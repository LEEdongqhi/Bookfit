import requests
from bs4 import BeautifulSoup
import pandas as pd
import os, re

#메인 페이지##########################################################################

def crawling(soup):

    book_name_ele = soup.select('dl.prod_info > dt > a')
    book_author_ele = soup.select('dl.prod_info > dd.txt_block > span:nth-child(1)')
    book_author2_ele = soup.select('dl.prod_info > dd.txt_block > span:nth-child(3)')
    book_price_ele = soup.select('dl.prod_info > dd.mt5 > p > span.txt_price >strong')
    book_sale_ele = soup.select('span.txt_price')


    book_n = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_name_ele)
    book_a = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_author_ele)
    book_a2 = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_author2_ele)
    book_p = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_price_ele)
    book_s = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text[10:]), book_sale_ele)

    return list(zip(book_n,book_a,book_a2,book_p,book_s))

def get_content():
    url= 'http://www.bandinlunis.com/front/display/listBest.do'
    result2 = []
    for i in range(0, 5):  # 0 - 1 , 1- 2
        req = requests.get(url, params={'page': 1 + i})
        content = req.content
        soup = BeautifulSoup(content, 'html.parser')
        result2 += crawling(soup)

    return result2

result = get_content()
print(result)

f = open("bandi_best.txt", 'wt', encoding='utf-8')
for book_index, item in enumerate(result):
    data = '{:2}위\t{}\t{}\t{}\t{}\t{}\n'.format(book_index+1, item[0],item[1],item[2],item[3],item[4])
    f.write(data)
f.close()

df = pd.read_csv('bandi_best.txt', sep="\t", encoding='utf-8')
df.to_excel('bandi_best.xlsx', index=False)
#df.head()
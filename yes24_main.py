import item as item
import requests
from bs4 import BeautifulSoup
import pandas as pd
from urllib.request import urlretrieve
import os, re

def crawling(soup):

    book_name_ele = soup.select('td.goodsTxtInfo > p:nth-child(1) > a:nth-child(1)')
    book_author_ele = soup.select('td.goodsTxtInfo >div.aupu > a:nth-child(1)')
    book_author2_ele = soup.select('td.goodsTxtInfo >div.aupu > a:nth-child(2)')
    book_price_ele = soup.select('td.goodsTxtInfo > p:nth-child(3) > span.priceB')
    book_sale_ele = soup.select('td.goodsTxtInfo > p:nth-child(3) > span:nth-child(2) ')
    book_n = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_name_ele)
    book_a = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_author_ele)
    book_a2 = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_author2_ele)
    book_p = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_price_ele)
    book_s = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_sale_ele)

    return list(zip(book_n,book_a,book_a2,book_p,book_s))


def get_content():
    url = 'http://www.yes24.com/24/Category/BestSeller'
    result2 = []
    for i in range(1, 3): #0 - 1 , 1- 2
        req = requests.get(url, params={'PageNumber': 1+i})
        content = req.content
        soup = BeautifulSoup(content, 'html.parser')
        result2 += crawling(soup)
    return result2
result = get_content()

url_main= 'http://www.yes24.com/24/Category/BestSeller'
req_main = requests.get(url_main)
content_main = req_main.content
soup2 = BeautifulSoup(content_main, 'html.parser')

book_name_ele = soup2.select('p:nth-child(3) > a')
book_author_ele = soup2.select('p:nth-child(4) > a:nth-child(1)')
book_author2_ele = soup2.select('p:nth-child(4) > a:nth-child(2)')
book_price_ele = soup2.select('p:nth-child(5) > strong')
book_sale_ele = soup2.select('p.price')

book_n = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_name_ele)
book_a = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_author_ele)
book_a2 = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_author2_ele)
book_p = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_price_ele)
book_s = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text)[7:15], book_sale_ele)

result_main=list(zip(book_n, book_a, book_a2, book_p,book_s))
result_main.extend(result)

f = open("yes24_best.txt", 'wt', encoding='utf-8')
for book_index, item in enumerate(result_main):
    data = '{:2}위\t{}\t{}\t{}\t{}\t{}\n'.format(book_index+1, item[0],item[1],item[2],item[3],item[4])
    f.write(data)
f.close()

df = pd.read_csv('yes24_best.txt', sep="\t", encoding='utf-8')
df.to_excel('yes24_best.xlsx', index=False)
#df.head()






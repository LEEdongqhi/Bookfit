import item as item
import requests
from bs4 import BeautifulSoup
import pandas as pd
from urllib.request import urlretrieve
import os, re


def get_content():
    url= 'https://books.11st.co.kr/booksmall/BooksAction.tmall?ID=BOOKS&ctgrNo=63548'
    req=requests.get(url)
    content = req.content

    soup = BeautifulSoup(content, 'html.parser')

    book_name_ele = soup.select('div.product_conts > div.pup_info > div.pup_title > a')
    book_author_ele = soup.select('div.product_conts > div.pup_info > div.seller_id > div > span:nth-child(1)')
    book_author2_ele = soup.select('div.product_conts > div.pup_info > div.seller_id > div > span:nth-child(2)')
    book_price_ele = soup.select('div.product_conts > div.pup_info > div.pub_priceW > strong')
    book_sale_ele = soup.select('div.product_conts > div.pup_info > div.pub_priceW > div.sale_per')

    book_n= map(lambda x: x.text[4:], book_name_ele)
    book_a = map(lambda x: x.text, book_author_ele)
    book_a2 = map(lambda x: x.text, book_author2_ele)
    book_p = map(lambda x:re.sub(r'[\s+\t\n]','',x.text), book_price_ele)
    book_s = map(lambda x: x.text[:3], book_sale_ele)

    return list(zip(book_n,book_a,book_a2,book_p,book_s))

result = get_content()

f = open("st11_best.txt", 'wt', encoding='utf-8')
for book_index, item in enumerate(result):
    data = '{:2}위\t{}\t{}\t{}\t{}\t{}\n'.format(book_index+1, item[0],item[1],item[2],item[3],item[4])
    f.write(data)
f.close()

df = pd.read_csv('st11_best.txt', sep="\t", encoding='utf-8')
#print(df)
df.to_excel('st11_best.xlsx', index=False)
#df.head()
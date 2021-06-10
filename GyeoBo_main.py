import time
import re, os
import pandas as pd
from selenium import webdriver

chrome = webdriver.Chrome('chromedriver')
chrome.get('http://www.kyobobook.co.kr/bestSellerNew/bestseller.laf')
result=[]

for n in range(0, 5):
##################################################
    time.sleep(1)
    # 컨테이너(가게 정보) 수
    stores = chrome.find_elements_by_css_selector("div.detail")
    for store in stores:
        # 세부 데이터 수집
        book_name = store.find_elements_by_css_selector("div.detail > div.title > a > strong")
        book_author = store.find_elements_by_css_selector('div.detail > div.author ')
        book_price = store.find_elements_by_css_selector("div.detail > div.price > strong")
        book_sale =  store.find_elements_by_css_selector("div.detail > div.price > span")

        book_n = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_name)
        book_a = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_author)
        book_p = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_price)
        book_s = map(lambda x: re.sub(r'[\s+\t\n]', '', x.text), book_sale)

        result += list(zip(book_n, book_a, book_p, book_s))

    page_bar = chrome.find_elements_by_xpath('//*[@id="main_contents"]/div[4]/div[1]/ul/li/a/..')
    ##################################################
    # page_bar의 인덱싱 부분을 다음페이지(n+1)로 바꿔줍니다.
    page_bar[n].click()
    ##################################################

f = open("kyobo_best.txt", 'wt', encoding='utf-8')
for book_index, item in enumerate(result):
    data = '{:2}위\t{}\t{}\t{}\t{}\n'.format(book_index+1, item[0],item[1],item[2],item[3])
    f.write(data)
f.close()

df = pd.read_csv('kyobo_best.txt', sep="\t", encoding='utf-8')
df.to_excel('kyobo_best.xlsx', index=False)
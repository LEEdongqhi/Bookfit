from pprint import pprint
from urllib.request import urlretrieve
import time
import re, os
from selenium import webdriver

chrome = webdriver.Chrome('chromedriver')
chrome.get('http://www.kyobobook.co.kr/bestSellerNew/bestseller.laf')
cover=[]
result=[]
for n in range(0, 5):
##################################################
    time.sleep(1)
    # 컨테이너(가게 정보) 수
    stores = chrome.find_elements_by_css_selector('div.cover > a:nth-child(1)> img')
        # 세부 데이터 수집
    for i in stores:
        book_cover = i.get_attribute('src')
        book_title = i.get_attribute('alt')

        cover.append(book_cover)
        result.append(book_title)
    page_bar = chrome.find_elements_by_xpath('//*[@id="main_contents"]/div[4]/div[1]/ul/li/a/..')
    page_bar[n].click()
#웹 페이지를 열고 소스코드를 읽어오는 작업

try:
    if not (os.path.isdir('image')):
        os.makedirs(os.path.join('image'))
except OSError as e:
    if e.errno != e.errno.EEXIST:
        print("폴더 생성 실패!")
        exit()

print(result)
count=1
for n in range(0,100):
   result[n] =re.sub('[^0-9a-zA-Zㄱ-힗]', '', result[n])
   urlretrieve(cover[n],'./image/'+'kyobo'+str(count)+'.jpg')
   count += 1


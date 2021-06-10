from bs4 import BeautifulSoup
from urllib.request import urlretrieve
import os
import requests, re

try:
    if not (os.path.isdir('image')):
        os.makedirs(os.path.join('image'))
except OSError as e:
    if e.errno != e.errno.EEXIST:
        print("폴더 생성 실패!")
        exit()

#웹 페이지를 열고 소스코드를 읽어오는 작업
html = requests.get('http://www.yes24.com/24/Category/BestSeller')
soup = BeautifulSoup(html.text, 'html.parser')
html.close()
html2 =  requests.get('http://www.yes24.com/24/category/bestseller?CategoryNumber=001&sumgb=06&fetchSize=40&PageNumber=2')
soup2 = BeautifulSoup(html2.text, 'html.parser')
html2.close()
html3 =  requests.get('http://www.yes24.com/24/category/bestseller?CategoryNumber=001&sumgb=06&fetchSize=40&PageNumber=3')
soup3 = BeautifulSoup(html3.text, 'html.parser')
html3.close()

# 영역 추출하기
data1_list = soup.findAll('p', {'class' : "image" })
data2_list = soup2.findAll('div', {'class' : "goodsImgW" })
data3_list = soup3.findAll('div', {'class' : "goodsImgW" })[:20]

# 전체 리스트
li_list = []
for data1 in data1_list:
    #제목+썸내일 영역 추출
    li_list.extend(data1.findAll('a'))
for data2 in data2_list:
    #제목+썸내일 영역 추출
    li_list.extend(data2.findAll('a'))
for data3 in data3_list:
    #제목+썸내일 영역 추출
    li_list.extend(data3.findAll('a'))

count = 1
for tr in li_list:
    img = tr.find('img')
    title = img['alt']
    img_src = img['src']
    if (title != '미리보기'):
        urlretrieve(img_src, './image/' + 'yes' + str(count) + '.jpg')
        count += 1

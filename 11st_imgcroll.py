from bs4 import BeautifulSoup
from urllib.request import urlretrieve
import os
import requests, re
from pprint import pprint


try:
    if not (os.path.isdir('image')):
        os.makedirs(os.path.join('image'))
except OSError as e:
    if e.errno != e.errno.EEXIST:
        print("폴더 생성 실패!")
        exit()

#웹 페이지를 열고 소스코드를 읽어오는 작업
html = requests.get('https://books.11st.co.kr/booksmall/BooksAction.tmall?ID=BOOKS&ctgrNo=63548')
soup = BeautifulSoup(html.text, 'html.parser')
html.close()


# 영역 추출하기
data1_list = soup.findAll('div',{'class':"pub_photo"})

# pprint(data1_list)
# 전체 리스트
li_list = []
for data1 in data1_list:
     #제목+썸내일 영역 추출
     li_list.extend(data1.findAll('a'))
# print('\n')
# pprint(li_list)

count = 1
for tr in data1_list:
    img = tr.find('img')
    title = img['alt']
    img_src = img['src']
    title = re.sub('[^0-9a-zA-Zㄱ-힗]', '', title)
    urlretrieve(img_src,'./image/'+'ele'+str(count)+'.jpg')
    count+=1
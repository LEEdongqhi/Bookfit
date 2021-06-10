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
def crawling_img(soup):
    result_img2 = []
    book_img = soup.select('div.prod_thumb_img > a:nth-child(1)')

    result_img2.extend(book_img)

    return result_img2


def get_content_img():
    url = 'http://www.bandinlunis.com/front/display/listBest.do'
    result3 = []
    for i in range(0, 5):  # 0 - 1 , 1- 2
        req = requests.get(url, params={'page': 1 + i})
        content = req.content
        soup = BeautifulSoup(content, 'html.parser')
        result3 += crawling_img(soup)

    return result3

result_img = get_content_img()

count = 1
for tr in result_img:
    img = tr.find('img')
    img_src = img['src']
    urlretrieve(img_src,'./image/'+'bandi'+str(count)+'.jpg')
    count += 1

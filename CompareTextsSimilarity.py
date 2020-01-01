import re
from flask import Flask, request, abort
from collections import Counter

app = Flask(__name__)


@app.route('/getSimilarity', methods=['POST'])
def getSimilarity():
    if not request.json or 'text1' not in request.json or 'text2' not in request.json:
        abort(400)
    text1, text2 = request.json['text1'], request.json['text2']
    stop_words = {'the', 'to', 'with', 'is', 'on', 'just', 'for', 'of', 'each', 'are', 'which', 'these', 'it', 'that'}
    words1 = [word.lower() for word in re.findall(r"[\w']+", text1) if word.lower() not in stop_words]
    words2 = [word.lower() for word in re.findall(r"[\w']+", text2) if word.lower() not in stop_words]
    word_count1, word_count2 = Counter(words1), Counter(words2)
    intersect, union = 0, 0
    for word in word_count1:
        intersect += min(word_count1[word], word_count2[word])
        union += max(word_count1[word], word_count2[word])
    return str(float(intersect) / union)


# text1 = "The easiest way to earn points with Fetch Rewards is to just shop for the products you already love. If you have any participating brands on your receipt, you'll get points based on the cost of the products. You don't need to clip any coupons or scan individual barcodes. Just scan each grocery receipt after you shop and we'll find the savings for you."
# text2 = "The easiest way to earn points with Fetch Rewards is to just shop for the items you already buy. If you have any eligible brands on your receipt, you will get points based on the total cost of the products. You do not need to cut out any coupons or scan individual UPCs. Just scan your receipt after you check out and we will find the savings for you."
# text3 = "We are always looking for opportunities for you to earn more points, which is why we also give you a selection of Special Offers. These Special Offers are opportunities to earn bonus points on top of the regular points you earn every time you purchase a participating brand. No need to pre-select these offers, we'll give you the points whether or not you knew about the offer. We just think it is easier that way."
# print getSimilarity(text1, text2)
# print getSimilarity(text2, text3)
if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')

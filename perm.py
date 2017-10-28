r= int(raw_input())
def solution(N):
	count = 0
	s = set([])
	def permutation(l, r=''):
    		if len(l) == 0: s.add(r)
    		else:
        		for i in range(len(l)):
            			permutation(l[0:i] + l[i+1:], r+l[i])
	permutation(str(N), '')
	for i in s:
		if len(str(int(i))) == len(i): count+=1
	return count
print solution(r)

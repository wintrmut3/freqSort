#python text processor
f = open ('text.txt', 'r', encoding = 'utf8')
redact = open('redact.txt', 'r', encoding = 'utf8')
o = open ('processed.txt', 'w', encoding = 'utf8')
text = f.read()
smush = redact.read().split(" ")

#smush = ['0','1','2','3','4','5','6','7','8','9',',','.','/','-', '(', ')', '[', ']', '?', '!', '#', " »", "« ","»", "«", ":", ";","–", "•", "*", " –  – ", "–"]
textZ = text.split(" ")# word lv filter
for i in range (len(textZ)):
	for j in range (len(smush)):
		if (textZ[i] == smush [j]):
			textZ[i] = ""
text = ' '.join(textZ)
textA = list(text);

for i in range (len(textA)):
	if (textA[i] == '\t' or textA[i] == '\n'):
		textA[i] = " "

	for j in range (len(smush)):
		if (textA[i] == smush [j]):
			textA[i] = ""
			
for i in range (len(textA)):
	o.write(textA[i].lower())


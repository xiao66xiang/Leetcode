class SpreadSheet(object):
    def __init__(self, row, col):
        self.row = row
        self.col = col
        self.contents = [['' for i in range(col)] for j in range(row)]

    def update(self, row_id, col_id, content):
        self.contents[row_id-1][col_id-1] = content

    def print_sheet(self):
        for row in self.contents:
            print '|'.join(map(str, row))

    def pretty_print(self):
        column_width = [0] * self.col
        for row in self.contents:
            for index, content in enumerate(row):
                column_width[index] = max(column_width[index], len(str(content)))
        for row in self.contents:
            print '|'.join([str(x) + ' '*(column_width[i]-len(str(x))) for i, x in enumerate(row)])

    def evaluate_sum(self, str):
        start, end = str[5:-1].split('-')
        row1, col1 = map(int, start.split(':'))
        row2, col2 = map(int, end.split(':'))
        sum = 0
        for row in self.contents[row1-1: row2]:
            for cell in row[col1-1: col2]:
                if isinstance(cell, int):
                    sum += cell
        return sum



sheet = SpreadSheet(4, 3)
sheet.update(1,1,1)
sheet.update(1,2,10)
sheet.update(1,3,'foo')
sheet.update(2,1,'alice')
sheet.update(2,2,5)
print sheet.evaluate_sum("=sum(1:1-3:2)")
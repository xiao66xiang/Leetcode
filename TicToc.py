class TicTocBoard(object):
    def __init__(self):
        self.board = [['-' for _ in range(3)] for _ in range(3)]

    def put(self, token, row_id, col_id):
        try:
            row_id = int(row_id)
            col_id = int(col_id)
        except:
            return False
        if row_id < 0 or row_id >= 3 or col_id < 0 or col_id >= 3 or self.board[row_id][col_id] != '-':
            return False
        self.board[row_id][col_id] = token
        return True

    def print_board(self):
        for row in self.board:
            print '|'.join(row)

    def check_full(self):
        for row in self.board:
            for cell in row:
                if cell == '-':
                    return False
        return True

    def move_AI(self):
        if self.check_full():
            raise Exception("The board is full!")
        put = False
        for row_id in range(3):
            for col_id in range(3):
                if self.board[row_id][col_id] == '-':
                    self.board[row_id][col_id] = 'O'
                    put = True
                    break
            if put:
                break

    def check_win(self):
        for row in self.board:
            if row[0] == row[1] and row[1] == row[2] and row[0] != '-':
                return row[0]
        for col in range(3):
            if self.board[0][col] == self.board[1][col] and \
                    self.board[1][col] == self.board[2][col] and self.board[1][col] != '-':
                return self.board[1][col] != '-'
        for 


tic_toc_board = TicTocBoard()
while True:
    row_id = raw_input("Row id: ")
    col_id = raw_input("Col id: ")
    success = tic_toc_board.put('X', row_id, col_id)
    while not success:
        print "Please try again!"
        row_id = raw_input("Row id: ")
        col_id = raw_input("Col id: ")
        success = tic_toc_board.put('X', row_id, col_id)
    if tic_toc_board.check_full():
        break
    tic_toc_board.move_AI()
    tic_toc_board.print_board()
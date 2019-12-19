def get_unique_email_number(emails):
    unique_email_set = set()
    for email in emails:
        username, suffix = email.split("@")
        username = username.replace(".", "")
        plus_location = username.find("+")
        if plus_location != -1:
            username = username[:plus_location]
        unique_email_set.add(username+"@"+suffix)
    return len(unique_email_set)


if __name__ == '__main__':
    print get_unique_email_number(["test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com"])
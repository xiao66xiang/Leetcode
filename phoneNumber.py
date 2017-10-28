
import math
from collections import defaultdict


def rule_1_2(duration):
    if duration < 300:
        # rule 1
        return 3 * duration
    else:
        # rule 2
        return math.ceil(float(duration) / 60)*150


def ts_to_duration(ts):
    hrs, mins, seds = tuple([int(i) for i in ts.split(":")])
    return hrs * 3600 + mins * 60 + seds


def solution(S):
    recs = defaultdict(list)
    costs = defaultdict(int)
    number_with_longest_duration = "999-999-999"
    longest_duration = 0
    for rec in S.split("\n"):
        if rec == "":
            return 0
        ts, phone_number = tuple(rec.split(","))
        recs[phone_number].append(ts_to_duration(ts))
    total_cost = 0
    for phone_number in recs:
        cur_total_duration = 0
        cur_cost = 0
        for ts in recs[phone_number]:
            cur_total_duration += ts
            cur_cost += rule_1_2(ts)
        costs[phone_number] = cur_cost
        total_cost += cur_cost
        if cur_total_duration > longest_duration:
            longest_duration = cur_total_duration
            number_with_longest_duration = phone_number
        elif cur_total_duration == longest_duration and phone_number < number_with_longest_duration:
            number_with_longest_duration = phone_number
    if number_with_longest_duration in costs:
        total_cost -= costs[number_with_longest_duration]
    return total_cost


a = "00:01:59,400-234-040\n00:01:59,400-234-040\n00:01:59,400-234-040\n00:01:59,400-234-040\n00:05:01,701-080-080\n00:00:00,400-234-090"
print solution(a)


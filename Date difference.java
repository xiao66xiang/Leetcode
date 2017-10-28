
date{
   long year,
   int month,
   int day,
}

long getDifference (date d1, date d2) {
    if(d1.year>d2.year || d1.year==d2.year && d1.month>d2.month|| d1.year==d2.year&&d1.month==d2.month&&d1.day>d2.day) {
        date tmp = d1;
        d1 = d2;
        d2 = temp;
    }
    long res = 0;
    res+=(d2.year-d1.year)*365 + getRui(d2.year-1)-getRui(d1.year-1); //?  
    return res+getDay(d2)-getDay(d1);
    
}
long getDay(date d) {
    long total = 0;
    int [] monthday = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for (int i=1; i<d.month; i++) { 
        total+=monthday[i-1];
    }
    if (isRui(d.year)&&(d.month>2)) { //?
        total+=1;
    }
    total+=d.day;
    return total;
}
boolean isRui(long year) {
    if(year%4==0 && year%100!=0|| year%400==0) {
        return true;
    }
    else return false;
}
long getRui(long year) {
    long res = 0;
    res+=year/400;
    res+=year/4;
    res-=year/100;
    return res;
}

# date_class_java

First we see class Date with already written data such as length of months and names of months
with special "" empty string in month and 0 in month days for easier orientation (0 index begining)
Second we see Constructor with isValid method used in it and we give each argument the value that we have.
like: this.day = day (argument of constructor).


Third we see methods of date class:
1)isValidDate(cleverly checks everything in date like february leap year thing and max of days)
2)isLeapYear(checks if it is a leap year if divisible by 4 and not 100 or by 400 without reminder)
3)updateDate(validates input then changes date)
4)getDayOfWeek(i used special class Calender for that which takes date and gives number of day of the week then we use list for word)
5)calculateDifference(takes difference of dates in milliseconds and converts back after calculated)
6)printDate(just prints date but instead of number of month it prints word frol list of months)
7)compareDate(first compares by year then by month then by day)

In main we can see some samples and method checking: printing, validating, updating, comparing

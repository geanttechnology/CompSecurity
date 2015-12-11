// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSAObj

public class SSAEventCalendar extends SSAObj
{

    private String DAILY;
    private String DAYS_IN_MONTH;
    private String DAYS_IN_WEEK;
    private String DAYS_IN_YEAR;
    private String DESCRIPTION;
    private String END;
    private String EXCEPTIONDATES;
    private String EXPIRES;
    private String FREQUENCY;
    private String ID;
    private String INTERVAL;
    private String MONTHLY;
    private String MONTHS_IN_YEAR;
    private String RECURRENCE;
    private String REMINDER;
    private String START;
    private String STATUS;
    private String WEEKLY;
    private String WEEKS_IN_MONTH;
    private String YEARLY;
    private String mDescription;
    private String mEnd;
    private String mStart;

    public SSAEventCalendar(String s)
    {
        super(s);
        ID = "id";
        DESCRIPTION = "description";
        START = "start";
        END = "end";
        STATUS = "status";
        RECURRENCE = "recurrence";
        REMINDER = "reminder";
        FREQUENCY = "frequency";
        INTERVAL = "interval";
        EXPIRES = "expires";
        EXCEPTIONDATES = "exceptionDates";
        DAYS_IN_WEEK = "daysInWeek";
        DAYS_IN_MONTH = "daysInMonth";
        DAYS_IN_YEAR = "daysInYear";
        WEEKS_IN_MONTH = "weeksInMonth";
        MONTHS_IN_YEAR = "monthsInYear";
        DAILY = "daily";
        WEEKLY = "weekly";
        MONTHLY = "monthly";
        YEARLY = "yearly";
        if (containsKey(DESCRIPTION))
        {
            setDescription(getString(DESCRIPTION));
        }
        if (containsKey(START))
        {
            setStart(getString(START));
        }
        if (containsKey(END))
        {
            setEnd(getString(END));
        }
    }

    public String getDescription()
    {
        return mDescription;
    }

    public String getEnd()
    {
        return mEnd;
    }

    public String getStart()
    {
        return mStart;
    }

    public void setDescription(String s)
    {
        mDescription = s;
    }

    public void setEnd(String s)
    {
        mEnd = s;
    }

    public void setStart(String s)
    {
        mStart = s;
    }
}

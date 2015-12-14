// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;


public class Period
    implements Comparable
{

    private long numberOfIntervals;
    private String timeInterval;

    public Period()
    {
    }

    public int compareTo(Period period)
    {
        if (period != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (period == this)
        {
            return 0;
        }
        s = getTimeInterval();
        s1 = period.getTimeInterval();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        if (getNumberOfIntervals() < period.getNumberOfIntervals())
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s.equals(s1))
        {
            int j = s.hashCode();
            int l = s1.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        return getNumberOfIntervals() <= period.getNumberOfIntervals() ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Period)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof Period)
            {
                if (compareTo((Period)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public long getNumberOfIntervals()
    {
        return numberOfIntervals;
    }

    public String getTimeInterval()
    {
        return timeInterval;
    }

    public int hashCode()
    {
        int i;
        if (getTimeInterval() == null)
        {
            i = 0;
        } else
        {
            i = getTimeInterval().hashCode();
        }
        return 1 + i + (int)getNumberOfIntervals();
    }

    public void setNumberOfIntervals(long l)
    {
        numberOfIntervals = l;
    }

    public void setTimeInterval(String s)
    {
        timeInterval = s;
    }
}

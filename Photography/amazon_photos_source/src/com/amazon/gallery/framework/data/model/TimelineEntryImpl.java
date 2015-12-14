// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import com.amazon.gallery.framework.model.TimelineEntry;

public class TimelineEntryImpl
    implements TimelineEntry
{

    private final int count;
    private final int month;
    private final int year;

    public TimelineEntryImpl(int i)
    {
        count = i;
        year = 0;
        month = 0;
    }

    public TimelineEntryImpl(int i, int j, int k)
    {
        year = i;
        month = j;
        count = k;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (TimelineEntryImpl)obj;
            if (count != ((TimelineEntryImpl) (obj)).count)
            {
                return false;
            }
            if (month != ((TimelineEntryImpl) (obj)).month)
            {
                return false;
            }
            if (year != ((TimelineEntryImpl) (obj)).year)
            {
                return false;
            }
        }
        return true;
    }

    public int getCount()
    {
        return count;
    }

    public int getId()
    {
        if (isNoDate())
        {
            return 0;
        } else
        {
            return getYear() * 12 + getMonth() + 1;
        }
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public int hashCode()
    {
        return (year * 31 + month) * 31 + count;
    }

    public boolean isNoDate()
    {
        return year == 0 && month == 0;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.search.data.FacetValue;
import com.groupon.models.search.domain.FilterValue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeSearchHelper
{

    public static final int RESERVABLE_DATES_COUNT = 31;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public DateTimeSearchHelper()
    {
    }

    public static FacetValue getBookableBufferFilter(int i, int j, int k)
    {
        Object obj = new StringBuffer();
        if (i != 0 || j != 0 || k != 0)
        {
            ((StringBuffer) (obj)).append("P");
        }
        if (i > 0)
        {
            ((StringBuffer) (obj)).append(String.format("%dD", new Object[] {
                Integer.valueOf(i)
            }));
        }
        if (j > 0 || k > 0)
        {
            ((StringBuffer) (obj)).append("T");
        }
        if (j > 0)
        {
            ((StringBuffer) (obj)).append(String.format("%dH", new Object[] {
                Integer.valueOf(j)
            }));
        }
        if (k > 0)
        {
            ((StringBuffer) (obj)).append(String.format("%dM", new Object[] {
                Integer.valueOf(i)
            }));
        }
        obj = new FilterValue("buffer", ((StringBuffer) (obj)).toString());
        FacetValue facetvalue = new FacetValue();
        facetvalue.id = ((FilterValue) (obj)).asUrlParam();
        return facetvalue;
    }

    public static FacetValue getBookableDayFilter(Date date)
    {
        date = new FilterValue("bookable", getDateRange(date, date));
        FacetValue facetvalue = new FacetValue();
        facetvalue.id = date.asUrlParam();
        return facetvalue;
    }

    public static FacetValue getBookableTimeFilter(Date date)
    {
        date = new FilterValue("time", getTimeRange(date, date));
        FacetValue facetvalue = new FacetValue();
        facetvalue.id = date.asUrlParam();
        return facetvalue;
    }

    public static String getDateRange(Date date, Date date1)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        date = dateFormat.format(calendar.getTime());
        calendar.setTime(date1);
        return String.format("[%s..%s]", new Object[] {
            date, dateFormat.format(calendar.getTime())
        });
    }

    public static FacetValue getPartySizeFilter(int i)
    {
        FacetValue facetvalue = new FacetValue();
        facetvalue.id = String.format(Locale.US, "%s:%d", new Object[] {
            "partySize", Integer.valueOf(i)
        });
        return facetvalue;
    }

    public static String getTimeRange(Date date, Date date1)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        date = timeFormat.format(calendar.getTime());
        calendar.setTime(date1);
        return String.format("[%s..%s]", new Object[] {
            date, timeFormat.format(calendar.getTime())
        });
    }

}

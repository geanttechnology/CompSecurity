// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import com.groupon.models.hotel.Destination;
import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchViewPresenter

static class shouldRedoLastSearch
    implements Serializable
{

    private Date checkInDate;
    private Date checkOutDate;
    private Destination destination;
    private Type lastSearchType;
    private String query;
    private boolean shouldRedoLastSearch;



/*
    static Date access$002(Type type, Date date)
    {
        type.checkInDate = date;
        return date;
    }

*/



/*
    static Date access$102(checkInDate checkindate, Date date)
    {
        checkindate.checkOutDate = date;
        return date;
    }

*/



/*
    static String access$202(checkOutDate checkoutdate, String s)
    {
        checkoutdate.query = s;
        return s;
    }

*/



/*
    static Destination access$302(query query1, Destination destination1)
    {
        query1.destination = destination1;
        return destination1;
    }

*/



/*
    static Type access$402(Type type, Type type1)
    {
        type.lastSearchType = type1;
        return type1;
    }

*/



/*
    static boolean access$502(lastSearchType lastsearchtype, boolean flag)
    {
        lastsearchtype.shouldRedoLastSearch = flag;
        return flag;
    }

*/

    shouldRedoLastSearch()
    {
    }
}

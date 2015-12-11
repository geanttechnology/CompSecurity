// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.target.mothership.services.aa;
import com.target.ui.model.BlackFridayDealDetails;
import com.target.ui.model.MapDisplayableItem;
import com.target.ui.model.pi_blackfriday_deals.PiBlackFridayDeal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r
    implements aa
{

    public r()
    {
    }

    public MapDisplayableItem a(PiBlackFridayDeal piblackfridaydeal)
    {
        MapDisplayableItem mapdisplayableitem = new MapDisplayableItem();
        mapdisplayableitem.a(piblackfridaydeal.b());
        mapdisplayableitem.a(piblackfridaydeal.e());
        BlackFridayDealDetails blackfridaydealdetails = new BlackFridayDealDetails();
        blackfridaydealdetails.a(piblackfridaydeal.c());
        blackfridaydealdetails.b(piblackfridaydeal.a());
        blackfridaydealdetails.a(piblackfridaydeal.f());
        mapdisplayableitem.a(blackfridaydealdetails);
        return mapdisplayableitem;
    }

    public volatile Object a(Object obj)
    {
        return a((List)obj);
    }

    public List a(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); arraylist.add(a((PiBlackFridayDeal)list.next()))) { }
        return arraylist;
    }
}

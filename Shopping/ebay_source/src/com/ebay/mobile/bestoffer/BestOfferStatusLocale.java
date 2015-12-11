// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;

public class BestOfferStatusLocale
{

    private static final HashMap status;

    public BestOfferStatusLocale()
    {
    }

    public static String getCaption(Context context, String s)
    {
        Integer integer = (Integer)status.get(s);
        if (integer == null)
        {
            Log.e(com/ebay/mobile/bestoffer/BestOfferStatusLocale.getSimpleName(), (new StringBuilder()).append("No caption for best offer status: ").append(s).toString());
            return s;
        } else
        {
            return context.getString(integer.intValue());
        }
    }

    static 
    {
        status = new HashMap();
        status.put("Accepted", Integer.valueOf(0x7f070728));
        status.put("Active", Integer.valueOf(0x7f070729));
        status.put("AdminEnded", Integer.valueOf(0x7f07072a));
        status.put("All", Integer.valueOf(0x7f07072b));
        status.put("Countered", Integer.valueOf(0x7f07072c));
        status.put("Declined", Integer.valueOf(0x7f07072d));
        status.put("Expired", Integer.valueOf(0x7f07072e));
        status.put("Pending", Integer.valueOf(0x7f07072f));
        status.put("Retracted", Integer.valueOf(0x7f070730));
    }
}

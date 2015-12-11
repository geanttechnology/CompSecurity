// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            SymbanNotification

public static final class A extends Enum
{

    private static final UPDATE_YOUR_INFO $VALUES[];
    public static final UPDATE_YOUR_INFO BUY_NOW;
    public static final UPDATE_YOUR_INFO PAY_NOW;
    public static final UPDATE_YOUR_INFO PLACE_BID;
    public static final UPDATE_YOUR_INFO RAISE_BID;
    public static final UPDATE_YOUR_INFO REVIEW_OFFER;
    public static final UPDATE_YOUR_INFO SHIP_ITEM;
    public static final UPDATE_YOUR_INFO UPDATE_YOUR_INFO;
    public static final UPDATE_YOUR_INFO VIEW_ITEM;
    public static final UPDATE_YOUR_INFO VIEW_MESSAGE;
    public static final UPDATE_YOUR_INFO VIEW_ORDER;

    public static A factory(String s)
    {
        A aa[] = values();
        int j = aa.length;
        for (int i = 0; i < j; i++)
        {
            A a = aa[i];
            if (TextUtils.equals(a.name(), s))
            {
                return a;
            }
        }

        return null;
    }

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$ActionEnum, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        BUY_NOW = new <init>("BUY_NOW", 0);
        PAY_NOW = new <init>("PAY_NOW", 1);
        PLACE_BID = new <init>("PLACE_BID", 2);
        RAISE_BID = new <init>("RAISE_BID", 3);
        REVIEW_OFFER = new <init>("REVIEW_OFFER", 4);
        SHIP_ITEM = new <init>("SHIP_ITEM", 5);
        VIEW_ITEM = new <init>("VIEW_ITEM", 6);
        VIEW_ORDER = new <init>("VIEW_ORDER", 7);
        VIEW_MESSAGE = new <init>("VIEW_MESSAGE", 8);
        UPDATE_YOUR_INFO = new <init>("UPDATE_YOUR_INFO", 9);
        $VALUES = (new .VALUES[] {
            BUY_NOW, PAY_NOW, PLACE_BID, RAISE_BID, REVIEW_OFFER, SHIP_ITEM, VIEW_ITEM, VIEW_ORDER, VIEW_MESSAGE, UPDATE_YOUR_INFO
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}

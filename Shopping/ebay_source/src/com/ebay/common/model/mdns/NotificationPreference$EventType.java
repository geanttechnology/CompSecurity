// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;

import java.util.ArrayList;

// Referenced classes of package com.ebay.common.model.mdns:
//            NotificationPreference

public static final class deliveryPolicyType extends Enum
{

    private static final CARTONSALE $VALUES[];
    public static final CARTONSALE ADDPHOTO;
    public static final CARTONSALE BESTOFR;
    public static final CARTONSALE BIDITEM;
    public static final CARTONSALE BIDRCVD;
    public static final CARTONSALE BOACCPTD;
    public static final CARTONSALE BODECLND;
    public static final CARTONSALE BUCKSEXP;
    public static final CARTONSALE BYRNOSHW;
    public static final CARTONSALE CARTONSALE;
    public static final CARTONSALE CNTROFFR;
    public static final CARTONSALE COACCPTED;
    public static final CARTONSALE COCMPLT;
    public static final CARTONSALE CODECLND;
    public static final CARTONSALE COUPONAVLBL;
    public static final CARTONSALE DailyDeals;
    public static final CARTONSALE DealsFrenzy;
    public static final CARTONSALE EBNORDCNCL;
    public static final CARTONSALE EBNORDPICKED;
    public static final CARTONSALE INTERNAL_BADGE;
    public static final CARTONSALE ITMOUTSTK;
    public static final CARTONSALE ITMPAID;
    public static final CARTONSALE ITMPICKUP;
    public static final CARTONSALE ITMSHPD;
    public static final CARTONSALE ITMSOLD;
    public static final CARTONSALE ITMWON;
    public static final CARTONSALE MSGEBAYMSGHDR;
    public static final CARTONSALE MSGM2MMSGHDR;
    public static final CARTONSALE OFRDCLNDACPT;
    public static final CARTONSALE OFREXPIRED;
    public static final CARTONSALE OFRRETRACTED;
    public static final CARTONSALE OUTBID;
    public static final CARTONSALE PAYREM;
    public static final CARTONSALE PING;
    public static final CARTONSALE SHOPCARTITM;
    public static final CARTONSALE SVDSRCH;
    public static final CARTONSALE WATCHITM;
    public static final CARTONSALE WATCHONSALE;
    public final boolean defaultValue;
    public final licyType deliveryPolicyType;
    public final int id;
    public final boolean supported;
    public final boolean uiVisible;

    public static deliveryPolicyType valueOf(String s)
    {
        return (deliveryPolicyType)Enum.valueOf(com/ebay/common/model/mdns/NotificationPreference$EventType, s);
    }

    public static deliveryPolicyType[] values()
    {
        return (deliveryPolicyType[])$VALUES.clone();
    }

    public boolean isUiVisible()
    {
        return uiVisible;
    }

    static 
    {
        OUTBID = new <init>("OUTBID", 0, 0, true, true);
        WATCHITM = new <init>("WATCHITM", 1, 1, true, true);
        SVDSRCH = new <init>("SVDSRCH", 2, 2, true, true, false);
        BESTOFR = new <init>("BESTOFR", 3, 3, true, true);
        BODECLND = new <init>("BODECLND", 4, 4, true, true);
        CNTROFFR = new <init>("CNTROFFR", 5, 5, true, true);
        ITMWON = new <init>("ITMWON", 6, 6, true, true);
        ITMSOLD = new <init>("ITMSOLD", 7, 7, true, true);
        ITMPAID = new <init>("ITMPAID", 8, 8, true, true);
        ITMSHPD = new <init>("ITMSHPD", 9, 9, true, true);
        BIDRCVD = new <init>("BIDRCVD", 10, 10, true, true);
        MSGEBAYMSGHDR = new <init>("MSGEBAYMSGHDR", 11, 11, false, false);
        MSGM2MMSGHDR = new <init>("MSGM2MMSGHDR", 12, 12, true, true);
        COCMPLT = new <init>("COCMPLT", 13, 13, true, true);
        BIDITEM = new <init>("BIDITEM", 14, 17, true, true);
        COUPONAVLBL = new <init>("COUPONAVLBL", 15, 18, true, true);
        ADDPHOTO = new <init>("ADDPHOTO", 16, 19, true, true, false);
        BUCKSEXP = new <init>("BUCKSEXP", 17, 20, true, true);
        SHOPCARTITM = new <init>("SHOPCARTITM", 18, 35, true, true, false);
        DailyDeals = new <init>("DailyDeals", 19, 36, true, false, true);
        DealsFrenzy = new <init>("DealsFrenzy", 20, 37, true, false, true);
        ITMPICKUP = new <init>("ITMPICKUP", 21, 21, true, true, false);
        ITMOUTSTK = new <init>("ITMOUTSTK", 22, 22, true, true, false);
        BYRNOSHW = new <init>("BYRNOSHW", 23, 23, true, true, false);
        PAYREM = new <init>("PAYREM", 24, 24, true, true, false);
        EBNORDPICKED = new <init>("EBNORDPICKED", 25, 25, true, true, false);
        EBNORDCNCL = new <init>("EBNORDCNCL", 26, 26, true, true, false);
        PING = new <init>("PING", 27, 27, false, true, false);
        INTERNAL_BADGE = new <init>("INTERNAL_BADGE", 28, 28, true, true, false, licyType.REAL_TIME);
        BOACCPTD = new <init>("BOACCPTD", 29, 29, false, false, false);
        COACCPTED = new <init>("COACCPTED", 30, 30, false, false, false);
        CODECLND = new <init>("CODECLND", 31, 31, false, false, false);
        OFRDCLNDACPT = new <init>("OFRDCLNDACPT", 32, 32, false, false, false);
        OFREXPIRED = new <init>("OFREXPIRED", 33, 33, false, false, false);
        OFRRETRACTED = new <init>("OFRRETRACTED", 34, 34, false, false, false);
        WATCHONSALE = new <init>("WATCHONSALE", 35, 38, true, true, true);
        CARTONSALE = new <init>("CARTONSALE", 36, 39, true, true, true);
        $VALUES = (new .VALUES[] {
            OUTBID, WATCHITM, SVDSRCH, BESTOFR, BODECLND, CNTROFFR, ITMWON, ITMSOLD, ITMPAID, ITMSHPD, 
            BIDRCVD, MSGEBAYMSGHDR, MSGM2MMSGHDR, COCMPLT, BIDITEM, COUPONAVLBL, ADDPHOTO, BUCKSEXP, SHOPCARTITM, DailyDeals, 
            DealsFrenzy, ITMPICKUP, ITMOUTSTK, BYRNOSHW, PAYREM, EBNORDPICKED, EBNORDCNCL, PING, INTERNAL_BADGE, BOACCPTD, 
            COACCPTED, CODECLND, OFRDCLNDACPT, OFREXPIRED, OFRRETRACTED, WATCHONSALE, CARTONSALE
        });
    }

    private licyType(String s, int i, int j, boolean flag, boolean flag1)
    {
        this(s, i, j, flag, flag1, true, null);
    }

    private licyType(String s, int i, int j, boolean flag, boolean flag1, boolean flag2)
    {
        this(s, i, j, flag, flag1, flag2, null);
    }

    private licyType(String s, int i, int j, boolean flag, boolean flag1, boolean flag2, licyType licytype)
    {
        super(s, i);
        id = j;
        supported = flag;
        defaultValue = flag1;
        if (flag)
        {
            NotificationPreference.supportedPushEventNames.add(name());
        }
        uiVisible = flag2;
        deliveryPolicyType = licytype;
    }
}

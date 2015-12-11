// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            SymbanNotification

public static final class  extends Enum
{

    private static final UCI $VALUES[];
    public static final UCI BESTOFR;
    public static final UCI BIDITEM;
    public static final UCI BOACCPTD;
    public static final UCI BODECLND;
    public static final UCI CNTROFFR;
    public static final UCI COACCPTED;
    public static final UCI COCMPLT;
    public static final UCI CODECLND;
    public static final UCI ITMSHPD;
    public static final UCI ITMSOLD;
    public static final UCI ITMWON;
    public static final UCI MSGM2MMSGHDR;
    public static final UCI OFRDCLNDACPT;
    public static final UCI OFREXPIRED;
    public static final UCI OFRRETRACTED;
    public static final UCI OUTBID;
    public static final UCI SHOPCARTITM;
    public static final UCI UCI;
    public static final UCI WATCHITM;

    public static  factory(String s)
    {
         a[] = values();
        int j = a.length;
        for (int i = 0; i < j; i++)
        {
              = a[i];
            if (TextUtils.equals(.name(), s))
            {
                return ;
            }
        }

        return null;
    }

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$MdnsNameEnum, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        OUTBID = new <init>("OUTBID", 0);
        BIDITEM = new <init>("BIDITEM", 1);
        WATCHITM = new <init>("WATCHITM", 2);
        SHOPCARTITM = new <init>("SHOPCARTITM", 3);
        ITMWON = new <init>("ITMWON", 4);
        ITMSOLD = new <init>("ITMSOLD", 5);
        COCMPLT = new <init>("COCMPLT", 6);
        ITMSHPD = new <init>("ITMSHPD", 7);
        BESTOFR = new <init>("BESTOFR", 8);
        BODECLND = new <init>("BODECLND", 9);
        CNTROFFR = new <init>("CNTROFFR", 10);
        BOACCPTD = new <init>("BOACCPTD", 11);
        OFREXPIRED = new <init>("OFREXPIRED", 12);
        MSGM2MMSGHDR = new <init>("MSGM2MMSGHDR", 13);
        OFRRETRACTED = new <init>("OFRRETRACTED", 14);
        COACCPTED = new <init>("COACCPTED", 15);
        CODECLND = new <init>("CODECLND", 16);
        OFRDCLNDACPT = new <init>("OFRDCLNDACPT", 17);
        UCI = new <init>("UCI", 18);
        $VALUES = (new .VALUES[] {
            OUTBID, BIDITEM, WATCHITM, SHOPCARTITM, ITMWON, ITMSOLD, COCMPLT, ITMSHPD, BESTOFR, BODECLND, 
            CNTROFFR, BOACCPTD, OFREXPIRED, MSGM2MMSGHDR, OFRRETRACTED, COACCPTED, CODECLND, OFRDCLNDACPT, UCI
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

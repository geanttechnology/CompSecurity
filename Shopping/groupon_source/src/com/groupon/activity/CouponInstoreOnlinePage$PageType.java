// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            CouponInstoreOnlinePage

public static final class  extends Enum
{

    private static final ONLINE $VALUES[];
    public static final ONLINE INSTORE;
    public static final ONLINE ONLINE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/activity/CouponInstoreOnlinePage$PageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INSTORE = new <init>("INSTORE", 0);
        ONLINE = new <init>("ONLINE", 1);
        $VALUES = (new .VALUES[] {
            INSTORE, ONLINE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

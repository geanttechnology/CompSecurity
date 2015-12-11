// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            StartupMetricsObserver

public static final class  extends Enum
{

    private static final PUBLIC_URL_FIRST_START $VALUES[];
    public static final PUBLIC_URL_FIRST_START PUBLIC_URL_FIRST_START;
    public static final PUBLIC_URL_FIRST_START PUBLIC_URL_START;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/net/StartupMetricsObserver$StartupType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PUBLIC_URL_START = new <init>("PUBLIC_URL_START", 0);
        PUBLIC_URL_FIRST_START = new <init>("PUBLIC_URL_FIRST_START", 1);
        $VALUES = (new .VALUES[] {
            PUBLIC_URL_START, PUBLIC_URL_FIRST_START
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

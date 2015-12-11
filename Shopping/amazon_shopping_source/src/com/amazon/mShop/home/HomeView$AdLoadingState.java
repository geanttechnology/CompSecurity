// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;


// Referenced classes of package com.amazon.mShop.home:
//            HomeView

private static final class  extends Enum
{

    private static final FAILURE $VALUES[];
    public static final FAILURE FAILURE;
    public static final FAILURE INIT;
    public static final FAILURE LOADING;
    public static final FAILURE SUCCESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/home/HomeView$AdLoadingState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INIT = new <init>("INIT", 0);
        LOADING = new <init>("LOADING", 1);
        SUCCESS = new <init>("SUCCESS", 2);
        FAILURE = new <init>("FAILURE", 3);
        $VALUES = (new .VALUES[] {
            INIT, LOADING, SUCCESS, FAILURE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

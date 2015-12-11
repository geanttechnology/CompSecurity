// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;


// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

private static final class  extends Enum
{

    private static final STATE_ERROR $VALUES[];
    public static final STATE_ERROR STATE_ERROR;
    public static final STATE_ERROR STATE_LOADED;
    public static final STATE_ERROR STATE_LOADING;
    public static final STATE_ERROR STATE_SIGNIN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/home/StartFragment$ChannelState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STATE_LOADING = new <init>("STATE_LOADING", 0);
        STATE_SIGNIN = new <init>("STATE_SIGNIN", 1);
        STATE_LOADED = new <init>("STATE_LOADED", 2);
        STATE_ERROR = new <init>("STATE_ERROR", 3);
        $VALUES = (new .VALUES[] {
            STATE_LOADING, STATE_SIGNIN, STATE_LOADED, STATE_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

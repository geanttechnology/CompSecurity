// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionHTTPSProxy_local $VALUES[];
    public static final TPOptionHTTPSProxy_local TPOptionHTTPSProxy_local;
    public static final TPOptionHTTPSProxy_local TPOptionHTTPSProxy_remote;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionHTTPSProxy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionHTTPSProxy_remote = new <init>("TPOptionHTTPSProxy_remote", 0);
        TPOptionHTTPSProxy_local = new <init>("TPOptionHTTPSProxy_local", 1);
        $VALUES = (new .VALUES[] {
            TPOptionHTTPSProxy_remote, TPOptionHTTPSProxy_local
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

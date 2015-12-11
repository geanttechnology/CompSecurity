// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;


// Referenced classes of package com.amazon.identity.auth.device.framework:
//            WrappableHttpURLConnection

private static final class  extends Enum
{

    private static final Connected $VALUES[];
    public static final Connected Connected;
    public static final Connected Connecting;
    public static final Connected Initial;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Initial = new <init>("Initial", 0);
        Connecting = new <init>("Connecting", 1);
        Connected = new <init>("Connected", 2);
        $VALUES = (new .VALUES[] {
            Initial, Connecting, Connected
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

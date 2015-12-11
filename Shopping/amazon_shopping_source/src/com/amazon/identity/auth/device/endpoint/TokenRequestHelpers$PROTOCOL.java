// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;

import java.util.Locale;

// Referenced classes of package com.amazon.identity.auth.device.endpoint:
//            TokenRequestHelpers

public static final class  extends Enum
{

    private static final HTTPS $VALUES[];
    public static final HTTPS HTTPS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString().toLowerCase(Locale.US)).append("://").toString();
    }

    static 
    {
        HTTPS = new <init>("HTTPS");
        $VALUES = (new .VALUES[] {
            HTTPS
        });
    }

    private (String s)
    {
        super(s, 0);
    }
}

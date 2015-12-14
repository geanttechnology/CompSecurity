// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            WebRequest

public static final class methodString extends Enum
{

    private static final POST $VALUES[];
    public static final POST GET;
    public static final POST POST;
    private final String methodString;

    public static methodString valueOf(String s)
    {
        return (methodString)Enum.valueOf(com/amazon/device/ads/identity/WebRequest$HttpMethod, s);
    }

    public static methodString[] values()
    {
        return (methodString[])$VALUES.clone();
    }

    public String toString()
    {
        return methodString;
    }

    static 
    {
        GET = new <init>("GET", 0, "GET");
        POST = new <init>("POST", 1, "POST");
        $VALUES = (new .VALUES[] {
            GET, POST
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        methodString = s1;
    }
}

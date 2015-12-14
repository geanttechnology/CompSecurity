// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            WebRequest

public static final class  extends Enum
{

    private static final UNSUPPORTED_ENCODING $VALUES[];
    public static final UNSUPPORTED_ENCODING INVALID_CLIENT_PROTOCOL;
    public static final UNSUPPORTED_ENCODING MALFORMED_URL;
    public static final UNSUPPORTED_ENCODING NETWORK_FAILURE;
    public static final UNSUPPORTED_ENCODING NETWORK_TIMEOUT;
    public static final UNSUPPORTED_ENCODING UNSUPPORTED_ENCODING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/identity/WebRequest$WebRequestStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NETWORK_FAILURE = new <init>("NETWORK_FAILURE", 0);
        NETWORK_TIMEOUT = new <init>("NETWORK_TIMEOUT", 1);
        MALFORMED_URL = new <init>("MALFORMED_URL", 2);
        INVALID_CLIENT_PROTOCOL = new <init>("INVALID_CLIENT_PROTOCOL", 3);
        UNSUPPORTED_ENCODING = new <init>("UNSUPPORTED_ENCODING", 4);
        $VALUES = (new .VALUES[] {
            NETWORK_FAILURE, NETWORK_TIMEOUT, MALFORMED_URL, INVALID_CLIENT_PROTOCOL, UNSUPPORTED_ENCODING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

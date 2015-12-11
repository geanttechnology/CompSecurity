// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;


// Referenced classes of package com.amazon.client.metrics.transport:
//            HttpClientFactory

static final class mScheme extends Enum
{

    private static final HTTPS $VALUES[];
    public static final HTTPS HTTP;
    public static final HTTPS HTTPS;
    private final int mPort;
    private final String mScheme;

    public static mScheme valueOf(String s)
    {
        return (mScheme)Enum.valueOf(com/amazon/client/metrics/transport/HttpClientFactory$Protocol, s);
    }

    public static mScheme[] values()
    {
        return (mScheme[])$VALUES.clone();
    }

    public final int getPort()
    {
        return mPort;
    }

    public final String getScheme()
    {
        return mScheme;
    }

    static 
    {
        HTTP = new <init>("HTTP", 0, 80, "http");
        HTTPS = new <init>("HTTPS", 1, 443, "https");
        $VALUES = (new .VALUES[] {
            HTTP, HTTPS
        });
    }

    private (String s, int i, int j, String s1)
    {
        super(s, i);
        mPort = j;
        mScheme = s1;
    }
}

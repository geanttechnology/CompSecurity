// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;


public final class WebProtocol extends Enum
{

    private static final WebProtocol $VALUES[];
    public static final WebProtocol WebProtocolHttp;
    public static final WebProtocol WebProtocolHttps;
    private final String mValue;

    private WebProtocol(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static WebProtocol valueOf(String s)
    {
        return (WebProtocol)Enum.valueOf(com/amazon/identity/kcpsdk/common/WebProtocol, s);
    }

    public static WebProtocol[] values()
    {
        return (WebProtocol[])$VALUES.clone();
    }

    public String getValue()
    {
        return mValue;
    }

    static 
    {
        WebProtocolHttp = new WebProtocol("WebProtocolHttp", 0, "http");
        WebProtocolHttps = new WebProtocol("WebProtocolHttps", 1, "https");
        $VALUES = (new WebProtocol[] {
            WebProtocolHttp, WebProtocolHttps
        });
    }
}

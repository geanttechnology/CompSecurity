// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;


public final class HttpScheme extends Enum
{

    private static final HttpScheme $VALUES[];
    public static final HttpScheme HTTP;
    public static final HttpScheme HTTPS;
    private final String name;

    private HttpScheme(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static HttpScheme valueOf(String s)
    {
        return (HttpScheme)Enum.valueOf(com/amazon/searchapp/retailsearch/client/web/HttpScheme, s);
    }

    public static HttpScheme[] values()
    {
        return (HttpScheme[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        HTTP = new HttpScheme("HTTP", 0, "http");
        HTTPS = new HttpScheme("HTTPS", 1, "https");
        $VALUES = (new HttpScheme[] {
            HTTP, HTTPS
        });
    }
}

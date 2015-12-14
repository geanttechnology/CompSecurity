// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;


public final class HttpVerb extends Enum
{

    private static final HttpVerb $VALUES[];
    public static final HttpVerb HttpVerbConnect;
    public static final HttpVerb HttpVerbDelete;
    public static final HttpVerb HttpVerbGet;
    public static final HttpVerb HttpVerbHead;
    public static final HttpVerb HttpVerbOptions;
    public static final HttpVerb HttpVerbPost;
    public static final HttpVerb HttpVerbPut;
    public static final HttpVerb HttpVerbTrace;
    private final String mValue;

    private HttpVerb(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static HttpVerb valueOf(String s)
    {
        return (HttpVerb)Enum.valueOf(com/amazon/identity/kcpsdk/common/HttpVerb, s);
    }

    public static HttpVerb[] values()
    {
        return (HttpVerb[])$VALUES.clone();
    }

    public String getValue()
    {
        return mValue;
    }

    static 
    {
        HttpVerbConnect = new HttpVerb("HttpVerbConnect", 0, "CONNECT");
        HttpVerbDelete = new HttpVerb("HttpVerbDelete", 1, "DELETE");
        HttpVerbGet = new HttpVerb("HttpVerbGet", 2, "GET");
        HttpVerbHead = new HttpVerb("HttpVerbHead", 3, "HEAD");
        HttpVerbOptions = new HttpVerb("HttpVerbOptions", 4, "OPTIONS");
        HttpVerbPost = new HttpVerb("HttpVerbPost", 5, "POST");
        HttpVerbPut = new HttpVerb("HttpVerbPut", 6, "PUT");
        HttpVerbTrace = new HttpVerb("HttpVerbTrace", 7, "TRACE");
        $VALUES = (new HttpVerb[] {
            HttpVerbConnect, HttpVerbDelete, HttpVerbGet, HttpVerbHead, HttpVerbOptions, HttpVerbPost, HttpVerbPut, HttpVerbTrace
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils;


public class URLRequest
{

    public String contentType;
    public String data;
    public long delayMs;
    public int method;
    public String url;
    public String userAgent;

    public URLRequest(String s, String s1)
    {
        method = 0;
        delayMs = 0L;
        url = s;
        userAgent = s1;
    }
}

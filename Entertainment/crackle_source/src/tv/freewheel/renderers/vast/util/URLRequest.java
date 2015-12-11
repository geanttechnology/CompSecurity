// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util;


public class URLRequest
{

    public static final String CONTENT_TYPE_FORM_ENCODED = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";
    public static final String CONTENT_TYPE_TEXT_XML = "text/xml";
    public static final int METHOD_GET = 1;
    public static final int METHOD_POST = 0;
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

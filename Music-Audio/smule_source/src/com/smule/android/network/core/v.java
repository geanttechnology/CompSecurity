// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class v extends Exception
{

    public String a;
    private HttpResponse b;

    public v(HttpResponse httpresponse, String s)
    {
        fillInStackTrace();
        b = httpresponse;
        a = s;
    }

    private static String a(HttpResponse httpresponse, String s)
    {
        Object obj = null;
        s = httpresponse.getFirstHeader(s);
        httpresponse = obj;
        if (s != null)
        {
            httpresponse = s.getValue();
        }
        return httpresponse;
    }

    public int a()
    {
        return b.getStatusLine().getStatusCode();
    }

    public String b()
    {
        return a(b, "server");
    }

    public String toString()
    {
        return (new StringBuilder()).append("ServerException (").append(b()).append("): ").append(a()).toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class s
    implements HttpRequestRetryHandler
{

    private static final int a = 1500;
    private static HashSet b;
    private static HashSet c;
    private final int d;

    public s(int i)
    {
        d = i;
    }

    public boolean retryRequest(IOException ioexception, int i, HttpContext httpcontext)
    {
        boolean flag2 = false;
        Boolean boolean1 = (Boolean)httpcontext.getAttribute("http.request_sent");
        boolean flag;
        boolean flag1;
        if (boolean1 != null && boolean1.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i > d)
        {
            flag1 = flag2;
        } else
        {
            flag1 = flag2;
            if (!c.contains(ioexception.getClass()))
            {
                if (b.contains(ioexception.getClass()))
                {
                    flag1 = true;
                } else
                if (!flag)
                {
                    flag1 = true;
                } else
                {
                    flag1 = flag2;
                    if (!((HttpUriRequest)httpcontext.getAttribute("http.request")).getMethod().equals("POST"))
                    {
                        flag1 = true;
                    }
                }
            }
        }
        if (flag1)
        {
            SystemClock.sleep(1500L);
            return flag1;
        } else
        {
            ioexception.printStackTrace();
            return flag1;
        }
    }

    static 
    {
        b = new HashSet();
        c = new HashSet();
        b.add(org/apache/http/NoHttpResponseException);
        b.add(java/net/UnknownHostException);
        b.add(java/net/SocketException);
        c.add(java/io/InterruptedIOException);
        c.add(javax/net/ssl/SSLHandshakeException);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class p
{

    public static HttpResponse a(HttpClient httpclient, HttpUriRequest httpurirequest)
    {
        HttpResponse httpresponse;
        if (l.c == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        httpresponse = (HttpResponse)(new ax._cls1(l.c.j, httpclient, httpurirequest, httpurirequest)).b();
        return httpresponse;
        httpclient;
        throw httpclient;
        Throwable throwable;
        throwable;
        a("Exception while executing http request", throwable);
        return httpclient.execute(httpurirequest);
    }

    public static HttpResponse a(HttpClient httpclient, HttpUriRequest httpurirequest, HttpContext httpcontext)
    {
        HttpResponse httpresponse;
        if (l.c == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        httpresponse = (HttpResponse)(new ax._cls2(l.c.j, httpclient, httpurirequest, httpurirequest, httpcontext)).b();
        return httpresponse;
        httpclient;
        throw httpclient;
        Throwable throwable;
        throwable;
        a("Exception while executing http request", throwable);
        return httpclient.execute(httpurirequest, httpcontext);
    }

    public static void a(Activity activity)
    {
    }

    public static void a(String s1, Throwable throwable)
    {
        bc.a(s1, throwable);
        if (l.c == null)
        {
            return;
        }
        try
        {
            l.c.l.a(s1, throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            bc.a("Error sending log message", s1);
        }
        return;
    }

    public static void a(URLConnection urlconnection)
    {
        try
        {
            if (l.c != null)
            {
                l.c.i.b(urlconnection);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (URLConnection urlconnection)
        {
            a("Exception in pre-request handler", ((Throwable) (urlconnection)));
        }
    }

    public static void a(URLConnection urlconnection, IOException ioexception)
    {
        try
        {
            if (l.c != null)
            {
                l.c.i.a(urlconnection, ioexception);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (URLConnection urlconnection)
        {
            a("Exception in network request handler", ((Throwable) (ioexception)));
        }
    }

    public static void b(Activity activity)
    {
        l.h.a(activity);
    }

    public static void b(URLConnection urlconnection)
    {
        try
        {
            if (l.c != null)
            {
                l.c.i.c(urlconnection);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (URLConnection urlconnection)
        {
            a("Exception in post-request handler", urlconnection);
        }
    }

    public static void c(Activity activity)
    {
        l.h.b(activity);
    }

    public static void c(URLConnection urlconnection)
    {
        try
        {
            if (l.c != null)
            {
                l.c.i.a(urlconnection);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (URLConnection urlconnection)
        {
            a("Exception in marking request as reportable", urlconnection);
        }
    }

    public static InputStream d(URLConnection urlconnection)
    {
        InputStream inputstream;
        if (l.c == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        inputstream = (new bk._cls1(l.c.i, urlconnection)).a(urlconnection);
        return inputstream;
        urlconnection;
        throw urlconnection;
        Throwable throwable;
        throwable;
        a("Exception while fetching input stream", throwable);
        return urlconnection.getInputStream();
    }

    public static void d(Activity activity)
    {
    }

    public static void e(Activity activity)
    {
    }

    public static void f(Activity activity)
    {
        if (l.b != null)
        {
            l.b.c();
        }
        l.h.c(activity);
    }

    public static void g(Activity activity)
    {
        if (l.b != null)
        {
            l.b.b();
        }
    }
}

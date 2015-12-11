// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package android.support.v7:
//            ako, akv, alj

public class ali
    implements ako
{
    private static class a
    {

        static Object a(Context context)
            throws IOException
        {
            java.io.File file = alj.b(context);
            HttpResponseCache httpresponsecache = HttpResponseCache.getInstalled();
            context = httpresponsecache;
            if (httpresponsecache == null)
            {
                context = HttpResponseCache.install(file, alj.a(file));
            }
            return context;
        }
    }


    static volatile Object a;
    private static final Object b = new Object();
    private static final ThreadLocal c = new ThreadLocal() {

        protected StringBuilder a()
        {
            return new StringBuilder();
        }

        protected Object initialValue()
        {
            return a();
        }

    };
    private final Context d;

    public ali(Context context)
    {
        d = context.getApplicationContext();
    }

    private static void a(Context context)
    {
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        synchronized (b)
        {
            if (a == null)
            {
                a = a.a(context);
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
    }

    public ako.a a(Uri uri, int i)
        throws IOException
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a(d);
        }
        HttpURLConnection httpurlconnection = a(uri);
        httpurlconnection.setUseCaches(true);
        if (i != 0)
        {
            int j;
            if (akv.c(i))
            {
                uri = "only-if-cached,max-age=2147483647";
            } else
            {
                uri = (StringBuilder)c.get();
                uri.setLength(0);
                if (!akv.a(i))
                {
                    uri.append("no-cache");
                }
                if (!akv.b(i))
                {
                    if (uri.length() > 0)
                    {
                        uri.append(',');
                    }
                    uri.append("no-store");
                }
                uri = uri.toString();
            }
            httpurlconnection.setRequestProperty("Cache-Control", uri);
        }
        j = httpurlconnection.getResponseCode();
        if (j >= 300)
        {
            httpurlconnection.disconnect();
            throw new ako.b((new StringBuilder()).append(j).append(" ").append(httpurlconnection.getResponseMessage()).toString(), i, j);
        } else
        {
            long l = httpurlconnection.getHeaderFieldInt("Content-Length", -1);
            boolean flag = alj.a(httpurlconnection.getHeaderField("X-Android-Response-Source"));
            return new ako.a(httpurlconnection.getInputStream(), flag, l);
        }
    }

    protected HttpURLConnection a(Uri uri)
        throws IOException
    {
        uri = (HttpURLConnection)(new URL(uri.toString())).openConnection();
        uri.setConnectTimeout(15000);
        uri.setReadTimeout(20000);
        return uri;
    }

}

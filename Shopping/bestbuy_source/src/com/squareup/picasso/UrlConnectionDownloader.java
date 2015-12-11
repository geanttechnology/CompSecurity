// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import p;

// Referenced classes of package com.squareup.picasso:
//            Downloader, Utils

public class UrlConnectionDownloader
    implements Downloader
{

    static final String RESPONSE_SOURCE = "X-Android-Response-Source";
    static volatile Object cache;
    private static final Object lock = new Object();
    private final Context context;

    public UrlConnectionDownloader(Context context1)
    {
        context = context1.getApplicationContext();
    }

    private static void installCacheIfNeeded(Context context1)
    {
        if (cache != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        synchronized (lock)
        {
            if (cache == null)
            {
                cache = ResponseCacheIcs.install(context1);
            }
        }
        return;
        context1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw context1;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1) { }
    }

    public Downloader.Response load(Uri uri, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            installCacheIfNeeded(context);
        }
        uri = openConnection(uri);
        uri.setUseCaches(true);
        if (flag)
        {
            uri.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        p.a(uri);
        int i;
        try
        {
            i = uri.getResponseCode();
            p.b(uri);
        }
        catch (IOException ioexception)
        {
            p.a(uri, ioexception);
            throw ioexception;
        }
        p.c(uri);
        if (i >= 300)
        {
            uri.disconnect();
            StringBuilder stringbuilder = (new StringBuilder()).append(i).append(" ");
            p.a(uri);
            String s1;
            try
            {
                s1 = uri.getResponseMessage();
                p.b(uri);
            }
            catch (IOException ioexception1)
            {
                p.a(uri, ioexception1);
                throw ioexception1;
            }
            p.c(uri);
            throw new Downloader.ResponseException(stringbuilder.append(s1).toString());
        } else
        {
            p.a(uri);
            int j = uri.getHeaderFieldInt("Content-Length", -1);
            p.b(uri);
            p.c(uri);
            long l = j;
            p.a(uri);
            String s = uri.getHeaderField("X-Android-Response-Source");
            p.b(uri);
            p.c(uri);
            flag = Utils.parseResponseSourceHeader(s);
            return new Downloader.Response(p.d(uri), flag, l);
        }
    }

    protected HttpURLConnection openConnection(Uri uri)
    {
        uri = (HttpURLConnection)(new URL(uri.toString())).openConnection();
        uri.setConnectTimeout(15000);
        uri.setReadTimeout(20000);
        return uri;
    }


    private class ResponseCacheIcs
    {

        static Object install(Context context1)
        {
            java.io.File file = Utils.createDefaultCacheDir(context1);
            HttpResponseCache httpresponsecache = HttpResponseCache.getInstalled();
            context1 = httpresponsecache;
            if (httpresponsecache == null)
            {
                context1 = HttpResponseCache.install(file, Utils.calculateDiskCacheSize(file));
            }
            return context1;
        }

        private ResponseCacheIcs()
        {
        }
    }

}

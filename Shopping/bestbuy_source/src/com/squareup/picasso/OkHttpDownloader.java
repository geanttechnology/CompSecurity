// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import p;

// Referenced classes of package com.squareup.picasso:
//            Downloader, Utils

public class OkHttpDownloader
    implements Downloader
{

    static final String RESPONSE_SOURCE_ANDROID = "X-Android-Response-Source";
    static final String RESPONSE_SOURCE_OKHTTP = "OkHttp-Response-Source";
    private final OkUrlFactory urlFactory;

    public OkHttpDownloader(Context context)
    {
        this(Utils.createDefaultCacheDir(context));
    }

    public OkHttpDownloader(Context context, long l)
    {
        this(Utils.createDefaultCacheDir(context), l);
    }

    public OkHttpDownloader(OkHttpClient okhttpclient)
    {
        urlFactory = new OkUrlFactory(okhttpclient);
    }

    public OkHttpDownloader(File file)
    {
        this(file, Utils.calculateDiskCacheSize(file));
    }

    public OkHttpDownloader(File file, long l)
    {
        this(new OkHttpClient());
        try
        {
            urlFactory.client().setCache(new Cache(file, l));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
    }

    protected OkHttpClient getClient()
    {
        return urlFactory.client();
    }

    public Downloader.Response load(Uri uri, boolean flag)
    {
        HttpURLConnection httpurlconnection = openConnection(uri);
        httpurlconnection.setUseCaches(true);
        if (flag)
        {
            httpurlconnection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        p.a(httpurlconnection);
        int i;
        try
        {
            i = httpurlconnection.getResponseCode();
            p.b(httpurlconnection);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            p.a(httpurlconnection, uri);
            throw uri;
        }
        p.c(httpurlconnection);
        if (i >= 300)
        {
            httpurlconnection.disconnect();
            uri = (new StringBuilder()).append(i).append(" ");
            p.a(httpurlconnection);
            String s;
            try
            {
                s = httpurlconnection.getResponseMessage();
                p.b(httpurlconnection);
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                p.a(httpurlconnection, uri);
                throw uri;
            }
            p.c(httpurlconnection);
            throw new Downloader.ResponseException(uri.append(s).toString());
        }
        p.a(httpurlconnection);
        String s1 = httpurlconnection.getHeaderField("OkHttp-Response-Source");
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        uri = s1;
        if (s1 == null)
        {
            p.a(httpurlconnection);
            uri = httpurlconnection.getHeaderField("X-Android-Response-Source");
            p.b(httpurlconnection);
            p.c(httpurlconnection);
        }
        p.a(httpurlconnection);
        i = httpurlconnection.getHeaderFieldInt("Content-Length", -1);
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        long l = i;
        flag = Utils.parseResponseSourceHeader(uri);
        return new Downloader.Response(p.d(httpurlconnection), flag, l);
    }

    protected HttpURLConnection openConnection(Uri uri)
    {
        uri = urlFactory.open(new URL(uri.toString()));
        uri.setConnectTimeout(15000);
        uri.setReadTimeout(20000);
        return uri;
    }
}

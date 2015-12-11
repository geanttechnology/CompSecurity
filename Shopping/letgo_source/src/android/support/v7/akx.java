// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            ako, alj, akv

public class akx
    implements ako
{

    private final OkHttpClient a;

    public akx(Context context)
    {
        this(alj.b(context));
    }

    public akx(OkHttpClient okhttpclient)
    {
        a = okhttpclient;
    }

    public akx(File file)
    {
        this(file, alj.a(file));
    }

    public akx(File file, long l)
    {
        this(a());
        try
        {
            a.setCache(new Cache(file, l));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
    }

    private static OkHttpClient a()
    {
        OkHttpClient okhttpclient = new OkHttpClient();
        okhttpclient.setConnectTimeout(15000L, TimeUnit.MILLISECONDS);
        okhttpclient.setReadTimeout(20000L, TimeUnit.MILLISECONDS);
        okhttpclient.setWriteTimeout(20000L, TimeUnit.MILLISECONDS);
        return okhttpclient;
    }

    public ako.a a(Uri uri, int i)
        throws IOException
    {
        Object obj = null;
        int j;
        if (i != 0)
        {
            if (akv.c(i))
            {
                obj = CacheControl.FORCE_CACHE;
            } else
            {
                obj = new com.squareup.okhttp.CacheControl.Builder();
                if (!akv.a(i))
                {
                    ((com.squareup.okhttp.CacheControl.Builder) (obj)).noCache();
                }
                if (!akv.b(i))
                {
                    ((com.squareup.okhttp.CacheControl.Builder) (obj)).noStore();
                }
                obj = ((com.squareup.okhttp.CacheControl.Builder) (obj)).build();
            }
        }
        uri = (new com.squareup.okhttp.Request.Builder()).url(uri.toString());
        if (obj != null)
        {
            uri.cacheControl(((CacheControl) (obj)));
        }
        uri = a.newCall(uri.build()).execute();
        j = uri.code();
        if (j >= 300)
        {
            uri.body().close();
            throw new ako.b((new StringBuilder()).append(j).append(" ").append(uri.message()).toString(), i, j);
        }
        boolean flag;
        if (uri.cacheResponse() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        uri = uri.body();
        return new ako.a(uri.byteStream(), flag, uri.contentLength());
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.net.Uri;
import com.a.a.f;
import com.a.a.r;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.a.b:
//            s, ba, u, t

public final class ac
    implements s
{

    private final r a;

    public ac(Context context)
    {
        this(ba.b(context));
    }

    private ac(r r1)
    {
        a = r1;
    }

    private ac(File file)
    {
        this(file, ba.a(file));
    }

    private ac(File file, long l)
    {
        this(new r());
        try
        {
            a.f = new f(file, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
    }

    public final t a(Uri uri, boolean flag)
    {
        HttpURLConnection httpurlconnection = a.a(new URL(uri.toString()));
        httpurlconnection.setConnectTimeout(15000);
        httpurlconnection.setReadTimeout(20000);
        httpurlconnection.setUseCaches(true);
        if (flag)
        {
            httpurlconnection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int i = httpurlconnection.getResponseCode();
        if (i >= 300)
        {
            httpurlconnection.disconnect();
            throw new u((new StringBuilder()).append(i).append(" ").append(httpurlconnection.getResponseMessage()).toString());
        }
        String s1 = httpurlconnection.getHeaderField("OkHttp-Response-Source");
        uri = s1;
        if (s1 == null)
        {
            uri = httpurlconnection.getHeaderField("X-Android-Response-Source");
        }
        flag = ba.a(uri);
        return new t(httpurlconnection.getInputStream(), flag);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.thirdparty.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.facebook.ads.internal.thirdparty.http:
//            p, g, j, m, 
//            q, n

public abstract class f
    implements p
{

    private final q a;

    public f()
    {
        this(((q) (new g())));
    }

    public f(q q1)
    {
        a = q1;
    }

    public OutputStream a(HttpURLConnection httpurlconnection)
    {
        return httpurlconnection.getOutputStream();
    }

    public HttpURLConnection a(String s)
    {
        return (HttpURLConnection)(new URL(s)).openConnection();
    }

    public void a(OutputStream outputstream, byte abyte0[])
    {
        outputstream.write(abyte0);
    }

    public void a(HttpURLConnection httpurlconnection, j j1, String s)
    {
        httpurlconnection.setRequestMethod(j1.c());
        httpurlconnection.setDoOutput(j1.b());
        httpurlconnection.setDoInput(j1.a());
        if (s != null)
        {
            httpurlconnection.setRequestProperty("Content-Type", s);
        }
        httpurlconnection.setRequestProperty("Accept-Charset", "UTF-8");
    }

    public boolean a(m m1)
    {
        n n1 = m1.a();
        if (a.a())
        {
            a.a("BasicRequestHandler.onError got");
            m1.printStackTrace();
        }
        return n1 != null && n1.a() > 0;
    }

    public byte[] a(InputStream inputstream)
    {
        byte abyte0[] = new byte[16384];
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                bytearrayoutputstream.flush();
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    public InputStream b(HttpURLConnection httpurlconnection)
    {
        return httpurlconnection.getInputStream();
    }
}

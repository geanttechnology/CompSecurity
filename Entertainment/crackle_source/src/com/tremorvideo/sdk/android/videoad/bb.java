// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aa, ad

public class bb
{
    class a extends AsyncTask
    {

        final bb a;

        protected transient Void a(bb abb[])
        {
            if (abb.length > 0)
            {
                abb = abb[0];
                if (abb != null)
                {
                    try
                    {
                        abb.a();
                    }
                    // Misplaced declaration of an exception variable
                    catch (bb abb[])
                    {
                        ad.a(abb);
                    }
                }
            }
            return null;
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((bb[])aobj);
        }

        a()
        {
            a = bb.this;
            super();
        }
    }

    private static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        private static final b c[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/videoad/bb$b, s);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("Post", 0);
            b = new b("Get", 1);
            c = (new b[] {
                a, b
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    private String a;
    private String b;
    private String c;
    private b d;
    private String e;
    private int f;

    private bb(String s, String s1, String s2, b b1, int i)
    {
        a = s;
        b = s1;
        c = s2;
        e = null;
        d = b1;
        f = i;
    }

    public static bb a(String s, String s1)
    {
        return new bb(s, s1, null, b.b, -1);
    }

    public static bb a(String s, String s1, String s2, int i)
    {
        return new bb(s, s1, s2, b.a, i);
    }

    public void a()
        throws UnsupportedEncodingException, IOException
    {
        Object obj1 = new DefaultHttpClient();
        if (aa.c() != null)
        {
            ((DefaultHttpClient) (obj1)).setCookieStore(aa.c());
        }
        Object obj = null;
        HttpParams httpparams;
        int i;
        if (d == b.b)
        {
            obj = new HttpGet(a);
        } else
        if (d == b.a)
        {
            obj = new HttpPost(a);
            ((HttpPost) (obj)).setEntity(new StringEntity(c));
        }
        httpparams = ((HttpUriRequest) (obj)).getParams();
        if (f > 0)
        {
            HttpConnectionParams.setConnectionTimeout(httpparams, f);
            HttpConnectionParams.setSoTimeout(httpparams, f);
        } else
        {
            HttpConnectionParams.setConnectionTimeout(httpparams, 18000);
            HttpConnectionParams.setSoTimeout(httpparams, 18000);
        }
        httpparams.setBooleanParameter("http.protocol.expect-continue", false);
        httpparams.setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
        if (b != null)
        {
            ((HttpUriRequest) (obj)).setHeader("User-Agent", b);
        }
        obj = ((DefaultHttpClient) (obj1)).execute(((HttpUriRequest) (obj)));
        obj1 = ((HttpResponse) (obj)).getEntity();
        if (((HttpResponse) (obj)).getStatusLine() != null)
        {
            i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        } else
        {
            i = 200;
        }
        if (i >= 200 && i < 300)
        {
            aa.a();
            obj = new BufferedInputStream(((HttpEntity) (obj1)).getContent());
            obj1 = new StringBuilder(Math.max(0, (int)((HttpEntity) (obj1)).getContentLength()));
            httpparams = new byte[1024];
            do
            {
                i = ((BufferedInputStream) (obj)).read(httpparams);
                if (i <= 0)
                {
                    break;
                }
                ((StringBuilder) (obj1)).append(new String(httpparams, 0, i));
            } while (true);
            e = ((StringBuilder) (obj1)).toString();
        }
    }

    public String b()
    {
        return e;
    }

    public void c()
    {
        (new a()).execute(new bb[] {
            this
        });
    }
}

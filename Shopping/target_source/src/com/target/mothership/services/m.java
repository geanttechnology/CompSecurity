// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.a.a.a;
import com.a.a.a.f;
import com.h.b.e;
import com.h.b.p;
import com.h.b.r;
import com.h.b.s;
import com.h.b.t;
import com.h.b.v;
import com.h.b.w;
import com.h.b.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class m
    implements f
{

    private final s mClient;

    public m()
    {
        this(new s());
    }

    public m(s s1)
    {
        mClient = s1;
    }

    private static v a(com.a.a.m m1)
        throws a
    {
        byte abyte0[] = m1.getBody();
        if (abyte0 == null)
        {
            return null;
        } else
        {
            return v.create(r.a(m1.getBodyContentType()), abyte0);
        }
    }

    private static HttpEntity a(w w1)
        throws IOException
    {
        BasicHttpEntity basichttpentity = new BasicHttpEntity();
        x x1 = w1.g();
        basichttpentity.setContent(x1.byteStream());
        basichttpentity.setContentLength(x1.contentLength());
        basichttpentity.setContentEncoding(w1.a("Content-Encoding"));
        if (x1.contentType() != null)
        {
            basichttpentity.setContentType(x1.contentType().a());
        }
        return basichttpentity;
    }

    private static ProtocolVersion a(t t1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$squareup$okhttp$Protocol[];

            static 
            {
                $SwitchMap$com$squareup$okhttp$Protocol = new int[t.values().length];
                try
                {
                    $SwitchMap$com$squareup$okhttp$Protocol[t.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$squareup$okhttp$Protocol[t.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$squareup$okhttp$Protocol[t.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$squareup$okhttp$Protocol[t.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.squareup.okhttp.Protocol[t1.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown or unsupported OkHttp Protocol value: ").append(t1).toString());

        case 1: // '\001'
            return new ProtocolVersion("HTTP", 1, 0);

        case 2: // '\002'
            return new ProtocolVersion("HTTP", 1, 1);

        case 3: // '\003'
            return new ProtocolVersion("SPDY", 3, 1);

        case 4: // '\004'
            return new ProtocolVersion("HTTP", 2, 0);
        }
    }

    private static void a(com.h.b.u.a a1, com.a.a.m m1)
        throws IOException, a
    {
        switch (m1.getMethod())
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown or unsupported Volley method int value: ").append(m1.getMethod()).toString());

        case 0: // '\0'
            a1.get();
            return;

        case 3: // '\003'
            a1.delete();
            return;

        case 1: // '\001'
            a1.post(a(m1));
            return;

        case 2: // '\002'
            a1.put(a(m1));
            return;

        case 4: // '\004'
            a1.head();
            return;

        case 5: // '\005'
            a1.method("OPTIONS", null);
            return;

        case 6: // '\006'
            a1.method("TRACE", null);
            return;

        case 7: // '\007'
            a1.patch(a(m1));
            break;
        }
    }

    private static boolean a(int i, int j)
    {
        return i != 4 && (100 > j || j >= 200) && j != 204 && j != 304;
    }

    public HttpResponse a(com.a.a.m m1, Map map)
        throws IOException, a
    {
        Object obj = mClient.x();
        int i = m1.getTimeoutMs();
        ((s) (obj)).a(i, TimeUnit.MILLISECONDS);
        ((s) (obj)).b(i, TimeUnit.MILLISECONDS);
        ((s) (obj)).c(i, TimeUnit.MILLISECONDS);
        Object obj1 = new com.h.b.u.a();
        ((com.h.b.u.a) (obj1)).url(m1.getUrl());
        Map map1 = m1.getHeaders();
        String s4;
        for (Iterator iterator1 = map1.keySet().iterator(); iterator1.hasNext(); ((com.h.b.u.a) (obj1)).addHeader(s4, (String)map1.get(s4)))
        {
            s4 = (String)iterator1.next();
        }

        String s3;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ((com.h.b.u.a) (obj1)).addHeader(s3, (String)map.get(s3)))
        {
            s3 = (String)iterator.next();
        }

        a(((com.h.b.u.a) (obj1)), m1);
        obj = ((s) (obj)).a(((com.h.b.u.a) (obj1)).build()).execute();
        obj1 = new BasicStatusLine(a(((w) (obj)).b()), ((w) (obj)).c(), ((w) (obj)).d());
        map = new BasicHttpResponse(((StatusLine) (obj1)));
        if (a(m1.getMethod(), ((StatusLine) (obj1)).getStatusCode()))
        {
            map.setEntity(a(((w) (obj))));
        }
        m1 = ((w) (obj)).f();
        i = 0;
        for (int j = m1.a(); i < j; i++)
        {
            String s1 = m1.a(i);
            String s2 = m1.b(i);
            if (s1 != null)
            {
                map.addHeader(new BasicHeader(s1, s2));
            }
        }

        return map;
    }
}

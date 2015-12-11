// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import com.mopub.common.d.j;
import com.mopub.d.a.f;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpResponse;

public final class l extends f
{

    private final String a;

    public l(String s, com.mopub.d.a.f.a a1, SSLSocketFactory sslsocketfactory)
    {
        super(a1, sslsocketfactory);
        a = s;
    }

    public final HttpResponse a(com.mopub.d.l l1, Map map)
    {
        Object obj = map;
        if (map == null)
        {
            obj = new TreeMap();
        }
        ((Map) (obj)).put(j.u.x, a);
        return super.a(l1, ((Map) (obj)));
    }
}

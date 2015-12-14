// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.server;

import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.thirdparty.http.b;
import com.facebook.ads.internal.thirdparty.http.m;
import com.facebook.ads.internal.thirdparty.http.n;
import com.facebook.ads.internal.util.d;
import org.json.JSONException;

// Referenced classes of package com.facebook.ads.internal.server:
//            a, b, c, e

class http.b extends b
{

    final a a;

    public void a(m m1)
    {
        d.b(com.facebook.ads.internal.server.a.d(a));
        com.facebook.ads.internal.server.a.a(a, null);
        Object obj = m1.a();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        Object obj1;
        Object obj2;
        a a1;
        obj = ((n) (obj)).e();
        obj1 = com.facebook.ads.internal.server.a.e(a).a(((String) (obj)));
        if (((c) (obj1)).a() != com.facebook.ads.internal.server.b)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        obj2 = (e)obj1;
        obj1 = ((e) (obj2)).c();
        obj2 = AdErrorType.adErrorTypeFromCode(((e) (obj2)).d(), AdErrorType.ERROR_MESSAGE);
        a1 = a;
        if (obj1 != null)
        {
            obj = obj1;
        }
        try
        {
            com.facebook.ads.internal.server.a.a(a1, ((AdErrorType) (obj2)).getAdErrorWrapper(((String) (obj))));
            return;
        }
        catch (JSONException jsonexception) { }
        com.facebook.ads.internal.server.a.a(a, new com.facebook.ads.internal.b(AdErrorType.NETWORK_ERROR, m1.getMessage()));
        return;
    }

    public void a(n n1)
    {
        if (n1 != null)
        {
            n1 = n1.e();
            d.b(com.facebook.ads.internal.server.a.d(a));
            com.facebook.ads.internal.server.a.a(a, null);
            com.facebook.ads.internal.server.a.a(a, n1);
        }
    }

    public void a(Exception exception)
    {
        if (com/facebook/ads/internal/thirdparty/http/m.equals(exception.getClass()))
        {
            a((m)exception);
            return;
        } else
        {
            com.facebook.ads.internal.server.a.a(a, new com.facebook.ads.internal.b(AdErrorType.NETWORK_ERROR, exception.getMessage()));
            return;
        }
    }

    http.n(a a1)
    {
        a = a1;
        super();
    }
}

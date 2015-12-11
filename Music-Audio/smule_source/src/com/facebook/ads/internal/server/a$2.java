// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.server;

import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.dev.Debug;
import com.facebook.ads.internal.http.c;
import com.facebook.ads.internal.util.d;

// Referenced classes of package com.facebook.ads.internal.server:
//            a

class t> extends c
{

    final a a;

    public void a()
    {
        Debug.d((new StringBuilder()).append("Facebook Ads SDK req start delay=").append(System.currentTimeMillis() - com.facebook.ads.internal.server.a.d(a)).append("ms").toString());
    }

    public void a(int i, String s)
    {
        d.b(com.facebook.ads.internal.server.a.e(a));
        Debug.i((new StringBuilder()).append("Facebook Ads SDK req complete ").append(System.currentTimeMillis() - com.facebook.ads.internal.server.a.d(a)).append("ms ").toString());
        com.facebook.ads.internal.server.a.a(a, null);
        com.facebook.ads.internal.server.a.a(a, s);
    }

    public void a(Throwable throwable, String s)
    {
        d.b(com.facebook.ads.internal.server.a.e(a));
        long l = System.currentTimeMillis();
        long l1 = com.facebook.ads.internal.server.a.d(a);
        Debug.e((new StringBuilder()).append("Facebook Ads SDK req failed ").append(l - l1).append("ms ").append(s).append(" ").append(throwable).toString());
        com.facebook.ads.internal.server.a.a(a, null);
        com.facebook.ads.internal.server.a.a(a, new b(AdErrorType.NETWORK_ERROR, throwable.getMessage()));
    }

    (a a1)
    {
        a = a1;
        super();
    }
}

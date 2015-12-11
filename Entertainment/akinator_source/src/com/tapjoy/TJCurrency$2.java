// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TJCurrency, TapjoyConnectCore, TapjoyUtil, TapjoyURLConnection

final class a
    implements Runnable
{

    final TJCurrency a;

    public final void run()
    {
        Object obj = TapjoyConnectCore.getURLParams();
        TapjoyUtil.safePut(((java.util.Map) (obj)), "tap_points", a.a, true);
        obj = (new TapjoyURLConnection()).getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("points/spend?").toString(), ((java.util.Map) (obj)));
        TJCurrency.b(a, ((TapjoyHttpURLResponse) (obj)));
    }

    ection(TJCurrency tjcurrency)
    {
        a = tjcurrency;
        super();
    }
}

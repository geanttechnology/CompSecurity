// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.util.UUID;

// Referenced classes of package com.tapjoy:
//            TJCurrency, TapjoyConnectCore, TapjoyUtil, TapjoyURLConnection

final class a
    implements Runnable
{

    final TJCurrency a;

    public final void run()
    {
        Object obj = UUID.randomUUID().toString();
        long l = System.currentTimeMillis() / 1000L;
        java.util.Map map = TapjoyConnectCore.getGenericURLParams();
        TapjoyUtil.safePut(map, "tap_points", String.valueOf(a.b), true);
        TapjoyUtil.safePut(map, "guid", ((String) (obj)), true);
        TapjoyUtil.safePut(map, "timestamp", String.valueOf(l), true);
        TapjoyUtil.safePut(map, "verifier", TapjoyConnectCore.getAwardCurrencyVerifier(l, a.b, ((String) (obj))), true);
        obj = (new TapjoyURLConnection()).getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("points/award?").toString(), map);
        TJCurrency.c(a, ((TapjoyHttpURLResponse) (obj)));
    }

    ection(TJCurrency tjcurrency)
    {
        a = tjcurrency;
        super();
    }
}

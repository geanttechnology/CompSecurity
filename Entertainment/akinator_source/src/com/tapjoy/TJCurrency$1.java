// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TJCurrency, TapjoyURLConnection, TapjoyConnectCore

final class a
    implements Runnable
{

    final TJCurrency a;

    public final void run()
    {
        TapjoyHttpURLResponse tapjoyhttpurlresponse = (new TapjoyURLConnection()).getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("get_vg_store_items/user_account?").toString(), TapjoyConnectCore.getURLParams());
        TJCurrency.a(a, tapjoyhttpurlresponse);
    }

    Core(TJCurrency tjcurrency)
    {
        a = tjcurrency;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.HashMap;

// Referenced classes of package com.tapjoy:
//            TJOffersListener, TapjoyConnectCore, TapjoyUtil, TJPlacementData, 
//            TJAdUnitActivity

public class TJCOffers
{

    private static TJOffersListener b;
    Context a;

    public TJCOffers(Context context)
    {
        a = context;
    }

    public static void onOffersResponse()
    {
        if (b != null)
        {
            b.onOffersResponse();
        }
    }

    public static void onOffersResponseFailed(String s)
    {
        if (b != null)
        {
            b.onOffersResponseFailure(s);
        }
    }

    public void showOffers(TJOffersListener tjofferslistener)
    {
        showOffersWithCurrencyID(null, false, tjofferslistener);
    }

    public void showOffersWithCurrencyID(String s, boolean flag, TJOffersListener tjofferslistener)
    {
label0:
        {
            if (!TapjoyConnectCore.isViewOpen())
            {
                TapjoyConnectCore.viewWillOpen(1);
                b = tjofferslistener;
                HashMap hashmap;
                if (flag)
                {
                    tjofferslistener = "1";
                } else
                {
                    tjofferslistener = "0";
                }
                hashmap = new HashMap(TapjoyConnectCore.getURLParams());
                TapjoyUtil.safePut(hashmap, "currency_id", s, true);
                TapjoyUtil.safePut(hashmap, "currency_selector", tjofferslistener, true);
                s = new TJPlacementData((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("get_offers/webpage?").append(TapjoyUtil.convertURLParams(hashmap, false)).toString());
                s.setViewType(1);
                s.setHasProgressSpinner(true);
                tjofferslistener = new Intent(a, com/tapjoy/TJAdUnitActivity);
                tjofferslistener.putExtra("placement_data", s);
                if (!(a instanceof Activity))
                {
                    break label0;
                }
                ((Activity)a).startActivityForResult(tjofferslistener, 0);
            }
            return;
        }
        tjofferslistener.setFlags(0x10000000);
        a.startActivity(tjofferslistener);
    }
}

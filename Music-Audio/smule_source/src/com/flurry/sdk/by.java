// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMInterstitial;
import java.lang.reflect.Method;

// Referenced classes of package com.flurry.sdk:
//            bd, gd, r

public class by extends bd
{

    private static final String b = com/flurry/sdk/by.getSimpleName();
    private static final Method c = e();
    private final String d;
    private IMInterstitial e;
    private a f;

    public by(Context context, r r, Bundle bundle)
    {
        super(context, r);
        d = bundle.getString("com.flurry.inmobi.MY_APP_ID");
        InMobi.initialize((Activity)c(), d);
    }

    private void a(IMInterstitial iminterstitial, a a1)
    {
        if (iminterstitial != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (c == null) goto _L1; else goto _L3
_L3:
        c.invoke(iminterstitial, new Object[] {
            a1
        });
        return;
        iminterstitial;
        gd.a(3, b, "InMobi set listener failed.");
        return;
    }

    static String b()
    {
        return b;
    }

    private static Method e()
    {
        Method amethod[] = com/inmobi/monetization/IMInterstitial.getMethods();
        int j = amethod.length;
        for (int i = 0; i < j; i++)
        {
            Method method = amethod[i];
            String s = method.getName();
            if (s.equals("setIMInterstitialListener") || s.equals("setImInterstitialListener"))
            {
                return method;
            }
        }

        return null;
    }

    public void a()
    {
        e = new IMInterstitial((Activity)c(), d);
        f = new a();
        a(e, f);
        e.loadInterstitial();
    }


    private class a
        implements IMInterstitialListener
    {

        final by a;

        public void onDismissInterstitialScreen(IMInterstitial iminterstitial)
        {
            a.c(Collections.emptyMap());
            gd.a(3, by.b(), "InMobi Interstitial ad dismissed.");
        }

        public void onInterstitialFailed(IMInterstitial iminterstitial, IMErrorCode imerrorcode)
        {
            a.d(Collections.emptyMap());
            gd.a(3, by.b(), (new StringBuilder()).append("InMobi imAdView ad request failed. ErrorCode  = ").append(imerrorcode.toString()).toString());
        }

        public void onInterstitialInteraction(IMInterstitial iminterstitial, Map map)
        {
            a.b(Collections.emptyMap());
            gd.a(3, by.b(), "InMobi onBannerInteraction");
        }

        public void onInterstitialLoaded(IMInterstitial iminterstitial)
        {
            gd.a(3, by.b(), "InMobi Interstitial ad request completed.");
            if (com.inmobi.monetization.IMInterstitial.State.READY.equals(iminterstitial.getState()))
            {
                a.a(Collections.emptyMap());
                iminterstitial.show();
            }
        }

        public void onLeaveApplication(IMInterstitial iminterstitial)
        {
            a.b(Collections.emptyMap());
            gd.a(3, by.b(), "InMobi onLeaveApplication");
        }

        public void onShowInterstitialScreen(IMInterstitial iminterstitial)
        {
            gd.a(3, by.b(), "InMobi Interstitial ad shown.");
        }

        private a()
        {
            a = by.this;
            super();
        }

    }

}

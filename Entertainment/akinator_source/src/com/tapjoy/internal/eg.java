// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJCOffers;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJOffersListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TJViewListener;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyException;
import com.tapjoy.TapjoyIntegrationException;
import com.tapjoy.TapjoyLog;
import java.util.Hashtable;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            ef, gd, ft

class eg extends ef
{

    private boolean b;
    private TJCurrency c;
    private TJCOffers d;
    private TapjoyCache e;

    eg()
    {
        b = false;
        c = null;
        d = null;
        e = null;
    }

    static TJCOffers a(eg eg1, TJCOffers tjcoffers)
    {
        eg1.d = tjcoffers;
        return tjcoffers;
    }

    static TJCurrency a(eg eg1, TJCurrency tjcurrency)
    {
        eg1.c = tjcurrency;
        return tjcurrency;
    }

    static TapjoyCache a(eg eg1, TapjoyCache tapjoycache)
    {
        eg1.e = tapjoycache;
        return tapjoycache;
    }

    private boolean g(String s)
    {
        if (!a)
        {
            TapjoyLog.w("TapjoyAPI", (new StringBuilder("Can not call ")).append(s).append(" because Tapjoy SDK has not successfully connected.").toString());
            return false;
        } else
        {
            return true;
        }
    }

    private boolean h(String s)
    {
        if (!b)
        {
            TapjoyLog.w("TapjoyAPI", (new StringBuilder("Can not call ")).append(s).append(" because Tapjoy SDK is not initialized.").toString());
            return false;
        } else
        {
            return true;
        }
    }

    public final void a(float f1)
    {
        if (h("setCurrencyMultiplier"))
        {
            TapjoyConnectCore.getInstance().setCurrencyMultiplier(f1);
        }
    }

    public final void a(int i)
    {
        gd.a().a(i);
    }

    public final void a(int i, TJAwardCurrencyListener tjawardcurrencylistener)
    {
        if (c != null && g("awardCurrency"))
        {
            c.awardCurrency(i, tjawardcurrencylistener);
        }
    }

    public final void a(int i, TJSpendCurrencyListener tjspendcurrencylistener)
    {
        if (c != null && g("spendCurrency"))
        {
            c.spendCurrency(i, tjspendcurrencylistener);
        }
    }

    public final void a(int i, String s)
    {
        gd.a().a(i, s);
    }

    public final void a(Activity activity)
    {
        TapjoyConnectCore.setAutoSessionTrackingStarted(true);
        gd.a().a(activity);
    }

    public final void a(GLSurfaceView glsurfaceview)
    {
        gd.a();
        gd.a(glsurfaceview);
    }

    public final void a(TJEarnedCurrencyListener tjearnedcurrencylistener)
    {
        if (c != null && g("setEarnedCurrencyListener"))
        {
            c.setEarnedCurrencyListener(tjearnedcurrencylistener);
        }
    }

    public final void a(TJGetCurrencyBalanceListener tjgetcurrencybalancelistener)
    {
        if (c != null && g("getCurrencyBalance"))
        {
            c.getCurrencyBalance(tjgetcurrencybalancelistener);
        }
    }

    public final void a(TJOffersListener tjofferslistener)
    {
        if (d != null && g("showOffers"))
        {
            d.showOffers(tjofferslistener);
        }
    }

    public final void a(TJVideoListener tjvideolistener)
    {
        if (h("setVideoListener"))
        {
            TJAdUnit.publisherVideoListener = tjvideolistener;
        }
    }

    public final void a(TJViewListener tjviewlistener)
    {
        if (h("setTapjoyViewListener"))
        {
            TapjoyConnectCore.getInstance().setTapjoyViewListener(tjviewlistener);
        }
    }

    public final void a(String s)
    {
        ft.a(null, s, null, null, 0L);
    }

    public final void a(String s, long l)
    {
        ft.a(null, s, null, null, l);
    }

    public final void a(String s, String s1)
    {
        ft.a(s, null, null, s1);
    }

    public final void a(String s, String s1, double d1, String s2)
    {
        gd.a().a(s, s1, d1, s2);
    }

    public final void a(String s, String s1, long l)
    {
        ft.a(s, s1, null, null, l);
    }

    public final void a(String s, String s1, String s2, String s3)
    {
        ft.a(s, s1, s2, s3);
    }

    public final void a(String s, String s1, String s2, String s3, long l)
    {
        ft.a(s, s1, s2, s3, l);
    }

    public final void a(String s, String s1, String s2, String s3, String s4, long l)
    {
        ft.a(s, s1, s2, s3, s4, l, null, 0L, null, 0L);
    }

    public final void a(String s, String s1, String s2, String s3, String s4, long l, 
            String s5, long l1)
    {
        ft.a(s, s1, s2, s3, s4, l, s5, l1, null, 0L);
    }

    public final void a(String s, String s1, String s2, String s3, String s4, long l, 
            String s5, long l1, String s6, long l2)
    {
        ft.a(s, s1, s2, s3, s4, l, s5, l1, s6, l2);
    }

    public final void a(String s, String s1, String s2, String s3, Map map)
    {
        gd.a().a(s, s1, s2, s3, map);
    }

    public final void a(String s, boolean flag)
    {
        if (d != null && g("showOffersWithCurrencyID"))
        {
            d.showOffersWithCurrencyID(s, flag, null);
        }
    }

    public final void a(String s, boolean flag, TJOffersListener tjofferslistener)
    {
        if (d != null && g("showOffersWithCurrencyID"))
        {
            d.showOffersWithCurrencyID(s, flag, tjofferslistener);
        }
    }

    public final void a(boolean flag)
    {
        TapjoyLog.setDebugEnabled(flag);
    }

    public final boolean a(Context context, String s)
    {
        return a(context, s, ((Hashtable) (null)), ((TJConnectListener) (null)));
    }

    public boolean a(Context context, String s, Hashtable hashtable, TJConnectListener tjconnectlistener)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        TapjoyConnectCore.setSDKType("event");
        FiveRocksIntegration.a(hashtable);
        TapjoyConnectCore.requestTapjoyConnect(context, s, hashtable, new TJConnectListener(context, tjconnectlistener) {

            final Context a;
            final TJConnectListener b;
            final eg c;

            public final void onConnectFailure()
            {
                if (b != null)
                {
                    b.onConnectFailure();
                }
            }

            public final void onConnectSuccess()
            {
                eg.a(c, new TJCurrency(a));
                eg.a(c, new TJCOffers(a));
                eg.a(c, new TapjoyCache(a));
                try
                {
                    TJEventOptimizer.init(a);
                }
                catch (InterruptedException interruptedexception)
                {
                    onConnectFailure();
                    return;
                }
                c.a = true;
                if (b != null)
                {
                    b.onConnectSuccess();
                }
            }

            
            {
                c = eg.this;
                a = context;
                b = tjconnectlistener;
                super();
            }
        });
        b = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        context;
        Log.e("TapjoyAPI", (new StringBuilder("IntegrationException: ")).append(context.getMessage()).toString());
        if (tjconnectlistener == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        tjconnectlistener.onConnectFailure();
        break MISSING_BLOCK_LABEL_131;
        context;
        Log.e("TapjoyAPI", (new StringBuilder("TapjoyException: ")).append(context.getMessage()).toString());
        if (tjconnectlistener == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        tjconnectlistener.onConnectFailure();
        flag = false;
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String b()
    {
        return "11.2.2";
    }

    public final void b(int i)
    {
        gd.a().b(i);
    }

    public final void b(Activity activity)
    {
        gd.a().b(activity);
    }

    public final void b(String s)
    {
        if (h("setUserID"))
        {
            TapjoyConnectCore.setUserID(s);
            gd.a().g(s);
        }
    }

    public final void b(String s, String s1, String s2, String s3)
    {
        ft.a(s, s1, s2, s3, 0L);
    }

    public final void b(boolean flag)
    {
        gd.a().c(flag);
    }

    public final void c()
    {
        if (d != null && g("showOffers"))
        {
            d.showOffers(null);
        }
    }

    public final void c(String s)
    {
        gd.a().f(s);
    }

    public final float d()
    {
        if (h("getCurrencyMultiplier"))
        {
            return TapjoyConnectCore.getInstance().getCurrencyMultiplier();
        } else
        {
            return 1.0F;
        }
    }

    public final void d(String s)
    {
        if (g("enablePaidAppWithActionID"))
        {
            TapjoyConnectCore.getInstance().enablePaidAppWithActionID(s);
        }
    }

    public final void e()
    {
        if (h("startSession"))
        {
            TapjoyConnectCore.getInstance().appResume();
            gd.a().g();
        }
    }

    public final void e(String s)
    {
        if (g("actionComplete"))
        {
            TapjoyConnectCore.getInstance().actionComplete(s);
        }
    }

    public final void f()
    {
        if (h("endSession"))
        {
            TapjoyConnectCore.setAutoSessionTrackingStarted(false);
            TapjoyConnectCore.getInstance().appPause();
            gd.a().h();
        }
    }

    public final void f(String s)
    {
        gd.a().b(s);
    }

    public final boolean g()
    {
        return gd.a().e();
    }

    public final boolean h()
    {
        return a;
    }
}

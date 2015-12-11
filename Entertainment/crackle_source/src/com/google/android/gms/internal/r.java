// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;

// Referenced classes of package com.google.android.gms.internal:
//            al, av, bn, bq, 
//            q, s, cs, ct, 
//            co, ab, x, cj, 
//            cu, au, az, cw, 
//            at, bc, ck, eg, 
//            v, aw, cx, bu, 
//            ae, bm, bk, cm, 
//            bb, h, g

public final class r extends ac.a
    implements al, av, bn, bq, bu.a, q
{
    private static final class a
    {

        public final String adUnitId;
        public final ViewSwitcher eg;
        public final Context eh;
        public final h ei;
        public final cu ej;
        public ab ek;
        public cm el;
        public x em;
        public cj en;
        public ae eo;

        public a(Context context, x x1, String s1, cu cu1)
        {
            if (x1.eG)
            {
                eg = null;
            } else
            {
                eg = new ViewSwitcher(context);
                eg.setMinimumWidth(x1.widthPixels);
                eg.setMinimumHeight(x1.heightPixels);
                eg.setVisibility(4);
            }
            em = x1;
            adUnitId = s1;
            eh = context;
            ei = new h(g.a(cu1.iJ, context));
            ej = cu1;
        }
    }


    private final bb ed;
    private final a ee;
    private final s ef = new s(this);

    public r(Context context, x x1, String s1, bb bb, cu cu1)
    {
        ee = new a(context, x1, s1, cu1);
        ed = bb;
        ct.t((new StringBuilder()).append("Use AdRequest.Builder.addTestDevice(\"").append(cs.l(context)).append("\") to get test ads on this device.").toString());
        co.i(context);
    }

    private void I()
    {
        ct.t("Ad closing.");
        if (ee.ek == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ee.ek.onAdClosed();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.ct.b("Could not call AdListener.onAdClosed().", remoteexception);
        return;
    }

    private void J()
    {
        ct.t("Ad leaving application.");
        if (ee.ek == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ee.ek.onAdLeftApplication();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.ct.b("Could not call AdListener.onAdLeftApplication().", remoteexception);
        return;
    }

    private void K()
    {
        ct.t("Ad opening.");
        if (ee.ek == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ee.ek.onAdOpened();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.ct.b("Could not call AdListener.onAdOpened().", remoteexception);
        return;
    }

    private void L()
    {
        ct.t("Ad finished loading.");
        if (ee.ek == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ee.ek.onAdLoaded();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.ct.b("Could not call AdListener.onAdLoaded().", remoteexception);
        return;
    }

    private boolean M()
    {
        boolean flag = true;
        if (!co.a(ee.eh.getPackageManager(), ee.eh.getPackageName(), "android.permission.INTERNET"))
        {
            if (!ee.em.eG)
            {
                cs.a(ee.eg, ee.em, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            flag = false;
        }
        if (!co.h(ee.eh))
        {
            if (!ee.em.eG)
            {
                cs.a(ee.eg, ee.em, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            flag = false;
        }
        if (!flag && !ee.em.eG)
        {
            ee.eg.setVisibility(0);
        }
        return flag;
    }

    private void N()
    {
        if (ee.en == null)
        {
            ct.v("Ad state was null when trying to ping click URLs.");
        } else
        {
            ct.r("Pinging click URLs.");
            if (ee.en.fK != null)
            {
                co.a(ee.eh, ee.ej.iJ, ee.en.fK);
            }
            if (ee.en.is != null && ee.en.is.fK != null)
            {
                az.a(ee.eh, ee.ej.iJ, ee.en, ee.adUnitId, false, ee.en.is.fK);
                return;
            }
        }
    }

    private void O()
    {
        if (ee.en != null)
        {
            ee.en.gJ.destroy();
            ee.en = null;
        }
    }

    private void a(int i)
    {
        ct.v((new StringBuilder()).append("Failed to load ad: ").append(i).toString());
        if (ee.ek == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        ee.ek.onAdFailedToLoad(i);
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.ct.b("Could not call AdListener.onAdFailedToLoad().", remoteexception);
        return;
    }

    private void b(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -2);
        ee.eg.addView(view, layoutparams);
    }

    private void b(boolean flag)
    {
        if (ee.en == null)
        {
            ct.v("Ad state was null when trying to ping impression URLs.");
        } else
        {
            ct.r("Pinging Impression URLs.");
            if (ee.en.fL != null)
            {
                co.a(ee.eh, ee.ej.iJ, ee.en.fL);
            }
            if (ee.en.is != null && ee.en.is.fL != null)
            {
                az.a(ee.eh, ee.ej.iJ, ee.en, ee.adUnitId, flag, ee.en.is.fL);
            }
            if (ee.en.gb != null && ee.en.gb.fG != null)
            {
                az.a(ee.eh, ee.ej.iJ, ee.en, ee.adUnitId, flag, ee.en.gb.fG);
                return;
            }
        }
    }

    private boolean b(cj cj1)
    {
        if (cj1.hy)
        {
            View view;
            try
            {
                cj1 = (View)com.google.android.gms.dynamic.c.b(cj1.gc.getView());
            }
            // Misplaced declaration of an exception variable
            catch (cj cj1)
            {
                com.google.android.gms.internal.ct.b("Could not get View from mediation adapter.", cj1);
                return false;
            }
            view = ee.eg.getNextView();
            if (view != null)
            {
                ee.eg.removeView(view);
            }
            try
            {
                b(((View) (cj1)));
            }
            // Misplaced declaration of an exception variable
            catch (cj cj1)
            {
                com.google.android.gms.internal.ct.b("Could not add mediation view to view hierarchy.", cj1);
                return false;
            }
        } else
        if (cj1.it != null)
        {
            cj1.gJ.a(cj1.it);
            ee.eg.removeAllViews();
            ee.eg.setMinimumWidth(cj1.it.widthPixels);
            ee.eg.setMinimumHeight(cj1.it.heightPixels);
            b(((View) (cj1.gJ)));
        }
        if (ee.eg.getChildCount() > 1)
        {
            ee.eg.showNext();
        }
        if (ee.en != null)
        {
            cj1 = ee.eg.getNextView();
            if (cj1 instanceof cw)
            {
                ((cw)cj1).a(ee.eh, ee.em);
            } else
            if (cj1 != null)
            {
                ee.eg.removeView(cj1);
            }
            if (ee.en.gc != null)
            {
                try
                {
                    ee.en.gc.destroy();
                }
                // Misplaced declaration of an exception variable
                catch (cj cj1)
                {
                    ct.v("Could not destroy previous mediation adapter.");
                }
            }
        }
        ee.eg.setVisibility(0);
        return true;
    }

    private bz.a c(v v1)
    {
        ApplicationInfo applicationinfo = ee.eh.getApplicationInfo();
        android.content.pm.PackageInfo packageinfo;
        Object obj;
        try
        {
            packageinfo = ee.eh.getPackageManager().getPackageInfo(applicationinfo.packageName, 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception = null;
        }
        if (!ee.em.eG && ee.eg.getParent() != null)
        {
            int ai[] = new int[2];
            ee.eg.getLocationOnScreen(ai);
            int j = ai[0];
            int k = ai[1];
            obj = ee.eh.getResources().getDisplayMetrics();
            int l = ee.eg.getWidth();
            int i1 = ee.eg.getHeight();
            int i;
            if (ee.eg.isShown() && j + l > 0 && k + i1 > 0 && j <= ((DisplayMetrics) (obj)).widthPixels && k <= ((DisplayMetrics) (obj)).heightPixels)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj = new Bundle(5);
            ((Bundle) (obj)).putInt("x", j);
            ((Bundle) (obj)).putInt("y", k);
            ((Bundle) (obj)).putInt("width", l);
            ((Bundle) (obj)).putInt("height", i1);
            ((Bundle) (obj)).putInt("visible", i);
        } else
        {
            obj = null;
        }
        return new bz.a(((Bundle) (obj)), v1, ee.em, ee.adUnitId, applicationinfo, packageinfo, ck.ar(), ck.iu, ee.ej);
    }

    public void A()
    {
        if (ee.em.eG)
        {
            O();
        }
        I();
    }

    public void B()
    {
        if (ee.em.eG)
        {
            b(false);
        }
        K();
    }

    public void C()
    {
        w();
    }

    public void D()
    {
        A();
    }

    public void E()
    {
        z();
    }

    public void F()
    {
        B();
    }

    public void G()
    {
        if (ee.en != null)
        {
            ct.v((new StringBuilder()).append("Mediation adapter ").append(ee.en.gd).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        b(true);
        L();
    }

    public void H()
    {
        eg.N("recordManualImpression must be called on the main UI thread.");
        if (ee.en == null)
        {
            ct.v("Ad state was null when trying to ping manual tracking URLs.");
        } else
        {
            ct.r("Pinging manual tracking URLs.");
            if (ee.en.hA != null)
            {
                co.a(ee.eh, ee.ej.iJ, ee.en.hA);
                return;
            }
        }
    }

    public void a(ab ab1)
    {
        eg.N("setAdListener must be called on the main UI thread.");
        ee.ek = ab1;
    }

    public void a(ae ae1)
    {
        eg.N("setAppEventListener must be called on the main UI thread.");
        ee.eo = ae1;
    }

    public void a(cj cj1)
    {
        boolean flag;
        ee.el = null;
        if (cj1.errorCode == -1)
        {
            return;
        }
        if (cj1.hr.extras != null)
        {
            flag = cj1.hr.extras.getBoolean("_noRefresh", false);
        } else
        {
            flag = false;
        }
        if (!ee.em.eG) goto _L2; else goto _L1
_L1:
        co.a(cj1.gJ);
_L4:
        if (cj1.errorCode == 3 && cj1.is != null && cj1.is.fM != null)
        {
            ct.r("Pinging no fill URLs.");
            az.a(ee.eh, ee.ej.iJ, cj1, ee.adUnitId, false, cj1.is.fM);
        }
        if (cj1.errorCode != -2)
        {
            a(cj1.errorCode);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (!flag)
        {
            if (cj1.fO > 0L)
            {
                ef.a(cj1.hr, cj1.fO);
            } else
            if (cj1.is != null && cj1.is.fO > 0L)
            {
                ef.a(cj1.hr, cj1.is.fO);
            } else
            if (!cj1.hy && cj1.errorCode == 2)
            {
                ef.d(cj1.hr);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!ee.em.eG && !b(cj1))
        {
            a(0);
            return;
        }
        if (ee.en != null && ee.en.ge != null)
        {
            ee.en.ge.a(null);
        }
        if (cj1.ge != null)
        {
            cj1.ge.a(this);
        }
        ee.en = cj1;
        if (cj1.it != null)
        {
            ee.em = cj1.it;
        }
        if (!ee.em.eG)
        {
            b(false);
        }
        L();
        return;
    }

    public void a(x x1)
    {
        eg.N("setAdSize must be called on the main UI thread.");
        ee.em = x1;
        if (ee.en != null)
        {
            ee.en.gJ.a(x1);
        }
        if (ee.eg.getChildCount() > 1)
        {
            ee.eg.removeView(ee.eg.getNextView());
        }
        ee.eg.setMinimumWidth(x1.widthPixels);
        ee.eg.setMinimumHeight(x1.heightPixels);
        ee.eg.requestLayout();
    }

    public boolean a(v v1)
    {
        eg.N("loadAd must be called on the main UI thread.");
        if (ee.el == null) goto _L2; else goto _L1
_L1:
        ct.v("An ad request is already in progress. Aborting.");
_L4:
        return false;
_L2:
        if (ee.em.eG && ee.en != null)
        {
            ct.v("An interstitial is already loading. Aborting.");
            return false;
        }
        if (!M()) goto _L4; else goto _L3
_L3:
        bz.a a1;
        ct.t("Starting ad request.");
        ef.cancel();
        a1 = c(v1);
        if (!ee.em.eG) goto _L6; else goto _L5
_L5:
        v1 = cw.a(ee.eh, ee.em, false, false, ee.ei, ee.ej);
        v1.aC().a(this, null, this, this, true);
_L8:
        ee.el = bu.a(ee.eh, a1, ee.ei, v1, ed, this);
        return true;
_L6:
        v1 = ee.eg.getNextView();
        if (!(v1 instanceof cw))
        {
            break; /* Loop/switch isn't completed */
        }
        v1 = (cw)v1;
        v1.a(ee.eh, ee.em);
_L9:
        v1.aC().a(this, this, this, this, false);
        if (true) goto _L8; else goto _L7
_L7:
        if (v1 != null)
        {
            ee.eg.removeView(v1);
        }
        cw cw1 = cw.a(ee.eh, ee.em, false, false, ee.ei, ee.ej);
        v1 = cw1;
        if (ee.em.eH == null)
        {
            b(cw1);
            v1 = cw1;
        }
          goto _L9
        if (true) goto _L8; else goto _L10
_L10:
    }

    public void b(v v1)
    {
        android.view.ViewParent viewparent = ee.eg.getParent();
        if ((viewparent instanceof View) && ((View)viewparent).isShown() && co.at())
        {
            a(v1);
            return;
        } else
        {
            ct.t("Ad is not visible. Not refreshing ad.");
            ef.d(v1);
            return;
        }
    }

    public void destroy()
    {
        eg.N("destroy must be called on the main UI thread.");
        ee.ek = null;
        ee.eo = null;
        ef.cancel();
        stopLoading();
        if (ee.eg != null)
        {
            ee.eg.removeAllViews();
        }
        if (ee.en != null && ee.en.gJ != null)
        {
            ee.en.gJ.destroy();
        }
    }

    public boolean isReady()
    {
        eg.N("isLoaded must be called on the main UI thread.");
        return ee.el == null && ee.en != null;
    }

    public void onAppEvent(String s1, String s2)
    {
        if (ee.eo == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        ee.eo.onAppEvent(s1, s2);
        return;
        s1;
        com.google.android.gms.internal.ct.b("Could not call the AppEventListener.", s1);
        return;
    }

    public void pause()
    {
        eg.N("pause must be called on the main UI thread.");
        if (ee.en != null)
        {
            co.a(ee.en.gJ);
        }
    }

    public void resume()
    {
        eg.N("resume must be called on the main UI thread.");
        if (ee.en != null)
        {
            com.google.android.gms.internal.co.b(ee.en.gJ);
        }
    }

    public void showInterstitial()
    {
        eg.N("showInterstitial must be called on the main UI thread.");
        if (!ee.em.eG)
        {
            ct.v("Cannot call showInterstitial on a banner ad.");
            return;
        }
        if (ee.en == null)
        {
            ct.v("The interstitial has not loaded.");
            return;
        }
        if (ee.en.gJ.aF())
        {
            ct.v("The interstitial is already showing.");
            return;
        }
        ee.en.gJ.l(true);
        if (ee.en.hy)
        {
            try
            {
                ee.en.gc.showInterstitial();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ct.b("Could not show interstitial.", remoteexception);
            }
            O();
            return;
        } else
        {
            bm bm1 = new bm(this, this, this, ee.en.gJ, ee.en.orientation, ee.ej);
            bk.a(ee.eh, bm1);
            return;
        }
    }

    public void stopLoading()
    {
        eg.N("stopLoading must be called on the main UI thread.");
        if (ee.en != null)
        {
            ee.en.gJ.stopLoading();
            ee.en = null;
        }
        if (ee.el != null)
        {
            ee.el.cancel();
        }
    }

    public void w()
    {
        N();
    }

    public b x()
    {
        eg.N("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.c.h(ee.eg);
    }

    public x y()
    {
        eg.N("getAdSize must be called on the main UI thread.");
        return ee.em;
    }

    public void z()
    {
        J();
    }
}

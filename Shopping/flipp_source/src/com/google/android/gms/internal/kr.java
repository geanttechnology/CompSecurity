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
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;

// Referenced classes of package com.google.android.gms.internal:
//            g, ap, ci, cn, 
//            cy, kq, u, ks, 
//            kt, er, et, ej, 
//            c, eb, cu, ao, 
//            av, an, x, dk, 
//            ec, bq, ew, ha, 
//            v, aq, l, ez, 
//            cz, ee, eg, bm, 
//            cd, bn

public final class kr extends g
    implements ap, ci, cn, cy, kq, u
{

    final ks a;
    final kt b = new kt(this);
    private final bn c;

    public kr(Context context, x x1, String s1, bn bn, cu cu1)
    {
        a = new ks(context, x1, s1, cu1);
        c = bn;
        et.b((new StringBuilder("Use AdRequest.Builder.addTestDevice(\"")).append(com.google.android.gms.internal.er.a(context)).append("\") to get test ads on this device.").toString());
        ej.b(context);
    }

    private void a(int i1)
    {
        com.google.android.gms.internal.et.d((new StringBuilder("Failed to load ad: ")).append(i1).toString());
        if (a.f == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        a.f.a(i1);
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.et.a("Could not call AdListener.onAdFailedToLoad().", remoteexception);
        return;
    }

    private void a(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -2);
        a.a.addView(view, layoutparams);
    }

    private void a(boolean flag)
    {
        if (a.i == null)
        {
            com.google.android.gms.internal.et.d("Ad state was null when trying to ping impression URLs.");
        } else
        {
            com.google.android.gms.internal.et.a("Pinging Impression URLs.");
            if (a.i.e != null)
            {
                com.google.android.gms.internal.ej.a(a.c, a.e.b, a.i.e);
            }
            if (a.i.n != null && a.i.n.d != null)
            {
                com.google.android.gms.internal.av.a(a.c, a.e.b, a.i, a.b, flag, a.i.n.d);
            }
            if (a.i.k != null && a.i.k.e != null)
            {
                com.google.android.gms.internal.av.a(a.c, a.e.b, a.i, a.b, flag, a.i.k.e);
                return;
            }
        }
    }

    private dk b(v v1)
    {
        ApplicationInfo applicationinfo = a.c.getApplicationInfo();
        android.content.pm.PackageInfo packageinfo;
        Object obj;
        try
        {
            packageinfo = a.c.getPackageManager().getPackageInfo(applicationinfo.packageName, 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception = null;
        }
        if (!a.h.e && a.a.getParent() != null)
        {
            int ai[] = new int[2];
            a.a.getLocationOnScreen(ai);
            int j1 = ai[0];
            int k1 = ai[1];
            obj = a.c.getResources().getDisplayMetrics();
            int l1 = a.a.getWidth();
            int i2 = a.a.getHeight();
            int i1;
            if (a.a.isShown() && j1 + l1 > 0 && k1 + i2 > 0 && j1 <= ((DisplayMetrics) (obj)).widthPixels && k1 <= ((DisplayMetrics) (obj)).heightPixels)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            obj = new Bundle(5);
            ((Bundle) (obj)).putInt("x", j1);
            ((Bundle) (obj)).putInt("y", k1);
            ((Bundle) (obj)).putInt("width", l1);
            ((Bundle) (obj)).putInt("height", i2);
            ((Bundle) (obj)).putInt("visible", i1);
        } else
        {
            obj = null;
        }
        return new dk(((Bundle) (obj)), v1, a.h, a.b, applicationinfo, packageinfo, com.google.android.gms.internal.ec.a(), com.google.android.gms.internal.ec.a, a.e);
    }

    private boolean b(eb eb1)
    {
        if (eb1.j)
        {
            View view;
            try
            {
                eb1 = (View)com.google.android.gms.a.d.a(eb1.l.a());
            }
            // Misplaced declaration of an exception variable
            catch (eb eb1)
            {
                com.google.android.gms.internal.et.a("Could not get View from mediation adapter.", eb1);
                return false;
            }
            view = a.a.getNextView();
            if (view != null)
            {
                a.a.removeView(view);
            }
            try
            {
                a(eb1);
            }
            // Misplaced declaration of an exception variable
            catch (eb eb1)
            {
                com.google.android.gms.internal.et.a("Could not add mediation view to view hierarchy.", eb1);
                return false;
            }
        } else
        if (eb1.q != null)
        {
            eb1.b.a(eb1.q);
            a.a.removeAllViews();
            a.a.setMinimumWidth(eb1.q.g);
            a.a.setMinimumHeight(eb1.q.d);
            a(eb1.b);
        }
        if (a.a.getChildCount() > 1)
        {
            a.a.showNext();
        }
        if (a.i != null)
        {
            eb1 = a.a.getNextView();
            if (eb1 instanceof ew)
            {
                ((ew)eb1).a(a.c, a.h);
            } else
            if (eb1 != null)
            {
                a.a.removeView(eb1);
            }
            if (a.i.l != null)
            {
                try
                {
                    a.i.l.c();
                }
                // Misplaced declaration of an exception variable
                catch (eb eb1)
                {
                    com.google.android.gms.internal.et.d("Could not destroy previous mediation adapter.");
                }
            }
        }
        a.a.setVisibility(0);
        return true;
    }

    private void s()
    {
        et.b("Ad finished loading.");
        if (a.f == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        a.f.c();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.et.a("Could not call AdListener.onAdLoaded().", remoteexception);
        return;
    }

    private void t()
    {
        if (a.i != null)
        {
            a.i.b.destroy();
            a.i = null;
        }
    }

    public final a a()
    {
        com.google.android.gms.internal.ha.a("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.a.d.a(a.a);
    }

    public final void a(c c1)
    {
        com.google.android.gms.internal.ha.a("setAdListener must be called on the main UI thread.");
        a.f = c1;
    }

    public final void a(eb eb1)
    {
        boolean flag;
        a.g = null;
        if (eb1.d == -1)
        {
            return;
        }
        if (eb1.a.c != null)
        {
            flag = eb1.a.c.getBoolean("_noRefresh", false);
        } else
        {
            flag = false;
        }
        if (!a.h.e) goto _L2; else goto _L1
_L1:
        com.google.android.gms.internal.ej.a(eb1.b);
_L4:
        if (eb1.d == 3 && eb1.n != null && eb1.n.e != null)
        {
            com.google.android.gms.internal.et.a("Pinging no fill URLs.");
            com.google.android.gms.internal.av.a(a.c, a.e.b, eb1, a.b, false, eb1.n.e);
        }
        if (eb1.d != -2)
        {
            a(eb1.d);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (!flag)
        {
            if (eb1.h > 0L)
            {
                b.a(eb1.a, eb1.h);
            } else
            if (eb1.n != null && eb1.n.g > 0L)
            {
                b.a(eb1.a, eb1.n.g);
            } else
            if (!eb1.j && eb1.d == 2)
            {
                b.a(eb1.a);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!a.h.e && !b(eb1))
        {
            a(0);
            return;
        }
        if (a.i != null && a.i.o != null)
        {
            a.i.o.a(null);
        }
        if (eb1.o != null)
        {
            eb1.o.a(this);
        }
        a.i = eb1;
        if (eb1.q != null)
        {
            a.h = eb1.q;
        }
        if (!a.h.e)
        {
            a(false);
        }
        s();
        return;
    }

    public final void a(l l1)
    {
        com.google.android.gms.internal.ha.a("setAppEventListener must be called on the main UI thread.");
        a.j = l1;
    }

    public final void a(x x1)
    {
        com.google.android.gms.internal.ha.a("setAdSize must be called on the main UI thread.");
        a.h = x1;
        if (a.i != null)
        {
            a.i.b.a(x1);
        }
        if (a.a.getChildCount() > 1)
        {
            a.a.removeView(a.a.getNextView());
        }
        a.a.setMinimumWidth(x1.g);
        a.a.setMinimumHeight(x1.d);
        a.a.requestLayout();
    }

    public final void a(String s1, String s2)
    {
        if (a.j == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        a.j.a(s1, s2);
        return;
        s1;
        com.google.android.gms.internal.et.a("Could not call the AppEventListener.", s1);
        return;
    }

    public final boolean a(v v1)
    {
        com.google.android.gms.internal.ha.a("loadAd must be called on the main UI thread.");
        if (a.g == null) goto _L2; else goto _L1
_L1:
        com.google.android.gms.internal.et.d("An ad request is already in progress. Aborting.");
_L4:
        return false;
_L2:
        if (a.h.e && a.i != null)
        {
            com.google.android.gms.internal.et.d("An interstitial is already loading. Aborting.");
            return false;
        }
        Object obj;
        dk dk1;
        boolean flag;
        if (!com.google.android.gms.internal.ej.a(a.c.getPackageManager(), a.c.getPackageName(), "android.permission.INTERNET"))
        {
            if (!a.h.e)
            {
                com.google.android.gms.internal.er.a(a.a, a.h, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            flag = false;
        } else
        {
            flag = true;
        }
        if (!com.google.android.gms.internal.ej.a(a.c))
        {
            if (!a.h.e)
            {
                com.google.android.gms.internal.er.a(a.a, a.h, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            flag = false;
        }
        if (!flag && !a.h.e)
        {
            a.a.setVisibility(0);
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        et.b("Starting ad request.");
        b.a();
        dk1 = b(v1);
        if (!a.h.e) goto _L6; else goto _L5
_L5:
        v1 = com.google.android.gms.internal.ew.a(a.c, a.h, false, false, a.d, a.e);
        ((ew) (v1)).a.a(this, null, this, this, true);
_L8:
        obj = a;
        v1 = new cz(a.c, dk1, a.d, v1, c, this);
        com.google.android.gms.internal.eg.a(((ee) (v1)).e);
        obj.g = v1;
        return true;
_L6:
        v1 = a.a.getNextView();
        if (!(v1 instanceof ew))
        {
            break; /* Loop/switch isn't completed */
        }
        v1 = (ew)v1;
        v1.a(a.c, a.h);
_L9:
        ((ew) (v1)).a.a(this, this, this, this, false);
        if (true) goto _L8; else goto _L7
_L7:
        if (v1 != null)
        {
            a.a.removeView(v1);
        }
        obj = com.google.android.gms.internal.ew.a(a.c, a.h, false, false, a.d, a.e);
        v1 = ((v) (obj));
        if (a.h.h == null)
        {
            a(((View) (obj)));
            v1 = ((v) (obj));
        }
          goto _L9
        if (true) goto _L8; else goto _L10
_L10:
    }

    public final void b()
    {
        com.google.android.gms.internal.ha.a("destroy must be called on the main UI thread.");
        a.f = null;
        a.j = null;
        b.a();
        g();
        if (a.a != null)
        {
            a.a.removeAllViews();
        }
        if (a.i != null && a.i.b != null)
        {
            a.i.b.destroy();
        }
    }

    public final boolean c()
    {
        com.google.android.gms.internal.ha.a("isLoaded must be called on the main UI thread.");
        return a.g == null && a.i != null;
    }

    public final void d()
    {
        com.google.android.gms.internal.ha.a("pause must be called on the main UI thread.");
        if (a.i != null)
        {
            com.google.android.gms.internal.ej.a(a.i.b);
        }
    }

    public final void e()
    {
        com.google.android.gms.internal.ha.a("resume must be called on the main UI thread.");
        if (a.i != null)
        {
            ej.b(a.i.b);
        }
    }

    public final void f()
    {
        com.google.android.gms.internal.ha.a("showInterstitial must be called on the main UI thread.");
        if (!a.h.e)
        {
            com.google.android.gms.internal.et.d("Cannot call showInterstitial on a banner ad.");
            return;
        }
        if (a.i == null)
        {
            com.google.android.gms.internal.et.d("The interstitial has not loaded.");
            return;
        }
        if (a.i.b.d())
        {
            com.google.android.gms.internal.et.d("The interstitial is already showing.");
            return;
        }
        a.i.b.a(true);
        if (a.i.j)
        {
            try
            {
                a.i.l.b();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.et.a("Could not show interstitial.", remoteexception);
            }
            t();
            return;
        } else
        {
            bm bm1 = new bm(this, this, this, a.i.b, a.i.g, a.e);
            com.google.android.gms.internal.cd.a(a.c, bm1);
            return;
        }
    }

    public final void g()
    {
        com.google.android.gms.internal.ha.a("stopLoading must be called on the main UI thread.");
        if (a.i != null)
        {
            a.i.b.stopLoading();
            a.i = null;
        }
        if (a.g != null)
        {
            a.g.e();
        }
    }

    public final void h()
    {
        com.google.android.gms.internal.ha.a("recordManualImpression must be called on the main UI thread.");
        if (a.i == null)
        {
            com.google.android.gms.internal.et.d("Ad state was null when trying to ping manual tracking URLs.");
        } else
        {
            com.google.android.gms.internal.et.a("Pinging manual tracking URLs.");
            if (a.i.f != null)
            {
                com.google.android.gms.internal.ej.a(a.c, a.e.b, a.i.f);
                return;
            }
        }
    }

    public final x i()
    {
        com.google.android.gms.internal.ha.a("getAdSize must be called on the main UI thread.");
        return a.h;
    }

    public final void j()
    {
        r();
    }

    public final void k()
    {
        o();
    }

    public final void l()
    {
        q();
    }

    public final void m()
    {
        p();
    }

    public final void n()
    {
        if (a.i != null)
        {
            com.google.android.gms.internal.et.d((new StringBuilder("Mediation adapter ")).append(a.i.m).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        a(true);
        s();
    }

    public final void o()
    {
        if (a.h.e)
        {
            t();
        }
        et.b("Ad closing.");
        if (a.f == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        a.f.a();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.et.a("Could not call AdListener.onAdClosed().", remoteexception);
        return;
    }

    public final void p()
    {
        if (a.h.e)
        {
            a(false);
        }
        et.b("Ad opening.");
        if (a.f == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        a.f.d();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.et.a("Could not call AdListener.onAdOpened().", remoteexception);
        return;
    }

    public final void q()
    {
        et.b("Ad leaving application.");
        if (a.f == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        a.f.b();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.et.a("Could not call AdListener.onAdLeftApplication().", remoteexception);
        return;
    }

    public final void r()
    {
        if (a.i == null)
        {
            com.google.android.gms.internal.et.d("Ad state was null when trying to ping click URLs.");
        } else
        {
            com.google.android.gms.internal.et.a("Pinging click URLs.");
            if (a.i.c != null)
            {
                com.google.android.gms.internal.ej.a(a.c, a.e.b, a.i.c);
            }
            if (a.i.n != null && a.i.n.c != null)
            {
                com.google.android.gms.internal.av.a(a.c, a.e.b, a.i, a.b, false, a.i.n.c);
                return;
            }
        }
    }
}

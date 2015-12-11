// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ahi extends tr
    implements aab, abk, ahh, aho, vb, ve, vg, vw, xh, xj, yd, zh
{

    private av a;
    private final wd b;
    private final ahk c;
    private final sk d;
    private final so e;
    private boolean f;
    private final ComponentCallbacks g;

    ahi(ahk ahk1, wd wd, sk sk1)
    {
        g = new ComponentCallbacks() {

            final ahi a;

            public void onConfigurationChanged(Configuration configuration)
            {
                if (ahi.a(a) != null && ahi.a(a).j != null && ahi.a(a).j.b != null)
                {
                    ahi.a(a).j.b.a();
                }
            }

            public void onLowMemory()
            {
            }

            
            {
                a = ahi.this;
                super();
            }
        };
        c = ahk1;
        b = wd;
        if (sk1 == null)
        {
            sk1 = new sk(this);
        }
        d = sk1;
        e = new so();
        abq.b(c.c);
        abi.a(c.c, c.e);
        w();
    }

    public ahi(Context context, ay ay1, String s1, wd wd, gs gs1)
    {
        this(new ahk(context, ay1, s1, gs1), wd, null);
    }

    private void A()
    {
        acb.c("Ad opening.");
        if (c.f == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        c.f.d();
        return;
        RemoteException remoteexception;
        remoteexception;
        acb.d("Could not call AdListener.onAdOpened().", remoteexception);
        return;
    }

    private void B()
    {
        acb.c("Ad finished loading.");
        if (c.f == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        c.f.c();
        return;
        RemoteException remoteexception;
        remoteexception;
        acb.d("Could not call AdListener.onAdLoaded().", remoteexception);
        return;
    }

    private void C()
    {
        try
        {
            if ((c.j.w instanceof uq) && c.p != null)
            {
                c.p.a((uq)c.j.w);
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", remoteexception);
        }
    }

    private void D()
    {
        try
        {
            if ((c.j.w instanceof ur) && c.q != null)
            {
                c.q.a((ur)c.j.w);
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", remoteexception);
        }
    }

    private void E()
    {
        if (c.j != null)
        {
            if (c.w == 0)
            {
                c.j.b.destroy();
            }
            c.j = null;
            c.y = false;
        }
    }

    private aak a(av av1, Bundle bundle)
    {
        ApplicationInfo applicationinfo = c.c.getApplicationInfo();
        android.content.pm.PackageInfo packageinfo;
        Object obj;
        String s1;
        Bundle bundle1;
        try
        {
            packageinfo = c.c.getPackageManager().getPackageInfo(applicationinfo.packageName, 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception = null;
        }
        s1 = null;
        obj = s1;
        if (!c.i.e)
        {
            obj = s1;
            if (c.a.getParent() != null)
            {
                obj = new int[2];
                c.a.getLocationOnScreen(((int []) (obj)));
                int j1 = obj[0];
                int k1 = obj[1];
                obj = c.c.getResources().getDisplayMetrics();
                int l1 = c.a.getWidth();
                int i2 = c.a.getHeight();
                boolean flag = false;
                int i1 = ((flag) ? 1 : 0);
                if (c.a.isShown())
                {
                    i1 = ((flag) ? 1 : 0);
                    if (j1 + l1 > 0)
                    {
                        i1 = ((flag) ? 1 : 0);
                        if (k1 + i2 > 0)
                        {
                            i1 = ((flag) ? 1 : 0);
                            if (j1 <= ((DisplayMetrics) (obj)).widthPixels)
                            {
                                i1 = ((flag) ? 1 : 0);
                                if (k1 <= ((DisplayMetrics) (obj)).heightPixels)
                                {
                                    i1 = 1;
                                }
                            }
                        }
                    }
                }
                obj = new Bundle(5);
                ((Bundle) (obj)).putInt("x", j1);
                ((Bundle) (obj)).putInt("y", k1);
                ((Bundle) (obj)).putInt("width", l1);
                ((Bundle) (obj)).putInt("height", i2);
                ((Bundle) (obj)).putInt("visible", i1);
            }
        }
        s1 = abi.d();
        c.l = new abf(s1, c.b);
        c.l.a(av1);
        bundle1 = abi.a(c.c, this, s1);
        return new aak(((Bundle) (obj)), av1, c.i, c.b, applicationinfo, packageinfo, s1, abi.a, c.e, bundle1, c.s, bundle, abi.j());
    }

    static ahk a(ahi ahi1)
    {
        return ahi1.c;
    }

    private gu a(ahl ahl1)
    {
        Object obj;
        if (c.i.e)
        {
            gu gu1 = gu.a(c.c, c.i, false, false, c.d, c.e);
            gu1.f().a(this, null, this, this, true, this, this, ahl1);
            return gu1;
        }
        obj = c.a.getNextView();
        if (!(obj instanceof gu)) goto _L2; else goto _L1
_L1:
        obj = (gu)obj;
        ((gu) (obj)).a(c.c, c.i);
_L4:
        ((gu) (obj)).f().a(this, this, this, this, false, this, ahl1);
        return ((gu) (obj));
_L2:
        if (obj != null)
        {
            c.a.removeView(((View) (obj)));
        }
        gu gu2 = gu.a(c.c, c.i, false, false, c.d, c.e);
        obj = gu2;
        if (c.i.h == null)
        {
            b(gu2);
            obj = gu2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(int i1)
    {
        acb.e((new StringBuilder()).append("Failed to load ad: ").append(i1).toString());
        if (c.f == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        c.f.a(i1);
        return;
        RemoteException remoteexception;
        remoteexception;
        acb.d("Could not call AdListener.onAdFailedToLoad().", remoteexception);
        return;
    }

    private void b(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -2);
        c.a.addView(view, layoutparams);
    }

    private void b(boolean flag)
    {
        if (c.j == null)
        {
            acb.e("Ad state was null when trying to ping impression URLs.");
        } else
        {
            acb.a("Pinging Impression URLs.");
            c.l.a();
            if (c.j.e != null)
            {
                abq.a(c.c, c.e.b, c.j.e);
            }
            if (c.j.o != null && c.j.o.d != null)
            {
                wb.a(c.c, c.e.b, c.j, c.b, flag, c.j.o.d);
            }
            if (c.j.l != null && c.j.l.f != null)
            {
                wb.a(c.c, c.e.b, c.j, c.b, flag, c.j.l.f);
                return;
            }
        }
    }

    private boolean b(abd abd1)
    {
        if (abd1.k)
        {
            View view;
            try
            {
                abd1 = (View)sb.a(abd1.m.a());
            }
            // Misplaced declaration of an exception variable
            catch (abd abd1)
            {
                acb.d("Could not get View from mediation adapter.", abd1);
                return false;
            }
            view = c.a.getNextView();
            if (view != null)
            {
                c.a.removeView(view);
            }
            try
            {
                b(((View) (abd1)));
            }
            // Misplaced declaration of an exception variable
            catch (abd abd1)
            {
                acb.d("Could not add mediation view to view hierarchy.", abd1);
                return false;
            }
        } else
        if (abd1.r != null)
        {
            abd1.b.a(abd1.r);
            c.a.removeAllViews();
            c.a.setMinimumWidth(abd1.r.g);
            c.a.setMinimumHeight(abd1.r.d);
            b(((View) (abd1.b)));
        }
        if (c.a.getChildCount() > 1)
        {
            c.a.showNext();
        }
        if (c.j != null)
        {
            abd1 = c.a.getNextView();
            if (abd1 instanceof gu)
            {
                ((gu)abd1).a(c.c, c.i);
            } else
            if (abd1 != null)
            {
                c.a.removeView(abd1);
            }
            if (c.j.m != null)
            {
                try
                {
                    c.j.m.c();
                }
                // Misplaced declaration of an exception variable
                catch (abd abd1)
                {
                    acb.e("Could not destroy previous mediation adapter.");
                }
            }
        }
        c.a.setVisibility(0);
        return true;
    }

    private void w()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14 && c != null && c.c != null)
        {
            c.c.registerComponentCallbacks(g);
        }
    }

    private void x()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14 && c != null && c.c != null)
        {
            c.c.unregisterComponentCallbacks(g);
        }
    }

    private void y()
    {
        acb.c("Ad closing.");
        if (c.f == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        c.f.a();
        return;
        RemoteException remoteexception;
        remoteexception;
        acb.d("Could not call AdListener.onAdClosed().", remoteexception);
        return;
    }

    private void z()
    {
        acb.c("Ad leaving application.");
        if (c.f == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        c.f.b();
        return;
        RemoteException remoteexception;
        remoteexception;
        acb.d("Could not call AdListener.onAdLeftApplication().", remoteexception);
        return;
    }

    Bundle a(sy sy1)
    {
        if (sy1 != null)
        {
            if (sy1.e())
            {
                sy1.c();
            }
            sv sv1 = sy1.b();
            if (sv1 != null)
            {
                sy1 = sv1.b();
                acb.a((new StringBuilder()).append("In AdManger: loadAd, ").append(sv1.toString()).toString());
            } else
            {
                sy1 = null;
            }
            if (sy1 != null)
            {
                Bundle bundle = new Bundle(1);
                bundle.putString("fingerprint", sy1);
                bundle.putInt("v", 1);
                return bundle;
            }
        }
        return null;
    }

    public ry a()
    {
        ady.b("getAdFrame must be called on the main UI thread.");
        return sb.a(c.a);
    }

    public void a(abd abd1)
    {
        c.h = null;
        boolean flag;
        if (abd1.w != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (abd1.d != -2 && abd1.d != 3)
        {
            abi.a(c.a());
        }
        if (abd1.d != -1)
        {
            if (a(abd1, flag))
            {
                acb.a("Ad refresh scheduled.");
            }
            if (abd1.d == 3 && abd1.o != null && abd1.o.e != null)
            {
                acb.a("Pinging no fill URLs.");
                wb.a(c.c, c.e.b, abd1, c.b, false, abd1.o.e);
            }
            if (abd1.d != -2)
            {
                a(abd1.d);
                return;
            }
            if (!c.i.e && !flag && c.w == 0)
            {
                if (!b(abd1))
                {
                    a(0);
                    return;
                }
                if (c.a != null)
                {
                    ahj.a(c.a).a(abd1.v);
                }
            }
            if (c.j != null && c.j.p != null)
            {
                c.j.p.a(null);
            }
            if (abd1.p != null)
            {
                abd1.p.a(this);
            }
            e.b(c.j);
            c.j = abd1;
            c.l.a(abd1.t);
            c.l.b(abd1.u);
            c.l.a(c.i.e);
            c.l.b(abd1.k);
            if (!c.i.e && !flag && c.w == 0)
            {
                b(false);
            }
            if (c.u == null)
            {
                c.u = new abl(c.b);
            }
            int i1;
            int j1;
            if (abd1.o != null)
            {
                j1 = abd1.o.h;
                i1 = abd1.o.i;
            } else
            {
                i1 = 0;
                j1 = 0;
            }
            c.u.a(j1, i1);
            if (c.w == 0)
            {
                if (!c.i.e && abd1.b != null && (abd1.b.f().b() || abd1.j != null))
                {
                    sp sp1 = e.a(c.i, c.j);
                    if (abd1.b.f().b() && sp1 != null)
                    {
                        sp1.a(new sj(abd1.b));
                    }
                }
                if (c.j.b != null)
                {
                    c.j.b.a();
                    c.j.b.f().c();
                }
                if (flag)
                {
                    abd1 = abd1.w;
                    if ((abd1 instanceof ur) && c.q != null)
                    {
                        D();
                    } else
                    if ((abd1 instanceof uq) && c.p != null)
                    {
                        C();
                    } else
                    {
                        acb.e("No matching listener for retrieved native ad template.");
                        a(0);
                        return;
                    }
                }
                B();
                return;
            }
            if (c.v != null && abd1.j != null)
            {
                e.a(c.c, c.i, c.j, c.v, c.e);
                return;
            }
        }
    }

    public void a(abe abe1)
    {
        Object obj = null;
        c.g = null;
        c.k = abe1;
        a(((List) (null)));
        gu gu1;
        if (!abe1.b.t)
        {
            ahl ahl1 = new ahl();
            gu1 = a(ahl1);
            ahl1.a(new ahn(abe1, gu1));
            gu1.setOnTouchListener(new android.view.View.OnTouchListener(ahl1) {

                final ahl a;
                final ahi b;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    a.a();
                    return false;
                }

            
            {
                b = ahi.this;
                a = ahl1;
                super();
            }
            });
            gu1.setOnClickListener(new android.view.View.OnClickListener(ahl1) {

                final ahl a;
                final ahi b;

                public void onClick(View view)
                {
                    a.a();
                }

            
            {
                b = ahi.this;
                a = ahl1;
                super();
            }
            });
        } else
        {
            gu1 = null;
        }
        if (abe1.d != null)
        {
            c.i = abe1.d;
        }
        if (abe1.e != -2)
        {
            a(new abd(abe1, gu1, null, null, null, null, null));
            return;
        }
        if (!abe1.b.h && abe1.b.s)
        {
            if (abe1.b.b != null)
            {
                obj = Uri.parse(abe1.b.b).buildUpon().query(null).build().toString();
            }
            obj = new uh(this, ((String) (obj)), abe1.b.c);
            try
            {
                if (c.r != null)
                {
                    c.w = 1;
                    c.r.a(((uj) (obj)));
                    return;
                }
            }
            catch (RemoteException remoteexception)
            {
                acb.d("Could not call the onCustomRenderedAdLoadedListener.", remoteexception);
            }
        }
        c.w = 0;
        c.h = aaa.a(c.c, this, abe1, gu1, b, this);
    }

    public void a(View view)
    {
        c.v = view;
        a(new abd(c.k, null, null, null, null, null, null));
    }

    public void a(ay ay1)
    {
        ady.b("setAdSize must be called on the main UI thread.");
        c.i = ay1;
        if (c.j != null && c.w == 0)
        {
            c.j.b.a(ay1);
        }
        if (c.a.getChildCount() > 1)
        {
            c.a.removeView(c.a.getNextView());
        }
        c.a.setMinimumWidth(ay1.g);
        c.a.setMinimumHeight(ay1.d);
        c.a.requestLayout();
    }

    public void a(String s1, String s2)
    {
        if (c.m == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        c.m.a(s1, s2);
        return;
        s1;
        acb.d("Could not call the AppEventListener.", s1);
        return;
    }

    public void a(String s1, ArrayList arraylist)
    {
        arraylist = new xw(s1, arraylist, c.c, c.e.b);
        if (c.o == null)
        {
            acb.e("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (pu.a(c.c) != 0)
            {
                acb.e("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            }
            if (c.n == null)
            {
                acb.e("PlayStorePurchaseListener is not set.");
                return;
            }
            if (c.t == null)
            {
                acb.e("PlayStorePurchaseVerifier is not initialized.");
                return;
            }
            if (c.x)
            {
                acb.e("An in-app purchase request is already in progress, abort");
                return;
            }
            c.x = true;
            try
            {
                if (!c.n.a(s1))
                {
                    c.x = false;
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                acb.e("Could not start In-App purchase.");
                c.x = false;
                return;
            }
            xx.a(c.c, c.e.e, new ea(c.c, c.t, arraylist, this));
            return;
        }
        try
        {
            c.o.a(arraylist);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            acb.e("Could not start In-App purchase.");
        }
    }

    public void a(String s1, boolean flag, int i1, Intent intent, xy xy)
    {
        try
        {
            if (c.n != null)
            {
                c.n.a(new xz(c.c, s1, flag, i1, intent, xy));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            acb.e("Fail to invoke PlayStorePurchaseListener.");
        }
        aca.a.postDelayed(new Runnable(intent) {

            final Intent a;
            final ahi b;

            public void run()
            {
                if (yc.a(a) == 0 && ahi.a(b).j != null && ahi.a(b).j.b != null && ahi.a(b).j.b.d() != null)
                {
                    ahi.a(b).j.b.d().a();
                }
                ahi.a(b).x = false;
            }

            
            {
                b = ahi.this;
                a = intent;
                super();
            }
        }, 500L);
    }

    public void a(HashSet hashset)
    {
        c.a(hashset);
    }

    public void a(List list)
    {
        ady.b("setNativeTemplates must be called on the main UI thread.");
        c.s = list;
    }

    public void a(tn tn1)
    {
        ady.b("setAdListener must be called on the main UI thread.");
        c.f = tn1;
    }

    public void a(tw tw1)
    {
        ady.b("setAppEventListener must be called on the main UI thread.");
        c.m = tw1;
    }

    public void a(um um1)
    {
        ady.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        c.r = um1;
    }

    public void a(yj yj1)
    {
        ady.b("setInAppPurchaseListener must be called on the main UI thread.");
        c.o = yj1;
    }

    public void a(yv yv1, String s1)
    {
        ady.b("setPlayStorePurchaseParams must be called on the main UI thread.");
        c.t = new ye(s1);
        c.n = yv1;
        if (!abi.h() && yv1 != null)
        {
            (new xv(c.c, c.n, c.t)).e();
        }
    }

    public void a(boolean flag)
    {
        c.y = flag;
    }

    boolean a(abd abd1, boolean flag)
    {
        boolean flag1 = false;
        av av1;
        if (a != null)
        {
            av1 = a;
            a = null;
            flag1 = false;
        } else
        {
            av1 = abd1.a;
            if (av1.c != null)
            {
                flag1 = av1.c.getBoolean("_noRefresh", false);
            }
        }
        if (c.i.e)
        {
            if (c.w == 0)
            {
                abq.a(abd1.b);
            }
        } else
        if (!(flag1 | flag) && c.w == 0)
        {
            if (abd1.h > 0L)
            {
                d.a(av1, abd1.h);
            } else
            if (abd1.o != null && abd1.o.g > 0L)
            {
                d.a(av1, abd1.o.g);
            } else
            if (!abd1.k && abd1.d == 2)
            {
                d.a(av1);
            }
        }
        return d.d();
    }

    public boolean a(av av1)
    {
        ady.b("loadAd must be called on the main UI thread.");
        if (c.g != null || c.h != null)
        {
            if (a != null)
            {
                acb.e("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            a = av1;
        } else
        {
            if (c.i.e && c.j != null)
            {
                acb.e("An interstitial is already loading. Aborting.");
                return false;
            }
            if (t())
            {
                acb.c("Starting ad request.");
                if (!av1.f)
                {
                    acb.c((new StringBuilder()).append("Use AdRequest.Builder.addTestDevice(\"").append(aca.a(c.c)).append("\") to get test ads on this device.").toString());
                }
                Bundle bundle = a(abi.a().a(c.c));
                d.a();
                c.w = 0;
                av1 = a(av1, bundle);
                c.g = zg.a(c.c, av1, c.d, this);
                return true;
            }
        }
        return false;
    }

    public void b()
    {
        ady.b("destroy must be called on the main UI thread.");
        x();
        c.f = null;
        c.m = null;
        c.n = null;
        c.o = null;
        c.r = null;
        d.a();
        e.a();
        g();
        if (c.a != null)
        {
            c.a.removeAllViews();
        }
        if (c.j != null && c.j.b != null)
        {
            c.j.b.destroy();
        }
        if (c.j == null || c.j.m == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        c.j.m.c();
        return;
        RemoteException remoteexception;
        remoteexception;
        acb.e("Could not destroy mediation adapter.");
        return;
    }

    public void b(av av1)
    {
        android.view.ViewParent viewparent = c.a.getParent();
        if ((viewparent instanceof View) && ((View)viewparent).isShown() && abq.a() && !f)
        {
            a(av1);
            return;
        } else
        {
            acb.c("Ad is not visible. Not refreshing ad.");
            d.a(av1);
            return;
        }
    }

    public boolean c()
    {
        ady.b("isLoaded must be called on the main UI thread.");
        return c.g == null && c.h == null && c.j != null;
    }

    public void d()
    {
        ady.b("pause must be called on the main UI thread.");
        if (c.j != null && c.w == 0)
        {
            abq.a(c.j.b);
        }
        if (c.j != null && c.j.m != null)
        {
            try
            {
                c.j.m.d();
            }
            catch (RemoteException remoteexception)
            {
                acb.e("Could not pause mediation adapter.");
            }
        }
        e.b();
        d.b();
    }

    public void e()
    {
        ady.b("resume must be called on the main UI thread.");
        if (c.j != null && c.w == 0)
        {
            abq.b(c.j.b);
        }
        if (c.j != null && c.j.m != null)
        {
            try
            {
                c.j.m.e();
            }
            catch (RemoteException remoteexception)
            {
                acb.e("Could not resume mediation adapter.");
            }
        }
        d.c();
        e.c();
    }

    public void f()
    {
        ady.b("showInterstitial must be called on the main UI thread.");
        if (!c.i.e)
        {
            acb.e("Cannot call showInterstitial on a banner ad.");
        } else
        {
            if (c.j == null)
            {
                acb.e("The interstitial has not loaded.");
                return;
            }
            if (c.w != 1)
            {
                if (c.j.b.j())
                {
                    acb.e("The interstitial is already showing.");
                    return;
                }
                c.j.b.a(true);
                if (c.j.b.f().b() || c.j.j != null)
                {
                    sp sp1 = e.a(c.i, c.j);
                    if (c.j.b.f().b() && sp1 != null)
                    {
                        sp1.a(new sj(c.j.b));
                    }
                }
                if (c.j.k)
                {
                    try
                    {
                        c.j.m.b();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        acb.d("Could not show interstitial.", remoteexception);
                    }
                    E();
                    return;
                }
                y y1 = new y(c.y, false);
                Object obj = y1;
                if (c.c instanceof Activity)
                {
                    obj = ((Activity)c.c).getWindow();
                    Rect rect = new Rect();
                    Rect rect1 = new Rect();
                    ((Window) (obj)).getDecorView().getGlobalVisibleRect(rect);
                    ((Window) (obj)).getDecorView().getWindowVisibleDisplayFrame(rect1);
                    obj = y1;
                    if (rect.bottom != 0)
                    {
                        obj = y1;
                        if (rect1.bottom != 0)
                        {
                            boolean flag1 = c.y;
                            boolean flag;
                            if (rect.top == rect1.top)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            obj = new y(flag1, flag);
                        }
                    }
                }
                obj = new dr(this, this, this, c.j.b, c.j.g, c.e, c.j.v, ((y) (obj)));
                xc.a(c.c, ((dr) (obj)));
                return;
            }
        }
    }

    public void g()
    {
        ady.b("stopLoading must be called on the main UI thread.");
        if (c.j != null && c.w == 0)
        {
            c.j.b.stopLoading();
            c.j = null;
        }
        if (c.g != null)
        {
            c.g.f();
        }
        if (c.h != null)
        {
            c.h.f();
        }
    }

    public void h()
    {
        ady.b("recordManualImpression must be called on the main UI thread.");
        if (c.j == null)
        {
            acb.e("Ad state was null when trying to ping manual tracking URLs.");
        } else
        {
            acb.a("Pinging manual tracking URLs.");
            if (c.j.f != null)
            {
                abq.a(c.c, c.e.b, c.j.f);
                return;
            }
        }
    }

    public ay i()
    {
        ady.b("getAdSize must be called on the main UI thread.");
        return c.i;
    }

    public String j()
    {
        if (c.j != null)
        {
            return c.j.n;
        } else
        {
            return null;
        }
    }

    public void k()
    {
        s();
    }

    public void l()
    {
        p();
    }

    public void m()
    {
        r();
    }

    public void n()
    {
        q();
    }

    public void o()
    {
        if (c.j != null)
        {
            acb.e((new StringBuilder()).append("Mediation adapter ").append(c.j.n).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        b(true);
        B();
    }

    public void p()
    {
        e.b(c.j);
        if (c.i.e)
        {
            E();
        }
        f = false;
        y();
        c.l.c();
    }

    public void q()
    {
        if (c.i.e)
        {
            b(false);
        }
        f = true;
        A();
    }

    public void r()
    {
        z();
    }

    public void s()
    {
        u();
    }

    public boolean t()
    {
        boolean flag = true;
        if (!abq.a(c.c.getPackageManager(), c.c.getPackageName(), "android.permission.INTERNET"))
        {
            if (!c.i.e)
            {
                aca.a(c.a, c.i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            flag = false;
        }
        if (!abq.a(c.c))
        {
            if (!c.i.e)
            {
                aca.a(c.a, c.i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            flag = false;
        }
        if (!flag && !c.i.e)
        {
            c.a.setVisibility(0);
        }
        return flag;
    }

    public void u()
    {
        if (c.j == null)
        {
            acb.e("Ad state was null when trying to ping click URLs.");
        } else
        {
            acb.a("Pinging click URLs.");
            c.l.b();
            if (c.j.c != null)
            {
                abq.a(c.c, c.e.b, c.j.c);
            }
            if (c.j.o != null && c.j.o.c != null)
            {
                wb.a(c.c, c.e.b, c.j, c.b, false, c.j.o.c);
                return;
            }
        }
    }

    public void v()
    {
        b(false);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.af;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.u;
import com.applovin.impl.adview.w;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.PostbackServiceImpl;
import com.applovin.impl.sdk.bv;
import com.applovin.impl.sdk.da;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.UUID;

// Referenced classes of package com.applovin.adview:
//            g, f, b, j, 
//            k, AppLovinTouchToClickListener, m, o, 
//            p, q, r, s, 
//            e, h, AppLovinAdView, i

public class AppLovinInterstitialActivity extends Activity
    implements w
{

    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile af lastKnownWrapper = null;
    private s A;
    private volatile UUID B;
    private AppLovinAdView a;
    private af b;
    private volatile boolean c;
    private AppLovinLogger d;
    private bv e;
    private AppLovinSdkImpl f;
    private volatile AppLovinAdImpl g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private Handler t;
    private FrameLayout u;
    private AppLovinVideoView v;
    private u w;
    private View x;
    private u y;
    private View z;

    public AppLovinInterstitialActivity()
    {
        c = false;
        g = da.a();
        h = false;
        i = false;
        j = false;
        k = false;
        l = false;
        m = false;
        n = false;
        o = false;
        p = false;
        q = false;
        r = false;
        s = 0;
    }

    private static int a(Display display)
    {
        if (display.getWidth() == display.getHeight())
        {
            return 3;
        }
        return display.getWidth() >= display.getHeight() ? 2 : 1;
    }

    static int a(AppLovinInterstitialActivity applovininterstitialactivity, int i1)
    {
        applovininterstitialactivity.s = i1;
        return i1;
    }

    static AppLovinVideoView a(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.v;
    }

    static AppLovinAdImpl a(AppLovinInterstitialActivity applovininterstitialactivity, AppLovinAdImpl applovinadimpl)
    {
        applovininterstitialactivity.g = applovinadimpl;
        return applovinadimpl;
    }

    private void a(int i1)
    {
        b((int)((float)i1 - da.a(1.0F)));
    }

    private void a(int i1, UUID uuid)
    {
        if (A != null && uuid.equals(B))
        {
            if (i1 <= 0)
            {
                A.setVisibility(8);
                r = true;
            } else
            if (!r)
            {
                i1--;
                A.a(i1);
                t.postDelayed(new g(this, i1, uuid), 1000L);
                return;
            }
        }
    }

    private void a(long l1, u u1)
    {
        t.postDelayed(new f(this, u1), l1);
    }

    static void a(AppLovinInterstitialActivity applovininterstitialactivity, int i1, UUID uuid)
    {
        applovininterstitialactivity.a(i1, uuid);
    }

    static void a(AppLovinInterstitialActivity applovininterstitialactivity, AppLovinAd applovinad)
    {
        applovininterstitialactivity.b(applovinad);
    }

    private void a(AppLovinAd applovinad)
    {
        AppLovinAdDisplayListener applovinaddisplaylistener = b.d();
        if (applovinaddisplaylistener != null)
        {
            applovinaddisplaylistener.adDisplayed(applovinad);
        }
        i = true;
    }

    private void a(AppLovinAd applovinad, double d1, boolean flag)
    {
        l = true;
        AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener = b.c();
        if (applovinadvideoplaybacklistener != null)
        {
            applovinadvideoplaybacklistener.videoPlaybackEnded(applovinad, d1, flag);
        }
    }

    private boolean a()
    {
        while (b == null || e == null || e.a() || e.c() && n || e.b() && p) 
        {
            return true;
        }
        return false;
    }

    static boolean a(AppLovinInterstitialActivity applovininterstitialactivity, boolean flag)
    {
        applovininterstitialactivity.m = flag;
        return flag;
    }

    static AppLovinLogger b(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.d;
    }

    private void b()
    {
        android.content.SharedPreferences.Editor editor = t().edit();
        editor.putBoolean("com.applovin.interstitial.should_resume_video", false);
        editor.putInt("com.applovin.interstitial.last_video_position", 0);
        editor.commit();
    }

    private void b(int i1)
    {
        a(i1, B);
    }

    static void b(AppLovinInterstitialActivity applovininterstitialactivity, AppLovinAd applovinad)
    {
        applovininterstitialactivity.a(applovinad);
    }

    private void b(AppLovinAd applovinad)
    {
        c(applovinad);
        dismiss();
    }

    static boolean b(AppLovinInterstitialActivity applovininterstitialactivity, boolean flag)
    {
        applovininterstitialactivity.n = flag;
        return flag;
    }

    private int c(int i1)
    {
        return AppLovinSdkUtils.dpToPx(this, i1);
    }

    private void c()
    {
        Uri uri = Uri.fromFile(f.getFileManager().a(g.getVideoFilename(), this, false));
        v = new AppLovinVideoView(this);
        v.setOnPreparedListener(new b(this));
        v.setOnCompletionListener(new j(this));
        v.setOnErrorListener(new k(this));
        v.setVideoURI(uri);
        v.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        v.setOnTouchListener(new AppLovinTouchToClickListener(this, new m(this)));
        u.addView(v);
        setContentView(u);
        k();
    }

    static void c(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.e();
    }

    private void c(AppLovinAd applovinad)
    {
        if (!j)
        {
            j = true;
            if (b != null)
            {
                AppLovinAdDisplayListener applovinaddisplaylistener = b.d();
                if (applovinaddisplaylistener != null)
                {
                    applovinaddisplaylistener.adHidden(applovinad);
                }
            }
        }
    }

    static boolean c(AppLovinInterstitialActivity applovininterstitialactivity, boolean flag)
    {
        applovininterstitialactivity.o = flag;
        return flag;
    }

    static Handler d(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.t;
    }

    private void d()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        u = new FrameLayout(this);
        u.setLayoutParams(layoutparams);
        u.setBackgroundColor(0xff000000);
        t = new Handler();
    }

    private void d(AppLovinAd applovinad)
    {
        if (!k)
        {
            k = true;
            AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener = b.c();
            if (applovinadvideoplaybacklistener != null)
            {
                applovinadvideoplaybacklistener.videoPlaybackBegan(applovinad);
            }
        }
    }

    private void e()
    {
        if (e.k())
        {
            finish();
            return;
        } else
        {
            h();
            return;
        }
    }

    static void e(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.l();
    }

    private void f()
    {
        d(g);
        v.start();
        b(m());
    }

    static void f(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.n();
    }

    private void g()
    {
        byte byte0 = 3;
        w = com.applovin.impl.adview.u.a(f, this, g.getCloseStyle());
        w.setVisibility(8);
        w.setOnClickListener(new o(this));
        int j1 = c(e.m());
        android.widget.FrameLayout.LayoutParams layoutparams;
        int i1;
        int k1;
        int l1;
        if (e.x())
        {
            i1 = 3;
        } else
        {
            i1 = 5;
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(j1, j1, i1 | 0x30);
        w.a(j1);
        k1 = c(e.o());
        l1 = c(e.q());
        layoutparams.setMargins(l1, k1, l1, k1);
        u.addView(w, layoutparams);
        y = com.applovin.impl.adview.u.a(f, this, g.getCloseStyle());
        y.setVisibility(8);
        y.setOnClickListener(new p(this));
        if (e.w())
        {
            i1 = 3;
        } else
        {
            i1 = 5;
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(j1, j1, i1 | 0x30);
        layoutparams.setMargins(l1, k1, l1, k1);
        y.a(j1);
        u.addView(y, layoutparams);
        y.bringToFront();
        if (i())
        {
            i1 = c((new bv(f)).r());
            x = new View(this);
            x.setBackgroundColor(0);
            x.setVisibility(8);
            z = new View(this);
            z.setBackgroundColor(0);
            z.setVisibility(8);
            j1 += i1;
            k1 -= c(5);
            android.widget.FrameLayout.LayoutParams layoutparams1;
            android.widget.FrameLayout.LayoutParams layoutparams2;
            if (e.x())
            {
                i1 = 3;
            } else
            {
                i1 = 5;
            }
            layoutparams1 = new android.widget.FrameLayout.LayoutParams(j1, j1, i1 | 0x30);
            layoutparams1.setMargins(k1, k1, k1, k1);
            if (e.w())
            {
                i1 = byte0;
            } else
            {
                i1 = 5;
            }
            layoutparams2 = new android.widget.FrameLayout.LayoutParams(j1, j1, i1 | 0x30);
            layoutparams2.setMargins(k1, k1, k1, k1);
            x.setOnClickListener(new q(this));
            z.setOnClickListener(new r(this));
            u.addView(x, layoutparams1);
            x.bringToFront();
            u.addView(z, layoutparams2);
            z.bringToFront();
        }
    }

    static void g(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.f();
    }

    private void h()
    {
        runOnUiThread(new com.applovin.adview.s(this));
    }

    static void h(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.r();
    }

    static AppLovinSdkImpl i(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.f;
    }

    private boolean i()
    {
        return e.r() > 0;
    }

    static bv j(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.e;
    }

    private void j()
    {
        runOnUiThread(new e(this));
    }

    static s k(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.A;
    }

    private void k()
    {
        if (g.getVideoCloseDelay() >= 0.0F)
        {
            u u1;
            if (q && y != null)
            {
                u1 = y;
            } else
            {
                u1 = w;
            }
            a(da.c(g.getVideoCloseDelay()), u1);
        }
    }

    private void l()
    {
        if (A == null)
        {
            A = new s(this);
            int i1 = o();
            A.c(i1);
            A.b(e.h());
            A.d(i1);
            A.a(e.g());
            A.b(m());
            Object obj = new android.widget.FrameLayout.LayoutParams(c(e.f()), c(e.f()), e.v());
            i1 = c(e.u());
            ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(i1, i1, i1, i1);
            u.addView(A, ((android.view.ViewGroup.LayoutParams) (obj)));
            A.bringToFront();
            obj = A;
            if (e.i() && m() > 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            ((s) (obj)).setVisibility(i1);
        }
    }

    static void l(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.p();
    }

    private int m()
    {
        for (int i1 = g.getCountdownLength(); i1 > 0 || !e.t();)
        {
            return i1;
        }

        return s + 1;
    }

    static u m(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.w;
    }

    static u n(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.y;
    }

    private void n()
    {
        B = UUID.randomUUID();
    }

    private int o()
    {
        return Color.parseColor(e.d());
    }

    static boolean o(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.n;
    }

    private void p()
    {
        v.stopPlayback();
        r();
    }

    static boolean p(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.i();
    }

    static View q(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.x;
    }

    private void q()
    {
label0:
        {
            if (!c)
            {
                if (a == null)
                {
                    break label0;
                }
                a.setAdDisplayListener(new h(this));
                a.setAdClickListener(new i(this));
                g = (AppLovinAdImpl)b.b();
                d();
                g();
                if (g.getVideoFilename() != null)
                {
                    c();
                } else
                {
                    h = true;
                    f.getLogger().e("AppLovinInterstitialActivity", "Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                    r();
                }
                w.bringToFront();
                if (i() && x != null)
                {
                    x.bringToFront();
                }
                if (y != null)
                {
                    y.bringToFront();
                }
                a.renderAd(g);
                b.a(true);
            }
            return;
        }
        exitWithError("AdView was null");
    }

    private void r()
    {
        FrameLayout framelayout = new FrameLayout(this);
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        framelayout.setBackgroundColor(0xbb000000);
        framelayout.addView(a);
        if (y != null)
        {
            u.removeView(y);
            if (z != null)
            {
                u.removeView(z);
            }
        }
        if (i() && x != null)
        {
            u.removeView(x);
            framelayout.addView(x);
            x.bringToFront();
        }
        u.removeView(w);
        framelayout.addView(w);
        setContentView(framelayout);
        w.bringToFront();
        if (g.getPoststitialCloseDelay() > 0.0F)
        {
            a(da.c(g.getPoststitialCloseDelay()), w);
        } else
        {
            w.setVisibility(0);
        }
        p = true;
        s();
    }

    static boolean r(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.o;
    }

    static View s(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.z;
    }

    private void s()
    {
        double d1 = 100D;
        if (l)
        {
            return;
        }
        AppLovinAdImpl applovinadimpl;
        boolean flag;
        if (!m)
        {
            if (v != null)
            {
                int i1 = v.getDuration();
                d1 = 100D * ((double)v.getCurrentPosition() / (double)i1);
            } else
            {
                Log.e("AppLovinInterstitialActivity", "No video view detected on video end");
                d1 = 0.0D;
            }
        }
        f.getPostbackService().dispatchPostbackAsync(g.getParametrizedCompletionUrl((int)d1), null);
        applovinadimpl = g;
        if (d1 > 95D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(applovinadimpl, d1, flag);
    }

    private SharedPreferences t()
    {
        return getSharedPreferences("com.applovin.interstitial.sharedpreferences", 0);
    }

    static void t(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.h();
    }

    static void u(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.j();
    }

    static boolean v(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.i;
    }

    static af w(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.b;
    }

    public void dismiss()
    {
        b();
        s();
        if (b != null)
        {
            if (g != null)
            {
                c(g);
            }
            b.a(false);
            b.g();
        }
        finish();
    }

    public void exitWithError(String s1)
    {
        try
        {
            String s2 = (new StringBuilder()).append("Initialized = ").append(af.a).append("; CleanedUp = ").append(af.b).toString();
            Log.e("AppLovinInterstitialActivity", (new StringBuilder()).append("Failed to properly render an Interstitial Activity, due to error: ").append(s1).toString(), new Throwable(s2));
            c(da.a());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.e("AppLovinInterstitialActivity", "Failed to show a video ad due to error:", s1);
        }
        finish();
    }

    public void onBackPressed()
    {
        if (a())
        {
            d.d("AppLovinInterstitialActivity", "Back button was pressed; forwarding to Android for handling...");
            super.onBackPressed();
            return;
        }
        try
        {
            if (q && y != null && y.getVisibility() == 0 && y.getAlpha() > 0.0F && !n)
            {
                d.d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to skip button.");
                y.performClick();
                return;
            }
        }
        catch (Exception exception)
        {
            super.onBackPressed();
            return;
        }
        if (w != null && w.getVisibility() == 0 && w.getAlpha() > 0.0F)
        {
            d.d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to close button.");
            w.performClick();
            return;
        }
        d.d("AppLovinInterstitialActivity", "Back button was pressed, but was not eligible for dismissal.");
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        try
        {
            getWindow().setFlags(1024, 1024);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        setTheme(0x1030011);
        bundle = getIntent().getStringExtra("com.applovin.interstitial.wrapper_id");
        if (bundle != null && !bundle.isEmpty())
        {
            b = af.a(bundle);
            if (b == null && lastKnownWrapper != null)
            {
                b = lastKnownWrapper;
            }
            if (b != null)
            {
                bundle = b.b();
                f = (AppLovinSdkImpl)b.a();
                d = b.a().getLogger();
                e = new bv(b.a());
                if (bundle != null)
                {
                    bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                    int i1 = a(bundle);
                    int j1 = bundle.getRotation();
                    boolean flag;
                    if (i1 == 2 && j1 == 0 || i1 == 2 && j1 == 2 || i1 == 1 && j1 == 1 || i1 == 1 && j1 == 3)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (b.f() == com.applovin.impl.sdk.AppLovinAdImpl.AdTarget.ACTIVITY_PORTRAIT)
                    {
                        if (flag)
                        {
                            if (j1 != 1 && j1 != 3)
                            {
                                c = true;
                                setRequestedOrientation(1);
                            }
                        } else
                        if (j1 != 0 && j1 != 2)
                        {
                            c = true;
                            setRequestedOrientation(1);
                        }
                    } else
                    if (flag)
                    {
                        if (j1 != 0 && j1 != 2)
                        {
                            c = true;
                            setRequestedOrientation(0);
                        }
                    } else
                    if (j1 != 1 && j1 != 3)
                    {
                        c = true;
                        setRequestedOrientation(0);
                    }
                    a = new AppLovinAdView(f, AppLovinAdSize.INTERSTITIAL, this);
                    a.setAutoDestroy(false);
                    b.a(this);
                    q = e.s();
                } else
                {
                    exitWithError("No current ad found.");
                }
            } else
            {
                exitWithError((new StringBuilder()).append("Wrapper is null; initialized state: ").append(Boolean.toString(af.a)).toString());
            }
        } else
        {
            exitWithError("Wrapper ID is null");
        }
        bundle = t().edit();
        bundle.putBoolean("com.applovin.interstitial.should_resume_video", false);
        bundle.commit();
        b();
        q();
    }

    protected void onDestroy()
    {
        try
        {
            if (a != null)
            {
                a.destroy();
            }
            if (v != null)
            {
                v.pause();
                v.stopPlayback();
            }
        }
        catch (Throwable throwable)
        {
            d.w("AppLovinInterstitialActivity", "Unable to destroy video view", throwable);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        if (!c && !h)
        {
            android.content.SharedPreferences.Editor editor = t().edit();
            editor.putInt("com.applovin.interstitial.last_video_position", v.getCurrentPosition());
            editor.putBoolean("com.applovin.interstitial.should_resume_video", true);
            editor.commit();
            v.pause();
        }
        b.a(false);
        super.onPause();
    }

    protected void onResume()
    {
label0:
        {
            super.onResume();
            b.a(true);
            Object obj = t();
            if (((SharedPreferences) (obj)).getBoolean("com.applovin.interstitial.should_resume_video", false))
            {
                if (v != null)
                {
                    int i1 = v.getDuration();
                    int j1 = ((SharedPreferences) (obj)).getInt("com.applovin.interstitial.last_video_position", i1);
                    n();
                    v.seekTo(j1);
                    v.start();
                    a(i1 - j1);
                }
                if (w == null || !e.j())
                {
                    break label0;
                }
                d.d("AppLovinInterstitialActivity", "Fading in close button due to app resume.");
                if (q && y != null)
                {
                    obj = y;
                } else
                {
                    obj = w;
                }
                a(0L, ((u) (obj)));
            }
            return;
        }
        dismiss();
    }

}

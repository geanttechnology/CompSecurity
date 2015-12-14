// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.af;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.u;
import com.applovin.impl.adview.w;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.PostbackServiceImpl;
import com.applovin.impl.sdk.ca;
import com.applovin.impl.sdk.dh;
import com.applovin.impl.sdk.y;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.UUID;

// Referenced classes of package com.applovin.adview:
//            h, g, b, k, 
//            l, AppLovinTouchToClickListener, n, p, 
//            q, r, s, t, 
//            e, f, i, AppLovinAdView, 
//            j

public class AppLovinInterstitialActivity extends Activity
    implements w
{

    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile af lastKnownWrapper = null;
    private View A;
    private s B;
    private volatile UUID C;
    private ImageView D;
    private WeakReference E;
    private AppLovinAdView a;
    private af b;
    private volatile boolean c;
    private AppLovinLogger d;
    private ca e;
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
    private volatile boolean r;
    private boolean s;
    private int t;
    private Handler u;
    private FrameLayout v;
    private AppLovinVideoView w;
    private u x;
    private View y;
    private u z;

    public AppLovinInterstitialActivity()
    {
        c = false;
        g = dh.a();
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
        s = false;
        t = 0;
        E = new WeakReference(null);
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
        applovininterstitialactivity.t = i1;
        return i1;
    }

    static AppLovinAdImpl a(AppLovinInterstitialActivity applovininterstitialactivity, AppLovinAdImpl applovinadimpl)
    {
        applovininterstitialactivity.g = applovinadimpl;
        return applovinadimpl;
    }

    static WeakReference a(AppLovinInterstitialActivity applovininterstitialactivity, WeakReference weakreference)
    {
        applovininterstitialactivity.E = weakreference;
        return weakreference;
    }

    private void a(int i1)
    {
        b((int)((float)i1 - dh.a(1.0F)));
    }

    private void a(int i1, UUID uuid)
    {
        if (B != null && uuid.equals(C))
        {
            if (i1 <= 0)
            {
                B.setVisibility(8);
                s = true;
            } else
            if (!s)
            {
                i1--;
                B.a(i1);
                u.postDelayed(new h(this, i1, uuid), 1000L);
                return;
            }
        }
    }

    private void a(long l1, u u1)
    {
        u.postDelayed(new g(this, u1), l1);
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

    private void a(boolean flag)
    {
        r = flag;
        MediaPlayer mediaplayer = (MediaPlayer)E.get();
        if (mediaplayer != null)
        {
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 1;
            }
            mediaplayer.setVolume(i1, i1);
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

    static boolean a(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.d();
    }

    static boolean a(AppLovinInterstitialActivity applovininterstitialactivity, boolean flag)
    {
        applovininterstitialactivity.m = flag;
        return flag;
    }

    static AppLovinVideoView b(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.w;
    }

    private void b()
    {
        android.content.SharedPreferences.Editor editor = x().edit();
        editor.putBoolean("com.applovin.interstitial.should_resume_video", false);
        editor.putInt("com.applovin.interstitial.last_video_position", 0);
        editor.commit();
    }

    private void b(int i1)
    {
        a(i1, C);
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

    static AppLovinLogger c(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.d;
    }

    private void c()
    {
        Uri uri = Uri.fromFile(f.getFileManager().a(g.getVideoFilename(), this, false));
        w = new AppLovinVideoView(this);
        w.setOnPreparedListener(new b(this));
        w.setOnCompletionListener(new k(this));
        w.setOnErrorListener(new l(this));
        w.setVideoURI(uri);
        w.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        w.setOnTouchListener(new AppLovinTouchToClickListener(this, new n(this)));
        v.addView(w);
        setContentView(v);
        m();
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

    static void d(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.f();
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

    private boolean d()
    {
        return e.G();
    }

    static Handler e(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.u;
    }

    private void e()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        v = new FrameLayout(this);
        v.setLayoutParams(layoutparams);
        v.setBackgroundColor(0xff000000);
        u = new Handler();
    }

    private void f()
    {
        if (e.k())
        {
            finish();
            return;
        } else
        {
            j();
            return;
        }
    }

    static void f(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.n();
    }

    private void g()
    {
        d(g);
        w.start();
        b(o());
    }

    static void g(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.i();
    }

    private void h()
    {
        byte byte0 = 3;
        x = com.applovin.impl.adview.u.a(f, this, g.getCloseStyle());
        x.setVisibility(8);
        x.setOnClickListener(new p(this));
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
        x.a(j1);
        k1 = c(e.o());
        l1 = c(e.q());
        layoutparams.setMargins(l1, k1, l1, k1);
        v.addView(x, layoutparams);
        z = com.applovin.impl.adview.u.a(f, this, g.getCloseStyle());
        z.setVisibility(8);
        z.setOnClickListener(new q(this));
        if (e.w())
        {
            i1 = 3;
        } else
        {
            i1 = 5;
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(j1, j1, i1 | 0x30);
        layoutparams.setMargins(l1, k1, l1, k1);
        z.a(j1);
        v.addView(z, layoutparams);
        z.bringToFront();
        if (k())
        {
            i1 = c((new ca(f)).r());
            y = new View(this);
            y.setBackgroundColor(0);
            y.setVisibility(8);
            A = new View(this);
            A.setBackgroundColor(0);
            A.setVisibility(8);
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
            y.setOnClickListener(new r(this));
            A.setOnClickListener(new com.applovin.adview.s(this));
            v.addView(y, layoutparams1);
            y.bringToFront();
            v.addView(A, layoutparams2);
            A.bringToFront();
        }
    }

    static void h(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.p();
    }

    private void i()
    {
        D = new ImageView(this);
        if (!e.A() || !d() && !e.B())
        {
            return;
        }
        int i1 = c(e.C());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(i1, i1, e.D());
        D.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        int j1 = c(e.E());
        layoutparams.setMargins(j1, j1, j1, j1);
        f.getLogger().d("AppLovinInterstitialActivity", (new StringBuilder()).append("Added mute button with params: ").append(layoutparams).toString());
        String s1;
        if (d())
        {
            s1 = g.getMuteImageFilename();
        } else
        {
            s1 = g.getUnmuteImageFilename();
        }
        AppLovinSdkUtils.safePopulateImageView(D, Uri.fromFile(f.getFileManager().a(s1, this, true)), i1);
        D.setClickable(true);
        D.setOnClickListener(new t(this));
        v.addView(D, layoutparams);
        D.bringToFront();
        r = d();
    }

    static void i(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.g();
    }

    private void j()
    {
        runOnUiThread(new e(this));
    }

    static void j(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.t();
    }

    static AppLovinSdkImpl k(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.f;
    }

    private boolean k()
    {
        return e.r() > 0;
    }

    static ca l(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.e;
    }

    private void l()
    {
        runOnUiThread(new f(this));
    }

    static s m(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.B;
    }

    private void m()
    {
        if (g.getVideoCloseDelay() >= 0.0F)
        {
            u u1;
            if (q && z != null)
            {
                u1 = z;
            } else
            {
                u1 = x;
            }
            a(dh.c(g.getVideoCloseDelay()), u1);
        }
    }

    private void n()
    {
        if (B == null)
        {
            B = new s(this);
            int i1 = q();
            B.c(i1);
            B.b(e.h());
            B.d(i1);
            B.a(e.g());
            B.b(o());
            Object obj = new android.widget.FrameLayout.LayoutParams(c(e.f()), c(e.f()), e.v());
            i1 = c(e.u());
            ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(i1, i1, i1, i1);
            v.addView(B, ((android.view.ViewGroup.LayoutParams) (obj)));
            B.bringToFront();
            obj = B;
            if (e.i() && o() > 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            ((s) (obj)).setVisibility(i1);
        }
    }

    static void n(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.r();
    }

    private int o()
    {
        for (int i1 = g.getCountdownLength(); i1 > 0 || !e.t();)
        {
            return i1;
        }

        return t + 1;
    }

    static u o(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.x;
    }

    static u p(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.z;
    }

    private void p()
    {
        C = UUID.randomUUID();
    }

    private int q()
    {
        return Color.parseColor(e.d());
    }

    static void q(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.u();
    }

    private void r()
    {
        t();
    }

    static boolean r(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.n;
    }

    private void s()
    {
label0:
        {
            if (!c)
            {
                if (a == null)
                {
                    break label0;
                }
                a.setAdDisplayListener(new i(this));
                a.setAdClickListener(new j(this));
                g = (AppLovinAdImpl)b.b();
                e();
                h();
                if (g.getVideoFilename() != null)
                {
                    c();
                } else
                {
                    h = true;
                    f.getLogger().e("AppLovinInterstitialActivity", "Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                    t();
                }
                x.bringToFront();
                if (k() && y != null)
                {
                    y.bringToFront();
                }
                if (z != null)
                {
                    z.bringToFront();
                }
                a.renderAd(g);
                b.a(true);
            }
            return;
        }
        exitWithError("AdView was null");
    }

    static boolean s(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.k();
    }

    static View t(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.y;
    }

    private void t()
    {
        w();
        w.stopPlayback();
        FrameLayout framelayout = new FrameLayout(this);
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        framelayout.setBackgroundColor(0xbb000000);
        framelayout.addView(a);
        if (z != null)
        {
            v.removeView(z);
            if (A != null)
            {
                v.removeView(A);
            }
        }
        if (k() && y != null)
        {
            v.removeView(y);
            framelayout.addView(y);
            y.bringToFront();
        }
        v.removeView(x);
        framelayout.addView(x);
        setContentView(framelayout);
        x.bringToFront();
        if (g.getPoststitialCloseDelay() > 0.0F)
        {
            a(dh.c(g.getPoststitialCloseDelay()), x);
        } else
        {
            x.setVisibility(0);
        }
        p = true;
    }

    private void u()
    {
        String s1;
        int i1;
        boolean flag;
        if (!v())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        if (flag)
        {
            s1 = g.getMuteImageFilename();
        } else
        {
            s1 = g.getUnmuteImageFilename();
        }
        i1 = c(e.C());
        AppLovinSdkUtils.safePopulateImageView(D, Uri.fromFile(f.getFileManager().a(s1, this, true)), i1);
    }

    static boolean u(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.o;
    }

    static View v(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.A;
    }

    private boolean v()
    {
        return r;
    }

    private void w()
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
            if (w != null)
            {
                int i1 = w.getDuration();
                d1 = 100D * ((double)w.getCurrentPosition() / (double)i1);
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

    static void w(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.j();
    }

    private SharedPreferences x()
    {
        return getSharedPreferences("com.applovin.interstitial.sharedpreferences", 0);
    }

    static void x(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        applovininterstitialactivity.l();
    }

    static boolean y(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.i;
    }

    static af z(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        return applovininterstitialactivity.b;
    }

    public void dismiss()
    {
        ((AdViewControllerImpl)a.getAdViewController()).setIsForegroundClickInvalidated(true);
        b();
        w();
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
            c(dh.a());
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
            if (q && z != null && z.getVisibility() == 0 && z.getAlpha() > 0.0F && !n)
            {
                d.d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to skip button.");
                z.performClick();
                return;
            }
        }
        catch (Exception exception)
        {
            super.onBackPressed();
            return;
        }
        if (x != null && x.getVisibility() == 0 && x.getAlpha() > 0.0F)
        {
            d.d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to close button.");
            x.performClick();
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
        requestWindowFeature(1);
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
                e = new ca(b.a());
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
        bundle = x().edit();
        bundle.putBoolean("com.applovin.interstitial.should_resume_video", false);
        bundle.commit();
        b();
        s();
    }

    protected void onDestroy()
    {
        try
        {
            if (a != null)
            {
                a.destroy();
            }
            if (w != null)
            {
                w.pause();
                w.stopPlayback();
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
            android.content.SharedPreferences.Editor editor = x().edit();
            editor.putInt("com.applovin.interstitial.last_video_position", w.getCurrentPosition());
            editor.putBoolean("com.applovin.interstitial.should_resume_video", true);
            editor.commit();
            w.pause();
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
            Object obj = x();
            if (((SharedPreferences) (obj)).getBoolean("com.applovin.interstitial.should_resume_video", false))
            {
                if (w != null)
                {
                    int i1 = w.getDuration();
                    int j1 = ((SharedPreferences) (obj)).getInt("com.applovin.interstitial.last_video_position", i1);
                    p();
                    w.seekTo(j1);
                    w.start();
                    a(i1 - j1);
                }
                if (x == null || !e.j())
                {
                    break label0;
                }
                d.d("AppLovinInterstitialActivity", "Fading in close button due to app resume.");
                if (q && z != null)
                {
                    obj = z;
                } else
                {
                    obj = x;
                }
                a(0L, ((u) (obj)));
            }
            return;
        }
        dismiss();
    }

}

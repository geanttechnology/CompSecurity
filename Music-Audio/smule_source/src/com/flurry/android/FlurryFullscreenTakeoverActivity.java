// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.sdk.ap;
import com.flurry.sdk.aw;
import com.flurry.sdk.co;
import com.flurry.sdk.cx;
import com.flurry.sdk.ea;
import com.flurry.sdk.ec;
import com.flurry.sdk.ee;
import com.flurry.sdk.ek;
import com.flurry.sdk.fp;
import com.flurry.sdk.fx;
import com.flurry.sdk.fy;
import com.flurry.sdk.fz;
import com.flurry.sdk.gd;
import com.flurry.sdk.hc;
import com.flurry.sdk.hq;
import com.flurry.sdk.i;
import com.flurry.sdk.p;
import com.flurry.sdk.r;
import com.flurry.sdk.v;
import java.util.Collections;
import java.util.Map;

public final class FlurryFullscreenTakeoverActivity extends Activity
{

    public static final String EXTRA_KEY_AD_OBJECT_ID = "ad_object_id";
    public static final String EXTRA_KEY_AD_OBJECT_LEGACY = "ad_object_legacy";
    public static final String EXTRA_KEY_CLOSE_AD = "close_ad";
    public static final String EXTRA_KEY_SEND_Y_COOKIES = "send_y_cookies";
    public static final String EXTRA_KEY_URL = "url";
    private static final String a = com/flurry/android/FlurryFullscreenTakeoverActivity.getSimpleName();
    private ViewGroup b;
    private ec c;
    private boolean d;
    private r e;
    private ek f;
    private boolean g;
    private fy h;
    private com.flurry.sdk.ec.a i;

    public FlurryFullscreenTakeoverActivity()
    {
        g = false;
        h = new fy() {

            final FlurryFullscreenTakeoverActivity a;

            public void a(ea ea1)
            {
                fp.a().a(new hq(this, ea1) {

                    final ea a;
                    final _cls1 b;

                    public void safeRun()
                    {
                        com.flurry.sdk.ea.a a1 = a.e;
                        class _cls3
                        {

                            static final int a[];

                            static 
                            {
                                a = new int[com.flurry.sdk.ea.a.values().length];
                                try
                                {
                                    a[com.flurry.sdk.ea.a.a.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    a[com.flurry.sdk.ea.a.b.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror)
                                {
                                    return;
                                }
                            }
                        }

                        switch (_cls3.a[a1.ordinal()])
                        {
                        default:
                            return;

                        case 1: // '\001'
                            gd.a(3, FlurryFullscreenTakeoverActivity.a(), (new StringBuilder()).append("RELOAD_ACTIVITY Event was fired for adObject:").append(a.a.d()).append(" for url:").append(a.b).append(" and should Close Ad:").append(a.c).toString());
                            FlurryFullscreenTakeoverActivity.a(b.a, new ek(a.a, a.b, a.c, a.d));
                            FlurryFullscreenTakeoverActivity.a(b.a, FlurryFullscreenTakeoverActivity.a(b.a).c());
                            if (FlurryFullscreenTakeoverActivity.b(b.a) == null)
                            {
                                gd.b(FlurryFullscreenTakeoverActivity.a(), "Cannot launch Activity. No Ad Controller");
                                b.a.finish();
                                return;
                            } else
                            {
                                FlurryFullscreenTakeoverActivity.c(b.a);
                                FlurryFullscreenTakeoverActivity.d(b.a);
                                FlurryFullscreenTakeoverActivity.a(b.a, true);
                                FlurryFullscreenTakeoverActivity.e(b.a);
                                return;
                            }

                        case 2: // '\002'
                            gd.a(FlurryFullscreenTakeoverActivity.a(), "CLOSE_ACTIVITY Event was fired :");
                            b.a.finish();
                            return;
                        }
                    }

            
            {
                b = _pcls1;
                a = ea1;
                super();
            }
                });
            }

            public void notify(fx fx)
            {
                a((ea)fx);
            }

            
            {
                a = FlurryFullscreenTakeoverActivity.this;
                super();
            }
        };
        i = new com.flurry.sdk.ec.a() {

            final FlurryFullscreenTakeoverActivity a;

            public void a()
            {
                gd.a(FlurryFullscreenTakeoverActivity.a(), "onViewBack");
                if (FlurryFullscreenTakeoverActivity.a(a) != null && FlurryFullscreenTakeoverActivity.a(a).b())
                {
                    FlurryFullscreenTakeoverActivity.d(a);
                    a.finish();
                    return;
                } else
                {
                    a.removeViewState();
                    a.loadViewState();
                    FlurryFullscreenTakeoverActivity.a(a, true);
                    FlurryFullscreenTakeoverActivity.e(a);
                    return;
                }
            }

            public void b()
            {
                gd.a(FlurryFullscreenTakeoverActivity.a(), "onViewClose");
                FlurryFullscreenTakeoverActivity.d(a);
                a.finish();
            }

            public void c()
            {
                gd.a(FlurryFullscreenTakeoverActivity.a(), "onViewError");
                FlurryFullscreenTakeoverActivity.d(a);
                a.finish();
            }

            
            {
                a = FlurryFullscreenTakeoverActivity.this;
                super();
            }
        };
    }

    static ek a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        return flurryfullscreentakeoveractivity.f;
    }

    static ek a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, ek ek1)
    {
        flurryfullscreentakeoveractivity.f = ek1;
        return ek1;
    }

    static r a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, r r1)
    {
        flurryfullscreentakeoveractivity.e = r1;
        return r1;
    }

    static String a()
    {
        return a;
    }

    static void a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, boolean flag)
    {
        flurryfullscreentakeoveractivity.a(flag);
    }

    private void a(ec ec1)
    {
        e();
        c = ec1;
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        b.addView(ec1, layoutparams);
        setContentView(b);
    }

    private void a(boolean flag)
    {
        g = flag;
    }

    static r b(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        return flurryfullscreentakeoveractivity.e;
    }

    private boolean b()
    {
        return g;
    }

    private void c()
    {
        boolean flag = getIntent().getBooleanExtra("ad_object_legacy", false);
        int j = getIntent().getIntExtra("ad_object_id", 0);
        String s = getIntent().getStringExtra("url");
        boolean flag1 = getIntent().getBooleanExtra("close_ad", true);
        boolean flag2 = getIntent().getBooleanExtra("send_y_cookies", false);
        Object obj = com.flurry.sdk.i.a();
        if (flag)
        {
            obj = ((i) (obj)).e().a(j);
        } else
        {
            obj = ((i) (obj)).d().a(j);
        }
        e = ((r) (obj));
        if (e == null)
        {
            gd.b(a, "Cannot launch Activity. No ad object.");
            finish();
            return;
        } else
        {
            f = new ek(e, s, flag1, flag2);
            e.k().b(true);
            return;
        }
    }

    static void c(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        flurryfullscreentakeoveractivity.f();
    }

    private void d()
    {
        if (f == null)
        {
            finish();
            return;
        }
        gd.a(3, a, (new StringBuilder()).append("Load View in Activity: ").append(f.toString()).toString());
        ec ec1 = ee.a(this, f.c(), f.a(), i, f.d(), b());
        if (ec1 != null)
        {
            e();
            a(ec1);
            c.initLayout();
        }
        a(false);
    }

    static void d(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        flurryfullscreentakeoveractivity.e();
    }

    private void e()
    {
        if (c != null)
        {
            c.cleanupLayout();
            b.removeAllViews();
        }
    }

    static void e(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        flurryfullscreentakeoveractivity.d();
    }

    private void f()
    {
        if (f != null)
        {
            gd.a(a, (new StringBuilder()).append("Save view state: ").append(f.toString()).toString());
            e.k().a(f);
        }
    }

    public void finish()
    {
        this;
        JVM INSTR monitorenter ;
        if (!d)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        d = true;
        this;
        JVM INSTR monitorexit ;
        super.finish();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void fireEvent(aw aw1, Map map, int j)
    {
        gd.a(a, (new StringBuilder()).append("fireEvent(event=").append(aw1).append(",params=").append(map).append(")").toString());
        co.a(aw1, map, this, e, e.k(), j);
    }

    public void loadViewState()
    {
        f = e.k().t();
        if (f == null)
        {
            finish();
            return;
        } else
        {
            gd.a(a, (new StringBuilder()).append("Load view state: ").append(f.toString()).toString());
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        gd.a(3, a, "onConfigurationChanged");
        if (c != null)
        {
            c.onConfigurationChanged();
        }
    }

    public void onCreate(Bundle bundle)
    {
        gd.a(3, a, "onCreate");
        setTheme(0x1030007);
        super.onCreate(bundle);
        if (fp.a() == null)
        {
            gd.a(3, a, "Flurry core not initialized.");
            finish();
            return;
        } else
        {
            cx.a(getWindow());
            setVolumeControlStream(3);
            b = new RelativeLayout(this);
            c();
            f();
            a(true);
            fireEvent(aw.N, Collections.emptyMap(), 0);
            return;
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        gd.a(3, a, "onDestroy");
        if (c != null)
        {
            c.onActivityDestroy();
        }
        if (e != null && e.k() != null)
        {
            e.k().u();
            e.k().b(false);
        }
        fireEvent(aw.t, Collections.emptyMap(), 0);
    }

    public boolean onKeyUp(int j, KeyEvent keyevent)
    {
        gd.a(3, a, "onKeyUp");
        if (j == 4 && c != null)
        {
            c.onBackKey();
            return true;
        } else
        {
            return super.onKeyUp(j, keyevent);
        }
    }

    protected void onPause()
    {
        gd.a(3, a, "onPause");
        super.onPause();
        if (c != null)
        {
            c.onActivityPause();
        }
    }

    protected void onRestart()
    {
        gd.a(3, a, "onRestart");
        super.onRestart();
        loadViewState();
    }

    protected void onResume()
    {
        gd.a(3, a, "onActivityResume");
        super.onResume();
        if (c != null)
        {
            c.onActivityResume();
        }
    }

    public void onStart()
    {
        super.onStart();
        gd.a(3, a, "onStart");
        hc.a().b(this);
        registerActivityEvent();
        d();
        if (c != null)
        {
            c.onActivityStart();
        }
    }

    public void onStop()
    {
        super.onStop();
        gd.a(3, a, "onStop");
        if (c != null)
        {
            c.onActivityStop();
        }
        a(false);
        unregisterActivityEvent();
        hc.a().c(this);
    }

    public void registerActivityEvent()
    {
        fz.a().a("com.flurry.android.impl.ads.views.ActivityEvent", h);
    }

    public void removeViewState()
    {
        if (e.k() != null)
        {
            ek ek1 = e.k().s();
            gd.a(a, (new StringBuilder()).append("Remove view state: ").append(ek1.toString()).toString());
        }
    }

    public void unregisterActivityEvent()
    {
        fz.a().a(h);
    }

}

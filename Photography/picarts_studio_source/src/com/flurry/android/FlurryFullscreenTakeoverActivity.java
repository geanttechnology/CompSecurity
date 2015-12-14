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
import com.flurry.sdk.ar;
import com.flurry.sdk.ay;
import com.flurry.sdk.ex;
import com.flurry.sdk.fi;
import com.flurry.sdk.go;
import com.flurry.sdk.gq;
import com.flurry.sdk.gs;
import com.flurry.sdk.gy;
import com.flurry.sdk.i;
import com.flurry.sdk.jo;
import com.flurry.sdk.jw;
import com.flurry.sdk.jx;
import com.flurry.sdk.jy;
import com.flurry.sdk.kc;
import com.flurry.sdk.ld;
import com.flurry.sdk.lr;
import com.flurry.sdk.q;
import com.flurry.sdk.s;
import com.flurry.sdk.w;
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
    private gq c;
    private boolean d;
    private s e;
    private gy f;
    private boolean g;
    private jx h;
    private com.flurry.sdk.gq.a i;

    public FlurryFullscreenTakeoverActivity()
    {
        g = false;
        h = new jx() {

            final FlurryFullscreenTakeoverActivity a;

            public void a(go go1)
            {
                jo.a().a(new lr(this, go1) {

                    final go a;
                    final _cls1 b;

                    public void a()
                    {
                        com.flurry.sdk.go.a a1 = a.e;
                        class _cls3
                        {

                            static final int a[];

                            static 
                            {
                                a = new int[com.flurry.sdk.go.a.values().length];
                                try
                                {
                                    a[com.flurry.sdk.go.a.a.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    a[com.flurry.sdk.go.a.b.ordinal()] = 2;
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
                            kc.a(3, FlurryFullscreenTakeoverActivity.a(), (new StringBuilder("RELOAD_ACTIVITY Event was fired for adObject:")).append(a.a.e()).append(" for url:").append(a.b).append(" and should Close Ad:").append(a.c).toString());
                            FlurryFullscreenTakeoverActivity.a(b.a, new gy(a.a, a.b, a.c, a.d));
                            FlurryFullscreenTakeoverActivity.a(b.a, FlurryFullscreenTakeoverActivity.a(b.a).c());
                            if (FlurryFullscreenTakeoverActivity.b(b.a) == null)
                            {
                                kc.b(FlurryFullscreenTakeoverActivity.a(), "Cannot launch Activity. No Ad Controller");
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
                            kc.a(FlurryFullscreenTakeoverActivity.a(), "CLOSE_ACTIVITY Event was fired :");
                            b.a.finish();
                            return;
                        }
                    }

            
            {
                b = _pcls1;
                a = go1;
                super();
            }
                });
            }

            public volatile void a(jw jw)
            {
                a((go)jw);
            }

            
            {
                a = FlurryFullscreenTakeoverActivity.this;
                super();
            }
        };
        i = new com.flurry.sdk.gq.a() {

            final FlurryFullscreenTakeoverActivity a;

            public void a()
            {
                kc.a(FlurryFullscreenTakeoverActivity.a(), "onViewBack");
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
                kc.a(FlurryFullscreenTakeoverActivity.a(), "onViewClose");
                FlurryFullscreenTakeoverActivity.d(a);
                a.finish();
            }

            public void c()
            {
                kc.a(FlurryFullscreenTakeoverActivity.a(), "onViewError");
                FlurryFullscreenTakeoverActivity.d(a);
                a.finish();
            }

            
            {
                a = FlurryFullscreenTakeoverActivity.this;
                super();
            }
        };
    }

    static gy a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        return flurryfullscreentakeoveractivity.f;
    }

    static gy a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, gy gy1)
    {
        flurryfullscreentakeoveractivity.f = gy1;
        return gy1;
    }

    static s a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, s s1)
    {
        flurryfullscreentakeoveractivity.e = s1;
        return s1;
    }

    static String a()
    {
        return a;
    }

    static void a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, boolean flag)
    {
        flurryfullscreentakeoveractivity.a(flag);
    }

    private void a(gq gq1)
    {
        e();
        c = gq1;
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        b.addView(gq1, layoutparams);
        setContentView(b);
    }

    private void a(boolean flag)
    {
        g = flag;
    }

    static s b(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
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
        String s1 = getIntent().getStringExtra("url");
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
        e = ((s) (obj));
        if (e == null)
        {
            kc.b(a, "Cannot launch Activity. No ad object.");
            finish();
            return;
        } else
        {
            f = new gy(e, s1, flag1, flag2);
            e.l().b(true);
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
        kc.a(3, a, (new StringBuilder("Load View in Activity: ")).append(f.toString()).toString());
        gq gq1 = gs.a(this, f.c(), f.a(), i, f.d(), b());
        if (gq1 != null)
        {
            e();
            a(gq1);
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
            kc.a(a, (new StringBuilder("Save view state: ")).append(f.toString()).toString());
            e.l().a(f);
        }
    }

    public final void finish()
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

    public final void fireEvent(ay ay1, Map map, int j)
    {
        kc.a(a, (new StringBuilder("fireEvent(event=")).append(ay1).append(",params=").append(map).append(")").toString());
        ex.a(ay1, map, this, e, e.l(), j);
    }

    public final void loadViewState()
    {
        f = e.l().t();
        if (f == null)
        {
            finish();
            return;
        } else
        {
            kc.a(a, (new StringBuilder("Load view state: ")).append(f.toString()).toString());
            return;
        }
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        kc.a(3, a, "onConfigurationChanged");
        if (c != null)
        {
            c.onConfigurationChanged();
        }
    }

    public final void onCreate(Bundle bundle)
    {
        setTheme(0x1030007);
        super.onCreate(bundle);
        kc.a(3, a, "onCreate");
        if (jo.a() == null)
        {
            kc.a(3, a, "Flurry core not initialized.");
            finish();
            return;
        }
        fi.a(getWindow());
        setVolumeControlStream(3);
        b = new RelativeLayout(this);
        c();
        f();
        a(true);
        if (e != null)
        {
            fireEvent(ay.Q, Collections.emptyMap(), 0);
            return;
        } else
        {
            kc.b(a, "FlurryFullscreenTakeoverActivity cannot be launched as the internal ad object could not be found. Please ensure that the ad object is displayed in the same Context in which it was created, and that the ad object was not deleted.");
            return;
        }
    }

    protected final void onDestroy()
    {
        super.onDestroy();
        kc.a(3, a, "onDestroy");
        if (c != null)
        {
            c.onActivityDestroy();
        }
        if (e != null && e.l() != null)
        {
            e.l().u();
            e.l().b(false);
        }
        if (e != null && e.l().x())
        {
            kc.a(a, "AdClose: Firing ad close.");
            fireEvent(ay.v, Collections.emptyMap(), 0);
            return;
        } else
        {
            kc.b(a, "FlurryFullscreenTakeoverActivity cannot destroy internal ad object as the object could not be found. Please ensure that the ad object is displayed in the same Context in which it was created, and that the ad object was not deleted.");
            return;
        }
    }

    public final boolean onKeyUp(int j, KeyEvent keyevent)
    {
        kc.a(3, a, "onKeyUp");
        if (j == 4 && c != null)
        {
            c.onBackKey();
            return true;
        } else
        {
            return super.onKeyUp(j, keyevent);
        }
    }

    protected final void onPause()
    {
        kc.a(3, a, "onPause");
        super.onPause();
        if (c != null)
        {
            c.onActivityPause();
        }
    }

    protected final void onRestart()
    {
        kc.a(3, a, "onRestart");
        super.onRestart();
        loadViewState();
    }

    protected final void onResume()
    {
        kc.a(3, a, "onActivityResume");
        super.onResume();
        if (c != null)
        {
            c.onActivityResume();
        }
    }

    public final void onStart()
    {
        super.onStart();
        kc.a(3, a, "onStart");
        ld.a().b(this);
        registerActivityEvent();
        d();
        if (c != null)
        {
            c.onActivityStart();
        }
    }

    public final void onStop()
    {
        super.onStop();
        kc.a(3, a, "onStop");
        if (c != null)
        {
            c.onActivityStop();
        }
        a(false);
        unregisterActivityEvent();
        ld.a().c(this);
    }

    public final void registerActivityEvent()
    {
        jy.a().a("com.flurry.android.impl.ads.views.ActivityEvent", h);
    }

    public final void removeViewState()
    {
        if (e.l() != null)
        {
            gy gy1 = e.l().s();
            kc.a(a, (new StringBuilder("Remove view state: ")).append(gy1.toString()).toString());
        }
    }

    public final void unregisterActivityEvent()
    {
        jy.a().a(h);
    }

}

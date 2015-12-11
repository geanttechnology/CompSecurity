// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.WebView;
import com.appnexus.opensdk.a.b;
import com.appnexus.opensdk.a.h;
import com.appnexus.opensdk.a.i;
import com.appnexus.opensdk.b.j;
import java.lang.ref.WeakReference;

// Referenced classes of package com.appnexus.opensdk:
//            k, m, z, ap, 
//            e, r, ae

public class o extends k
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        private static final a j[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/appnexus/opensdk/o$a, s1);
        }

        public static a[] values()
        {
            return (a[])j.clone();
        }

        final int a()
        {
            static final class _cls2
            {

                static final int a[];

                static 
                {
                    a = new int[a.values().length];
                    try
                    {
                        a[a.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        a[com.appnexus.opensdk.a.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        a[a.c.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        a[a.d.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        a[a.e.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        a[a.f.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[a.g.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[com.appnexus.opensdk.a.h.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[com.appnexus.opensdk.a.i.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls2.a[ordinal()])
            {
            case 5: // '\005'
            default:
                return 17;

            case 1: // '\001'
                return 51;

            case 2: // '\002'
                return 49;

            case 3: // '\003'
                return 53;

            case 4: // '\004'
                return 19;

            case 6: // '\006'
                return 21;

            case 7: // '\007'
                return 83;

            case 8: // '\b'
                return 81;

            case 9: // '\t'
                return 85;
            }
        }

        static 
        {
            a = new a("TOP_LEFT", 0);
            b = new a("TOP_CENTER", 1);
            c = new a("TOP_RIGHT", 2);
            d = new a("CENTER_LEFT", 3);
            e = new a("CENTER", 4);
            f = new a("CENTER_RIGHT", 5);
            g = new a("BOTTOM_LEFT", 6);
            h = new a("BOTTOM_CENTER", 7);
            i = new a("BOTTOM_RIGHT", 8);
            j = (new a[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private a(String s1, int l)
        {
            super(s1, l);
        }
    }

    final class b
        implements android.view.animation.Animation.AnimationListener
    {

        final o a;
        private final WeakReference b;
        private final WeakReference c;

        public final void onAnimationEnd(Animation animation)
        {
            animation.setAnimationListener(null);
            animation = (r)b.get();
            com.appnexus.opensdk.a.b b1 = (com.appnexus.opensdk.a.b)c.get();
            if (animation != null && b1 != null)
            {
                animation.b().getHandler().post(new Runnable(this, b1, animation) {

                    final com.appnexus.opensdk.a.b a;
                    final r b;
                    final b c;

                    public final void run()
                    {
                        a.clearAnimation();
                        b.destroy();
                        a.a();
                    }

            
            {
                c = b1;
                a = b2;
                b = r1;
                super();
            }
                });
            }
        }

        public final void onAnimationRepeat(Animation animation)
        {
        }

        public final void onAnimationStart(Animation animation)
        {
        }

        b(r r1, com.appnexus.opensdk.a.b b1)
        {
            a = o.this;
            super();
            b = new WeakReference(r1);
            c = new WeakReference(b1);
        }
    }


    private com.appnexus.opensdk.a.b A;
    private boolean B;
    private a C;
    protected boolean q;
    public r r;
    protected int s;
    protected int t;
    private int u;
    private boolean v;
    private boolean w;
    private BroadcastReceiver x;
    private boolean y;
    private boolean z;

    public o(Context context)
    {
        super(context);
    }

    static int a(o o1)
    {
        return o1.u;
    }

    static boolean b(o o1)
    {
        return o1.w;
    }

    private void k()
    {
        if (x != null)
        {
            return;
        } else
        {
            IntentFilter intentfilter = new IntentFilter("android.intent.action.SCREEN_OFF");
            intentfilter.addAction("android.intent.action.SCREEN_ON");
            x = new BroadcastReceiver() {

                final o a;

                public final void onReceive(Context context, Intent intent)
                {
                    boolean flag = true;
                    if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
                    {
                        a.i();
                        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.screen_off_stop));
                    } else
                    if (intent.getAction().equals("android.intent.action.SCREEN_ON"))
                    {
                        if (o.a(a) > 0)
                        {
                            a.h();
                        } else
                        if (com.appnexus.opensdk.o.b(a))
                        {
                            a.i();
                            a.h();
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.screen_on_start));
                            return;
                        }
                    }
                }

            
            {
                a = o.this;
                super();
            }
            };
            getContext().registerReceiver(x, intentfilter);
            return;
        }
    }

    protected final void a(int l, int i1, m m1)
    {
        Display display = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
        float f1;
        int j1;
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            display.getSize(point);
            j1 = point.x;
        } else
        {
            j1 = display.getWidth();
        }
        f1 = (float)j1 / (float)l;
        l = (int)Math.floor((float)i1 * f1);
        s = getLayoutParams().height;
        t = getLayoutParams().width;
        if (getLayoutParams().width > 0 || getLayoutParams().width == -2)
        {
            getLayoutParams().width = j1;
        }
        getLayoutParams().height = l;
        if (m1.getLayoutParams() == null)
        {
            m1.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        } else
        {
            m1.getLayoutParams().width = -1;
            m1.getLayoutParams().height = -1;
        }
        m1.setInitialScale((int)Math.ceil(100F * f1));
        m1.invalidate();
        q = true;
    }

    protected final void a(Context context, AttributeSet attributeset)
    {
        u = 30000;
        q = false;
        y = false;
        z = false;
        A = new com.appnexus.opensdk.a.b(getContext(), i.a, h.a);
        super.a(context, attributeset);
        if (u > 0)
        {
            k();
        }
        j.a = z.a;
        a.a(u);
        if (B)
        {
            a.b();
        }
    }

    protected final void a(ae ae)
    {
        a(((r) (ae)));
    }

    protected final void a(r r1)
    {
        if (r1 == null || r1.c() || r1.b() == null)
        {
            com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.b, "Loaded an ad with an invalid displayable");
            return;
        }
        r = r1;
        if (getTransitionType() != i.a) goto _L2; else goto _L1
_L1:
        removeAllViews();
        if (f != null)
        {
            f.destroy();
        }
        View view = r1.b();
        addView(view);
        if (view.getLayoutParams() != null)
        {
            ((android.widget.FrameLayout.LayoutParams)view.getLayoutParams()).gravity = getAdAlignment().a();
        }
_L4:
        super.j_();
        f = r1;
        return;
_L2:
        if (getChildCount() == 0 || indexOfChild(A) >= 0)
        {
            removeAllViews();
            addView(A);
        }
        A.addView(r1.b());
        if (r1.b().getLayoutParams() != null)
        {
            ((android.widget.FrameLayout.LayoutParams)r1.b().getLayoutParams()).gravity = getAdAlignment().a();
            A.setLayoutParams(r1.b().getLayoutParams());
        }
        A.showNext();
        r r2 = f;
        if (r2 != null)
        {
            if (r2.b().getAnimation() != null)
            {
                r2.b().getAnimation().setAnimationListener(new b(r2, A));
            } else
            {
                r2.destroy();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void b(Context context, AttributeSet attributeset)
    {
        v = false;
        u = 30000;
        w = false;
        B = false;
        context = context.obtainStyledAttributes(attributeset, an.e.BannerAdView);
        int i2 = context.getIndexCount();
        com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.found_n_in_xml, i2));
        int j1 = -1;
        int i1 = -1;
        int l = 0;
        while (l < i2) 
        {
            int j2 = context.getIndex(l);
            int k1;
            int l1;
            if (j2 == an.e.BannerAdView_placement_id)
            {
                setPlacementID(context.getString(j2));
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.placement_id, context.getString(j2)));
                l1 = i1;
                k1 = j1;
            } else
            if (j2 == an.e.BannerAdView_auto_refresh_interval)
            {
                k1 = context.getInt(j2, 30000);
                setAutoRefreshInterval(k1);
                if (k1 <= 0)
                {
                    B = true;
                }
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.xml_set_period, k1));
                k1 = j1;
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_test)
            {
                com.appnexus.opensdk.b.j.a().i = context.getBoolean(j2, false);
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.xml_set_test, com.appnexus.opensdk.b.j.a().i));
                k1 = j1;
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_adWidth)
            {
                l1 = context.getInt(j2, -1);
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.xml_ad_width, context.getInt(j2, -1)));
                k1 = j1;
            } else
            if (j2 == an.e.BannerAdView_adHeight)
            {
                k1 = context.getInt(j2, -1);
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.xml_ad_height, context.getInt(j2, -1)));
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_should_reload_on_resume)
            {
                setShouldReloadOnResume(context.getBoolean(j2, false));
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.xml_set_should_reload, w));
                k1 = j1;
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_opens_native_browser)
            {
                setOpensNativeBrowser(context.getBoolean(j2, false));
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.xml_set_opens_native_browser, getOpensNativeBrowser()));
                k1 = j1;
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_expands_to_fit_screen_width)
            {
                setExpandsToFitScreenWidth(context.getBoolean(j2, false));
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.xml_set_expands_to_full_screen_width, y));
                k1 = j1;
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_show_loading_indicator)
            {
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.show_loading_indicator_xml));
                setShowLoadingIndicator(context.getBoolean(j2, true));
                k1 = j1;
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_transition_type)
            {
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.transition_type));
                setTransitionType(com.appnexus.opensdk.a.i.a(context.getInt(j2, 0)));
                k1 = j1;
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_transition_direction)
            {
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.transition_direction));
                setTransitionDirection(com.appnexus.opensdk.a.h.a(context.getInt(j2, 0)));
                k1 = j1;
                l1 = i1;
            } else
            if (j2 == an.e.BannerAdView_transition_duration)
            {
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.transition_duration));
                setTransitionDuration(context.getInt(j2, 1000));
                k1 = j1;
                l1 = i1;
            } else
            {
                k1 = j1;
                l1 = i1;
                if (j2 == an.e.BannerAdView_load_landing_page_in_background)
                {
                    setLoadsInBackground(context.getBoolean(j2, true));
                    com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.g, com.appnexus.opensdk.b.b.a(an.d.xml_load_landing_page_in_background, i));
                    k1 = j1;
                    l1 = i1;
                }
            }
            l++;
            j1 = k1;
            i1 = l1;
        }
        if (i1 != -1 && j1 != -1)
        {
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.set_size, i1, j1));
            j.d = i1;
            j.e = j1;
        }
        context.recycle();
    }

    final boolean e()
    {
        return true;
    }

    final boolean f()
    {
        return false;
    }

    final void g()
    {
    }

    public a getAdAlignment()
    {
        if (C == null)
        {
            C = a.e;
        }
        return C;
    }

    public int getAdHeight()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.get_height, j.b()));
        return j.b();
    }

    public int getAdWidth()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.get_width, j.a()));
        return j.a();
    }

    public int getAutoRefreshInterval()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.get_period, u));
        return u;
    }

    public boolean getExpandsToFitScreenWidth()
    {
        return y;
    }

    public int getMaxHeight()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.get_max_height, j.e()));
        return j.e();
    }

    public int getMaxWidth()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.get_max_width, j.d()));
        return j.d();
    }

    public z getMediaType()
    {
        return z.a;
    }

    public boolean getOverrideMaxSize()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.get_override_max_size, j.c()));
        return j.c();
    }

    public boolean getShouldReloadOnResume()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.get_should_resume, w));
        return w;
    }

    public h getTransitionDirection()
    {
        return A.getTransitionDirection();
    }

    public long getTransitionDuration()
    {
        return A.getTransitionDuration();
    }

    public i getTransitionType()
    {
        return A.getTransitionType();
    }

    final void h()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.start));
        a.b();
        v = true;
    }

    final void i()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.stop));
        a.a();
        v = false;
    }

    final void j()
    {
        if (q)
        {
            q = false;
            if (getLayoutParams() != null)
            {
                getLayoutParams().height = s;
                getLayoutParams().width = t;
            }
        }
    }

    protected final void j_()
    {
        super.j_();
    }

    public final void k_()
    {
        super.k_();
    }

    public final void onLayout(boolean flag, int l, int i1, int j1, int k1)
    {
        super.onLayout(flag, l, i1, j1, k1);
        if (!b) goto _L2; else goto _L1
_L1:
        b = false;
_L4:
        return;
_L2:
        if (z && !flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        float f1 = getContext().getResources().getDisplayMetrics().density;
        l = (int)((float)(j1 - l) / f1 + 0.5F);
        i1 = (int)((float)(k1 - i1) / f1 + 0.5F);
        if (i1 >= j.b() && l >= j.b() || i1 <= 0 || l <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.adsize_too_big, l, i1, j.b(), j.b()));
        c();
        if (a != null)
        {
            a.a();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        j.f = l;
        j.g = i1;
        if (!z && !g)
        {
            c();
        }
        g = false;
        z = true;
        if (!v) goto _L4; else goto _L5
_L5:
        k();
        if (w)
        {
            h();
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void onWindowVisibilityChanged(int l)
    {
        super.onWindowVisibilityChanged(l);
        if (l == 0)
        {
            k();
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.unhidden));
            if ((v || w || u > 0) && !k && !b && !super.h && a != null && !g)
            {
                h();
            }
            k = false;
            if (getChildAt(0) instanceof WebView)
            {
                com.appnexus.opensdk.b.o.b((WebView)getChildAt(0));
            }
        } else
        {
            if (x != null)
            {
                try
                {
                    getContext().unregisterReceiver(x);
                }
                catch (IllegalArgumentException illegalargumentexception) { }
                x = null;
            }
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.hidden));
            if (a != null && v)
            {
                i();
            }
            if (getChildAt(0) instanceof WebView)
            {
                com.appnexus.opensdk.b.o.c((WebView)getChildAt(0));
                return;
            }
        }
    }

    public void setAdAlignment(a a1)
    {
        C = a1;
    }

    public void setAdHeight(int l)
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.set_height, l));
        j.e = l;
    }

    public void setAdWidth(int l)
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.set_width, l));
        j.d = l;
    }

    public void setAutoRefreshInterval(int l)
    {
        if (l > 0)
        {
            u = Math.max(15000, l);
        } else
        {
            u = l;
        }
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.set_period, u));
        if (a != null)
        {
            a.a(u);
        }
    }

    public void setExpandsToFitScreenWidth(boolean flag)
    {
        y = flag;
    }

    public void setOverrideMaxSize(boolean flag)
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.set_override_max_size, flag));
        j.p = flag;
    }

    public void setShouldReloadOnResume(boolean flag)
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.set_should_resume, flag));
        w = flag;
    }

    public void setTransitionDirection(h h1)
    {
        A.setTransitionDirection(h1);
    }

    public void setTransitionDuration(long l)
    {
        A.setTransitionDuration(l);
    }

    public void setTransitionType(i l)
    {
        A.setTransitionType(l);
    }
}

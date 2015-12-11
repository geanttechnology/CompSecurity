// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.appnexus.opensdk.b.a;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.b.l;
import java.util.ArrayList;

// Referenced classes of package com.appnexus.opensdk:
//            c, x, m, ap, 
//            e, AdActivity, r, f, 
//            n, ae, d, i, 
//            z, aq, v

public abstract class k extends FrameLayout
    implements com.appnexus.opensdk.c
{
    private final class a
        implements d
    {

        Handler a;
        final k b;

        public final void a()
        {
            a.post(new Runnable(this) {

                final a a;

                public final void run()
                {
                    if (com.appnexus.opensdk.k.a(a.b) != null)
                    {
                        com.appnexus.opensdk.k.a(a.b).b();
                    }
                }

            
            {
                a = a1;
                super();
            }
            });
        }

        public final void a(aq aq1)
        {
            a.post(new Runnable(this, aq1) {

                final aq a;
                final a b;

                public final void run()
                {
                    if (com.appnexus.opensdk.k.a(b.b) != null)
                    {
                        com.appnexus.opensdk.k.a(b.b).a();
                    }
                }

            
            {
                b = a1;
                a = aq;
                super();
            }
            });
        }

        public final void a(i i1)
        {
            if (i1.a().equals(com.appnexus.opensdk.z.a) || i1.a().equals(com.appnexus.opensdk.z.b))
            {
                a.post(new Runnable(this, i1) {

                    final i a;
                    final a b;

                    public final void run()
                    {
                        b.b.setCreativeWidth(a.c().d());
                        b.b.setCreativeHeight(a.c().e());
                        if (a.b())
                        {
                            try
                            {
                                b.b.a((ae)a.c());
                            }
                            catch (ClassCastException classcastexception)
                            {
                                com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.b, "The SDK shouldn't fail downcasts to MediatedDisplayable in AdView");
                            }
                        } else
                        {
                            b.b.a(a.c());
                        }
                        if (com.appnexus.opensdk.k.a(b.b) != null)
                        {
                            com.appnexus.opensdk.k.a(b.b).a(b.b);
                        }
                    }

            
            {
                b = a1;
                a = i1;
                super();
            }
                });
                return;
            } else
            {
                a(aq.f);
                return;
            }
        }

        public final void a(String s1, String s2)
        {
            a.post(new Runnable(this, s1, s2) {

                final String a;
                final String b;
                final a c;

                public final void run()
                {
                }

            
            {
                c = a1;
                a = s1;
                b = s2;
                super();
            }
            });
        }

        public final void b()
        {
            a.post(new Runnable(this) {

                final a a;

                public final void run()
                {
                    if (com.appnexus.opensdk.k.a(a.b) != null)
                    {
                        com.appnexus.opensdk.k.a(a.b).c();
                    }
                }

            
            {
                a = a1;
                super();
            }
            });
        }

        public final void c()
        {
            a.post(new Runnable(this) {

                final a a;

                public final void run()
                {
                    if (com.appnexus.opensdk.k.a(a.b) != null)
                    {
                        com.appnexus.opensdk.k.a(a.b).d();
                    }
                }

            
            {
                a = a1;
                super();
            }
            });
        }

        public a(Handler handler)
        {
            b = k.this;
            super();
            a = handler;
        }
    }

    static final class b
    {

        static final ArrayList d = new ArrayList();
        final Drawable a;
        final Drawable b;
        final Drawable c;

    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s1)
        {
            return (c)Enum.valueOf(com/appnexus/opensdk/k$c, s1);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("UNKNOWN", 0);
            b = new c("MALE", 1);
            c = new c("FEMALE", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    static FrameLayout m;
    static x n;
    static m.b o;
    public e a;
    boolean b;
    int c;
    int d;
    final Handler e;
    protected r f;
    public boolean g;
    boolean h;
    boolean i;
    public ap j;
    boolean k;
    ImageButton l;
    int p;
    private f q;
    private n r;
    private b s;
    private a t;
    private boolean u;
    private boolean v;

    k(Context context)
    {
        this(context, (byte)0);
    }

    private k(Context context, byte byte0)
    {
        super(context, null, 0);
        b = false;
        e = new Handler(Looper.getMainLooper());
        g = false;
        h = false;
        i = true;
        u = false;
        v = true;
        k = false;
        p = 0;
        a(context, ((AttributeSet) (null)));
    }

    static f a(k k1)
    {
        return k1.q;
    }

    private void a(int i1, int j1)
    {
        b = true;
        if (getLayoutParams() != null)
        {
            if (getLayoutParams().width > 0)
            {
                getLayoutParams().width = i1;
            }
            if (getLayoutParams().height > 0)
            {
                getLayoutParams().height = j1;
            }
        }
        if (u && (getParent() instanceof View))
        {
            View view = (View)getParent();
            if (view.getLayoutParams() != null)
            {
                if (view.getLayoutParams().width > 0)
                {
                    view.getLayoutParams().width = i1;
                }
                if (view.getLayoutParams().height > 0)
                {
                    view.getLayoutParams().height = j1;
                }
            }
        }
    }

    final void a(int i1, int j1, x.a a1, x x1)
    {
        android.widget.FrameLayout.LayoutParams layoutparams;
        a(i1, j1);
        com.appnexus.opensdk.b.l.a(l);
        if (p <= 0)
        {
            p = (int)(x1.b.getContext().getResources().getDisplayMetrics().density * 50F);
        }
        l = new ImageButton(getContext(), x1) {

            final x a;
            final k b;

            public final void onLayout(boolean flag, int k1, int l1, int i2, int j2)
            {
                int ai[];
                Point point;
                ai = new int[2];
                getLocationOnScreen(ai);
                point = new Point(0, 0);
                Object obj = (Activity)a.b.getContext();
                k1 = 1;
_L1:
                int ai1[];
                int k2;
                if (k1 != 0)
                {
                    if (android.os.Build.VERSION.SDK_INT >= 13)
                    {
                        ((Activity) (obj)).getWindowManager().getDefaultDisplay().getSize(point);
                    } else
                    {
                        point.x = ((Activity) (obj)).getWindowManager().getDefaultDisplay().getWidth();
                        point.y = ((Activity) (obj)).getWindowManager().getDefaultDisplay().getHeight();
                    }
                }
                ai1 = new int[2];
                if (b.getMediaType().equals(com.appnexus.opensdk.z.b))
                {
                    v.q.measure(0, 0);
                    v.q.getLocationOnScreen(ai1);
                    obj = new Point(v.q.getMeasuredWidth(), v.q.getMeasuredHeight());
                } else
                {
                    b.measure(0, 0);
                    b.getLocationOnScreen(ai1);
                    obj = new Point(b.getMeasuredWidth(), b.getMeasuredHeight());
                }
                j2 = ((Point) (obj)).x;
                k2 = b.p;
                l1 = ((Point) (obj)).y;
                i2 = b.p;
                if (k1 != 0)
                {
                    j2 = (ai1[0] + Math.min(point.x, ((Point) (obj)).x)) - b.p;
                    k1 = ai1[1];
                    i2 = (Math.min(point.y, ((Point) (obj)).y) + k1) - b.p;
                    l1 = ai1[0];
                    k1 = ai1[1];
                } else
                {
                    k1 = 0;
                    j2 -= k2;
                    i2 = l1 - i2;
                    l1 = 0;
                }
                if (ai[0] + 1 < l1 || ai[0] - 1 > j2 || ai[1] + 1 < k1 || ai[1] - 1 > i2)
                {
                    obj = new android.widget.FrameLayout.LayoutParams(getLayoutParams());
                    ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(0, 0, 0, 0);
                    obj.gravity = 51;
                    post(new Runnable(this, ((android.widget.FrameLayout.LayoutParams) (obj))) {

                        final android.widget.FrameLayout.LayoutParams a;
                        final _cls2 b;

                        public final void run()
                        {
                            b.setLayoutParams(a);
                        }

            
            {
                b = _pcls2;
                a = layoutparams;
                super();
            }
                    });
                    b.l.setImageDrawable(getResources().getDrawable(0x1080038));
                }
                return;
                obj;
                k1 = 0;
                obj = null;
                  goto _L1
            }

            
            {
                b = k.this;
                a = x1;
                super(context);
            }
        };
        layoutparams = new android.widget.FrameLayout.LayoutParams(p, p, 17);
        j1 = j1 / 2 - p / 2;
        i1 = i1 / 2 - p / 2;
        static final class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[x.a.values().length];
                try
                {
                    a[x.a.g.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[x.a.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[x.a.e.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[x.a.c.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[x.a.f.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.appnexus.opensdk.x.a.a.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.appnexus.opensdk.x.a.b.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.appnexus.opensdk._cls4.a[a1.ordinal()];
        JVM INSTR tableswitch 1 7: default 156
    //                   1 220
    //                   2 229
    //                   3 244
    //                   4 156
    //                   5 259
    //                   6 268
    //                   7 283;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7
_L1:
        l.setLayoutParams(layoutparams);
        l.setBackgroundColor(0);
        l.setOnClickListener(new android.view.View.OnClickListener(x1) {

            final x a;
            final k b;

            public final void onClick(View view)
            {
                a.a();
            }

            
            {
                b = k.this;
                a = x1;
                super();
            }
        });
        if (x1.b.getParent() != null)
        {
            ((ViewGroup)x1.b.getParent()).addView(l);
        }
        return;
_L2:
        layoutparams.topMargin = j1;
        continue; /* Loop/switch isn't completed */
_L3:
        layoutparams.rightMargin = i1;
        layoutparams.topMargin = j1;
        continue; /* Loop/switch isn't completed */
_L4:
        layoutparams.leftMargin = i1;
        layoutparams.topMargin = j1;
        continue; /* Loop/switch isn't completed */
_L5:
        layoutparams.bottomMargin = j1;
        continue; /* Loop/switch isn't completed */
_L6:
        layoutparams.rightMargin = i1;
        layoutparams.bottomMargin = j1;
        continue; /* Loop/switch isn't completed */
_L7:
        layoutparams.leftMargin = i1;
        layoutparams.bottomMargin = j1;
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected final void a(int i1, int j1, x x1)
    {
        com.appnexus.opensdk.b.l.a(l);
        l = null;
        if (x1.b.g)
        {
            com.appnexus.opensdk.b.l.a(x1.b);
            if (x1.k != null)
            {
                x1.k.addView(x1.b, 0);
            }
            if (x1.j != null)
            {
                x1.j.finish();
            }
        }
        m = null;
        n = null;
        o = null;
        a(i1, j1);
        k = true;
        h = false;
    }

    final void a(int i1, int j1, boolean flag, x x1, m.b b1)
    {
        a(i1, j1);
        l = com.appnexus.opensdk.b.l.a(getContext(), flag);
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)l.getLayoutParams();
        if (!x1.b.g && getChildAt(0) != null)
        {
            layoutparams.rightMargin = (getMeasuredWidth() - getChildAt(0).getMeasuredWidth()) / 2;
        }
        l.setLayoutParams(layoutparams);
        l.setOnClickListener(new android.view.View.OnClickListener(x1) {

            final x a;
            final k b;

            public final void onClick(View view)
            {
                a.a();
            }

            
            {
                b = k.this;
                a = x1;
                super();
            }
        });
        if (!x1.b.g) goto _L2; else goto _L1
_L1:
        a(x1, flag, b1);
_L4:
        h = true;
        return;
_L2:
        if (!flag)
        {
            addView(l);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void a(Context context, AttributeSet attributeset)
    {
        t = new a(e);
        j = new ap(context);
        com.appnexus.opensdk.b.a.a(context);
        com.appnexus.opensdk.b.b.a(getContext());
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.new_adview));
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedpreferences.getBoolean("opensdk_first_launch", true))
        {
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.first_opensdk_launch));
            com.appnexus.opensdk.b.j.a().k = true;
            sharedpreferences.edit().putBoolean("opensdk_first_launch", false).commit();
        } else
        {
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.not_first_opensdk_launch));
            com.appnexus.opensdk.b.j.a().k = false;
        }
        com.appnexus.opensdk.b.j.a().j = (new WebView(context)).getSettings().getUserAgentString();
        com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.ua, com.appnexus.opensdk.b.j.a().j));
        com.appnexus.opensdk.b.j.a().h = context.getApplicationContext().getPackageName();
        com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.appid, com.appnexus.opensdk.b.j.a().h));
        com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.making_adman));
        setPadding(0, 0, 0, 0);
        a = new e(this);
        if (attributeset != null)
        {
            b(context, attributeset);
        }
    }

    protected abstract void a(ae ae);

    protected abstract void a(r r1);

    protected final void a(x x1, boolean flag, m.b b1)
    {
        x1.k = (ViewGroup)x1.b.getParent();
        FrameLayout framelayout = new FrameLayout(getContext());
        com.appnexus.opensdk.b.l.a(x1.b);
        framelayout.addView(x1.b);
        if (l == null)
        {
            l = com.appnexus.opensdk.b.l.a(getContext(), flag);
        }
        if (!flag)
        {
            framelayout.addView(l);
        }
        m = framelayout;
        n = x1;
        o = b1;
        x1 = com.appnexus.opensdk.AdActivity.a();
        try
        {
            b1 = new Intent(getContext(), x1);
            b1.putExtra("ACTIVITY_TYPE", "MRAID");
            getContext().startActivity(b1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (m.b b1)
        {
            com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.adactivity_missing, x1.getName()));
        }
        m = null;
        n = null;
        o = null;
    }

    public final boolean a()
    {
        if (h)
        {
            com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.already_expanded));
            return false;
        }
        if (com.appnexus.opensdk.b.k.a(j.b))
        {
            com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.no_placement_id));
            return false;
        } else
        {
            return true;
        }
    }

    protected abstract void b(Context context, AttributeSet attributeset);

    final void c()
    {
        if (getVisibility() != 8)
        {
            setVisibility(8);
        }
    }

    abstract boolean e();

    abstract boolean f();

    protected void finalize()
    {
        try
        {
            super.finalize();
        }
        catch (Throwable throwable) { }
        if (a != null)
        {
            a.a();
        }
    }

    abstract void g();

    public d getAdDispatcher()
    {
        return t;
    }

    public f getAdListener()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.get_ad_listener));
        return q;
    }

    public String getAge()
    {
        return j.j;
    }

    public n getAppEventListener()
    {
        return r;
    }

    b getBrowserStyle()
    {
        return s;
    }

    int getContainerHeight()
    {
        return j.g;
    }

    int getContainerWidth()
    {
        return j.f;
    }

    public int getCreativeHeight()
    {
        return d;
    }

    public int getCreativeWidth()
    {
        return c;
    }

    public ArrayList getCustomKeywords()
    {
        return j.l;
    }

    public c getGender()
    {
        return j.k;
    }

    public boolean getLoadsInBackground()
    {
        return i;
    }

    public boolean getOpensNativeBrowser()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.get_opens_native_browser, j.c));
        return j.c;
    }

    public String getPlacementID()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.get_placement_id, j.b));
        return j.b;
    }

    public float getReserve()
    {
        return j.i;
    }

    public boolean getShouldServePSAs()
    {
        return j.h;
    }

    public boolean getShowLoadingIndicator()
    {
        return v;
    }

    void j_()
    {
        if (getVisibility() != 0)
        {
            setVisibility(0);
        }
    }

    public void k_()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, "called destroy() on AdView");
        if (f != null)
        {
            f.destroy();
            f = null;
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
    }

    public void setAdListener(f f1)
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.set_ad_listener));
        q = f1;
    }

    public void setAge(String s1)
    {
        j.j = s1;
    }

    public void setAppEventListener(n n1)
    {
        r = n1;
    }

    protected void setBrowserStyle(b b1)
    {
        s = b1;
    }

    void setCreativeHeight(int i1)
    {
        d = i1;
    }

    void setCreativeWidth(int i1)
    {
        c = i1;
    }

    public void setGender(c c1)
    {
        j.k = c1;
    }

    public void setLoadsInBackground(boolean flag)
    {
        i = flag;
    }

    public void setOpensNativeBrowser(boolean flag)
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.set_opens_native_browser, flag));
        j.c = flag;
    }

    public void setPlacementID(String s1)
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.d, com.appnexus.opensdk.b.b.a(an.d.set_placement_id, s1));
        j.b = s1;
    }

    public void setReserve(float f1)
    {
        j.i = f1;
    }

    protected void setShouldResizeParent(boolean flag)
    {
        u = flag;
    }

    public void setShouldServePSAs(boolean flag)
    {
        j.h = flag;
    }

    public void setShowLoadingIndicator(boolean flag)
    {
        v = flag;
    }
}

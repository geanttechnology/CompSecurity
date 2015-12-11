// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.shazam.android.p.i;
import com.shazam.android.v.g;
import com.shazam.android.v.m;
import com.shazam.i.b.e.a;
import com.shazam.i.b.e.b;
import com.shazam.i.b.r.d;
import com.shazam.model.Factory;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.AdvertisingInfo;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.android.advert:
//            j, n, d, l, 
//            c, f, b

public class ShazamAdView extends FrameLayout
{
    private static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a d[];
        final int c;

        public static a a(int i1)
        {
            a aa[] = values();
            int k1 = aa.length;
            for (int j1 = 0; j1 < k1; j1++)
            {
                a a1 = aa[j1];
                if (a1.c == i1)
                {
                    return a1;
                }
            }

            return a;
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/shazam/android/advert/ShazamAdView$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("APP_NEXUS", 0, 0);
            b = new a("FACEBOOK", 1, 1);
            d = (new a[] {
                a, b
            });
        }

        private a(String s, int i1, int j1)
        {
            super(s, i1);
            c = j1;
        }
    }


    private static final a b;
    private static final android.widget.FrameLayout.LayoutParams c = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
    boolean a;
    private final c d;
    private final com.shazam.android.advert.d.a e;
    private final l f;
    private com.shazam.android.advert.i.a g;
    private Factory h;
    private com.shazam.android.advert.h.a i;
    private com.shazam.android.j.a.a j;
    private n k;
    private l l;
    private a m;
    private boolean n;
    private Runnable o;

    public ShazamAdView(Context context)
    {
        super(context, null);
        d = com.shazam.i.b.e.a.a();
        e = new com.shazam.android.advert.d.a();
        f = new f() {

            final ShazamAdView a;

            public final void b(ShazamAdView shazamadview, com.shazam.android.advert.b b1, String s)
            {
                super.b(shazamadview, b1, s);
                com.shazam.android.advert.ShazamAdView.a(a);
            }

            
            {
                a = ShazamAdView.this;
                super();
            }
        };
        h = new j();
        m = b;
        a = true;
        i();
    }

    public ShazamAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = com.shazam.i.b.e.a.a();
        e = new com.shazam.android.advert.d.a();
        f = new _cls1();
        h = new j();
        m = b;
        a = true;
        a(context, attributeset);
        i();
    }

    public ShazamAdView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        d = com.shazam.i.b.e.a.a();
        e = new com.shazam.android.advert.d.a();
        f = new _cls1();
        h = new j();
        m = b;
        a = true;
        a(context, attributeset);
        i();
    }

    public static void a()
    {
    }

    private void a(Context context, AttributeSet attributeset)
    {
        if (attributeset != null)
        {
            context = context.obtainStyledAttributes(attributeset, com.shazam.android.b.a.ShazamAdView);
            m = com.shazam.android.advert.a.a(context.getInteger(0, b.c));
            context.recycle();
        }
    }

    static boolean a(ShazamAdView shazamadview)
    {
        shazamadview.n = true;
        return true;
    }

    static Runnable b(ShazamAdView shazamadview)
    {
        shazamadview.o = null;
        return null;
    }

    static com.shazam.android.advert.i.a c(ShazamAdView shazamadview)
    {
        return shazamadview.g;
    }

    public static void e()
    {
    }

    private Map getExtraTargetParams()
    {
        if (k == null || k.a() == null)
        {
            return new HashMap(0);
        } else
        {
            return k.a();
        }
    }

    private com.shazam.android.advert.d.a getImmediateAdvertConfigValues()
    {
        com.shazam.android.advert.d.a a1 = new com.shazam.android.advert.d.a();
        String s = android.os.Build.VERSION.RELEASE;
        a1.a.put("osv", s);
        return a1;
    }

    private void i()
    {
        if (!isInEditMode()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        static final class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[a.values().length];
                try
                {
                    a[com.shazam.android.advert.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.shazam.android.advert.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.shazam.android.advert._cls3.a[m.ordinal()])
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_180;
_L4:
        l = com.shazam.i.b.e.b.a();
        g = (com.shazam.android.advert.i.a)h.create(getContext());
        g.setListener(new com.shazam.android.advert.d(new l[] {
            l, f
        }));
        com.shazam.android.advert.i.a a1 = g;
        if (a1 instanceof View)
        {
            addView((View)a1, c);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        com.shazam.android.j.a.a a2 = com.shazam.i.b.n.b.z();
        Object obj;
        if (com.shazam.i.b.r.d.a().b)
        {
            obj = new com.shazam.android.v.a.a.a();
        } else
        {
            obj = new com.shazam.android.v.a.a.b();
        }
        h = new m(a2, ((com.shazam.android.advert.c.b) (obj)));
        j = com.shazam.i.b.n.b.z();
          goto _L4
        h = new g(com.shazam.i.b.n.b.A());
        j = com.shazam.i.b.n.b.A();
          goto _L4
    }

    public final void b()
    {
        g.h_();
        h();
    }

    public final void c()
    {
        g.h_();
    }

    public final void d()
    {
        g.b();
    }

    public final void f()
    {
        g.i_();
        o = null;
        i = null;
        k = null;
        g();
    }

    public final void g()
    {
        g.d();
    }

    public boolean getAndResetAdClick()
    {
        boolean flag = n;
        n = false;
        return flag;
    }

    public final void h()
    {
        if (n)
        {
            n = false;
            return;
        }
        AdvertSiteIdKey advertsiteidkey = i.f();
        String s = j.a(advertsiteidkey);
        if (com.shazam.b.e.a.c(s))
        {
            Map map = j.c();
            Map map1 = com.shazam.i.e.a.a(map.size());
            map1.putAll(map);
            map1.putAll(e.a);
            map1.putAll(getExtraTargetParams());
            map1.putAll(getImmediateAdvertConfigValues().a);
            if (!d.d())
            {
                map1.put("dc_rdid", d.c());
            }
            if (hasWindowFocus())
            {
                g.a(s, advertsiteidkey, map1);
                return;
            } else
            {
                o = new Runnable(s, advertsiteidkey, map1) {

                    final String a;
                    final AdvertSiteIdKey b;
                    final Map c;
                    final ShazamAdView d;

                    public final void run()
                    {
                        com.shazam.android.advert.ShazamAdView.b(d);
                        ShazamAdView.c(d).a(a, b, c);
                    }

            
            {
                d = ShazamAdView.this;
                a = s;
                b = advertsiteidkey;
                c = map;
                super();
            }
                };
                return;
            }
        } else
        {
            setVisibility(8);
            return;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (a)
        {
            return super.onInterceptTouchEvent(motionevent);
        } else
        {
            return true;
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && o != null)
        {
            o.run();
        }
    }

    public void setAdvertSiteIdKeyProvider(com.shazam.android.advert.h.a a1)
    {
        i = a1;
    }

    public void setExtraTargetParamsProvider(n n1)
    {
        k = n1;
    }

    public void setListener(l l1)
    {
        g.setListener(new com.shazam.android.advert.d(new l[] {
            l, l1, f
        }));
    }

    public void setTrackAdvertInfo(AdvertisingInfo advertisinginfo)
    {
        com.shazam.android.advert.d.a a1 = e;
        if (advertisinginfo != null)
        {
            advertisinginfo = advertisinginfo.params;
            if (advertisinginfo != null)
            {
                a1.a.putAll(advertisinginfo);
            }
        }
    }

    static 
    {
        b = com.shazam.android.advert.a.a;
    }
}

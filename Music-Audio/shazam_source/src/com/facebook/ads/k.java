// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.support.v4.a.e;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.a.b.h;
import com.facebook.ads.a.b.j;
import com.facebook.ads.a.b.t;
import com.facebook.ads.a.b.u;
import com.facebook.ads.a.d;
import com.facebook.ads.a.f;
import com.facebook.ads.a.f.l;
import com.facebook.ads.a.f.m;
import com.facebook.ads.a.g.a.a;
import com.facebook.ads.a.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads:
//            a, c, g

public class k
    implements com.facebook.ads.a
{
    public static final class a
    {

        public final String a;
        private final int b;
        private final int c;

        public static a a(JSONObject jsonobject)
        {
            String s1;
            if (jsonobject != null)
            {
                if ((s1 = jsonobject.optString("url")) != null)
                {
                    return new a(s1, jsonobject.optInt("width", 0), jsonobject.optInt("height", 0));
                }
            }
            return null;
        }

        private a(String s1, int i1, int j1)
        {
            a = s1;
            b = i1;
            c = j1;
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final EnumSet d = EnumSet.allOf(com/facebook/ads/k$b);
        private static final b f[];
        private final long e;

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/facebook/ads/k$b, s1);
        }

        public static b[] values()
        {
            return (b[])f.clone();
        }

        static 
        {
            a = new b("NONE", 0, 0L);
            b = new b("ICON", 1, 1L);
            c = new b("IMAGE", 2, 2L);
            f = (new b[] {
                a, b, c
            });
        }

        private b(String s1, int i1, long l1)
        {
            super(s1, i1);
            e = l1;
        }
    }

    public static final class c
    {

        public final double a;
        public final double b;

        public c(double d1, double d2)
        {
            a = d1;
            b = d2;
        }
    }

    private final class d
        implements android.view.View.OnClickListener, android.view.View.OnTouchListener
    {

        final k a;
        private int b;
        private int c;
        private int d;
        private int e;
        private float f;
        private float g;
        private int h;
        private int i;
        private boolean j;

        public final void onClick(View view)
        {
            if (com.facebook.ads.k.a(a) != null)
            {
                com.facebook.ads.k.a(a).b(a);
            }
            if (!j)
            {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            view = new HashMap();
            view.put("clickX", Integer.valueOf(b));
            view.put("clickY", Integer.valueOf(c));
            view.put("width", Integer.valueOf(d));
            view.put("height", Integer.valueOf(e));
            view.put("adPositionX", Float.valueOf(f));
            view.put("adPositionY", Float.valueOf(g));
            view.put("visibleWidth", Integer.valueOf(i));
            view.put("visibleHeight", Integer.valueOf(h));
            if (com.facebook.ads.k.h(a) != null)
            {
                view.put("nti", String.valueOf(com.facebook.ads.k.h(a).a()));
            }
            if (com.facebook.ads.k.i(a))
            {
                view.put("nhs", String.valueOf(com.facebook.ads.k.i(a)));
            }
            com.facebook.ads.k.e(a).b(view);
        }

        public final boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0 && com.facebook.ads.k.f(a) != null)
            {
                d = com.facebook.ads.k.f(a).getWidth();
                e = com.facebook.ads.k.f(a).getHeight();
                int ai[] = new int[2];
                com.facebook.ads.k.f(a).getLocationInWindow(ai);
                f = ai[0];
                g = ai[1];
                Rect rect = new Rect();
                com.facebook.ads.k.f(a).getGlobalVisibleRect(rect);
                i = rect.width();
                h = rect.height();
                int ai1[] = new int[2];
                view.getLocationInWindow(ai1);
                b = ((int)motionevent.getX() + ai1[0]) - ai[0];
                int i1 = (int)motionevent.getY();
                c = (ai1[1] + i1) - ai[1];
                j = true;
            }
            return com.facebook.ads.k.m(a) != null && com.facebook.ads.k.m(a).onTouch(view, motionevent);
        }

        private d()
        {
            a = k.this;
            super();
        }

        d(byte byte0)
        {
            this();
        }
    }

    private final class e extends BroadcastReceiver
    {

        boolean a;
        final k b;

        public final void onReceive(Context context, Intent intent)
        {
            context = intent.getAction().split(":")[0];
            if ("com.facebook.ads.native.impression".equals(context))
            {
                k.g(b).a();
            } else
            if ("com.facebook.ads.native.click".equals(context))
            {
                context = new HashMap();
                context.put("mil", Boolean.valueOf(true));
                com.facebook.ads.k.e(b).b(context);
                return;
            }
        }

        private e()
        {
            b = k.this;
            super();
        }

        e(byte byte0)
        {
            this();
        }
    }

    private final class f extends h
    {

        final k a;

        public final boolean a()
        {
            return false;
        }

        public final void b()
        {
            if (com.facebook.ads.k.l(a) != null)
            {
                com.facebook.ads.k.l(a);
            }
            if ((com.facebook.ads.k.a(a) instanceof g) && com.facebook.ads.k.a(a) != com.facebook.ads.k.l(a))
            {
                com.facebook.ads.k.a(a);
            }
        }

        private f()
        {
            a = k.this;
            super();
        }

        f(byte byte0)
        {
            this();
        }
    }


    private static final com.facebook.ads.a.d e;
    private static final String f = com/facebook/ads/k.getSimpleName();
    private static WeakHashMap g = new WeakHashMap();
    public com.facebook.ads.c a;
    public u b;
    boolean c;
    boolean d;
    private final Context h;
    private final String i;
    private g j;
    private i k;
    private volatile boolean l;
    private com.facebook.ads.a.c.d m;
    private View n;
    private List o;
    private android.view.View.OnTouchListener p;
    private j q;
    private t r;
    private d s;
    private e t;
    private com.facebook.ads.a.g.i u;
    private m.a v;
    private boolean w;

    public k(Context context, String s1)
    {
        o = new ArrayList();
        h = context;
        i = s1;
    }

    static u a(k k1, u u1)
    {
        k1.b = u1;
        return u1;
    }

    static com.facebook.ads.c a(k k1)
    {
        return k1.a;
    }

    static i b(k k1)
    {
        return k1.k;
    }

    static Context c(k k1)
    {
        return k1.h;
    }

    static void d(k k1)
    {
        if (k1.b != null && k1.b.c())
        {
            k1.t = k1. new e((byte)0);
            e e1 = k1.t;
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction((new StringBuilder("com.facebook.ads.native.impression:")).append(e1.b.b.o()).toString());
            intentfilter.addAction((new StringBuilder("com.facebook.ads.native.click:")).append(e1.b.b.o()).toString());
            android.support.v4.a.e.a(e1.b.h).a(e1, intentfilter);
            e1.a = true;
            k1.r = new t(k1.h, k1. new h() {

                final k a;

                public final boolean a()
                {
                    return true;
                }

            
            {
                a = k.this;
                super();
            }
            }, k1.b);
        }
    }

    static u e(k k1)
    {
        return k1.b;
    }

    static View f(k k1)
    {
        return k1.n;
    }

    static t g(k k1)
    {
        return k1.r;
    }

    static m.a h(k k1)
    {
        return k1.v;
    }

    static boolean i(k k1)
    {
        return k1.w;
    }

    private void j()
    {
        View view;
        for (Iterator iterator = o.iterator(); iterator.hasNext(); view.setOnTouchListener(null))
        {
            view = (View)iterator.next();
            view.setOnClickListener(null);
        }

        o.clear();
    }

    static boolean j(k k1)
    {
        return k1.c;
    }

    static boolean k(k k1)
    {
        return k1.d;
    }

    static g l(k k1)
    {
        return k1.j;
    }

    static android.view.View.OnTouchListener m(k k1)
    {
        return k1.p;
    }

    public final void a()
    {
        EnumSet enumset = EnumSet.of(com.facebook.ads.b.a);
        if (l)
        {
            throw new IllegalStateException("loadAd cannot be called more than once");
        } else
        {
            l = true;
            com.facebook.ads.a.f f1 = com.facebook.ads.a.f.j;
            k = new i(h, i, f1, null, e, true);
            k.a(new com.facebook.ads.a.b(enumset) {

                final EnumSet a;
                final k b;

                public final void a()
                {
                    if (k.b(b) != null)
                    {
                        k.b(b).c();
                    }
                }

                public final void a(u u1)
                {
                    if (u1 == null)
                    {
                        return;
                    }
                    ArrayList arraylist = new ArrayList(2);
                    if (a.contains(b.b) && u1.i() != null)
                    {
                        arraylist.add(u1.i().a);
                    }
                    if (a.contains(b.c) && u1.j() != null)
                    {
                        arraylist.add(u1.j().a);
                    }
                    com.facebook.ads.a.f.m.a(k.c(b), arraylist, new l(this, u1) {

                        final u a;
                        final _cls1 b;

                        public final void a()
                        {
                            com.facebook.ads.k.a(b.b, a);
                            com.facebook.ads.k.d(b.b);
                            if (com.facebook.ads.k.a(b.b) != null)
                            {
                                com.facebook.ads.k.a(b.b).a(b.b);
                            }
                        }

            
            {
                b = _pcls1;
                a = u1;
                super();
            }
                    });
                }

                public final void a(com.facebook.ads.a.c c1)
                {
                    if (com.facebook.ads.k.a(b) != null)
                    {
                        com.facebook.ads.k.a(b).a(b, c1.a());
                    }
                }

                public final void b()
                {
                    if (com.facebook.ads.k.a(b) != null)
                    {
                        com.facebook.ads.k.a(b).b(b);
                    }
                }

                public final void c()
                {
                    throw new IllegalStateException("Native ads manager their own impressions.");
                }

            
            {
                b = k.this;
                a = enumset;
                super();
            }
            });
            k.b();
            return;
        }
    }

    public final void a(View view, List list)
    {
        if (view == null)
        {
            throw new IllegalArgumentException("Must provide a View");
        }
        if (list == null || list.size() == 0)
        {
            throw new IllegalArgumentException("Invalid set of clickable views");
        }
        if (!b())
        {
            Log.e(f, "Ad not loaded");
            return;
        }
        if (n != null)
        {
            i();
        }
        if (g.containsKey(view))
        {
            ((k)((WeakReference)g.get(view)).get()).i();
        }
        s = new d((byte)0);
        n = view;
        if (view instanceof ViewGroup)
        {
            u = new com.facebook.ads.a.g.i(view.getContext(), new com.facebook.ads.a.g.h() {

                final k a;

                public final void a(int j1)
                {
                    if (com.facebook.ads.k.e(a) != null)
                    {
                        com.facebook.ads.k.e(a).a(j1);
                    }
                }

            
            {
                a = k.this;
                super();
            }
            });
            ((ViewGroup)view).addView(u);
        }
        View view1;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); view1.setOnTouchListener(s))
        {
            view1 = (View)iterator.next();
            o.add(view1);
            view1.setOnClickListener(s);
        }

        r = new t(h, new f((byte)0), b);
        r.g = list;
        boolean flag = true;
        int i1;
        if (m != null)
        {
            i1 = m.e();
        } else
        {
            i1 = ((flag) ? 1 : 0);
            if (k != null)
            {
                i1 = ((flag) ? 1 : 0);
                if (k.a() != null)
                {
                    i1 = k.a().e();
                }
            }
        }
        q = new j(h, n, i1, new com.facebook.ads.a.b.j.a() {

            final k a;

            public final void a()
            {
                k.g(a).f = com.facebook.ads.k.f(a);
                k.g(a).b = com.facebook.ads.k.h(a);
                k.g(a).c = com.facebook.ads.k.i(a);
                k.g(a).d = com.facebook.ads.k.j(a);
                k.g(a).e = k.k(a);
                k.g(a).a();
            }

            
            {
                a = k.this;
                super();
            }
        });
        list = q;
        if (m != null)
        {
            i1 = m.e();
        } else
        if (b != null)
        {
            i1 = b.g();
        } else
        if (k != null && k.a() != null)
        {
            i1 = k.a().f();
        } else
        {
            i1 = 0;
        }
        list.a = i1;
        list = q;
        if (m != null)
        {
            i1 = m.g();
        } else
        if (b != null)
        {
            i1 = b.h();
        } else
        if (k != null && k.a() != null)
        {
            i1 = k.a().g();
        } else
        {
            i1 = 1000;
        }
        list.b = i1;
        q.a();
        g.put(view, new WeakReference(this));
    }

    public final void a(List list, View view)
    {
        list.add(view);
        if ((view instanceof ViewGroup) && !(view instanceof com.facebook.ads.a.g.a.a))
        {
            view = (ViewGroup)view;
            for (int i1 = 0; i1 < view.getChildCount(); i1++)
            {
                a(list, view.getChildAt(i1));
            }

        }
    }

    public final boolean b()
    {
        return b != null;
    }

    public final a c()
    {
        if (!b())
        {
            return null;
        } else
        {
            return b.i();
        }
    }

    public final a d()
    {
        if (!b())
        {
            return null;
        } else
        {
            return b.j();
        }
    }

    public final String e()
    {
        if (!b())
        {
            return null;
        } else
        {
            return b.k();
        }
    }

    public final String f()
    {
        if (!b())
        {
            return null;
        } else
        {
            return b.l();
        }
    }

    public final String g()
    {
        if (!b())
        {
            return null;
        } else
        {
            return b.m();
        }
    }

    final String h()
    {
        if (!b())
        {
            return null;
        } else
        {
            return b.p();
        }
    }

    public final void i()
    {
        if (n == null)
        {
            return;
        }
        if (!g.containsKey(n) || ((WeakReference)g.get(n)).get() != this)
        {
            throw new IllegalStateException("View not registered with this NativeAd");
        }
        if ((n instanceof ViewGroup) && u != null)
        {
            ((ViewGroup)n).removeView(u);
            u = null;
        }
        g.remove(n);
        j();
        n = null;
        if (q != null)
        {
            q.b();
            q = null;
        }
        r = null;
    }

    static 
    {
        e = com.facebook.ads.a.d.a;
    }
}

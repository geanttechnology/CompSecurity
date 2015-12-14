// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.adapters.m;
import com.facebook.ads.internal.adapters.n;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.dto.d;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.util.k;
import com.facebook.ads.internal.view.o;
import com.facebook.ads.internal.view.video.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

// Referenced classes of package com.facebook.ads:
//            Ad, AdChoicesView, AdListener, ImpressionListener, 
//            NativeAdViewAttributes

public class NativeAd
    implements Ad
{

    private static final com.facebook.ads.internal.c a;
    private static final String b = com/facebook/ads/NativeAd.getSimpleName();
    private static WeakHashMap c = new WeakHashMap();
    private final Context d;
    private final String e;
    private final String f;
    private AdListener g;
    private ImpressionListener h;
    private h i;
    private volatile boolean j;
    private n k;
    private d l;
    private View m;
    private List n;
    private android.view.View.OnTouchListener o;
    private com.facebook.ads.internal.adapters.d p;
    private m q;
    private a r;
    private b s;
    private o t;
    private NativeAdView.Type u;
    private boolean v;
    private boolean w;
    private boolean x;
    private long y;

    public NativeAd(Context context, n n1, d d1)
    {
        this(context, null);
        l = d1;
        j = true;
        k = n1;
    }

    public NativeAd(Context context, String s1)
    {
        f = UUID.randomUUID().toString();
        n = new ArrayList();
        d = context;
        e = s1;
    }

    NativeAd(NativeAd nativead)
    {
        this(nativead.d, null);
        l = nativead.l;
        j = true;
        k = nativead.k;
    }

    static AdListener a(NativeAd nativead)
    {
        return nativead.g;
    }

    static n a(NativeAd nativead, n n1)
    {
        nativead.k = n1;
        return n1;
    }

    private void a(View view)
    {
        n.add(view);
        view.setOnClickListener(r);
        view.setOnTouchListener(r);
    }

    private void a(List list, View view)
    {
        if (!(view instanceof a) && !(view instanceof AdChoicesView)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        list.add(view);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int i1 = 0;
            while (i1 < view.getChildCount()) 
            {
                a(list, view.getChildAt(i1));
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    static h b(NativeAd nativead)
    {
        return nativead.i;
    }

    static long c(NativeAd nativead)
    {
        return nativead.y;
    }

    private int d()
    {
        if (l != null)
        {
            return l.e();
        }
        if (k != null)
        {
            return k.i();
        }
        if (i != null && i.a() != null)
        {
            return i.a().f();
        } else
        {
            return 0;
        }
    }

    static Context d(NativeAd nativead)
    {
        return nativead.d;
    }

    public static void downloadAndDisplayImage(Image image, ImageView imageview)
    {
        if (image != null && imageview != null)
        {
            (new k(imageview)).execute(new String[] {
                image.getUrl()
            });
        }
    }

    private int e()
    {
        if (l != null)
        {
            return l.g();
        }
        if (k != null)
        {
            return k.j();
        }
        if (i != null && i.a() != null)
        {
            return i.a().g();
        } else
        {
            return 1000;
        }
    }

    static void e(NativeAd nativead)
    {
        nativead.g();
    }

    static n f(NativeAd nativead)
    {
        return nativead.k;
    }

    private void f()
    {
        View view;
        for (Iterator iterator = n.iterator(); iterator.hasNext(); view.setOnTouchListener(null))
        {
            view = (View)iterator.next();
            view.setOnClickListener(null);
        }

        n.clear();
    }

    static View g(NativeAd nativead)
    {
        return nativead.m;
    }

    private void g()
    {
        if (k != null && k.d())
        {
            s = new b(null);
            s.a();
            q = new m(d, new _cls4(), k);
        }
    }

    private int getMinViewabilityPercentage()
    {
        boolean flag = true;
        int i1;
        if (l != null)
        {
            i1 = l.e();
        } else
        {
            i1 = ((flag) ? 1 : 0);
            if (i != null)
            {
                i1 = ((flag) ? 1 : 0);
                if (i.a() != null)
                {
                    return i.a().e();
                }
            }
        }
        return i1;
    }

    static m h(NativeAd nativead)
    {
        return nativead.q;
    }

    static NativeAdView.Type i(NativeAd nativead)
    {
        return nativead.u;
    }

    static boolean j(NativeAd nativead)
    {
        return nativead.v;
    }

    static boolean k(NativeAd nativead)
    {
        return nativead.w;
    }

    static boolean l(NativeAd nativead)
    {
        return nativead.x;
    }

    private void logExternalClick(String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("eil", Boolean.valueOf(true));
        hashmap.put("eil_source", s1);
        k.b(hashmap);
    }

    private void logExternalImpression()
    {
        q.a();
    }

    static ImpressionListener m(NativeAd nativead)
    {
        return nativead.h;
    }

    static android.view.View.OnTouchListener n(NativeAd nativead)
    {
        return nativead.o;
    }

    static String o(NativeAd nativead)
    {
        return nativead.f;
    }

    private void registerExternalLogReceiver(String s1)
    {
        q = new m(d, new _cls5(s1), k);
    }

    String a()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.v();
        }
    }

    void a(NativeAdView.Type type)
    {
        u = type;
    }

    void a(boolean flag)
    {
        v = flag;
    }

    String b()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.w();
        }
    }

    void b(boolean flag)
    {
        w = flag;
    }

    String c()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.x();
        }
    }

    public void destroy()
    {
        if (s != null)
        {
            s.b();
            s = null;
        }
        if (i != null)
        {
            i.d();
            i = null;
        }
    }

    public String getAdBody()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.p();
        }
    }

    public String getAdCallToAction()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.q();
        }
    }

    public Image getAdChoicesIcon()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.t();
        }
    }

    public String getAdChoicesLinkUrl()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.u();
        }
    }

    public Image getAdCoverImage()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.l();
        }
    }

    public AdExtras getAdExtras()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.y();
        }
    }

    public Image getAdIcon()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.k();
        }
    }

    public String getAdSocialContext()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.r();
        }
    }

    public Rating getAdStarRating()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.s();
        }
    }

    public String getAdSubtitle()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.o();
        }
    }

    public String getAdTitle()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.n();
        }
    }

    public NativeAdViewAttributes getAdViewAttributes()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return k.m();
        }
    }

    public String getId()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return f;
        }
    }

    public boolean isAdLoaded()
    {
        return k != null;
    }

    public boolean isNativeConfigEnabled()
    {
        return isAdLoaded() && k.f();
    }

    public void loadAd()
    {
        loadAd(EnumSet.of(MediaCacheFlag.NONE));
    }

    public void loadAd(EnumSet enumset)
    {
        if (j)
        {
            throw new IllegalStateException("loadAd cannot be called more than once");
        } else
        {
            y = System.currentTimeMillis();
            j = true;
            e e1 = e.j;
            i = new h(d, e, e1, null, a, 1, true);
            i.a(new _cls1(enumset));
            i.b();
            return;
        }
    }

    public void registerViewForInteraction(View view)
    {
        ArrayList arraylist = new ArrayList();
        a(arraylist, view);
        registerViewForInteraction(view, ((List) (arraylist)));
    }

    public void registerViewForInteraction(View view, List list)
    {
        if (view == null)
        {
            throw new IllegalArgumentException("Must provide a View");
        }
        if (list == null || list.size() == 0)
        {
            throw new IllegalArgumentException("Invalid set of clickable views");
        }
        if (!isAdLoaded())
        {
            Log.e(b, "Ad not loaded");
            return;
        }
        if (m != null)
        {
            Log.w(b, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
            unregisterView();
        }
        if (c.containsKey(view))
        {
            Log.w(b, "View already registered with a NativeAd. Auto unregistering and proceeding.");
            ((NativeAd)((WeakReference)c.get(view)).get()).unregisterView();
        }
        r = new a(null);
        m = view;
        if (view instanceof ViewGroup)
        {
            t = new o(view.getContext(), new _cls2());
            ((ViewGroup)view).addView(t);
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext(); a((View)iterator.next())) { }
        q = new m(d, new c(null), k);
        q.a(list);
        int i1 = getMinViewabilityPercentage();
        p = new com.facebook.ads.internal.adapters.d(d, m, i1, new _cls3());
        p.a(d());
        p.b(e());
        p.a();
        c.put(view, new WeakReference(this));
    }

    public void setAdListener(AdListener adlistener)
    {
        g = adlistener;
    }

    public void setImpressionListener(ImpressionListener impressionlistener)
    {
        h = impressionlistener;
    }

    public void setMediaViewAutoplay(boolean flag)
    {
        x = flag;
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        o = ontouchlistener;
    }

    public void unregisterView()
    {
        if (m == null)
        {
            return;
        }
        if (!c.containsKey(m) || ((WeakReference)c.get(m)).get() != this)
        {
            throw new IllegalStateException("View not registered with this NativeAd");
        }
        if ((m instanceof ViewGroup) && t != null)
        {
            ((ViewGroup)m).removeView(t);
            t = null;
        }
        c.remove(m);
        f();
        m = null;
        if (p != null)
        {
            p.b();
            p = null;
        }
        q = null;
    }

    static 
    {
        a = com.facebook.ads.internal.c.a;
    }

    private class Image
    {

        private final String a;
        private final int b;
        private final int c;

        public static Image fromJSONObject(JSONObject jsonobject)
        {
            String s1;
            if (jsonobject != null)
            {
                if ((s1 = jsonobject.optString("url")) != null)
                {
                    return new Image(s1, jsonobject.optInt("width", 0), jsonobject.optInt("height", 0));
                }
            }
            return null;
        }

        public int getHeight()
        {
            return c;
        }

        public String getUrl()
        {
            return a;
        }

        public int getWidth()
        {
            return b;
        }

        private Image(String s1, int i1, int j1)
        {
            a = s1;
            b = i1;
            c = j1;
        }
    }


    private class b extends BroadcastReceiver
    {

        final NativeAd a;
        private boolean b;

        public void a()
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction((new StringBuilder()).append("com.facebook.ads.native.impression:").append(com.facebook.ads.NativeAd.o(a)).toString());
            intentfilter.addAction((new StringBuilder()).append("com.facebook.ads.native.click:").append(com.facebook.ads.NativeAd.o(a)).toString());
            LocalBroadcastManager.getInstance(com.facebook.ads.NativeAd.d(a)).registerReceiver(this, intentfilter);
            b = true;
        }

        public void b()
        {
            if (!b)
            {
                return;
            }
            try
            {
                LocalBroadcastManager.getInstance(com.facebook.ads.NativeAd.d(a)).unregisterReceiver(this);
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }

        public void onReceive(Context context, Intent intent)
        {
            context = intent.getAction().split(":")[0];
            if ("com.facebook.ads.native.impression".equals(context))
            {
                com.facebook.ads.NativeAd.h(a).a();
            } else
            if ("com.facebook.ads.native.click".equals(context))
            {
                context = new HashMap();
                context.put("mil", Boolean.valueOf(true));
                NativeAd.f(a).b(context);
                return;
            }
        }

        private b()
        {
            a = NativeAd.this;
            super();
        }

        b(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls4 extends com.facebook.ads.internal.adapters.b
    {

        final NativeAd a;

        public boolean a()
        {
            return true;
        }

        _cls4()
        {
            a = NativeAd.this;
            super();
        }
    }


    private class _cls5 extends com.facebook.ads.internal.adapters.b
    {

        final String a;
        final NativeAd b;

        public boolean b()
        {
            return true;
        }

        public String c()
        {
            return a;
        }

        _cls5(String s1)
        {
            b = NativeAd.this;
            a = s1;
            super();
        }
    }


    private class MediaCacheFlag extends Enum
    {

        public static final EnumSet ALL = EnumSet.allOf(com/facebook/ads/NativeAd$MediaCacheFlag);
        public static final MediaCacheFlag ICON;
        public static final MediaCacheFlag IMAGE;
        public static final MediaCacheFlag NONE;
        private static final MediaCacheFlag b[];
        private final long a;

        public static MediaCacheFlag valueOf(String s1)
        {
            return (MediaCacheFlag)Enum.valueOf(com/facebook/ads/NativeAd$MediaCacheFlag, s1);
        }

        public static MediaCacheFlag[] values()
        {
            return (MediaCacheFlag[])b.clone();
        }

        public long getCacheFlagValue()
        {
            return a;
        }

        static 
        {
            NONE = new MediaCacheFlag("NONE", 0, 0L);
            ICON = new MediaCacheFlag("ICON", 1, 1L);
            IMAGE = new MediaCacheFlag("IMAGE", 2, 2L);
            b = (new MediaCacheFlag[] {
                NONE, ICON, IMAGE
            });
        }

        private MediaCacheFlag(String s1, int i1, long l1)
        {
            super(s1, i1);
            a = l1;
        }
    }


    private class _cls1 extends com.facebook.ads.internal.a
    {

        final EnumSet a;
        final NativeAd b;

        public void a()
        {
            if (NativeAd.b(b) != null)
            {
                NativeAd.b(b).c();
            }
        }

        public void a(n n1)
        {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(com.facebook.ads.internal.util.b.b.a, AdPlacementType.NATIVE, System.currentTimeMillis() - com.facebook.ads.NativeAd.c(b), null));
            if (n1 == null)
            {
                return;
            }
            ArrayList arraylist = new ArrayList(2);
            if (a.contains(MediaCacheFlag.ICON) && n1.k() != null)
            {
                arraylist.add(n1.k().getUrl());
            }
            if (a.contains(MediaCacheFlag.IMAGE) && n1.l() != null)
            {
                arraylist.add(n1.l().getUrl());
            }
            class _cls1
                implements l
            {

                final n a;
                final _cls1 b;

                public void a()
                {
                    com.facebook.ads.NativeAd.a(b.b, a);
                    com.facebook.ads.NativeAd.e(b.b);
                    if (com.facebook.ads.NativeAd.a(b.b) != null)
                    {
                        com.facebook.ads.NativeAd.a(b.b).onAdLoaded(b.b);
                    }
                }

                _cls1(n n1)
                {
                    b = _cls1.this;
                    a = n1;
                    super();
                }
            }

            com.facebook.ads.internal.util.m.a(com.facebook.ads.NativeAd.d(b), arraylist, new _cls1(n1));
        }

        public void a(com.facebook.ads.internal.b b1)
        {
            if (com.facebook.ads.NativeAd.a(b) != null)
            {
                com.facebook.ads.NativeAd.a(b).onError(b, b1.b());
            }
        }

        public void b()
        {
            if (com.facebook.ads.NativeAd.a(b) != null)
            {
                com.facebook.ads.NativeAd.a(b).onAdClicked(b);
            }
        }

        public void c()
        {
            throw new IllegalStateException("Native ads manager their own impressions.");
        }

        _cls1(EnumSet enumset)
        {
            b = NativeAd.this;
            a = enumset;
            super();
        }
    }


    private class a
        implements android.view.View.OnClickListener, android.view.View.OnTouchListener
    {

        final NativeAd a;
        private int b;
        private int c;
        private int d;
        private int e;
        private float f;
        private float g;
        private int h;
        private int i;
        private boolean j;

        public Map a()
        {
            HashMap hashmap = new HashMap();
            hashmap.put("clickX", Integer.valueOf(b));
            hashmap.put("clickY", Integer.valueOf(c));
            hashmap.put("width", Integer.valueOf(d));
            hashmap.put("height", Integer.valueOf(e));
            hashmap.put("adPositionX", Float.valueOf(f));
            hashmap.put("adPositionY", Float.valueOf(g));
            hashmap.put("visibleWidth", Integer.valueOf(i));
            hashmap.put("visibleHeight", Integer.valueOf(h));
            return hashmap;
        }

        public void onClick(View view)
        {
            if (com.facebook.ads.NativeAd.a(a) != null)
            {
                com.facebook.ads.NativeAd.a(a).onAdClicked(a);
            }
            if (!j)
            {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            view = a();
            if (NativeAd.i(a) != null)
            {
                view.put("nti", String.valueOf(NativeAd.i(a).getValue()));
            }
            if (NativeAd.j(a))
            {
                view.put("nhs", String.valueOf(NativeAd.j(a)));
            }
            NativeAd.f(a).b(view);
        }

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0 && NativeAd.g(a) != null)
            {
                d = NativeAd.g(a).getWidth();
                e = NativeAd.g(a).getHeight();
                int ai[] = new int[2];
                NativeAd.g(a).getLocationInWindow(ai);
                f = ai[0];
                g = ai[1];
                Rect rect = new Rect();
                NativeAd.g(a).getGlobalVisibleRect(rect);
                i = rect.width();
                h = rect.height();
                int ai1[] = new int[2];
                view.getLocationInWindow(ai1);
                b = ((int)motionevent.getX() + ai1[0]) - ai[0];
                int i1 = (int)motionevent.getY();
                c = (ai1[1] + i1) - ai[1];
                j = true;
            }
            return com.facebook.ads.NativeAd.n(a) != null && com.facebook.ads.NativeAd.n(a).onTouch(view, motionevent);
        }

        private a()
        {
            a = NativeAd.this;
            super();
        }

        a(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls2
        implements com.facebook.ads.internal.view.n
    {

        final NativeAd a;

        public void a(int i1)
        {
            if (NativeAd.f(a) != null)
            {
                NativeAd.f(a).a(i1);
            }
        }

        _cls2()
        {
            a = NativeAd.this;
            super();
        }
    }


    private class c extends com.facebook.ads.internal.adapters.b
    {

        final NativeAd a;

        public boolean a()
        {
            return false;
        }

        public void d()
        {
            if (com.facebook.ads.NativeAd.m(a) != null)
            {
                com.facebook.ads.NativeAd.m(a).onLoggingImpression(a);
            }
            if ((com.facebook.ads.NativeAd.a(a) instanceof ImpressionListener) && com.facebook.ads.NativeAd.a(a) != com.facebook.ads.NativeAd.m(a))
            {
                ((ImpressionListener)com.facebook.ads.NativeAd.a(a)).onLoggingImpression(a);
            }
        }

        public void e()
        {
        }

        private c()
        {
            a = NativeAd.this;
            super();
        }

        c(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls3 extends com.facebook.ads.internal.adapters.d.a
    {

        final NativeAd a;

        public void a()
        {
            com.facebook.ads.NativeAd.h(a).a(NativeAd.g(a));
            com.facebook.ads.NativeAd.h(a).a(NativeAd.i(a));
            com.facebook.ads.NativeAd.h(a).a(NativeAd.j(a));
            com.facebook.ads.NativeAd.h(a).b(com.facebook.ads.NativeAd.k(a));
            com.facebook.ads.NativeAd.h(a).c(com.facebook.ads.NativeAd.l(a));
            com.facebook.ads.NativeAd.h(a).a();
        }

        _cls3()
        {
            a = NativeAd.this;
            super();
        }
    }

}

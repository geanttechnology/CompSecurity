// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.a;
import com.facebook.ads.internal.adapters.o;
import com.facebook.ads.internal.adapters.p;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.util.k;
import com.facebook.ads.internal.util.l;
import com.facebook.ads.internal.util.m;
import com.facebook.ads.internal.view.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

// Referenced classes of package com.facebook.ads:
//            Ad, AdListener, ImpressionListener

public class NativeAd
    implements Ad
{

    private static final com.facebook.ads.internal.c a;
    private static final String b = com/facebook/ads/NativeAd.getSimpleName();
    private static WeakHashMap c = new WeakHashMap();
    private final Context d;
    private final String e;
    private AdListener f;
    private ImpressionListener g;
    private h h;
    private volatile boolean i;
    private p j;
    private com.facebook.ads.internal.dto.c k;
    private View l;
    private List m;
    private android.view.View.OnTouchListener n;
    private com.facebook.ads.internal.adapters.e o;
    private o p;
    private a q;
    private b r;
    private com.facebook.ads.internal.view.k s;
    private NativeAdView.Type t;
    private boolean u;
    private boolean v;

    public NativeAd(Context context, p p1, com.facebook.ads.internal.dto.c c1)
    {
        this(context, null);
        k = c1;
        i = true;
        j = p1;
    }

    public NativeAd(Context context, String s1)
    {
        m = new ArrayList();
        d = context;
        e = s1;
    }

    NativeAd(NativeAd nativead)
    {
        this(nativead.d, null);
        k = nativead.k;
        i = true;
        j = nativead.j;
    }

    private int a()
    {
        if (k != null)
        {
            return k.e();
        }
        if (j != null)
        {
            return j.e();
        }
        if (h != null && h.a() != null)
        {
            return h.a().f();
        } else
        {
            return 0;
        }
    }

    static AdListener a(NativeAd nativead)
    {
        return nativead.f;
    }

    static p a(NativeAd nativead, p p1)
    {
        nativead.j = p1;
        return p1;
    }

    private void a(View view)
    {
        m.add(view);
        view.setOnClickListener(q);
        view.setOnTouchListener(q);
    }

    private void a(List list, View view)
    {
        list.add(view);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            for (int i1 = 0; i1 < view.getChildCount(); i1++)
            {
                a(list, view.getChildAt(i1));
            }

        }
    }

    private int b()
    {
        if (k != null)
        {
            return k.g();
        }
        if (j != null)
        {
            return j.f();
        }
        if (h != null && h.a() != null)
        {
            return h.a().g();
        } else
        {
            return 1000;
        }
    }

    static h b(NativeAd nativead)
    {
        return nativead.h;
    }

    static Context c(NativeAd nativead)
    {
        return nativead.d;
    }

    private void c()
    {
        View view;
        for (Iterator iterator = m.iterator(); iterator.hasNext(); view.setOnTouchListener(null))
        {
            view = (View)iterator.next();
            view.setOnClickListener(null);
        }

        m.clear();
    }

    private void d()
    {
        if (j != null && j.a())
        {
            r = new b();
            r.a();
            p = new o(d, new com.facebook.ads.internal.adapters.c() {

                final NativeAd a;

                public boolean a()
                {
                    return true;
                }

            
            {
                a = NativeAd.this;
                super();
            }
            }, j);
        }
    }

    static void d(NativeAd nativead)
    {
        nativead.d();
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

    static p e(NativeAd nativead)
    {
        return nativead.j;
    }

    static View f(NativeAd nativead)
    {
        return nativead.l;
    }

    static o g(NativeAd nativead)
    {
        return nativead.p;
    }

    private int getMinViewabilityPercentage()
    {
        boolean flag = true;
        int i1;
        if (k != null)
        {
            i1 = k.e();
        } else
        {
            i1 = ((flag) ? 1 : 0);
            if (h != null)
            {
                i1 = ((flag) ? 1 : 0);
                if (h.a() != null)
                {
                    return h.a().e();
                }
            }
        }
        return i1;
    }

    static NativeAdView.Type h(NativeAd nativead)
    {
        return nativead.t;
    }

    static boolean i(NativeAd nativead)
    {
        return nativead.u;
    }

    static boolean j(NativeAd nativead)
    {
        return nativead.v;
    }

    static ImpressionListener k(NativeAd nativead)
    {
        return nativead.g;
    }

    static android.view.View.OnTouchListener l(NativeAd nativead)
    {
        return nativead.n;
    }

    private void logExternalClick(String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("eil", Boolean.valueOf(true));
        hashmap.put("eil_source", s1);
        j.b(hashmap);
    }

    private void logExternalImpression()
    {
        p.a();
    }

    private void registerExternalLogReceiver(String s1)
    {
        p = new o(d, new com.facebook.ads.internal.adapters.c(s1) {

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

            
            {
                b = NativeAd.this;
                a = s1;
                super();
            }
        }, j);
    }

    void a(NativeAdView.Type type)
    {
        t = type;
    }

    void a(boolean flag)
    {
        u = flag;
    }

    void b(boolean flag)
    {
        v = flag;
    }

    public void destroy()
    {
        if (r != null)
        {
            r.b();
            r = null;
        }
        if (h != null)
        {
            h.d();
            h = null;
        }
    }

    public String getAdBody()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.k();
        }
    }

    public String getAdCallToAction()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.l();
        }
    }

    public Image getAdChoicesIcon()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.p();
        }
    }

    public String getAdChoicesLinkUrl()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.q();
        }
    }

    public Image getAdCoverImage()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.h();
        }
    }

    public Image getAdIcon()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.g();
        }
    }

    public String getAdSocialContext()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.m();
        }
    }

    public Rating getAdStarRating()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.n();
        }
    }

    public String getAdSubtitle()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.j();
        }
    }

    public String getAdTitle()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.i();
        }
    }

    public String getId()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.o();
        }
    }

    public boolean isAdLoaded()
    {
        return j != null;
    }

    public void loadAd()
    {
        loadAd(EnumSet.of(MediaCacheFlag.NONE));
    }

    public void loadAd(EnumSet enumset)
    {
        if (i)
        {
            throw new IllegalStateException("loadAd cannot be called more than once");
        } else
        {
            i = true;
            e e1 = e.j;
            h = new h(d, e, e1, null, a, 1);
            h.a(new a(enumset) {

                final EnumSet a;
                final NativeAd b;

                public void a()
                {
                    if (com.facebook.ads.NativeAd.b(b) != null)
                    {
                        com.facebook.ads.NativeAd.b(b).c();
                    }
                }

                public void a(p p1)
                {
                    if (p1 == null)
                    {
                        return;
                    }
                    ArrayList arraylist = new ArrayList(2);
                    if (a.contains(MediaCacheFlag.ICON) && p1.g() != null)
                    {
                        arraylist.add(p1.g().getUrl());
                    }
                    if (a.contains(MediaCacheFlag.IMAGE) && p1.h() != null)
                    {
                        arraylist.add(p1.h().getUrl());
                    }
                    com.facebook.ads.internal.util.m.a(com.facebook.ads.NativeAd.c(b), arraylist, new l(this, p1) {

                        final p a;
                        final _cls1 b;

                        public void a()
                        {
                            com.facebook.ads.NativeAd.a(b.b, a);
                            NativeAd.d(b.b);
                            if (com.facebook.ads.NativeAd.a(b.b) != null)
                            {
                                com.facebook.ads.NativeAd.a(b.b).onAdLoaded(b.b);
                            }
                        }

            
            {
                b = _pcls1;
                a = p1;
                super();
            }
                    });
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

            
            {
                b = NativeAd.this;
                a = enumset;
                super();
            }
            });
            h.b();
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
        if (l != null)
        {
            Log.w(b, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
            unregisterView();
        }
        if (c.containsKey(view))
        {
            Log.w(b, "View already registered with a NativeAd. Auto unregistering and proceeding.");
            ((NativeAd)((WeakReference)c.get(view)).get()).unregisterView();
        }
        q = new a();
        l = view;
        if (view instanceof ViewGroup)
        {
            s = new com.facebook.ads.internal.view.k(view.getContext(), new j() {

                final NativeAd a;

                public void a(int j1)
                {
                    if (com.facebook.ads.NativeAd.e(a) != null)
                    {
                        com.facebook.ads.NativeAd.e(a).a(j1);
                    }
                }

            
            {
                a = NativeAd.this;
                super();
            }
            });
            ((ViewGroup)view).addView(s);
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext(); a((View)iterator.next())) { }
        p = new o(d, new c(), j);
        p.a(list);
        int i1 = getMinViewabilityPercentage();
        o = new com.facebook.ads.internal.adapters.e(d, l, i1, new com.facebook.ads.internal.adapters.e.a() {

            final NativeAd a;

            public void a()
            {
                NativeAd.g(a).a(NativeAd.f(a));
                NativeAd.g(a).a(com.facebook.ads.NativeAd.h(a));
                NativeAd.g(a).a(NativeAd.i(a));
                NativeAd.g(a).b(com.facebook.ads.NativeAd.j(a));
                NativeAd.g(a).a();
            }

            
            {
                a = NativeAd.this;
                super();
            }
        });
        o.a(a());
        o.b(b());
        o.a();
        c.put(view, new WeakReference(this));
    }

    public void setAdListener(AdListener adlistener)
    {
        f = adlistener;
    }

    public void setImpressionListener(ImpressionListener impressionlistener)
    {
        g = impressionlistener;
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        n = ontouchlistener;
    }

    public void unregisterView()
    {
        if (l == null)
        {
            return;
        }
        if (!c.containsKey(l) || ((WeakReference)c.get(l)).get() != this)
        {
            throw new IllegalStateException("View not registered with this NativeAd");
        }
        if ((l instanceof ViewGroup) && s != null)
        {
            ((ViewGroup)l).removeView(s);
            s = null;
        }
        c.remove(l);
        c();
        l = null;
        if (o != null)
        {
            o.b();
            o = null;
        }
        p = null;
    }

    static 
    {
        a = com.facebook.ads.internal.c.a;
    }

    private class b extends BroadcastReceiver
    {

        final NativeAd a;
        private boolean b;

        public void a()
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction((new StringBuilder()).append("com.facebook.ads.native.impression:").append(com.facebook.ads.NativeAd.e(a).o()).toString());
            intentfilter.addAction((new StringBuilder()).append("com.facebook.ads.native.click:").append(com.facebook.ads.NativeAd.e(a).o()).toString());
            LocalBroadcastManager.getInstance(com.facebook.ads.NativeAd.c(a)).registerReceiver(this, intentfilter);
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
                LocalBroadcastManager.getInstance(com.facebook.ads.NativeAd.c(a)).unregisterReceiver(this);
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
                NativeAd.g(a).a();
            } else
            if ("com.facebook.ads.native.click".equals(context))
            {
                context = new HashMap();
                context.put("mil", Boolean.valueOf(true));
                com.facebook.ads.NativeAd.e(a).b(context);
                return;
            }
        }

        private b()
        {
            a = NativeAd.this;
            super();
        }

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
            if (com.facebook.ads.NativeAd.h(a) != null)
            {
                view.put("nti", String.valueOf(com.facebook.ads.NativeAd.h(a).getValue()));
            }
            if (NativeAd.i(a))
            {
                view.put("nhs", String.valueOf(NativeAd.i(a)));
            }
            com.facebook.ads.NativeAd.e(a).b(view);
        }

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            boolean flag = false;
            if (motionevent.getAction() == 0 && NativeAd.f(a) != null)
            {
                d = NativeAd.f(a).getWidth();
                e = NativeAd.f(a).getHeight();
                int ai[] = new int[2];
                NativeAd.f(a).getLocationInWindow(ai);
                f = ai[0];
                g = ai[1];
                Rect rect = new Rect();
                NativeAd.f(a).getGlobalVisibleRect(rect);
                i = rect.width();
                h = rect.height();
                int ai1[] = new int[2];
                view.getLocationInWindow(ai1);
                b = ((int)motionevent.getX() + ai1[0]) - ai[0];
                int i1 = (int)motionevent.getY();
                c = (ai1[1] + i1) - ai[1];
                j = true;
            }
            if (com.facebook.ads.NativeAd.l(a) != null)
            {
                flag = com.facebook.ads.NativeAd.l(a).onTouch(view, motionevent);
            }
            return flag;
        }

        private a()
        {
            a = NativeAd.this;
            super();
        }

    }


    private class c extends com.facebook.ads.internal.adapters.c
    {

        final NativeAd a;

        public boolean a()
        {
            return false;
        }

        public void d()
        {
            if (com.facebook.ads.NativeAd.k(a) != null)
            {
                com.facebook.ads.NativeAd.k(a).onLoggingImpression(a);
            }
            if ((com.facebook.ads.NativeAd.a(a) instanceof ImpressionListener) && com.facebook.ads.NativeAd.a(a) != com.facebook.ads.NativeAd.k(a))
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

    }

}

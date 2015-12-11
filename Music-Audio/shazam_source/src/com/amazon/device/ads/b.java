// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.location.Location;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            bc, dq, y, af, 
//            cd, co, cn, cm, 
//            cz, bg, do, bb, 
//            ba, t, ad, h, 
//            ac, av, du, dn

abstract class com.amazon.device.ads.b
{
    static final class a extends w
    {

        protected final Object b(o o1)
        {
            if (o1.a.d.b())
            {
                return o1.a.d.a();
            } else
            {
                return null;
            }
        }

        a()
        {
            super("idfa", "debug.idfa");
        }
    }

    private static final class aa
    {

        private final o a;

        public final boolean a()
        {
            if (!a.c.b.b)
            {
                return false;
            }
            if (a.b.containsKey("enableVideoAds"))
            {
                String s1 = (String)a.b.remove("enableVideoAds");
                a.e.put("enableVideoAds", s1);
                return Boolean.parseBoolean(s1);
            }
            if (a.e.containsKey("enableVideoAds"))
            {
                return Boolean.parseBoolean((String)a.e.get("enableVideoAds"));
            } else
            {
                return a.c.b.g;
            }
        }

        public aa(o o1)
        {
            a = o1;
        }
    }

    static final class ab extends i
    {

        private static JSONObject c(o o1)
        {
            int i1 = 0;
            if ((new aa(o1)).a())
            {
                JSONObject jsonobject = new JSONObject();
                if (o1.b.containsKey("minVideoAdDuration"))
                {
                    ct.a a1 = new ct.a();
                    a1.a = 0;
                    a1 = a1.a(com.amazon.device.ads.b.a);
                    a1.b = "The minVideoAdDuration advanced option could not be parsed properly.";
                    i1 = a1.b((String)o1.b.remove("minVideoAdDuration"));
                }
                cd.b(jsonobject, "minAdDuration", i1);
                if (o1.b.containsKey("maxVideoAdDuration"))
                {
                    ct.a a2 = new ct.a();
                    a2.a = 30000;
                    a2 = a2.a(com.amazon.device.ads.b.a);
                    a2.b = "The maxVideoAdDuration advanced option could not be parsed properly.";
                    i1 = a2.b((String)o1.b.remove("maxVideoAdDuration"));
                } else
                {
                    i1 = 30000;
                }
                cd.b(jsonobject, "maxAdDuration", i1);
                return jsonobject;
            } else
            {
                return null;
            }
        }

        protected final Object b(o o1)
        {
            return c(o1);
        }

        public ab()
        {
            super("video", "debug.videoOptions");
        }
    }

    static final class b extends w
    {

        protected final Object b(o o1)
        {
            return cm.a().c.d();
        }

        b()
        {
            super("appId", "debug.appid");
        }
    }

    static class c extends com.amazon.device.ads.b
    {

        protected final volatile Object a()
        {
            return bc.a().a(c, null);
        }

        protected final Object a(String s1)
        {
            return Boolean.valueOf(Boolean.parseBoolean(s1));
        }

        c(String s1, String s2)
        {
            super(s1, s2);
        }
    }

    static final class d extends i
    {

        protected final Object b(o o1)
        {
            bg bg1 = cm.a().b;
            o1 = o1.a.b;
            JSONObject jsonobject = bg1.j();
            cd.b(jsonobject, "orientation", o1);
            if (o1.equals("portrait") && bg1.j != null)
            {
                o1 = bg1.j;
            } else
            if (o1.equals("landscape") && bg1.i != null)
            {
                o1 = bg1.i;
            } else
            {
                Object obj = (WindowManager)bg1.k.b().getSystemService("window");
                DisplayMetrics displaymetrics = new DisplayMetrics();
                ((WindowManager) (obj)).getDefaultDisplay().getMetrics(displaymetrics);
                obj = (new StringBuilder()).append(String.valueOf(displaymetrics.widthPixels)).append("x").append(String.valueOf(displaymetrics.heightPixels)).toString();
                if (o1.equals("portrait"))
                {
                    bg1.j = new do(((String) (obj)));
                    o1 = bg1.j;
                } else
                if (o1.equals("landscape"))
                {
                    bg1.i = new do(((String) (obj)));
                    o1 = bg1.i;
                } else
                {
                    o1 = new do(((String) (obj)));
                }
            }
            cd.b(jsonobject, "screenSize", o1.toString());
            cd.b(jsonobject, "connectionType", (new bb(bg1.k)).a);
            return jsonobject;
        }

        d()
        {
            super("dinfo", "debug.dinfo");
        }
    }

    static final class e extends j
    {

        protected final Object b(o o1)
        {
            boolean flag;
            if (o1.c.b.d > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return Long.valueOf(o1.c.b.d);
            } else
            {
                return null;
            }
        }

        e()
        {
            super("ec", "debug.ec");
        }
    }

    static final class f extends w
    {

        private final ba C;
        private final Context D;

        protected final Object b(o o1)
        {
            if (C.b(ba.a.f) && o1.a.a.e)
            {
                o1 = (new com.amazon.device.ads.t(D)).a();
                if (o1 != null)
                {
                    return (new StringBuilder()).append(o1.getLatitude()).append(",").append(o1.getLongitude()).toString();
                }
            }
            return null;
        }

        f()
        {
            this(ba.a(), cm.a().b());
        }

        private f(ba ba1, Context context)
        {
            super("geoloc", "debug.geoloc");
            C = ba1;
            D = context;
        }
    }

    static class g extends com.amazon.device.ads.b
    {

        protected final volatile Object a()
        {
            return bc.a().a(c, null);
        }

        protected final Object a(String s1)
        {
            return Integer.valueOf(Integer.parseInt(s1));
        }

        g(String s1, String s2)
        {
            super(s1, s2);
        }
    }

    static class h extends com.amazon.device.ads.b
    {

        private final cn C;

        private JSONArray b(String s1)
        {
            try
            {
                s1 = new JSONArray(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                C.d("Unable to parse the following value into a JSONArray: %s", new Object[] {
                    b
                });
                return null;
            }
            return s1;
        }

        protected final Object a()
        {
            return b(bc.a().a(c, null));
        }

        protected final Object a(String s1)
        {
            return b(s1);
        }

        h(String s1, String s2)
        {
            super(s1, s2);
            new co();
            C = co.a(com.amazon.device.ads.b.a);
        }
    }

    static class i extends com.amazon.device.ads.b
    {

        private final cn C;

        private JSONObject b(String s1)
        {
            try
            {
                s1 = new JSONObject(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                C.d("Unable to parse the following value into a JSONObject: %s", new Object[] {
                    b
                });
                return null;
            }
            return s1;
        }

        protected final Object a()
        {
            return b(bc.a().a(c, null));
        }

        protected final Object a(String s1)
        {
            return b(s1);
        }

        i(String s1, String s2)
        {
            super(s1, s2);
            new co();
            C = co.a(com.amazon.device.ads.b.a);
        }
    }

    static class j extends com.amazon.device.ads.b
    {

        protected final volatile Object a()
        {
            return bc.a().a(c);
        }

        protected final Object a(String s1)
        {
            return Long.valueOf(Long.parseLong(s1));
        }

        j(String s1, String s2)
        {
            super(s1, s2);
        }
    }

    static final class k extends w
    {

        protected final Object b(o o1)
        {
            if (!o1.a.d.b())
            {
                o1 = cm.a().b;
                o1.a();
                return ((bg) (o1)).e;
            } else
            {
                return null;
            }
        }

        k()
        {
            super("md5_udid", "debug.md5udid");
        }
    }

    static final class l extends w
    {

        protected final Object b(o o1)
        {
            o1 = o1.c.d.b;
            if (!((com.amazon.device.ads.h) (o1)).c.a())
            {
                return null;
            } else
            {
                return ac.a(((com.amazon.device.ads.h) (o1)).v, ((com.amazon.device.ads.h) (o1)).u);
            }
        }

        l()
        {
            super("mxsz", "debug.mxsz");
        }
    }

    static final class m extends c
    {

        protected final Object b(o o1)
        {
            if (o1.a.d.b())
            {
                return Boolean.valueOf(o1.a.d.c());
            } else
            {
                return null;
            }
        }

        m()
        {
            super("oo", "debug.optOut");
        }
    }

    static final class n extends i
    {

        protected final Object b(o o1)
        {
            return cm.a().a.a;
        }

        n()
        {
            super("pkg", "debug.pkg");
        }
    }

    static final class o
    {

        com.amazon.device.ads.y a;
        Map b;
        y.c c;
        af d;
        Map e;

        public o()
        {
            e = new HashMap();
        }
    }

    static final class p extends h
    {

        protected final Object a(Object obj, o o1)
        {
            JSONArray jsonarray = (JSONArray)obj;
            obj = jsonarray;
            if (jsonarray == null)
            {
                obj = new JSONArray();
            }
            for (o1 = o1.d.c.iterator(); o1.hasNext(); ((JSONArray) (obj)).put((String)o1.next())) { }
            return obj;
        }

        p()
        {
            super("pk", "debug.pk");
        }
    }

    static final class q extends w
    {

        protected final volatile Object b(o o1)
        {
            return du.b();
        }

        q()
        {
            super("adsdk", "debug.ver");
        }
    }

    static final class r extends w
    {

        protected final Object b(o o1)
        {
            if (!o1.a.d.b())
            {
                return cm.a().b.h();
            } else
            {
                return null;
            }
        }

        r()
        {
            super("sha1_udid", "debug.sha1udid");
        }
    }

    static final class s extends w
    {

        protected final Object b(o o1)
        {
            return o1.a.d.d();
        }

        s()
        {
            super("ad-id", "debug.adid");
        }
    }

    static final class t extends w
    {

        protected final Object b(o o1)
        {
            return o1.c.d.b.c.toString();
        }

        t()
        {
            super("sz", "debug.size");
        }
    }

    static final class u extends g
    {

        protected final Object b(o o1)
        {
            return Integer.valueOf(o1.c.d.a);
        }

        u()
        {
            super("slotId", "debug.slotId");
        }
    }

    static final class v extends w
    {

        protected final volatile Object b(o o1)
        {
            return o1.a.b;
        }

        v()
        {
            super("slot", "debug.slot");
        }
    }

    static class w extends com.amazon.device.ads.b
    {

        protected final volatile Object a()
        {
            return bc.a().a(c, null);
        }

        protected final volatile Object a(String s1)
        {
            return s1;
        }

        w(String s1, String s2)
        {
            super(s1, s2);
        }
    }

    static final class x extends h
    {

        protected final Object b(o o1)
        {
            JSONArray jsonarray = new JSONArray();
            boolean flag = o1.c.b.f;
            if (o1.b.containsKey("enableDisplayAds"))
            {
                flag = Boolean.parseBoolean((String)o1.b.remove("enableDisplayAds"));
            }
            if (flag)
            {
                jsonarray.put("DISPLAY");
            }
            if ((new aa(o1)).a())
            {
                jsonarray.put("VIDEO");
            }
            return jsonarray;
        }

        public x()
        {
            super("supportedMediaTypes", "debug.supportedMediaTypes");
        }
    }

    static final class y extends c
    {

        protected final Object b(o o1)
        {
            return dn.a().b("testingEnabled");
        }

        y()
        {
            super("isTest", "debug.test");
        }
    }

    static final class z extends w
    {

        protected final Object b(o o1)
        {
            return cm.a().b.i();
        }

        z()
        {
            super("ua", "debug.ua");
        }
    }


    static final com.amazon.device.ads.b A = new x();
    static final com.amazon.device.ads.b B = new ab();
    static final String a = com/amazon/device/ads/b.getSimpleName();
    static final com.amazon.device.ads.b d = new b();
    static final com.amazon.device.ads.b e = new w("c", "debug.channel");
    static final p f = new p();
    static final com.amazon.device.ads.b g = new h("pa", "debug.pa");
    static final com.amazon.device.ads.b h = new z();
    static final com.amazon.device.ads.b i = new q();
    static final com.amazon.device.ads.b j = new f();
    static final com.amazon.device.ads.b k = new d();
    static final com.amazon.device.ads.b l = new n();
    static final com.amazon.device.ads.b m = new y();
    static final com.amazon.device.ads.b n = new s();
    static final com.amazon.device.ads.b o = new r();
    static final com.amazon.device.ads.b p = new k();
    static final com.amazon.device.ads.b q = new h("slots", "debug.slots");
    static final com.amazon.device.ads.b r = new a();
    static final com.amazon.device.ads.b s = new m();
    static final com.amazon.device.ads.b t = new t();
    static final com.amazon.device.ads.b u = new w("pt", "debug.pt");
    static final com.amazon.device.ads.b v = new v();
    static final com.amazon.device.ads.b w = new w("sp", "debug.sp");
    static final com.amazon.device.ads.b x = new l();
    static final com.amazon.device.ads.b y = new u();
    static final com.amazon.device.ads.b z = new e();
    final String b;
    final String c;

    com.amazon.device.ads.b(String s1, String s2)
    {
        b = s1;
        c = s2;
    }

    protected abstract Object a();

    final Object a(o o1)
    {
        Object obj;
        if (bc.a().b(c))
        {
            obj = a();
        } else
        if (o1.b.containsKey(b))
        {
            obj = a((String)o1.b.remove(b));
        } else
        {
            obj = b(o1);
        }
        obj = a(obj, o1);
        o1 = ((o) (obj));
        if (obj instanceof String)
        {
            o1 = ((o) (obj));
            if (dq.b((String)obj))
            {
                o1 = null;
            }
        }
        return o1;
    }

    protected Object a(Object obj, o o1)
    {
        return obj;
    }

    protected abstract Object a(String s1);

    protected Object b(o o1)
    {
        return null;
    }

}

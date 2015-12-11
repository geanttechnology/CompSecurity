// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.a.c;
import com.tremorvideo.sdk.android.richmedia.a.d;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, ae, az, be, 
//            t, u, s, q, 
//            r, aw, y, bv, 
//            br

public class n
{
    public class a
    {

        public bf.d a;
        public String b;
        public Map c;
        final n d;

        public a(bf.d d1, String s1)
        {
            d = n.this;
            super();
            a = d1;
            b = s1;
            c = new HashMap();
        }

        public a(bf.d d1, String s1, Map map)
        {
            d = n.this;
            super();
            a = d1;
            b = s1;
            c = map;
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        private static final b h[];
        private String g;

        public static b a(String s1)
        {
            b ab[] = values();
            int j1 = ab.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                b b1 = ab[i1];
                if (b1.toString().equals(s1))
                {
                    return b1;
                }
            }

            return a;
        }

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/videoad/n$b, s1);
        }

        public static b[] values()
        {
            return (b[])h.clone();
        }

        public String toString()
        {
            return g;
        }

        static 
        {
            a = new b("Unknown", 0, "unknown");
            b = new b("Video", 1, "video");
            c = new b("RichMedia", 2, "richmedia");
            d = new b("HTML5", 3, "html5");
            e = new b("VAST", 4, "vast");
            f = new b("Mraid", 5, "mraid");
            h = (new b[] {
                a, b, c, d, e, f
            });
        }

        private b(String s1, int i1, String s2)
        {
            super(s1, i1);
            g = s2;
        }
    }


    protected b a;
    protected List b;
    protected com.tremorvideo.sdk.android.videoad.ae c;
    protected bv d;
    protected az e;
    protected be f;
    protected c g;
    protected com.tremorvideo.sdk.android.b.c h;
    protected d i;
    protected long j;
    protected boolean k;
    protected Map l;
    protected long m;
    public aw n;
    public int o;
    protected boolean p;
    protected Map q;
    private br r;
    private String s;
    private String t;
    private boolean u;
    private String v;

    public n()
    {
        j = 0L;
        k = false;
        n = null;
        o = 0;
        p = false;
    }

    public n(br br, JSONObject jsonobject, boolean flag)
        throws Exception
    {
        j = 0L;
        k = false;
        n = null;
        o = 0;
        p = false;
        l = new HashMap();
        a = com.tremorvideo.sdk.android.videoad.b.a(jsonobject.getString("adtype"));
        r = br;
        u = false;
        v = jsonobject.toString();
        s = jsonobject.getString("id");
        m = ad.D();
        if (jsonobject.has("ad-lifetime"))
        {
            j = jsonobject.getLong("ad-lifetime");
        }
        if (jsonobject.has("coupon"))
        {
            c = new com.tremorvideo.sdk.android.videoad.ae(jsonobject.getJSONObject("coupon"));
        }
        t = jsonobject.getString("cache-expiry-date");
        if (jsonobject.has("ad-survey-external"))
        {
            e = new az(jsonobject.getJSONObject("ad-survey-external"));
        } else
        {
            e = null;
        }
        if (jsonobject.has("ad-survey-internal"))
        {
            f = new be(jsonobject.getJSONObject("ad-survey-internal"));
        } else
        {
            f = null;
        }
        if (jsonobject.has("buy-now"))
        {
            g = new c(jsonobject.getJSONObject("buy-now"));
        } else
        {
            g = null;
        }
        if (jsonobject.has("uatype"))
        {
            o = jsonobject.getInt("uatype");
            if (o > 3 || o < 0)
            {
                o = 0;
            }
        } else
        {
            o = 0;
        }
        ae.a = o;
        if (jsonobject.has("streaming"))
        {
            p = jsonobject.getBoolean("streaming");
        }
    }

    public static n a(com.tremorvideo.sdk.android.videoad.a.a a1, int i1, boolean flag)
        throws Exception
    {
        return new t(a1, i1, flag);
    }

    public static n a(br br, JSONObject jsonobject, boolean flag)
        throws Exception
    {
        b b1 = com.tremorvideo.sdk.android.videoad.b.a(jsonobject.getString("adtype"));
        if (b1 == b.b)
        {
            return new u(br, jsonobject, flag);
        }
        if (b1 == com.tremorvideo.sdk.android.videoad.b.c)
        {
            return new s(br, jsonobject, flag);
        }
        if (b1 == com.tremorvideo.sdk.android.videoad.b.d)
        {
            return new q(br, jsonobject, flag);
        }
        if (b1 == b.e)
        {
            return new t(br, jsonobject, flag);
        }
        if (b1 == b.f)
        {
            return new r(br, jsonobject, flag);
        } else
        {
            return null;
        }
    }

    public static GregorianCalendar a(String s1)
    {
        try
        {
            String as[] = s1.split(" ");
            s1 = as[0].split("-");
            if (as.length == 1)
            {
                return new GregorianCalendar(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]) - 1, Integer.parseInt(s1[2]));
            }
            as = as[1].split(":");
            s1 = new GregorianCalendar(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]) - 1, Integer.parseInt(s1[2]), Integer.parseInt(as[0]), Integer.parseInt(as[1]), Integer.parseInt(as[2]));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.tremorvideo.sdk.android.videoad.ad.a(s1);
            return new GregorianCalendar();
        }
        return s1;
    }

    protected static void a(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            aw aw1 = (aw)list.next();
            if (aw1.a() == aw.b.t)
            {
                aw1.a(aw.b.r);
            } else
            if (aw1.a() == aw.b.s)
            {
                aw1.a(aw.b.r);
            } else
            if (aw1.a() == aw.b.N)
            {
                aw1.a(aw.b.M);
            } else
            if (aw1.a() == aw.b.O)
            {
                aw1.a(aw.b.M);
            }
        } while (true);
    }

    protected static String b(String s1)
    {
        return (new StringBuilder()).append(ae.a(s1)).append("_").append(s1.substring(s1.lastIndexOf(File.separatorChar) + 1)).toString();
    }

    protected static void b(List list)
    {
        aw aw1;
        ArrayList arraylist;
        Iterator iterator;
        int j1;
        j1 = 0;
        arraylist = new ArrayList();
        iterator = list.iterator();
        aw1 = null;
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        aw aw2 = (aw)iterator.next();
        int i1 = -1;
        if (aw2.a() == aw.b.t)
        {
            i1 = 1;
        } else
        if (aw2.a() == aw.b.s)
        {
            i1 = 2;
        } else
        if (aw2.a() == aw.b.r)
        {
            i1 = 3;
        } else
        {
            aw2 = null;
        }
        if (aw2 == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        arraylist.add(aw2);
        if (i1 <= j1)
        {
            break MISSING_BLOCK_LABEL_155;
        }
_L3:
        aw1 = aw2;
        j1 = i1;
        if (true) goto _L2; else goto _L1
_L1:
        if (aw1 != null)
        {
            aw1.a(aw.b.r);
            arraylist.remove(aw1);
        }
        if (arraylist.size() > 0)
        {
            list.removeAll(arraylist);
        }
        return;
        i1 = j1;
        aw2 = aw1;
          goto _L3
    }

    protected static void c(List list)
    {
        aw aw1;
        ArrayList arraylist;
        Iterator iterator;
        int j1;
        j1 = 0;
        arraylist = new ArrayList();
        iterator = list.iterator();
        aw1 = null;
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        aw aw2 = (aw)iterator.next();
        int i1 = -1;
        if (aw2.a() == aw.b.N)
        {
            i1 = 1;
        } else
        if (aw2.a() == aw.b.O)
        {
            i1 = 2;
        } else
        if (aw2.a() == aw.b.M)
        {
            i1 = 3;
        } else
        {
            aw2 = null;
        }
        if (aw2 == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        arraylist.add(aw2);
        if (i1 <= j1)
        {
            break MISSING_BLOCK_LABEL_155;
        }
_L3:
        aw1 = aw2;
        j1 = i1;
        if (true) goto _L2; else goto _L1
_L1:
        if (aw1 != null)
        {
            aw1.a(aw.b.M);
            arraylist.remove(aw1);
        }
        if (arraylist.size() > 0)
        {
            list.removeAll(arraylist);
        }
        return;
        i1 = j1;
        aw2 = aw1;
          goto _L3
    }

    protected static void d(List list)
    {
        Collections.sort(list, new Comparator() {

            public int a(aw aw1, aw aw2)
            {
                if (aw1.i() < aw2.i())
                {
                    return -1;
                }
                return aw1.i() <= aw2.i() ? 0 : 1;
            }

            public int compare(Object obj, Object obj1)
            {
                return a((aw)obj, (aw)obj1);
            }

        });
    }

    public int A()
    {
        return -1;
    }

    public aw B()
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (aw1.a() == aw.b.y)
            {
                return aw1;
            }
        }

        return null;
    }

    public aw C()
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (aw1.a() == aw.b.z)
            {
                return aw1;
            }
        }

        return null;
    }

    public aw D()
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (aw1.a() == aw.b.aq)
            {
                return aw1;
            }
        }

        return null;
    }

    public aw a(aw.b b1)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (b1 == aw1.a())
            {
                return aw1;
            }
        }

        return null;
    }

    public String a(int i1)
    {
        return "";
    }

    public String a(Context context, int i1)
    {
        return com.tremorvideo.sdk.android.videoad.y.a(context.getFilesDir(), e(i1)).getAbsolutePath();
    }

    public List a()
    {
        return new ArrayList();
    }

    public void a(Context context)
    {
        k = true;
    }

    public void a(String s1, Object obj)
        throws Exception
    {
        if (s1.compareTo("coupon") == 0)
        {
            c.a(new File((String)obj));
        } else
        {
            if (s1.compareTo("buyItNowDealsXml") == 0)
            {
                g.a(new File((String)obj));
                return;
            }
            if (s1.compareTo("buyItNowTemplate") == 0)
            {
                g.b(new File((String)obj));
                return;
            }
            if (s1.compareTo("movieBoardTemplate") == 0)
            {
                h.a(new File((String)obj));
                return;
            }
            if (s1.compareTo("genericTemplate") == 0)
            {
                i.a(new File((String)obj));
                return;
            }
            if (s1.startsWith("embedPlayer_"))
            {
                if (q != null)
                {
                    int i1 = Integer.parseInt(s1.substring(s1.lastIndexOf("_") + 1));
                    if (q.containsKey(Integer.valueOf(i1)))
                    {
                        ((s.a)q.get(Integer.valueOf(i1))).a(obj.toString());
                        return;
                    }
                }
            } else
            {
                l.put(s1, obj);
                return;
            }
        }
    }

    protected void a(JSONObject jsonobject)
        throws Exception
    {
        jsonobject = jsonobject.getJSONArray("event");
        b = new ArrayList(jsonobject.length());
        for (int i1 = 0; i1 < jsonobject.length(); i1++)
        {
            aw aw1 = new aw(jsonobject.getJSONObject(i1));
            b.add(aw1);
            if (aw1.a() == aw.b.av)
            {
                n = aw1;
            }
        }

        if (o())
        {
            a(b);
        } else
        {
            b(b);
        }
        d(b);
    }

    public int b(int i1)
    {
        return 0;
    }

    public boolean b()
    {
        return k;
    }

    public aw c(String s1)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (s1.equalsIgnoreCase(aw1.d()))
            {
                return aw1;
            }
        }

        return null;
    }

    public String c(int i1)
    {
        return "";
    }

    public void c()
    {
        com.tremorvideo.sdk.android.videoad.ad.d("Freeing AD resources");
        if (c != null)
        {
            c.e();
            c = null;
        }
        if (d != null)
        {
            d.b();
            d = null;
        }
    }

    public int d(int i1)
    {
        return 0;
    }

    public void d()
    {
        if (g != null)
        {
            g.g();
            g = null;
        }
        if (h != null)
        {
            h.e();
            h = null;
        }
        if (q != null)
        {
            Iterator iterator = q.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                int i1 = ((Integer)iterator.next()).intValue();
                Object obj = (s.a)q.get(Integer.valueOf(i1));
                if (obj != null)
                {
                    obj = new File(((s.a) (obj)).b());
                    if (((File) (obj)).exists())
                    {
                        ae.a(((File) (obj)));
                    }
                }
            } while (true);
        }
    }

    public String e(int i1)
    {
        String s1 = a(i1);
        return (new StringBuilder()).append(ae.a(s1)).append("_").append(s1.substring(s1.lastIndexOf(File.separatorChar) + 1)).toString();
    }

    public GregorianCalendar e()
    {
        return a(t);
    }

    public long f(int i1)
    {
        return 0L;
    }

    public br f()
    {
        return r;
    }

    public b g()
    {
        return a;
    }

    public boolean g(int i1)
    {
        return false;
    }

    public s.a h(int i1)
    {
        if (q.containsKey(Integer.valueOf(i1)))
        {
            return (s.a)q.get(Integer.valueOf(i1));
        } else
        {
            return null;
        }
    }

    public String h()
    {
        return t;
    }

    public String i()
    {
        return "";
    }

    public int j()
    {
        return 0;
    }

    public String[] k()
    {
        return new String[0];
    }

    public List l()
    {
        return b;
    }

    public boolean m()
    {
        return true;
    }

    public aw n()
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (aw1.a() == aw.b.v)
            {
                return aw1;
            }
        }

        return null;
    }

    protected boolean o()
    {
        return false;
    }

    public com.tremorvideo.sdk.android.videoad.ae p()
    {
        return c;
    }

    public bv q()
    {
        return d;
    }

    public s.b r()
    {
        return null;
    }

    public az s()
    {
        return e;
    }

    public String t()
    {
        return null;
    }

    public be u()
    {
        return f;
    }

    public boolean v()
    {
        return c != null && a(aw.b.B) == null;
    }

    public long w()
    {
        return j;
    }

    public long x()
    {
        return m;
    }

    public c y()
    {
        return g;
    }

    public com.tremorvideo.sdk.android.b.c z()
    {
        return h;
    }
}

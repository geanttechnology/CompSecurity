// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.b.c;
import com.tremorvideo.sdk.android.richmedia.a;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.richmedia.f;
import com.tremorvideo.sdk.android.richmedia.l;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            n, aw, ae, bv, 
//            ad, az, br

public class s extends n
{
    public class a
    {

        final s a;
        private String b;
        private String c;
        private String d;

        static String a(a a1)
        {
            return a1.b;
        }

        public String a()
        {
            return d;
        }

        public void a(String s1)
        {
            d = s1;
        }

        public String b()
        {
            return c;
        }

        public void b(String s1)
        {
            c = s1;
        }

        public a(String s2)
        {
            a = s.this;
            super();
            b = s2;
        }
    }

    public class b
    {

        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public JSONObject f;
        final s g;

        public b()
        {
            g = s.this;
            super();
            a = "";
            b = "";
            c = "";
            d = "";
            e = "";
        }

        public b(JSONObject jsonobject)
            throws Exception
        {
            g = s.this;
            super();
            f = jsonobject;
            if (jsonobject.has("city"))
            {
                a = jsonobject.getString("city");
            } else
            {
                a = "";
            }
            if (jsonobject.has("country"))
            {
                b = jsonobject.getString("country");
            } else
            {
                b = "";
            }
            if (jsonobject.has("state"))
            {
                c = jsonobject.getString("state");
            } else
            {
                c = "";
            }
            if (jsonobject.has("zip"))
            {
                d = jsonobject.getString("zip");
            } else
            {
                d = "";
            }
            if (jsonobject.has("dma"))
            {
                e = jsonobject.getString("dma");
                return;
            } else
            {
                e = "";
                return;
            }
        }
    }

    public class c
    {

        final s a;
        private String b;
        private String c;
        private int d;
        private String e;
        private long f;
        private String g;
        private int h;
        private int i;
        private boolean j;
        private String k;
        private long l;

        static String a(c c1)
        {
            return c1.k;
        }

        static boolean b(c c1)
        {
            return c1.j;
        }

        static long c(c c1)
        {
            return c1.l;
        }

        public String a()
        {
            if (j)
            {
                return b;
            } else
            {
                return n.b(b);
            }
        }

        public int b()
        {
            return h;
        }

        public int c()
        {
            return i;
        }

        public String d()
        {
            return b;
        }

        public String e()
        {
            return g;
        }

        public String f()
        {
            return c;
        }

        public int g()
        {
            return d;
        }

        public long h()
        {
            return f;
        }

        public c(JSONObject jsonobject)
            throws Exception
        {
            a = s.this;
            super();
            e = "";
            f = 0L;
            g = "";
            h = 0;
            i = 0;
            j = false;
            b = jsonobject.getString("video-url");
            c = jsonobject.getString("format");
            g = jsonobject.getString("tag");
            if (jsonobject.has("streaming"))
            {
                j = jsonobject.getBoolean("streaming");
            }
            if (j)
            {
                if (jsonobject.has("ad-size"))
                {
                    d = jsonobject.getInt("ad-size");
                }
            } else
            {
                d = jsonobject.getInt("ad-size");
            }
            if (jsonobject.has("video-crc-32"))
            {
                f = jsonobject.getLong("video-crc-32");
            } else
            if (jsonobject.has("video-crc32"))
            {
                f = jsonobject.getLong("video-crc32");
            }
            if (jsonobject.has("streaming"))
            {
                j = jsonobject.getBoolean("streaming");
            }
            if (jsonobject.has("embed-video-player"))
            {
                k = jsonobject.getString("embed-video-player");
                if (jsonobject.has("embed-video-player-crc32"))
                {
                    l = jsonobject.getLong("embed-video-player-crc32");
                }
            } else
            {
                k = null;
            }
            s1 = c.split("-")[1].split("x");
            h = Integer.parseInt(s.this[0]);
            i = Integer.parseInt(s.this[1]);
        }
    }


    private b A;
    private com.tremorvideo.sdk.android.richmedia.a B;
    private int C;
    protected com.tremorvideo.sdk.android.richmedia.b.c r;
    protected com.tremorvideo.sdk.android.richmedia.a.f s;
    protected boolean t;
    private String u;
    private long v;
    private List w;
    private int x;
    private boolean y;
    private String z;

    public s(br br, JSONObject jsonobject, boolean flag)
        throws Exception
    {
        int i1 = 0;
        super(br, jsonobject, flag);
        v = 0L;
        w = new ArrayList();
        y = false;
        C = -1;
        u = jsonobject.getString("asset-url");
        if (jsonobject.has("skip"))
        {
            y = Boolean.parseBoolean(jsonobject.getString("skip"));
        }
        if (jsonobject.has("skip-delay"))
        {
            x = jsonobject.getInt("skip-delay");
        } else
        {
            x = 0;
        }
        if (!jsonobject.has("asset-crc-32")) goto _L2; else goto _L1
_L1:
        v = jsonobject.getLong("asset-crc-32");
_L4:
        for (br = jsonobject.getJSONArray("video"); i1 < br.length(); i1++)
        {
            w.add(new c(br.getJSONObject(i1)));
        }

        break; /* Loop/switch isn't completed */
_L2:
        if (jsonobject.has("asset-crc32"))
        {
            v = jsonobject.getLong("asset-crc32");
        }
        if (true) goto _L4; else goto _L3
_L3:
        q = new HashMap();
        if (jsonobject.has("watermark"))
        {
            t = jsonobject.getBoolean("watermark");
        } else
        {
            t = true;
        }
        if (jsonobject.has("geo-info"))
        {
            A = new b(jsonobject.getJSONObject("geo-info"));
        } else
        {
            A = new b();
        }
        if (jsonobject.has("tms-movie-board"))
        {
            h = new com.tremorvideo.sdk.android.b.c(jsonobject.getJSONObject("tms-movie-board"), A);
        } else
        {
            h = null;
        }
        if (jsonobject.has("duration"))
        {
            C = jsonobject.getInt("duration") * 1000;
        }
        a(jsonobject);
        return;
    }

    private aw[] d(String s1)
    {
        boolean flag = false;
        Iterator iterator = b.iterator();
        int i1 = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (s1.equals(((aw)iterator.next()).d()))
            {
                i1++;
            }
        } while (true);
        aw aaw[] = new aw[i1];
        Iterator iterator1 = b.iterator();
        i1 = ((flag) ? 1 : 0);
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            aw aw1 = (aw)iterator1.next();
            if (s1.equals(aw1.d()))
            {
                aaw[i1] = aw1;
                i1++;
            }
        } while (true);
        return aaw;
    }

    public int A()
    {
        return C;
    }

    public String E()
    {
        return B.b();
    }

    public int F()
    {
        return x;
    }

    public boolean G()
    {
        return y;
    }

    public com.tremorvideo.sdk.android.richmedia.a H()
    {
        return B;
    }

    public l[] I()
    {
        l al[] = new l[w.size()];
        for (int i1 = 0; i1 < w.size(); i1++)
        {
            c c1 = (c)w.get(i1);
            aw aaw[] = d(c1.e());
            a a1 = null;
            if (com.tremorvideo.sdk.android.videoad.c.a(c1) != null)
            {
                a1 = h(ae.a(com.tremorvideo.sdk.android.videoad.c.a(c1)));
            }
            al[i1] = new l(c1.e(), c1.a(), c1.b(), c1.c(), aaw, c.b(c1), a1);
        }

        return al;
    }

    public String a(int i1)
    {
        return ((c)w.get(i1)).d();
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = w.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (c)((Iterator) (obj)).next();
            if (!c.b(((c) (obj1))))
            {
                HashMap hashmap3 = new HashMap(4);
                hashmap3.put("ad", this);
                hashmap3.put("url", ((c) (obj1)).d());
                hashmap3.put("crc", Long.valueOf(((c) (obj1)).h()));
                hashmap3.put("index", Integer.valueOf(w.indexOf(obj1)));
                arraylist.add(new n.a(this, bf.d.b, "video", hashmap3));
            } else
            if (com.tremorvideo.sdk.android.videoad.c.a(((c) (obj1))) != null && com.tremorvideo.sdk.android.videoad.c.a(((c) (obj1))).length() > 0)
            {
                int i1 = ae.a(com.tremorvideo.sdk.android.videoad.c.a(((c) (obj1))));
                if (!q.containsKey(Integer.valueOf(i1)))
                {
                    Object obj2 = new a(com.tremorvideo.sdk.android.videoad.c.a(((c) (obj1))));
                    q.put(Integer.valueOf(i1), obj2);
                    obj2 = new HashMap(3);
                    ((Map) (obj2)).put("url", com.tremorvideo.sdk.android.videoad.c.a(((c) (obj1))));
                    ((Map) (obj2)).put("crc", Long.valueOf(com.tremorvideo.sdk.android.videoad.c.c(((c) (obj1)))));
                    ((Map) (obj2)).put("checkCache", Boolean.valueOf(true));
                    arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.a, (new StringBuilder()).append("embedPlayer_").append(i1).toString(), ((Map) (obj2))));
                    obj1 = new HashMap(2);
                    ((Map) (obj1)).put("hashName", Integer.valueOf(i1));
                    arraylist.add(new n.a(this, bf.d.g, "processPlayer", ((Map) (obj1))));
                }
            }
        } while (true);
        obj = new HashMap(2);
        ((Map) (obj)).put("url", u);
        ((Map) (obj)).put("crc", Long.valueOf(v));
        arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.a, "asset", ((Map) (obj))));
        if (c != null)
        {
            HashMap hashmap = new HashMap(2);
            hashmap.put("url", c.c());
            hashmap.put("crc", Long.valueOf(c.d()));
            hashmap.put("checkCache", Boolean.valueOf(false));
            arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.a, "coupon", hashmap));
        }
        if (e != null)
        {
            arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.c, "survey"));
        }
        if (g != null)
        {
            HashMap hashmap1 = new HashMap(2);
            hashmap1.put("url", g.b());
            hashmap1.put("checkCache", Boolean.valueOf(false));
            arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.a, "buyItNowDealsXml", hashmap1));
            hashmap1 = new HashMap(3);
            hashmap1.put("url", g.c());
            hashmap1.put("crc", g.d());
            hashmap1.put("checkCache", Boolean.valueOf(true));
            arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.a, "buyItNowTemplate", hashmap1));
            arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.f, "processBIN"));
        }
        if (h != null)
        {
            HashMap hashmap2 = new HashMap(3);
            hashmap2.put("url", h.c());
            hashmap2.put("crc", h.d());
            hashmap2.put("checkCache", Boolean.valueOf(true));
            arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.a, "movieBoardTemplate", hashmap2));
            arraylist.add(new n.a(this, bf.d.h, "processMovieBoard"));
        }
        return arraylist;
    }

    public void a(Context context)
    {
        super.a(context);
        try
        {
            ZipFile zipfile = new ZipFile(new File(z));
            B = new com.tremorvideo.sdk.android.richmedia.a();
            B.a(zipfile, new f(context), A, t);
            d = new bv();
            d.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            B = null;
        }
        k = false;
        com.tremorvideo.sdk.android.videoad.ad.a(context);
    }

    public void a(String s1, Object obj)
        throws Exception
    {
        if (s1.compareTo("asset") == 0)
        {
            z = (String)obj;
            return;
        } else
        {
            super.a(s1, obj);
            return;
        }
    }

    public int b(int i1)
    {
        return ((c)w.get(i1)).g();
    }

    public String c(int i1)
    {
        return ((c)w.get(i1)).f();
    }

    public void c()
    {
        super.c();
        if (B != null)
        {
            B.f();
        }
    }

    public int d(int i1)
    {
        if (i1 < w.size())
        {
            return ((c)w.get(i1)).g();
        } else
        {
            return 0;
        }
    }

    public void d()
    {
        if (r != null)
        {
            B.x();
            r.c();
        }
        if (s != null)
        {
            B.y();
            s.b();
        }
        Object obj = t();
        if (obj != null)
        {
            obj = new File((new StringBuilder()).append(t()).append("/").append(((String) (obj))).toString());
            if (((File) (obj)).exists())
            {
                ae.a(((File) (obj)));
            }
        }
        super.d();
    }

    public long f(int i1)
    {
        return ((c)w.get(i1)).h();
    }

    public String i()
    {
        return b(u);
    }

    public int j()
    {
        int j1 = w.size() + 1;
        int i1 = j1;
        if (g != null)
        {
            i1 = j1 + 1;
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + 1;
        }
        return j1;
    }

    public String[] k()
    {
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < w.size(); i1++)
        {
            arraylist.add(((c)w.get(i1)).a());
        }

        arraylist.add(i());
        if (g != null)
        {
            arraylist.add(b(g.c()));
        }
        if (h != null)
        {
            arraylist.add(b(h.c()));
        }
        if (q != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = q.entrySet().iterator(); iterator.hasNext(); arraylist.add(b(com.tremorvideo.sdk.android.videoad.a.a((a)q.get(entry.getKey())))))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        if (c != null)
        {
            arraylist.add(b(c.c()));
        }
        if (e != null)
        {
            arraylist.add(b(e.c()));
        }
        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }

    protected boolean o()
    {
        return true;
    }

    public b r()
    {
        return A;
    }

    public String t()
    {
        return B.a();
    }
}

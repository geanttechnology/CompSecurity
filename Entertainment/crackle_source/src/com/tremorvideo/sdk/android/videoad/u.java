// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            n, bv, bx, ad, 
//            aw, ae, az, br

public class u extends n
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a e[];
        private String d;

        public static a a(String s)
        {
            a aa[] = values();
            int i1 = aa.length;
            for (int l = 0; l < i1; l++)
            {
                a a1 = aa[l];
                if (a1.toString().equals(s))
                {
                    return a1;
                }
            }

            return a;
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tremorvideo/sdk/android/videoad/u$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        public String toString()
        {
            return d;
        }

        static 
        {
            a = new a("Default", 0, "default");
            b = new a("AppStart", 1, "appstart");
            c = new a("PreRoll", 2, "preroll");
            e = (new a[] {
                a, b, c
            });
        }

        private a(String s, int l, String s1)
        {
            super(s, l);
            d = s1;
        }
    }

    public static class b
    {

        private String a;
        private int b;
        private int c;
        private int d;
        private int e;
        private c f;
        private int g;
        private boolean h;

        public int a()
        {
            if (f.b())
            {
                return d;
            } else
            {
                return 0;
            }
        }

        public String b()
        {
            return a;
        }

        public int c()
        {
            return b;
        }

        public int d()
        {
            return c;
        }

        public int e()
        {
            return d;
        }

        public int f()
        {
            return e;
        }

        public c g()
        {
            return f;
        }

        public b(JSONObject jsonobject)
            throws Exception
        {
            a = jsonobject.getString("url");
            d = jsonobject.getInt("layout-width");
            e = jsonobject.getInt("layout-height");
            f = c.values()[jsonobject.getInt("layout")];
            g = Long.decode(jsonobject.getString("background-color")).intValue();
            h = jsonobject.getBoolean("opaque");
            if (jsonobject.has("layout-x"))
            {
                b = jsonobject.getInt("layout-x");
            }
            if (jsonobject.has("layout-y"))
            {
                c = jsonobject.getInt("layout-y");
            }
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        private static final c g[];
        private String f;

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/tremorvideo/sdk/android/videoad/u$c, s);
        }

        public static c[] values()
        {
            return (c[])g.clone();
        }

        public boolean a()
        {
            return ordinal() == a.ordinal() || ordinal() == b.ordinal();
        }

        public boolean b()
        {
            return ordinal() == c.ordinal() || ordinal() == d.ordinal();
        }

        public String toString()
        {
            return f;
        }

        static 
        {
            a = new c("Top", 0, "top");
            b = new c("Bottom", 1, "bottom");
            c = new c("Left", 2, "left");
            d = new c("Right", 3, "right");
            e = new c("Absolute", 4, "absolute");
            g = (new c[] {
                a, b, c, d, e
            });
        }

        private c(String s, int l, String s1)
        {
            super(s, l);
            f = s1;
        }
    }


    protected long A;
    protected String B;
    protected int C;
    protected int D;
    protected a E;
    protected String F;
    protected long G;
    protected String H;
    protected String I;
    protected String J;
    protected String K;
    protected bx L;
    protected boolean M;
    protected boolean N;
    protected boolean O;
    protected b P;
    protected int w;
    protected boolean x;
    protected int y;
    protected String z;

    protected u(int l, boolean flag)
        throws Exception
    {
        O = false;
        P = null;
        N = flag;
        if (l > 0)
        {
            x = true;
            y = l;
        } else
        {
            x = false;
            y = 0;
        }
        d = new bv();
    }

    protected u(br br, JSONObject jsonobject)
        throws Exception
    {
        super(br, jsonobject, false);
        O = false;
        P = null;
    }

    public u(br br, JSONObject jsonobject, boolean flag)
        throws Exception
    {
        super(br, jsonobject, flag);
        O = false;
        P = null;
        d = new bv();
        w = jsonobject.getInt("priority");
        x = jsonobject.getBoolean("skip");
        y = jsonobject.getInt("skip-delay");
        D = jsonobject.getInt("duration");
        z = jsonobject.getString("url");
        B = jsonobject.getString("format");
        C = jsonobject.getInt("ad-size");
        E = a.a(jsonobject.getString("placement"));
        if (jsonobject.has("video-crc-32"))
        {
            A = jsonobject.getLong("video-crc-32");
        } else
        if (jsonobject.has("video-crc32"))
        {
            A = jsonobject.getLong("video-crc32");
        }
        if (jsonobject.has("theme-crc-32"))
        {
            G = jsonobject.getLong("theme-crc-32");
        } else
        if (jsonobject.has("theme-crc32"))
        {
            G = jsonobject.getLong("theme-crc32");
        }
        if (jsonobject.has("watermark"))
        {
            N = jsonobject.getBoolean("watermark");
        } else
        {
            N = true;
        }
        if (jsonobject.has("twitter-feed") && flag)
        {
            d(jsonobject.getString("twitter-feed"));
        }
        if (jsonobject.has("theme-url"))
        {
            F = jsonobject.getString("theme-url");
        } else
        {
            F = null;
        }
        if (jsonobject.has("html5"))
        {
            P = new b(jsonobject.getJSONObject("html5"));
        }
        a(jsonobject);
    }

    private void d(String s)
    {
        L = new bx(this);
        L.a(s, new bx.c() {

            final u a;

            public void a(bx bx1, boolean flag)
            {
                a.M = flag;
            }

            
            {
                a = u.this;
                super();
            }
        });
    }

    private void e(String s)
    {
        File file;
        file = new File(s);
        if (!file.exists())
        {
            ad.a(ad.d.b, (new StringBuilder()).append("Can't find theme: ").append(s).append(", using default...").toString());
            return;
        }
        try
        {
            s = new ZipFile(file);
            d.a(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.a(s);
        }
        d.a();
        return;
    }

    public int A()
    {
        return D * 1000;
    }

    public int E()
    {
        return D;
    }

    public boolean F()
    {
        return M;
    }

    public bx G()
    {
        return L;
    }

    public boolean H()
    {
        return H != null;
    }

    public String I()
    {
        return H;
    }

    public String J()
    {
        return I;
    }

    public String K()
    {
        return J;
    }

    public boolean L()
    {
        return N;
    }

    public boolean M()
    {
        if (P != null)
        {
            return false;
        } else
        {
            return x;
        }
    }

    public boolean N()
    {
        return x;
    }

    public int O()
    {
        return y * 1000;
    }

    public boolean P()
    {
        return R() != null;
    }

    public List Q()
    {
        ArrayList arraylist = new ArrayList();
        if (P == null)
        {
            Iterator iterator = b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                aw aw1 = (aw)iterator.next();
                if (aw1.l())
                {
                    arraylist.add(aw1);
                }
            } while (true);
        }
        return arraylist;
    }

    public aw R()
    {
label0:
        {
            if (!x)
            {
                break label0;
            }
            Iterator iterator = b.iterator();
            aw aw1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                aw1 = (aw)iterator.next();
            } while (aw1.a() != aw.b.w);
            return aw1;
        }
        return null;
    }

    public b S()
    {
        return P;
    }

    public String a(int l)
    {
        return z;
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        if (!p)
        {
            HashMap hashmap = new HashMap(4);
            hashmap.put("ad", this);
            hashmap.put("url", z);
            hashmap.put("crc", Long.valueOf(A));
            hashmap.put("index", Integer.valueOf(0));
            arraylist.add(new n.a(this, bf.d.b, "video", hashmap));
        }
        if (c != null)
        {
            HashMap hashmap1 = new HashMap(2);
            hashmap1.put("url", c.c());
            hashmap1.put("crc", Long.valueOf(c.d()));
            hashmap1.put("checkCache", Boolean.valueOf(false));
            arraylist.add(new n.a(this, bf.d.a, "coupon", hashmap1));
        }
        if (F != null)
        {
            HashMap hashmap2 = new HashMap(2);
            hashmap2.put("url", F);
            hashmap2.put("crc", Long.valueOf(G));
            arraylist.add(new n.a(this, bf.d.a, "theme", hashmap2));
        }
        if (e != null)
        {
            arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.c, "survey"));
        }
        if (g != null)
        {
            HashMap hashmap3 = new HashMap(2);
            hashmap3.put("url", g.b());
            hashmap3.put("checkCache", Boolean.valueOf(false));
            arraylist.add(new n.a(this, bf.d.a, "buyItNowDealsXml", hashmap3));
            hashmap3 = new HashMap(3);
            hashmap3.put("url", g.c());
            hashmap3.put("crc", g.d());
            hashmap3.put("checkCache", Boolean.valueOf(true));
            arraylist.add(new n.a(this, bf.d.a, "buyItNowTemplate", hashmap3));
            arraylist.add(new n.a(this, bf.d.f, "processBIN"));
        }
        if (h != null)
        {
            HashMap hashmap4 = new HashMap(3);
            hashmap4.put("url", h.c());
            hashmap4.put("crc", h.d());
            hashmap4.put("checkCache", Boolean.valueOf(true));
            arraylist.add(new n.a(this, bf.d.a, "movieBoardTemplate", hashmap4));
            arraylist.add(new n.a(this, bf.d.h, "processMovieBoard"));
        }
        return arraylist;
    }

    public void a(Context context)
    {
        super.a(context);
        if (K == null)
        {
            d.a();
            return;
        } else
        {
            e(K);
            return;
        }
    }

    public void a(String s, Object obj)
        throws Exception
    {
        if (s.equals("theme"))
        {
            K = (String)obj;
        }
        super.a(s, obj);
    }

    public int b(int l)
    {
        return C;
    }

    public String c(int l)
    {
        return B;
    }

    public int d(int l)
    {
        if (l != 0 || p)
        {
            return 0;
        } else
        {
            return C;
        }
    }

    public long f(int l)
    {
        return A;
    }

    public String i()
    {
        return b(z);
    }

    public int j()
    {
        int l;
        int i1;
        if (p)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        l = i1;
        if (F != null)
        {
            l = i1 + 1;
        }
        i1 = l;
        if (c != null)
        {
            i1 = l + 1;
        }
        return i1;
    }

    public String[] k()
    {
        ArrayList arraylist = new ArrayList();
        if (!p)
        {
            arraylist.add(b(z));
        }
        if (F != null)
        {
            arraylist.add((new StringBuilder()).append(b(z)).append(".theme").toString());
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

    public bv q()
    {
        return d;
    }
}

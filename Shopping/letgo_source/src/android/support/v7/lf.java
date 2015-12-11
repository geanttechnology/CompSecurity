// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.c;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.o;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.t;
import com.google.android.gms.common.internal.x;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            wh, ux, wb, uy, 
//            wq, wo, wl, wp, 
//            wr, ws, uu, lg, 
//            uv, wn, lc, ld, 
//            lb, wm, wk, kx

public class lf extends o
    implements wh
{

    private static DecimalFormat a;
    private final r b;
    private final String c;
    private final Uri d;
    private final boolean e;
    private final boolean f;

    public lf(r r1, String s)
    {
        this(r1, s, true, false);
    }

    public lf(r r1, String s, boolean flag, boolean flag1)
    {
        super(r1);
        x.a(s);
        b = r1;
        c = s;
        e = flag;
        f = flag1;
        d = a(c);
    }

    static Uri a(String s)
    {
        x.a(s);
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(s);
        return builder.build();
    }

    static String a(double d1)
    {
        if (a == null)
        {
            a = new DecimalFormat("0.######");
        }
        return a.format(d1);
    }

    private static String a(Object obj)
    {
        if (obj == null)
        {
            obj = null;
        } else
        if (obj instanceof String)
        {
            String s = (String)obj;
            obj = s;
            if (TextUtils.isEmpty(s))
            {
                return null;
            }
        } else
        {
            if (obj instanceof Double)
            {
                obj = (Double)obj;
                if (((Double) (obj)).doubleValue() != 0.0D)
                {
                    return a(((Double) (obj)).doubleValue());
                } else
                {
                    return null;
                }
            }
            if (obj instanceof Boolean)
            {
                if (obj != Boolean.FALSE)
                {
                    return "1";
                } else
                {
                    return null;
                }
            } else
            {
                return String.valueOf(obj);
            }
        }
        return ((String) (obj));
    }

    private static String a(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }

    private static void a(Map map, String s, double d1)
    {
        if (d1 != 0.0D)
        {
            map.put(s, a(d1));
        }
    }

    private static void a(Map map, String s, int i, int j)
    {
        if (i > 0 && j > 0)
        {
            map.put(s, (new StringBuilder()).append(i).append("x").append(j).toString());
        }
    }

    private static void a(Map map, String s, String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            map.put(s, s1);
        }
    }

    private static void a(Map map, String s, boolean flag)
    {
        if (flag)
        {
            map.put(s, "1");
        }
    }

    public static Map b(wb wb1)
    {
        HashMap hashmap = new HashMap();
        Object obj = (ux)wb1.a(android/support/v7/ux);
        if (obj != null)
        {
            obj = ((ux) (obj)).a().entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                String s = a(entry.getValue());
                if (s != null)
                {
                    hashmap.put(entry.getKey(), s);
                }
            } while (true);
        }
        obj = (uy)wb1.a(android/support/v7/uy);
        if (obj != null)
        {
            a(hashmap, "t", ((uy) (obj)).a());
            a(hashmap, "cid", ((uy) (obj)).b());
            a(hashmap, "uid", ((uy) (obj)).c());
            a(hashmap, "sc", ((uy) (obj)).f());
            a(hashmap, "sf", ((uy) (obj)).h());
            a(hashmap, "ni", ((uy) (obj)).g());
            a(hashmap, "adid", ((uy) (obj)).d());
            a(hashmap, "ate", ((uy) (obj)).e());
        }
        obj = (wq)wb1.a(android/support/v7/wq);
        if (obj != null)
        {
            a(hashmap, "cd", ((wq) (obj)).b());
            a(hashmap, "a", ((wq) (obj)).c());
            a(hashmap, "dr", ((wq) (obj)).f());
        }
        obj = (wo)wb1.a(android/support/v7/wo);
        if (obj != null)
        {
            a(hashmap, "ec", ((wo) (obj)).a());
            a(hashmap, "ea", ((wo) (obj)).b());
            a(hashmap, "el", ((wo) (obj)).c());
            a(hashmap, "ev", ((wo) (obj)).d());
        }
        obj = (wl)wb1.a(android/support/v7/wl);
        if (obj != null)
        {
            a(hashmap, "cn", ((wl) (obj)).a());
            a(hashmap, "cs", ((wl) (obj)).b());
            a(hashmap, "cm", ((wl) (obj)).c());
            a(hashmap, "ck", ((wl) (obj)).d());
            a(hashmap, "cc", ((wl) (obj)).e());
            a(hashmap, "ci", ((wl) (obj)).f());
            a(hashmap, "anid", ((wl) (obj)).g());
            a(hashmap, "gclid", ((wl) (obj)).h());
            a(hashmap, "dclid", ((wl) (obj)).i());
            a(hashmap, "aclid", ((wl) (obj)).j());
        }
        obj = (wp)wb1.a(android/support/v7/wp);
        if (obj != null)
        {
            a(hashmap, "exd", ((wp) (obj)).a());
            a(hashmap, "exf", ((wp) (obj)).b());
        }
        obj = (wr)wb1.a(android/support/v7/wr);
        if (obj != null)
        {
            a(hashmap, "sn", ((wr) (obj)).a());
            a(hashmap, "sa", ((wr) (obj)).b());
            a(hashmap, "st", ((wr) (obj)).c());
        }
        obj = (ws)wb1.a(android/support/v7/ws);
        if (obj != null)
        {
            a(hashmap, "utv", ((ws) (obj)).a());
            a(hashmap, "utt", ((ws) (obj)).b());
            a(hashmap, "utc", ((ws) (obj)).c());
            a(hashmap, "utl", ((ws) (obj)).d());
        }
        obj = (uu)wb1.a(android/support/v7/uu);
        if (obj != null)
        {
            obj = ((uu) (obj)).a().entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                String s1 = lg.a(((Integer)entry1.getKey()).intValue());
                if (!TextUtils.isEmpty(s1))
                {
                    hashmap.put(s1, entry1.getValue());
                }
            } while (true);
        }
        obj = (uv)wb1.a(android/support/v7/uv);
        if (obj != null)
        {
            obj = ((uv) (obj)).a().entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry2 = (java.util.Map.Entry)((Iterator) (obj)).next();
                String s2 = lg.b(((Integer)entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(s2))
                {
                    hashmap.put(s2, a(((Double)entry2.getValue()).doubleValue()));
                }
            } while (true);
        }
        obj = (wn)wb1.a(android/support/v7/wn);
        if (obj != null)
        {
            Object obj1 = ((wn) (obj)).a();
            if (obj1 != null)
            {
                for (obj1 = ((lc) (obj1)).a().entrySet().iterator(); ((Iterator) (obj1)).hasNext();)
                {
                    java.util.Map.Entry entry4 = (java.util.Map.Entry)((Iterator) (obj1)).next();
                    if (((String)entry4.getKey()).startsWith("&"))
                    {
                        hashmap.put(((String)entry4.getKey()).substring(1), entry4.getValue());
                    } else
                    {
                        hashmap.put(entry4.getKey(), entry4.getValue());
                    }
                }

            }
            obj1 = ((wn) (obj)).d().iterator();
            for (int i = 1; ((Iterator) (obj1)).hasNext(); i++)
            {
                hashmap.putAll(((ld)((Iterator) (obj1)).next()).e(lg.f(i)));
            }

            obj1 = ((wn) (obj)).b().iterator();
            for (int j = 1; ((Iterator) (obj1)).hasNext(); j++)
            {
                hashmap.putAll(((lb)((Iterator) (obj1)).next()).g(lg.d(j)));
            }

            obj = ((wn) (obj)).c().entrySet().iterator();
            for (int k = 1; ((Iterator) (obj)).hasNext(); k++)
            {
                java.util.Map.Entry entry3 = (java.util.Map.Entry)((Iterator) (obj)).next();
                Object obj2 = (List)entry3.getValue();
                String s3 = lg.i(k);
                obj2 = ((List) (obj2)).iterator();
                for (int i1 = 1; ((Iterator) (obj2)).hasNext(); i1++)
                {
                    hashmap.putAll(((lb)((Iterator) (obj2)).next()).g((new StringBuilder()).append(s3).append(android.support.v7.lg.g(i1)).toString()));
                }

                if (!TextUtils.isEmpty((CharSequence)entry3.getKey()))
                {
                    hashmap.put((new StringBuilder()).append(s3).append("nm").toString(), entry3.getKey());
                }
            }

        }
        obj = (wm)wb1.a(android/support/v7/wm);
        if (obj != null)
        {
            a(hashmap, "ul", ((wm) (obj)).f());
            a(hashmap, "sd", ((wm) (obj)).a());
            a(hashmap, "sr", ((wm) (obj)).b(), ((wm) (obj)).c());
            a(hashmap, "vp", ((wm) (obj)).d(), ((wm) (obj)).e());
        }
        wb1 = (wk)wb1.a(android/support/v7/wk);
        if (wb1 != null)
        {
            a(hashmap, "an", wb1.a());
            a(hashmap, "aid", wb1.c());
            a(hashmap, "aiid", wb1.d());
            a(hashmap, "av", wb1.b());
        }
        return hashmap;
    }

    public Uri a()
    {
        return d;
    }

    public void a(wb wb1)
    {
        x.a(wb1);
        x.b(wb1.f(), "Can't deliver not submitted measurement");
        x.c("deliver should be called on worker thread");
        Object obj1 = wb1.a();
        Object obj = (uy)((wb) (obj1)).b(android/support/v7/uy);
        if (TextUtils.isEmpty(((uy) (obj)).a()))
        {
            p().a(b(((wb) (obj1))), "Ignoring measurement without type");
        } else
        {
            if (TextUtils.isEmpty(((uy) (obj)).b()))
            {
                p().a(b(((wb) (obj1))), "Ignoring measurement without client id");
                return;
            }
            if (!b.k().f())
            {
                double d1 = ((uy) (obj)).h();
                if (l.a(d1, ((uy) (obj)).b()))
                {
                    b("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d1));
                    return;
                }
                obj1 = b(((wb) (obj1)));
                ((Map) (obj1)).put("v", "1");
                ((Map) (obj1)).put("_v", q.b);
                ((Map) (obj1)).put("tid", c);
                if (b.k().e())
                {
                    c("Dry run is enabled. GoogleAnalytics would have sent", a(((Map) (obj1))));
                    return;
                }
                HashMap hashmap = new HashMap();
                l.a(hashmap, "uid", ((uy) (obj)).c());
                Object obj2 = (wk)wb1.a(android/support/v7/wk);
                if (obj2 != null)
                {
                    l.a(hashmap, "an", ((wk) (obj2)).a());
                    l.a(hashmap, "aid", ((wk) (obj2)).c());
                    l.a(hashmap, "av", ((wk) (obj2)).b());
                    l.a(hashmap, "aiid", ((wk) (obj2)).d());
                }
                obj2 = ((uy) (obj)).b();
                String s = c;
                boolean flag;
                if (!TextUtils.isEmpty(((uy) (obj)).d()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj = new t(0L, ((String) (obj2)), s, flag, 0L, hashmap);
                ((Map) (obj1)).put("_s", String.valueOf(t().a(((t) (obj)))));
                wb1 = new c(p(), ((Map) (obj1)), wb1.d(), true);
                t().a(wb1);
                return;
            }
        }
    }
}

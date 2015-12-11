// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.o;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.t;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.hn;
import com.google.android.gms.d.ho;
import com.google.android.gms.d.hq;
import com.google.android.gms.d.hr;
import com.google.android.gms.d.ix;
import com.google.android.gms.d.jb;
import com.google.android.gms.d.jd;
import com.google.android.gms.d.je;
import com.google.android.gms.d.jf;
import com.google.android.gms.d.jg;
import com.google.android.gms.d.jh;
import com.google.android.gms.d.ji;
import com.google.android.gms.d.jj;
import com.google.android.gms.d.jk;
import com.google.android.gms.d.jl;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            k, e

public final class j extends o
    implements jb
{

    private static DecimalFormat a;
    private final r b;
    private final String c;
    private final Uri d;
    private final boolean e;
    private final boolean f;

    public j(r r1, String s)
    {
        this(r1, s, (byte)0);
    }

    private j(r r1, String s, byte byte0)
    {
        super(r1);
        w.a(s);
        b = r1;
        c = s;
        e = true;
        f = false;
        d = a(c);
    }

    public static Uri a(String s)
    {
        w.a(s);
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(s);
        return builder.build();
    }

    private static String a(double d1)
    {
        if (a == null)
        {
            a = new DecimalFormat("0.######");
        }
        return a.format(d1);
    }

    private static void a(Map map, String s, double d1)
    {
        if (d1 != 0.0D)
        {
            map.put(s, a(d1));
        }
    }

    private static void a(Map map, String s, int i, int i1)
    {
        if (i > 0 && i1 > 0)
        {
            map.put(s, (new StringBuilder()).append(i).append("x").append(i1).toString());
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

    private static Map b(ix ix1)
    {
        Object obj;
        HashMap hashmap;
        hashmap = new HashMap();
        obj = (hq)ix1.a(com/google/android/gms/d/hq);
        if (obj == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = Collections.unmodifiableMap(((hq) (obj)).a).entrySet().iterator();
_L8:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        java.util.Map.Entry entry4;
        entry4 = (java.util.Map.Entry)iterator.next();
        obj = entry4.getValue();
        if (obj != null) goto _L5; else goto _L4
_L4:
        obj = null;
_L6:
        if (obj != null)
        {
            hashmap.put(entry4.getKey(), obj);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (obj instanceof String)
        {
            String s = (String)obj;
            obj = s;
            if (TextUtils.isEmpty(s))
            {
                obj = null;
            }
        } else
        if (obj instanceof Double)
        {
            obj = (Double)obj;
            if (((Double) (obj)).doubleValue() != 0.0D)
            {
                obj = a(((Double) (obj)).doubleValue());
            } else
            {
                obj = null;
            }
        } else
        if (obj instanceof Boolean)
        {
            if (obj != Boolean.FALSE)
            {
                obj = "1";
            } else
            {
                obj = null;
            }
        } else
        {
            obj = String.valueOf(obj);
        }
        if (true) goto _L6; else goto _L2
_L2:
        Object obj1 = (hr)ix1.a(com/google/android/gms/d/hr);
        if (obj1 != null)
        {
            a(hashmap, "t", ((hr) (obj1)).a);
            a(hashmap, "cid", ((hr) (obj1)).b);
            a(hashmap, "uid", ((hr) (obj1)).c);
            a(hashmap, "sc", ((hr) (obj1)).f);
            a(hashmap, "sf", ((hr) (obj1)).h);
            a(hashmap, "ni", ((hr) (obj1)).g);
            a(hashmap, "adid", ((hr) (obj1)).d);
            a(hashmap, "ate", ((hr) (obj1)).e);
        }
        obj1 = (jj)ix1.a(com/google/android/gms/d/jj);
        if (obj1 != null)
        {
            a(hashmap, "cd", ((jj) (obj1)).a);
            a(hashmap, "a", ((jj) (obj1)).b);
            a(hashmap, "dr", ((jj) (obj1)).e);
        }
        obj1 = (jh)ix1.a(com/google/android/gms/d/jh);
        if (obj1 != null)
        {
            a(hashmap, "ec", ((jh) (obj1)).a);
            a(hashmap, "ea", ((jh) (obj1)).b);
            a(hashmap, "el", ((jh) (obj1)).c);
            a(hashmap, "ev", ((jh) (obj1)).d);
        }
        obj1 = (je)ix1.a(com/google/android/gms/d/je);
        if (obj1 != null)
        {
            a(hashmap, "cn", ((je) (obj1)).a);
            a(hashmap, "cs", ((je) (obj1)).b);
            a(hashmap, "cm", ((je) (obj1)).c);
            a(hashmap, "ck", ((je) (obj1)).d);
            a(hashmap, "cc", ((je) (obj1)).e);
            a(hashmap, "ci", ((je) (obj1)).f);
            a(hashmap, "anid", ((je) (obj1)).g);
            a(hashmap, "gclid", ((je) (obj1)).h);
            a(hashmap, "dclid", ((je) (obj1)).i);
            a(hashmap, "aclid", ((je) (obj1)).j);
        }
        obj1 = (ji)ix1.a(com/google/android/gms/d/ji);
        if (obj1 != null)
        {
            a(hashmap, "exd", ((ji) (obj1)).a);
            a(hashmap, "exf", ((ji) (obj1)).b);
        }
        obj1 = (jk)ix1.a(com/google/android/gms/d/jk);
        if (obj1 != null)
        {
            a(hashmap, "sn", ((jk) (obj1)).a);
            a(hashmap, "sa", ((jk) (obj1)).b);
            a(hashmap, "st", ((jk) (obj1)).c);
        }
        obj1 = (jl)ix1.a(com/google/android/gms/d/jl);
        if (obj1 != null)
        {
            a(hashmap, "utv", ((jl) (obj1)).a);
            a(hashmap, "utt", ((jl) (obj1)).b);
            a(hashmap, "utc", ((jl) (obj1)).c);
            a(hashmap, "utl", ((jl) (obj1)).d);
        }
        obj1 = (hn)ix1.a(com/google/android/gms/d/hn);
        if (obj1 != null)
        {
            obj1 = Collections.unmodifiableMap(((hn) (obj1)).a).entrySet().iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                String s1 = com.google.android.gms.analytics.k.a("cd", ((Integer)entry.getKey()).intValue());
                if (!TextUtils.isEmpty(s1))
                {
                    hashmap.put(s1, entry.getValue());
                }
            } while (true);
        }
        obj1 = (ho)ix1.a(com/google/android/gms/d/ho);
        if (obj1 != null)
        {
            obj1 = Collections.unmodifiableMap(((ho) (obj1)).a).entrySet().iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj1)).next();
                String s2 = com.google.android.gms.analytics.k.a("cm", ((Integer)entry1.getKey()).intValue());
                if (!TextUtils.isEmpty(s2))
                {
                    hashmap.put(s2, a(((Double)entry1.getValue()).doubleValue()));
                }
            } while (true);
        }
        obj1 = (jg)ix1.a(com/google/android/gms/d/jg);
        if (obj1 != null)
        {
            Object obj2 = ((jg) (obj1)).d;
            if (obj2 != null)
            {
                for (obj2 = ((b) (obj2)).a().entrySet().iterator(); ((Iterator) (obj2)).hasNext();)
                {
                    java.util.Map.Entry entry3 = (java.util.Map.Entry)((Iterator) (obj2)).next();
                    if (((String)entry3.getKey()).startsWith("&"))
                    {
                        hashmap.put(((String)entry3.getKey()).substring(1), entry3.getValue());
                    } else
                    {
                        hashmap.put(entry3.getKey(), entry3.getValue());
                    }
                }

            }
            obj2 = Collections.unmodifiableList(((jg) (obj1)).b).iterator();
            for (int i = 1; ((Iterator) (obj2)).hasNext(); i++)
            {
                hashmap.putAll(((c)((Iterator) (obj2)).next()).a(com.google.android.gms.analytics.k.a("promo", i)));
            }

            obj2 = Collections.unmodifiableList(((jg) (obj1)).a).iterator();
            for (int i1 = 1; ((Iterator) (obj2)).hasNext(); i1++)
            {
                hashmap.putAll(((a)((Iterator) (obj2)).next()).a(com.google.android.gms.analytics.k.a("pr", i1)));
            }

            obj1 = ((jg) (obj1)).c.entrySet().iterator();
            for (int j1 = 1; ((Iterator) (obj1)).hasNext(); j1++)
            {
                java.util.Map.Entry entry2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
                Object obj3 = (List)entry2.getValue();
                String s3 = com.google.android.gms.analytics.k.a("il", j1);
                obj3 = ((List) (obj3)).iterator();
                for (int k1 = 1; ((Iterator) (obj3)).hasNext(); k1++)
                {
                    hashmap.putAll(((a)((Iterator) (obj3)).next()).a((new StringBuilder()).append(s3).append(com.google.android.gms.analytics.k.a("pi", k1)).toString()));
                }

                if (!TextUtils.isEmpty((CharSequence)entry2.getKey()))
                {
                    hashmap.put((new StringBuilder()).append(s3).append("nm").toString(), entry2.getKey());
                }
            }

        }
        obj1 = (jf)ix1.a(com/google/android/gms/d/jf);
        if (obj1 != null)
        {
            a(hashmap, "ul", ((jf) (obj1)).a);
            a(hashmap, "sd", ((jf) (obj1)).b);
            a(hashmap, "sr", ((jf) (obj1)).c, ((jf) (obj1)).d);
            a(hashmap, "vp", ((jf) (obj1)).e, ((jf) (obj1)).f);
        }
        ix1 = (jd)ix1.a(com/google/android/gms/d/jd);
        if (ix1 != null)
        {
            a(hashmap, "an", ((jd) (ix1)).a);
            a(hashmap, "aid", ((jd) (ix1)).c);
            a(hashmap, "aiid", ((jd) (ix1)).d);
            a(hashmap, "av", ((jd) (ix1)).b);
        }
        return hashmap;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final Uri a()
    {
        return d;
    }

    public final void a(ix ix1)
    {
        w.a(ix1);
        w.b(ix1.c, "Can't deliver not submitted measurement");
        w.c("deliver should be called on worker thread");
        Object obj = ix1.a();
        Object obj1 = (hr)((ix) (obj)).b(com/google/android/gms/d/hr);
        if (TextUtils.isEmpty(((hr) (obj1)).a))
        {
            super.i.a().a(b(((ix) (obj))), "Ignoring measurement without type");
        } else
        {
            if (TextUtils.isEmpty(((hr) (obj1)).b))
            {
                super.i.a().a(b(((ix) (obj))), "Ignoring measurement without client id");
                return;
            }
            if (!b.d().d)
            {
                double d1 = ((hr) (obj1)).h;
                if (l.a(d1, ((hr) (obj1)).b))
                {
                    b("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d1));
                    return;
                }
                obj = b(((ix) (obj)));
                ((Map) (obj)).put("v", "1");
                ((Map) (obj)).put("_v", q.b);
                ((Map) (obj)).put("tid", c);
                if (b.d().c)
                {
                    ix1 = new StringBuilder();
                    for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); ix1.append((String)((java.util.Map.Entry) (obj1)).getValue()))
                    {
                        obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                        if (ix1.length() != 0)
                        {
                            ix1.append(", ");
                        }
                        ix1.append((String)((java.util.Map.Entry) (obj1)).getKey());
                        ix1.append("=");
                    }

                    c("Dry run is enabled. GoogleAnalytics would have sent", ix1.toString());
                    return;
                }
                HashMap hashmap = new HashMap();
                l.a(hashmap, "uid", ((hr) (obj1)).c);
                Object obj2 = (jd)ix1.a(com/google/android/gms/d/jd);
                if (obj2 != null)
                {
                    l.a(hashmap, "an", ((jd) (obj2)).a);
                    l.a(hashmap, "aid", ((jd) (obj2)).c);
                    l.a(hashmap, "av", ((jd) (obj2)).b);
                    l.a(hashmap, "aiid", ((jd) (obj2)).d);
                }
                obj2 = ((hr) (obj1)).b;
                String s = c;
                boolean flag;
                if (!TextUtils.isEmpty(((hr) (obj1)).d))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj1 = new t(((String) (obj2)), s, flag, 0L, hashmap);
                ((Map) (obj)).put("_s", String.valueOf(super.i.c().a(((t) (obj1)))));
                ix1 = new com.google.android.gms.analytics.internal.c(super.i.a(), ((Map) (obj)), ix1.d, true);
                super.i.c().a(ix1);
                return;
            }
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.a.h;
import com.mopub.common.d.g;
import com.mopub.common.d.j;
import com.mopub.common.k;
import com.mopub.common.m;
import com.mopub.d.d;
import com.mopub.d.i;
import com.mopub.d.l;
import com.mopub.d.n;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mopub.c:
//            b, e, g

public final class com.mopub.c.a extends l
{
    public static interface a
        extends com.mopub.d.n.a
    {

        public abstract void a(b b1);
    }


    private final a l;
    private final com.mopub.common.a m;
    private final String n;
    private final Context o;

    public com.mopub.c.a(String s, com.mopub.common.a a1, String s1, Context context, a a2)
    {
        super(0, s, a2);
        com.mopub.common.m.a(a1);
        com.mopub.common.m.a(a2);
        n = s1;
        l = a2;
        m = a1;
        o = context.getApplicationContext();
        super.j = new d(2500, 1, 1.0F);
        super.g = false;
    }

    private void a(b b1, i i1, Location location)
    {
        Object obj = null;
        com.mopub.common.m.a(b1);
        com.mopub.common.m.a(i1);
        com.mopub.common.a.c.a a1 = new com.mopub.common.a.c.a(com.mopub.common.a.d.a, com.mopub.common.a.c.a, com.mopub.common.a.e.a.b);
        a1.e = n;
        a1.f = b1.k;
        a1.g = b1.a;
        a1.h = b1.b;
        Double double1;
        if (b1.g != null)
        {
            double1 = Double.valueOf(b1.g.doubleValue());
        } else
        {
            double1 = null;
        }
        a1.i = double1;
        if (b1.h != null)
        {
            double1 = Double.valueOf(b1.h.doubleValue());
        } else
        {
            double1 = null;
        }
        a1.j = double1;
        if (location != null)
        {
            double1 = Double.valueOf(location.getLatitude());
        } else
        {
            double1 = null;
        }
        a1.k = double1;
        if (location != null)
        {
            double1 = Double.valueOf(location.getLongitude());
        } else
        {
            double1 = null;
        }
        a1.l = double1;
        double1 = obj;
        if (location != null)
        {
            double1 = Double.valueOf(location.getAccuracy());
        }
        a1.m = double1;
        a1.n = Double.valueOf(i1.e);
        a1.o = b1.f;
        a1.p = Integer.valueOf(i1.a);
        a1.q = super.b;
        h.a(a1.a());
    }

    private static String b(i i1)
    {
        String s;
        try
        {
            s = new String(i1.b, com.mopub.d.a.d.a(i1.c));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return new String(i1.b);
        }
        return s;
    }

    private static String c(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = Uri.parse(s);
        try
        {
            s = s.getQueryParameter("request_id");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.mopub.common.c.a.b("Unable to obtain request id from fail url.");
            return null;
        }
        return s;
    }

    protected final n a(i i1)
    {
        String s = null;
        Map map = i1.c;
        if (e.c(map, j.r))
        {
            return com.mopub.d.n.a(new com.mopub.c.g("Ad Unit is warming up.", g.a.a));
        }
        Location location = k.a(o, com.mopub.common.l.b(), com.mopub.common.l.a());
        b.a a1 = new b.a();
        a1.b = n;
        String s1 = e.a(map, j.b);
        String s2 = e.a(map, j.i);
        a1.a = s1;
        a1.c = s2;
        Object obj = e.b(map, j.p);
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(((Integer) (obj)).intValue() * 1000);
        }
        a1.m = ((Integer) (obj));
        if ("clear".equals(s1))
        {
            a(a1.a(), i1, location);
            return com.mopub.d.n.a(new com.mopub.c.g("No ads found for ad unit.", g.a.b, ((Integer) (obj))));
        }
        a1.d = e.a(map, j.n);
        String s3 = e.a(map, j.l);
        a1.e = s3;
        String s4 = e.a(map, j.c);
        a1.f = s4;
        a1.g = e.a(map, j.k);
        obj = e.a(map, j.h);
        a1.h = ((String) (obj));
        a1.i = c(((String) (obj)));
        boolean flag2 = e.c(map, j.q);
        obj = Boolean.valueOf(flag2);
        Object obj1;
        boolean flag;
        boolean flag1;
        if (obj == null)
        {
            flag1 = a1.o;
        } else
        {
            flag1 = ((Boolean) (obj)).booleanValue();
        }
        a1.o = flag1;
        obj = e.b(map, j.s);
        obj1 = e.b(map, j.j);
        a1.j = ((Integer) (obj));
        a1.k = ((Integer) (obj1));
        obj = e.b(map, j.a);
        if (obj == null)
        {
            obj = s;
        } else
        {
            obj = Integer.valueOf(((Integer) (obj)).intValue() * 1000);
        }
        a1.l = ((Integer) (obj));
        obj1 = b(i1);
        a1.p = ((String) (obj1));
        if ("json".equals(s1))
        {
            try
            {
                a1.q = new JSONObject(((String) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (i i1)
            {
                return com.mopub.d.n.a(new com.mopub.c.g("Failed to decode body JSON for native ad format", i1, com.mopub.c.g.a.d));
            }
        }
        obj = m;
        if ("custom".equalsIgnoreCase(s1))
        {
            obj = e.a(map, j.e);
        } else
        if ("json".equalsIgnoreCase(s1))
        {
            obj = com.mopub.mobileads.d.a.j.toString();
        } else
        if ("html".equalsIgnoreCase(s1) || "mraid".equalsIgnoreCase(s1))
        {
            if (com.mopub.common.a.b.equals(obj))
            {
                obj = com.mopub.mobileads.d.a.a((new StringBuilder()).append(s1).append("_interstitial").toString());
            } else
            {
                obj = com.mopub.mobileads.d.a.a((new StringBuilder()).append(s1).append("_banner").toString());
            }
            obj = ((com.mopub.mobileads.d.a) (obj)).toString();
        } else
        if ("interstitial".equalsIgnoreCase(s1))
        {
            obj = com.mopub.mobileads.d.a.a((new StringBuilder()).append(s2).append("_interstitial").toString()).toString();
        } else
        {
            obj = com.mopub.mobileads.d.a.a((new StringBuilder()).append(s1).append("_banner").toString()).toString();
        }
        a1.r = ((String) (obj));
        s = e.a(map, j.d);
        obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = e.a(map, j.m);
        }
        try
        {
            a1.a(g.a(((String) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (i i1)
        {
            return com.mopub.d.n.a(new com.mopub.c.g("Failed to decode server extras for custom event data.", i1, g.a.c));
        }
        if ("mraid".equals(s1) || "html".equals(s1) || "interstitial".equals(s1) && "vast".equals(s2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = new TreeMap();
            ((Map) (obj)).put("Html-Response-Body", obj1);
            ((Map) (obj)).put("Scrollable", Boolean.toString(flag2));
            ((Map) (obj)).put("com_mopub_orientation", e.a(map, j.o));
            if (s3 != null)
            {
                ((Map) (obj)).put("Redirect-Url", s3);
            }
            if (s4 != null)
            {
                ((Map) (obj)).put("Clickthrough-Url", s4);
            }
            a1.a(((Map) (obj)));
        }
        a(a1.a(), i1, location);
        return com.mopub.d.n.a(a1.a(), com.mopub.d.a.d.a(i1));
    }

    public final Map a()
    {
        TreeMap treemap = new TreeMap();
        String s1 = Locale.getDefault().getLanguage();
        Locale locale = o.getResources().getConfiguration().locale;
        String s = s1;
        if (locale != null)
        {
            s = s1;
            if (!locale.getLanguage().trim().isEmpty())
            {
                s = locale.getLanguage().trim();
            }
        }
        if (!s.isEmpty())
        {
            treemap.put(j.v.x, s);
        }
        return treemap;
    }

    protected final volatile void a(Object obj)
    {
        obj = (b)obj;
        l.a(((b) (obj)));
    }
}

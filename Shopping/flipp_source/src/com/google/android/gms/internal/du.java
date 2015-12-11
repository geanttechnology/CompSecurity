// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            ej, et, cb, bz, 
//            cu, dr, ed, v, 
//            ai, x, ea

public final class du
{

    private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd");

    public static cb a(Context context, bz bz1, String s)
    {
        String s1;
        Object obj;
        String s2;
        Object obj3;
        obj3 = new JSONObject(s);
        s = ((JSONObject) (obj3)).optString("ad_base_url", null);
        obj = ((JSONObject) (obj3)).optString("ad_url", null);
        s2 = ((JSONObject) (obj3)).optString("ad_size", null);
        s1 = ((JSONObject) (obj3)).optString("ad_html", null);
        if (!((JSONObject) (obj3)).has("interstitial_timeout")) goto _L2; else goto _L1
_L1:
        long l = (long)(((JSONObject) (obj3)).getDouble("interstitial_timeout") * 1000D);
_L39:
        Object obj1 = ((JSONObject) (obj3)).optString("orientation", null);
        int i = -1;
        if (!"portrait".equals(obj1)) goto _L4; else goto _L3
_L3:
        i = ej.c();
_L7:
        if (TextUtils.isEmpty(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty(s))
        {
            et.d("Could not parse the mediation config: Missing required ad_base_url field");
            return new cb(0);
        }
          goto _L5
_L4:
        if ("landscape".equals(obj1))
        {
            i = ej.b();
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L9; else goto _L8
_L8:
        obj = dr.a(context, bz1.k.b, ((String) (obj)));
        s = ((cb) (obj)).b;
        s1 = ((cb) (obj)).c;
_L38:
        obj1 = ((JSONObject) (obj3)).optJSONArray("click_urls");
        if (obj != null) goto _L11; else goto _L10
_L10:
        context = null;
_L17:
        if (obj1 == null) goto _L13; else goto _L12
_L16:
        int j;
        if (j >= ((JSONArray) (obj1)).length()) goto _L15; else goto _L14
_L14:
        bz1.add(((JSONArray) (obj1)).getString(j));
        j++;
          goto _L16
_L9:
        et.d("Could not parse the mediation config: Missing required ad_html or ad_url field.");
        context = new cb(0);
        return context;
_L11:
        context = ((cb) (obj)).d;
          goto _L17
_L37:
        Object obj2 = ((JSONObject) (obj3)).optJSONArray("impression_urls");
        if (obj != null) goto _L19; else goto _L18
_L18:
        context = null;
_L27:
        if (obj2 == null) goto _L21; else goto _L20
_L20:
        bz1 = context;
        if (context != null) goto _L23; else goto _L22
_L22:
        bz1 = new LinkedList();
          goto _L23
_L26:
        if (j >= ((JSONArray) (obj2)).length()) goto _L25; else goto _L24
_L24:
        bz1.add(((JSONArray) (obj2)).getString(j));
        j++;
          goto _L26
_L19:
        context = ((cb) (obj)).f;
          goto _L27
_L36:
        obj3 = ((JSONObject) (obj3)).optJSONArray("manual_impression_urls");
        if (obj != null) goto _L29; else goto _L28
_L28:
        context = null;
_L35:
        if (obj3 == null) goto _L31; else goto _L30
_L30:
        bz1 = context;
        if (context != null) goto _L33; else goto _L32
_L32:
        bz1 = new LinkedList();
          goto _L33
_L34:
        if (j >= ((JSONArray) (obj3)).length())
        {
            break MISSING_BLOCK_LABEL_613;
        }
        bz1.add(((JSONArray) (obj3)).getString(j));
        j++;
          goto _L34
_L29:
        context = ((cb) (obj)).j;
          goto _L35
_L31:
        l1 = l;
        j = i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        if (((cb) (obj)).l != -1)
        {
            i = ((cb) (obj)).l;
        }
        l1 = l;
        j = i;
        if (((cb) (obj)).g <= 0L)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        l1 = ((cb) (obj)).g;
        j = i;
        context = new cb(s, s1, ((List) (obj1)), ((List) (obj2)), l1, false, context, -1L, j, s2);
        return context;
_L21:
        obj2 = context;
          goto _L36
_L13:
        obj1 = context;
          goto _L37
_L5:
        obj = null;
          goto _L38
_L2:
        l = -1L;
          goto _L39
_L12:
        bz1 = context;
        long l1;
        if (context == null)
        {
            try
            {
                bz1 = new LinkedList();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                et.d((new StringBuilder("Could not parse the mediation config: ")).append(context.getMessage()).toString());
                return new cb(0);
            }
        }
        j = 0;
          goto _L16
_L15:
        obj1 = bz1;
          goto _L37
_L23:
        j = 0;
          goto _L26
_L25:
        obj2 = bz1;
          goto _L36
_L33:
        j = 0;
          goto _L34
        context = bz1;
          goto _L31
    }

    private static Integer a(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return Integer.valueOf(i);
    }

    private static String a(int i)
    {
        return String.format(Locale.US, "#%06x", new Object[] {
            Integer.valueOf(0xffffff & i)
        });
    }

    public static String a(bz bz1, ea ea1)
    {
        Object obj;
        float f;
        HashMap hashmap;
        Object obj1;
        x ax[];
        x x1;
        int i;
        int j;
        int k;
        long l;
        long l1;
        long l2;
        try
        {
            hashmap = new HashMap();
            if (bz1.b != null)
            {
                hashmap.put("ad_pos", bz1.b);
            }
            obj = bz1.c;
            obj1 = ed.a();
        }
        // Misplaced declaration of an exception variable
        catch (bz bz1)
        {
            et.d((new StringBuilder("Problem serializing ad request to JSON: ")).append(bz1.getMessage()).toString());
            return null;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        hashmap.put("abf", obj1);
        if (((v) (obj)).b != -1L)
        {
            hashmap.put("cust_age", a.format(new Date(((v) (obj)).b)));
        }
        if (((v) (obj)).c != null)
        {
            hashmap.put("extras", ((v) (obj)).c);
        }
        if (((v) (obj)).d != -1)
        {
            hashmap.put("cust_gender", Integer.valueOf(((v) (obj)).d));
        }
        if (((v) (obj)).e != null)
        {
            hashmap.put("kw", ((v) (obj)).e);
        }
        if (((v) (obj)).g != -1)
        {
            hashmap.put("tag_for_child_directed_treatment", Integer.valueOf(((v) (obj)).g));
        }
        if (((v) (obj)).f)
        {
            hashmap.put("adtest", "on");
        }
        if (((v) (obj)).a < 2) goto _L2; else goto _L1
_L1:
        if (((v) (obj)).h)
        {
            hashmap.put("d_imp_hdr", Integer.valueOf(1));
        }
        if (!TextUtils.isEmpty(((v) (obj)).i))
        {
            hashmap.put("ppid", ((v) (obj)).i);
        }
        if (((v) (obj)).j == null) goto _L2; else goto _L3
_L3:
        obj1 = ((v) (obj)).j;
        if (Color.alpha(((ai) (obj1)).b) != 0)
        {
            hashmap.put("acolor", a(((ai) (obj1)).b));
        }
        if (Color.alpha(((ai) (obj1)).c) != 0)
        {
            hashmap.put("bgcolor", a(((ai) (obj1)).c));
        }
        if (Color.alpha(((ai) (obj1)).d) != 0 && Color.alpha(((ai) (obj1)).e) != 0)
        {
            hashmap.put("gradientto", a(((ai) (obj1)).d));
            hashmap.put("gradientfrom", a(((ai) (obj1)).e));
        }
        if (Color.alpha(((ai) (obj1)).f) != 0)
        {
            hashmap.put("bcolor", a(((ai) (obj1)).f));
        }
        hashmap.put("bthick", Integer.toString(((ai) (obj1)).g));
        ((ai) (obj1)).h;
        JVM INSTR tableswitch 0 3: default 1528
    //                   0 1538
    //                   1 1545
    //                   2 1552
    //                   3 1559;
           goto _L4 _L5 _L6 _L7 _L8
_L28:
        if (obj == null) goto _L10; else goto _L9
_L9:
        hashmap.put("btype", obj);
_L10:
        ((ai) (obj1)).i;
        JVM INSTR tableswitch 0 2: default 1533
    //                   0 1573
    //                   1 1580
    //                   2 1566;
           goto _L11 _L12 _L13 _L14
_L29:
        if (obj == null) goto _L16; else goto _L15
_L15:
        hashmap.put("callbuttoncolor", obj);
_L16:
        if (((ai) (obj1)).j != null)
        {
            hashmap.put("channel", ((ai) (obj1)).j);
        }
        if (Color.alpha(((ai) (obj1)).k) != 0)
        {
            hashmap.put("dcolor", a(((ai) (obj1)).k));
        }
        if (((ai) (obj1)).l != null)
        {
            hashmap.put("font", ((ai) (obj1)).l);
        }
        if (Color.alpha(((ai) (obj1)).m) != 0)
        {
            hashmap.put("hcolor", a(((ai) (obj1)).m));
        }
        hashmap.put("headersize", Integer.toString(((ai) (obj1)).n));
        if (((ai) (obj1)).o != null)
        {
            hashmap.put("q", ((ai) (obj1)).o);
        }
_L2:
        hashmap.put("format", bz1.d.b);
        if (bz1.d.f == -1)
        {
            hashmap.put("smart_w", "full");
        }
        if (bz1.d.c == -2)
        {
            hashmap.put("smart_h", "auto");
        }
        if (bz1.d.h == null) goto _L18; else goto _L17
_L17:
        obj = new StringBuilder();
        ax = bz1.d.h;
        k = ax.length;
        i = 0;
_L25:
        if (i >= k) goto _L20; else goto _L19
_L19:
        x1 = ax[i];
        if (((StringBuilder) (obj)).length() != 0)
        {
            ((StringBuilder) (obj)).append("|");
        }
        if (x1.f != -1) goto _L22; else goto _L21
_L21:
        j = (int)((float)x1.g / ea1.q);
_L26:
        ((StringBuilder) (obj)).append(j);
        ((StringBuilder) (obj)).append("x");
        if (x1.c != -2) goto _L24; else goto _L23
_L23:
        j = (int)((float)x1.d / ea1.q);
_L27:
        ((StringBuilder) (obj)).append(j);
        i++;
          goto _L25
_L22:
        j = x1.f;
          goto _L26
_L24:
        j = x1.c;
          goto _L27
_L20:
        hashmap.put("sz", obj);
_L18:
        hashmap.put("slotname", bz1.e);
        hashmap.put("pn", bz1.f.packageName);
        if (bz1.g != null)
        {
            hashmap.put("vc", Integer.valueOf(bz1.g.versionCode));
        }
        hashmap.put("ms", bz1.h);
        hashmap.put("seq_num", bz1.i);
        hashmap.put("session_id", bz1.j);
        hashmap.put("js", bz1.k.b);
        hashmap.put("am", Integer.valueOf(ea1.a));
        hashmap.put("cog", a(ea1.b));
        hashmap.put("coh", a(ea1.c));
        if (!TextUtils.isEmpty(ea1.d))
        {
            hashmap.put("carrier", ea1.d);
        }
        hashmap.put("gl", ea1.e);
        if (ea1.f)
        {
            hashmap.put("simulator", Integer.valueOf(1));
        }
        hashmap.put("ma", a(ea1.g));
        hashmap.put("sp", a(ea1.h));
        hashmap.put("hl", ea1.i);
        if (!TextUtils.isEmpty(ea1.j))
        {
            hashmap.put("mv", ea1.j);
        }
        hashmap.put("muv", Integer.valueOf(ea1.k));
        if (ea1.l != -2)
        {
            hashmap.put("cnt", Integer.valueOf(ea1.l));
        }
        hashmap.put("gnt", Integer.valueOf(ea1.m));
        hashmap.put("pt", Integer.valueOf(ea1.n));
        hashmap.put("rm", Integer.valueOf(ea1.o));
        hashmap.put("riv", Integer.valueOf(ea1.p));
        hashmap.put("u_sd", Float.valueOf(ea1.q));
        hashmap.put("sh", Integer.valueOf(ea1.s));
        hashmap.put("sw", Integer.valueOf(ea1.r));
        if (bz1.c.a >= 2 && bz1.c.k != null)
        {
            bz1 = bz1.c.k;
            ea1 = new HashMap();
            f = bz1.getAccuracy();
            l = bz1.getTime();
            l1 = (long)(bz1.getLatitude() * 10000000D);
            l2 = (long)(bz1.getLongitude() * 10000000D);
            ea1.put("radius", Float.valueOf(f * 1000F));
            ea1.put("lat", Long.valueOf(l1));
            ea1.put("long", Long.valueOf(l2));
            ea1.put("time", Long.valueOf(l * 1000L));
            hashmap.put("uule", ea1);
        }
        if (et.a(2))
        {
            bz1 = ej.a(hashmap).toString(2);
            et.c((new StringBuilder("Ad Request JSON: ")).append(bz1).toString());
        }
        bz1 = ej.a(hashmap).toString();
        return bz1;
_L4:
        obj = null;
          goto _L28
_L11:
        obj = null;
          goto _L29
_L5:
        obj = "none";
          goto _L28
_L6:
        obj = "dashed";
          goto _L28
_L7:
        obj = "dotted";
          goto _L28
_L8:
        obj = "solid";
          goto _L28
_L14:
        obj = "dark";
          goto _L29
_L12:
        obj = "light";
          goto _L29
_L13:
        obj = "medium";
          goto _L29
    }

}

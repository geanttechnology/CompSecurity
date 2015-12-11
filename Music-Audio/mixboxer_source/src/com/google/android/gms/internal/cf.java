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
//            co, ct, cb, bz, 
//            cu, ce, x, ci, 
//            v, ai, cl

public final class cf
{

    private static final SimpleDateFormat hJ = new SimpleDateFormat("yyyyMMdd");

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
        i = co.av();
_L7:
        if (TextUtils.isEmpty(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty(s))
        {
            ct.v("Could not parse the mediation config: Missing required ad_base_url field");
            return new cb(0);
        }
          goto _L5
_L4:
        if ("landscape".equals(obj1))
        {
            i = co.au();
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L9; else goto _L8
_L8:
        obj = ce.a(context, bz1.ej.iJ, ((String) (obj)));
        s = ((cb) (obj)).gL;
        s1 = ((cb) (obj)).hw;
_L38:
        obj1 = ((JSONObject) (obj3)).optJSONArray("click_urls");
        if (obj != null) goto _L11; else goto _L10
_L10:
        context = null;
_L17:
        if (obj1 == null) goto _L13; else goto _L12
_L16:
        int k;
        if (k >= ((JSONArray) (obj1)).length()) goto _L15; else goto _L14
_L14:
        bz1.add(((JSONArray) (obj1)).getString(k));
        k++;
          goto _L16
_L9:
        ct.v("Could not parse the mediation config: Missing required ad_html or ad_url field.");
        context = new cb(0);
        return context;
_L11:
        context = ((cb) (obj)).fK;
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
        if (k >= ((JSONArray) (obj2)).length()) goto _L25; else goto _L24
_L24:
        bz1.add(((JSONArray) (obj2)).getString(k));
        k++;
          goto _L26
_L19:
        context = ((cb) (obj)).fL;
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
        if (k >= ((JSONArray) (obj3)).length())
        {
            break MISSING_BLOCK_LABEL_619;
        }
        bz1.add(((JSONArray) (obj3)).getString(k));
        k++;
          goto _L34
_L29:
        context = ((cb) (obj)).hA;
          goto _L35
_L31:
        l1 = l;
        k = i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_530;
        }
        if (((cb) (obj)).orientation != -1)
        {
            i = ((cb) (obj)).orientation;
        }
        l1 = l;
        k = i;
        if (((cb) (obj)).hx <= 0L)
        {
            break MISSING_BLOCK_LABEL_530;
        }
        l1 = ((cb) (obj)).hx;
        k = i;
        context = new cb(s, s1, ((List) (obj1)), ((List) (obj2)), l1, false, -1L, context, -1L, k, s2);
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
                ct.v((new StringBuilder()).append("Could not parse the mediation config: ").append(context.getMessage()).toString());
                return new cb(0);
            }
        }
        k = 0;
          goto _L16
_L15:
        obj1 = bz1;
          goto _L37
_L23:
        k = 0;
          goto _L26
_L25:
        obj2 = bz1;
          goto _L36
_L33:
        k = 0;
          goto _L34
        context = bz1;
          goto _L31
    }

    public static String a(bz bz1, ci ci1, Location location)
    {
        location = new HashMap();
        if (bz1.hq != null)
        {
            location.put("ad_pos", bz1.hq);
        }
        a(((HashMap) (location)), bz1.hr);
        location.put("format", bz1.em.eF);
        if (bz1.em.width == -1)
        {
            location.put("smart_w", "full");
        }
        if (bz1.em.height == -2)
        {
            location.put("smart_h", "auto");
        }
        if (bz1.em.eH == null) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder;
        x ax[];
        int l;
        stringbuilder = new StringBuilder();
        ax = bz1.em.eH;
        l = ax.length;
        int i = 0;
_L8:
        x x1;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_249;
        }
        x1 = ax[i];
        if (stringbuilder.length() != 0)
        {
            stringbuilder.append("|");
        }
        if (x1.width != -1) goto _L4; else goto _L3
_L3:
        int k = (int)((float)x1.widthPixels / ci1.ip);
_L5:
        stringbuilder.append(k);
        stringbuilder.append("x");
        if (x1.height != -2)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        k = (int)((float)x1.heightPixels / ci1.ip);
_L6:
        stringbuilder.append(k);
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        k = x1.width;
          goto _L5
        k = x1.height;
          goto _L6
        location.put("sz", stringbuilder);
_L2:
        location.put("slotname", bz1.adUnitId);
        location.put("pn", bz1.applicationInfo.packageName);
        if (bz1.hs != null)
        {
            location.put("vc", Integer.valueOf(bz1.hs.versionCode));
        }
        location.put("ms", bz1.ht);
        location.put("seq_num", bz1.hu);
        location.put("session_id", bz1.hv);
        location.put("js", bz1.ej.iJ);
        a(((HashMap) (location)), ci1);
        if (bz1.hr.versionCode >= 2 && bz1.hr.eE != null)
        {
            a(((HashMap) (location)), bz1.hr.eE);
        }
        if (ct.n(2))
        {
            bz1 = co.m(location).toString(2);
            ct.u((new StringBuilder()).append("Ad Request JSON: ").append(bz1).toString());
        }
        bz1 = co.m(location).toString();
        return bz1;
        bz1;
        ct.v((new StringBuilder()).append("Problem serializing ad request to JSON: ").append(bz1.getMessage()).toString());
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static void a(HashMap hashmap, Location location)
    {
        HashMap hashmap1 = new HashMap();
        float f = location.getAccuracy();
        long l = location.getTime();
        long l1 = (long)(location.getLatitude() * 10000000D);
        long l2 = (long)(location.getLongitude() * 10000000D);
        hashmap1.put("radius", Float.valueOf(f * 1000F));
        hashmap1.put("lat", Long.valueOf(l1));
        hashmap1.put("long", Long.valueOf(l2));
        hashmap1.put("time", Long.valueOf(l * 1000L));
        hashmap.put("uule", hashmap1);
    }

    private static void a(HashMap hashmap, ai ai1)
    {
        Object obj;
        obj = null;
        if (Color.alpha(ai1.eZ) != 0)
        {
            hashmap.put("acolor", m(ai1.eZ));
        }
        if (Color.alpha(ai1.backgroundColor) != 0)
        {
            hashmap.put("bgcolor", m(ai1.backgroundColor));
        }
        if (Color.alpha(ai1.fa) != 0 && Color.alpha(ai1.fb) != 0)
        {
            hashmap.put("gradientto", m(ai1.fa));
            hashmap.put("gradientfrom", m(ai1.fb));
        }
        if (Color.alpha(ai1.fc) != 0)
        {
            hashmap.put("bcolor", m(ai1.fc));
        }
        hashmap.put("bthick", Integer.toString(ai1.fd));
        ai1.fe;
        JVM INSTR tableswitch 0 3: default 176
    //                   0 358
    //                   1 365
    //                   2 372
    //                   3 379;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        String s = null;
_L10:
        if (s != null)
        {
            hashmap.put("btype", s);
        }
        ai1.ff;
        JVM INSTR tableswitch 0 2: default 220
    //                   0 393
    //                   1 400
    //                   2 386;
           goto _L6 _L7 _L8 _L9
_L8:
        break MISSING_BLOCK_LABEL_400;
_L6:
        s = obj;
_L11:
        if (s != null)
        {
            hashmap.put("callbuttoncolor", s);
        }
        if (ai1.fg != null)
        {
            hashmap.put("channel", ai1.fg);
        }
        if (Color.alpha(ai1.fh) != 0)
        {
            hashmap.put("dcolor", m(ai1.fh));
        }
        if (ai1.fi != null)
        {
            hashmap.put("font", ai1.fi);
        }
        if (Color.alpha(ai1.fj) != 0)
        {
            hashmap.put("hcolor", m(ai1.fj));
        }
        hashmap.put("headersize", Integer.toString(ai1.fk));
        if (ai1.fl != null)
        {
            hashmap.put("q", ai1.fl);
        }
        return;
_L2:
        s = "none";
          goto _L10
_L3:
        s = "dashed";
          goto _L10
_L4:
        s = "dotted";
          goto _L10
_L5:
        s = "solid";
          goto _L10
_L9:
        s = "dark";
          goto _L11
_L7:
        s = "light";
          goto _L11
        s = "medium";
          goto _L11
    }

    private static void a(HashMap hashmap, ci ci1)
    {
        hashmap.put("am", Integer.valueOf(ci1.hZ));
        hashmap.put("cog", j(ci1.ia));
        hashmap.put("coh", j(ci1.ib));
        if (!TextUtils.isEmpty(ci1.ic))
        {
            hashmap.put("carrier", ci1.ic);
        }
        hashmap.put("gl", ci1.id);
        if (ci1.ie)
        {
            hashmap.put("simulator", Integer.valueOf(1));
        }
        hashmap.put("ma", j(ci1._fldif));
        hashmap.put("sp", j(ci1.ig));
        hashmap.put("hl", ci1.ih);
        if (!TextUtils.isEmpty(ci1.ii))
        {
            hashmap.put("mv", ci1.ii);
        }
        hashmap.put("muv", Integer.valueOf(ci1.ij));
        if (ci1.ik != -2)
        {
            hashmap.put("cnt", Integer.valueOf(ci1.ik));
        }
        hashmap.put("gnt", Integer.valueOf(ci1.il));
        hashmap.put("pt", Integer.valueOf(ci1.im));
        hashmap.put("rm", Integer.valueOf(ci1.in));
        hashmap.put("riv", Integer.valueOf(ci1.io));
        hashmap.put("u_sd", Float.valueOf(ci1.ip));
        hashmap.put("sh", Integer.valueOf(ci1.ir));
        hashmap.put("sw", Integer.valueOf(ci1.iq));
    }

    private static void a(HashMap hashmap, v v1)
    {
        String s = cl.as();
        if (s != null)
        {
            hashmap.put("abf", s);
        }
        if (v1.ex != -1L)
        {
            hashmap.put("cust_age", hJ.format(new Date(v1.ex)));
        }
        if (v1.extras != null)
        {
            hashmap.put("extras", v1.extras);
        }
        if (v1.ey != -1)
        {
            hashmap.put("cust_gender", Integer.valueOf(v1.ey));
        }
        if (v1.ez != null)
        {
            hashmap.put("kw", v1.ez);
        }
        if (v1.tagForChildDirectedTreatment != -1)
        {
            hashmap.put("tag_for_child_directed_treatment", Integer.valueOf(v1.tagForChildDirectedTreatment));
        }
        if (v1.eA)
        {
            hashmap.put("adtest", "on");
        }
        if (v1.versionCode >= 2)
        {
            if (v1.eB)
            {
                hashmap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(v1.eC))
            {
                hashmap.put("ppid", v1.eC);
            }
            if (v1.eD != null)
            {
                a(hashmap, v1.eD);
            }
        }
    }

    private static Integer j(boolean flag)
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

    private static String m(int i)
    {
        return String.format(Locale.US, "#%06x", new Object[] {
            Integer.valueOf(0xffffff & i)
        });
    }

}

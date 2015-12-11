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
//            cv, da, cf, cd, 
//            db, ci, ab, cm, 
//            z, am, cs

public final class cj
{

    private static final SimpleDateFormat ow = new SimpleDateFormat("yyyyMMdd");

    public static cf a(Context context, cd cd1, String s)
    {
        String s1;
        Object obj;
        String s2;
        Object obj4;
        int i;
        int k;
        long l;
        long l1;
        Object obj1;
        try
        {
            obj4 = new JSONObject(s);
            s = ((JSONObject) (obj4)).optString("ad_base_url", null);
            obj = ((JSONObject) (obj4)).optString("ad_url", null);
            s2 = ((JSONObject) (obj4)).optString("ad_size", null);
            s1 = ((JSONObject) (obj4)).optString("ad_html", null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            da.w((new StringBuilder()).append("Could not parse the mediation config: ").append(context.getMessage()).toString());
            return new cf(0);
        }
        l1 = -1L;
        if (!((JSONObject) (obj4)).has("interstitial_timeout")) goto _L2; else goto _L1
_L1:
        l = (long)(((JSONObject) (obj4)).getDouble("interstitial_timeout") * 1000D);
_L41:
        obj1 = ((JSONObject) (obj4)).optString("orientation", null);
        i = -1;
        if (!"portrait".equals(obj1)) goto _L4; else goto _L3
_L3:
        i = cv.aU();
_L7:
        if (TextUtils.isEmpty(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty(s))
        {
            da.w("Could not parse the mediation config: Missing required ad_base_url field");
            return new cf(0);
        }
          goto _L5
_L4:
        if ("landscape".equals(obj1))
        {
            i = cv.aT();
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L9; else goto _L8
_L8:
        obj = ci.a(context, cd1.kN.pU, ((String) (obj)));
        s = ((cf) (obj)).nw;
        s1 = ((cf) (obj)).oi;
        l1 = ((cf) (obj)).oo;
_L40:
        obj1 = ((JSONObject) (obj4)).optJSONArray("click_urls");
        if (obj != null) goto _L11; else goto _L10
_L10:
        context = null;
_L19:
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        cd1 = context;
        if (context != null) goto _L15; else goto _L14
_L14:
        cd1 = new LinkedList();
          goto _L15
_L18:
        if (k >= ((JSONArray) (obj1)).length()) goto _L17; else goto _L16
_L16:
        cd1.add(((JSONArray) (obj1)).getString(k));
        k++;
          goto _L18
_L9:
        da.w("Could not parse the mediation config: Missing required ad_html or ad_url field.");
        context = new cf(0);
        return context;
_L11:
        context = ((cf) (obj)).mt;
          goto _L19
_L39:
        Object obj3 = ((JSONObject) (obj4)).optJSONArray("impression_urls");
        if (obj != null) goto _L21; else goto _L20
_L20:
        context = null;
_L29:
        if (obj3 == null) goto _L23; else goto _L22
_L22:
        cd1 = context;
        if (context != null) goto _L25; else goto _L24
_L24:
        cd1 = new LinkedList();
          goto _L25
_L28:
        if (k >= ((JSONArray) (obj3)).length()) goto _L27; else goto _L26
_L26:
        cd1.add(((JSONArray) (obj3)).getString(k));
        k++;
          goto _L28
_L21:
        context = ((cf) (obj)).mu;
          goto _L29
_L38:
        obj4 = ((JSONObject) (obj4)).optJSONArray("manual_impression_urls");
        if (obj != null) goto _L31; else goto _L30
_L30:
        context = null;
_L37:
        if (obj4 == null) goto _L33; else goto _L32
_L32:
        cd1 = context;
        if (context != null) goto _L35; else goto _L34
_L34:
        cd1 = new LinkedList();
          goto _L35
_L36:
        if (k >= ((JSONArray) (obj4)).length())
        {
            break MISSING_BLOCK_LABEL_633;
        }
        cd1.add(((JSONArray) (obj4)).getString(k));
        k++;
          goto _L36
_L31:
        context = ((cf) (obj)).om;
          goto _L37
_L33:
        long l2;
        l2 = l;
        k = i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        if (((cf) (obj)).orientation != -1)
        {
            i = ((cf) (obj)).orientation;
        }
        l2 = l;
        k = i;
        if (((cf) (obj)).oj <= 0L)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        l2 = ((cf) (obj)).oj;
        k = i;
        Object obj2;
        context = new cf(s, s1, ((List) (obj2)), ((List) (obj3)), l2, false, -1L, context, -1L, k, s2, l1);
        return context;
_L23:
        obj3 = context;
          goto _L38
_L13:
        obj2 = context;
          goto _L39
_L5:
        obj = null;
          goto _L40
_L2:
        l = -1L;
          goto _L41
_L15:
        k = 0;
          goto _L18
_L17:
        obj2 = cd1;
          goto _L39
_L25:
        k = 0;
          goto _L28
_L27:
        obj3 = cd1;
          goto _L38
_L35:
        k = 0;
          goto _L36
        context = cd1;
          goto _L33
    }

    public static String a(cd cd1, cm cm1, Location location)
    {
        location = new HashMap();
        if (cd1.ob != null)
        {
            location.put("ad_pos", cd1.ob);
        }
        a(((HashMap) (location)), cd1.oc);
        location.put("format", cd1.kQ.ln);
        if (cd1.kQ.width == -1)
        {
            location.put("smart_w", "full");
        }
        if (cd1.kQ.height == -2)
        {
            location.put("smart_h", "auto");
        }
        if (cd1.kQ.lp == null) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder;
        ab aab[];
        int l;
        stringbuilder = new StringBuilder();
        aab = cd1.kQ.lp;
        l = aab.length;
        int i = 0;
_L8:
        ab ab1;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_249;
        }
        ab1 = aab[i];
        if (stringbuilder.length() != 0)
        {
            stringbuilder.append("|");
        }
        if (ab1.width != -1) goto _L4; else goto _L3
_L3:
        int k = (int)((float)ab1.widthPixels / cm1.pc);
_L5:
        stringbuilder.append(k);
        stringbuilder.append("x");
        if (ab1.height != -2)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        k = (int)((float)ab1.heightPixels / cm1.pc);
_L6:
        stringbuilder.append(k);
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        k = ab1.width;
          goto _L5
        k = ab1.height;
          goto _L6
        location.put("sz", stringbuilder);
_L2:
        location.put("slotname", cd1.adUnitId);
        location.put("pn", cd1.applicationInfo.packageName);
        if (cd1.od != null)
        {
            location.put("vc", Integer.valueOf(cd1.od.versionCode));
        }
        location.put("ms", cd1.oe);
        location.put("seq_num", cd1.of);
        location.put("session_id", cd1.og);
        location.put("js", cd1.kN.pU);
        a(((HashMap) (location)), cm1);
        if (cd1.oc.versionCode >= 2 && cd1.oc.ll != null)
        {
            a(((HashMap) (location)), cd1.oc.ll);
        }
        if (cd1.versionCode >= 2)
        {
            location.put("quality_signals", cd1.oh);
        }
        if (da.n(2))
        {
            cd1 = cv.m(location).toString(2);
            da.v((new StringBuilder()).append("Ad Request JSON: ").append(cd1).toString());
        }
        cd1 = cv.m(location).toString();
        return cd1;
        cd1;
        da.w((new StringBuilder()).append("Problem serializing ad request to JSON: ").append(cd1.getMessage()).toString());
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

    private static void a(HashMap hashmap, am am1)
    {
        Object obj;
        obj = null;
        if (Color.alpha(am1.lI) != 0)
        {
            hashmap.put("acolor", m(am1.lI));
        }
        if (Color.alpha(am1.backgroundColor) != 0)
        {
            hashmap.put("bgcolor", m(am1.backgroundColor));
        }
        if (Color.alpha(am1.lJ) != 0 && Color.alpha(am1.lK) != 0)
        {
            hashmap.put("gradientto", m(am1.lJ));
            hashmap.put("gradientfrom", m(am1.lK));
        }
        if (Color.alpha(am1.lL) != 0)
        {
            hashmap.put("bcolor", m(am1.lL));
        }
        hashmap.put("bthick", Integer.toString(am1.lM));
        am1.lN;
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
        am1.lO;
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
        if (am1.lP != null)
        {
            hashmap.put("channel", am1.lP);
        }
        if (Color.alpha(am1.lQ) != 0)
        {
            hashmap.put("dcolor", m(am1.lQ));
        }
        if (am1.lR != null)
        {
            hashmap.put("font", am1.lR);
        }
        if (Color.alpha(am1.lS) != 0)
        {
            hashmap.put("hcolor", m(am1.lS));
        }
        hashmap.put("headersize", Integer.toString(am1.lT));
        if (am1.lU != null)
        {
            hashmap.put("q", am1.lU);
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

    private static void a(HashMap hashmap, cm cm1)
    {
        hashmap.put("am", Integer.valueOf(cm1.oM));
        hashmap.put("cog", j(cm1.oN));
        hashmap.put("coh", j(cm1.oO));
        if (!TextUtils.isEmpty(cm1.oP))
        {
            hashmap.put("carrier", cm1.oP);
        }
        hashmap.put("gl", cm1.oQ);
        if (cm1.oR)
        {
            hashmap.put("simulator", Integer.valueOf(1));
        }
        hashmap.put("ma", j(cm1.oS));
        hashmap.put("sp", j(cm1.oT));
        hashmap.put("hl", cm1.oU);
        if (!TextUtils.isEmpty(cm1.oV))
        {
            hashmap.put("mv", cm1.oV);
        }
        hashmap.put("muv", Integer.valueOf(cm1.oW));
        if (cm1.oX != -2)
        {
            hashmap.put("cnt", Integer.valueOf(cm1.oX));
        }
        hashmap.put("gnt", Integer.valueOf(cm1.oY));
        hashmap.put("pt", Integer.valueOf(cm1.oZ));
        hashmap.put("rm", Integer.valueOf(cm1.pa));
        hashmap.put("riv", Integer.valueOf(cm1.pb));
        hashmap.put("u_sd", Float.valueOf(cm1.pc));
        hashmap.put("sh", Integer.valueOf(cm1.pe));
        hashmap.put("sw", Integer.valueOf(cm1.pd));
    }

    private static void a(HashMap hashmap, z z1)
    {
        String s = cs.aR();
        if (s != null)
        {
            hashmap.put("abf", s);
        }
        if (z1.le != -1L)
        {
            hashmap.put("cust_age", ow.format(new Date(z1.le)));
        }
        if (z1.extras != null)
        {
            hashmap.put("extras", z1.extras);
        }
        if (z1.lf != -1)
        {
            hashmap.put("cust_gender", Integer.valueOf(z1.lf));
        }
        if (z1.lg != null)
        {
            hashmap.put("kw", z1.lg);
        }
        if (z1.tagForChildDirectedTreatment != -1)
        {
            hashmap.put("tag_for_child_directed_treatment", Integer.valueOf(z1.tagForChildDirectedTreatment));
        }
        if (z1.lh)
        {
            hashmap.put("adtest", "on");
        }
        if (z1.versionCode >= 2)
        {
            if (z1.li)
            {
                hashmap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(z1.lj))
            {
                hashmap.put("ppid", z1.lj);
            }
            if (z1.lk != null)
            {
                a(hashmap, z1.lk);
            }
        }
        if (z1.versionCode >= 3 && z1.lm != null)
        {
            hashmap.put("url", z1.lm);
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

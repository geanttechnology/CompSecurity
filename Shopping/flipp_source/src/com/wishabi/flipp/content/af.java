// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.util.Pair;
import b.a.a.d.a;
import b.a.a.d.aa;
import b.a.a.d.d;
import b.a.a.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.content:
//            ag, ah

public final class af
{

    private static final d A = b.a.a.d.a.a();
    public static final d a = aa.a();
    public static final d b;
    private static final i z;
    private long B;
    private String C;
    private String D;
    private ag E;
    private String F;
    private String G;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public final List v = new ArrayList();
    public final List w = new ArrayList();
    public final List x = new ArrayList();
    public boolean y;

    public af()
    {
    }

    public static af a(JSONObject jsonobject)
    {
        af af1;
        af1 = new af();
        af1.B = jsonobject.getLong("id");
        af1.c = jsonobject.getInt("flyer_id");
        if (!jsonobject.isNull("brand")) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L57:
        af1.C = ((String) (obj));
        if (!jsonobject.isNull("merchant")) goto _L4; else goto _L3
_L3:
        obj = null;
_L58:
        af1.d = ((String) (obj));
        if (!jsonobject.isNull("merchant_logo")) goto _L6; else goto _L5
_L5:
        obj = null;
_L59:
        af1.e = ((String) (obj));
        if (!jsonobject.isNull("name")) goto _L8; else goto _L7
_L7:
        obj = null;
_L60:
        af1.f = ((String) (obj));
        if (!jsonobject.isNull("short_name")) goto _L10; else goto _L9
_L9:
        obj = null;
_L61:
        af1.D = ((String) (obj));
        if (!jsonobject.isNull("image_url")) goto _L12; else goto _L11
_L11:
        obj = null;
_L62:
        af1.g = ((String) (obj));
        if (!jsonobject.isNull("cutout_image_url")) goto _L14; else goto _L13
_L13:
        obj = null;
_L63:
        af1.h = ((String) (obj));
        if (!jsonobject.isNull("description")) goto _L16; else goto _L15
_L15:
        obj = null;
_L64:
        af1.i = ((String) (obj));
        af1.E = com.wishabi.flipp.content.ag.a(jsonobject.getInt("display_type"));
        if (!jsonobject.isNull("current_price")) goto _L18; else goto _L17
_L17:
        obj = null;
_L65:
        af1.j = ((String) (obj));
        if (!jsonobject.isNull("pre_price_text")) goto _L20; else goto _L19
_L19:
        obj = null;
_L66:
        af1.k = ((String) (obj));
        if (!jsonobject.isNull("category")) goto _L22; else goto _L21
_L21:
        obj = null;
_L67:
        af1.F = ((String) (obj));
        if (!jsonobject.isNull("price_text")) goto _L24; else goto _L23
_L23:
        obj = null;
_L68:
        af1.l = ((String) (obj));
        if (!jsonobject.isNull("sale_story")) goto _L26; else goto _L25
_L25:
        obj = null;
_L69:
        af1.m = ((String) (obj));
        if (!jsonobject.isNull("original_price")) goto _L28; else goto _L27
_L27:
        obj = null;
_L70:
        af1.n = ((String) (obj));
        Object obj1;
        Object obj2;
        Object obj3;
        int i1;
        int j1;
        boolean flag;
        if (!jsonobject.isNull("in_store_only") && jsonobject.getBoolean("in_store_only"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        af1.o = flag;
        if (!jsonobject.isNull("disclaimer_text")) goto _L30; else goto _L29
_L29:
        obj = null;
_L71:
        af1.G = ((String) (obj));
        if (!jsonobject.isNull("valid_to")) goto _L32; else goto _L31
_L31:
        obj = null;
_L72:
        af1.p = ((String) (obj));
        if (!jsonobject.isNull("valid_from")) goto _L34; else goto _L33
_L33:
        obj = null;
_L73:
        af1.q = ((String) (obj));
        if (!jsonobject.isNull("sku")) goto _L36; else goto _L35
_L35:
        obj = null;
_L74:
        af1.r = ((String) (obj));
        if (!jsonobject.isNull("ttm_url")) goto _L38; else goto _L37
_L37:
        obj = null;
_L75:
        af1.s = ((String) (obj));
        if (!jsonobject.isNull("ttm_label")) goto _L40; else goto _L39
_L39:
        obj = null;
_L76:
        af1.t = ((String) (obj));
        if (!jsonobject.isNull("review_average_rating")) goto _L42; else goto _L41
_L41:
        obj = null;
_L77:
        af1.u = ((String) (obj));
        af1.y = jsonobject.optBoolean("show_details");
        obj1 = jsonobject.optJSONArray("review_samples");
        if (obj1 == null) goto _L44; else goto _L43
_L43:
        j1 = ((JSONArray) (obj1)).length();
        i1 = 0;
_L56:
        if (i1 >= j1) goto _L44; else goto _L45
_L45:
        obj3 = ((JSONArray) (obj1)).getJSONObject(i1);
        obj2 = new ah();
        if (!((JSONObject) (obj3)).isNull("title")) goto _L47; else goto _L46
_L46:
        obj = null;
_L78:
        obj2.a = ((String) (obj));
        if (!((JSONObject) (obj3)).isNull("rating")) goto _L49; else goto _L48
_L48:
        obj = null;
_L79:
        obj2.b = ((String) (obj));
        if (!((JSONObject) (obj3)).isNull("byline")) goto _L51; else goto _L50
_L50:
        obj = null;
_L80:
        obj2.c = ((String) (obj));
        if (!((JSONObject) (obj3)).isNull("date")) goto _L53; else goto _L52
_L52:
        obj = null;
_L81:
        obj2.d = ((String) (obj));
        if (!((JSONObject) (obj3)).isNull("body")) goto _L55; else goto _L54
_L54:
        obj = null;
_L82:
        obj2.e = ((String) (obj));
        af1.v.add(obj2);
        i1++;
          goto _L56
_L2:
        obj = jsonobject.getString("brand");
          goto _L57
_L4:
        obj = jsonobject.getString("merchant");
          goto _L58
_L6:
        obj = jsonobject.getString("merchant_logo");
          goto _L59
_L8:
        obj = jsonobject.getString("name");
          goto _L60
_L10:
        obj = jsonobject.getString("short_name");
          goto _L61
_L12:
        obj = jsonobject.getString("image_url");
          goto _L62
_L14:
        obj = jsonobject.getString("cutout_image_url");
          goto _L63
_L16:
        obj = jsonobject.getString("description");
          goto _L64
_L18:
        obj = jsonobject.getString("current_price");
          goto _L65
_L20:
        obj = jsonobject.getString("pre_price_text");
          goto _L66
_L22:
        obj = jsonobject.getString("category");
          goto _L67
_L24:
        obj = jsonobject.getString("price_text");
          goto _L68
_L26:
        obj = jsonobject.getString("sale_story");
          goto _L69
_L28:
        obj = jsonobject.getString("original_price");
          goto _L70
_L30:
        obj = jsonobject.getString("disclaimer_text");
          goto _L71
_L32:
        obj = jsonobject.getString("valid_to");
          goto _L72
_L34:
        obj = jsonobject.getString("valid_from");
          goto _L73
_L36:
        obj = jsonobject.getString("sku");
          goto _L74
_L38:
        obj = jsonobject.getString("ttm_url");
          goto _L75
_L40:
        obj = jsonobject.getString("ttm_label");
          goto _L76
_L42:
        obj = jsonobject.getString("review_average_rating");
          goto _L77
_L47:
        obj = ((JSONObject) (obj3)).getString("title");
          goto _L78
_L49:
        obj = ((JSONObject) (obj3)).getString("rating");
          goto _L79
_L51:
        obj = ((JSONObject) (obj3)).getString("byline");
          goto _L80
_L53:
        obj = ((JSONObject) (obj3)).getString("date");
          goto _L81
_L55:
        obj = ((JSONObject) (obj3)).getString("body");
          goto _L82
_L44:
        obj2 = jsonobject.optJSONArray("specs");
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_959;
        }
        j1 = ((JSONArray) (obj2)).length();
        i1 = 0;
_L85:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_959;
        }
        obj1 = ((JSONArray) (obj2)).getJSONObject(i1);
        obj3 = af1.w;
        if (!((JSONObject) (obj1)).isNull("name")) goto _L84; else goto _L83
_L83:
        obj = null;
_L86:
        if (!((JSONObject) (obj1)).isNull("value"))
        {
            break MISSING_BLOCK_LABEL_948;
        }
        obj1 = null;
_L87:
        ((List) (obj3)).add(new Pair(obj, obj1));
        i1++;
          goto _L85
_L84:
        obj = ((JSONObject) (obj1)).getString("name");
          goto _L86
        obj1 = ((JSONObject) (obj1)).getString("value");
          goto _L87
        obj = jsonobject.getJSONArray("features");
        jsonobject = af1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1046;
        }
        j1 = ((JSONArray) (obj)).length();
        i1 = 0;
_L88:
        jsonobject = af1;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_1046;
        }
        jsonobject = ((JSONArray) (obj)).getJSONObject(i1);
        obj1 = af1.x;
        if (!jsonobject.isNull("text"))
        {
            break MISSING_BLOCK_LABEL_1032;
        }
        jsonobject = null;
_L89:
        ((List) (obj1)).add(jsonobject);
        i1++;
          goto _L88
        jsonobject = jsonobject.getString("text");
          goto _L89
        jsonobject;
        jsonobject = null;
        return jsonobject;
          goto _L56
    }

    public static d b()
    {
        return a;
    }

    public static d c()
    {
        return A;
    }

    public final String a()
    {
        return String.format("https://share.flipp.com/flipp/items/%d/share?locale=%s", new Object[] {
            Long.valueOf(B), Locale.getDefault().toString()
        });
    }

    static 
    {
        z = b.a.a.i.a(TimeZone.getTimeZone("America/Toronto"));
        b = b.a.a.d.a.a("MMM dd, yyyy").a(z);
    }
}

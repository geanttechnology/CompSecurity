// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.pf.common.utility.m;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class an
{

    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    String o;

    public an()
    {
    }

    public static an a(String s)
    {
        an an1 = new an();
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.a.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.a = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.b.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.b = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.c.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.c = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.d.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.d = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.e.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.e = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.f.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.f = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.g.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.g = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.h.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.h = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.i.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.i = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.j.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.j = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.k.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.k = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.l.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.l = s;
        s = jsonobject.optString(com.cyberlink.youcammakeup.utility.PanelDataCenter.LocaleEnum.m.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.m = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.n.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.n = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.o.name());
        if (s.equals(""))
        {
            s = null;
        }
        an1.o = s;
        return an1;
        s;
        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("[convert Description From JSON]").append(s.toString()).toString());
        return an1;
        s;
        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("[convert Description From JSON]").append(s.toString()).toString());
        return an1;
    }

    public static String a(an an1)
    {
        String s = Locale.getDefault().getLanguage();
        String s1 = s.split("_")[0];
        if (s1.equals("en") && an1.a != null)
        {
            return an1.a;
        }
        if (s.equals("zh_TW") && an1.b != null)
        {
            return an1.b;
        }
        if (s.equals("zh_CN") && an1.c != null)
        {
            return an1.c;
        }
        if (s1.equals("zh"))
        {
            if (Locale.getDefault().getCountry().equals("CN") && an1.c != null)
            {
                return an1.c;
            }
            if (an1.b != null)
            {
                return an1.b;
            }
        }
        if (s1.equals("ja") && an1.d != null)
        {
            return an1.d;
        }
        if (s1.equals("ko") && an1.e != null)
        {
            return an1.e;
        }
        if (s1.equals("de") && an1.f != null)
        {
            return an1.f;
        }
        if (s1.equals("es") && an1.g != null)
        {
            return an1.g;
        }
        if (s1.equals("fr") && an1.h != null)
        {
            return an1.h;
        }
        if (s1.equals("it") && an1.i != null)
        {
            return an1.i;
        }
        if (s1.equals("pl") && an1.j != null)
        {
            return an1.j;
        }
        if (s.equals("pt_BR") && an1.l != null)
        {
            return an1.l;
        }
        if (s.equals("pt_PT") && an1.k != null)
        {
            return an1.k;
        }
        if (s1.equals("ru") && an1.m != null)
        {
            return an1.m;
        }
        if (s1.equals("ru") && an1.m != null)
        {
            return an1.m;
        }
        if (s1.equals("nl") && an1.n != null)
        {
            return an1.n;
        } else
        {
            return an1.o;
        }
    }

    public static JSONObject b(an an1)
    {
        JSONObject jsonobject = new JSONObject();
        String s1 = PanelDataCenter.LocaleEnum.a.name();
        if (an1.a == null) goto _L2; else goto _L1
_L1:
        String s = an1.a;
_L28:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.b.name();
        if (an1.b == null) goto _L4; else goto _L3
_L3:
        s = an1.b;
_L29:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.c.name();
        if (an1.c == null) goto _L6; else goto _L5
_L5:
        s = an1.c;
_L30:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.d.name();
        if (an1.d == null) goto _L8; else goto _L7
_L7:
        s = an1.d;
_L31:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.e.name();
        if (an1.e == null) goto _L10; else goto _L9
_L9:
        s = an1.e;
_L32:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.f.name();
        if (an1.f == null) goto _L12; else goto _L11
_L11:
        s = an1.f;
_L33:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.g.name();
        if (an1.g == null) goto _L14; else goto _L13
_L13:
        s = an1.g;
_L34:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.h.name();
        if (an1.h == null) goto _L16; else goto _L15
_L15:
        s = an1.h;
_L35:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.i.name();
        if (an1.i == null) goto _L18; else goto _L17
_L17:
        s = an1.i;
_L36:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.j.name();
        if (an1.j == null) goto _L20; else goto _L19
_L19:
        s = an1.j;
_L37:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.k.name();
        if (an1.k == null) goto _L22; else goto _L21
_L21:
        s = an1.k;
_L38:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.l.name();
        if (an1.l == null) goto _L24; else goto _L23
_L23:
        s = an1.l;
_L39:
        jsonobject.put(s1, s);
        s1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.LocaleEnum.m.name();
        if (an1.m == null)
        {
            break MISSING_BLOCK_LABEL_514;
        }
        s = an1.m;
_L40:
        jsonobject.put(s1, s);
        s = PanelDataCenter.LocaleEnum.o.name();
        if (an1.o == null) goto _L26; else goto _L25
_L25:
        an1 = an1.o;
_L27:
        jsonobject.put(s, an1);
        return jsonobject;
_L26:
        an1 = "";
          goto _L27
        an1;
        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("[convert Description to JSON]").append(an1.toString()).toString());
        return jsonobject;
        an1;
        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("[convert Description to JSON]").append(an1.toString()).toString());
        return jsonobject;
_L2:
        s = "";
          goto _L28
_L4:
        s = "";
          goto _L29
_L6:
        s = "";
          goto _L30
_L8:
        s = "";
          goto _L31
_L10:
        s = "";
          goto _L32
_L12:
        s = "";
          goto _L33
_L14:
        s = "";
          goto _L34
_L16:
        s = "";
          goto _L35
_L18:
        s = "";
          goto _L36
_L20:
        s = "";
          goto _L37
_L22:
        s = "";
          goto _L38
_L24:
        s = "";
          goto _L39
        s = "";
          goto _L40
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.pf.common.utility.m;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class av
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

    public av()
    {
    }

    public static av a(String s)
    {
        av av1 = new av();
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.a.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.a = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.b.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.b = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.c.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.c = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.d.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.d = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.e.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.e = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.f.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.f = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.g.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.g = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.h.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.h = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.i.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.i = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.j.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.j = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.k.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.k = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.l.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.l = s;
        s = jsonobject.optString(com.cyberlink.youcammakeup.utility.PanelDataCenter.LocaleEnum.m.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.m = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.n.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.n = s;
        s = jsonobject.optString(PanelDataCenter.LocaleEnum.o.name());
        if (s.equals(""))
        {
            s = null;
        }
        av1.o = s;
        return av1;
        s;
        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("[convert Name From JSON]").append(s.toString()).toString());
        return av1;
        s;
        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("[convert Name From JSON]").append(s.toString()).toString());
        return av1;
    }

    public static av a(Node node)
    {
        av av1 = new av();
        if (node != null)
        {
            node = (Element)node;
            av1.b = a(node.getElementsByTagName("cht"));
            av1.c = a(node.getElementsByTagName("chs"));
            av1.a = a(node.getElementsByTagName("enu"));
            av1.d = a(node.getElementsByTagName("jpn"));
            av1.e = a(node.getElementsByTagName("kor"));
            av1.f = a(node.getElementsByTagName("deu"));
            av1.g = a(node.getElementsByTagName("esp"));
            av1.h = a(node.getElementsByTagName("fra"));
            av1.i = a(node.getElementsByTagName("ita"));
            av1.j = a(node.getElementsByTagName("plk"));
            av1.k = a(node.getElementsByTagName("ptg"));
            av1.l = a(node.getElementsByTagName("ptb"));
            av1.m = a(node.getElementsByTagName("rus"));
            av1.n = a(node.getElementsByTagName("nld"));
            av1.o = a(node.getElementsByTagName("def"));
        }
        return av1;
    }

    public static String a(av av1)
    {
        String s = Locale.getDefault().getLanguage();
        String s1 = s.split("_")[0];
        if (s1.equals("en") && av1.a != null)
        {
            return av1.a;
        }
        if (s.equals("zh_TW") && av1.b != null)
        {
            return av1.b;
        }
        if (s.equals("zh_CN") && av1.c != null)
        {
            return av1.c;
        }
        if (s1.equals("zh"))
        {
            if (Locale.getDefault().getCountry().equals("CN") && av1.c != null)
            {
                return av1.c;
            }
            if (av1.b != null)
            {
                return av1.b;
            }
        }
        if (s1.equals("ja") && av1.d != null)
        {
            return av1.d;
        }
        if (s1.equals("ko") && av1.e != null)
        {
            return av1.e;
        }
        if (s1.equals("de") && av1.f != null)
        {
            return av1.f;
        }
        if (s1.equals("es") && av1.g != null)
        {
            return av1.g;
        }
        if (s1.equals("fr") && av1.h != null)
        {
            return av1.h;
        }
        if (s1.equals("it") && av1.i != null)
        {
            return av1.i;
        }
        if (s1.equals("pl") && av1.j != null)
        {
            return av1.j;
        }
        if (s.equals("pt_BR") && av1.l != null)
        {
            return av1.l;
        }
        if (s.equals("pt_PT") && av1.k != null)
        {
            return av1.k;
        }
        if (s1.equals("ru") && av1.m != null)
        {
            return av1.m;
        }
        if (s1.equals("ru") && av1.m != null)
        {
            return av1.m;
        }
        if (s1.equals("nl") && av1.n != null)
        {
            return av1.n;
        } else
        {
            return av1.o;
        }
    }

    private static String a(NodeList nodelist)
    {
        String s1 = "";
        String s = s1;
        if (nodelist != null)
        {
            s = s1;
            if (nodelist.item(0) != null)
            {
                nodelist = nodelist.item(0).getChildNodes();
                s = s1;
                if (nodelist != null)
                {
                    s = s1;
                    if (nodelist.item(0) != null)
                    {
                        s = nodelist.item(0).getNodeValue().trim();
                    }
                }
            }
        }
        return s;
    }

    public static JSONObject b(av av1)
    {
        JSONObject jsonobject = new JSONObject();
        String s1 = PanelDataCenter.LocaleEnum.a.name();
        if (av1.a == null) goto _L2; else goto _L1
_L1:
        String s = av1.a;
_L28:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.b.name();
        if (av1.b == null) goto _L4; else goto _L3
_L3:
        s = av1.b;
_L29:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.c.name();
        if (av1.c == null) goto _L6; else goto _L5
_L5:
        s = av1.c;
_L30:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.d.name();
        if (av1.d == null) goto _L8; else goto _L7
_L7:
        s = av1.d;
_L31:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.e.name();
        if (av1.e == null) goto _L10; else goto _L9
_L9:
        s = av1.e;
_L32:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.f.name();
        if (av1.f == null) goto _L12; else goto _L11
_L11:
        s = av1.f;
_L33:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.g.name();
        if (av1.g == null) goto _L14; else goto _L13
_L13:
        s = av1.g;
_L34:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.h.name();
        if (av1.h == null) goto _L16; else goto _L15
_L15:
        s = av1.h;
_L35:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.i.name();
        if (av1.i == null) goto _L18; else goto _L17
_L17:
        s = av1.i;
_L36:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.j.name();
        if (av1.j == null) goto _L20; else goto _L19
_L19:
        s = av1.j;
_L37:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.k.name();
        if (av1.k == null) goto _L22; else goto _L21
_L21:
        s = av1.k;
_L38:
        jsonobject.put(s1, s);
        s1 = PanelDataCenter.LocaleEnum.l.name();
        if (av1.l == null) goto _L24; else goto _L23
_L23:
        s = av1.l;
_L39:
        jsonobject.put(s1, s);
        s1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.LocaleEnum.m.name();
        if (av1.m == null)
        {
            break MISSING_BLOCK_LABEL_514;
        }
        s = av1.m;
_L40:
        jsonobject.put(s1, s);
        s = PanelDataCenter.LocaleEnum.o.name();
        if (av1.o == null) goto _L26; else goto _L25
_L25:
        av1 = av1.o;
_L27:
        jsonobject.put(s, av1);
        return jsonobject;
_L26:
        av1 = "";
          goto _L27
        av1;
        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("[convert Name to JSON]").append(av1.toString()).toString());
        return jsonobject;
        av1;
        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("[convert Name to JSON]").append(av1.toString()).toString());
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

    public void b(String s)
    {
        o = s;
    }
}

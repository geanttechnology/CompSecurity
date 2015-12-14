// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.pf.common.utility.m;
import org.json.JSONException;
import org.json.JSONObject;

class au
{

    static int f = -1;
    static int g = 8;
    int a;
    int b;
    boolean c;
    int d;
    int e[];

    au()
    {
        e = null;
    }

    static String a(String s)
    {
        if (s == null)
        {
            m.b("PanelDataCenter", "formatEngineColorString(), Info. engineColorString is null");
            return "";
        }
        if (s.isEmpty())
        {
            return "";
        }
        s = s.split(",");
        int ai[] = new int[g];
        int i = 0;
        while (i < g) 
        {
            if (i < s.length)
            {
                if (s[i] == null || s[i].isEmpty())
                {
                    ai[i] = f;
                } else
                {
                    ai[i] = Integer.parseInt(s[i]);
                }
            } else
            {
                ai[i] = f;
            }
            i++;
        }
        return a(ai);
    }

    static String a(int ai[])
    {
        if (ai == null)
        {
            m.e("PanelDataCenter", "formatEngineColorString(), Info. engineColor is null");
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < g; i++)
        {
            if (i < ai.length && ai[i] != f)
            {
                stringbuilder.append(ai[i]);
            }
            if (i != ai.length - 1)
            {
                stringbuilder.append(",");
            }
        }

        if (stringbuilder.toString().equals(",,,,,,,"))
        {
            return "";
        } else
        {
            return stringbuilder.toString();
        }
    }

    static JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("level_max", "");
            jsonobject.put("level_default", "");
            jsonobject.put("is_shimmer", "");
            jsonobject.put("shimmer_intensity", "");
            jsonobject.put("engine_color", "");
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    static JSONObject a(int i, int j, boolean flag, int k, String s)
    {
        String s2 = a(s);
        String s1;
        if (i > 0)
        {
            s = String.valueOf(i);
        } else
        {
            s = "";
        }
        if (j > 0)
        {
            s1 = String.valueOf(j);
        } else
        {
            s1 = "";
        }
        return a(s, s1, String.valueOf(flag), String.valueOf(k), s2);
    }

    static JSONObject a(String s, String s1, String s2, String s3, String s4)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("level_max", s);
            jsonobject.put("level_default", s1);
            jsonobject.put("is_shimmer", s2);
            jsonobject.put("shimmer_intensity", s3);
            jsonobject.put("engine_color", s4);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    static int[] b(String s)
    {
        if (a(s) == null)
        {
            m.e("PanelDataCenter", "getEngineColors(), Info. formatedEngineColorString is null");
            return null;
        }
        s = s.split(",");
        int ai[] = new int[g];
        int i = 0;
        while (i < g) 
        {
            if (i < s.length)
            {
                if (s[i] == null || s[i].isEmpty())
                {
                    ai[i] = f;
                } else
                {
                    ai[i] = Integer.parseInt(s[i]);
                }
            } else
            {
                ai[i] = f;
            }
            i++;
        }
        return ai;
    }

}

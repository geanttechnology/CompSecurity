// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.d;

import android.content.ContentValues;
import com.pf.common.utility.m;
import org.json.JSONObject;

public class a
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private String h;
    private String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;

    public a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10)
    {
        h = "";
        i = "";
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
        j = s7;
        k = s8;
        l = s9;
        m = s10;
        try
        {
            s = new JSONObject(g);
            h = s.getString("intensity");
            i = s.getString("hidden_intensity");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.pf.common.utility.m.e("EffectInfo", s.toString());
        }
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public String e()
    {
        return e;
    }

    public String f()
    {
        return f;
    }

    public String g()
    {
        return g;
    }

    public String h()
    {
        return h;
    }

    public String i()
    {
        return i;
    }

    public String j()
    {
        return l;
    }

    public String k()
    {
        return j;
    }

    public String l()
    {
        return k;
    }

    public ContentValues m()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("GUID", a);
        contentvalues.put("PresetGUID", b);
        contentvalues.put("PatternGUID", c);
        contentvalues.put("EffectType", d);
        contentvalues.put("ColorCount", e);
        contentvalues.put("ColorSetGUID", f);
        contentvalues.put("Intensity", g);
        contentvalues.put("ListOrder", j);
        contentvalues.put("ExtraData", k);
        contentvalues.put("Ext_1", l);
        contentvalues.put("Ext_2", m);
        return contentvalues;
    }
}

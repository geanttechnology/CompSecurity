// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import org.json.JSONException;
import org.json.JSONObject;

public class n
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public n()
    {
        this("", "", "_", "", "_", "", "_");
    }

    public n(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
    }

    public n(JSONObject jsonobject)
    {
        try
        {
            a = jsonobject.getString("zip");
            b = jsonobject.getString("cover");
            c = jsonobject.getString("coverLocalFilePath");
            d = jsonobject.getString("thumbnail");
            e = jsonobject.getString("thumbnailLocalFilePath");
            f = jsonobject.getString("preview");
            g = jsonobject.getString("previewLocalFilePath");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
    }

    public static n a(String s)
    {
        if (s != null && !s.isEmpty())
        {
            if ((s = s.split(",")).length == 7)
            {
                return new n(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
            }
        }
        return null;
    }

    public String a()
    {
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("zip", a);
            ((JSONObject) (obj)).put("cover", b);
            ((JSONObject) (obj)).put("coverLocalFilePath", c);
            ((JSONObject) (obj)).put("thumbnail", d);
            ((JSONObject) (obj)).put("thumbnailLocalFilePath", e);
            ((JSONObject) (obj)).put("preview", f);
            ((JSONObject) (obj)).put("previewLocalFilePath", g);
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return "";
        }
        return ((String) (obj));
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append(",").append(b).append(",").append(c).append(",").append(d).append(",").append(e).append(",").append(f).append(",").append(g).toString();
    }
}

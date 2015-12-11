// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.e;

import java.util.ArrayList;
import net.hockeyapp.android.c.b;
import net.hockeyapp.android.c.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{

    private c()
    {
    }

    c(byte byte0)
    {
        this();
    }

    public static d a(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        b b1;
        JSONObject jsonobject1;
        JSONArray jsonarray;
        jsonobject = new JSONObject(s);
        jsonobject1 = jsonobject.getJSONObject("feedback");
        b1 = new b();
        jsonarray = jsonobject1.getJSONArray("messages");
        s = null;
        if (jsonarray.length() <= 0) goto _L4; else goto _L3
_L3:
        ArrayList arraylist = new ArrayList();
        int i = 0;
_L5:
        s = arraylist;
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s = jsonarray.getJSONObject(i).getString("subject").toString();
        String s1 = jsonarray.getJSONObject(i).getString("text").toString();
        String s2 = jsonarray.getJSONObject(i).getString("oem").toString();
        String s3 = jsonarray.getJSONObject(i).getString("model").toString();
        String s4 = jsonarray.getJSONObject(i).getString("os_version").toString();
        String s5 = jsonarray.getJSONObject(i).getString("created_at").toString();
        int j = jsonarray.getJSONObject(i).getInt("id");
        String s6 = jsonarray.getJSONObject(i).getString("token").toString();
        int k = jsonarray.getJSONObject(i).getInt("via");
        String s7 = jsonarray.getJSONObject(i).getString("user_string").toString();
        String s8 = jsonarray.getJSONObject(i).getString("clean_text").toString();
        String s9 = jsonarray.getJSONObject(i).getString("name").toString();
        String s10 = jsonarray.getJSONObject(i).getString("app_id").toString();
        net.hockeyapp.android.c.c c1 = new net.hockeyapp.android.c.c();
        c1.m = s10;
        c1.k = s8;
        c1.f = s5;
        c1.g = j;
        c1.d = s3;
        c1.l = s9;
        c1.c = s2;
        c1.e = s4;
        c1.a = s;
        c1.b = s1;
        c1.h = s6;
        c1.j = s7;
        c1.i = k;
        arraylist.add(c1);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        b1.e = s;
        b1.a = jsonobject1.getString("name").toString();
_L6:
        b1.b = jsonobject1.getString("email").toString();
_L7:
        b1.c = jsonobject1.getInt("id");
_L8:
        b1.d = jsonobject1.getString("created_at").toString();
_L9:
        s = new d();
        s.b = b1;
        s.a = jsonobject.getString("status").toString();
_L10:
        s.c = jsonobject.getString("token").toString();
        return s;
        s;
        s.printStackTrace();
          goto _L6
        JSONException jsonexception;
        jsonexception;
        s = null;
_L11:
        jsonexception.printStackTrace();
        return s;
        s;
        s.printStackTrace();
          goto _L7
        s;
        s.printStackTrace();
          goto _L8
        s;
        s.printStackTrace();
          goto _L9
        jsonexception;
        jsonexception.printStackTrace();
          goto _L10
        jsonexception;
        jsonexception.printStackTrace();
        return s;
_L2:
        return null;
        jsonexception;
          goto _L11
    }
}

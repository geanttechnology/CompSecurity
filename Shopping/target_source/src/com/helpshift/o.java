// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.util.Log;
import com.helpshift.i.h;
import java.text.DecimalFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{

    public static String a;
    private static JSONArray b = new JSONArray();

    public static JSONArray a()
    {
        JSONArray jsonarray = b;
        b();
        return jsonarray;
    }

    public static void a(String s)
    {
        a(s, null);
    }

    public static void a(String s, JSONObject jsonobject)
    {
        JSONObject jsonobject1 = new JSONObject();
        try
        {
            jsonobject1.put("ts", h.f.format((double)System.currentTimeMillis() / 1000D));
            jsonobject1.put("t", s);
            jsonobject1.put("d", jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("HelpShiftDebug", "JSONException", s);
        }
        b.put(jsonobject1);
    }

    public static void b()
    {
        b = new JSONArray();
        a = Long.toString((new Date()).getTime());
    }

    public static void b(String s)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("type", "periodic");
            jsonobject.put("response", s);
            a("r", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("HelpShiftDebug", "JSONException", s);
        }
    }

}

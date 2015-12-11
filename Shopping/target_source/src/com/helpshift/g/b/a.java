// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.g.b;

import android.util.Log;
import com.helpshift.s;
import com.helpshift.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{

    public static Map a;
    public static Map b;

    public static void a(JSONObject jsonobject)
        throws JSONException
    {
        a.put("title", jsonobject.getString("title"));
        a.put("sp", jsonobject.getString("sp"));
        a.put("hc", jsonobject.getString("hc"));
        a.put("tc", jsonobject.getString("tc"));
        a.put("hl", jsonobject.getString("hl"));
        (new s(v.a())).Y();
    }

    public static void b(JSONObject jsonobject)
    {
        b.put("rurl", jsonobject.optString("rurl", ""));
        b.put("bcl", Integer.valueOf(jsonobject.optInt("bcl", 10)));
        b.put("dbgl", Integer.valueOf(jsonobject.optInt("dbgl", 25)));
        b.put("pr", jsonobject.optJSONObject("pr"));
        b.put("pfe", Boolean.valueOf(jsonobject.optBoolean("pfe", true)));
        b.put("rne", Boolean.valueOf(jsonobject.optBoolean("rne", false)));
        b.put("dia", Boolean.valueOf(jsonobject.optBoolean("dia", false)));
        b.put("csat", Boolean.valueOf(jsonobject.optBoolean("csat", false)));
        b.put("san", Boolean.valueOf(jsonobject.optBoolean("san", true)));
        try
        {
            if (jsonobject.has("t"))
            {
                a(jsonobject.getJSONObject("t"));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.d("HelpShiftDebug", jsonobject.toString(), jsonobject);
        }
    }

    static 
    {
        a = new HashMap();
        a.put("title", "Help");
        a.put("sp", "Describe your problem");
        a.put("hc", "516B90");
        a.put("tc", "535353");
        a.put("hl", "true");
        b = new HashMap();
        b.put("bcl", Integer.valueOf(10));
        b.put("dbgl", Integer.valueOf(0));
        b.put("rurl", "");
        b.put("t", a);
        b.put("pfe", Boolean.valueOf(true));
        b.put("pr", null);
        b.put("rne", Boolean.valueOf(false));
        b.put("dia", Boolean.valueOf(false));
        b.put("csat", Boolean.valueOf(false));
        b.put("san", Boolean.valueOf(true));
    }
}

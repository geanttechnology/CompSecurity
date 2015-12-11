// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.util.Log;
import com.helpshift.f.a;
import com.helpshift.f.b;
import com.helpshift.f.c;
import com.helpshift.f.d;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q
{

    private static a a(String s, JSONObject jsonobject)
        throws JSONException
    {
        return (new b(s, jsonobject.getString("id"), jsonobject.getString("body"), jsonobject.getString("title"), jsonobject.getString("created_at"), jsonobject.getString("updated_at"), jsonobject.getInt("status"), jsonobject.optBoolean("show-agent-name", true))).a(a(jsonobject.getJSONArray("messages"))).a();
    }

    private static c a(JSONObject jsonobject)
        throws JSONException
    {
        String s = jsonobject.getString("issue_id");
        String s1 = jsonobject.getString("id");
        String s2 = jsonobject.getString("body");
        String s3 = jsonobject.getString("origin");
        String s4 = jsonobject.getString("type");
        String s5 = jsonobject.getString("created_at");
        Object obj = jsonobject.getJSONObject("author");
        Object obj1;
        if (!(obj instanceof JSONObject))
        {
            obj = ((JSONObject) (obj)).toString();
        } else
        {
            obj = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        obj1 = jsonobject.getJSONObject("meta");
        if (!(obj1 instanceof JSONObject))
        {
            obj1 = ((JSONObject) (obj1)).toString();
        } else
        {
            obj1 = JSONObjectInstrumentation.toString((JSONObject)obj1);
        }
        return (new d(s, s1, s2, s3, s4, s5, ((String) (obj)), ((String) (obj1)))).a(jsonobject.optString("screenshot")).a(jsonobject.optBoolean("seen")).b(jsonobject.optBoolean("invisible")).c(jsonobject.optBoolean("inProgress")).a();
    }

    public static List a(String s, JSONArray jsonarray)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L2:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(a(s, jsonarray.getJSONObject(i)));
        i++;
        if (true) goto _L2; else goto _L1
        s;
        Log.d("HelpShiftDebug", "storeMessages", s);
_L1:
        return arraylist;
    }

    public static List a(JSONArray jsonarray)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L2:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(a(jsonarray.getJSONObject(i)));
        i++;
        if (true) goto _L2; else goto _L1
        jsonarray;
        Log.d("HelpShiftDebug", "storeMessages", jsonarray);
_L1:
        return arraylist;
    }

    public static JSONArray a(List list)
    {
        JSONArray jsonarray = new JSONArray();
        list = list.iterator();
        while (list.hasNext()) 
        {
            c c1 = (c)list.next();
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("issue_id", c1.a());
                jsonobject.put("id", c1.b());
                jsonobject.put("body", c1.c());
                jsonobject.put("origin", c1.d());
                jsonobject.put("type", c1.e());
                jsonobject.put("created_at", c1.f());
                jsonobject.put("author", JSONObjectInstrumentation.init(c1.g()));
                jsonobject.put("meta", JSONObjectInstrumentation.init(c1.h()));
                jsonobject.put("screenshot", c1.i());
                jsonobject.put("seen", c1.j());
                jsonobject.put("invisible", c1.k());
                jsonobject.put("inProgress", c1.l());
            }
            catch (JSONException jsonexception)
            {
                Log.d("HelpShiftDebug", "messageListToJSONArray", jsonexception);
            }
            jsonarray.put(jsonobject);
        }
        return jsonarray;
    }
}

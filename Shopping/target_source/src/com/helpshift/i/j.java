// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{

    public static ArrayList a(String s)
    {
        ArrayList arraylist = new ArrayList();
        int k;
        s = JSONArrayInstrumentation.init(s);
        k = s.length();
        int i = 0;
_L2:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(s.getString(i));
        i++;
        if (true) goto _L2; else goto _L1
        s;
        Log.d("HelpShiftDebug", "jsonToStringArrayList", s);
_L1:
        return arraylist;
    }

    public static String[] a(JSONObject jsonobject)
    {
        jsonobject = jsonobject.keys();
        ArrayList arraylist = new ArrayList();
        for (; jsonobject != null && jsonobject.hasNext(); arraylist.add((String)jsonobject.next())) { }
        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }

    public static HashMap b(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            try
            {
                if (jsonobject.get(s) instanceof String)
                {
                    hashmap.put(s, jsonobject.getString(s));
                }
            }
            catch (JSONException jsonexception)
            {
                Log.d("HelpShiftDebug", "JsonException ", jsonexception);
            }
        } while (true);
        return hashmap;
    }
}

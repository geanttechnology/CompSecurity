// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{

    public static ArrayList a(JSONArray jsonarray)
    {
        if (jsonarray == null)
        {
            return null;
        }
        ArrayList arraylist;
        int k;
        if (jsonarray.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        k = jsonarray.length();
        arraylist = new ArrayList(k);
        int j = 0;
_L2:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add((String)jsonarray.get(j));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
        jsonarray;
_L4:
        return null;
        jsonarray;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static HashMap a(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        HashMap hashmap;
        try
        {
            Iterator iterator = jsonobject.keys();
            hashmap = new HashMap();
            String s;
            for (; iterator.hasNext(); hashmap.put(s, jsonobject.getString(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        return hashmap;
    }

    public static JSONArray a(JSONObject jsonobject, String s)
    {
        if (jsonobject != null)
        {
            int j;
            try
            {
                jsonobject = jsonobject.getJSONArray(s);
                j = jsonobject.length();
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return null;
            }
            if (j > 0)
            {
                return jsonobject;
            }
        }
        return null;
    }

    public static JSONObject a(JSONArray jsonarray, int j)
    {
        if (jsonarray == null)
        {
            return null;
        }
        try
        {
            jsonarray = jsonarray.getJSONObject(j);
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            return null;
        }
        return jsonarray;
    }

    public static JSONObject b(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return null;
        }
        try
        {
            jsonobject = jsonobject.getJSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        return jsonobject;
    }

    public static String c(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return null;
        }
        try
        {
            jsonobject = jsonobject.getString(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        return jsonobject;
    }

    public static int d(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return -1;
        }
        int j;
        try
        {
            j = jsonobject.getInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return -1;
        }
        return j;
    }

    public static double e(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return -1D;
        }
        double d1;
        try
        {
            d1 = jsonobject.getDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return -1D;
        }
        return d1;
    }
}

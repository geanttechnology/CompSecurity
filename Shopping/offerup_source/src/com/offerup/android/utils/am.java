// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import com.b.a.a.g;
import com.leanplum.Leanplum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class am
{

    public am()
    {
    }

    private static List a(JSONArray jsonarray)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L6:
        Object obj1;
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj1 = jsonarray.get(i);
        if (!(obj1 instanceof JSONArray)) goto _L2; else goto _L1
_L1:
        Object obj = a((JSONArray)obj1);
_L4:
        arraylist.add(obj);
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        obj = obj1;
        if (!(obj1 instanceof JSONObject)) goto _L4; else goto _L3
_L3:
        obj = a((JSONObject)obj1);
          goto _L4
        return arraylist;
        jsonarray;
        return null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static Map a(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = jsonobject.keys();
_L2:
        Object obj;
        Object obj1;
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = (String)iterator.next();
        obj1 = jsonobject.get(s);
        if (!(obj1 instanceof JSONArray))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = a((JSONArray)obj1);
_L4:
        hashmap.put(s, obj);
        if (true) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (!(obj1 instanceof JSONObject)) goto _L4; else goto _L3
_L3:
        obj = a((JSONObject)obj1);
          goto _L4
        return hashmap;
        jsonobject;
        return null;
    }

    public static void a(String s)
    {
        Leanplum.track(s);
    }

    public static void a(String s, JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        if (jsonobject != JSONObject.NULL)
        {
            try
            {
                jsonobject = a(jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                g.c(com/offerup/android/utils/am.getSimpleName(), "Unable to convert JSONObject to HashMap");
                jsonobject = hashmap;
            }
            if (jsonobject != null)
            {
                Leanplum.track(s, jsonobject);
            }
        }
    }
}

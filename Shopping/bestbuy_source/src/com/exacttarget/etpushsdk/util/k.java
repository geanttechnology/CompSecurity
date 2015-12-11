// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class k
{

    private static Object a(Object obj)
    {
        Object obj1;
        if (obj == JSONObject.NULL)
        {
            obj1 = null;
        } else
        {
            if (obj instanceof JSONObject)
            {
                return a((JSONObject)obj);
            }
            obj1 = obj;
            if (obj instanceof JSONArray)
            {
                return a((JSONArray)obj);
            }
        }
        return obj1;
    }

    public static List a(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(a(jsonarray.get(i)));
        }

        return arraylist;
    }

    public static Map a(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, a(jsonobject.get(s))))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }
}

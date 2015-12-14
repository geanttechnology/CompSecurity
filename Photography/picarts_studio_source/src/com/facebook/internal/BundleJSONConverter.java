// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter
{

    private static final Map SETTERS;

    public BundleJSONConverter()
    {
    }

    public static Bundle convertToBundle(JSONObject jsonobject)
    {
        Bundle bundle = new Bundle();
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = jsonobject.get(s);
            if (obj != null && obj != JSONObject.NULL)
            {
                if (obj instanceof JSONObject)
                {
                    bundle.putBundle(s, convertToBundle((JSONObject)obj));
                } else
                {
                    Setter setter = (Setter)SETTERS.get(obj.getClass());
                    if (setter == null)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Unsupported type: ")).append(obj.getClass()).toString());
                    }
                    setter.setOnBundle(bundle, s, obj);
                }
            }
        } while (true);
        return bundle;
    }

    public static JSONObject convertToJSON(Bundle bundle)
    {
        JSONObject jsonobject = new JSONObject();
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            if (obj != null)
            {
                if (obj instanceof List)
                {
                    JSONArray jsonarray = new JSONArray();
                    for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); jsonarray.put((String)((Iterator) (obj)).next())) { }
                    jsonobject.put(s, jsonarray);
                } else
                if (obj instanceof Bundle)
                {
                    jsonobject.put(s, convertToJSON((Bundle)obj));
                } else
                {
                    Setter setter = (Setter)SETTERS.get(obj.getClass());
                    if (setter == null)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Unsupported type: ")).append(obj.getClass()).toString());
                    }
                    setter.setOnJSON(jsonobject, s, obj);
                }
            }
        } while (true);
        return jsonobject;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        SETTERS = hashmap;
        hashmap.put(java/lang/Boolean, new _cls1());
        SETTERS.put(java/lang/Integer, new _cls2());
        SETTERS.put(java/lang/Long, new _cls3());
        SETTERS.put(java/lang/Double, new _cls4());
        SETTERS.put(java/lang/String, new _cls5());
        SETTERS.put([Ljava/lang/String;, new _cls6());
        SETTERS.put(org/json/JSONArray, new _cls7());
    }

    /* member class not found */
    class Setter {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}

}

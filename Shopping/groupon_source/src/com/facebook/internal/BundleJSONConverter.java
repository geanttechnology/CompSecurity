// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleJSONConverter
{
    public static interface Setter
    {

        public abstract void setOnBundle(Bundle bundle, String s, Object obj)
            throws JSONException;
    }


    private static final Map SETTERS;

    public static Bundle convertToBundle(JSONObject jsonobject)
        throws JSONException
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
                        throw new IllegalArgumentException((new StringBuilder()).append("Unsupported type: ").append(obj.getClass()).toString());
                    }
                    setter.setOnBundle(bundle, s, obj);
                }
            }
        } while (true);
        return bundle;
    }

    static 
    {
        SETTERS = new HashMap();
        SETTERS.put(java/lang/Boolean, new Setter() {

            public void setOnBundle(Bundle bundle, String s, Object obj)
                throws JSONException
            {
                bundle.putBoolean(s, ((Boolean)obj).booleanValue());
            }

        });
        SETTERS.put(java/lang/Integer, new Setter() {

            public void setOnBundle(Bundle bundle, String s, Object obj)
                throws JSONException
            {
                bundle.putInt(s, ((Integer)obj).intValue());
            }

        });
        SETTERS.put(java/lang/Long, new Setter() {

            public void setOnBundle(Bundle bundle, String s, Object obj)
                throws JSONException
            {
                bundle.putLong(s, ((Long)obj).longValue());
            }

        });
        SETTERS.put(java/lang/Double, new Setter() {

            public void setOnBundle(Bundle bundle, String s, Object obj)
                throws JSONException
            {
                bundle.putDouble(s, ((Double)obj).doubleValue());
            }

        });
        SETTERS.put(java/lang/String, new Setter() {

            public void setOnBundle(Bundle bundle, String s, Object obj)
                throws JSONException
            {
                bundle.putString(s, (String)obj);
            }

        });
        SETTERS.put([Ljava/lang/String;, new Setter() {

            public void setOnBundle(Bundle bundle, String s, Object obj)
                throws JSONException
            {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

        });
        SETTERS.put(org/json/JSONArray, new Setter() {

            public void setOnBundle(Bundle bundle, String s, Object obj)
                throws JSONException
            {
                obj = (JSONArray)obj;
                ArrayList arraylist = new ArrayList();
                if (((JSONArray) (obj)).length() == 0)
                {
                    bundle.putStringArrayList(s, arraylist);
                    return;
                }
                for (int i = 0; i < ((JSONArray) (obj)).length();)
                {
                    Object obj1 = ((JSONArray) (obj)).get(i);
                    if (obj1 instanceof String)
                    {
                        arraylist.add((String)obj1);
                        i++;
                    } else
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Unexpected type in an array: ").append(obj1.getClass()).toString());
                    }
                }

                bundle.putStringArrayList(s, arraylist);
            }

        });
    }
}

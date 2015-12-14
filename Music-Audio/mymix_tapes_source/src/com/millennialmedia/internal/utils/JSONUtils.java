// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import com.millennialmedia.MMLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils
{

    private static final String TAG = com/millennialmedia/internal/utils/JSONUtils.getName();

    public JSONUtils()
    {
    }

    public static JSONArray buildFromList(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        JSONArray jsonarray = new JSONArray();
        Iterator iterator = list.iterator();
        do
        {
            list = jsonarray;
            if (!iterator.hasNext())
            {
                continue;
            }
            jsonarray.put(buildFromObject(iterator.next()));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static JSONObject buildFromMap(Map map)
    {
        if (map != null) goto _L2; else goto _L1
_L1:
        map = null;
_L4:
        return map;
_L2:
        JSONObject jsonobject = new JSONObject();
        Iterator iterator;
        try
        {
            iterator = map.entrySet().iterator();
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            MMLog.e(TAG, "Error building JSON from Map");
            return jsonobject;
        }
        map = jsonobject;
        if (iterator.hasNext())
        {
            map = (java.util.Map.Entry)iterator.next();
            jsonobject.put((String)map.getKey(), buildFromObject(map.getValue()));
            break MISSING_BLOCK_LABEL_28;
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Object buildFromObject(Object obj)
    {
        Object obj1;
        if (obj instanceof Map)
        {
            obj1 = buildFromMap((Map)obj);
        } else
        {
            obj1 = obj;
            if (obj instanceof List)
            {
                return buildFromList((List)obj);
            }
        }
        return obj1;
    }

    public static String[] convertToStringArray(JSONArray jsonarray)
        throws JSONException
    {
        if (jsonarray != null) goto _L2; else goto _L1
_L1:
        String as[] = new String[0];
_L4:
        return as;
_L2:
        String as1[] = new String[jsonarray.length()];
        int i = 0;
        do
        {
            as = as1;
            if (i >= jsonarray.length())
            {
                continue;
            }
            as1[i] = jsonarray.getString(i);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String[] getStringArray(JSONObject jsonobject, String s)
        throws JSONException
    {
        if (jsonobject != null)
        {
            return convertToStringArray(jsonobject.getJSONArray(s));
        } else
        {
            return new String[0];
        }
    }

}

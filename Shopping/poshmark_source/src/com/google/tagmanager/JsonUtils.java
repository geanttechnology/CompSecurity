// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.tagmanager:
//            ConstantMacro, Types

class JsonUtils
{

    private JsonUtils()
    {
    }

    public static ResourceUtil.ExpandedResource expandedResourceFromJsonString(String s)
        throws JSONException
    {
        s = jsonObjectToValue(JSONObjectInstrumentation.init(s));
        ResourceUtil.ExpandedResourceBuilder expandedresourcebuilder = ResourceUtil.ExpandedResource.newBuilder();
        for (int i = 0; i < s.getMapKeyCount(); i++)
        {
            expandedresourcebuilder.addMacro(ResourceUtil.ExpandedFunctionCall.newBuilder().addProperty(Key.INSTANCE_NAME.toString(), s.getMapKey(i)).addProperty(Key.FUNCTION.toString(), Types.functionIdToValue(ConstantMacro.getFunctionId())).addProperty(ConstantMacro.getValueKey(), s.getMapValue(i)).build());
        }

        return expandedresourcebuilder.build();
    }

    static Object jsonObjectToObject(Object obj)
        throws JSONException
    {
        if (obj instanceof JSONArray)
        {
            throw new RuntimeException("JSONArrays are not supported");
        }
        if (JSONObject.NULL.equals(obj))
        {
            throw new RuntimeException("JSON nulls are not supported");
        }
        if (obj instanceof JSONObject)
        {
            JSONObject jsonobject = (JSONObject)obj;
            HashMap hashmap = new HashMap();
            Iterator iterator = jsonobject.keys();
            do
            {
                obj = hashmap;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (String)iterator.next();
                hashmap.put(obj, jsonObjectToObject(jsonobject.get(((String) (obj)))));
            } while (true);
        }
        return obj;
    }

    private static com.google.analytics.midtier.proto.containertag.TypeSystem.Value jsonObjectToValue(Object obj)
        throws JSONException
    {
        return Types.objectToValue(jsonObjectToObject(obj));
    }
}

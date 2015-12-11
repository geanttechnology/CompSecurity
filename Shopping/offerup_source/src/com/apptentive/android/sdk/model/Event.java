// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.model;

import com.apptentive.android.sdk.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.model:
//            ConversationItem, ExtendedData

public class Event extends ConversationItem
{

    private static final String KEY_CUSTOM_DATA = "custom_data";
    private static final String KEY_DATA = "data";
    private static final String KEY_INTERACTION_ID = "interaction_id";
    private static final String KEY_LABEL = "label";
    private static final String KEY_TRIGGER = "trigger";

    public Event(String s)
    {
        super(s);
    }

    public Event(String s, String s1)
    {
        this(s, ((Map) (null)));
        s = new HashMap();
        s.put("trigger", s1);
        putData(s);
    }

    public transient Event(String s, String s1, String s2, Map map, ExtendedData aextendeddata[])
    {
        put("label", s);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        put("interaction_id", s1);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        put("data", new JSONObject(s2));
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (!map.isEmpty())
        {
            put("custom_data", generateCustomDataJson(map));
        }
        if (aextendeddata == null) goto _L2; else goto _L1
_L1:
        if (aextendeddata.length == 0) goto _L2; else goto _L3
_L3:
        int j = aextendeddata.length;
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = aextendeddata[i];
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        put(s.getTypeName(), s);
        i++;
        if (true) goto _L4; else goto _L2
        s;
        Log.e("Unable to construct Event.", s, new Object[0]);
_L2:
    }

    public Event(String s, Map map)
    {
        put("label", s);
label0:
        {
            if (map != null)
            {
                try
                {
                    if (!map.isEmpty())
                    {
                        s = new JSONObject();
                        String s1;
                        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); s.put(s1, map.get(s1)))
                        {
                            s1 = (String)iterator.next();
                        }

                        break label0;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Log.e("Unable to construct Event.", s, new Object[0]);
                }
            }
            return;
        }
        put("data", s);
        return;
    }

    public Event(String s, JSONObject jsonobject)
    {
        try
        {
            put("label", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Unable to construct Event.", s, new Object[0]);
            return;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        put("data", jsonobject);
    }

    private JSONObject generateCustomDataJson(Map map)
    {
        JSONObject jsonobject = new JSONObject();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = map.get(s);
            if (obj != null)
            {
                try
                {
                    jsonobject.put(s, obj);
                }
                catch (Exception exception)
                {
                    Log.w("Error adding custom data to Event: \"%s\" = \"%s\"", new Object[] {
                        s, obj.toString(), exception
                    });
                }
            }
        } while (true);
        return jsonobject;
    }

    protected void initBaseType()
    {
        setBaseType(Payload.BaseType.event);
    }

    public void putData(Map map)
    {
        if (map != null && !map.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONObject jsonobject;
        if (!isNull("data"))
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = new JSONObject();
        put("data", jsonobject);
_L4:
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            jsonobject.put(s, map.get(s));
        }
        if (true) goto _L1; else goto _L3
_L3:
        try
        {
            jsonobject = getJSONObject("data");
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.e("Unable to add data to Event.", map, new Object[0]);
            return;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }
}

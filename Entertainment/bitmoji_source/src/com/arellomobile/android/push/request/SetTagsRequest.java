// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import com.arellomobile.android.push.PushManager;
import com.arellomobile.android.push.utils.JsonUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class SetTagsRequest extends PushRequest
{

    private JSONArray skippedTags;
    private Map tags;

    public SetTagsRequest(Map map)
    {
        tags = map;
    }

    private JSONObject jsonObjectFromTagMap(Map map)
        throws JSONException
    {
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = map.get(s);
            if (obj instanceof String)
            {
                obj = (String)obj;
                if (((String) (obj)).startsWith("#pwinc#"))
                {
                    map.put(s, PushManager.incrementalTag(Integer.valueOf(Integer.parseInt(((String) (obj)).substring(7)))));
                }
            }
        } while (true);
        return JsonUtils.mapToJson(map);
    }

    protected void buildParams(Context context, Map map)
        throws JSONException
    {
        map.put("tags", jsonObjectFromTagMap(tags));
    }

    public String getMethod()
    {
        return "setTags";
    }

    public JSONArray getSkippedTags()
    {
        return skippedTags;
    }

    public void parseResponse(JSONObject jsonobject)
        throws JSONException
    {
        try
        {
            skippedTags = jsonobject.getJSONObject("response").getJSONArray("skipped");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            skippedTags = new JSONArray();
        }
        throw jsonobject;
    }
}

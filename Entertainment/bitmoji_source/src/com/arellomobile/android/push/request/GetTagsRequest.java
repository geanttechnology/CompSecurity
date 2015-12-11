// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class GetTagsRequest extends PushRequest
{

    private Map tags;

    public GetTagsRequest()
    {
    }

    public String getMethod()
    {
        return "getTags";
    }

    public Map getTags()
    {
        return tags;
    }

    public void parseResponse(JSONObject jsonobject)
        throws JSONException
    {
        HashMap hashmap;
        try
        {
            hashmap = new HashMap();
            jsonobject = jsonobject.getJSONObject("response").getJSONObject("result");
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, jsonobject.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            tags = new HashMap();
            throw jsonobject;
        }
        tags = hashmap;
        return;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand, PointerEncoder

class ParseRESTPushCommand extends ParseRESTCommand
{

    static final String KEY_CHANNELS = "channels";
    static final String KEY_DATA = "data";
    static final String KEY_DEVICE_TYPE = "deviceType";
    static final String KEY_EXPIRATION_INTERVAL = "expiration_interval";
    static final String KEY_EXPIRATION_TIME = "expiration_time";
    static final String KEY_WHERE = "where";

    public ParseRESTPushCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1)
    {
        super(s, method, map, s1);
    }

    public static ParseRESTPushCommand sendPushCommand(ParseQuery.State state, Set set, String s, Long long1, Long long2, JSONObject jsonobject, String s1)
    {
        HashMap hashmap = new HashMap();
        if (set != null)
        {
            hashmap.put("channels", new JSONArray(set));
        } else
        {
            if (state != null)
            {
                state = state.constraints();
                hashmap.put("where", (JSONObject)PointerEncoder.get().encode(state));
            }
            if (s != null)
            {
                state = new JSONObject();
                try
                {
                    state.put("deviceType", s);
                }
                // Misplaced declaration of an exception variable
                catch (ParseQuery.State state)
                {
                    throw new RuntimeException(state.getMessage());
                }
                hashmap.put("where", state);
            }
            if (hashmap.size() == 0)
            {
                hashmap.put("where", new JSONObject());
            }
        }
        if (long1 != null)
        {
            hashmap.put("expiration_time", long1);
        } else
        if (long2 != null)
        {
            hashmap.put("expiration_interval", long2);
        }
        if (jsonobject != null)
        {
            hashmap.put("data", jsonobject);
        }
        return new ParseRESTPushCommand("push", com.parse.http.ParseHttpRequest.Method.POST, hashmap, s1);
    }
}

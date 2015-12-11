// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand, PointerEncoder, ParseTextUtils, ParseEncoder

class ParseRESTQueryCommand extends ParseRESTCommand
{

    private ParseRESTQueryCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1)
    {
        super(s, method, map, s1);
    }

    public static ParseRESTQueryCommand countCommand(ParseQuery.State state, String s)
    {
        String s1 = String.format("classes/%s", new Object[] {
            state.className()
        });
        state = encode(state, true);
        return new ParseRESTQueryCommand(s1, com.parse.http.ParseHttpRequest.Method.GET, state, s);
    }

    static Map encode(ParseQuery.State state, boolean flag)
    {
        HashMap hashmap;
        PointerEncoder pointerencoder = PointerEncoder.get();
        hashmap = new HashMap();
        Object obj = state.order();
        if (!((List) (obj)).isEmpty())
        {
            hashmap.put("order", ParseTextUtils.join(",", ((Iterable) (obj))));
        }
        obj = state.constraints();
        if (!((ParseQuery.QueryConstraints) (obj)).isEmpty())
        {
            obj = (JSONObject)pointerencoder.encode(obj);
            java.util.Map.Entry entry;
            Object obj1;
            if (!(obj instanceof JSONObject))
            {
                obj = ((JSONObject) (obj)).toString();
            } else
            {
                obj = JSONObjectInstrumentation.toString((JSONObject)obj);
            }
            hashmap.put("where", obj);
        }
        obj = state.selectedKeys();
        if (obj != null)
        {
            hashmap.put("keys", ParseTextUtils.join(",", ((Iterable) (obj))));
        }
        obj = state.includes();
        if (!((Set) (obj)).isEmpty())
        {
            hashmap.put("include", ParseTextUtils.join(",", ((Iterable) (obj))));
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        hashmap.put("count", Integer.toString(1));
_L4:
        for (obj = state.extraOptions().entrySet().iterator(); ((Iterator) (obj)).hasNext(); hashmap.put(entry.getKey(), obj1.toString()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            obj1 = pointerencoder.encode(entry.getValue());
        }

        break; /* Loop/switch isn't completed */
_L2:
        int i = state.limit();
        if (i >= 0)
        {
            hashmap.put("limit", Integer.toString(i));
        }
        i = state.skip();
        if (i > 0)
        {
            hashmap.put("skip", Integer.toString(i));
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (state.isTracingEnabled())
        {
            hashmap.put("trace", Integer.toString(1));
        }
        return hashmap;
    }

    public static ParseRESTQueryCommand findCommand(ParseQuery.State state, String s)
    {
        String s1 = String.format("classes/%s", new Object[] {
            state.className()
        });
        state = encode(state, false);
        return new ParseRESTQueryCommand(s1, com.parse.http.ParseHttpRequest.Method.GET, state, s);
    }
}

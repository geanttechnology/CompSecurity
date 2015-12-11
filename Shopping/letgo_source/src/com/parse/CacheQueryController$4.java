// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            CacheQueryController, ParseKeyValueCache, ParseException

class val.state
    implements Callable
{

    final CacheQueryController this$0;
    final String val$cacheKey;
    final call val$state;

    public Integer call()
        throws Exception
    {
        JSONObject jsonobject = ParseKeyValueCache.jsonFromKeyValueCache(val$cacheKey, val$state.heAge());
        if (jsonobject == null)
        {
            throw new ParseException(120, "results not cached");
        }
        int i;
        try
        {
            i = jsonobject.getInt("count");
        }
        catch (JSONException jsonexception)
        {
            throw new ParseException(120, "the cache contains corrupted json");
        }
        return Integer.valueOf(i);
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
        this$0 = final_cachequerycontroller;
        val$cacheKey = s;
        val$state = val.state.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;

// Referenced classes of package com.parse:
//            CacheQueryController, ParseKeyValueCache, ParseException, NetworkQueryController

class val.state
    implements Callable
{

    final CacheQueryController this$0;
    final String val$cacheKey;
    final val.state val$state;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public List call()
        throws Exception
    {
        Object obj = ParseKeyValueCache.jsonFromKeyValueCache(val$cacheKey, val$state.heAge());
        if (obj == null)
        {
            throw new ParseException(120, "results not cached");
        }
        try
        {
            obj = CacheQueryController.access$000(CacheQueryController.this).convertFindResponse(val$state, ((org.json.JSONObject) (obj)));
        }
        catch (JSONException jsonexception)
        {
            throw new ParseException(120, "the cache contains corrupted json");
        }
        return ((List) (obj));
    }

    ()
    {
        this$0 = final_cachequerycontroller;
        val$cacheKey = s;
        val$state = val.state.this;
        super();
    }
}

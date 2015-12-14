// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseQuery, ParseUser, ParseCommand, Parse, 
//            ParseException

class 
    implements Callable
{

    final ParseQuery this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public List call()
        throws Exception
    {
        Object obj = Parse.jsonFromKeyValueCache(ParseQuery.access$900(ParseQuery.this, ParseUser.getCurrentSessionToken()).getCacheKey(), ParseQuery.access$1000(ParseQuery.this));
        if (obj == null)
        {
            throw new ParseException(120, "results not cached");
        }
        if (!(obj instanceof JSONObject))
        {
            throw new ParseException(120, "the cache contains the wrong datatype");
        }
        obj = (JSONObject)obj;
        try
        {
            obj = ParseQuery.access$800(ParseQuery.this, ((JSONObject) (obj)));
        }
        catch (JSONException jsonexception)
        {
            throw new ParseException(120, "the cache contains corrupted json");
        }
        return ((List) (obj));
    }

    n()
    {
        this$0 = ParseQuery.this;
        super();
    }
}

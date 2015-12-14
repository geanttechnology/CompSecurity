// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseQuery, ParseCommand, Parse

class val.caching
    implements Continuation
{

    final is._cls0 this$1;
    final boolean val$caching;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public List then(Task task)
        throws Exception
    {
        if (val$caching)
        {
            Object obj = task.getResult();
            Parse.saveToKeyValueCache(ParseQuery.access$400(_fld0).getCacheKey(), obj.toString());
        }
        ParseQuery.access$702(_fld0, System.nanoTime());
        return ParseQuery.access$800(_fld0, (JSONObject)task.getResult());
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$caching = Z.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseQuery$6

/* anonymous class */
    class ParseQuery._cls6
        implements Continuation
    {

        final ParseQuery this$0;

        public Task then(Task task)
            throws Exception
        {
            task = new ArrayList();
            if (ParseQuery.access$400(ParseQuery.this) == null)
            {
                return Task.forResult(task);
            }
            boolean flag;
            if (ParseQuery.access$500(ParseQuery.this) != ParseQuery.CachePolicy.IGNORE_CACHE)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ParseQuery.access$602(ParseQuery.this, System.nanoTime());
            return ParseQuery.access$400(ParseQuery.this).executeAsync().onSuccess(flag. new ParseQuery._cls6._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
    }

}

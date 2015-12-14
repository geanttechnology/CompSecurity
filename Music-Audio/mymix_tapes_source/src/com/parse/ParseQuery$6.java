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

class 
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
        final boolean caching;
        if (ParseQuery.access$500(ParseQuery.this) != chePolicy.IGNORE_CACHE)
        {
            caching = true;
        } else
        {
            caching = false;
        }
        ParseQuery.access$602(ParseQuery.this, System.nanoTime());
        return ParseQuery.access$400(ParseQuery.this).executeAsync().onSuccess(new Continuation() {

            final ParseQuery._cls6 this$1;
            final boolean val$caching;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public List then(Task task1)
                throws Exception
            {
                if (caching)
                {
                    Object obj = task1.getResult();
                    Parse.saveToKeyValueCache(ParseQuery.access$400(this$0).getCacheKey(), obj.toString());
                }
                ParseQuery.access$702(this$0, System.nanoTime());
                return ParseQuery.access$800(this$0, (JSONObject)task1.getResult());
            }

            
            {
                this$1 = ParseQuery._cls6.this;
                caching = flag;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = ParseQuery.this;
        super();
    }
}

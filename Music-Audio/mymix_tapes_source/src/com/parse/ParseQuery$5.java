// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseQuery, ParseObject, ParseException

class 
    implements Continuation
{

    final ParseQuery this$0;

    public ParseObject then(Task task)
        throws Exception
    {
        if (task.isFaulted())
        {
            throw task.getError();
        }
        if (task.getResult() != null && ((List)task.getResult()).size() > 0)
        {
            return (ParseObject)((List)task.getResult()).get(0);
        } else
        {
            throw new ParseException(101, "no results found for query");
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    n()
    {
        this$0 = ParseQuery.this;
        super();
    }
}

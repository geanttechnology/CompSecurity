// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseObject

class val.object
    implements Continuation
{

    final then this$1;
    final ParseObject val$object;

    public Boolean then(Task task)
        throws ParseException
    {
        return Boolean.valueOf(tches(val$object, (List)task.getResult()));
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$1 = final_;
        val$object = ParseObject.this;
        super();
    }
}

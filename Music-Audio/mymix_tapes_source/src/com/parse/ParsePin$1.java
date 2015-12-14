// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePin, ParseObject

static final class t>
    implements Continuation
{

    final String val$name;

    public ParsePin then(Task task)
        throws Exception
    {
        Object obj = null;
        ParsePin parsepin = obj;
        if (task.getResult() != null)
        {
            parsepin = obj;
            if (((List)task.getResult()).size() > 0)
            {
                parsepin = (ParsePin)((List)task.getResult()).get(0);
            }
        }
        task = parsepin;
        if (parsepin == null)
        {
            task = (ParsePin)ParseObject.create(com/parse/ParsePin);
            task.setName(val$name);
        }
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (String s)
    {
        val$name = s;
        super();
    }
}

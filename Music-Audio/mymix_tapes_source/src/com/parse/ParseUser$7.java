// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseException, ParseObject

static final class on
    implements Continuation
{

    public Task then(Task task)
        throws Exception
    {
        if (task.getResult() == JSONObject.NULL)
        {
            throw new ParseException(101, "invalid login credentials");
        } else
        {
            return ParseUser.access$100((ParseUser)ParseObject.fromJSON((JSONObject)task.getResult(), "_User", true));
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    on()
    {
    }
}

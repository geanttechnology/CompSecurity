// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser

static final class val.user
    implements Continuation
{

    final List val$objects;
    final ParseUser val$user;

    public Task then(Task task)
        throws Exception
    {
        return ParseObject.access$1600(val$objects, val$user, task);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (List list, ParseUser parseuser)
    {
        val$objects = list;
        val$user = parseuser;
        super();
    }
}

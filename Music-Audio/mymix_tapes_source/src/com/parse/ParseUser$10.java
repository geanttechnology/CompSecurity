// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseUser

static final class 
    implements Continuation
{

    final ParseUser val$user;

    public Task then(Task task)
        throws Exception
    {
        return val$user.pinInBackground("_currentUser");
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (ParseUser parseuser)
    {
        val$user = parseuser;
        super();
    }
}

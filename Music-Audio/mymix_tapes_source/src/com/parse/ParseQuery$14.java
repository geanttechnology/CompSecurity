// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseQuery, ParseUser

class val.user
    implements Callable
{

    final ParseQuery this$0;
    final ParseUser val$user;

    public Task call()
        throws Exception
    {
        return findWithCachePolicyAsync(ParseQuery.access$500(ParseQuery.this), val$user);
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    lable()
    {
        this$0 = final_parsequery;
        val$user = ParseUser.this;
        super();
    }
}

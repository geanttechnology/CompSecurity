// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;

// Referenced classes of package com.parse:
//            ParseQuery, ParseUser

class 
    implements mmandDelegate
{

    final ParseQuery this$0;
    final ParseUser val$user;

    public Task runFromCacheAsync()
    {
        return ParseQuery.access$200(ParseQuery.this, val$user, false, ParseQuery.access$100(ParseQuery.this));
    }

    public Task runOnNetworkAsync(boolean flag)
    {
        return ParseQuery.access$000(ParseQuery.this);
    }

    mmandDelegate()
    {
        this$0 = final_parsequery;
        val$user = ParseUser.this;
        super();
    }
}

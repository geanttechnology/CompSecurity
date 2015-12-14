// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;

// Referenced classes of package com.parse:
//            ParseQuery, ParseUser

class val.user
    implements lableWithCachePolicy
{

    final ParseQuery this$0;
    final ParseUser val$user;

    public Task call(hePolicy hepolicy)
    {
        return ParseQuery.access$1500(ParseQuery.this, hepolicy, val$user);
    }

    public volatile Object call(hePolicy hepolicy)
    {
        return call(hepolicy);
    }

    hePolicy()
    {
        this$0 = final_parsequery;
        val$user = ParseUser.this;
        super();
    }
}

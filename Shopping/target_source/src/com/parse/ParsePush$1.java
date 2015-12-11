// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParsePush, ParsePushController

class >
    implements i
{

    final ParsePush this$0;
    final ate val$state;

    public j then(j j1)
        throws Exception
    {
        j1 = (String)j1.e();
        return ParsePush.getPushController().sendInBackground(val$state, j1);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ate()
    {
        this$0 = final_parsepush;
        val$state = ate.this;
        super();
    }
}

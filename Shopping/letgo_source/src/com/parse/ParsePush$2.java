// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParsePush, ParsePushController

class >
    implements ct
{

    final ParsePush this$0;
    final ate val$state;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        return ParsePush.getPushController().sendInBackground(val$state, cu1);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ate()
    {
        this$0 = final_parsepush;
        val$state = ate.this;
        super();
    }
}

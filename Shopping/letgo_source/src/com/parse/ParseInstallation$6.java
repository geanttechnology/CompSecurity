// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseInstallation, PushService

class this._cls0
    implements ct
{

    final ParseInstallation this$0;

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public Void then(cu cu1)
        throws Exception
    {
        cu1 = (Boolean)cu1.e();
        if (cu1 == null || cu1.booleanValue())
        {
            PushService.startServiceIfRequired(.get().applicationContext());
        }
        return null;
    }

    ()
    {
        this$0 = ParseInstallation.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParsePush, Parse, PushService

static final class >
    implements ct
{

    final boolean val$enabled;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
        throws Exception
    {
        cu = Parse.getApplicationContext();
        if (!val$enabled)
        {
            PushService.stopPpnsService(cu);
        } else
        {
            PushService.startServiceIfRequired(cu);
        }
        return null;
    }

    (boolean flag)
    {
        val$enabled = flag;
        super();
    }
}

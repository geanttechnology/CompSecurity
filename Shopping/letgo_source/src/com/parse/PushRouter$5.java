// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Set;

// Referenced classes of package com.parse:
//            PushRouter

static final class 
    implements ct
{

    final boolean val$includeDefaultRoute;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Set then(cu cu)
    {
        return PushRouter.access$000().getSubscriptions(val$includeDefaultRoute);
    }

    (boolean flag)
    {
        val$includeDefaultRoute = flag;
        super();
    }
}

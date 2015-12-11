// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            PushRouter

static final class 
    implements ct
{

    final Boolean val$forceEnabled;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
    {
        PushRouter.access$000().setForceEnabledState(val$forceEnabled);
        return null;
    }

    (Boolean boolean1)
    {
        val$forceEnabled = boolean1;
        super();
    }
}

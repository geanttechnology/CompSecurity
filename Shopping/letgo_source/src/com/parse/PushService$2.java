// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Set;

// Referenced classes of package com.parse:
//            PushService

static final class ndroid
    implements ct
{

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public Void then(cu cu1)
    {
        if (((Set)cu1.e()).size() == 0)
        {
            PushService.stopPpnsService(ndroid.get().applicationContext());
        }
        return null;
    }

    ndroid()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject

class val.object
    implements ct
{

    final OfflineStore this$0;
    final ParseObject val$object;
    final android.support.v7.t val$tcs;

    public cu then(cu cu1)
        throws Exception
    {
        if (cu1.c())
        {
            val$tcs.t();
        } else
        if (cu1.d())
        {
            val$tcs.t(cu1.f());
        } else
        {
            val$tcs.t(val$object);
        }
        return val$tcs.t();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$tcs = ;
        val$object = ParseObject.this;
        super();
    }
}

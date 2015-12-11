// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore

class val.store
    implements ct
{

    final ParseObject this$0;
    final OfflineStore val$store;

    public cu then(cu cu1)
        throws Exception
    {
        return val$store.fetchLocallyAsync(ParseObject.this).j();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_parseobject;
        val$store = OfflineStore.this;
        super();
    }
}

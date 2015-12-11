// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore

class val.store
    implements i
{

    final ParseObject this$0;
    final OfflineStore val$store;

    public j then(j j1)
        throws Exception
    {
        return val$store.fetchLocallyAsync(ParseObject.this).j();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_parseobject;
        val$store = OfflineStore.this;
        super();
    }
}

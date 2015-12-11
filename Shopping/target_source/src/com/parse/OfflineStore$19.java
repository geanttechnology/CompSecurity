// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject

class val.object
    implements i
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public j then(j j1)
        throws Exception
    {
        return (j)OfflineStore.access$500(OfflineStore.this).get(val$object);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}

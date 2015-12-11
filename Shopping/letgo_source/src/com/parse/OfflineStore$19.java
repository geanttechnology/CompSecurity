// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject

class val.object
    implements ct
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public cu then(cu cu1)
        throws Exception
    {
        return (cu)OfflineStore.access$500(OfflineStore.this).get(val$object);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}

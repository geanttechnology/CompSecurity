// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineObjectStore, ParseObject

class val.object
    implements i
{

    final OfflineObjectStore this$0;
    final ParseObject val$object;

    public j then(j j)
        throws Exception
    {
        return val$object.pinInBackground(OfflineObjectStore.access$000(OfflineObjectStore.this), false);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    ()
    {
        this$0 = final_offlineobjectstore;
        val$object = ParseObject.this;
        super();
    }
}

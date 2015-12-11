// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineObjectStore, ParseObject

class this._cls0
    implements i
{

    final OfflineObjectStore this$0;

    public j then(j j1)
        throws Exception
    {
        j1 = (List)j1.e();
        if (j1 != null)
        {
            if (j1.size() == 1)
            {
                return j.a(j1.get(0));
            } else
            {
                return ParseObject.unpinAllInBackground(OfflineObjectStore.access$000(OfflineObjectStore.this)).i();
            }
        } else
        {
            return j.a(null);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = OfflineObjectStore.this;
        super();
    }
}

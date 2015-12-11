// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineObjectStore, ParseObjectStore

class this._cls0
    implements i
{

    final OfflineObjectStore this$0;

    public j then(j j1)
        throws Exception
    {
        boolean flag;
        if (((Integer)j1.e()).intValue() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return j.a(Boolean.valueOf(true));
        } else
        {
            return OfflineObjectStore.access$100(OfflineObjectStore.this).existsAsync();
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

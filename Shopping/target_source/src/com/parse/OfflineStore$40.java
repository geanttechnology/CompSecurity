// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final List val$objects;

    public j then(j j1)
        throws Exception
    {
        j1 = (ParsePin)j1.e();
        List list = j1.getObjects();
        if (list == null)
        {
            return j.a(null);
        }
        list.removeAll(val$objects);
        if (list.size() == 0)
        {
            return OfflineStore.access$2000(OfflineStore.this, j1, val$db);
        } else
        {
            j1.setObjects(list);
            return OfflineStore.access$1500(OfflineStore.this, j1, true, val$db);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$objects = list;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}

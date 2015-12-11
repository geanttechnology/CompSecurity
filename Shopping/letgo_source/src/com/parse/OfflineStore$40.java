// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseSQLiteDatabase

class ase
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final List val$objects;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (ParsePin)cu1.e();
        List list = cu1.getObjects();
        if (list == null)
        {
            return cu.a(null);
        }
        list.removeAll(val$objects);
        if (list.size() == 0)
        {
            return OfflineStore.access$2000(OfflineStore.this, cu1, val$db);
        } else
        {
            cu1.setObjects(list);
            return OfflineStore.access$1500(OfflineStore.this, cu1, true, val$db);
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$objects = list;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final String val$key;

    public j then(j j)
        throws Exception
    {
        j = val$key;
        return val$db.deleteAsync("Dependencies", "key=?", new String[] {
            j
        });
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$key = s;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}

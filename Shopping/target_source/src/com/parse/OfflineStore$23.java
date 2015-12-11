// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.database.Cursor;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final List val$uuidsToDelete;

    public j then(j j1)
        throws Exception
    {
        for (j1 = (Cursor)j1.e(); j1.moveToNext(); val$uuidsToDelete.add(j1.getString(0))) { }
        j1.close();
        return OfflineStore.access$1100(OfflineStore.this, val$uuidsToDelete, val$db);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$uuidsToDelete = list;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}

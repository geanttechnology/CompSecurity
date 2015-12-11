// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class ase
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final List val$uuidsToDelete;

    public cu then(cu cu1)
        throws Exception
    {
        for (cu1 = (Cursor)cu1.e(); cu1.moveToNext(); val$uuidsToDelete.add(cu1.getString(0))) { }
        cu1.close();
        return OfflineStore.access$1100(OfflineStore.this, val$uuidsToDelete, val$db);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$uuidsToDelete = list;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.mixtape.database.MetadataCleanupRunnable;
import com.amazon.mixtape.database.MetadataCleanupTask;
import com.amazon.mixtape.utils.TransactionExecutor;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.amazon.mixtape.service:
//            MetadataCleanup, MetadataSyncException

private class mAccountId
    implements com.amazon.mixtape.account.mAccountId
{

    private final String mAccountId;
    private final String mAuthority;
    private final Context mContext;
    final MetadataCleanup this$0;

    private Collection getPendingCleanupTasks(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        LinkedList linkedlist;
        linkedlist = new LinkedList();
        cursor = sqlitedatabase.query("metadata_cleanup_queue", null, null, null, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        cursor.moveToFirst();
_L1:
        MetadataCleanupTask metadatacleanuptask;
        if (cursor.isAfterLast())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        metadatacleanuptask = MetadataCleanupTask.getTaskFromId(cursor.getInt(cursor.getColumnIndex("task_id")));
        if (metadatacleanuptask == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        linkedlist.add(metadatacleanuptask.getMetadataCleanupRunnable(mContext, sqlitedatabase, mAuthority, mAccountId));
        cursor.moveToNext();
          goto _L1
        sqlitedatabase;
        cursor.close();
        throw sqlitedatabase;
        cursor.close();
        return linkedlist;
    }

    public void run(SQLiteDatabase sqlitedatabase)
        throws CloudDriveException, MetadataSyncException, InterruptedException
    {
        TransactionExecutor transactionexecutor = new TransactionExecutor(sqlitedatabase);
        MetadataCleanupRunnable metadatacleanuprunnable;
        for (sqlitedatabase = getPendingCleanupTasks(sqlitedatabase).iterator(); sqlitedatabase.hasNext(); metadatacleanuprunnable.onPostTransactionComplete())
        {
            metadatacleanuprunnable = (MetadataCleanupRunnable)sqlitedatabase.next();
            transactionexecutor.execute(metadatacleanuprunnable);
        }

    }

    public (Context context, String s, String s1)
    {
        this$0 = MetadataCleanup.this;
        super();
        mContext = context;
        mAuthority = s;
        mAccountId = s1;
    }
}

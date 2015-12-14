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
//            MetadataSyncException

class MetadataCleanup
{
    private class MetadataCleanupTasks
        implements com.amazon.mixtape.account.AccountContextFactory.MetadataTask
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

        public MetadataCleanupTasks(Context context, String s, String s1)
        {
            this$0 = MetadataCleanup.this;
            super();
            mContext = context;
            mAuthority = s;
            mAccountId = s1;
        }
    }

    private class PostSyncTasks
        implements com.amazon.mixtape.account.AccountContextFactory.MetadataTask
    {

        final MetadataCleanup this$0;

        public void run(SQLiteDatabase sqlitedatabase)
            throws CloudDriveException, MetadataSyncException, InterruptedException
        {
        }

        private PostSyncTasks()
        {
            this$0 = MetadataCleanup.this;
            super();
        }

    }


    private final PostSyncTasks mPostSyncTasks = new PostSyncTasks();

    MetadataCleanup()
    {
    }

    com.amazon.mixtape.account.AccountContextFactory.MetadataTask getMetadataCleanupTasks(Context context, String s, String s1)
    {
        return new MetadataCleanupTasks(context, s, s1);
    }

    com.amazon.mixtape.account.AccountContextFactory.MetadataTask getPostSyncTasks()
    {
        return mPostSyncTasks;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.amazon.mixtape.database:
//            MetadataCleanupRunnable, CloudMediaParentsRollupHelper

public abstract class MetadataCleanupTask extends Enum
{
    private static class ClearNodeProperties
        implements MetadataCleanupRunnable
    {

        private final String mAccountId;
        private final String mAuthority;
        private final Context mContext;
        private final SQLiteDatabase mDatabase;

        public void onPostTransactionComplete()
        {
            android.net.Uri uri = com.amazon.mixtape.provider.CloudNodesContract.NodeProperties.getContentUri(mAuthority, mAccountId);
            mContext.getContentResolver().notifyChange(uri, null);
        }

        public void run()
        {
            mDatabase.execSQL("CREATE TEMP TABLE tmpProperties(        node_id TEXT,        event_id INTEGER,        owner TEXT,        key TEXT,        value TEXT)");
            mDatabase.execSQL("INSERT INTO tmpProperties(node_id,             event_id,             owner,             key,             value)        SELECT p.node_id,                p.event_id,                p.owner,                p.key,                p.value        FROM cloud_node_properties p            JOIN cloud_nodes n ON                n.node_id=p.node_id AND                n.event_id=p.event_id AND                p.owner='AMZClient'");
            mDatabase.execSQL("DELETE FROM cloud_node_properties");
            mDatabase.execSQL("INSERT INTO cloud_node_properties(            node_id,             event_id,             owner,             key,             value)        SELECT node_id,                event_id,                owner,                key,                value        FROM tmpProperties");
            mDatabase.execSQL("DROP TABLE tmpProperties");
            MetadataCleanupTask.CLEAR_NODE_PROPERTIES.removeTaskForExecution(mDatabase);
        }

        public ClearNodeProperties(Context context, SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mContext = context;
            mDatabase = sqlitedatabase;
            mAuthority = s;
            mAccountId = s1;
        }
    }

    private static class RebuildMediaParents
        implements MetadataCleanupRunnable
    {

        private final String mAccountId;
        private final String mAuthority;
        private final Context mContext;
        private final SQLiteDatabase mDatabase;

        public void onPostTransactionComplete()
        {
            android.net.Uri uri = com.amazon.mixtape.provider.CloudNodesContract.MediaParents.getContentUri(mAuthority, mAccountId);
            mContext.getContentResolver().notifyChange(uri, null);
        }

        public void run()
        {
            CloudMediaParentsRollupHelper.updateCloudMediaParents(mDatabase, 0L);
            MetadataCleanupTask.REBUILD_MEDIA_PARENTS.removeTaskForExecution(mDatabase);
        }

        public RebuildMediaParents(Context context, SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mContext = context;
            mDatabase = sqlitedatabase;
            mAuthority = s;
            mAccountId = s1;
        }
    }


    private static final MetadataCleanupTask $VALUES[];
    public static final MetadataCleanupTask CLEAR_NODE_PROPERTIES;
    public static final MetadataCleanupTask REBUILD_MEDIA_PARENTS;
    final int taskId;

    private MetadataCleanupTask(String s, int i, int j)
    {
        super(s, i);
        taskId = j;
    }


    public static MetadataCleanupTask getTaskFromId(int i)
    {
        MetadataCleanupTask ametadatacleanuptask[] = values();
        int k = ametadatacleanuptask.length;
        for (int j = 0; j < k; j++)
        {
            MetadataCleanupTask metadatacleanuptask = ametadatacleanuptask[j];
            if (i == metadatacleanuptask.taskId)
            {
                return metadatacleanuptask;
            }
        }

        return null;
    }

    public static MetadataCleanupTask valueOf(String s)
    {
        return (MetadataCleanupTask)Enum.valueOf(com/amazon/mixtape/database/MetadataCleanupTask, s);
    }

    public static MetadataCleanupTask[] values()
    {
        return (MetadataCleanupTask[])$VALUES.clone();
    }

    public abstract MetadataCleanupRunnable getMetadataCleanupRunnable(Context context, SQLiteDatabase sqlitedatabase, String s, String s1);

    void removeTaskForExecution(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("DELETE FROM metadata_cleanup_queue WHERE task_id = ?", new Object[] {
            Integer.valueOf(taskId)
        });
    }

    void scheduleTaskForExecution(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("INSERT INTO metadata_cleanup_queue(task_id) VALUES (?)", new Object[] {
            Integer.valueOf(taskId)
        });
    }

    static 
    {
        CLEAR_NODE_PROPERTIES = new MetadataCleanupTask("CLEAR_NODE_PROPERTIES", 0, 1) {

            public MetadataCleanupRunnable getMetadataCleanupRunnable(Context context, SQLiteDatabase sqlitedatabase, String s, String s1)
            {
                return new ClearNodeProperties(context, sqlitedatabase, s, s1);
            }

        };
        REBUILD_MEDIA_PARENTS = new MetadataCleanupTask("REBUILD_MEDIA_PARENTS", 1, 2) {

            public MetadataCleanupRunnable getMetadataCleanupRunnable(Context context, SQLiteDatabase sqlitedatabase, String s, String s1)
            {
                return new RebuildMediaParents(context, sqlitedatabase, s, s1);
            }

        };
        $VALUES = (new MetadataCleanupTask[] {
            CLEAR_NODE_PROPERTIES, REBUILD_MEDIA_PARENTS
        });
    }
}

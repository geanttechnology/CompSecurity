// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.amazon.mixtape.database:
//            MetadataCleanupRunnable, MetadataCleanupTask

private static class mAccountId
    implements MetadataCleanupRunnable
{

    private final String mAccountId;
    private final String mAuthority;
    private final Context mContext;
    private final SQLiteDatabase mDatabase;

    public void onPostTransactionComplete()
    {
        android.net.Uri uri = com.amazon.mixtape.provider.tentUri(mAuthority, mAccountId);
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

    public I(Context context, SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        mContext = context;
        mDatabase = sqlitedatabase;
        mAuthority = s;
        mAccountId = s1;
    }
}

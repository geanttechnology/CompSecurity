// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.amazon.mixtape.database:
//            MetadataCleanupRunnable, MetadataCleanupTask, CloudMediaParentsRollupHelper

private static class mAccountId
    implements MetadataCleanupRunnable
{

    private final String mAccountId;
    private final String mAuthority;
    private final Context mContext;
    private final SQLiteDatabase mDatabase;

    public void onPostTransactionComplete()
    {
        android.net.Uri uri = com.amazon.mixtape.provider.ntUri(mAuthority, mAccountId);
        mContext.getContentResolver().notifyChange(uri, null);
    }

    public void run()
    {
        CloudMediaParentsRollupHelper.updateCloudMediaParents(mDatabase, 0L);
        MetadataCleanupTask.REBUILD_MEDIA_PARENTS.removeTaskForExecution(mDatabase);
    }

    public I(Context context, SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        mContext = context;
        mDatabase = sqlitedatabase;
        mAuthority = s;
        mAccountId = s1;
    }
}

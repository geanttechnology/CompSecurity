// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.amazon.mixtape.database:
//            MetadataCleanupTask, MetadataCleanupRunnable

static final class nit> extends MetadataCleanupTask
{

    public MetadataCleanupRunnable getMetadataCleanupRunnable(Context context, SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        return new buildMediaParents(context, sqlitedatabase, s, s1);
    }

    e(String s, int i, int j)
    {
        super(s, i, j, null);
    }
}

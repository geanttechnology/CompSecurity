// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.content.ContentResolver;
import android.content.ContentValues;
import com.amazon.gallery.foundation.utils.log.GLogger;

public abstract class MigrationPolicy
    implements Runnable
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/MigrationPolicy.getSimpleName();
    private final int oldDbVersion;

    protected MigrationPolicy(int i)
    {
        oldDbVersion = i;
    }

    protected void createAuditLog(ContentResolver contentresolver, String s)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("key", s);
        contentvalues.put("value", Boolean.TRUE.toString());
        contentresolver.insert(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Audit.CONTENT_URI, contentvalues);
    }

    protected abstract void doMigration();

    public int getOldDbVersion()
    {
        return oldDbVersion;
    }

    protected abstract boolean needsMigration();

    public final void run()
    {
        if (!needsMigration())
        {
            return;
        }
        try
        {
            doMigration();
            return;
        }
        catch (Exception exception)
        {
            GLogger.exf(TAG, exception, "Exception while running migrator: %s", new Object[] {
                getClass().getSimpleName()
            });
        }
    }

}

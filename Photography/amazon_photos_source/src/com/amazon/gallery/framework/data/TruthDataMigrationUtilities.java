// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data;

import android.content.Context;
import com.amazon.gallery.framework.data.dao.sqlite.TruthDBMigrationHelper;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationHelper;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTask;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTaskFilter;
import com.amazon.gallery.framework.data.dao.sqlite.migration.TruthUploadQueueMigrationTask;
import com.amazon.gallery.framework.data.dao.sqlite.tag.NoOpDBMigrationHelper;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TruthDataMigrationUtilities
{
    public static interface MigrationCompleteCallback
    {

        public abstract void onMigrationComplete();
    }


    private Context context;
    private DatabaseMigrationHelper dbMigrationHelper;
    private Map dbMigrationTaskFilters;

    public TruthDataMigrationUtilities(Context context1)
    {
        dbMigrationTaskFilters = new HashMap();
        context = context1;
        dbMigrationHelper = new TruthDBMigrationHelper(context1, new MigrationCompleteCallback() {

            final TruthDataMigrationUtilities this$0;

            public void onMigrationComplete()
            {
                onDatabaseMigrationCompleted();
            }

            
            {
                this$0 = TruthDataMigrationUtilities.this;
                super();
            }
        });
    }

    private static boolean isDatabaseMigrationNeeded(Context context1)
    {
        return !"".equals(AospPreferences.getTruthDatabaseIdHelper(context1));
    }

    public static boolean isMigrationComplete(Context context1)
    {
        return !isDatabaseMigrationNeeded(context1);
    }

    private void onDatabaseMigrationCompleted()
    {
        this;
        JVM INSTR monitorenter ;
        dbMigrationHelper = new NoOpDBMigrationHelper();
        dbMigrationTaskFilters.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void enqueuePendingDatabaseMigrationTasks(Collection collection)
    {
        DatabaseMigrationTask databasemigrationtask;
        for (collection = collection.iterator(); collection.hasNext(); dbMigrationTaskFilters.put(databasemigrationtask.getClass(), databasemigrationtask.getFilterForTask()))
        {
            databasemigrationtask = (DatabaseMigrationTask)collection.next();
            dbMigrationHelper.registerTaskForExecution(databasemigrationtask);
        }

    }

    public void startTruthUploadQueueMigration()
    {
        dbMigrationHelper.executeTasksForCategory((DatabaseMigrationTaskFilter)dbMigrationTaskFilters.get(com/amazon/gallery/framework/data/dao/sqlite/migration/TruthUploadQueueMigrationTask));
    }

}

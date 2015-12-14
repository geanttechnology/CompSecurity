// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class NewAttributeMigrator
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/NewAttributeMigrator.getName();
    private boolean isTrigger;
    private final List policies = new ArrayList();

    public NewAttributeMigrator()
    {
        isTrigger = false;
    }

    public void addMigrationPolicy(MigrationPolicy migrationpolicy)
    {
        policies.add(migrationpolicy);
        isTrigger = true;
    }

    public void executePendingMigrations()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isTrigger;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        isTrigger = false;
        obj = Executors.newSingleThreadExecutor();
        MigrationPolicy migrationpolicy;
        for (Iterator iterator = policies.iterator(); iterator.hasNext(); ((ExecutorService) (obj)).execute(migrationpolicy))
        {
            migrationpolicy = (MigrationPolicy)iterator.next();
            String s = migrationpolicy.getClass().getSimpleName();
            GLogger.i(TAG, "Scheduling migration: %s", new Object[] {
                s
            });
        }

        break MISSING_BLOCK_LABEL_104;
        Exception exception;
        exception;
        ((ExecutorService) (obj)).shutdown();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((ExecutorService) (obj)).shutdown();
          goto _L1
    }

}

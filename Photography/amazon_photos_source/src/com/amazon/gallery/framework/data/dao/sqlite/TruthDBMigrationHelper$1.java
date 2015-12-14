// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTask;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            TruthDBMigrationHelper

class this._cls0
    implements appedDBMigrationTask.MigrationTaskCallback
{

    final TruthDBMigrationHelper this$0;

    public void onError(DatabaseMigrationTask databasemigrationtask)
    {
        TruthDBMigrationHelper.access$000(TruthDBMigrationHelper.this, databasemigrationtask, false);
    }

    public void onSuccess(DatabaseMigrationTask databasemigrationtask)
    {
        TruthDBMigrationHelper.access$000(TruthDBMigrationHelper.this, databasemigrationtask, true);
    }

    onTask()
    {
        this$0 = TruthDBMigrationHelper.this;
        super();
    }
}

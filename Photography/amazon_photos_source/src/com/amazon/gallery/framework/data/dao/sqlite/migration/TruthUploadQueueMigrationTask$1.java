// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            DatabaseMigrationTaskFilter, TruthUploadQueueMigrationTask, DatabaseMigrationTask

class this._cls0
    implements DatabaseMigrationTaskFilter
{

    final TruthUploadQueueMigrationTask this$0;

    public boolean doesTaskMatchFilter(DatabaseMigrationTask databasemigrationtask)
    {
        return databasemigrationtask instanceof TruthUploadQueueMigrationTask;
    }

    ()
    {
        this$0 = TruthUploadQueueMigrationTask.this;
        super();
    }
}

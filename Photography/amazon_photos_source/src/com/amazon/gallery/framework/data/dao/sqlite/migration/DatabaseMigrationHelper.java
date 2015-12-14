// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            DatabaseMigrationTaskFilter, DatabaseMigrationTask

public interface DatabaseMigrationHelper
{

    public abstract void executeTasksForCategory(DatabaseMigrationTaskFilter databasemigrationtaskfilter);

    public abstract void registerTaskForExecution(DatabaseMigrationTask databasemigrationtask);
}

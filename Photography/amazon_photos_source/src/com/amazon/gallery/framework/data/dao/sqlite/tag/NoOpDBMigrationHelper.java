// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationHelper;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTask;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTaskFilter;

public class NoOpDBMigrationHelper
    implements DatabaseMigrationHelper
{

    public NoOpDBMigrationHelper()
    {
    }

    public void executeTasksForCategory(DatabaseMigrationTaskFilter databasemigrationtaskfilter)
    {
    }

    public void registerTaskForExecution(DatabaseMigrationTask databasemigrationtask)
    {
    }
}

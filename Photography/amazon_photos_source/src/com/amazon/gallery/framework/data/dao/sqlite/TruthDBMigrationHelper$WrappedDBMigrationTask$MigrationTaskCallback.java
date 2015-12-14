// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTask;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            TruthDBMigrationHelper

public static interface 
{

    public abstract void onError(DatabaseMigrationTask databasemigrationtask);

    public abstract void onSuccess(DatabaseMigrationTask databasemigrationtask);
}

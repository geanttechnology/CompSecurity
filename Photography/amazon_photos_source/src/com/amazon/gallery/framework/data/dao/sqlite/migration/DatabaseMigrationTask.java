// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            DatabaseMigrationTaskFilter

public interface DatabaseMigrationTask
{

    public abstract void executeTask(SQLiteDatabase sqlitedatabase);

    public abstract DatabaseMigrationTaskFilter getFilterForTask();
}

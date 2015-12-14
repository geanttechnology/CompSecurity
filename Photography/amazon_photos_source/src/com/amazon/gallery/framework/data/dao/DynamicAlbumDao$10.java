// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            DynamicAlbumDao

class tor extends DBWriteExecutor
{

    final DynamicAlbumDao this$0;
    final long val$id;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        readwritesqlitedatabase = (com.amazon.gallery.framework.data.dao.sqlite.base.ReadWriteSQLiteStatement)DynamicAlbumDao.access$700().get();
        readwritesqlitedatabase.bindLong(1, val$id);
        readwritesqlitedatabase.bindLong(2, val$id);
        readwritesqlitedatabase.executeUpdateDelete();
        return null;
    }

    iteDatabase()
    {
        this$0 = final_dynamicalbumdao;
        val$id = J.this;
        super();
    }
}

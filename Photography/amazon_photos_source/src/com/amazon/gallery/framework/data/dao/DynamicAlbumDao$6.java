// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            DynamicAlbumDao

class utor extends DBWriteExecutor
{

    final DynamicAlbumDao this$0;
    final long val$tagId;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        readwritesqlitedatabase = (com.amazon.gallery.framework.data.dao.sqlite.abase.ReadWriteSQLiteStatement)DynamicAlbumDao.access$400().get();
        readwritesqlitedatabase.bindLong(1, val$tagId);
        readwritesqlitedatabase.executeUpdateDelete();
        return null;
    }

    LiteDatabase()
    {
        this$0 = final_dynamicalbumdao;
        val$tagId = J.this;
        super();
    }
}

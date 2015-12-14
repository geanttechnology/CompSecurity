// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.content.ContentResolver;
import android.content.Context;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import java.util.Collection;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl, MediaItemDaoChangeList

class val.items extends DBWriteExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final Collection val$items;

    public MediaItemDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
        LocalMediaItemDaoSqliteImpl.access$1200(LocalMediaItemDaoSqliteImpl.this, readwritesqlitedatabase, val$items, mediaitemdaochangelist, true);
        if (!mediaitemdaochangelist.getAllChangeList().isEmpty())
        {
            incrementSessionCounter();
        }
        return mediaitemdaochangelist;
    }

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    protected void postTransaction()
    {
        LocalMediaItemDaoSqliteImpl.access$1000(LocalMediaItemDaoSqliteImpl.this).getContentResolver().notifyChange(LocalMediaItemDaoSqliteImpl.access$1100(), null);
    }

    ()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$items = Collection.this;
        super();
    }
}

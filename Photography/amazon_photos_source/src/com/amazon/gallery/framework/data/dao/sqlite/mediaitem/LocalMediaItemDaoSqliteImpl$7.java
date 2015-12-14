// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class val.item extends DBReadExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final MediaItem val$item;

    protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    protected Set execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return LocalMediaItemDaoSqliteImpl.access$500(LocalMediaItemDaoSqliteImpl.this, readonlysqlitedatabase, val$item);
    }

    ()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$item = MediaItem.this;
        super();
    }
}

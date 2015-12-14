// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class val.mediaItem extends DBReadExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final MediaItem val$mediaItem;

    protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    protected List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return LocalMediaItemDaoSqliteImpl.access$300(LocalMediaItemDaoSqliteImpl.this, readonlysqlitedatabase, val$mediaItem);
    }

    ()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$mediaItem = MediaItem.this;
        super();
    }
}

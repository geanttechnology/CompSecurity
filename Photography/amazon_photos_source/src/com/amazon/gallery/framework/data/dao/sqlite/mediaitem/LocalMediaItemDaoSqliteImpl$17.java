// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.content.ContentResolver;
import android.content.Context;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class val.mediaItems extends DBWriteExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final List val$mediaItems;
    final Tag val$tag;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        if (LocalMediaItemDaoSqliteImpl.access$1300(LocalMediaItemDaoSqliteImpl.this) == null)
        {
            String s = SQLiteDaoUtil.deleteClause("tag_membership", "media_item_id=? AND tag_id=?");
            LocalMediaItemDaoSqliteImpl.access$1302(LocalMediaItemDaoSqliteImpl.this, readwritesqlitedatabase.compileStatement(s));
        }
        LocalMediaItemDaoSqliteImpl.access$1300(LocalMediaItemDaoSqliteImpl.this).bindString(2, String.valueOf(val$tag.getId()));
        for (readwritesqlitedatabase = val$mediaItems.iterator(); readwritesqlitedatabase.hasNext(); LocalMediaItemDaoSqliteImpl.access$1300(LocalMediaItemDaoSqliteImpl.this).executeUpdateDelete())
        {
            MediaItem mediaitem = (MediaItem)readwritesqlitedatabase.next();
            LocalMediaItemDaoSqliteImpl.access$1300(LocalMediaItemDaoSqliteImpl.this).bindString(1, String.valueOf(mediaitem.getId()));
        }

        return null;
    }

    protected void postTransaction()
    {
        LocalMediaItemDaoSqliteImpl.access$1000(LocalMediaItemDaoSqliteImpl.this).getContentResolver().notifyChange(LocalMediaItemDaoSqliteImpl.access$1100(), null);
    }

    atement()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$tag = tag1;
        val$mediaItems = List.this;
        super();
    }
}

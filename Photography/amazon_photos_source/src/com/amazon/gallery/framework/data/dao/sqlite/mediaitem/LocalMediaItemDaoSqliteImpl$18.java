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

class val.items extends DBWriteExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final List val$items;
    final Tag val$tag;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        if (LocalMediaItemDaoSqliteImpl.access$1400(LocalMediaItemDaoSqliteImpl.this) == null)
        {
            String s = SQLiteDaoUtil.replaceClause("tag_membership", new String[] {
                "media_item_id", "tag_id", "tag_media_revision_id"
            });
            LocalMediaItemDaoSqliteImpl.access$1402(LocalMediaItemDaoSqliteImpl.this, readwritesqlitedatabase.compileStatement(s));
        }
        LocalMediaItemDaoSqliteImpl.access$1400(LocalMediaItemDaoSqliteImpl.this).bindLong(2, val$tag.getId());
        LocalMediaItemDaoSqliteImpl.access$1400(LocalMediaItemDaoSqliteImpl.this).bindLong(3, val$tag.getDateCreatedMs());
        for (readwritesqlitedatabase = val$items.iterator(); readwritesqlitedatabase.hasNext(); LocalMediaItemDaoSqliteImpl.access$1400(LocalMediaItemDaoSqliteImpl.this).executeInsert())
        {
            MediaItem mediaitem = (MediaItem)readwritesqlitedatabase.next();
            LocalMediaItemDaoSqliteImpl.access$1400(LocalMediaItemDaoSqliteImpl.this).bindLong(1, mediaitem.getId());
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
        val$items = List.this;
        super();
    }
}

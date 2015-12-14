// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class this._cls0
    implements CursorRowProcessor
{

    final LocalMediaItemDaoSqliteImpl this$0;

    public MediaItem process(Cursor cursor)
    {
        return SQLiteDaoUtil.itemFromCursor(cursor, LocalMediaItemDaoSqliteImpl.this);
    }

    public volatile Object process(Cursor cursor)
    {
        return process(cursor);
    }

    ()
    {
        this$0 = LocalMediaItemDaoSqliteImpl.this;
        super();
    }
}

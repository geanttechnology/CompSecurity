// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.tag:
//            TagDaoSqliteImpl

class val.mediaItem extends DBReadExecutor
{

    final TagDaoSqliteImpl this$0;
    final MediaItem val$mediaItem;

    protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    protected Set execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return TagDaoSqliteImpl.access$000(TagDaoSqliteImpl.this, readonlysqlitedatabase, val$mediaItem);
    }

    I()
    {
        this$0 = final_tagdaosqliteimpl;
        val$mediaItem = MediaItem.this;
        super();
    }
}

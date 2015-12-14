// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.tag:
//            TagDaoSqliteImpl

class this._cls0
    implements CursorRowProcessor
{

    final TagDaoSqliteImpl this$0;

    public Tag process(Cursor cursor)
    {
        return tagFromCursor(cursor, false);
    }

    public volatile Object process(Cursor cursor)
    {
        return process(cursor);
    }

    I()
    {
        this$0 = TagDaoSqliteImpl.this;
        super();
    }
}

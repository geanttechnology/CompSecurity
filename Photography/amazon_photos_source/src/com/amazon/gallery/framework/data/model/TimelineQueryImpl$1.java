// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.model.TimelineEntry;

// Referenced classes of package com.amazon.gallery.framework.data.model:
//            TimelineQueryImpl

class this._cls0
    implements CursorRowProcessor
{

    final TimelineQueryImpl this$0;

    public TimelineEntry process(Cursor cursor)
    {
        return createTimelineEntry(cursor);
    }

    public volatile Object process(Cursor cursor)
    {
        return process(cursor);
    }

    sor()
    {
        this$0 = TimelineQueryImpl.this;
        super();
    }
}

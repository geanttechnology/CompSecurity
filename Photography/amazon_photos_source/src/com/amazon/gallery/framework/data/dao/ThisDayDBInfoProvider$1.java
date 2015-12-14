// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.model.ThisDayYearInfo;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            ThisDayDBInfoProvider

class val.collection
    implements CursorRowProcessor
{

    private ThisDayYearInfo currentBucket;
    private int currentYear;
    final ThisDayDBInfoProvider this$0;
    final ThisDayViewCollection val$collection;

    public MediaItem process(Cursor cursor)
    {
        int i = cursor.getInt(cursor.getColumnIndex("year"));
        if (i != currentYear)
        {
            currentBucket = new ThisDayYearInfo(i, ThisDayDBInfoProvider.access$000(ThisDayDBInfoProvider.this));
            val$collection.yearInfoList.add(currentBucket);
            currentYear = i;
        }
        currentBucket.addMediaItem(SQLiteDaoUtil.itemFromCursor(cursor, ThisDayDBInfoProvider.access$100(ThisDayDBInfoProvider.this), ThisDayDBInfoProvider.access$200()));
        return null;
    }

    public volatile Object process(Cursor cursor)
    {
        return process(cursor);
    }

    r()
    {
        this$0 = final_thisdaydbinfoprovider;
        val$collection = ThisDayViewCollection.this;
        super();
    }
}

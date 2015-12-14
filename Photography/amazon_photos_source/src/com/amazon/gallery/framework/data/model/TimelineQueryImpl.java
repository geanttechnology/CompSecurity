// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.model.TimelineEntry;
import com.amazon.gallery.framework.model.TimelineQuery;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.model:
//            TimelineUtils

public class TimelineQueryImpl
    implements TimelineQuery
{

    private static final String TAG = com/amazon/gallery/framework/data/model/TimelineQueryImpl.getName();
    private final String from;
    private SortOrder sortOrder;
    private MediaItemSortType sortType;
    private final String whereArgs[];
    private final String whereClause;

    public TimelineQueryImpl(String s, String s1, String as[], SortOrder sortorder)
    {
        from = s;
        whereClause = s1;
        whereArgs = as;
        sortOrder = sortorder;
    }

    TimelineEntry createTimelineEntry(Cursor cursor)
    {
        return TimelineUtils.getTimelineEntry(cursor.getInt(cursor.getColumnIndex("label")), cursor.getInt(cursor.getColumnIndex("count")));
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (TimelineQueryImpl)obj;
            if (from == null ? ((TimelineQueryImpl) (obj)).from != null : !from.equals(((TimelineQueryImpl) (obj)).from))
            {
                return false;
            }
            if (sortType == null ? ((TimelineQueryImpl) (obj)).sortType != null : !sortType.equals(((TimelineQueryImpl) (obj)).sortType))
            {
                return false;
            }
            if (!Arrays.equals(whereArgs, ((TimelineQueryImpl) (obj)).whereArgs))
            {
                return false;
            }
            if (whereClause == null ? ((TimelineQueryImpl) (obj)).whereClause != null : !whereClause.equals(((TimelineQueryImpl) (obj)).whereClause))
            {
                return false;
            }
        }
        return true;
    }

    public List get(GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        String s = "timeline_time_stamp";
        if (sortType != null)
        {
            s = sortType.getFilingType();
        }
        return (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(gallerydbconnectionmanager)).select(new String[] {
            (new StringBuilder()).append(s).append(" ").append("label").append(", count(*) ").append("count").toString()
        }).from(from).where(whereClause, whereArgs).orderBy("label DESC").groupBy("label").setRowProcessor(new CursorRowProcessor() {

            final TimelineQueryImpl this$0;

            public TimelineEntry process(Cursor cursor)
            {
                return createTimelineEntry(cursor);
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = TimelineQueryImpl.this;
                super();
            }
        }).build().query();
    }

    public int hashCode()
    {
        int k = 0;
        int l = from.hashCode();
        int i;
        int j;
        if (whereClause != null)
        {
            i = whereClause.hashCode();
        } else
        {
            i = 0;
        }
        if (whereArgs != null)
        {
            j = Arrays.hashCode(whereArgs);
        } else
        {
            j = 0;
        }
        if (sortOrder != null)
        {
            k = sortOrder.hashCode();
        }
        return ((l * 31 + i) * 31 + j) * 31 + k;
    }

    public void setMediaItemSortType(MediaItemSortType mediaitemsorttype)
    {
        sortType = mediaitemsorttype;
    }

}

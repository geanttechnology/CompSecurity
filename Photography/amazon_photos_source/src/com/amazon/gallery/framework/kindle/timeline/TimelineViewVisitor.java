// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.view.View;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.model.media.MediaItem;

public class TimelineViewVisitor
{

    private int column;
    private long date;
    private boolean dividerFound;
    private final int numColumns;
    private MediaItemSortType sortType;

    public TimelineViewVisitor(int i)
    {
        sortType = null;
        column = 0;
        dividerFound = false;
        date = -1L;
        numColumns = i;
        reset();
    }

    public long getDate()
    {
        return date;
    }

    public void reset()
    {
        column = 0;
        dividerFound = false;
        date = -1L;
    }

    public void setSortType(MediaItemSortType mediaitemsorttype)
    {
        sortType = mediaitemsorttype;
    }

    public boolean visit(View view)
    {
        com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType itemviewtype;
        itemviewtype = (com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType)view.getTag(0x7f0c000e);
        if (itemviewtype != com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.BANNER)
        {
            column = column + 1;
        }
        if (column == numColumns && dividerFound && date >= 0L || column > numColumns && !dividerFound)
        {
            return true;
        }
        if (itemviewtype != com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.DIVIDER) goto _L2; else goto _L1
_L1:
        if (!dividerFound)
        {
            dividerFound = true;
            date = -1L;
        }
        view = (Boolean)view.getTag(0x7f0c000c);
        if (view != null && view.booleanValue())
        {
            date = -1L;
        }
_L4:
        return false;
_L2:
        if (itemviewtype != com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.BANNER)
        {
            view = (ItemViewHolder)view.getTag();
            if (view == null)
            {
                view = null;
            } else
            {
                view = (MediaItem)view.getItem();
            }
            if (view == null)
            {
                return false;
            }
            if (date < 0L)
            {
                if (sortType == null)
                {
                    date = view.getDateCreatedMs();
                } else
                {
                    date = sortType.getSortingDate(view);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.gallery.accessibility.utils.ContentDescriptionHelper;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ViewFactory

public class MediaItemCursorAdapter extends CursorAdapter
{

    private final Context mContext;
    private MediaItemDao mMediaItemDao;
    private ViewFactory viewFactory;

    public MediaItemCursorAdapter(Context context, Cursor cursor)
    {
        super(context, cursor, 0);
        mContext = context;
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        context = SQLiteDaoUtil.itemFromCursor(cursor, mMediaItemDao);
        viewFactory.getView(cursor.getPosition(), context, view);
        ContentDescriptionHelper.setupAccessibilityContent(view);
    }

    public MediaItem getItem(int i)
    {
        return SQLiteDaoUtil.itemFromCursor((Cursor)super.getItem(i), mMediaItemDao);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i < 0 || i >= getCount())
        {
            DebugAssert.assertMsg(String.format("Position %d is invalid for cursor size %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(getCount())
            }));
            View view1 = view;
            if (view == null)
            {
                view1 = newView(null, null, viewgroup);
            }
            return view1;
        } else
        {
            return super.getView(i, view, viewgroup);
        }
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return viewFactory.createView(null);
    }

    public void setMediaItemDao(MediaItemDao mediaitemdao)
    {
        mMediaItemDao = mediaitemdao;
    }

    public void setViewFactory(ViewFactory viewfactory)
    {
        viewFactory = viewfactory;
    }
}

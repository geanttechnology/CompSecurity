// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.utils.TimelineMonthResources;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;
import com.amazon.gallery.framework.model.TimelineEntry;

public class DividerViewFactory
    implements ViewFactory
{
    public static class DividerHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        private TimelineEntry entry;
        final TextView monthText;
        final TextView yearText;

        public int getMonth()
        {
            return entry.getMonth();
        }

        public int getYear()
        {
            return entry.getYear();
        }

        void updateEntry(TimelineEntry timelineentry)
        {
            entry = timelineentry;
        }

        public DividerHolder(View view)
        {
            super(view);
            yearText = (TextView)view.findViewById(0x7f0c012b);
            monthText = (TextView)view.findViewById(0x7f0c012c);
        }
    }


    private final Activity activity;
    private int boundingHeight;
    private int boundingWidth;

    public DividerViewFactory(Activity activity1)
    {
        boundingWidth = 1;
        boundingHeight = 1;
        activity = activity1;
    }

    public View createView(TimelineEntry timelineentry)
    {
        timelineentry = LayoutInflater.from(activity).inflate(0x7f03007c, null);
        if (timelineentry.getLayoutParams() != null) goto _L2; else goto _L1
_L1:
        timelineentry.setLayoutParams(new android.view.ViewGroup.LayoutParams(boundingWidth, boundingHeight));
_L4:
        timelineentry.setTag(0x7f0c000e, com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.DIVIDER);
        timelineentry.setTag(new DividerHolder(timelineentry));
        return timelineentry;
_L2:
        if (timelineentry.getLayoutParams().width != boundingWidth || timelineentry.getLayoutParams().height != boundingHeight)
        {
            android.view.ViewGroup.LayoutParams layoutparams = timelineentry.getLayoutParams();
            layoutparams.width = boundingWidth;
            layoutparams.height = boundingHeight;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile View createView(Object obj)
    {
        return createView((TimelineEntry)obj);
    }

    public View getView(int i, TimelineEntry timelineentry, View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = createView(timelineentry);
        }
        view = (DividerHolder)view1.getTag();
        view.updateEntry(timelineentry);
        if (timelineentry.isNoDate())
        {
            ((DividerHolder) (view)).monthText.setText("");
            ((DividerHolder) (view)).yearText.setText(activity.getResources().getString(0x7f0e017e));
        } else
        {
            ((DividerHolder) (view)).yearText.setText(String.valueOf(timelineentry.getYear()));
            String s = activity.getResources().getString(TimelineMonthResources.MONTHS_FULL[timelineentry.getMonth()]);
            ((DividerHolder) (view)).monthText.setText(s);
        }
        view1.setId(timelineentry.getId());
        return view1;
    }

    public volatile View getView(int i, Object obj, View view)
    {
        return getView(i, (TimelineEntry)obj, view);
    }

    public void onViewDestroy(View view)
    {
    }

    public void reset()
    {
    }

    public void setBoundingSize(int i)
    {
        setBoundingSize(i, i);
    }

    public void setBoundingSize(int i, int j)
    {
        boundingWidth = i;
        boundingHeight = j;
    }

    public void setContext(Context context)
    {
    }
}

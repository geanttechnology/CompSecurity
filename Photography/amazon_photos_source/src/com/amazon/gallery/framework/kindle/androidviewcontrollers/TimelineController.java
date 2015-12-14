// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.androidviewcontrollers;

import android.view.View;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewController;
import com.amazon.gallery.framework.gallery.timeline.TimelineNavigator;

public class TimelineController
    implements AndroidViewController
{

    private final TimelineNavigator timelineNavigator;

    public TimelineController(TimelineNavigator timelinenavigator)
    {
        timelineNavigator = timelinenavigator;
    }

    public boolean onClick(View view, int i)
    {
        while (timelineNavigator == null || view.getTag(0x7f0c000e) != com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.DIVIDER) 
        {
            return false;
        }
        if (timelineNavigator.isVisible())
        {
            timelineNavigator.hideTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.TAP_CLOSE);
        } else
        {
            view = (com.amazon.gallery.framework.kindle.widget.DividerViewFactory.DividerHolder)view.getTag();
            timelineNavigator.selectYearAndMonth(view.getYear(), view.getMonth());
            timelineNavigator.showTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.TAP_OPEN);
        }
        return true;
    }

    public boolean onLongClick(View view, int i)
    {
        return false;
    }
}

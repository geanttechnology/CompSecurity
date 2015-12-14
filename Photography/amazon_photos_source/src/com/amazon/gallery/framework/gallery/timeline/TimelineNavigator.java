// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.timeline;

import android.view.ViewGroup;
import android.widget.ListView;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;

public interface TimelineNavigator
    extends com.amazon.gallery.framework.data.model.TimelineModel.ChangeListener
{
    public static interface TimelineClickListener
    {

        public abstract void onTimeNavBarClick(int i, int j);
    }

    public static final class TimelineEvent extends Enum
    {

        private static final TimelineEvent $VALUES[];
        public static final TimelineEvent AUTO_CLOSE;
        public static final TimelineEvent AUTO_OPEN;
        public static final TimelineEvent SWIPE_CLOSE;
        public static final TimelineEvent SWIPE_OPEN;
        public static final TimelineEvent SYSTEM_CLOSE;
        public static final TimelineEvent TAP_CLOSE;
        public static final TimelineEvent TAP_OPEN;

        public static TimelineEvent valueOf(String s)
        {
            return (TimelineEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/timeline/TimelineNavigator$TimelineEvent, s);
        }

        public static TimelineEvent[] values()
        {
            return (TimelineEvent[])$VALUES.clone();
        }

        static 
        {
            SWIPE_OPEN = new TimelineEvent("SWIPE_OPEN", 0);
            TAP_OPEN = new TimelineEvent("TAP_OPEN", 1);
            AUTO_OPEN = new TimelineEvent("AUTO_OPEN", 2);
            SWIPE_CLOSE = new TimelineEvent("SWIPE_CLOSE", 3);
            TAP_CLOSE = new TimelineEvent("TAP_CLOSE", 4);
            SYSTEM_CLOSE = new TimelineEvent("SYSTEM_CLOSE", 5);
            AUTO_CLOSE = new TimelineEvent("AUTO_CLOSE", 6);
            $VALUES = (new TimelineEvent[] {
                SWIPE_OPEN, TAP_OPEN, AUTO_OPEN, SWIPE_CLOSE, TAP_CLOSE, SYSTEM_CLOSE, AUTO_CLOSE
            });
        }

        private TimelineEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void disableTimelineBar();

    public abstract void drag(float f);

    public abstract void enableTimelineBar();

    public abstract void hideTimelineNavigator(TimelineEvent timelineevent);

    public abstract void init(ListView listview);

    public abstract boolean isTimelineInitialized();

    public abstract boolean isVisible();

    public abstract void onScroll(float f, ViewGroup viewgroup);

    public abstract void selectYearAndMonth(int i, int j);

    public abstract void setHasSortChanged(boolean flag);

    public abstract void setScreenHeight(float f);

    public abstract void setTimelineClickListener(TimelineClickListener timelineclicklistener);

    public abstract void setViewDescriptor(ViewDescriptor viewdescriptor);

    public abstract void showTimelineNavigator(TimelineEvent timelineevent);
}

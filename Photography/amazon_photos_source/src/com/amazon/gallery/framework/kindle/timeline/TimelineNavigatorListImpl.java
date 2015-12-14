// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.log.GTrace;
import com.amazon.gallery.framework.gallery.timeline.TimelineNavigator;
import com.amazon.gallery.framework.gallery.utils.TimelineMonthResources;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics;
import com.amazon.gallery.framework.kindle.timeline.model.ExpandableListComponent;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;
import com.amazon.gallery.framework.model.TimelineEntry;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineViewVisitor, TimelineMarkerContainer, TimelineMarker, TimelineListAdapter

public class TimelineNavigatorListImpl
    implements TimelineNavigator
{

    private static final String TAG = com/amazon/gallery/framework/kindle/timeline/TimelineNavigatorListImpl.getName();
    TimelineListAdapter adapter;
    private boolean alwaysOn;
    private Calendar calendar;
    private int currentTopLeftItemMonth;
    private int currentTopLeftItemYear;
    private boolean disableOnScroll;
    private Runnable disableScrollRunnable;
    private Runnable dragSnapRunnable;
    private boolean enabled;
    private boolean hasScrolledLayout;
    private boolean hasScrolledNavigator;
    private boolean hasSortChanged;
    private final Runnable hideTimelineBar = new Runnable() {

        final TimelineNavigatorListImpl this$0;

        public void run()
        {
            timelineBarAnimator.hide();
            visible = false;
        }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                super();
            }
    };
    private com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent hideTimelineEvent;
    private List lastTimelineUpdate;
    private final String monthTitles[];
    private final String noDateTitle;
    private float screenHeight;
    int scrollDistanceCumulative;
    long scrollDistanceStartTime;
    private float scrollPos;
    private ListView timelineBar;
    private final VisibilityAnimator timelineBarAnimator = new VisibilityAnimator() {

        final TimelineNavigatorListImpl this$0;

        protected long getDuration()
        {
            return 375L;
        }

        protected ObjectAnimator getHideAnimator()
        {
            int k = timelineBar.getWidth();
            int j = k;
            if (k == 0)
            {
                timelineBar.measure(0, 0);
                j = timelineBar.getMeasuredWidth();
            }
            ListView listview = timelineBar;
            float f;
            if (j != 0)
            {
                f = j;
            } else
            {
                f = 100F;
            }
            return ObjectAnimator.ofFloat(listview, "translationX", new float[] {
                f
            });
        }

        protected volatile ValueAnimator getHideAnimator()
        {
            return getHideAnimator();
        }

        protected ObjectAnimator getShowAnimator()
        {
            return ObjectAnimator.ofFloat(timelineBar, "translationX", new float[] {
                0.0F
            });
        }

        protected volatile ValueAnimator getShowAnimator()
        {
            return getShowAnimator();
        }

        protected void onHidden()
        {
            super.onHidden();
            timelineBar.setVisibility(8);
            if (timer != null)
            {
                timer.stop();
                timer = null;
            }
            switch (_cls14..SwitchMap.com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent[hideTimelineEvent.ordinal()])
            {
            default:
                return;

            case 4: // '\004'
                timelineMetrics.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineSwipeClose);
                return;

            case 5: // '\005'
                timelineMetrics.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineTapClose);
                return;

            case 6: // '\006'
                timelineMetrics.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineAutoClose);
                break;
            }
        }

        protected void onShown()
        {
            super.onShown();
            if (timer != null)
            {
                timer.start();
            }
        }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                super();
            }
    };
    private com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineClickListener timelineClickListener;
    private TimelineMetrics timelineMetrics;
    private Timer timer;
    private ViewDescriptor viewDescriptor;
    private boolean visible;
    private final TimelineViewVisitor visibleItemsVisitor;

    public TimelineNavigatorListImpl(Context context)
    {
        calendar = Calendar.getInstance();
        alwaysOn = false;
        scrollDistanceCumulative = 0;
        scrollDistanceStartTime = 0L;
        screenHeight = -1F;
        hasScrolledLayout = false;
        hasScrolledNavigator = false;
        enabled = false;
        visible = false;
        disableOnScroll = false;
        hideTimelineEvent = com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.SYSTEM_CLOSE;
        currentTopLeftItemYear = -1;
        currentTopLeftItemMonth = -1;
        hasSortChanged = false;
        dragSnapRunnable = new Runnable() {

            final TimelineNavigatorListImpl this$0;

            public void run()
            {
                float f = timelineBar.getTranslationX();
                if (f > 0.0F && f <= (float)(timelineBar.getWidth() / 2) && !visible)
                {
                    timelineBarAnimator.cancel();
                    showTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.SWIPE_OPEN);
                } else
                if (f < (float)timelineBar.getWidth() && f > (float)(timelineBar.getWidth() / 2) && visible)
                {
                    timelineBarAnimator.cancel();
                    hideTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.SWIPE_CLOSE);
                    return;
                }
            }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                super();
            }
        };
        disableScrollRunnable = new Runnable() {

            final TimelineNavigatorListImpl this$0;

            public void run()
            {
                disableOnScroll = false;
            }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                super();
            }
        };
        visibleItemsVisitor = new TimelineViewVisitor(getNumColumns(context));
        noDateTitle = context.getResources().getString(0x7f0e017e);
        monthTitles = new String[TimelineMonthResources.MONTHS_ABBR.length];
        for (int i = 0; i < monthTitles.length; i++)
        {
            monthTitles[i] = context.getResources().getString(TimelineMonthResources.MONTHS_ABBR[i]);
        }

    }

    private void findCollectionTypeAndLogMetric()
    {
        static class _cls14
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[];
            static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_PROPERTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_TYPE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.CUSTOM_DATA_SET.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent = new int[com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.AUTO_OPEN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.SWIPE_OPEN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.TAP_OPEN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.SWIPE_CLOSE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.TAP_CLOSE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$timeline$TimelineNavigator$TimelineEvent[com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.AUTO_CLOSE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls14..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[viewDescriptor.getCollectionType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            timelineMetrics.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineMonthTapAllView);
            return;

        case 2: // '\002'
            timelineMetrics.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineMonthTapCameraRoll);
            return;

        case 3: // '\003'
            timelineMetrics.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineMonthTapVideoView);
            return;

        case 4: // '\004'
            timelineMetrics.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineMonthTapCollection);
            break;
        }
    }

    private int getNumColumns(Context context)
    {
        return context.getResources().getInteger(0x7f0d0001);
    }

    private void initAdapter(List list)
    {
        Object obj = list;
        if (list == null)
        {
            obj = Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        list = null;
        int k = -1;
        int j = 0;
        int i = 0;
        obj = ((List) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            TimelineEntry timelineentry = (TimelineEntry)((Iterator) (obj)).next();
            int i1 = timelineentry.getYear();
            int j1 = timelineentry.getMonth();
            int l = k;
            if (i1 != k)
            {
                l = i1;
                if (timelineentry.isNoDate())
                {
                    list = new TimelineMarkerContainer(noDateTitle, j, i);
                } else
                {
                    list = new TimelineMarkerContainer(Integer.toString(i1), j, i, i1);
                }
                arraylist.add(list);
            }
            if (!timelineentry.isNoDate() && list != null)
            {
                list.addMarker(new TimelineMarker(monthTitles[j1], j, i, i1, j1));
            }
            j += timelineentry.getCount();
            i = timelineentry.getCount() + i + 1;
            k = l;
        }
        adapter.setData(arraylist);
    }

    private boolean isInSingleView()
    {
        return viewDescriptor != null && viewDescriptor.getMediaItem() != null;
    }

    private void resetHideTimer()
    {
        this;
        JVM INSTR monitorenter ;
        GLogger.d(TAG, "Removed callbacks on hiding timeline bar", new Object[0]);
        timelineBar.removeCallbacks(hideTimelineBar);
        if (hasScrolledLayout && !alwaysOn)
        {
            GLogger.d(TAG, "Hiding Timeline Bar in %d ms!", new Object[] {
                Integer.valueOf(5000)
            });
            hideTimelineEvent = com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.AUTO_CLOSE;
            timelineBar.postDelayed(hideTimelineBar, 5000L);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void updateHighlight(final int yearFocused, final int scrollOffset, final boolean expandHighlight)
    {
        this;
        JVM INSTR monitorenter ;
        final long highlightDate = visibleItemsVisitor.getDate();
        if (highlightDate > 0L) goto _L2; else goto _L1
_L1:
        final int topLeftItemYear;
        final int topLeftItemMonth;
        topLeftItemYear = 0;
        topLeftItemMonth = 0;
_L4:
        if (topLeftItemMonth != currentTopLeftItemMonth || topLeftItemYear != currentTopLeftItemYear)
        {
            currentTopLeftItemMonth = topLeftItemMonth;
            currentTopLeftItemYear = topLeftItemYear;
            timelineBar.post(new Runnable() {

                final TimelineNavigatorListImpl this$0;
                final boolean val$expandHighlight;
                final long val$highlightDate;
                final int val$scrollOffset;
                final int val$topLeftItemMonth;
                final int val$topLeftItemYear;
                final int val$yearFocused;

                public void run()
                {
                    if (adapter == null)
                    {
                        return;
                    }
                    if (expandHighlight)
                    {
                        adapter.expandYear(topLeftItemYear);
                    }
                    Integer integer;
                    if (highlightDate == -1L)
                    {
                        adapter.collapseAll();
                    } else
                    {
                        adapter.highlightDate(topLeftItemYear, topLeftItemMonth);
                    }
                    integer = adapter.getYearIndex(yearFocused);
                    if (integer == null)
                    {
                        updateTimelineScrollPosition(adapter.getActiveContainerIndex(), 15);
                        return;
                    } else
                    {
                        updateTimelineScrollPosition(integer.intValue(), scrollOffset);
                        return;
                    }
                }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                expandHighlight = flag;
                topLeftItemYear = i;
                highlightDate = l;
                topLeftItemMonth = j;
                yearFocused = k;
                scrollOffset = i1;
                super();
            }
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        calendar.setTimeInMillis(highlightDate);
        topLeftItemYear = calendar.get(1);
        topLeftItemMonth = calendar.get(2);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void updateTimelineScrollPosition(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        TimelineListAdapter timelinelistadapter = adapter;
          goto _L1
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L1:
        if (timelinelistadapter == null || i < 0) goto _L3; else goto _L2
_L2:
        timelineBar.setSelectionFromTop(i, j);
        if (true) goto _L3; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void disableTimelineBar()
    {
        this;
        JVM INSTR monitorenter ;
        ListView listview;
        enabled = false;
        listview = timelineBar;
        if (listview != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        timelineBar.post(new Runnable() {

            final TimelineNavigatorListImpl this$0;

            public void run()
            {
                timelineBarAnimator.hide();
            }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                super();
            }
        });
        visibleItemsVisitor.reset();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void drag(float f)
    {
        if (enabled)
        {
            int i = timelineBar.getWidth();
            if (i != 0)
            {
                float f1 = timelineBar.getTranslationX() + f;
                f = f1;
                if (f1 < 0.0F)
                {
                    f = 0.0F;
                }
                f1 = f;
                if (f > (float)i)
                {
                    f1 = i;
                }
                if (f1 != timelineBar.getTranslationX())
                {
                    timelineBar.setVisibility(0);
                    timelineBar.setTranslationX(f1);
                    timelineBar.removeCallbacks(dragSnapRunnable);
                    timelineBar.postDelayed(dragSnapRunnable, 150L);
                    return;
                }
            }
        }
    }

    public void enableTimelineBar()
    {
        this;
        JVM INSTR monitorenter ;
        ListView listview;
        enabled = true;
        listview = timelineBar;
        if (listview != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        timelineBar.setPadding(0, 0, 0, 0);
        updateHighlight();
        if (alwaysOn)
        {
            showTimelineNavigator(null);
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void hideTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent timelineevent)
    {
        if (timelineevent == com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.SYSTEM_CLOSE || !alwaysOn)
        {
            hideTimelineEvent = timelineevent;
            if (timelineBar != null)
            {
                timelineBar.removeCallbacks(hideTimelineBar);
                timelineBar.post(hideTimelineBar);
                return;
            }
        }
    }

    public void init(final ListView timelineBar)
    {
        if (timelineBar == null)
        {
            enabled = false;
        } else
        {
            this.timelineBar = timelineBar;
            adapter = new TimelineListAdapter(timelineBar.getContext());
            ((Activity)timelineBar.getContext()).runOnUiThread(new Runnable() {

                final TimelineNavigatorListImpl this$0;
                final ListView val$timelineBar;

                public void run()
                {
                    timelineBar.setAdapter(adapter);
                }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                timelineBar = listview;
                super();
            }
            });
            timelineBar.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final TimelineNavigatorListImpl this$0;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    onTimeNavBarClick(i, (ExpandableListComponent)adapterview.getItemAtPosition(i));
                }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                super();
            }
            });
            timelineBar.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

                final TimelineNavigatorListImpl this$0;

                public void onScroll(AbsListView abslistview, int i, int j, int k)
                {
                }

                public void onScrollStateChanged(AbsListView abslistview, int i)
                {
                    if (i != 0)
                    {
                        hasScrolledNavigator = true;
                    }
                }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                super();
            }
            });
            timelineBar.setOnTouchListener(new android.view.View.OnTouchListener() {

                final TimelineNavigatorListImpl this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (isInSingleView())
                    {
                        resetHideTimer();
                    }
                    return false;
                }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                super();
            }
            });
            timelineBarAnimator.setView(timelineBar);
            if (lastTimelineUpdate != null)
            {
                onTimelineChanged(lastTimelineUpdate);
                return;
            }
        }
    }

    public boolean isTimelineInitialized()
    {
        return timelineBar != null;
    }

    public boolean isVisible()
    {
        return visible;
    }

    public void onScroll(float f, ViewGroup viewgroup)
    {
        this;
        JVM INSTR monitorenter ;
        if (!enabled) goto _L2; else goto _L1
_L1:
        boolean flag = disableOnScroll;
        if (!flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        GTrace.beginSection(com.amazon.gallery.foundation.utils.log.GTrace.TraceType.Controller, "TimelineNavigatorListImpl#onScroll");
        if (scrollDistanceStartTime == 0L)
        {
            scrollDistanceStartTime = SystemClock.uptimeMillis();
        }
        if (SystemClock.uptimeMillis() - scrollDistanceStartTime > 1500L)
        {
            scrollDistanceCumulative = 0;
            scrollDistanceStartTime = SystemClock.uptimeMillis();
        }
        scrollDistanceCumulative = (int)((float)scrollDistanceCumulative + Math.abs(scrollPos - f));
        scrollPos = f;
        if ((float)scrollDistanceCumulative > screenHeight / 2.0F)
        {
            hasScrolledLayout = true;
        }
        if ((float)scrollDistanceCumulative > screenHeight * 3F)
        {
            showTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.AUTO_OPEN);
            scrollDistanceCumulative = 0;
        }
        hasScrolledNavigator = false;
        flag = false;
        visibleItemsVisitor.reset();
        int i = 0;
_L5:
        if (i >= viewgroup.getChildCount() || flag)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = visibleItemsVisitor.visit(viewgroup.getChildAt(i));
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        updateHighlight();
        resetHideTimer();
        GTrace.endSection(com.amazon.gallery.foundation.utils.log.GTrace.TraceType.Controller);
        if (true) goto _L2; else goto _L6
_L6:
        viewgroup;
        throw viewgroup;
    }

    void onTimeNavBarClick(int i, ExpandableListComponent expandablelistcomponent)
    {
        if (expandablelistcomponent instanceof TimelineMarker)
        {
            expandablelistcomponent = (TimelineMarker)expandablelistcomponent;
            GLogger.d(TAG, "Clicked %s", new Object[] {
                expandablelistcomponent.getLabel()
            });
            if (expandablelistcomponent instanceof TimelineMarkerContainer)
            {
                List list = ((TimelineMarkerContainer)expandablelistcomponent).getSubItems();
                if (list.isEmpty())
                {
                    i = -1;
                } else
                {
                    i = ((TimelineMarker)list.get(0)).getMonth();
                }
            } else
            {
                i = expandablelistcomponent.getMonth();
            }
            if (adapter != null)
            {
                adapter.expandYear(expandablelistcomponent.getYear());
                adapter.highlightDate(expandablelistcomponent.getYear(), i);
                findCollectionTypeAndLogMetric();
                updateTimelineScrollPosition(adapter.getActiveContainerIndex(), 15);
            }
            if (timelineClickListener != null)
            {
                i = expandablelistcomponent.getTag().intValue();
                if (i >= 0)
                {
                    timelineClickListener.onTimeNavBarClick(i, expandablelistcomponent.getGridIndex());
                }
            }
        }
    }

    public void onTimelineChanged(final List timeline)
    {
        byte byte0 = -1;
        if (adapter != null)
        {
            lastTimelineUpdate = timeline;
            byte byte2 = -1;
            byte byte1 = 15;
            final int topOffset = byte1;
            final int topYear = byte2;
            if (!hasSortChanged)
            {
                topOffset = byte1;
                topYear = byte2;
                if (hasScrolledNavigator)
                {
                    topOffset = byte1;
                    topYear = byte2;
                    if (adapter.getCount() > 0)
                    {
                        topOffset = byte1;
                        topYear = byte2;
                        if (timelineBar.getChildCount() > 0)
                        {
                            topYear = timelineBar.getFirstVisiblePosition();
                            if (adapter.getItem(topYear) instanceof TimelineMarkerContainer)
                            {
                                topOffset = timelineBar.getChildAt(0).getTop() - timelineBar.getListPaddingTop();
                            } else
                            {
                                topYear = adapter.containerToListIndex(Integer.valueOf(adapter.getActiveContainerIndex() + 1));
                                topOffset = topYear - timelineBar.getFirstVisiblePosition();
                                if (topOffset < timelineBar.getChildCount())
                                {
                                    topOffset = timelineBar.getChildAt(topOffset).getTop() - timelineBar.getListPaddingTop();
                                } else
                                {
                                    GLogger.w(TAG, "next year index is not visible, resetting list", new Object[0]);
                                    topYear = -1;
                                    topOffset = byte1;
                                }
                            }
                        }
                    }
                }
            }
            if (topYear == -1)
            {
                topYear = byte0;
            } else
            {
                topYear = ((TimelineMarkerContainer)adapter.getItem(topYear)).getYear();
            }
            hasSortChanged = false;
            if (timelineBar != null)
            {
                ((Activity)timelineBar.getContext()).runOnUiThread(new Runnable() {

                    final TimelineNavigatorListImpl this$0;
                    final List val$timeline;
                    final int val$topOffset;
                    final int val$topYear;

                    public void run()
                    {
                        int i = adapter.getActiveContainerIndex();
                        initAdapter(timeline);
                        currentTopLeftItemMonth = -1;
                        currentTopLeftItemYear = -1;
                        TimelineNavigatorListImpl timelinenavigatorlistimpl = TimelineNavigatorListImpl.this;
                        int j = topYear;
                        int k = topOffset;
                        boolean flag;
                        if (i == -1)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        timelinenavigatorlistimpl.updateHighlight(j, k, flag);
                    }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                timeline = list;
                topYear = i;
                topOffset = j;
                super();
            }
                });
                return;
            }
        }
    }

    public void selectYearAndMonth(final int year, final int month)
    {
        timelineBar.post(new Runnable() {

            final TimelineNavigatorListImpl this$0;
            final int val$month;
            final int val$year;

            public void run()
            {
                if (adapter == null)
                {
                    return;
                } else
                {
                    adapter.expandYear(year);
                    adapter.highlightDate(year, month);
                    updateTimelineScrollPosition(adapter.getActiveContainerIndex(), 15);
                    return;
                }
            }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                year = i;
                month = j;
                super();
            }
        });
    }

    public void setHasSortChanged(boolean flag)
    {
        hasSortChanged = flag;
    }

    public void setScreenHeight(float f)
    {
        screenHeight = f;
    }

    public void setTimelineClickListener(com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineClickListener timelineclicklistener)
    {
        timelineClickListener = timelineclicklistener;
    }

    public void setTimelineMetrics(TimelineMetrics timelinemetrics)
    {
        timelineMetrics = timelinemetrics;
    }

    public void setViewDescriptor(ViewDescriptor viewdescriptor)
    {
        viewDescriptor = viewdescriptor;
        visibleItemsVisitor.setSortType(viewdescriptor.getMediaItemSortType());
    }

    public void showTimelineNavigator(final com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent showTimelineEvent)
    {
        if (enabled)
        {
            updateHighlight();
            timelineBar.post(new Runnable() {

                final TimelineNavigatorListImpl this$0;
                final com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent val$showTimelineEvent;

                public void run()
                {
                    boolean flag = true;
                    if (alwaysOn || timer != null) goto _L2; else goto _L1
_L1:
                    Object obj = null;
                    _cls14..SwitchMap.com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent[showTimelineEvent.ordinal()];
                    JVM INSTR tableswitch 1 3: default 60
                //                               1 141
                //                               2 148
                //                               3 155;
                       goto _L3 _L4 _L5 _L6
_L3:
                    if (obj != null)
                    {
                        timer = timelineMetrics.newTimer(((Enum) (obj)));
                    }
_L2:
                    timelineBarAnimator.show();
                    visible = true;
                    obj = TimelineNavigatorListImpl.this;
                    if (!hasScrolledLayout || com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.AUTO_OPEN != showTimelineEvent)
                    {
                        flag = false;
                    }
                    obj.hasScrolledLayout = flag;
                    resetHideTimer();
                    return;
_L4:
                    obj = com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineAutoOpen;
                    continue; /* Loop/switch isn't completed */
_L5:
                    obj = com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineSwipeOpen;
                    continue; /* Loop/switch isn't completed */
_L6:
                    obj = com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics.MetricsEvent.TimelineTapOpen;
                    if (true) goto _L3; else goto _L7
_L7:
                }

            
            {
                this$0 = TimelineNavigatorListImpl.this;
                showTimelineEvent = timelineevent;
                super();
            }
            });
        }
    }

    public void updateHighlight()
    {
        updateHighlight(-1, 15, true);
    }





/*
    static boolean access$1002(TimelineNavigatorListImpl timelinenavigatorlistimpl, boolean flag)
    {
        timelinenavigatorlistimpl.disableOnScroll = flag;
        return flag;
    }

*/


/*
    static boolean access$102(TimelineNavigatorListImpl timelinenavigatorlistimpl, boolean flag)
    {
        timelinenavigatorlistimpl.visible = flag;
        return flag;
    }

*/




/*
    static int access$1302(TimelineNavigatorListImpl timelinenavigatorlistimpl, int i)
    {
        timelinenavigatorlistimpl.currentTopLeftItemMonth = i;
        return i;
    }

*/


/*
    static int access$1402(TimelineNavigatorListImpl timelinenavigatorlistimpl, int i)
    {
        timelinenavigatorlistimpl.currentTopLeftItemYear = i;
        return i;
    }

*/




/*
    static boolean access$202(TimelineNavigatorListImpl timelinenavigatorlistimpl, boolean flag)
    {
        timelinenavigatorlistimpl.hasScrolledNavigator = flag;
        return flag;
    }

*/







/*
    static Timer access$702(TimelineNavigatorListImpl timelinenavigatorlistimpl, Timer timer1)
    {
        timelinenavigatorlistimpl.timer = timer1;
        return timer1;
    }

*/




/*
    static boolean access$902(TimelineNavigatorListImpl timelinenavigatorlistimpl, boolean flag)
    {
        timelinenavigatorlistimpl.hasScrolledLayout = flag;
        return flag;
    }

*/
}

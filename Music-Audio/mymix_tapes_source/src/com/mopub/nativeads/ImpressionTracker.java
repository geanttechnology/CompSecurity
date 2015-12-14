// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.nativeads:
//            VisibilityTracker, ImpressionInterface, TimestampWrapper

public class ImpressionTracker
{
    class PollingRunnable
        implements Runnable
    {

        private final ArrayList mRemovedViews = new ArrayList();
        final ImpressionTracker this$0;

        public void run()
        {
            Iterator iterator = mPollingViews.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                View view = (View)((java.util.Map.Entry) (obj)).getKey();
                obj = (TimestampWrapper)((java.util.Map.Entry) (obj)).getValue();
                if (mVisibilityChecker.hasRequiredTimeElapsed(((TimestampWrapper) (obj)).mCreatedTimestamp, ((ImpressionInterface)((TimestampWrapper) (obj)).mInstance).getImpressionMinTimeViewed()))
                {
                    ((ImpressionInterface)((TimestampWrapper) (obj)).mInstance).recordImpression(view);
                    ((ImpressionInterface)((TimestampWrapper) (obj)).mInstance).setImpressionRecorded();
                    mRemovedViews.add(view);
                }
            } while (true);
            View view1;
            for (Iterator iterator1 = mRemovedViews.iterator(); iterator1.hasNext(); removeView(view1))
            {
                view1 = (View)iterator1.next();
            }

            mRemovedViews.clear();
            if (!mPollingViews.isEmpty())
            {
                scheduleNextPoll();
            }
        }

        PollingRunnable()
        {
            this$0 = ImpressionTracker.this;
            super();
        }
    }


    private static final int PERIOD = 250;
    private final Handler mPollHandler;
    private final PollingRunnable mPollingRunnable;
    private final Map mPollingViews;
    private final Map mTrackedViews;
    private final VisibilityTracker.VisibilityChecker mVisibilityChecker;
    private final VisibilityTracker mVisibilityTracker;
    private VisibilityTracker.VisibilityTrackerListener mVisibilityTrackerListener = new VisibilityTracker.VisibilityTrackerListener() {

        final ImpressionTracker this$0;

        public void onVisibilityChanged(List list, List list1)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                View view = (View)list.next();
                ImpressionInterface impressioninterface = (ImpressionInterface)mTrackedViews.get(view);
                if (impressioninterface == null)
                {
                    removeView(view);
                } else
                {
                    TimestampWrapper timestampwrapper = (TimestampWrapper)mPollingViews.get(view);
                    if (timestampwrapper == null || !impressioninterface.equals(timestampwrapper.mInstance))
                    {
                        mPollingViews.put(view, new TimestampWrapper(impressioninterface));
                    }
                }
            } while (true);
            for (list = list1.iterator(); list.hasNext(); mPollingViews.remove(list1))
            {
                list1 = (View)list.next();
            }

            scheduleNextPoll();
        }

            
            {
                this$0 = ImpressionTracker.this;
                super();
            }
    };

    public ImpressionTracker(Context context)
    {
        this(((Map) (new WeakHashMap())), ((Map) (new WeakHashMap())), new VisibilityTracker.VisibilityChecker(), new VisibilityTracker(context), new Handler(Looper.getMainLooper()));
    }

    ImpressionTracker(Map map, Map map1, VisibilityTracker.VisibilityChecker visibilitychecker, VisibilityTracker visibilitytracker, Handler handler)
    {
        mTrackedViews = map;
        mPollingViews = map1;
        mVisibilityChecker = visibilitychecker;
        mVisibilityTracker = visibilitytracker;
        mVisibilityTracker.setVisibilityTrackerListener(mVisibilityTrackerListener);
        mPollHandler = handler;
        mPollingRunnable = new PollingRunnable();
    }

    private void removePollingView(View view)
    {
        mPollingViews.remove(view);
    }

    public void addView(View view, ImpressionInterface impressioninterface)
    {
        if (mTrackedViews.get(view) != impressioninterface)
        {
            removeView(view);
            if (!impressioninterface.isImpressionRecorded())
            {
                mTrackedViews.put(view, impressioninterface);
                mVisibilityTracker.addView(view, impressioninterface.getImpressionMinPercentageViewed());
                return;
            }
        }
    }

    public void clear()
    {
        mTrackedViews.clear();
        mPollingViews.clear();
        mVisibilityTracker.clear();
        mPollHandler.removeMessages(0);
    }

    public void destroy()
    {
        clear();
        mVisibilityTracker.destroy();
        mVisibilityTrackerListener = null;
    }

    VisibilityTracker.VisibilityTrackerListener getVisibilityTrackerListener()
    {
        return mVisibilityTrackerListener;
    }

    public void removeView(View view)
    {
        mTrackedViews.remove(view);
        removePollingView(view);
        mVisibilityTracker.removeView(view);
    }

    void scheduleNextPoll()
    {
        if (mPollHandler.hasMessages(0))
        {
            return;
        } else
        {
            mPollHandler.postDelayed(mPollingRunnable, 250L);
            return;
        }
    }



}

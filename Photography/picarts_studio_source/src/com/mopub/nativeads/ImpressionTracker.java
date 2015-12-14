// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.nativeads:
//            VisibilityTracker, NativeResponse, TimestampWrapper

class ImpressionTracker
{

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
                NativeResponse nativeresponse = (NativeResponse)mTrackedViews.get(view);
                if (nativeresponse == null)
                {
                    removeView(view);
                } else
                {
                    TimestampWrapper timestampwrapper = (TimestampWrapper)mPollingViews.get(view);
                    if (timestampwrapper == null || !nativeresponse.equals(timestampwrapper.mInstance))
                    {
                        mPollingViews.put(view, new TimestampWrapper(nativeresponse));
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

    ImpressionTracker(Context context)
    {
        this(((Map) (new WeakHashMap())), ((Map) (new WeakHashMap())), new VisibilityTracker.VisibilityChecker(), new VisibilityTracker(context), new Handler());
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

    void addView(View view, NativeResponse nativeresponse)
    {
        if (mTrackedViews.get(view) != nativeresponse)
        {
            removeView(view);
            if (!nativeresponse.getRecordedImpression() && !nativeresponse.isDestroyed())
            {
                mTrackedViews.put(view, nativeresponse);
                mVisibilityTracker.addView(view, nativeresponse.getImpressionMinPercentageViewed());
                return;
            }
        }
    }

    void clear()
    {
        mTrackedViews.clear();
        mPollingViews.clear();
        mVisibilityTracker.clear();
        mPollHandler.removeMessages(0);
    }

    void destroy()
    {
        clear();
        mVisibilityTracker.destroy();
        mVisibilityTrackerListener = null;
    }

    VisibilityTracker.VisibilityTrackerListener getVisibilityTrackerListener()
    {
        return mVisibilityTrackerListener;
    }

    void removeView(View view)
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




    private class PollingRunnable
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
                if (mVisibilityChecker.hasRequiredTimeElapsed(((TimestampWrapper) (obj)).mCreatedTimestamp, ((NativeResponse)((TimestampWrapper) (obj)).mInstance).getImpressionMinTimeViewed()))
                {
                    ((NativeResponse)((TimestampWrapper) (obj)).mInstance).recordImpression(view);
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

}

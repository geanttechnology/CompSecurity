// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class VisibilityTracker
{

    static final int NUM_ACCESSES_BEFORE_TRIMMING = 50;
    private static final int VISIBILITY_THROTTLE_MILLIS = 100;
    private long mAccessCounter;
    private boolean mIsVisibilityScheduled;
    android.view.ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    final WeakReference mRootView;
    private final Map mTrackedViews;
    private final ArrayList mTrimmedViews;
    private final VisibilityChecker mVisibilityChecker;
    private final Handler mVisibilityHandler;
    private final VisibilityRunnable mVisibilityRunnable;
    private VisibilityTrackerListener mVisibilityTrackerListener;

    public VisibilityTracker(Context context)
    {
        this(context, ((Map) (new WeakHashMap(10))), new VisibilityChecker(), new Handler());
    }

    VisibilityTracker(Context context, Map map, VisibilityChecker visibilitychecker, Handler handler)
    {
        mAccessCounter = 0L;
        mTrackedViews = map;
        mVisibilityChecker = visibilitychecker;
        mVisibilityHandler = handler;
        mVisibilityRunnable = new VisibilityRunnable();
        mTrimmedViews = new ArrayList(50);
        context = ((Activity)context).getWindow().getDecorView();
        mRootView = new WeakReference(context);
        context = context.getViewTreeObserver();
        if (!context.isAlive())
        {
            MoPubLog.w("Visibility Tracker was unable to track views because the root view tree observer was not alive");
            return;
        } else
        {
            mOnPreDrawListener = new android.view.ViewTreeObserver.OnPreDrawListener() {

                final VisibilityTracker this$0;

                public boolean onPreDraw()
                {
                    scheduleVisibilityCheck();
                    return true;
                }

            
            {
                this$0 = VisibilityTracker.this;
                super();
            }
            };
            context.addOnPreDrawListener(mOnPreDrawListener);
            return;
        }
    }

    private void trimTrackedViews(long l)
    {
        Iterator iterator = mTrackedViews.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((TrackingInfo)entry.getValue()).mAccessOrder < l)
            {
                mTrimmedViews.add(entry.getKey());
            }
        } while (true);
        for (Iterator iterator1 = mTrimmedViews.iterator(); iterator1.hasNext(); removeView((View)iterator1.next())) { }
        mTrimmedViews.clear();
    }

    public void addView(View view, int i)
    {
        TrackingInfo trackinginfo1 = (TrackingInfo)mTrackedViews.get(view);
        TrackingInfo trackinginfo = trackinginfo1;
        if (trackinginfo1 == null)
        {
            trackinginfo = new TrackingInfo();
            mTrackedViews.put(view, trackinginfo);
            scheduleVisibilityCheck();
        }
        trackinginfo.mMinViewablePercent = i;
        trackinginfo.mAccessOrder = mAccessCounter;
        mAccessCounter = mAccessCounter + 1L;
        if (mAccessCounter % 50L == 0L)
        {
            trimTrackedViews(mAccessCounter - 50L);
        }
    }

    void clear()
    {
        mTrackedViews.clear();
        mVisibilityHandler.removeMessages(0);
        mIsVisibilityScheduled = false;
    }

    public void destroy()
    {
        clear();
        Object obj = (View)mRootView.get();
        if (obj != null && mOnPreDrawListener != null)
        {
            obj = ((View) (obj)).getViewTreeObserver();
            if (((ViewTreeObserver) (obj)).isAlive())
            {
                ((ViewTreeObserver) (obj)).removeOnPreDrawListener(mOnPreDrawListener);
            }
            mOnPreDrawListener = null;
        }
        mVisibilityTrackerListener = null;
    }

    void removeView(View view)
    {
        mTrackedViews.remove(view);
    }

    void scheduleVisibilityCheck()
    {
        if (mIsVisibilityScheduled)
        {
            return;
        } else
        {
            mIsVisibilityScheduled = true;
            mVisibilityHandler.postDelayed(mVisibilityRunnable, 100L);
            return;
        }
    }

    public void setVisibilityTrackerListener(VisibilityTrackerListener visibilitytrackerlistener)
    {
        mVisibilityTrackerListener = visibilitytrackerlistener;
    }


/*
    static boolean access$002(VisibilityTracker visibilitytracker, boolean flag)
    {
        visibilitytracker.mIsVisibilityScheduled = flag;
        return flag;
    }

*/




    private class VisibilityChecker
    {

        private final Rect mClipRect = new Rect();

        boolean hasRequiredTimeElapsed(long l, int i)
        {
            return SystemClock.uptimeMillis() - l >= (long)i;
        }

        boolean isVisible(View view, int i)
        {
            if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.getGlobalVisibleRect(mClipRect))
            {
                long l = mClipRect.height();
                long l1 = mClipRect.width();
                long l2 = (long)view.getHeight() * (long)view.getWidth();
                if (l2 > 0L && l * l1 * 100L >= l2 * (long)i)
                {
                    return true;
                }
            }
            return false;
        }

        VisibilityChecker()
        {
        }
    }


    private class VisibilityRunnable
        implements Runnable
    {

        private final ArrayList mInvisibleViews = new ArrayList();
        private final ArrayList mVisibleViews = new ArrayList();
        final VisibilityTracker this$0;

        public void run()
        {
            mIsVisibilityScheduled = false;
            for (Iterator iterator = mTrackedViews.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                View view = (View)entry.getKey();
                int i = ((TrackingInfo)entry.getValue()).mMinViewablePercent;
                if (mVisibilityChecker.isVisible(view, i))
                {
                    mVisibleViews.add(view);
                } else
                {
                    mInvisibleViews.add(view);
                }
            }

            if (mVisibilityTrackerListener != null)
            {
                mVisibilityTrackerListener.onVisibilityChanged(mVisibleViews, mInvisibleViews);
            }
            mVisibleViews.clear();
            mInvisibleViews.clear();
        }

        VisibilityRunnable()
        {
            this$0 = VisibilityTracker.this;
            super();
        }

        private class VisibilityTrackerListener
        {

            public abstract void onVisibilityChanged(List list, List list1);
        }

    }


    private class TrackingInfo
    {

        long mAccessOrder;
        int mMinViewablePercent;

        TrackingInfo()
        {
        }
    }

}

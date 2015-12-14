// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

class VisibilityTracker
{
    static class TrackingInfo
    {

        long mAccessOrder;
        int mMaxInvisiblePercent;
        int mMinViewablePercent;
        View mRootView;

        TrackingInfo()
        {
        }
    }

    static class VisibilityChecker
    {

        private final Rect mClipRect = new Rect();

        boolean hasRequiredTimeElapsed(long l, int i)
        {
            return SystemClock.uptimeMillis() - l >= (long)i;
        }

        boolean isVisible(View view, View view1, int i)
        {
            if (view1 != null && view1.getVisibility() == 0 && view.getParent() != null && view1.getGlobalVisibleRect(mClipRect))
            {
                long l = mClipRect.height();
                long l1 = mClipRect.width();
                long l2 = (long)view1.getHeight() * (long)view1.getWidth();
                if (l2 > 0L && 100L * (l * l1) >= (long)i * l2)
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

    class VisibilityRunnable
        implements Runnable
    {

        private final ArrayList mInvisibleViews = new ArrayList();
        private final ArrayList mVisibleViews = new ArrayList();
        final VisibilityTracker this$0;

        public void run()
        {
            mIsVisibilityScheduled = false;
            Iterator iterator = mTrackedViews.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                View view = (View)((java.util.Map.Entry) (obj)).getKey();
                int i = ((TrackingInfo)((java.util.Map.Entry) (obj)).getValue()).mMinViewablePercent;
                int j = ((TrackingInfo)((java.util.Map.Entry) (obj)).getValue()).mMaxInvisiblePercent;
                obj = ((TrackingInfo)((java.util.Map.Entry) (obj)).getValue()).mRootView;
                if (mVisibilityChecker.isVisible(((View) (obj)), view, i))
                {
                    mVisibleViews.add(view);
                } else
                if (!mVisibilityChecker.isVisible(((View) (obj)), view, j))
                {
                    mInvisibleViews.add(view);
                }
            } while (true);
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
    }

    static interface VisibilityTrackerListener
    {

        public abstract void onVisibilityChanged(List list, List list1);
    }


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

    void addView(View view, int i)
    {
        addView(view, view, i);
    }

    void addView(View view, View view1, int i)
    {
        addView(view, view1, i, i);
    }

    void addView(View view, View view1, int i, int j)
    {
        TrackingInfo trackinginfo1 = (TrackingInfo)mTrackedViews.get(view1);
        TrackingInfo trackinginfo = trackinginfo1;
        if (trackinginfo1 == null)
        {
            trackinginfo = new TrackingInfo();
            mTrackedViews.put(view1, trackinginfo);
            scheduleVisibilityCheck();
        }
        j = Math.min(j, i);
        trackinginfo.mRootView = view;
        trackinginfo.mMinViewablePercent = i;
        trackinginfo.mMaxInvisiblePercent = j;
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

    void destroy()
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

    void setVisibilityTrackerListener(VisibilityTrackerListener visibilitytrackerlistener)
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



}

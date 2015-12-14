// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.ActivityListenerManager;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal.utils:
//            ViewUtils

public static class checkViewable
    implements android.view.tener, android.view.tener, android.view.ner
{

    volatile com.millennialmedia.internal.ityListener activityListener;
    Rect clipRect;
    volatile com.millennialmedia.internal.ycleState lifecycleState;
    volatile  listener;
    volatile boolean listeningToActivity;
    int minViewabilityPercent;
    volatile boolean observingViewTree;
    volatile WeakReference viewRef;
    public volatile boolean viewable;
    volatile boolean watching;

    private void addObserver(View view)
    {
        if (observingViewTree)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ViewUtils.access$000(), "Trying to set view tree observer when already set");
            }
        } else
        {
            ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
            if (viewtreeobserver.isAlive())
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("Adding ViewTreeObserver.\n\tViewability watcher: ").append(this).append("\n\tViewTreeObserver: ").append(viewtreeobserver).append("\n\tView: ").append(view).toString());
                }
                viewtreeobserver.addOnPreDrawListener(this);
                observingViewTree = true;
                return;
            }
        }
    }

    private void checkViewable()
    {
        boolean flag1 = false;
        View view = (View)viewRef.get();
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (lifecycleState == com.millennialmedia.internal.ycleState.RESUMED)
            {
                flag = flag1;
                if (view.isShown())
                {
                    flag = flag1;
                    if (view.getGlobalVisibleRect(clipRect))
                    {
                        long l = clipRect.height() * clipRect.width();
                        long l1 = view.getHeight() * view.getWidth();
                        flag = flag1;
                        if (l1 > 0L)
                        {
                            if ((100L * l) / l1 >= (long)minViewabilityPercent)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
        if (viewable != flag)
        {
            viewable = flag;
            if (listener != null)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("Notifying listener of viewability change.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(view).append("\n\tViewable: ").append(viewable).toString());
                }
                listener.onViewableChanged(viewable);
            }
        }
    }

    private void listenToActivity(View view, boolean flag)
    {
        view = ViewUtils.getActivityForView(view);
        if (view == null)
        {
            return;
        }
        if (!flag || listeningToActivity) goto _L2; else goto _L1
_L1:
        ActivityListenerManager.registerListener(view.hashCode(), activityListener);
        lifecycleState = ActivityListenerManager.getLifecycleState(view.hashCode());
_L4:
        listeningToActivity = flag;
        checkViewable();
        return;
_L2:
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 & listeningToActivity)
        {
            ActivityListenerManager.unregisterListener(view.hashCode(), activityListener);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void removeObserver(View view)
    {
        if (!observingViewTree)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ViewUtils.access$000(), "Trying to remove view tree observer when not set");
            }
            return;
        }
        ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("Removing ViewTreeObserver.\n\tViewability watcher: ").append(this).append("\n\tViewTreeObserver: ").append(viewtreeobserver).append("\n\tView: ").append(view).toString());
            }
            viewtreeobserver.removeOnPreDrawListener(this);
        }
        observingViewTree = false;
    }

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (watching)
        {
            checkViewable();
        }
    }

    public boolean onPreDraw()
    {
        if (watching)
        {
            checkViewable();
        }
        return true;
    }

    public void onViewAttachedToWindow(View view)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("onViewAttachedToWindow called.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(view).toString());
        }
        if (watching)
        {
            addObserver(view);
            listenToActivity(view, true);
        }
    }

    public void onViewDetachedFromWindow(View view)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("onViewDetachedFromWindow called.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(view).toString());
        }
        if (watching)
        {
            removeObserver(view);
            listenToActivity(view, false);
        }
    }

    public void setMinViewabilityPercent(int i)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("Setting the viewability percentage.\n\tViewability watcher: ").append(this).append("\n\tPercentage: ").append(i).toString());
        }
        minViewabilityPercent = i;
    }

    public void startWatching()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("Starting watcher.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(viewRef.get()).toString());
        }
        View view = (View)viewRef.get();
        if (view == null || watching)
        {
            return;
        }
        view.addOnAttachStateChangeListener(this);
        view.addOnLayoutChangeListener(this);
        watching = true;
        if (view.getWindowToken() != null)
        {
            addObserver(view);
            listenToActivity(view, true);
            return;
        } else
        {
            checkViewable();
            return;
        }
    }

    public void stopWatching()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("Stopping watcher.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(viewRef.get()).toString());
        }
        View view = (View)viewRef.get();
        if (view == null || !watching)
        {
            return;
        } else
        {
            removeObserver(view);
            view.removeOnAttachStateChangeListener(this);
            view.removeOnLayoutChangeListener(this);
            watching = false;
            listenToActivity(view, false);
            return;
        }
    }


    public (View view,  )
    {
        minViewabilityPercent = 1;
        clipRect = new Rect();
        watching = false;
        listeningToActivity = false;
        observingViewTree = false;
        viewable = false;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ViewUtils.access$000(), (new StringBuilder()).append("Creating viewability watcher <").append(this).append("> for view <").append(view).append(">").toString());
        }
        viewRef = new WeakReference(view);
        listener = ;
        activityListener = new com.millennialmedia.internal.ActivityListenerManager.ActivityListener() {

            final ViewUtils.ViewabilityWatcher this$0;

            public void onPaused(Activity activity)
            {
                lifecycleState = com.millennialmedia.internal.ActivityListenerManager.LifecycleState.PAUSED;
                checkViewable();
            }

            public void onResumed(Activity activity)
            {
                lifecycleState = com.millennialmedia.internal.ActivityListenerManager.LifecycleState.RESUMED;
                checkViewable();
            }

            
            {
                this$0 = ViewUtils.ViewabilityWatcher.this;
                super();
            }
        };
    }
}

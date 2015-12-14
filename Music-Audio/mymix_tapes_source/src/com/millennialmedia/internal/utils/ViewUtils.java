// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.ActivityListenerManager;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal.utils:
//            EnvironmentUtils

public class ViewUtils
{
    public static interface ViewabilityListener
    {

        public abstract void onViewableChanged(boolean flag);
    }

    public static class ViewabilityWatcher
        implements android.view.ViewTreeObserver.OnPreDrawListener, android.view.View.OnLayoutChangeListener, android.view.View.OnAttachStateChangeListener
    {

        volatile com.millennialmedia.internal.ActivityListenerManager.ActivityListener activityListener;
        Rect clipRect;
        volatile com.millennialmedia.internal.ActivityListenerManager.LifecycleState lifecycleState;
        volatile ViewabilityListener listener;
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
                    MMLog.d(ViewUtils.TAG, "Trying to set view tree observer when already set");
                }
            } else
            {
                ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
                if (viewtreeobserver.isAlive())
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("Adding ViewTreeObserver.\n\tViewability watcher: ").append(this).append("\n\tViewTreeObserver: ").append(viewtreeobserver).append("\n\tView: ").append(view).toString());
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
                if (lifecycleState == com.millennialmedia.internal.ActivityListenerManager.LifecycleState.RESUMED)
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
                        MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("Notifying listener of viewability change.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(view).append("\n\tViewable: ").append(viewable).toString());
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
                    MMLog.d(ViewUtils.TAG, "Trying to remove view tree observer when not set");
                }
                return;
            }
            ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
            if (viewtreeobserver.isAlive())
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("Removing ViewTreeObserver.\n\tViewability watcher: ").append(this).append("\n\tViewTreeObserver: ").append(viewtreeobserver).append("\n\tView: ").append(view).toString());
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
                MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("onViewAttachedToWindow called.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(view).toString());
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
                MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("onViewDetachedFromWindow called.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(view).toString());
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
                MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("Setting the viewability percentage.\n\tViewability watcher: ").append(this).append("\n\tPercentage: ").append(i).toString());
            }
            minViewabilityPercent = i;
        }

        public void startWatching()
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("Starting watcher.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(viewRef.get()).toString());
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
                MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("Stopping watcher.\n\tViewability watcher: ").append(this).append("\n\tView: ").append(viewRef.get()).toString());
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


        public ViewabilityWatcher(View view, ViewabilityListener viewabilitylistener)
        {
            minViewabilityPercent = 1;
            clipRect = new Rect();
            watching = false;
            listeningToActivity = false;
            observingViewTree = false;
            viewable = false;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ViewUtils.TAG, (new StringBuilder()).append("Creating viewability watcher <").append(this).append("> for view <").append(view).append(">").toString());
            }
            viewRef = new WeakReference(view);
            listener = viewabilitylistener;
            activityListener = new _cls1();
        }
    }


    private static final int DEFAULT_MIN_VIEWABILITY_PERCENT = 1;
    private static final String TAG = com/millennialmedia/internal/utils/ViewUtils.getSimpleName();

    public ViewUtils()
    {
    }

    public static void attachView(ViewGroup viewgroup, View view)
    {
        attachView(viewgroup, view, null);
    }

    public static void attachView(ViewGroup viewgroup, View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (view.getParent() != null)
        {
            removeFromParent(view);
        }
        android.content.Context context = view.getContext();
        if (context instanceof MutableContextWrapper)
        {
            android.content.Context context1 = viewgroup.getContext();
            if (context != context1)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TAG, "Changing view context to match parent context");
                }
                ((MutableContextWrapper)context).setBaseContext(context1);
            }
        }
        if (layoutparams != null)
        {
            viewgroup.addView(view, layoutparams);
            return;
        } else
        {
            viewgroup.addView(view);
            return;
        }
    }

    public static int convertPixelsToDips(int i)
    {
        return (int)((float)i / EnvironmentUtils.getDisplayDensity());
    }

    public static void convertPixelsToDips(Rect rect)
    {
        if (rect == null)
        {
            MMLog.e(TAG, "Unable to convert for null dimensions");
        } else
        {
            float f = EnvironmentUtils.getDisplayDensity();
            int i = (int)((float)(rect.right - rect.left) / f);
            int j = (int)((float)(rect.bottom - rect.top) / f);
            rect.left = (int)((float)rect.left / f);
            rect.top = (int)((float)rect.top / f);
            rect.right = rect.left + i;
            rect.bottom = rect.top + j;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Converted dimensions from pixels to dips: ").append(rect.flattenToString()).toString());
                return;
            }
        }
    }

    public static Activity getActivityForView(View view)
    {
        Object obj = null;
        Activity activity = obj;
        if (view != null)
        {
            android.content.Context context;
            for (context = view.getContext(); context instanceof MutableContextWrapper; context = ((MutableContextWrapper)context).getBaseContext()) { }
            activity = obj;
            if (context instanceof Activity)
            {
                activity = (Activity)context;
            }
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Found activity <").append(activity).append("> for view <").append(view).append(">").toString());
        }
        return activity;
    }

    public static int getActivityHashForView(View view)
    {
        int i = -1;
        Activity activity = getActivityForView(view);
        if (activity == null)
        {
            MMLog.e(TAG, "Unable to get activity hash");
        } else
        {
            i = activity.hashCode();
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Found activity hash code <").append(i).append("> for view <").append(view).append(">").toString());
        }
        return i;
    }

    public static Rect getContentDimensions(View view, Rect rect)
    {
        if (view == null)
        {
            MMLog.e(TAG, "Unable to calculate content dimensions for null view");
            return null;
        }
        ViewGroup viewgroup = getDecorView(view);
        if (viewgroup == null)
        {
            MMLog.e(TAG, "Unable to calculate content for null root view");
            return null;
        }
        Rect rect1 = rect;
        if (rect == null)
        {
            rect1 = new Rect();
        }
        viewgroup.getWindowVisibleDisplayFrame(rect1);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Content dimensions for View <").append(view).append(">: ").append(rect1.flattenToString()).toString());
        }
        return rect1;
    }

    public static ViewGroup getDecorView(View view)
    {
        Object obj = null;
        Object obj1 = getActivityForView(view);
        ViewGroup viewgroup = obj;
        if (obj1 != null)
        {
            obj1 = ((Activity) (obj1)).getWindow().getDecorView();
            viewgroup = obj;
            if (obj1 instanceof ViewGroup)
            {
                viewgroup = (ViewGroup)obj1;
            }
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Found decor view <").append(viewgroup).append("> for view <").append(view).append(">").toString());
        }
        return viewgroup;
    }

    public static ViewGroup getParentContainer(View view)
    {
        view = view.getParent();
        if (!(view instanceof ViewGroup))
        {
            return null;
        } else
        {
            return (ViewGroup)view;
        }
    }

    public static Rect getViewDimensionsOnScreen(View view, Rect rect)
    {
        if (view == null)
        {
            MMLog.e(TAG, "Unable to calculate view dimensions for null view");
            return null;
        }
        Rect rect1 = rect;
        if (rect == null)
        {
            rect1 = new Rect();
        }
        rect = new int[2];
        view.getLocationOnScreen(rect);
        rect1.left = rect[0];
        rect1.top = rect[1];
        rect1.right = rect1.left + view.getWidth();
        rect1.bottom = rect1.top + view.getHeight();
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("On screen dimensions for View <").append(view).append(">: ").append(rect1.flattenToString()).toString());
        }
        return rect1;
    }

    public static Rect getViewDimensionsRelativeToContent(View view, Rect rect)
    {
        Rect rect1 = getViewDimensionsOnScreen(view, rect);
        if (rect1 == null) goto _L2; else goto _L1
_L1:
        rect = getDecorView(view);
        if (rect != null) goto _L4; else goto _L3
_L3:
        MMLog.e(TAG, "Unable to calculate dimensions for null root view");
        rect = null;
_L6:
        return rect;
_L4:
        Rect rect2 = new Rect();
        rect.getWindowVisibleDisplayFrame(rect2);
        rect1.top = rect1.top - rect2.top;
        rect1.bottom = rect1.bottom - rect2.top;
_L2:
        rect = rect1;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Dimensions relative to content for View <").append(view).append(">: ").append(rect1.flattenToString()).toString());
            return rect1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Point getViewPositionOnScreen(View view)
    {
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        return new Point(ai[0], ai[1]);
    }

    public static boolean isChild(ViewGroup viewgroup, View view)
    {
        boolean flag1 = false;
        view = view.getParent();
        boolean flag = flag1;
        if (view instanceof ViewGroup)
        {
            flag = flag1;
            if ((ViewGroup)view == viewgroup)
            {
                flag = true;
            }
        }
        return flag;
    }

    public static void removeFromParent(View view)
    {
        android.view.ViewParent viewparent = view.getParent();
        if (!(viewparent instanceof ViewGroup))
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Unable to remove view from parent, no valid parent view found");
            }
            return;
        } else
        {
            ((ViewGroup)viewparent).removeView(view);
            return;
        }
    }



    // Unreferenced inner class com/millennialmedia/internal/utils/ViewUtils$ViewabilityWatcher$1

/* anonymous class */
    class ViewabilityWatcher._cls1 extends com.millennialmedia.internal.ActivityListenerManager.ActivityListener
    {

        final ViewabilityWatcher this$0;

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
                this$0 = ViewabilityWatcher.this;
                super();
            }
    }

}

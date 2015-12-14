// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal:
//            MMActivity

public class SizableStateManager
{
    public static class ExpandParams
    {

        public int height;
        public int orientation;
        public boolean showCloseIndicator;
        public boolean showLoadingSpinner;
        public boolean transparent;
        public String url;
        public int width;

        public ExpandParams()
        {
        }
    }

    public class ExpandStateManager
    {

        private static final long CLOSE_BUTTON_APPEARANCE_DELAY = 1100L;
        private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable closeButtonShowRunnable;
        private ImageView closeControl;
        private boolean closeIndicatorShowing;
        private ProgressBar loadingSpinner;
        private MMActivity mmExpandActivity;
        final SizableStateManager this$0;

        private void showCloseIndicator()
        {
            while (closeButtonShowRunnable != null || closeControl == null) 
            {
                return;
            }
            closeControl.setImageDrawable(closeControl.getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_close));
            closeControl.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            closeIndicatorShowing = true;
        }

        void attachCloseControl()
        {
            if (closeControl == null)
            {
                closeControl = new ImageView(mmExpandActivity.getRootView().getContext());
                closeControl.setBackgroundColor(0);
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(SizableStateManager.closeAreaSize, SizableStateManager.closeAreaSize);
                layoutparams.addRule(11);
                closeControl.setLayoutParams(layoutparams);
                closeControl.setOnClickListener(new android.view.View.OnClickListener() {

                    final ExpandStateManager this$1;

                    public void onClick(View view)
                    {
                        close();
                    }

            
            {
                this$1 = ExpandStateManager.this;
                super();
            }
                });
            }
            ViewUtils.attachView(mmExpandActivity.getRootView(), closeControl);
            closeControl.bringToFront();
        }

        public void close()
        {
            if (!ThreadUtils.isUiThread())
            {
                MMLog.e(SizableStateManager.TAG, "close must be called on the UI thread");
            } else
            if (mmExpandActivity != null)
            {
                mmExpandActivity.finish();
                return;
            }
        }

        public boolean expand(View view, final ExpandParams expandParams, MMActivity.MMActivityConfig mmactivityconfig)
        {
            if (!ThreadUtils.isUiThread())
            {
                MMLog.e(SizableStateManager.TAG, "expand must be called on the UI thread");
                return false;
            } else
            {
                MMActivity.launch(view.getContext(), mmactivityconfig, view. new MMActivity.MMActivityListener() {

                    final ExpandStateManager this$1;
                    final View val$childView;
                    final ExpandParams val$expandParams;

                    public void onCreate(MMActivity mmactivity)
                    {
                        boolean flag;
                        flag = false;
                        if (mmExpandActivity == null)
                        {
                            sizableListener.onExpanding();
                            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(expandParams.width, expandParams.height);
                            layoutparams.addRule(13);
                            childView.setLayoutParams(layoutparams);
                            flag = true;
                            notifyStateWhenReady(childView, SizableState.STATE_EXPANDED);
                        }
                        mmExpandActivity = mmactivity;
                        ViewUtils.attachView(mmactivity.getRootView(), childView);
                        attachCloseControl();
                        if (!flag || !expandParams.showCloseIndicator) goto _L2; else goto _L1
_L1:
                        showCloseIndicatorDelay();
_L4:
                        if (expandParams.showLoadingSpinner)
                        {
                            showLoadingSpinner();
                        }
                        return;
_L2:
                        if (closeIndicatorShowing)
                        {
                            showCloseIndicator();
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

                    public void onDestroy(MMActivity mmactivity)
                    {
                        if (mmactivity.isFinishing())
                        {
                            restoreDefaultState(true);
                            mmExpandActivity = null;
                        }
                    }

                    public void onLaunchFailed()
                    {
                        sizableListener.onExpandFailed();
                    }

            
            {
                this$1 = final_expandstatemanager;
                expandParams = expandparams;
                childView = View.this;
                super();
            }
                });
                return true;
            }
        }

        void hideCloseIndicator()
        {
            if (closeButtonShowRunnable != null)
            {
                closeButtonShowRunnable.cancel();
                closeButtonShowRunnable = null;
            }
            if (closeControl != null)
            {
                closeControl.setImageDrawable(null);
                closeIndicatorShowing = false;
            }
        }

        void hideLoadingSpinner()
        {
            if (loadingSpinner != null)
            {
                loadingSpinner.setVisibility(8);
                ViewUtils.removeFromParent(loadingSpinner);
                loadingSpinner = null;
            }
        }

        void setOrientation(int i)
        {
            mmExpandActivity.setOrientation(i);
        }

        void showCloseIndicatorDelay()
        {
            if (closeButtonShowRunnable == null)
            {
                closeButtonShowRunnable = ThreadUtils.runOnUiThreadDelayed(new Runnable() {

                    final ExpandStateManager this$1;

                    public void run()
                    {
                        closeButtonShowRunnable = null;
                        showCloseIndicator();
                    }

            
            {
                this$1 = ExpandStateManager.this;
                super();
            }
                }, 1100L);
            }
        }

        void showLoadingSpinner()
        {
            if (mmExpandActivity == null)
            {
                return;
            }
            if (loadingSpinner == null)
            {
                loadingSpinner = new ProgressBar(mmExpandActivity.getRootView().getContext());
                loadingSpinner.setIndeterminate(true);
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutparams.addRule(13);
                loadingSpinner.setLayoutParams(layoutparams);
            }
            ViewUtils.attachView(mmExpandActivity.getRootView(), loadingSpinner);
            loadingSpinner.bringToFront();
        }


/*
        static com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable access$602(ExpandStateManager expandstatemanager, com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledrunnable)
        {
            expandstatemanager.closeButtonShowRunnable = scheduledrunnable;
            return scheduledrunnable;
        }

*/




/*
        static MMActivity access$802(ExpandStateManager expandstatemanager, MMActivity mmactivity)
        {
            expandstatemanager.mmExpandActivity = mmactivity;
            return mmactivity;
        }

*/


        public ExpandStateManager()
        {
            this$0 = SizableStateManager.this;
            super();
            closeButtonShowRunnable = null;
        }
    }

    public class ResizeContainer extends RelativeLayout
    {

        private View closeControl;
        final SizableStateManager this$0;

        private Rect calculateCloseAreaRect(String s, Rect rect)
        {
            Rect rect1 = new Rect();
            if (s.contains("center"))
            {
                rect1.left = ((rect.left + rect.right) - SizableStateManager.closeAreaSize) / 2;
                if (s.equals("center"))
                {
                    rect1.top = ((rect.top + rect.bottom) - SizableStateManager.closeAreaSize) / 2;
                }
            }
            if (s.startsWith("top"))
            {
                rect1.top = rect.top;
            } else
            if (s.startsWith("bottom"))
            {
                rect1.top = rect.bottom - SizableStateManager.closeAreaSize;
            }
            if (s.endsWith("left"))
            {
                rect1.left = rect.left;
            } else
            if (s.endsWith("right"))
            {
                rect1.left = rect.right - SizableStateManager.closeAreaSize;
            }
            rect1.right = rect1.left + SizableStateManager.closeAreaSize;
            rect1.bottom = rect1.top + SizableStateManager.closeAreaSize;
            return rect1;
        }

        public void attachCloseControl(Context context, String s)
        {
            if (closeControl == null)
            {
                closeControl = new View(context);
                closeControl.setBackgroundColor(0);
                closeControl.setOnClickListener(new android.view.View.OnClickListener() {

                    final ResizeContainer this$1;

                    public void onClick(View view)
                    {
                        close();
                    }

            
            {
                this$1 = ResizeContainer.this;
                super();
            }
                });
                ViewUtils.attachView(this, closeControl);
            }
            context = new android.widget.RelativeLayout.LayoutParams(SizableStateManager.closeAreaSize, SizableStateManager.closeAreaSize);
            if (!s.equals("top-right")) goto _L2; else goto _L1
_L1:
            context.addRule(11);
_L4:
            closeControl.setLayoutParams(context);
            closeControl.bringToFront();
            return;
_L2:
            if (s.equals("top-center"))
            {
                context.addRule(14);
            } else
            if (s.equals("bottom-left"))
            {
                context.addRule(12);
            } else
            if (s.equals("bottom-center"))
            {
                context.addRule(12);
                context.addRule(14);
            } else
            if (s.equals("bottom-right"))
            {
                context.addRule(12);
                context.addRule(11);
            } else
            if (s.equals("center"))
            {
                context.addRule(13);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void close()
        {
            if (!ThreadUtils.isUiThread())
            {
                MMLog.e(SizableStateManager.TAG, "close must be called on the UI thread");
                return;
            } else
            {
                restoreDefaultState(true);
                ViewUtils.removeFromParent(this);
                return;
            }
        }

        public boolean resize(View view, ResizeParams resizeparams)
        {
            if (!ThreadUtils.isUiThread())
            {
                MMLog.e(SizableStateManager.TAG, "resize must be called on the UI thread");
                return false;
            }
            Object obj = ViewUtils.getContentDimensions(view.getRootView(), null);
            Rect rect = new Rect();
            if (restoreState == null)
            {
                Point point = ViewUtils.getViewPositionOnScreen(view);
                rect.left = point.x + resizeparams.offsetX;
                rect.top = point.y + resizeparams.offsetY;
            } else
            {
                rect.left = restoreState.pos.x + resizeparams.offsetX;
                rect.top = restoreState.pos.y + resizeparams.offsetY;
            }
            rect.right = rect.left + resizeparams.width;
            rect.bottom = rect.top + resizeparams.height;
            if (!resizeparams.allowOffScreen)
            {
                shiftRectOnScreen(rect, ((Rect) (obj)));
                if (!((Rect) (obj)).contains(rect))
                {
                    MMLog.e(SizableStateManager.TAG, "Resized view would not appear on screen");
                    return false;
                }
            }
            if (!((Rect) (obj)).contains(calculateCloseAreaRect(resizeparams.customClosePosition, rect)))
            {
                MMLog.e(SizableStateManager.TAG, "Close area would not appear on screen");
                return false;
            }
            sizableListener.onResizing(resizeparams.width, resizeparams.height);
            if (restoreState == null)
            {
                saveDefaultState(view);
                obj = ViewUtils.getDecorView(view);
                if (obj == null)
                {
                    MMLog.e(SizableStateManager.TAG, "Unable to resize to root view");
                    return false;
                }
                ViewUtils.attachView(this, view);
                ViewUtils.attachView(((ViewGroup) (obj)), this);
                obj = (ViewGroup)restoreState.parentContainerRef.get();
                if (obj != null)
                {
                    ((ViewGroup) (obj)).setVisibility(4);
                }
            }
            view.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(resizeparams.width, resizeparams.height));
            obj = getLayoutParams();
            obj.width = resizeparams.width;
            obj.height = resizeparams.height;
            setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            setTranslationX(rect.left);
            setTranslationY(rect.top);
            attachCloseControl(getContext(), resizeparams.customClosePosition);
            notifyStateWhenReady(view, SizableState.STATE_RESIZED);
            return true;
        }

        void shiftRectOnScreen(Rect rect, Rect rect1)
        {
            int i = 0;
            int j = 0;
            if (rect.left < rect1.left)
            {
                i = rect1.left - rect.left;
            } else
            if (rect.right > rect1.right)
            {
                i = rect1.right - rect.right;
            }
            if (rect.top < rect1.top)
            {
                j = rect1.top - rect.top;
            } else
            if (rect.bottom > rect1.bottom)
            {
                j = rect1.bottom - rect.bottom;
            }
            rect.offset(i, j);
        }

        public ResizeContainer(Context context)
        {
            this$0 = SizableStateManager.this;
            super(context);
        }
    }

    public static class ResizeParams
    {

        boolean allowOffScreen;
        String customClosePosition;
        int height;
        int offsetX;
        int offsetY;
        int width;

        public ResizeParams()
        {
        }
    }

    private class RestoreState
    {

        private android.view.ViewGroup.LayoutParams layoutParams;
        private WeakReference parentContainerRef;
        private Point pos;
        private Point size;
        final SizableStateManager this$0;
        private View view;



/*
        static View access$1102(RestoreState restorestate, View view1)
        {
            restorestate.view = view1;
            return view1;
        }

*/



/*
        static android.view.ViewGroup.LayoutParams access$1202(RestoreState restorestate, android.view.ViewGroup.LayoutParams layoutparams)
        {
            restorestate.layoutParams = layoutparams;
            return layoutparams;
        }

*/



/*
        static Point access$1302(RestoreState restorestate, Point point)
        {
            restorestate.size = point;
            return point;
        }

*/



/*
        static Point access$202(RestoreState restorestate, Point point)
        {
            restorestate.pos = point;
            return point;
        }

*/



/*
        static WeakReference access$402(RestoreState restorestate, WeakReference weakreference)
        {
            restorestate.parentContainerRef = weakreference;
            return weakreference;
        }

*/

        private RestoreState()
        {
            this$0 = SizableStateManager.this;
            super();
        }

    }

    public static interface SizableListener
    {

        public abstract void onCollapsed();

        public abstract void onCollapsing();

        public abstract void onExpandFailed();

        public abstract void onExpanded();

        public abstract void onExpanding();

        public abstract void onResized(int i, int j);

        public abstract void onResizing(int i, int j);

        public abstract void onUnresized(int i, int j);

        public abstract void onUnresizing(int i, int j);
    }

    private static final class SizableState extends Enum
    {

        private static final SizableState $VALUES[];
        public static final SizableState STATE_COLLAPSED;
        public static final SizableState STATE_EXPANDED;
        public static final SizableState STATE_RESIZED;
        public static final SizableState STATE_UNRESIZED;

        public static SizableState valueOf(String s)
        {
            return (SizableState)Enum.valueOf(com/millennialmedia/internal/SizableStateManager$SizableState, s);
        }

        public static SizableState[] values()
        {
            return (SizableState[])$VALUES.clone();
        }

        static 
        {
            STATE_RESIZED = new SizableState("STATE_RESIZED", 0);
            STATE_UNRESIZED = new SizableState("STATE_UNRESIZED", 1);
            STATE_EXPANDED = new SizableState("STATE_EXPANDED", 2);
            STATE_COLLAPSED = new SizableState("STATE_COLLAPSED", 3);
            $VALUES = (new SizableState[] {
                STATE_RESIZED, STATE_UNRESIZED, STATE_EXPANDED, STATE_COLLAPSED
            });
        }

        private SizableState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/millennialmedia/internal/SizableStateManager.getSimpleName();
    static final int closeAreaSize;
    private ExpandStateManager expandStateManager;
    private ResizeContainer resizeContainer;
    private RestoreState restoreState;
    private SizableListener sizableListener;

    public SizableStateManager(SizableListener sizablelistener)
    {
        sizableListener = sizablelistener;
    }

    private void notifyStateWhenReady(final View view, final SizableState deferredState)
    {
        view.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

            final SizableStateManager this$0;
            final SizableState val$deferredState;
            final View val$view;

            public void onLayoutChange(View view1, int i, int j, int k, int l, int i1, int j1, 
                    int k1, int l1)
            {
                i = k - i;
                j = l - j;
                if (i > 0 && j > 0)
                {
                    view.removeOnLayoutChangeListener(this);
                    if (deferredState == SizableState.STATE_RESIZED)
                    {
                        sizableListener.onResized(i, j);
                    } else
                    {
                        if (deferredState == SizableState.STATE_EXPANDED)
                        {
                            sizableListener.onExpanded();
                            return;
                        }
                        if (deferredState == SizableState.STATE_UNRESIZED)
                        {
                            sizableListener.onUnresized(i, j);
                            return;
                        }
                        if (deferredState == SizableState.STATE_COLLAPSED)
                        {
                            sizableListener.onCollapsed();
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = SizableStateManager.this;
                view = view1;
                deferredState = sizablestate;
                super();
            }
        });
    }

    public void close()
    {
        if (expandStateManager != null)
        {
            expandStateManager.close();
        } else
        if (resizeContainer != null)
        {
            resizeContainer.close();
            return;
        }
    }

    public boolean expand(View view, ExpandParams expandparams, MMActivity.MMActivityConfig mmactivityconfig)
    {
        expandStateManager = new ExpandStateManager();
        if (expandStateManager.expand(view, expandparams, mmactivityconfig))
        {
            return true;
        } else
        {
            expandStateManager = null;
            return false;
        }
    }

    public boolean expand(View view, ExpandParams expandparams, boolean flag)
    {
        if (expandStateManager != null)
        {
            MMLog.e(TAG, "Cannot expand while expanded");
            return false;
        }
        MMActivity.MMActivityConfig mmactivityconfig;
        if (flag)
        {
            saveDefaultState(view);
        } else
        {
            restoreDefaultState(false);
        }
        mmactivityconfig = (new MMActivity.MMActivityConfig()).setImmersive(false).setOrientation(expandparams.orientation).setTransparent(expandparams.transparent);
        expandStateManager = new ExpandStateManager();
        if (expandStateManager.expand(view, expandparams, mmactivityconfig))
        {
            return true;
        } else
        {
            expandStateManager = null;
            return false;
        }
    }

    public void hideLoadingSpinner(ExpandParams expandparams)
    {
        expandparams.showLoadingSpinner = false;
        if (expandStateManager != null)
        {
            expandStateManager.hideLoadingSpinner();
        }
    }

    public boolean isExpanded()
    {
        return expandStateManager != null;
    }

    public boolean isResized()
    {
        return resizeContainer != null;
    }

    public boolean resize(View view, ResizeParams resizeparams)
    {
        if (expandStateManager != null)
        {
            MMLog.e(TAG, "Cannot resize while expanded");
        } else
        {
            boolean flag;
            if (resizeContainer == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                resizeContainer = new ResizeContainer(view.getContext());
            }
            if (resizeContainer.resize(view, resizeparams))
            {
                return true;
            }
            if (flag)
            {
                resizeContainer = null;
                return false;
            }
        }
        return false;
    }

    public void restoreDefaultState(boolean flag)
    {
        if (restoreState == null) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup = (ViewGroup)restoreState.parentContainerRef.get();
        if (viewgroup != null)
        {
            if (flag)
            {
                if (expandStateManager != null)
                {
                    sizableListener.onCollapsing();
                    notifyStateWhenReady(restoreState.view, SizableState.STATE_COLLAPSED);
                } else
                {
                    sizableListener.onUnresizing(restoreState.size.x, restoreState.size.y);
                    notifyStateWhenReady(restoreState.view, SizableState.STATE_UNRESIZED);
                }
            }
            viewgroup.setVisibility(0);
            if (restoreState.layoutParams == null)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TAG, (new StringBuilder()).append("No layout params found for view being restored, creating new layout params based on original size: x<").append(restoreState.size.x).append(">, y<").append(restoreState.size.y).append(">").toString());
                }
                restoreState.layoutParams = new android.view.ViewGroup.LayoutParams(restoreState.size.x, restoreState.size.y);
            }
            ViewUtils.attachView(viewgroup, restoreState.view, restoreState.layoutParams);
        }
        restoreState = null;
_L4:
        resizeContainer = null;
        expandStateManager = null;
        return;
_L2:
        if (flag)
        {
            sizableListener.onCollapsing();
            sizableListener.onCollapsed();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void saveDefaultState(View view)
    {
        if (restoreState == null)
        {
            restoreState = new RestoreState();
            restoreState.view = view;
            restoreState.pos = ViewUtils.getViewPositionOnScreen(view);
            restoreState.layoutParams = view.getLayoutParams();
            restoreState.size = new Point(view.getWidth(), view.getHeight());
            view = ViewUtils.getParentContainer(view);
            restoreState.parentContainerRef = new WeakReference(view);
        }
    }

    public void setOrientation(int i)
    {
        if (expandStateManager != null)
        {
            expandStateManager.setOrientation(i);
        }
    }

    public void showCloseIndicator(boolean flag)
    {
label0:
        {
            if (expandStateManager != null)
            {
                if (!flag)
                {
                    break label0;
                }
                expandStateManager.showCloseIndicator();
            }
            return;
        }
        expandStateManager.hideCloseIndicator();
    }

    public void showLoadingSpinner(ExpandParams expandparams)
    {
        expandparams.showLoadingSpinner = true;
        if (expandStateManager != null)
        {
            expandStateManager.showLoadingSpinner();
        }
    }

    static 
    {
        closeAreaSize = EnvironmentUtils.getApplicationContext().getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_mraid_resize_close_area_size);
    }




}

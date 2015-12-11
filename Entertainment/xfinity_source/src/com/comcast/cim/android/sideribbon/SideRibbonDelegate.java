// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.PassiveGestureListener;
import com.comcast.cim.android.accessibility.PassiveStateChangeListener;
import com.comcast.cim.cmasl.android.util.view.animation.ResizeAnimation;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SlideClosedRequestListener, SlideClosedListener

public class SideRibbonDelegate
    implements SlideClosedRequestListener
{
    public static interface RibbonStateChangeListener
    {

        public abstract void onSideRibbonStateChanged(State state1);
    }

    private class SlideInGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final int SWIPE_THRESHOLD_VELOCITY = 20;
        private SideRibbonDelegate sideRibbonDelegate;
        final SideRibbonDelegate this$0;

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            if (Math.abs(f) > Math.abs(f1) && f < 0.0F && Math.abs(f) > 20F)
            {
                sideRibbonDelegate.slideClosed(null);
                return true;
            } else
            {
                return false;
            }
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            sideRibbonDelegate.slideClosed(null);
            return true;
        }

        public SlideInGestureListener(SideRibbonDelegate sideribbondelegate1)
        {
            this$0 = SideRibbonDelegate.this;
            super();
            sideRibbonDelegate = sideribbondelegate1;
        }
    }

    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State CLOSED;
        public static final State IN_PROGRESS;
        public static final State OPEN;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/comcast/cim/android/sideribbon/SideRibbonDelegate$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            CLOSED = new State("CLOSED", 0);
            OPEN = new State("OPEN", 1);
            IN_PROGRESS = new State("IN_PROGRESS", 2);
            $VALUES = (new State[] {
                CLOSED, OPEN, IN_PROGRESS
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }

    private class closeAnimationListener
        implements android.view.animation.Animation.AnimationListener
    {

        private SlideClosedListener slideClosedListener;
        final SideRibbonDelegate this$0;

        public void onAnimationEnd(Animation animation)
        {
            animation = (android.view.ViewGroup.MarginLayoutParams)touchyContentContainer.getLayoutParams();
            animation.setMargins(0, 0, 0, 0);
            touchyContentContainer.setLayoutParams(animation);
            int i = shadowView.getMeasuredWidth();
            animation = (android.view.ViewGroup.MarginLayoutParams)shadowView.getLayoutParams();
            animation.setMargins(-i, 0, 0, 0);
            shadowView.setLayoutParams(animation);
            ribbonContainer.setVisibility(8);
            updateState(State.CLOSED);
            if (slideClosedListener != null)
            {
                slideClosedListener.onCloseFinished();
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
            updateState(State.IN_PROGRESS);
            if (accessibilityUtil.isAccessibilityEnabled())
            {
                accessibilityUtil.toggleScreenFocus(focusToggleState, touchyContentContainer, touchyContentContainer, false, true);
            }
        }

        public closeAnimationListener(SlideClosedListener slideclosedlistener)
        {
            this$0 = SideRibbonDelegate.this;
            super();
            slideClosedListener = slideclosedlistener;
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/sideribbon/SideRibbonDelegate);
    private final AccessibilityUtil accessibilityUtil;
    private final Interpolator animationInterpolator;
    private final Animation closeAnimation;
    private final Animation closeShadowAnimation;
    private final GestureDetector contentContainerGestureDetector;
    private final GestureDetector contentContainerGestureDetectorAtRest;
    private final ViewGroup contentContainerParent;
    protected HashMap focusToggleState;
    private final Animation openAnimation;
    private final Animation openShadowAnimation;
    private PassiveGestureListener passiveGestureListener;
    private final Set passiveStateChangeListeners = Collections.synchronizedSet(new HashSet());
    private final ViewGroup ribbonContainer;
    private final Set ribbonStateChangeListeners = Collections.synchronizedSet(new HashSet());
    private final int ribbonWidth;
    private final ViewGroup rootContainer;
    private final View shadowView;
    private final long slideDuration;
    private State state;
    private int statusBarHeight;
    private final ViewGroup touchyContentContainer;

    public SideRibbonDelegate(final Context final_context1, ViewGroup viewgroup, SideRibbonDelegateBuilder.Configuration configuration, final AccessibilityUtil accessibilityUtil)
    {
        statusBarHeight = -1;
        state = State.CLOSED;
        focusToggleState = new HashMap();
        contentContainerParent = viewgroup;
        this.accessibilityUtil = accessibilityUtil;
        ribbonWidth = configuration.getRibbonWidth();
        slideDuration = configuration.getSlideDuration();
        animationInterpolator = configuration.getAnimationInterpolator();
        touchyContentContainer = new RelativeLayout(final_context1) {

            final SideRibbonDelegate this$0;
            final AccessibilityUtil val$accessibilityUtil;
            final Context val$context;

            public boolean onInterceptTouchEvent(MotionEvent motionevent)
            {
                if (!state.equals(State.CLOSED))
                {
                    contentContainerGestureDetector.onTouchEvent(motionevent);
                } else
                if (accessibilityUtil.isAccessibilityEnabled())
                {
                    PassiveGestureListener _tmp = passiveGestureListener;
                    if (!PassiveGestureListener.isDownInRange(motionevent, context.getResources().getDisplayMetrics()))
                    {
                        return contentContainerGestureDetectorAtRest.onTouchEvent(motionevent);
                    }
                } else
                {
                    return false;
                }
                return true;
            }

            public boolean onTouchEvent(MotionEvent motionevent)
            {
                if (!state.equals(State.CLOSED))
                {
                    contentContainerGestureDetector.onTouchEvent(motionevent);
                } else
                if (accessibilityUtil.isAccessibilityEnabled())
                {
                    PassiveGestureListener _tmp = passiveGestureListener;
                    if (!PassiveGestureListener.isDownInRange(motionevent, context.getResources().getDisplayMetrics()))
                    {
                        return contentContainerGestureDetectorAtRest.onTouchEvent(motionevent);
                    }
                } else
                {
                    return false;
                }
                return true;
            }

            
            {
                this$0 = SideRibbonDelegate.this;
                accessibilityUtil = accessibilityutil;
                context = context2;
                super(final_context1);
            }
        };
        contentContainerGestureDetector = new GestureDetector(final_context1, new SlideInGestureListener(this));
        passiveGestureListener = new PassiveGestureListener(passiveStateChangeListeners);
        contentContainerGestureDetectorAtRest = new GestureDetector(final_context1, passiveGestureListener);
        touchyContentContainer.setBackgroundDrawable(viewgroup.getBackground());
        shadowView = new View(final_context1);
        rootContainer = new RelativeLayout(viewgroup.getContext());
        ribbonContainer = new FrameLayout(final_context1);
        ribbonContainer.setVisibility(8);
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            ribbonContainer.setFocusable(true);
            ribbonContainer.setFocusableInTouchMode(true);
            ribbonContainer.setContentDescription(final_context1.getString(com.comcast.cim.android.R.string.content_description_menu));
            accessibilityUtil.setImportantForAccessibility(ribbonContainer, 1);
        }
        rootContainer.addView(ribbonContainer);
        rootContainer.addView(shadowView);
        final int shadowWidth = configuration.getShadowWidth();
        shadowView.getLayoutParams().width = shadowWidth;
        shadowView.getLayoutParams().height = -1;
        ((android.view.ViewGroup.MarginLayoutParams)shadowView.getLayoutParams()).setMargins(-shadowWidth, 0, -shadowWidth, 0);
        shadowView.requestLayout();
        if (configuration.getShadowResource() != null)
        {
            shadowView.setBackgroundResource(configuration.getShadowResource().intValue());
        } else
        if (configuration.getShadowDrawable() != null)
        {
            shadowView.setBackgroundDrawable(configuration.getShadowDrawable());
        } else
        if (configuration.getBackgroundColor() != null)
        {
            shadowView.setBackgroundColor(configuration.getShadowColor());
        }
        rootContainer.addView(touchyContentContainer);
        if (configuration.getBackgroundResource() != null)
        {
            ribbonContainer.setBackgroundResource(configuration.getBackgroundResource().intValue());
        } else
        if (configuration.getBackgroundDrawable() != null)
        {
            ribbonContainer.setBackgroundDrawable(configuration.getBackgroundDrawable());
        } else
        if (configuration.getBackgroundColor() != null)
        {
            ribbonContainer.setBackgroundColor(configuration.getBackgroundColor().intValue());
        }
        openShadowAnimation = getSlideAnimation(0.0F, ribbonWidth);
        openAnimation = getSlideAnimation(0.0F, ribbonWidth);
        openAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final SideRibbonDelegate this$0;
            final AccessibilityUtil val$accessibilityUtil;
            final int val$shadowWidth;

            public void onAnimationEnd(Animation animation)
            {
                animation = (android.view.ViewGroup.MarginLayoutParams)touchyContentContainer.getLayoutParams();
                animation.setMargins(ribbonWidth, 0, -ribbonWidth, 0);
                touchyContentContainer.setLayoutParams(animation);
                animation = (android.view.ViewGroup.MarginLayoutParams)shadowView.getLayoutParams();
                animation.setMargins(ribbonWidth - shadowWidth, 0, -ribbonWidth - shadowWidth, 0);
                shadowView.setLayoutParams(animation);
                ribbonContainer.getLayoutParams().width = ribbonWidth;
                ribbonContainer.requestLayout();
                ribbonContainer.requestFocus();
                updateState(State.OPEN);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                ribbonContainer.setVisibility(0);
                updateState(State.IN_PROGRESS);
                if (accessibilityUtil.isAccessibilityEnabled())
                {
                    accessibilityUtil.toggleScreenFocus(focusToggleState, touchyContentContainer, touchyContentContainer, true, true);
                }
            }

            
            {
                this$0 = SideRibbonDelegate.this;
                accessibilityUtil = accessibilityutil;
                shadowWidth = i;
                super();
            }
        });
        closeShadowAnimation = getSlideAnimation(0.0F, -ribbonWidth);
        closeAnimation = getSlideAnimation(0.0F, -ribbonWidth);
        if (viewgroup == viewgroup.getRootView())
        {
            adjustMenuTopForNotificationBar(ribbonContainer);
        }
    }

    private void adjustMenuTopForNotificationBar(final View view)
    {
        if (statusBarHeight == -1)
        {
            contentContainerParent.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final SideRibbonDelegate this$0;
                final View val$view;

                public void onGlobalLayout()
                {
                    statusBarHeight = getStatusBarHeight();
                    adjustMenuTopForNotificationBar(view);
                    contentContainerParent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }

            
            {
                this$0 = SideRibbonDelegate.this;
                view = view1;
                super();
            }
            });
            return;
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutparams.topMargin = statusBarHeight;
            view.setLayoutParams(layoutparams);
            view.requestLayout();
            return;
        }
    }

    private Animation getResizeAnimation(View view, float f, float f1)
    {
        view = new ResizeAnimation(view, f, -1F, f1, -1F);
        view.setDuration(slideDuration);
        view.setFillEnabled(true);
        view.setInterpolator(animationInterpolator);
        return view;
    }

    private Animation getSlideAnimation(float f, float f1)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(f, f1, 0.0F, 0.0F);
        translateanimation.setDuration(slideDuration);
        translateanimation.setFillEnabled(true);
        translateanimation.setInterpolator(animationInterpolator);
        return translateanimation;
    }

    private int getStatusBarHeight()
    {
        Rect rect = new Rect();
        contentContainerParent.getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    private void updateState(State state1)
    {
        Set set = ribbonStateChangeListeners;
        set;
        JVM INSTR monitorenter ;
        if (!state.equals(state1))
        {
            state = state1;
            for (state1 = ribbonStateChangeListeners.iterator(); state1.hasNext(); ((RibbonStateChangeListener)state1.next()).onSideRibbonStateChanged(state)) { }
        }
        break MISSING_BLOCK_LABEL_68;
        state1;
        set;
        JVM INSTR monitorexit ;
        throw state1;
        set;
        JVM INSTR monitorexit ;
    }

    public void addPassiveStateChangeListener(PassiveStateChangeListener passivestatechangelistener)
    {
        passiveStateChangeListeners.add(passivestatechangelistener);
    }

    public void addRibbonStateChangeListener(RibbonStateChangeListener ribbonstatechangelistener)
    {
        ribbonStateChangeListeners.add(ribbonstatechangelistener);
    }

    public ViewGroup getRibbonContainer()
    {
        return ribbonContainer;
    }

    public View getRibbonContentView()
    {
        return ribbonContainer.getChildAt(0);
    }

    public boolean handleBackPressed()
    {
        if (!State.CLOSED.equals(state))
        {
            slideClosed(null);
            return true;
        } else
        {
            return false;
        }
    }

    public void init()
    {
        View view = contentContainerParent.getChildAt(0);
        contentContainerParent.removeAllViews();
        contentContainerParent.addView(rootContainer);
        touchyContentContainer.addView(view);
    }

    public void removeRibbonContentView()
    {
        ribbonContainer.removeAllViews();
    }

    public void setRibbonContentView(View view)
    {
        removeRibbonContentView();
        ribbonContainer.addView(view);
    }

    public void slideClosed(SlideClosedListener slideclosedlistener)
    {
        if (state == State.OPEN)
        {
            shadowView.startAnimation(closeShadowAnimation);
            closeAnimation.setAnimationListener(new closeAnimationListener(slideclosedlistener));
            touchyContentContainer.startAnimation(closeAnimation);
            ribbonContainer.startAnimation(getResizeAnimation(ribbonContainer, ribbonWidth, 0.0F));
        }
    }

    public void slideOpen()
    {
        if (State.CLOSED.equals(state))
        {
            shadowView.startAnimation(openShadowAnimation);
            ribbonContainer.startAnimation(getResizeAnimation(ribbonContainer, 0.0F, ribbonWidth));
            touchyContentContainer.startAnimation(openAnimation);
        }
    }

    public void toggleSlideIn()
    {
        static class _cls4
        {

            static final int $SwitchMap$com$comcast$cim$android$sideribbon$SideRibbonDelegate$State[];

            static 
            {
                $SwitchMap$com$comcast$cim$android$sideribbon$SideRibbonDelegate$State = new int[State.values().length];
                try
                {
                    $SwitchMap$com$comcast$cim$android$sideribbon$SideRibbonDelegate$State[State.CLOSED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$cim$android$sideribbon$SideRibbonDelegate$State[State.OPEN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls4..SwitchMap.com.comcast.cim.android.sideribbon.SideRibbonDelegate.State[state.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            slideOpen();
            return;

        case 2: // '\002'
            slideClosed(null);
            break;
        }
    }
















/*
    static int access$902(SideRibbonDelegate sideribbondelegate, int i)
    {
        sideribbondelegate.statusBarHeight = i;
        return i;
    }

*/
}

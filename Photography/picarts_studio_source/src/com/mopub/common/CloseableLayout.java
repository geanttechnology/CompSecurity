// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

// Referenced classes of package com.mopub.common:
//            Preconditions

public class CloseableLayout extends FrameLayout
{

    static final float CLOSE_BUTTON_PADDING_DP = 8F;
    static final float CLOSE_BUTTON_SIZE_DP = 30F;
    static final float CLOSE_REGION_SIZE_DP = 50F;
    private final Rect mClosableLayoutRect = new Rect();
    private boolean mCloseBoundChanged;
    private final Rect mCloseButtonBounds = new Rect();
    private final int mCloseButtonPadding;
    private final int mCloseButtonSize;
    private final StateListDrawable mCloseDrawable = new StateListDrawable();
    private ClosePosition mClosePosition;
    private final Rect mCloseRegionBounds = new Rect();
    private final int mCloseRegionSize;
    private final Rect mInsetCloseRegionBounds = new Rect();
    private OnCloseListener mOnCloseListener;
    private final int mTouchSlop;
    private UnsetPressedState mUnsetPressedState;

    public CloseableLayout(Context context)
    {
        super(context);
        mClosePosition = ClosePosition.TOP_RIGHT;
        mCloseDrawable.addState(SELECTED_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(context));
        mCloseDrawable.addState(EMPTY_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(context));
        mCloseDrawable.setState(EMPTY_STATE_SET);
        mCloseDrawable.setCallback(this);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mCloseRegionSize = Dips.asIntPixels(50F, context);
        mCloseButtonSize = Dips.asIntPixels(30F, context);
        mCloseButtonPadding = Dips.asIntPixels(8F, context);
        setWillNotDraw(false);
    }

    private void applyCloseBoundsWithSize(ClosePosition closeposition, int i, Rect rect, Rect rect1)
    {
        Gravity.apply(closeposition.getGravity(), i, i, rect, rect1);
    }

    private void applyCloseButtonBounds(ClosePosition closeposition, Rect rect, Rect rect1)
    {
        applyCloseBoundsWithSize(closeposition, mCloseButtonSize, rect, rect1);
    }

    private void performClose()
    {
        playSoundEffect(0);
        if (mOnCloseListener != null)
        {
            mOnCloseListener.onClose();
        }
    }

    private void setClosePressed(boolean flag)
    {
        if (flag == isClosePressed())
        {
            return;
        }
        StateListDrawable statelistdrawable = mCloseDrawable;
        int ai[];
        if (flag)
        {
            ai = SELECTED_STATE_SET;
        } else
        {
            ai = EMPTY_STATE_SET;
        }
        statelistdrawable.setState(ai);
        invalidate(mCloseRegionBounds);
    }

    public void applyCloseRegionBounds(ClosePosition closeposition, Rect rect, Rect rect1)
    {
        applyCloseBoundsWithSize(closeposition, mCloseRegionSize, rect, rect1);
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (mCloseBoundChanged)
        {
            mCloseBoundChanged = false;
            mClosableLayoutRect.set(0, 0, getWidth(), getHeight());
            applyCloseRegionBounds(mClosePosition, mClosableLayoutRect, mCloseRegionBounds);
            mInsetCloseRegionBounds.set(mCloseRegionBounds);
            mInsetCloseRegionBounds.inset(mCloseButtonPadding, mCloseButtonPadding);
            applyCloseButtonBounds(mClosePosition, mInsetCloseRegionBounds, mCloseButtonBounds);
            mCloseDrawable.setBounds(mCloseButtonBounds);
        }
        if (mCloseDrawable.isVisible())
        {
            mCloseDrawable.draw(canvas);
        }
    }

    Rect getCloseBounds()
    {
        return mCloseRegionBounds;
    }

    boolean isClosePressed()
    {
        return mCloseDrawable.getState() == SELECTED_STATE_SET;
    }

    public boolean isCloseVisible()
    {
        return mCloseDrawable.isVisible();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() != 0)
        {
            return false;
        } else
        {
            return pointInCloseBounds((int)motionevent.getX(), (int)motionevent.getY(), 0);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        mCloseBoundChanged = true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!pointInCloseBounds((int)motionevent.getX(), (int)motionevent.getY(), mTouchSlop))
        {
            setClosePressed(false);
            super.onTouchEvent(motionevent);
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 68
    //                   0 70
    //                   1 86
    //                   2 68
    //                   3 78;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return true;
_L2:
        setClosePressed(true);
        continue; /* Loop/switch isn't completed */
_L4:
        setClosePressed(false);
        continue; /* Loop/switch isn't completed */
_L3:
        if (isClosePressed())
        {
            if (mUnsetPressedState == null)
            {
                mUnsetPressedState = new UnsetPressedState();
            }
            postDelayed(mUnsetPressedState, ViewConfiguration.getPressedStateDuration());
            performClose();
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    boolean pointInCloseBounds(int i, int j, int k)
    {
        return i >= mCloseRegionBounds.left - k && j >= mCloseRegionBounds.top - k && i < mCloseRegionBounds.right + k && j < mCloseRegionBounds.bottom + k;
    }

    void setCloseBoundChanged(boolean flag)
    {
        mCloseBoundChanged = flag;
    }

    void setCloseBounds(Rect rect)
    {
        mCloseRegionBounds.set(rect);
    }

    public void setClosePosition(ClosePosition closeposition)
    {
        Preconditions.checkNotNull(closeposition);
        mClosePosition = closeposition;
        mCloseBoundChanged = true;
        invalidate();
    }

    public void setCloseVisible(boolean flag)
    {
        if (mCloseDrawable.setVisible(flag, false))
        {
            invalidate(mCloseRegionBounds);
        }
    }

    public void setOnCloseListener(OnCloseListener oncloselistener)
    {
        mOnCloseListener = oncloselistener;
    }


    private class ClosePosition extends Enum
    {

        private static final ClosePosition $VALUES[];
        public static final ClosePosition BOTTOM_CENTER;
        public static final ClosePosition BOTTOM_LEFT;
        public static final ClosePosition BOTTOM_RIGHT;
        public static final ClosePosition CENTER;
        public static final ClosePosition TOP_CENTER;
        public static final ClosePosition TOP_LEFT;
        public static final ClosePosition TOP_RIGHT;
        private final int mGravity;

        public static ClosePosition valueOf(String s)
        {
            return (ClosePosition)Enum.valueOf(com/mopub/common/CloseableLayout$ClosePosition, s);
        }

        public static ClosePosition[] values()
        {
            return (ClosePosition[])$VALUES.clone();
        }

        final int getGravity()
        {
            return mGravity;
        }

        static 
        {
            TOP_LEFT = new ClosePosition("TOP_LEFT", 0, 51);
            TOP_CENTER = new ClosePosition("TOP_CENTER", 1, 49);
            TOP_RIGHT = new ClosePosition("TOP_RIGHT", 2, 53);
            CENTER = new ClosePosition("CENTER", 3, 17);
            BOTTOM_LEFT = new ClosePosition("BOTTOM_LEFT", 4, 83);
            BOTTOM_CENTER = new ClosePosition("BOTTOM_CENTER", 5, 81);
            BOTTOM_RIGHT = new ClosePosition("BOTTOM_RIGHT", 6, 85);
            $VALUES = (new ClosePosition[] {
                TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
            });
        }

        private ClosePosition(String s, int i, int j)
        {
            super(s, i);
            mGravity = j;
        }
    }


    private class OnCloseListener
    {

        public abstract void onClose();
    }


    private class UnsetPressedState
        implements Runnable
    {

        final CloseableLayout this$0;

        public final void run()
        {
            setClosePressed(false);
        }

        private UnsetPressedState()
        {
            this$0 = CloseableLayout.this;
            super();
        }

    }

}

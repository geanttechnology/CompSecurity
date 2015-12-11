// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;

public class ViewItSlidingDrawer extends ViewGroup
{
    private class DrawerToggler
        implements android.view.View.OnClickListener
    {

        final ViewItSlidingDrawer this$0;

        public void onClick(View view)
        {
            if (mLocked)
            {
                return;
            }
            if (mAnimateOnClick)
            {
                animateToggle();
                return;
            } else
            {
                toggle();
                return;
            }
        }

        private DrawerToggler()
        {
            this$0 = ViewItSlidingDrawer.this;
            super();
        }

    }

    public static interface OnDrawerCloseListener
    {

        public abstract void onDrawerClosed();
    }

    public static interface OnDrawerOpenListener
    {

        public abstract void onDrawerOpened();
    }

    public static interface OnDrawerScrollListener
    {

        public abstract void onScrollEnded();

        public abstract void onScrollStarted();
    }

    private class SlidingHandler extends Handler
    {

        final ViewItSlidingDrawer this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 1000: 
                doAnimation();
                break;
            }
        }

        private SlidingHandler()
        {
            this$0 = ViewItSlidingDrawer.this;
            super();
        }

    }


    private float mActionMoveThreshold;
    private boolean mAllowSingleTap;
    private boolean mAnimateOnClick;
    private float mAnimatedAcceleration;
    private float mAnimatedVelocity;
    private boolean mAnimating;
    private long mAnimationLastTime;
    private float mAnimationPosition;
    protected int mBottomOffset;
    private View mContent;
    private final int mContentId;
    private long mCurrentAnimationTime;
    private boolean mExpanded;
    private final Rect mFrame;
    private View mHandle;
    private final int mHandleId;
    private final Handler mHandler;
    private final Rect mInvalidate;
    private float mLastMotionPositionY;
    private boolean mLocked;
    private final int mMaximumAcceleration;
    private final int mMaximumMajorVelocity;
    private final int mMaximumTapVelocity;
    private OnDrawerCloseListener mOnDrawerCloseListener;
    private OnDrawerOpenListener mOnDrawerOpenListener;
    private OnDrawerScrollListener mOnDrawerScrollListener;
    private boolean mRequestInterceptTouchEvent;
    private boolean mShowContentAfterClose;
    private final int mTapThreshold;
    private int mTopOffset;
    private int mTouchDelta;
    private boolean mTracking;
    private VelocityTracker mVelocityTracker;
    private final int mVelocityUnits;
    protected boolean mVertical;

    public ViewItSlidingDrawer(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ViewItSlidingDrawer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFrame = new Rect();
        mInvalidate = new Rect();
        mLocked = false;
        mHandler = new SlidingHandler();
        mLastMotionPositionY = 0.0F;
        mRequestInterceptTouchEvent = false;
        mActionMoveThreshold = 10F;
        context = context.obtainStyledAttributes(attributeset, com.amazon.mShop.android.lib.R.styleable.AmazonSlidingDrawer, i, 0);
        boolean flag;
        if (context.getInt(2, 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mVertical = flag;
        mBottomOffset = (int)context.getDimension(3, 0.0F);
        mTopOffset = (int)context.getDimension(4, 0.0F);
        mAllowSingleTap = context.getBoolean(5, true);
        mAnimateOnClick = context.getBoolean(6, true);
        mShowContentAfterClose = context.getBoolean(7, false);
        i = context.getResourceId(0, 0);
        if (i == 0)
        {
            throw new IllegalArgumentException("The handle attribute is required and must refer to a valid child.");
        }
        int j = context.getResourceId(1, 0);
        if (j == 0)
        {
            throw new IllegalArgumentException("The content attribute is required and must refer to a valid child.");
        }
        if (i == j)
        {
            throw new IllegalArgumentException("The content and handle attributes must refer to different children.");
        } else
        {
            mHandleId = i;
            mContentId = j;
            float f = getResources().getDisplayMetrics().density;
            mTapThreshold = (int)(1.0F * f + 0.5F);
            mMaximumTapVelocity = (int)(300F * f + 0.5F);
            mMaximumMajorVelocity = (int)(200F * f + 0.5F);
            mMaximumAcceleration = (int)(1000F * f + 0.5F);
            mVelocityUnits = (int)(1000F * f + 0.5F);
            context.recycle();
            setAlwaysDrawnWithCacheEnabled(false);
            return;
        }
    }

    private void animateClose(int i)
    {
        prepareTracking(i);
        float f;
        if (mVertical)
        {
            f = mMaximumAcceleration;
        } else
        {
            f = -mMaximumAcceleration;
        }
        performFling(i, f, true);
    }

    private void animateOpen(int i)
    {
        prepareTracking(i);
        float f;
        if (mVertical)
        {
            f = -mMaximumAcceleration;
        } else
        {
            f = mMaximumAcceleration;
        }
        performFling(i, f, true);
    }

    private void closeDrawer()
    {
        mExpanded = false;
        moveHandle(-10002);
        if (mShowContentAfterClose && (float)mBottomOffset != 0.0F)
        {
            mContent.setVisibility(0);
        } else
        {
            mContent.setVisibility(8);
        }
        if (mOnDrawerCloseListener != null)
        {
            mOnDrawerCloseListener.onDrawerClosed();
        }
    }

    private void doAnimation()
    {
label0:
        {
label1:
            {
                if (mAnimating)
                {
                    incrementAnimation();
                    if (!mVertical)
                    {
                        break label0;
                    }
                    if (mAnimationPosition < (float)((mBottomOffset + getHeight()) - mHandle.getHeight()))
                    {
                        break label1;
                    }
                    mAnimating = false;
                    closeDrawer();
                }
                return;
            }
            if (mAnimationPosition <= (float)mTopOffset)
            {
                mAnimating = false;
                openDrawer();
                return;
            } else
            {
                moveHandle((int)mAnimationPosition);
                mCurrentAnimationTime = mCurrentAnimationTime + 16L;
                mHandler.sendMessageAtTime(mHandler.obtainMessage(1000), mCurrentAnimationTime);
                return;
            }
        }
        if (mAnimationPosition <= (float)(mBottomOffset + mHandle.getWidth()))
        {
            mAnimating = false;
            closeDrawer();
            return;
        }
        if (mAnimationPosition >= (float)(mTopOffset + getWidth()))
        {
            mAnimating = false;
            openDrawer();
            return;
        } else
        {
            moveHandle((int)mAnimationPosition);
            mCurrentAnimationTime = mCurrentAnimationTime + 16L;
            mHandler.sendMessageAtTime(mHandler.obtainMessage(1000), mCurrentAnimationTime);
            return;
        }
    }

    private void incrementAnimation()
    {
        long l = SystemClock.uptimeMillis();
        float f = (float)(l - mAnimationLastTime) / 1000F;
        float f1 = mAnimationPosition;
        float f2 = mAnimatedVelocity;
        float f3 = mAnimatedAcceleration;
        mAnimationPosition = f2 * f + f1 + 0.5F * f3 * f * f;
        mAnimatedVelocity = f3 * f + f2;
        mAnimationLastTime = l;
    }

    private void moveHandle(int i)
    {
        View view;
        Object obj;
        view = mHandle;
        obj = mContent;
        float f;
        if (i == -10001)
        {
            f = 0.0F;
        } else
        if (i == -10002)
        {
            f = 1.0F;
        } else
        {
            f = (float)view.getTop() / (float)(((getHeight() - mTopOffset) + mBottomOffset) - view.getHeight());
        }
        updateHandleBackground(f);
        if (!mVertical) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        if (i == -10001)
        {
            view.offsetTopAndBottom(mTopOffset - view.getTop());
            ((View) (obj)).layout(0, view.getBottom(), ((View) (obj)).getMeasuredWidth(), view.getBottom() + ((View) (obj)).getMeasuredHeight());
            invalidate();
            return;
        }
        if (i == -10002)
        {
            view.offsetTopAndBottom((mBottomOffset + getBottom()) - getTop() - view.getHeight() - view.getTop());
            ((View) (obj)).layout(0, view.getBottom(), ((View) (obj)).getMeasuredWidth(), view.getBottom() + ((View) (obj)).getMeasuredHeight());
            invalidate();
            return;
        }
        k = view.getTop();
        j = i - k;
        if (i >= mTopOffset) goto _L4; else goto _L3
_L3:
        i = mTopOffset - k;
_L5:
        view.offsetTopAndBottom(i);
        j = getBottom();
        k = mHandle.getBottom();
        ((View) (obj)).measure(android.view.View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j - k, 0x40000000));
        ((View) (obj)).layout(0, view.getBottom(), ((View) (obj)).getMeasuredWidth(), view.getBottom() + ((View) (obj)).getMeasuredHeight());
        obj = mFrame;
        Rect rect = mInvalidate;
        view.getHitRect(((Rect) (obj)));
        rect.set(((Rect) (obj)));
        rect.union(((Rect) (obj)).left, ((Rect) (obj)).top - i, ((Rect) (obj)).right, ((Rect) (obj)).bottom - i);
        rect.union(0, ((Rect) (obj)).bottom - i, getWidth(), (((Rect) (obj)).bottom - i) + mContent.getHeight());
        invalidate(rect);
        return;
_L4:
        i = j;
        if (j > (mBottomOffset + getBottom()) - getTop() - view.getHeight() - k)
        {
            i = (mBottomOffset + getBottom()) - getTop() - view.getHeight() - k;
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (i == -10001)
        {
            view.offsetLeftAndRight((mTopOffset + getRight()) - getLeft() - view.getRight());
            ((View) (obj)).layout(view.getRight(), 0, getWidth(), getHeight());
            invalidate();
            return;
        }
        if (i == -10002)
        {
            view.offsetLeftAndRight((mBottomOffset + view.getWidth()) - view.getRight());
            ((View) (obj)).layout(view.getRight(), 0, getWidth(), getHeight());
            invalidate();
            return;
        }
        k = view.getRight();
        j = i - k;
        if (i >= mBottomOffset + view.getWidth()) goto _L7; else goto _L6
_L6:
        j = (mBottomOffset + view.getWidth()) - k;
_L9:
        view.offsetLeftAndRight(j);
        ((View) (obj)).measure(android.view.View.MeasureSpec.makeMeasureSpec(getRight() - mHandle.getRight(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 0x40000000));
        ((View) (obj)).layout(mHandle.getRight(), 0, getWidth(), getHeight());
        obj = mFrame;
        Rect rect1 = mInvalidate;
        view.getHitRect(((Rect) (obj)));
        rect1.set(((Rect) (obj)));
        rect1.union(((Rect) (obj)).left - j, ((Rect) (obj)).top, ((Rect) (obj)).right - j, ((Rect) (obj)).bottom);
        invalidate(rect1);
        return;
_L7:
        if (i > (getRight() - getLeft()) + mTopOffset)
        {
            j = ((getRight() - getLeft()) + mTopOffset) - k;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void openDrawer()
    {
        mExpanded = true;
        moveHandle(-10001);
        mContent.setVisibility(0);
        if (mOnDrawerOpenListener != null)
        {
            mOnDrawerOpenListener.onDrawerOpened();
        }
    }

    private void performFling(int i, float f, boolean flag)
    {
        mAnimationPosition = i;
        mAnimatedVelocity = f;
        if (!mExpanded) goto _L2; else goto _L1
_L1:
        if (!mVertical) goto _L4; else goto _L3
_L3:
        if (!flag && f <= (float)mMaximumMajorVelocity && (i <= getHeight() / 2 || f <= (float)(-mMaximumMajorVelocity))) goto _L6; else goto _L5
_L5:
        mAnimatedAcceleration = mMaximumAcceleration;
        if (f < 0.0F)
        {
            mAnimatedVelocity = 0.0F;
        }
_L8:
        long l = SystemClock.uptimeMillis();
        mAnimationLastTime = l;
        mCurrentAnimationTime = 16L + l;
        mAnimating = true;
        mHandler.removeMessages(1000);
        mHandler.sendMessageAtTime(mHandler.obtainMessage(1000), mCurrentAnimationTime);
        stopTracking();
        return;
_L6:
        mAnimatedAcceleration = -mMaximumAcceleration;
        if (f > 0.0F)
        {
            mAnimatedVelocity = 0.0F;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (flag || f < (float)(-mMaximumMajorVelocity) || i < getWidth() / 2 && f < (float)mMaximumMajorVelocity)
        {
            mAnimatedAcceleration = -mMaximumAcceleration;
            if (f > 0.0F)
            {
                mAnimatedVelocity = 0.0F;
            }
        } else
        {
            mAnimatedAcceleration = mMaximumAcceleration;
            if (f < 0.0F)
            {
                mAnimatedVelocity = 0.0F;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (mVertical)
        {
            if (!flag && (f > (float)mMaximumMajorVelocity || i > getHeight() / 2 && f > (float)(-mMaximumMajorVelocity)))
            {
                mAnimatedAcceleration = mMaximumAcceleration;
                if (f < 0.0F)
                {
                    mAnimatedVelocity = 0.0F;
                }
            } else
            {
                mAnimatedAcceleration = -mMaximumAcceleration;
                if (f > 0.0F)
                {
                    mAnimatedVelocity = 0.0F;
                }
            }
        } else
        if (!flag && (f < (float)(-mMaximumMajorVelocity) || i < getWidth() / 2 && f < (float)mMaximumMajorVelocity))
        {
            mAnimatedAcceleration = -mMaximumAcceleration;
            if (f > 0.0F)
            {
                mAnimatedVelocity = 0.0F;
            }
        } else
        {
            mAnimatedAcceleration = mMaximumAcceleration;
            if (f < 0.0F)
            {
                mAnimatedVelocity = 0.0F;
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void prepareTracking(int i)
    {
        mTracking = true;
        mVelocityTracker = VelocityTracker.obtain();
        boolean flag;
        if (!mExpanded)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            mAnimatedAcceleration = mMaximumAcceleration;
            mAnimatedVelocity = mMaximumMajorVelocity;
            float f;
            long l;
            if (mVertical)
            {
                i = (mBottomOffset + getHeight()) - mHandle.getHeight();
            } else
            {
                i = mBottomOffset + mHandle.getWidth();
            }
            mAnimationPosition = i;
            f = mAnimationPosition;
            if (mVertical)
            {
                i = mHandle.getTop();
            } else
            {
                i = mHandle.getRight();
            }
            if (f != (float)i)
            {
                moveHandle((int)mAnimationPosition);
            }
            mAnimating = true;
            mHandler.removeMessages(1000);
            l = SystemClock.uptimeMillis();
            mAnimationLastTime = l;
            mCurrentAnimationTime = 16L + l;
            mAnimating = true;
        } else
        {
            if (mAnimating)
            {
                mAnimating = false;
                mHandler.removeMessages(1000);
            }
            int j;
            if (mVertical)
            {
                j = mHandle.getTop();
            } else
            {
                j = mHandle.getRight();
            }
            if (i != j)
            {
                moveHandle(i);
                return;
            }
        }
    }

    private void stopTracking()
    {
        mHandle.setPressed(false);
        mTracking = false;
        if (mOnDrawerScrollListener != null)
        {
            mOnDrawerScrollListener.onScrollEnded();
        }
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    public void animateClose()
    {
        mTracking = true;
        prepareContent();
        OnDrawerScrollListener ondrawerscrolllistener = mOnDrawerScrollListener;
        if (ondrawerscrolllistener != null)
        {
            ondrawerscrolllistener.onScrollStarted();
        }
        int i;
        if (mVertical)
        {
            i = mHandle.getTop();
        } else
        {
            i = mHandle.getRight();
        }
        animateClose(i);
        if (ondrawerscrolllistener != null)
        {
            ondrawerscrolllistener.onScrollEnded();
        }
    }

    public void animateOpen()
    {
        mTracking = true;
        prepareContent();
        OnDrawerScrollListener ondrawerscrolllistener = mOnDrawerScrollListener;
        if (ondrawerscrolllistener != null)
        {
            ondrawerscrolllistener.onScrollStarted();
        }
        int i;
        if (mVertical)
        {
            i = mHandle.getTop();
        } else
        {
            i = mHandle.getRight();
        }
        animateOpen(i);
        sendAccessibilityEvent(32);
        if (ondrawerscrolllistener != null)
        {
            ondrawerscrolllistener.onScrollEnded();
        }
    }

    public void animateToggle()
    {
        if (!mExpanded)
        {
            animateOpen();
            return;
        } else
        {
            animateClose();
            return;
        }
    }

    public void close()
    {
        closeDrawer();
        invalidate();
        requestLayout();
    }

    protected void dispatchDraw(Canvas canvas)
    {
        long l = getDrawingTime();
        drawChild(canvas, mHandle, l);
        if (mTracking || mAnimating)
        {
            drawChild(canvas, mContent, l);
            return;
        }
        if (mExpanded)
        {
            drawChild(canvas, mContent, l);
            return;
        }
        if (mShowContentAfterClose && (float)mBottomOffset != 0.0F)
        {
            mContent.setVisibility(0);
            drawChild(canvas, mContent, l);
            return;
        } else
        {
            mContent.setVisibility(8);
            return;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (mRequestInterceptTouchEvent)
        {
            mRequestInterceptTouchEvent = false;
            if (onInterceptTouchEvent(motionevent))
            {
                motionevent.setAction(3);
            }
            return super.dispatchTouchEvent(motionevent);
        } else
        {
            return super.dispatchTouchEvent(motionevent);
        }
    }

    public View getContent()
    {
        return mContent;
    }

    public View getHandle()
    {
        return mHandle;
    }

    public boolean isClosed()
    {
        return !mExpanded && !mTracking && !mAnimating;
    }

    public boolean isMoving()
    {
        return mTracking || mAnimating;
    }

    public boolean isOpened()
    {
        return mExpanded;
    }

    protected boolean isScrolledToTop()
    {
        return false;
    }

    protected void onFinishInflate()
    {
        mHandle = findViewById(mHandleId);
        if (mHandle == null)
        {
            throw new IllegalArgumentException("The handle attribute is must refer to an existing child.");
        }
        mHandle.setOnClickListener(new DrawerToggler());
        mContent = findViewById(mContentId);
        if (mContent == null)
        {
            throw new IllegalArgumentException("The content attribute is must refer to an existing child.");
        } else
        {
            mContent.setVisibility(8);
            return;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        float f;
        float f1;
        Rect rect;
        View view;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        int k;
label0:
        {
            if (mLocked)
            {
                return false;
            }
            k = motionevent.getAction();
            f = motionevent.getX();
            f1 = motionevent.getY();
            flag2 = false;
            flag3 = false;
            if (k == 0)
            {
                mLastMotionPositionY = f1;
            }
            if (k != 2)
            {
                break label0;
            }
            boolean flag;
            if (f1 - mLastMotionPositionY > mActionMoveThreshold)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mLastMotionPositionY - f1 > mActionMoveThreshold)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag)
            {
                flag2 = flag;
                flag3 = flag1;
                if (!flag1)
                {
                    break label0;
                }
            }
            mLastMotionPositionY = f1;
            flag3 = flag1;
            flag2 = flag;
        }
        rect = mFrame;
        view = mHandle;
        view.getHitRect(rect);
        flag1 = false;
        if (mTracking || mAnimating)
        {
            return false;
        }
        int i;
        if (!rect.contains((int)f, (int)f1))
        {
            i = ((flag1) ? 1 : 0);
            if (k == 2)
            {
                if (mExpanded)
                {
                    i = ((flag1) ? 1 : 0);
                    if (flag2)
                    {
                        i = ((flag1) ? 1 : 0);
                        if (isScrolledToTop())
                        {
                            i = 1;
                        }
                    }
                } else
                {
                    i = ((flag1) ? 1 : 0);
                    if (!isMoving())
                    {
                        i = ((flag1) ? 1 : 0);
                        if (flag3)
                        {
                            i = 1;
                        }
                    }
                }
            }
        } else
        {
            i = 1;
        }
        if ((k == 0 || k == 2) && i != 0)
        {
            mTracking = true;
            view.setPressed(true);
            prepareContent();
            if (mOnDrawerScrollListener != null)
            {
                mOnDrawerScrollListener.onScrollStarted();
            }
            if (mVertical)
            {
                i = mHandle.getTop();
                mTouchDelta = (int)f1 - i;
                prepareTracking(i);
            } else
            {
                int j = mHandle.getRight();
                mTouchDelta = (int)f - j;
                prepareTracking(j);
            }
            mVelocityTracker.addMovement(motionevent);
            return true;
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (mTracking)
        {
            return;
        }
        i = k - i;
        j = l - j;
        View view = mHandle;
        l = view.getMeasuredWidth();
        int i1 = view.getMeasuredHeight();
        View view1 = mContent;
        if (mVertical)
        {
            k = (i - l) / 2;
            if (mExpanded)
            {
                i = mTopOffset;
            } else
            {
                i = (j - i1) + mBottomOffset;
            }
            view1.layout(0, i + i1, view1.getMeasuredWidth(), mTopOffset + i1 + view1.getMeasuredHeight());
            j = i;
            i = k;
        } else
        {
            if (mExpanded)
            {
                i = (i - l) + mTopOffset;
            } else
            {
                i = mBottomOffset;
            }
            j = (j - i1) / 2;
            view1.layout(0, 0, view1.getMeasuredWidth(), view1.getMeasuredHeight());
        }
        view.layout(i, j, i + l, j + i1);
    }

    protected void onMeasure(int i, int j)
    {
        int i1 = android.view.View.MeasureSpec.getMode(i);
        int k = android.view.View.MeasureSpec.getSize(i);
        int k1 = android.view.View.MeasureSpec.getMode(j);
        int l = android.view.View.MeasureSpec.getSize(j);
        if (i1 == 0 || k1 == 0)
        {
            throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
        }
        View view = mHandle;
        measureChild(view, i, j);
        if (mVertical)
        {
            j = view.getMeasuredHeight();
            int j1 = mTopOffset;
            if (mShowContentAfterClose)
            {
                i = 0;
            } else
            {
                i = mBottomOffset;
            }
            mContent.measure(android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec((l - j - j1) + i, 0x40000000));
        } else
        if (!mExpanded && !mTracking && !mAnimating)
        {
            i = mBottomOffset;
            mContent.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(l, 0x40000000));
        } else
        {
            i = view.getMeasuredWidth();
            j = mTopOffset;
            mContent.measure(android.view.View.MeasureSpec.makeMeasureSpec((k - i) + j, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(l, 0x40000000));
        }
        setMeasuredDimension(k, l);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mLocked)
        {
            return true;
        }
        if (!mTracking) goto _L2; else goto _L1
_L1:
        mVelocityTracker.addMovement(motionevent);
        motionevent.getAction();
        JVM INSTR tableswitch 1 3: default 56
    //                   1 118
    //                   2 84
    //                   3 118;
           goto _L3 _L4 _L5 _L4
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_118;
_L2:
        float f;
        float f1;
        VelocityTracker velocitytracker;
        int i;
        int j;
        boolean flag;
        if (mTracking || mAnimating || super.onTouchEvent(motionevent))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
_L5:
        if (mVertical)
        {
            f = motionevent.getY();
        } else
        {
            f = motionevent.getX();
        }
        moveHandle((int)f - mTouchDelta);
          goto _L2
        velocitytracker = mVelocityTracker;
        velocitytracker.computeCurrentVelocity(mVelocityUnits);
        f = velocitytracker.getYVelocity();
        f1 = velocitytracker.getXVelocity();
        flag = mVertical;
        if (!mVertical)
        {
            f = f1;
        }
        i = mHandle.getTop();
        j = mHandle.getRight();
        if (Math.abs(f) < (float)mMaximumTapVelocity)
        {
            if (flag ? mExpanded && i < mTapThreshold + mTopOffset || !mExpanded && i > (mBottomOffset + getBottom()) - getTop() - mHandle.getHeight() - mTapThreshold : mExpanded && j > (mTopOffset + getRight()) - getLeft() - mTapThreshold || !mExpanded && j < mBottomOffset + mHandle.getWidth() + mTapThreshold)
            {
                if (mAllowSingleTap)
                {
                    if (mExpanded)
                    {
                        if (!flag)
                        {
                            i = j;
                        }
                        animateClose(i);
                    } else
                    {
                        if (!flag)
                        {
                            i = j;
                        }
                        animateOpen(i);
                    }
                } else
                {
                    if (!flag)
                    {
                        i = j;
                    }
                    performFling(i, f, false);
                }
            } else
            {
                if (!flag)
                {
                    i = j;
                }
                performFling(i, f, false);
            }
        } else
        {
            if (!flag)
            {
                i = j;
            }
            performFling(i, f, false);
        }
          goto _L2
    }

    protected void prepareContent()
    {
        if (mAnimating)
        {
            return;
        }
        if (mVertical)
        {
            int k = mHandle.getHeight();
            int i1 = getBottom();
            int k1 = getTop();
            int i2 = mTopOffset;
            int i;
            if (mShowContentAfterClose)
            {
                i = 0;
            } else
            {
                i = mBottomOffset;
            }
            mContent.measure(android.view.View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec((i1 - k1 - k - i2) + i, 0x40000000));
            mContent.layout(0, mHandle.getBottom(), mContent.getMeasuredWidth(), mHandle.getBottom() + mContent.getMeasuredHeight());
        } else
        {
            int j = mHandle.getWidth();
            int l = getRight();
            int j1 = getLeft();
            int l1 = mTopOffset;
            mContent.measure(android.view.View.MeasureSpec.makeMeasureSpec((l - j1 - j) + l1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 0x40000000));
            mContent.layout(0, 0, mContent.getMeasuredWidth(), mContent.getMeasuredHeight());
        }
        mContent.setVisibility(8);
    }

    protected void requestInterceptTouchEvent()
    {
        mRequestInterceptTouchEvent = true;
    }

    public void setOnDrawerCloseListener(OnDrawerCloseListener ondrawercloselistener)
    {
        mOnDrawerCloseListener = ondrawercloselistener;
    }

    public void setOnDrawerOpenListener(OnDrawerOpenListener ondraweropenlistener)
    {
        mOnDrawerOpenListener = ondraweropenlistener;
    }

    public void setOnDrawerScrollListener(OnDrawerScrollListener ondrawerscrolllistener)
    {
        mOnDrawerScrollListener = ondrawerscrolllistener;
    }

    public void toggle()
    {
        if (!mExpanded)
        {
            openDrawer();
        } else
        {
            closeDrawer();
        }
        invalidate();
        requestLayout();
    }

    public void updateHandleBackground(float f)
    {
    }



}

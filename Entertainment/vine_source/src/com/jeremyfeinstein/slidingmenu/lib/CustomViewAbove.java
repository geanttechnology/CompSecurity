// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            CustomViewBehind, SlidingMenu

public class CustomViewAbove extends ViewGroup
{
    public static interface OnPageChangeListener
    {

        public abstract void onPageScrolled(int i, float f, int j);

        public abstract void onPageSelected(int i);
    }

    public static class SimpleOnPageChangeListener
        implements OnPageChangeListener
    {

        public void onPageScrollStateChanged(int i)
        {
        }

        public void onPageScrolled(int i, float f, int j)
        {
        }

        public void onPageSelected(int i)
        {
        }

        public SimpleOnPageChangeListener()
        {
        }
    }


    private static final boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final String TAG = "CustomViewAbove";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() {

        public float getInterpolation(float f)
        {
            f--;
            return f * f * f * f * f + 1.0F;
        }

    };
    protected int mActivePointerId;
    private SlidingMenu.OnClosedListener mClosedListener;
    private View mContent;
    private int mCurItem;
    private boolean mEnabled;
    private int mFlingDistance;
    private List mIgnoredViews;
    private float mInitialMotionX;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private boolean mLastIntersecption;
    private float mLastMotionX;
    private float mLastMotionY;
    protected int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnPageChangeListener mOnPageChangeListener;
    private SlidingMenu.OnOpenedListener mOpenedListener;
    private boolean mQuickReturn;
    private float mScrollX;
    private Scroller mScroller;
    private boolean mScrolling;
    private boolean mScrollingCacheEnabled;
    protected int mTouchMode;
    private int mTouchSlop;
    protected VelocityTracker mVelocityTracker;
    private CustomViewBehind mViewBehind;

    public CustomViewAbove(Context context)
    {
        this(context, null);
    }

    public CustomViewAbove(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mActivePointerId = -1;
        mEnabled = true;
        mIgnoredViews = new ArrayList();
        mTouchMode = 0;
        mQuickReturn = false;
        mScrollX = 0.0F;
        initCustomViewAbove();
    }

    private void completeScroll()
    {
        if (!mScrolling) goto _L2; else goto _L1
_L1:
        setScrollingCacheEnabled(false);
        mScroller.abortAnimation();
        int i = getScrollX();
        int j = getScrollY();
        int k = mScroller.getCurrX();
        int l = mScroller.getCurrY();
        if (i != k || j != l)
        {
            scrollTo(k, l);
        }
        if (!isMenuOpen()) goto _L4; else goto _L3
_L3:
        if (mOpenedListener != null)
        {
            mOpenedListener.onOpened();
        }
_L2:
        mScrolling = false;
        return;
_L4:
        if (mClosedListener != null)
        {
            mClosedListener.onClosed();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private int determineTargetPage(float f, int i, int j)
    {
        int l;
        l = mCurItem;
        if (Math.abs(j) <= mFlingDistance || Math.abs(i) <= mMinimumVelocity)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (i <= 0 || j <= 0) goto _L2; else goto _L1
_L1:
        int k = l - 1;
_L4:
        return k;
_L2:
        k = l;
        if (i >= 0) goto _L4; else goto _L3
_L3:
        k = l;
        if (j >= 0) goto _L4; else goto _L5
_L5:
        return l + 1;
        return Math.round((float)mCurItem + f);
    }

    private void endDrag()
    {
        mQuickReturn = false;
        mIsBeingDragged = false;
        mIsUnableToDrag = false;
        mActivePointerId = -1;
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private int getLeftBound()
    {
        return mViewBehind.getAbsLeftBound(mContent);
    }

    private int getPointerIndex(MotionEvent motionevent, int i)
    {
        i = MotionEventCompat.findPointerIndex(motionevent, i);
        if (i == -1)
        {
            mActivePointerId = -1;
        }
        return i;
    }

    private int getRightBound()
    {
        return mViewBehind.getAbsRightBound(mContent);
    }

    private boolean isInIgnoredView(MotionEvent motionevent)
    {
        Rect rect = new Rect();
        for (Iterator iterator = mIgnoredViews.iterator(); iterator.hasNext();)
        {
            ((View)iterator.next()).getHitRect(rect);
            if (rect.contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                return true;
            }
        }

        return false;
    }

    private void onSecondaryPointerUp(MotionEvent motionevent)
    {
        int i = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, i) == mActivePointerId)
        {
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            mLastMotionX = MotionEventCompat.getX(motionevent, i);
            mActivePointerId = MotionEventCompat.getPointerId(motionevent, i);
            if (mVelocityTracker != null)
            {
                mVelocityTracker.clear();
            }
        }
    }

    private void pageScrolled(int i)
    {
        int j = getWidth();
        int k = i / j;
        i %= j;
        onPageScrolled(k, (float)i / (float)j, i);
    }

    private void setScrollingCacheEnabled(boolean flag)
    {
        if (mScrollingCacheEnabled != flag)
        {
            mScrollingCacheEnabled = flag;
        }
    }

    private void startDrag()
    {
        mIsBeingDragged = true;
        mQuickReturn = false;
    }

    private boolean thisSlideAllowed(float f)
    {
        if (isMenuOpen())
        {
            return mViewBehind.menuOpenSlideAllowed(f);
        } else
        {
            return mViewBehind.menuClosedSlideAllowed(f);
        }
    }

    private boolean thisTouchAllowed(MotionEvent motionevent)
    {
        int i;
        boolean flag1;
        flag1 = false;
        i = (int)(motionevent.getX() + mScrollX);
        if (!isMenuOpen()) goto _L2; else goto _L1
_L1:
        boolean flag = mViewBehind.menuOpenTouchAllowed(mContent, mCurItem, i);
_L4:
        return flag;
_L2:
        flag = flag1;
        switch (mTouchMode)
        {
        default:
            return false;

        case 2: // '\002'
            break;

        case 0: // '\0'
            return mViewBehind.marginTouchAllowed(mContent, i);

        case 1: // '\001'
            flag = flag1;
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (isInIgnoredView(motionevent)) goto _L4; else goto _L5
_L5:
        return true;
    }

    public void addIgnoredView(View view)
    {
        if (!mIgnoredViews.contains(view))
        {
            mIgnoredViews.add(view);
        }
    }

    public void addMovement(MotionEvent motionevent)
    {
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        if (mVelocityTracker != null)
        {
            mVelocityTracker.addMovement(motionevent);
        }
    }

    public boolean arrowScroll(int i)
    {
        View view;
        View view1;
        boolean flag;
        view1 = findFocus();
        view = view1;
        if (view1 == this)
        {
            view = null;
        }
        flag = false;
        view1 = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (view1 == null || view1 == view) goto _L2; else goto _L1
_L1:
        if (i != 17) goto _L4; else goto _L3
_L3:
        flag = view1.requestFocus();
_L6:
        if (flag)
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return flag;
_L4:
        if (i == 66)
        {
            if (view != null && view1.getLeft() <= view.getLeft())
            {
                flag = pageRight();
            } else
            {
                flag = view1.requestFocus();
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i == 17 || i == 1)
        {
            flag = pageLeft();
        } else
        if (i == 66 || i == 2)
        {
            flag = pageRight();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected boolean canScroll(View view, boolean flag, int i, int j, int k)
    {
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i1 = view.getScrollX();
            int j1 = view.getScrollY();
            for (int l = viewgroup.getChildCount() - 1; l >= 0; l--)
            {
                View view1 = viewgroup.getChildAt(l);
                if (j + i1 >= view1.getLeft() && j + i1 < view1.getRight() && k + j1 >= view1.getTop() && k + j1 < view1.getBottom() && canScroll(view1, true, i, (j + i1) - view1.getLeft(), (k + j1) - view1.getTop()))
                {
                    return true;
                }
            }

        }
        return flag && ViewCompat.canScrollHorizontally(view, -i);
    }

    public void clearIgnoredViews()
    {
        mIgnoredViews.clear();
    }

    public void computeScroll()
    {
        if (!mScroller.isFinished() && mScroller.computeScrollOffset())
        {
            int i = getScrollX();
            int j = getScrollY();
            int k = mScroller.getCurrX();
            int l = mScroller.getCurrY();
            if (i != k || j != l)
            {
                scrollTo(k, l);
                pageScrolled(k);
            }
            invalidate();
            return;
        } else
        {
            completeScroll();
            return;
        }
    }

    public void determineDrag(MotionEvent motionevent)
    {
        int i = mActivePointerId;
        int k = getPointerIndex(motionevent, i);
        if (i != -1 && k != -1)
        {
            float f = MotionEventCompat.getX(motionevent, k);
            float f1 = f - mLastMotionX;
            float f2 = Math.abs(f1);
            float f3 = MotionEventCompat.getY(motionevent, k);
            float f4 = Math.abs(f3 - mLastMotionY);
            int j;
            if (isMenuOpen())
            {
                j = mTouchSlop / 2;
            } else
            {
                j = mTouchSlop;
            }
            if (f2 > (float)j && f2 > f4 && thisSlideAllowed(f1))
            {
                startDrag();
                mLastMotionX = f;
                mLastMotionY = f3;
                setScrollingCacheEnabled(true);
                return;
            }
            if (f2 > (float)mTouchSlop)
            {
                mIsUnableToDrag = true;
                return;
            }
        }
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        mViewBehind.drawShadow(mContent, canvas);
        mViewBehind.drawFade(mContent, canvas, getPercentOpen());
        mViewBehind.drawSelector(mContent, canvas, getPercentOpen());
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyEvent(keyevent) || executeKeyEvent(keyevent);
    }

    float distanceInfluenceForSnapDuration(float f)
    {
        return FloatMath.sin((float)((double)(f - 0.5F) * 0.4712389167638204D));
    }

    public boolean executeKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 44
    //                   21: 46
    //                   22: 53
    //                   61: 60;
           goto _L2 _L3 _L4 _L5
_L2:
        return false;
_L3:
        return arrowScroll(17);
_L4:
        return arrowScroll(66);
_L5:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            if (KeyEventCompat.hasNoModifiers(keyevent))
            {
                return arrowScroll(2);
            }
            if (KeyEventCompat.hasModifiers(keyevent, 1))
            {
                return arrowScroll(1);
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public int getBehindWidth()
    {
        if (mViewBehind == null)
        {
            return 0;
        } else
        {
            return mViewBehind.getBehindWidth();
        }
    }

    public int getChildWidth(int i)
    {
        switch (i)
        {
        default:
            return 0;

        case 0: // '\0'
            return getBehindWidth();

        case 1: // '\001'
            return mContent.getWidth();
        }
    }

    public View getContent()
    {
        return mContent;
    }

    public int getContentLeft()
    {
        return mContent.getLeft() + mContent.getPaddingLeft();
    }

    public int getCurrentItem()
    {
        return mCurItem;
    }

    public int getDestScrollX(int i)
    {
        switch (i)
        {
        default:
            return 0;

        case 0: // '\0'
        case 2: // '\002'
            return mViewBehind.getMenuLeft(mContent, i);

        case 1: // '\001'
            return mContent.getLeft();
        }
    }

    protected float getPercentOpen()
    {
        return Math.abs(mScrollX - (float)mContent.getLeft()) / (float)getBehindWidth();
    }

    public int getTouchMode()
    {
        return mTouchMode;
    }

    void initCustomViewAbove()
    {
        setWillNotDraw(false);
        setDescendantFocusability(0x40000);
        setFocusable(true);
        Context context = getContext();
        mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewconfiguration);
        mMinimumVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        setInternalPageChangeListener(new SimpleOnPageChangeListener() {

            final CustomViewAbove this$0;

            public void onPageSelected(int i)
            {
                if (mViewBehind == null) goto _L2; else goto _L1
_L1:
                i;
                JVM INSTR tableswitch 0 2: default 36
            //                           0 37
            //                           1 49
            //                           2 37;
                   goto _L2 _L3 _L4 _L3
_L2:
                return;
_L3:
                mViewBehind.setChildrenEnabled(true);
                return;
_L4:
                mViewBehind.setChildrenEnabled(false);
                return;
            }

            
            {
                this$0 = CustomViewAbove.this;
                super();
            }
        });
        mFlingDistance = (int)(25F * context.getResources().getDisplayMetrics().density);
    }

    public boolean isMenuOpen()
    {
        return mCurItem == 0 || mCurItem == 2;
    }

    public boolean isSlidingEnabled()
    {
        return mEnabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (mEnabled) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i;
        i = motionevent.getAction() & 0xff;
        if (i == 3 || i == 1 || i != 0 && mIsUnableToDrag)
        {
            endDrag();
            mLastIntersecption = false;
            return false;
        }
        i;
        JVM INSTR lookupswitch 3: default 84
    //                   0: 143
    //                   2: 135
    //                   6: 258;
           goto _L3 _L4 _L5 _L6
_L3:
        if (!mIsBeingDragged)
        {
            addMovement(motionevent);
        }
        float f;
        int j;
        boolean flag;
        if (mIsBeingDragged || mQuickReturn)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mLastIntersecption = flag;
        if (mIsBeingDragged || mQuickReturn)
        {
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
        determineDrag(motionevent);
          goto _L3
_L4:
        j = MotionEventCompat.getActionIndex(motionevent);
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, j);
        if (mActivePointerId != -1)
        {
            f = MotionEventCompat.getX(motionevent, j);
            mInitialMotionX = f;
            mLastMotionX = f;
            mLastMotionY = MotionEventCompat.getY(motionevent, j);
            if (thisTouchAllowed(motionevent))
            {
                mIsBeingDragged = false;
                mIsUnableToDrag = false;
                if (isMenuOpen() && mViewBehind.menuTouchInQuickReturn(mContent, mCurItem, motionevent.getX() + mScrollX))
                {
                    mQuickReturn = true;
                }
            } else
            {
                mIsUnableToDrag = true;
            }
        }
          goto _L3
_L6:
        onSecondaryPointerUp(motionevent);
          goto _L3
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        mContent.layout(0, 0, k - i, l - j);
    }

    protected void onMeasure(int i, int j)
    {
        int l = getDefaultSize(0, i);
        int k = getDefaultSize(0, j);
        setMeasuredDimension(l, k);
        i = getChildMeasureSpec(i, 0, l);
        j = getChildMeasureSpec(j, 0, k);
        mContent.measure(i, j);
    }

    protected void onPageScrolled(int i, float f, int j)
    {
        if (mOnPageChangeListener != null)
        {
            mOnPageChangeListener.onPageScrolled(i, f, j);
        }
        if (mInternalPageChangeListener != null)
        {
            mInternalPageChangeListener.onPageScrolled(i, f, j);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i != k)
        {
            completeScroll();
            scrollTo(getDestScrollX(mCurItem), getScrollY());
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        if (!mEnabled)
        {
            return false;
        }
        if (!mIsBeingDragged && !thisTouchAllowed(motionevent))
        {
            return false;
        }
        i = motionevent.getAction();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 104
    //                   0 106
    //                   1 281
    //                   2 140
    //                   3 459
    //                   4 104
    //                   5 488
    //                   6 517;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return true;
_L2:
        completeScroll();
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, MotionEventCompat.getActionIndex(motionevent));
        float f = motionevent.getX();
        mInitialMotionX = f;
        mLastMotionX = f;
        continue; /* Loop/switch isn't completed */
_L4:
        float f1;
        float f3;
        float f4;
        if (!mIsBeingDragged)
        {
            determineDrag(motionevent);
            if (mIsUnableToDrag)
            {
                return false;
            }
        }
        if (!mIsBeingDragged)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j = getPointerIndex(motionevent, mActivePointerId);
        if (mActivePointerId == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        f1 = MotionEventCompat.getX(motionevent, j);
        f3 = mLastMotionX;
        mLastMotionX = f1;
        f3 = (float)getScrollX() + (f3 - f1);
        f1 = getLeftBound();
        f4 = getRightBound();
        if (f3 >= f1) goto _L9; else goto _L8
_L8:
        mLastMotionX = mLastMotionX + (f1 - (float)(int)f1);
        scrollTo((int)f1, getScrollY());
        pageScrolled((int)f1);
        continue; /* Loop/switch isn't completed */
_L9:
        f1 = f3;
        if (f3 > f4)
        {
            f1 = f4;
        }
        if (true) goto _L8; else goto _L3
_L3:
        if (mIsBeingDragged)
        {
            VelocityTracker velocitytracker = mVelocityTracker;
            velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int k = (int)VelocityTrackerCompat.getXVelocity(velocitytracker, mActivePointerId);
            float f2 = (float)(getScrollX() - getDestScrollX(mCurItem)) / (float)getBehindWidth();
            int j1 = getPointerIndex(motionevent, mActivePointerId);
            if (mActivePointerId != -1)
            {
                setCurrentItemInternal(determineTargetPage(f2, k, (int)(MotionEventCompat.getX(motionevent, j1) - mInitialMotionX)), true, true, k);
            } else
            {
                setCurrentItemInternal(mCurItem, true, true, k);
            }
            mActivePointerId = -1;
            endDrag();
        } else
        if (mQuickReturn && mViewBehind.menuTouchInQuickReturn(mContent, mCurItem, motionevent.getX() + mScrollX))
        {
            setCurrentItem(1);
            endDrag();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mIsBeingDragged)
        {
            setCurrentItemInternal(mCurItem, true, true);
            mActivePointerId = -1;
            endDrag();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        int l = MotionEventCompat.getActionIndex(motionevent);
        mLastMotionX = MotionEventCompat.getX(motionevent, l);
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, l);
        continue; /* Loop/switch isn't completed */
_L7:
        onSecondaryPointerUp(motionevent);
        int i1 = getPointerIndex(motionevent, mActivePointerId);
        if (mActivePointerId != -1)
        {
            mLastMotionX = MotionEventCompat.getX(motionevent, i1);
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    boolean pageLeft()
    {
        if (mCurItem > 0)
        {
            setCurrentItem(mCurItem - 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    boolean pageRight()
    {
        if (mCurItem < 1)
        {
            setCurrentItem(mCurItem + 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    public void removeIgnoredView(View view)
    {
        mIgnoredViews.remove(view);
    }

    public void scrollTo(int i, int j)
    {
        super.scrollTo(i, j);
        mScrollX = i;
        mViewBehind.scrollBehindTo(mContent, i, j);
        ((SlidingMenu)getParent()).manageLayers(getPercentOpen());
    }

    public void setAboveOffset(int i)
    {
        mContent.setPadding(i, mContent.getPaddingTop(), mContent.getPaddingRight(), mContent.getPaddingBottom());
    }

    public void setContent(View view)
    {
        if (mContent != null)
        {
            removeView(mContent);
        }
        mContent = view;
        addView(mContent);
    }

    public void setCurrentItem(int i)
    {
        setCurrentItemInternal(i, true, false);
    }

    public void setCurrentItem(int i, boolean flag)
    {
        setCurrentItemInternal(i, flag, false);
    }

    void setCurrentItemInternal(int i, boolean flag, boolean flag1)
    {
        setCurrentItemInternal(i, flag, flag1, 0);
    }

    void setCurrentItemInternal(int i, boolean flag, boolean flag1, int j)
    {
        if (!flag1 && mCurItem == i)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        int k = mViewBehind.getMenuPage(i);
        int l;
        if (mCurItem != k)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        mCurItem = k;
        l = getDestScrollX(mCurItem);
        if (i != 0 && mOnPageChangeListener != null)
        {
            mOnPageChangeListener.onPageSelected(k);
        }
        if (i != 0 && mInternalPageChangeListener != null)
        {
            mInternalPageChangeListener.onPageSelected(k);
        }
        if (flag)
        {
            smoothScrollTo(l, 0, j);
            return;
        } else
        {
            completeScroll();
            scrollTo(l, 0);
            return;
        }
    }

    public void setCustomViewBehind(CustomViewBehind customviewbehind)
    {
        mViewBehind = customviewbehind;
    }

    public void setInitialTouchEvents(float f, int i)
    {
        mInitialMotionX = f;
        mLastMotionX = f;
        mActivePointerId = i;
        mIsBeingDragged = true;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onpagechangelistener)
    {
        OnPageChangeListener onpagechangelistener1 = mInternalPageChangeListener;
        mInternalPageChangeListener = onpagechangelistener;
        return onpagechangelistener1;
    }

    public void setOnClosedListener(SlidingMenu.OnClosedListener onclosedlistener)
    {
        mClosedListener = onclosedlistener;
    }

    public void setOnOpenedListener(SlidingMenu.OnOpenedListener onopenedlistener)
    {
        mOpenedListener = onopenedlistener;
    }

    public void setOnPageChangeListener(OnPageChangeListener onpagechangelistener)
    {
        mOnPageChangeListener = onpagechangelistener;
    }

    public void setSlidingEnabled(boolean flag)
    {
        mEnabled = flag;
    }

    public void setTouchMode(int i)
    {
        mTouchMode = i;
    }

    void smoothScrollTo(int i, int j)
    {
        smoothScrollTo(i, j, 0);
    }

    void smoothScrollTo(int i, int j, int k)
    {
        if (getChildCount() != 0) goto _L2; else goto _L1
_L1:
        setScrollingCacheEnabled(false);
_L4:
        return;
_L2:
        int l;
        int i1;
        int j1;
        l = getScrollX();
        i1 = getScrollY();
        j1 = i - l;
        j -= i1;
        if (j1 != 0 || j != 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        completeScroll();
        if (!isMenuOpen())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mOpenedListener == null) goto _L4; else goto _L3
_L3:
        mOpenedListener.onOpened();
        return;
        if (mClosedListener == null) goto _L4; else goto _L5
_L5:
        mClosedListener.onClosed();
        return;
        setScrollingCacheEnabled(true);
        mScrolling = true;
        i = getBehindWidth();
        int k1 = i / 2;
        float f2 = Math.min(1.0F, (1.0F * (float)Math.abs(j1)) / (float)i);
        float f = k1;
        float f1 = k1;
        f2 = distanceInfluenceForSnapDuration(f2);
        k = Math.abs(k);
        if (k > 0)
        {
            i = Math.round(1000F * Math.abs((f + f1 * f2) / (float)k)) * 4;
        } else
        {
            i = (int)((1.0F + (float)Math.abs(j1) / (float)i) * 100F);
            i = 600;
        }
        i = Math.min(i, 600);
        mScroller.startScroll(l, i1, j1, j, i);
        invalidate();
        return;
    }


}

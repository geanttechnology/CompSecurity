// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.DraftFragmentStatePagerAdapter;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            MotionEventCompat, DraftPagerAdapter, ViewCompat, VelocityTrackerCompat, 
//            KeyEventCompat, ViewConfigurationCompat

public class DraftViewPager extends ViewGroup
{
    static interface Decor
    {
    }

    static class ItemInfo
    {

        Object object;
        int position;
        boolean scrolling;

        ItemInfo()
        {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        public int gravity;
        public boolean isDecor;

        public LayoutParams()
        {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            context = context.obtainStyledAttributes(attributeset, DraftViewPager.LAYOUT_ATTRS);
            gravity = context.getInteger(0, 0);
            context.recycle();
        }
    }

    static interface OnAdapterChangeListener
    {

        public abstract void onAdapterChanged(DraftPagerAdapter draftpageradapter, DraftPagerAdapter draftpageradapter1);
    }

    public static interface OnPageChangeListener
    {

        public abstract void onPageScrollStateChanged(int i);

        public abstract void onPageScrolled(int i, float f, int j);

        public abstract void onPageSelected(int i);
    }

    private class PagerObserver extends DataSetObserver
    {

        final DraftViewPager this$0;

        public void onChanged()
        {
            dataSetChanged();
        }

        public void onInvalidated()
        {
            dataSetChanged();
        }

        private PagerObserver()
        {
            this$0 = DraftViewPager.this;
            super();
        }

    }

    public static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() {

            public SavedState createFromParcel(Parcel parcel, ClassLoader classloader)
            {
                return new SavedState(parcel, classloader);
            }

            public volatile Object createFromParcel(Parcel parcel, ClassLoader classloader)
            {
                return createFromParcel(parcel, classloader);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public String toString()
        {
            return (new StringBuilder()).append("FragmentPager.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(position).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(position);
            parcel.writeParcelable(adapterState, i);
        }


        SavedState(Parcel parcel, ClassLoader classloader)
        {
            super(parcel);
            ClassLoader classloader1 = classloader;
            if (classloader == null)
            {
                classloader1 = getClass().getClassLoader();
            }
            position = parcel.readInt();
            adapterState = parcel.readParcelable(classloader1);
            loader = classloader1;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private static final Comparator COMPARATOR = new Comparator() {

        public int compare(ItemInfo iteminfo, ItemInfo iteminfo1)
        {
            return iteminfo.position - iteminfo1.position;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((ItemInfo)obj, (ItemInfo)obj1);
        }

    };
    private static final boolean DEBUG = false;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int INVALID_POINTER = -1;
    private static final int LAYOUT_ATTRS[] = {
        0x10100b3
    };
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() {

        public float getInterpolation(float f)
        {
            f--;
            return f * f * f * f * f + 1.0F;
        }

    };
    private int mActivePointerId;
    private DraftPagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDraftMargin;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private int mFlingDistance;
    private boolean mInLayout;
    private float mInitialMotionX;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private boolean mPopulatePending;
    private float mPreviewRatio;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrolling;
    private boolean mScrollingCacheEnabled;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public DraftViewPager(Context context)
    {
        this(context, null);
    }

    public DraftViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mItems = new ArrayList();
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
        mOffscreenPageLimit = 1;
        mActivePointerId = -1;
        mFirstLayout = true;
        mScrollState = 0;
        context = context.getResources();
        mPreviewRatio = (float)context.getInteger(0x7f0c0003) / 100F;
        mDraftMargin = context.getDimensionPixelOffset(0x7f0b0036);
        initViewPager();
    }

    private void completeScroll()
    {
        boolean flag = mScrolling;
        if (flag)
        {
            setScrollingCacheEnabled(false);
            mScroller.abortAnimation();
            int i = getScrollX();
            int k = getScrollY();
            int l = mScroller.getCurrX();
            int i1 = mScroller.getCurrY();
            if (i != l || k != i1)
            {
                scrollTo(l, i1);
            }
            setScrollState(0);
        }
        mPopulatePending = false;
        mScrolling = false;
        for (int j = 0; j < mItems.size(); j++)
        {
            ItemInfo iteminfo = (ItemInfo)mItems.get(j);
            if (iteminfo.scrolling)
            {
                flag = true;
                iteminfo.scrolling = false;
            }
        }

        if (flag)
        {
            populate();
        }
    }

    private int determineTargetPage(int i, float f, int j, int k)
    {
        if (Math.abs(k) > mFlingDistance && Math.abs(j) > mMinimumVelocity)
        {
            if (j > 0)
            {
                return i;
            } else
            {
                return i + 1;
            }
        } else
        {
            return (int)((float)i + f + 0.5F);
        }
    }

    private void endDrag()
    {
        mIsBeingDragged = false;
        mIsUnableToDrag = false;
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private int getAdjustedXDestination(int i)
    {
        return ((int)((float)getWidth() * mPreviewRatio) + mDraftMargin * 2) * i;
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
        int j = getWidth() + mPageMargin;
        int k = i / j;
        i %= j;
        float f = (float)i / (float)j;
        mCalledSuper = false;
        onPageScrolled(k, f, i);
        if (!mCalledSuper)
        {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else
        {
            return;
        }
    }

    private void recomputeScrollPosition(int i, int j, int k, int l)
    {
        i += k;
        if (j > 0)
        {
            k = getScrollX();
            j += l;
            l = k / j;
            float f = (float)(k % j) / (float)j;
            j = (int)(((float)l + f) * (float)i);
            scrollTo(j, getScrollY());
            if (!mScroller.isFinished())
            {
                k = mScroller.getDuration();
                l = mScroller.timePassed();
                mScroller.startScroll(j, 0, mCurItem * i, 0, k - l);
            }
        } else
        {
            i = mCurItem * i;
            if (i != getScrollX())
            {
                completeScroll();
                scrollTo(i, getScrollY());
                return;
            }
        }
    }

    private void removeNonDecorViews()
    {
        int j;
        for (int i = 0; i < getChildCount(); i = j + 1)
        {
            j = i;
            if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
            {
                removeViewAt(i);
                j = i - 1;
            }
        }

    }

    private void setScrollState(int i)
    {
        if (mScrollState != i)
        {
            mScrollState = i;
            if (mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageScrollStateChanged(i);
                return;
            }
        }
    }

    private void setScrollingCacheEnabled(boolean flag)
    {
        if (mScrollingCacheEnabled != flag)
        {
            mScrollingCacheEnabled = flag;
        }
    }

    public void addFocusables(ArrayList arraylist, int i, int j)
    {
        int l = arraylist.size();
        int i1 = getDescendantFocusability();
        if (i1 != 0x60000)
        {
            for (int k = 0; k < getChildCount(); k++)
            {
                View view = getChildAt(k);
                if (view.getVisibility() == 0)
                {
                    ItemInfo iteminfo = infoForChild(view);
                    if (iteminfo != null && iteminfo.position == mCurItem)
                    {
                        view.addFocusables(arraylist, i, j);
                    }
                }
            }

        }
        while (i1 == 0x40000 && l != arraylist.size() || !isFocusable() || (j & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode() || arraylist == null) 
        {
            return;
        }
        arraylist.add(this);
    }

    void addNewItem(int i, int j)
    {
        ItemInfo iteminfo = new ItemInfo();
        iteminfo.position = i;
        iteminfo.object = mAdapter.instantiateItem(this, i);
        if (j < 0)
        {
            mItems.add(iteminfo);
            return;
        } else
        {
            mItems.add(j, iteminfo);
            return;
        }
    }

    public void addTouchables(ArrayList arraylist)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            ItemInfo iteminfo = infoForChild(view);
            if (iteminfo != null && iteminfo.position == mCurItem)
            {
                view.addTouchables(arraylist);
            }
        }

    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = layoutparams;
        if (!checkLayoutParams(layoutparams))
        {
            layoutparams1 = generateLayoutParams(layoutparams);
        }
        layoutparams = (LayoutParams)layoutparams1;
        layoutparams.isDecor = ((LayoutParams) (layoutparams)).isDecor | (view instanceof Decor);
        if (mInLayout)
        {
            if (layoutparams != null && ((LayoutParams) (layoutparams)).isDecor)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                addViewInLayout(view, i, layoutparams1);
                view.measure(mChildWidthMeasureSpec, mChildHeightMeasureSpec);
                return;
            }
        } else
        {
            super.addView(view, i, layoutparams1);
            return;
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
        if (view != null && view1.getLeft() >= view.getLeft())
        {
            flag = pageLeft();
        } else
        {
            flag = view1.requestFocus();
        }
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

    public boolean beginFakeDrag()
    {
        if (mIsBeingDragged)
        {
            return false;
        }
        mFakeDragging = true;
        setScrollState(1);
        mLastMotionX = 0.0F;
        mInitialMotionX = 0.0F;
        MotionEvent motionevent;
        long l;
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        } else
        {
            mVelocityTracker.clear();
        }
        l = SystemClock.uptimeMillis();
        motionevent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
        mVelocityTracker.addMovement(motionevent);
        motionevent.recycle();
        mFakeDragBeginTime = l;
        return true;
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

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && super.checkLayoutParams(layoutparams);
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

    void dataSetChanged()
    {
        int i;
        boolean flag;
        boolean flag1;
        int k;
        if (mItems.size() < 3 && mItems.size() < mAdapter.getCount())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i = -1;
        flag = false;
        k = 0;
        while (k < mItems.size()) 
        {
            ItemInfo iteminfo = (ItemInfo)mItems.get(k);
            int j1 = mAdapter.getItemPosition(iteminfo.object);
            int j;
            int l;
            int i1;
            if (j1 == -1)
            {
                j = i;
                l = ((flag) ? 1 : 0);
                i1 = k;
            } else
            if (j1 == -2)
            {
                mItems.remove(k);
                j1 = k - 1;
                k = ((flag) ? 1 : 0);
                if (!flag)
                {
                    mAdapter.startUpdate(this);
                    k = 1;
                }
                mAdapter.destroyItem(this, iteminfo.position, iteminfo.object);
                flag = true;
                i1 = j1;
                l = k;
                flag1 = flag;
                j = i;
                if (mCurItem == iteminfo.position)
                {
                    j = Math.max(0, Math.min(mCurItem, mAdapter.getCount() - 1));
                    i1 = j1;
                    l = k;
                    flag1 = flag;
                }
            } else
            {
                i1 = k;
                l = ((flag) ? 1 : 0);
                j = i;
                if (iteminfo.position != j1)
                {
                    if (iteminfo.position == mCurItem)
                    {
                        i = j1;
                    }
                    iteminfo.position = j1;
                    flag1 = true;
                    i1 = k;
                    l = ((flag) ? 1 : 0);
                    j = i;
                }
            }
            k = i1 + 1;
            flag = l;
            i = j;
        }
        if (flag)
        {
            mAdapter.finishUpdate(this);
        }
        Collections.sort(mItems, COMPARATOR);
        if (i >= 0)
        {
            setCurrentItemInternal(i, false, true);
            flag1 = true;
        }
        if (flag1)
        {
            populate();
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyEvent(keyevent) || executeKeyEvent(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        int j = getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            ItemInfo iteminfo = infoForChild(view);
            if (iteminfo != null && iteminfo.position == mCurItem && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
            {
                return true;
            }
        }

        return false;
    }

    float distanceInfluenceForSnapDuration(float f)
    {
        return (float)Math.sin((float)((double)(f - 0.5F) * 0.4712389167638204D));
    }

    public void draw(Canvas canvas)
    {
        boolean flag = true;
        super.draw(canvas);
        int j = 0;
        int i = 0;
        int k = ViewCompat.getOverScrollMode(this);
        if (k == 0 || k == 1 && mAdapter != null && mAdapter.getCount() > 1)
        {
            if (!mLeftEdge.isFinished())
            {
                j = canvas.save();
                i = getHeight() - getPaddingTop() - getPaddingBottom();
                canvas.rotate(270F);
                canvas.translate(-i + getPaddingTop(), 0.0F);
                mLeftEdge.setSize(i, getWidth());
                i = false | mLeftEdge.draw(canvas);
                canvas.restoreToCount(j);
            }
            j = i;
            if (!mRightEdge.isFinished())
            {
                int l = canvas.save();
                int i1 = getWidth();
                int j1 = getHeight();
                int k1 = getPaddingTop();
                int l1 = getPaddingBottom();
                j = ((flag) ? 1 : 0);
                if (mAdapter != null)
                {
                    j = mAdapter.getCount();
                }
                canvas.rotate(90F);
                canvas.translate(-getPaddingTop(), -j * (mPageMargin + i1) + mPageMargin);
                mRightEdge.setSize(j1 - k1 - l1, i1);
                j = i | mRightEdge.draw(canvas);
                canvas.restoreToCount(l);
            }
        } else
        {
            mLeftEdge.finish();
            mRightEdge.finish();
        }
        if (j != 0)
        {
            invalidate();
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = mMarginDrawable;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag()
    {
        if (!mFakeDragging)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else
        {
            VelocityTracker velocitytracker = mVelocityTracker;
            velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int i = (int)VelocityTrackerCompat.getYVelocity(velocitytracker, mActivePointerId);
            mPopulatePending = true;
            int j = (int)(mLastMotionX - mInitialMotionX);
            int k = getScrollX();
            int l = getWidth() + mPageMargin;
            setCurrentItemInternal(determineTargetPage(k / l, (float)(k % l) / (float)l, i, j), true, true, i);
            endDrag();
            mFakeDragging = false;
            return;
        }
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

    public void fakeDragBy(float f)
    {
        float f1;
        float f2;
        if (!mFakeDragging)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        mLastMotionX = mLastMotionX + f;
        f1 = (float)getScrollX() - f;
        int i = getWidth() + mPageMargin;
        f = Math.max(0, (mCurItem - 1) * i);
        f2 = Math.min(mCurItem + 1, mAdapter.getCount() - 1) * i;
        if (f1 >= f) goto _L2; else goto _L1
_L1:
        mLastMotionX = mLastMotionX + (f - (float)(int)f);
        scrollTo((int)f, getScrollY());
        pageScrolled((int)f);
        long l = SystemClock.uptimeMillis();
        MotionEvent motionevent = MotionEvent.obtain(mFakeDragBeginTime, l, 2, mLastMotionX, 0.0F, 0);
        mVelocityTracker.addMovement(motionevent);
        motionevent.recycle();
        return;
_L2:
        f = f1;
        if (f1 > f2)
        {
            f = f2;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateDefaultLayoutParams();
    }

    public DraftPagerAdapter getAdapter()
    {
        return mAdapter;
    }

    public int getCurrentItem()
    {
        return mCurItem;
    }

    public int getLeftOfSelectedFragment()
    {
        int i = getWidth();
        return (int)((float)i - (float)i * mPreviewRatio) / 2;
    }

    public int getOffscreenPageLimit()
    {
        return mOffscreenPageLimit;
    }

    public int getPageMargin()
    {
        return mPageMargin;
    }

    ItemInfo infoForAnyChild(View view)
    {
        do
        {
            android.view.ViewParent viewparent = view.getParent();
            if (viewparent != this)
            {
                if (viewparent == null || !(viewparent instanceof View))
                {
                    return null;
                }
                view = (View)viewparent;
            } else
            {
                return infoForChild(view);
            }
        } while (true);
    }

    ItemInfo infoForChild(View view)
    {
        for (int i = 0; i < mItems.size(); i++)
        {
            ItemInfo iteminfo = (ItemInfo)mItems.get(i);
            if (mAdapter.isViewFromObject(view, iteminfo.object))
            {
                return iteminfo;
            }
        }

        return null;
    }

    void initViewPager()
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
        mLeftEdge = new EdgeEffectCompat(context);
        mRightEdge = new EdgeEffectCompat(context);
        mFlingDistance = (int)(25F * context.getResources().getDisplayMetrics().density);
    }

    public boolean isDrawn()
    {
        return getWidth() > 0;
    }

    public boolean isFakeDragging()
    {
        return mFakeDragging;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mPageMargin > 0 && mMarginDrawable != null)
        {
            int i = getScrollX();
            int j = getWidth();
            int k = i % (mPageMargin + j);
            if (k != 0)
            {
                i = (i - k) + j;
                mMarginDrawable.setBounds(i, mTopPageBounds, mPageMargin + i, mBottomPageBounds);
                mMarginDrawable.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        i = motionevent.getAction() & 0xff;
        if (i == 3 || i == 1)
        {
            mIsBeingDragged = false;
            mIsUnableToDrag = false;
            mActivePointerId = -1;
            if (mVelocityTracker != null)
            {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            }
            return false;
        }
        if (i != 0)
        {
            if (mIsBeingDragged)
            {
                return true;
            }
            if (mIsUnableToDrag)
            {
                return false;
            }
        }
        i;
        JVM INSTR lookupswitch 3: default 116
    //                   0: 305
    //                   2: 150
    //                   6: 380;
           goto _L1 _L2 _L3 _L4
_L1:
        if (!mIsBeingDragged)
        {
            if (mVelocityTracker == null)
            {
                mVelocityTracker = VelocityTracker.obtain();
            }
            mVelocityTracker.addMovement(motionevent);
        }
        return mIsBeingDragged;
_L3:
        int j = mActivePointerId;
        if (j != -1)
        {
            j = MotionEventCompat.findPointerIndex(motionevent, j);
            float f = MotionEventCompat.getX(motionevent, j);
            float f2 = f - mLastMotionX;
            float f3 = Math.abs(f2);
            float f4 = MotionEventCompat.getY(motionevent, j);
            float f5 = Math.abs(f4 - mLastMotionY);
            if (canScroll(this, false, (int)f2, (int)f, (int)f4))
            {
                mLastMotionX = f;
                mInitialMotionX = f;
                mLastMotionY = f4;
                return false;
            }
            if (f3 > (float)mTouchSlop && f3 > f5)
            {
                mIsBeingDragged = true;
                setScrollState(1);
                mLastMotionX = f;
                setScrollingCacheEnabled(true);
            } else
            if (f5 > (float)mTouchSlop)
            {
                mIsUnableToDrag = true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        float f1 = motionevent.getX();
        mInitialMotionX = f1;
        mLastMotionX = f1;
        mLastMotionY = motionevent.getY();
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, 0);
        if (mScrollState == 2)
        {
            mIsBeingDragged = true;
            mIsUnableToDrag = false;
            setScrollState(1);
        } else
        {
            completeScroll();
            mIsBeingDragged = false;
            mIsUnableToDrag = false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        onSecondaryPointerUp(motionevent);
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i1;
        int k1;
        int l1;
        int l2;
        int i3;
        int j3;
        int k3;
        l2 = getChildCount();
        mInLayout = true;
        populate();
        mInLayout = false;
        i3 = k - i;
        j3 = l - j;
        k3 = getScrollX();
        j = getPaddingLeft();
        i = getPaddingTop();
        i1 = getPaddingRight();
        l = getPaddingBottom();
        l1 = 0;
        k1 = 0;
_L18:
        if (k1 >= l2) goto _L2; else goto _L1
_L1:
        View view;
        int j1;
        int i2;
        int j2;
        int k2;
        view = getChildAt(k1);
        k2 = l1;
        j2 = l;
        j1 = j;
        i2 = i1;
        k = i;
        if (view.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (!layoutparams.isDecor) goto _L6; else goto _L5
_L5:
        k = layoutparams.gravity;
        i2 = layoutparams.gravity;
        k & 7;
        JVM INSTR tableswitch 1 5: default 180
    //                   1 315
    //                   2 180
    //                   3 300
    //                   4 180
    //                   5 337;
           goto _L7 _L8 _L7 _L9 _L7 _L10
_L7:
        k = j;
        j1 = j;
_L15:
        i2 & 0x70;
        JVM INSTR lookupswitch 3: default 224
    //                   16: 379
    //                   48: 366
    //                   80: 397;
           goto _L11 _L12 _L13 _L14
_L11:
        j = i;
_L16:
        k += k3;
        k2 = l1 + 1;
        view.layout(k, j, view.getMeasuredWidth() + k, view.getMeasuredHeight() + j);
        k = i;
        i2 = i1;
        j2 = l;
_L4:
        k1++;
        l1 = k2;
        l = j2;
        j = j1;
        i1 = i2;
        i = k;
        continue; /* Loop/switch isn't completed */
_L9:
        k = j;
        j1 = j + view.getMeasuredWidth();
          goto _L15
_L8:
        k = Math.max((i3 - view.getMeasuredWidth()) / 2, j);
        j1 = j;
          goto _L15
_L10:
        k = i3 - i1 - view.getMeasuredWidth();
        i1 += view.getMeasuredWidth();
        j1 = j;
          goto _L15
_L13:
        j = i;
        i += view.getMeasuredHeight();
          goto _L16
_L12:
        j = Math.max((j3 - view.getMeasuredHeight()) / 2, i);
          goto _L16
_L14:
        j = j3 - l - view.getMeasuredHeight();
        l += view.getMeasuredHeight();
          goto _L16
_L6:
        ItemInfo iteminfo = infoForChild(view);
        k2 = l1;
        j2 = l;
        j1 = j;
        i2 = i1;
        k = i;
        if (iteminfo != null)
        {
            k = j + (mPageMargin + i3) * iteminfo.position;
            i2 = (int)((float)getWidth() * (1.0F - mPreviewRatio));
            j1 = (int)((float)getWidth() * ((1.0F - mPreviewRatio) / 2.0F));
            if (iteminfo.position > 0)
            {
                i2 *= iteminfo.position;
                j2 = mDraftMargin * 2 * iteminfo.position;
                view.layout((k - i2) + j1 + j2, i, ((view.getMeasuredWidth() + k) - i2) + j1 + j2, view.getMeasuredHeight() + i);
                k2 = l1;
                j2 = l;
                j1 = j;
                i2 = i1;
                k = i;
            } else
            {
                view.layout(k + j1, i, view.getMeasuredWidth() + k + j1, view.getMeasuredHeight() + i);
                k2 = l1;
                j2 = l;
                j1 = j;
                i2 = i1;
                k = i;
            }
        }
          goto _L4
_L2:
        mTopPageBounds = i;
        mBottomPageBounds = j3 - l;
        mDecorChildCount = l1;
        mFirstLayout = false;
        return;
        if (true) goto _L18; else goto _L17
_L17:
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, j));
        j = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int k = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int i2 = getChildCount();
        i = 0;
        do
        {
            if (i < i2)
            {
                View view = getChildAt(i);
                int l = k;
                int j1 = j;
                if (view.getVisibility() != 8)
                {
                    LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                    l = k;
                    j1 = j;
                    if (layoutparams != null)
                    {
                        l = k;
                        j1 = j;
                        if (layoutparams.isDecor)
                        {
                            int i1 = layoutparams.gravity & 7;
                            l = layoutparams.gravity & 0x70;
                            Log.d("ViewPager", (new StringBuilder()).append("gravity: ").append(layoutparams.gravity).append(" hgrav: ").append(i1).append(" vgrav: ").append(l).toString());
                            int l1 = 0x80000000;
                            int k1 = 0x80000000;
                            boolean flag;
                            if (l == 48 || l == 80)
                            {
                                l = 1;
                            } else
                            {
                                l = 0;
                            }
                            if (i1 == 3 || i1 == 5)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (l != 0)
                            {
                                j1 = 0x40000000;
                            } else
                            {
                                j1 = l1;
                                if (flag)
                                {
                                    k1 = 0x40000000;
                                    j1 = l1;
                                }
                            }
                            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j, j1), android.view.View.MeasureSpec.makeMeasureSpec(k, k1));
                            if (l != 0)
                            {
                                l = k - view.getMeasuredHeight();
                                j1 = j;
                            } else
                            {
                                l = k;
                                j1 = j;
                                if (flag)
                                {
                                    j1 = j - view.getMeasuredWidth();
                                    l = k;
                                }
                            }
                        }
                    }
                }
                i++;
                k = l;
                j = j1;
                continue;
            }
            mChildWidthMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            mChildHeightMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000);
            mInLayout = true;
            populate();
            mInLayout = false;
            j = getChildCount();
            for (i = 0; i < j; i++)
            {
                View view1 = getChildAt(i);
                if (view1.getVisibility() == 8)
                {
                    continue;
                }
                LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
                if (layoutparams1 == null || !layoutparams1.isDecor)
                {
                    view1.measure(mChildWidthMeasureSpec, mChildHeightMeasureSpec);
                }
            }

            return;
        } while (true);
    }

    protected void onPageScrolled(int i, float f, int j)
    {
        int k;
        int i1;
        int j1;
        int l1;
        int i2;
        int j2;
        if (mDecorChildCount <= 0)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        l1 = getScrollX();
        k = getPaddingLeft();
        i1 = getPaddingRight();
        i2 = getWidth();
        j2 = getChildCount();
        j1 = 0;
_L2:
        View view;
        LayoutParams layoutparams;
        int l;
        int k1;
        if (j1 >= j2)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        view = getChildAt(j1);
        layoutparams = (LayoutParams)view.getLayoutParams();
        if (layoutparams.isDecor)
        {
            break; /* Loop/switch isn't completed */
        }
        l = i1;
        k1 = k;
_L7:
        j1++;
        k = k1;
        i1 = l;
        if (true) goto _L2; else goto _L1
_L1:
        layoutparams.gravity & 7;
        JVM INSTR tableswitch 1 5: default 140
    //                   1 205
    //                   2 140
    //                   3 188
    //                   4 140
    //                   5 225;
           goto _L3 _L4 _L3 _L5 _L3 _L6
_L6:
        break MISSING_BLOCK_LABEL_225;
_L3:
        l = k;
_L8:
        int k2 = (l + l1) - view.getLeft();
        k1 = k;
        l = i1;
        if (k2 != 0)
        {
            view.offsetLeftAndRight(k2);
            k1 = k;
            l = i1;
        }
          goto _L7
_L5:
        l = k;
        k += view.getWidth();
          goto _L8
_L4:
        l = Math.max((i2 - view.getMeasuredWidth()) / 2, k);
          goto _L8
        l = i2 - i1 - view.getMeasuredWidth();
        i1 += view.getMeasuredWidth();
          goto _L8
        if (mOnPageChangeListener != null)
        {
            mOnPageChangeListener.onPageScrolled(i, f, j);
        }
        if (mInternalPageChangeListener != null)
        {
            mInternalPageChangeListener.onPageScrolled(i, f, j);
        }
        mCalledSuper = true;
        return;
          goto _L7
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect)
    {
        int k = getChildCount();
        int j;
        byte byte0;
        if ((i & 2) != 0)
        {
            j = 0;
            byte0 = 1;
        } else
        {
            j = k - 1;
            byte0 = -1;
            k = -1;
        }
        for (; j != k; j += byte0)
        {
            View view = getChildAt(j);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            ItemInfo iteminfo = infoForChild(view);
            if (iteminfo != null && iteminfo.position == mCurItem && view.requestFocus(i, rect))
            {
                return true;
            }
        }

        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (mAdapter != null)
        {
            mAdapter.restoreState(((SavedState) (parcelable)).adapterState, ((SavedState) (parcelable)).loader);
            setCurrentItemInternal(((SavedState) (parcelable)).position, false, true);
            return;
        } else
        {
            mRestoredCurItem = ((SavedState) (parcelable)).position;
            mRestoredAdapterState = ((SavedState) (parcelable)).adapterState;
            mRestoredClassLoader = ((SavedState) (parcelable)).loader;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.position = mCurItem;
        if (mAdapter != null)
        {
            savedstate.adapterState = mAdapter.saveState();
        }
        return savedstate;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i != k)
        {
            recomputeScrollPosition(i, k, mPageMargin, mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if (mFakeDragging)
        {
            return true;
        }
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        if (mAdapter == null || mAdapter.getCount() == 0)
        {
            return false;
        }
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        i = motionevent.getAction();
        flag3 = false;
        flag4 = false;
        flag1 = false;
        flag2 = false;
        flag = flag2;
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 136
    //                   0 151
    //                   1 500
    //                   2 186
    //                   3 647
    //                   4 140
    //                   5 697
    //                   6 730;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L6:
        break; /* Loop/switch isn't completed */
_L1:
        flag = flag2;
_L13:
        if (flag)
        {
            invalidate();
        }
        return true;
_L2:
        completeScroll();
        float f = motionevent.getX();
        mInitialMotionX = f;
        mLastMotionX = f;
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, 0);
        flag = flag2;
        continue; /* Loop/switch isn't completed */
_L4:
        float f2;
        float f4;
        float f6;
        int l;
        int j1;
        if (!mIsBeingDragged)
        {
            i = MotionEventCompat.findPointerIndex(motionevent, mActivePointerId);
            float f1 = MotionEventCompat.getX(motionevent, i);
            float f3 = Math.abs(f1 - mLastMotionX);
            float f5 = Math.abs(MotionEventCompat.getY(motionevent, i) - mLastMotionY);
            if (f3 > (float)mTouchSlop && f3 > f5)
            {
                mIsBeingDragged = true;
                mLastMotionX = f1;
                setScrollState(1);
                setScrollingCacheEnabled(true);
            }
        }
        flag = flag2;
        if (!mIsBeingDragged)
        {
            continue; /* Loop/switch isn't completed */
        }
        f2 = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, mActivePointerId));
        f4 = mLastMotionX;
        mLastMotionX = f2;
        f4 = (float)getScrollX() + (f4 - f2);
        i = (int)((float)getWidth() * mPreviewRatio);
        l = i + mPageMargin;
        j1 = mAdapter.getCount() - 1;
        f2 = Math.max(0, (mCurItem - 1) * l);
        f6 = Math.min(mCurItem + 1, j1) * l;
        if (f4 >= f2) goto _L10; else goto _L9
_L9:
        flag = flag3;
        if (f2 == 0.0F)
        {
            f4 = -f4;
            flag = mLeftEdge.onPull(f4 / (float)i);
        }
_L11:
        mLastMotionX = mLastMotionX + (f2 - (float)(int)f2);
        scrollTo((int)f2, getScrollY());
        pageScrolled((int)f2);
        continue; /* Loop/switch isn't completed */
_L10:
        flag = flag4;
        f2 = f4;
        if (f4 > f6)
        {
            flag = flag1;
            if (f6 == (float)(j1 * l))
            {
                flag = mRightEdge.onPull((f4 - f6) / (float)i);
            }
            f2 = f6;
        }
        if (true) goto _L11; else goto _L3
_L3:
        flag = flag2;
        if (mIsBeingDragged)
        {
            VelocityTracker velocitytracker = mVelocityTracker;
            velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int j = (int)VelocityTrackerCompat.getXVelocity(velocitytracker, mActivePointerId);
            mPopulatePending = true;
            int i1 = getWidth() + mPageMargin;
            int k1 = getScrollX();
            setCurrentItemInternal(determineTargetPage(k1 / (int)((float)i1 * mPreviewRatio), (float)(k1 % i1) / (float)i1, j, (int)(MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, mActivePointerId)) - mInitialMotionX)), true, true, j);
            mActivePointerId = -1;
            endDrag();
            flag = mLeftEdge.onRelease() | mRightEdge.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        flag = flag2;
        if (mIsBeingDragged)
        {
            setCurrentItemInternal(mCurItem, true, true);
            mActivePointerId = -1;
            endDrag();
            flag = mLeftEdge.onRelease() | mRightEdge.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L7:
        int k = MotionEventCompat.getActionIndex(motionevent);
        mLastMotionX = MotionEventCompat.getX(motionevent, k);
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, k);
        flag = flag2;
        continue; /* Loop/switch isn't completed */
_L8:
        onSecondaryPointerUp(motionevent);
        mLastMotionX = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, mActivePointerId));
        flag = flag2;
        if (true) goto _L13; else goto _L12
_L12:
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
        if (mAdapter != null && mCurItem < mAdapter.getCount() - 1)
        {
            setCurrentItem(mCurItem + 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    public void populate()
    {
_L2:
        return;
        if (mAdapter == null || mPopulatePending || getWindowToken() == null) goto _L2; else goto _L1
_L1:
        int i;
        int k;
        int i1;
        int j1;
        mAdapter.startUpdate(this);
        i = mOffscreenPageLimit;
        i1 = Math.max(0, mCurItem - i);
        j1 = Math.min(mAdapter.getCount() - 1, mCurItem + i);
        k = -1;
        i = 0;
_L4:
        Object obj;
        int j;
        if (i >= mItems.size())
        {
            break MISSING_BLOCK_LABEL_260;
        }
        obj = (ItemInfo)mItems.get(i);
        if (((ItemInfo) (obj)).position >= i1 && ((ItemInfo) (obj)).position <= j1 || ((ItemInfo) (obj)).scrolling)
        {
            break; /* Loop/switch isn't completed */
        }
        mItems.remove(i);
        j = i - 1;
        mAdapter.destroyItem(this, ((ItemInfo) (obj)).position, ((ItemInfo) (obj)).object);
_L6:
        k = ((ItemInfo) (obj)).position;
        i = j + 1;
        if (true) goto _L4; else goto _L3
_L3:
        j = i;
        if (k >= j1) goto _L6; else goto _L5
_L5:
        j = i;
        if (((ItemInfo) (obj)).position <= i1) goto _L6; else goto _L7
_L7:
        int l;
        j = k + 1;
        k = i;
        l = j;
        if (j < i1)
        {
            l = i1;
            k = i;
        }
_L10:
        j = k;
        if (l > j1) goto _L6; else goto _L8
_L8:
        j = k;
        if (l >= ((ItemInfo) (obj)).position) goto _L6; else goto _L9
_L9:
        addNewItem(l, k);
        l++;
        k++;
          goto _L10
        Object obj1;
        if (mItems.size() > 0)
        {
            i = ((ItemInfo)mItems.get(mItems.size() - 1)).position;
        } else
        {
            i = -1;
        }
        if (i < j1)
        {
            i++;
            if (i <= i1)
            {
                i = i1;
            }
            for (; i <= j1; i++)
            {
                addNewItem(i, -1);
            }

        }
        obj1 = null;
        i = 0;
_L16:
        obj = obj1;
        if (i < mItems.size())
        {
            if (((ItemInfo)mItems.get(i)).position != mCurItem)
            {
                break MISSING_BLOCK_LABEL_512;
            }
            obj = (ItemInfo)mItems.get(i);
        }
        obj1 = mAdapter;
        i = mCurItem;
        if (obj != null)
        {
            obj = ((ItemInfo) (obj)).object;
        } else
        {
            obj = null;
        }
        ((DraftPagerAdapter) (obj1)).setPrimaryItem(this, i, obj);
        mAdapter.finishUpdate(this);
        if (!hasFocus()) goto _L2; else goto _L11
_L11:
        obj = findFocus();
        if (obj != null)
        {
            obj = infoForAnyChild(((View) (obj)));
        } else
        {
            obj = null;
        }
        if (obj != null && ((ItemInfo) (obj)).position == mCurItem) goto _L2; else goto _L12
_L12:
        i = 0;
_L15:
        if (i >= getChildCount()) goto _L2; else goto _L13
_L13:
        obj = getChildAt(i);
        obj1 = infoForChild(((View) (obj)));
        if (obj1 != null && ((ItemInfo) (obj1)).position == mCurItem && ((View) (obj)).requestFocus(2)) goto _L2; else goto _L14
_L14:
        i++;
          goto _L15
        i++;
          goto _L16
    }

    public void setAdapter(DraftFragmentStatePagerAdapter draftfragmentstatepageradapter)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mObserver);
            mAdapter.startUpdate(this);
            for (int i = 0; i < mItems.size(); i++)
            {
                ItemInfo iteminfo = (ItemInfo)mItems.get(i);
                mAdapter.destroyItem(this, iteminfo.position, iteminfo.object);
            }

            mAdapter.finishUpdate(this);
            mItems.clear();
            removeNonDecorViews();
            mCurItem = 0;
            scrollTo(0, 0);
        }
        DraftPagerAdapter draftpageradapter = mAdapter;
        mAdapter = draftfragmentstatepageradapter;
        if (mAdapter != null)
        {
            if (mObserver == null)
            {
                mObserver = new PagerObserver();
            }
            mAdapter.registerDataSetObserver(mObserver);
            mPopulatePending = false;
            if (mRestoredCurItem >= 0)
            {
                mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
                setCurrentItemInternal(mRestoredCurItem, false, true);
                mRestoredCurItem = -1;
                mRestoredAdapterState = null;
                mRestoredClassLoader = null;
            } else
            {
                populate();
            }
        }
        if (mAdapterChangeListener != null && draftpageradapter != draftfragmentstatepageradapter)
        {
            mAdapterChangeListener.onAdapterChanged(draftpageradapter, draftfragmentstatepageradapter);
        }
    }

    public void setCurrentItem(int i)
    {
        mPopulatePending = false;
        boolean flag;
        if (!mFirstLayout)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setCurrentItemInternal(i, flag, false);
    }

    public void setCurrentItem(int i, boolean flag)
    {
        mPopulatePending = false;
        setCurrentItemInternal(i, flag, false);
    }

    void setCurrentItemInternal(int i, boolean flag, boolean flag1)
    {
        setCurrentItemInternal(i, flag, flag1, 0);
    }

    void setCurrentItemInternal(int i, boolean flag, boolean flag1, int j)
    {
        int l = 1;
        if (mAdapter != null && mAdapter.getCount() > 0) goto _L2; else goto _L1
_L1:
        setScrollingCacheEnabled(false);
_L8:
        return;
_L2:
        if (!flag1 && mCurItem == i && mItems.size() != 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i >= 0) goto _L4; else goto _L3
_L3:
        int k = 0;
_L6:
        i = mOffscreenPageLimit;
        if (k > mCurItem + i || k < mCurItem - i)
        {
            for (i = 0; i < mItems.size(); i++)
            {
                ((ItemInfo)mItems.get(i)).scrolling = true;
            }

        }
        break; /* Loop/switch isn't completed */
_L4:
        k = i;
        if (i >= mAdapter.getCount())
        {
            k = mAdapter.getCount() - 1;
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (mCurItem != k)
        {
            i = l;
        } else
        {
            i = 0;
        }
        mCurItem = k;
        populate();
        l = getAdjustedXDestination(k);
        if (flag)
        {
            smoothScrollTo(k, l, 0, j);
            if (i != 0 && mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageSelected(k);
            }
            if (i != 0 && mInternalPageChangeListener != null)
            {
                mInternalPageChangeListener.onPageSelected(k);
                return;
            }
        } else
        {
            if (i != 0 && mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageSelected(k);
            }
            if (i != 0 && mInternalPageChangeListener != null)
            {
                mInternalPageChangeListener.onPageSelected(k);
            }
            completeScroll();
            scrollTo(l, 0);
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onpagechangelistener)
    {
        OnPageChangeListener onpagechangelistener1 = mInternalPageChangeListener;
        mInternalPageChangeListener = onpagechangelistener;
        return onpagechangelistener1;
    }

    public void setOffscreenPageLimit(int i)
    {
        int j = i;
        if (i < 1)
        {
            Log.w("ViewPager", (new StringBuilder()).append("Requested offscreen page limit ").append(i).append(" too small; defaulting to ").append(1).toString());
            j = 1;
        }
        if (j != mOffscreenPageLimit)
        {
            mOffscreenPageLimit = j;
            populate();
        }
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener onadapterchangelistener)
    {
        mAdapterChangeListener = onadapterchangelistener;
    }

    public void setOnPageChangeListener(OnPageChangeListener onpagechangelistener)
    {
        mOnPageChangeListener = onpagechangelistener;
    }

    public void setPageMargin(int i)
    {
        int j = mPageMargin;
        mPageMargin = i;
        int k = getWidth();
        recomputeScrollPosition(k, k, i, j);
        requestLayout();
    }

    public void setPageMarginDrawable(int i)
    {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable)
    {
        mMarginDrawable = drawable;
        if (drawable != null)
        {
            refreshDrawableState();
        }
        boolean flag;
        if (drawable == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    void smoothScrollTo(int i, int j, int k, int l)
    {
        if (getChildCount() == 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        int i1 = getScrollX();
        int j1 = getScrollY();
        j -= i1;
        k -= j1;
        if (j == 0 && k == 0)
        {
            completeScroll();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        mScrolling = true;
        setScrollState(2);
        i = getWidth();
        int k1 = i / 2;
        float f2 = Math.min(1.0F, (1.0F * (float)Math.abs(j)) / (float)i);
        float f = k1;
        float f1 = k1;
        f2 = distanceInfluenceForSnapDuration(f2);
        l = Math.abs(l);
        if (l > 0)
        {
            i = Math.round(1000F * Math.abs((f + f1 * f2) / (float)l)) * 4;
        } else
        {
            i = (int)((1.0F + (float)Math.abs(j) / (float)(mPageMargin + i)) * 100F);
        }
        i = Math.min(i, 600);
        mScroller.startScroll(i1, j1, j, k, i);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == mMarginDrawable;
    }


}

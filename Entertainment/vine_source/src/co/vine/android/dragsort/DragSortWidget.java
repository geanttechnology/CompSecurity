// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import co.vine.android.animation.SmoothAnimator;
import co.vine.android.views.HorizontalListView;

public class DragSortWidget extends RelativeLayout
    implements android.view.View.OnTouchListener, android.widget.AdapterView.OnItemClickListener, co.vine.android.views.HorizontalListView.OnScrollListener
{
    public class CheckForLongPress
        implements Runnable
    {

        final DragSortWidget this$0;

        public void run()
        {
            if (mTouchListPosition == mDownPosition)
            {
                if (mTouchListPosition != mSelectionPosition)
                {
                    handleClick(mTouchListPosition, false);
                }
                mFloatViewListPosition = mTouchListPosition;
                if (pickUpView(mTouchListPosition))
                {
                    mFloatViewX = mTouchX - mXOffsetFromTouch;
                    mFloatViewY = mTouchY - mYOffsetFromTouch;
                }
            }
        }

        public CheckForLongPress()
        {
            this$0 = DragSortWidget.this;
            super();
        }
    }

    private class ContentViewPickUpAnimator extends SmoothAnimator
    {

        private int mFloatViewStartHeight;
        private int mFloatViewStartWidth;
        private int mHeightDelta;
        private int mWidthDelta;
        private float mXOffsetRatio;
        private float mYOffsetRatio;
        final DragSortWidget this$0;

        public void onStart()
        {
            mFloatViewStartWidth = mContentViewBounds.width();
            mFloatViewStartHeight = mContentViewBounds.height();
            mFloatViewWidth = mFloatViewStartWidth;
            mFloatViewHeight = mFloatViewStartHeight;
            mXOffsetFromTouch = mTouchX - mContentViewBounds.left;
            mYOffsetFromTouch = mTouchY - mContentViewBounds.top;
            if (mContentViewBounds.width() != 0)
            {
                mXOffsetRatio = (float)mXOffsetFromTouch / ((float)mContentViewBounds.width() * 1.0F);
            }
            if (mContentViewBounds.height() != 0)
            {
                mYOffsetRatio = (float)mYOffsetFromTouch / ((float)mContentViewBounds.height() * 1.0F);
            }
            mWidthDelta = mFloatViewWidth - mFloatViewDefaultSize;
            mHeightDelta = mFloatViewHeight - mFloatViewDefaultSize;
            mPickingUpContent = true;
            invalidate();
        }

        public void onStop()
        {
            mPickingUpContent = false;
            invalidate();
        }

        public void onUpdate(float f, float f1)
        {
            mFloatViewWidth = (int)((float)mFloatViewStartWidth - (float)mWidthDelta * f1);
            mFloatViewHeight = (int)((float)mFloatViewStartHeight - (float)mHeightDelta * f1);
            int i = mXOffsetFromTouch;
            int j = mYOffsetFromTouch;
            mXOffsetFromTouch = (int)((float)mFloatViewWidth * mXOffsetRatio);
            mYOffsetFromTouch = (int)((float)mFloatViewHeight * mYOffsetRatio);
            mFloatViewX = (mFloatViewX + i) - mXOffsetFromTouch;
            mFloatViewY = (mFloatViewY + j) - mYOffsetFromTouch;
            invalidate();
        }

        public ContentViewPickUpAnimator(float f, int i)
        {
            this$0 = DragSortWidget.this;
            super(DragSortWidget.this, f, i);
        }
    }

    public static interface CurrentlyPlayingProvider
    {

        public abstract int getCurrentlyPlayingPosition();
    }

    public static interface DragListener
    {

        public abstract void drag(int i, int j);
    }

    public class DragScroller
        implements Runnable
    {

        public static final int LEFT = 0;
        public static final int RIGHT = 1;
        private float dt;
        private int dx;
        private boolean mAbort;
        private long mCurrTime;
        private long mPrevTime;
        private float mScrollSpeed;
        private boolean mScrolling;
        private int scrollDir;
        private long tStart;
        final DragSortWidget this$0;

        public void run()
        {
            if (mAbort)
            {
                mScrolling = false;
                return;
            }
            int k = mFloatViewListPosition;
            int i = mListView.getFirstVisiblePosition();
            int j = mListView.getLastVisiblePosition();
            int l = mListView.getCount();
            int i1 = mListView.getWidth();
            if (scrollDir == 0)
            {
                View view = mListView.getChildAt(0);
                if (view == null)
                {
                    mScrolling = false;
                    return;
                }
                if (i == 0 && view.getLeft() == 0)
                {
                    mScrolling = false;
                    return;
                }
                j = mTouchX - mListView.getLeft();
                i = j;
                if (j < 0)
                {
                    i = 0;
                }
                mScrollSpeed = mMaxScrollSpeed / (float)(i + 1);
            } else
            {
                View view1 = mListView.getChildAt(j - i);
                if (view1 == null)
                {
                    mScrolling = false;
                    return;
                }
                if (j == l - 1 && view1.getRight() <= i1)
                {
                    mScrolling = false;
                    return;
                }
                j = (i1 - mTouchX) + mListView.getLeft();
                i = j;
                if (j < 0)
                {
                    i = 0;
                }
                mScrollSpeed = -mMaxScrollSpeed / (float)(i + 1);
            }
            mCurrTime = SystemClock.uptimeMillis();
            dt = mCurrTime - mPrevTime;
            dx = Math.round(mScrollSpeed * dt);
            mListView.scroll(dx, dx);
            mPrevTime = mCurrTime;
            mFloatViewListPosition = getClosestItemPosition();
            if (mFloatViewListPosition == -1)
            {
                mFloatViewListPosition = k;
            }
            dragFloatView(k, mFloatViewListPosition);
            post(this);
        }

        public void startScrolling(int i)
        {
            if (!mScrolling)
            {
                mAbort = false;
                mScrolling = true;
                tStart = SystemClock.uptimeMillis();
                mPrevTime = tStart;
                scrollDir = i;
                post(this);
            }
        }

        public void stopScrolling(boolean flag)
        {
            if (flag)
            {
                mListView.removeCallbacks(this);
                mScrolling = false;
                return;
            } else
            {
                mAbort = true;
                return;
            }
        }

        public DragScroller()
        {
            this$0 = DragSortWidget.this;
            super();
            mScrollSpeed = 0.0F;
            mScrolling = false;
        }
    }

    public class DragSortAdapterWrapper extends BaseAdapter
        implements ListAdapter
    {

        private ListAdapter mAdapter;
        private Context mContext;
        private DataSetObserver mObserver;
        final DragSortWidget this$0;

        public int getCount()
        {
            return mAdapter.getCount();
        }

        public Object getItem(int i)
        {
            return mAdapter.getItem(i);
        }

        public long getItemId(int i)
        {
            return mAdapter.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            float f;
            boolean flag;
            if (view != null)
            {
                view = (DragSortListItem)view;
                View view1 = view.getChildAt(i);
                viewgroup = mAdapter.getView(i, view1, viewgroup);
            } else
            {
                viewgroup = mAdapter.getView(i, null, viewgroup);
                view = new DragSortListItem(mContext);
            }
            view.removeAllViews();
            view.addView(viewgroup);
            if (i == mSelectionPosition)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setActivated(flag);
            if (i == mFocusedPosition)
            {
                f = 1.0F;
            } else
            {
                f = 0.3F;
            }
            view.setAlpha(f);
            viewgroup = view.getLayoutParams();
            if (mRemoving && i == mRemovePosition)
            {
                viewgroup.width = mRemoveAnimator.mWidth;
            } else
            {
                viewgroup.width = 0;
            }
            view.setLayoutParams(viewgroup);
            if (mFloatView != null && i == mFloatViewListPosition)
            {
                view.setVisibility(4);
                return view;
            } else
            {
                view.setVisibility(0);
                return view;
            }
        }

        public boolean isEnabled(int i)
        {
            return mAdapter.isEnabled(i);
        }

        public void setAdapter(ListAdapter listadapter)
        {
            mAdapter = listadapter;
            if (listadapter != null)
            {
                listadapter.registerDataSetObserver(mObserver);
            }
        }

        public DragSortAdapterWrapper(Context context)
        {
            this$0 = DragSortWidget.this;
            super();
            mObserver = new _cls1();
            mContext = context;
        }
    }

    public class DragSortListItem extends ViewGroup
    {

        public boolean hasTransientState;
        final DragSortWidget this$0;

        public Bitmap getBitmap()
        {
            Object obj = getChildAt(0);
            if (obj != null)
            {
                obj = (BitmapDrawable)((View) (obj)).getBackground();
                if (obj != null)
                {
                    return ((BitmapDrawable) (obj)).getBitmap();
                }
            }
            return null;
        }

        public void onLayout(boolean flag, int i, int j, int k, int l)
        {
            if (mActivatedDrawable != null)
            {
                mActivatedDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            View view = getChildAt(0);
            if (view != null)
            {
                view.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }

        protected void onMeasure(int i, int j)
        {
            int l = android.view.View.MeasureSpec.getSize(j);
            int k = android.view.View.MeasureSpec.getSize(i);
            int i1 = android.view.View.MeasureSpec.getMode(i);
            View view = getChildAt(0);
            if (view == null)
            {
                setMeasuredDimension(0, 0);
                return;
            }
            if (view.isLayoutRequested())
            {
                measureChild(view, android.view.View.MeasureSpec.makeMeasureSpec(0, 0), j);
            }
            i = k;
            if (i1 == 0)
            {
                android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
                if (layoutparams.width > 0 || hasTransientState)
                {
                    i = layoutparams.width;
                } else
                {
                    i = view.getMeasuredWidth();
                }
            }
            setMeasuredDimension(i, l);
        }

        public DragSortListItem(Context context)
        {
            this$0 = DragSortWidget.this;
            super(context);
            hasTransientState = false;
            setLayoutParams(new co.vine.android.views.HorizontalListView.LayoutParams(-2, -1));
        }
    }

    private class DropAnimator extends SmoothAnimator
    {

        private float mDeltaX;
        private float mDeltaY;
        private int mTargetPosition;
        private int mTargetX;
        private int mTargetY;
        final DragSortWidget this$0;

        public void onStart()
        {
            mTargetPosition = mFloatViewListPosition;
            View view = mListView.getChildAt(mTargetPosition - mListView.getFirstVisiblePosition());
            mDropping = true;
            if (view != null)
            {
                mTargetY = view.getTop() + mListView.getTop();
                mTargetX = view.getLeft() + mListView.getLeft();
            } else
            {
                mDropping = false;
                mFloatViewDestroyAnimator.start();
                cancel();
            }
            mDeltaX = mFloatViewX - mTargetX;
            mDeltaY = mFloatViewY - mTargetY;
        }

        public void onStop()
        {
            finishDrop();
        }

        public void onUpdate(float f, float f1)
        {
            int i = mTargetX;
            int j = mTargetY;
            View view = mListView.getChildAt(mTargetPosition - mListView.getFirstVisiblePosition());
            if (view != null)
            {
                j = view.getTop() + mListView.getTop();
                i = view.getLeft() + mListView.getLeft();
            }
            mTargetX = i;
            mTargetY = j;
            f = 1.0F - f1;
            mFloatViewX = mTargetX + (int)(mDeltaX * f);
            mFloatViewY = mTargetY + (int)(mDeltaY * f);
            invalidate();
        }

        public DropAnimator(float f, int i)
        {
            this$0 = DragSortWidget.this;
            super(DragSortWidget.this, f, i);
        }
    }

    private class FloatViewDestroyAnimator extends SmoothAnimator
    {

        final DragSortWidget this$0;

        public void onStop()
        {
            mFloatViewAlpha = 0.0F;
            mFloatViewListPosition = -1;
            destroyFloatView();
            adjustItems();
            invalidate();
        }

        public void onUpdate(float f, float f1)
        {
            f = 0.0F;
            mFloatViewAlpha = (1.0F - f1) * 255F - 50F;
            DragSortWidget dragsortwidget = DragSortWidget.this;
            if (mFloatViewAlpha >= 0.0F)
            {
                f = mFloatViewAlpha;
            }
            dragsortwidget.mFloatViewAlpha = f;
            invalidate();
        }

        public FloatViewDestroyAnimator(float f, int i)
        {
            this$0 = DragSortWidget.this;
            super(DragSortWidget.this, f, i);
        }
    }

    public static interface FloatViewInteractionListener
    {

        public abstract boolean canPickUpFloatView();

        public abstract boolean floatViewDropped(int i);

        public abstract void floatViewLanded(int i);

        public abstract void floatViewMoved();

        public abstract void floatViewPickedUp(int i);
    }

    private class RemoveAnimator extends SmoothAnimator
    {

        private int mWidth;
        final DragSortWidget this$0;

        public void onStart()
        {
            mRemovePosition = mSelectionPosition;
            View view = mListView.getChildAt(mRemovePosition - mListView.getFirstVisiblePosition());
            if (view != null)
            {
                mWidth = view.getWidth();
                if (view != null)
                {
                    view.animate().alpha(0.0F).setDuration((long)mDurationF).start();
                }
                ((DragSortListItem)view).hasTransientState = true;
                mRemoving = true;
                return;
            } else
            {
                finishRemoveSelection();
                cancel();
                return;
            }
        }

        public void onStop()
        {
            View view = mListView.getChildAt(mRemovePosition - mListView.getFirstVisiblePosition());
            if (view != null)
            {
                view.setVisibility(8);
                view.animate().cancel();
                view.setAlpha(1.0F);
                ((DragSortListItem)view).hasTransientState = false;
            }
            finishRemoveSelection();
            mRemoving = false;
        }

        public void onUpdate(float f, float f1)
        {
            View view = mListView.getChildAt(mRemovePosition - mListView.getFirstVisiblePosition());
            if (view != null)
            {
                mWidth = Math.round((float)mWidth * (1.0F - f1));
                android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
                layoutparams.width = mWidth;
                view.setLayoutParams(layoutparams);
                mListView.forceLayout();
            } else
            {
                finishRemoveSelection();
                mRemoving = false;
                cancel();
            }
            mListView.invalidate();
        }


        public RemoveAnimator(float f, int i)
        {
            this$0 = DragSortWidget.this;
            super(DragSortWidget.this, f, i);
        }
    }

    public static interface RemoveListener
    {

        public abstract void remove(int i);
    }

    public static interface SelectionChangedListener
    {

        public abstract void onSelectionChanged(int i, boolean flag);
    }


    private static final int DROP_DURATION = 150;
    private static final float FOCUSED_ALPHA = 1F;
    public static final int INVALID_POSITION = -1;
    private static final float MAX_SCROLL_SPEED_DENSITY_MULTIPLIER = 0.1F;
    private static final int PICK_UP_CONTENT_DURATION = 130;
    private static final int PICK_UP_DURATION = ViewConfiguration.getTapTimeout() + 1;
    private static final int REMOVE_DURATION = 100;
    private static final float SCROLL_THRESHOLD = 0.33F;
    private static final float SMOOTHNESS = 0.05F;
    private static final int SWAP_DURATION = 100;
    private static final float UNFOCUSED_ALPHA = 0.3F;
    private boolean isFromContentView;
    private Drawable mActivatedDrawable;
    private int mActivePointerId;
    private DragSortAdapterWrapper mAdapterWrapper;
    private CheckForLongPress mCheckForLongPress;
    private View mContentView;
    private Rect mContentViewBounds;
    private ContentViewPickUpAnimator mContentViewPickUpAnimator;
    private CurrentlyPlayingProvider mCurrentlyPlayingProvider;
    private int mDownPosition;
    private DragListener mDragListener;
    private DragScroller mDragScroller;
    private DropAnimator mDropAnimator;
    boolean mDropping;
    private Bitmap mFloatBitmap;
    private ImageView mFloatView;
    private Drawable mFloatViewActivatedDrawable;
    private float mFloatViewAlpha;
    private int mFloatViewDefaultSize;
    private FloatViewDestroyAnimator mFloatViewDestroyAnimator;
    private int mFloatViewHeight;
    private FloatViewInteractionListener mFloatViewInteractionListener;
    private int mFloatViewListPosition;
    private int mFloatViewWidth;
    private int mFloatViewX;
    private int mFloatViewY;
    private int mFocusedPosition;
    private HorizontalListView mListView;
    private float mMaxScrollSpeed;
    private boolean mPickingUpContent;
    private RemoveAnimator mRemoveAnimator;
    private RemoveListener mRemoveListener;
    private int mRemovePosition;
    boolean mRemoving;
    private SelectionChangedListener mSelectionChangedListener;
    private int mSelectionPosition;
    private int mTouchDownX;
    private int mTouchDownY;
    private int mTouchListPosition;
    private final int mTouchSlop;
    private int mTouchX;
    private int mTouchY;
    private int mXOffsetFromTouch;
    private int mYOffsetFromTouch;

    public DragSortWidget(Context context)
    {
        this(context, null);
    }

    public DragSortWidget(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, co.vine.android.shared.R.attr.dragSortWidgetStyle);
    }

    public DragSortWidget(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mDragScroller = new DragScroller();
        mDropAnimator = new DropAnimator(0.05F, 150);
        mRemoveAnimator = new RemoveAnimator(0.05F, 100);
        mFloatViewDestroyAnimator = new FloatViewDestroyAnimator(0.05F, 100);
        mContentViewPickUpAnimator = new ContentViewPickUpAnimator(0.05F, 130);
        mFloatView = null;
        mFloatViewListPosition = -1;
        mSelectionPosition = -1;
        mFloatViewAlpha = 255F;
        mDropping = false;
        mRemoving = false;
        mPickingUpContent = false;
        isFromContentView = false;
        attributeset = context.obtainStyledAttributes(attributeset, co.vine.android.shared.R.styleable.DragSortWidget, i, 0);
        mActivatedDrawable = attributeset.getDrawable(0);
        mFloatViewActivatedDrawable = attributeset.getDrawable(1);
        mFloatViewDefaultSize = attributeset.getDimensionPixelSize(2, 0);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        attributeset.recycle();
    }

    private void adjustItem(int i)
    {
        View view = mListView.getChildAt(i - mListView.getFirstVisiblePosition());
        if (view != null)
        {
            float f;
            if (mFloatView != null && i == mFloatViewListPosition)
            {
                view.setVisibility(4);
                view.setActivated(true);
            } else
            if (i == mSelectionPosition)
            {
                view.setActivated(true);
                view.setVisibility(0);
            } else
            {
                view.setActivated(false);
                view.setVisibility(0);
            }
            if (i == mFocusedPosition)
            {
                f = 1.0F;
            } else
            {
                f = 0.3F;
            }
            view.setAlpha(f);
            view.invalidate();
        }
    }

    private void adjustItems()
    {
        for (int i = 0; i < mListView.getChildCount(); i++)
        {
            adjustItem(mListView.getFirstVisiblePosition() + i);
        }

    }

    private void createFloatView(int i)
    {
        View view;
        for (view = mListView.getChildAt(i - mListView.getFirstVisiblePosition()); view == null || mTouchDownX - mListView.getLeft() < view.getLeft() || mTouchDownY - mListView.getTop() < view.getTop() || mTouchDownX - mListView.getLeft() > view.getRight() || mTouchDownY - mListView.getTop() > view.getBottom();)
        {
            return;
        }

        view.setDrawingCacheQuality(0x100000);
        view.setDrawingCacheEnabled(true);
        mFloatBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        if (mFloatView == null)
        {
            mFloatView = new ImageView(mListView.getContext());
        }
        mFloatView.setImageBitmap(mFloatBitmap);
        mFloatView.setLayoutParams(new android.view.ViewGroup.LayoutParams(view.getWidth(), view.getHeight()));
        mXOffsetFromTouch = mTouchDownX - (view.getLeft() + mListView.getLeft());
        mYOffsetFromTouch = mTouchDownY - (view.getTop() + mListView.getTop());
        mFloatViewWidth = view.getWidth();
        mFloatViewHeight = view.getHeight();
        mFloatViewX = mTouchX - mXOffsetFromTouch;
        mFloatViewY = mTouchY - mYOffsetFromTouch;
        mFloatViewAlpha = 255F;
        adjustItem(i);
    }

    private void createFloatViewFromContentView()
    {
        mFloatViewListPosition = mSelectionPosition;
        View view1 = mListView.getChildAt(mSelectionPosition - mListView.getFirstVisiblePosition());
        mContentViewPickUpAnimator.start();
        mXOffsetFromTouch = mTouchX - mContentViewBounds.left;
        mYOffsetFromTouch = mTouchY - mContentViewBounds.top;
        mFloatViewX = mTouchX - mXOffsetFromTouch;
        mFloatViewY = mTouchY - mYOffsetFromTouch;
        mFloatViewWidth = mContentViewBounds.width();
        mFloatViewHeight = mContentViewBounds.height();
        mFloatViewAlpha = 255F;
        View view = view1;
        if (view1 == null)
        {
            view = view1;
            if (mSelectionPosition >= 0)
            {
                view = view1;
                if (mSelectionPosition < mListView.getAdapter().getCount())
                {
                    view = mListView.getAdapter().getView(mSelectionPosition, null, null);
                }
            }
        }
        mFloatBitmap = ((DragSortListItem)view).getBitmap();
        if (mFloatView == null)
        {
            mFloatView = new ImageView(mListView.getContext());
        }
        mFloatView.setImageBitmap(mFloatBitmap);
        mFloatView.setLayoutParams(new android.view.ViewGroup.LayoutParams(mFloatViewWidth, mFloatViewHeight));
        adjustItem(mSelectionPosition);
    }

    private void destroyFloatView()
    {
        if (mFloatView != null)
        {
            mFloatView.setImageDrawable(null);
            mFloatBitmap = null;
            mFloatView = null;
        }
    }

    private void dragFloatView(int i, int j)
    {
        if (i <= -1 || j <= -1 || i == j || !floatViewIntersectsList()) goto _L2; else goto _L1
_L1:
        mFloatViewListPosition = j;
        finishSwap(i, j);
_L4:
        handleDragScroll();
        invalidate();
        return;
_L2:
        if (floatViewIntersectsList() && i == j)
        {
            View view = mListView.getChildAt(mListView.getLastVisiblePosition() - mListView.getFirstVisiblePosition());
            if (view != null && mFloatViewX > view.getRight())
            {
                mFloatViewListPosition = mListView.getLastVisiblePosition();
                finishSwap(i, mFloatViewListPosition);
            }
        } else
        {
            mFloatViewListPosition = i;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void finishDrop()
    {
        mDropping = false;
        if (mFloatViewInteractionListener != null)
        {
            mFloatViewInteractionListener.floatViewLanded(mFloatViewListPosition);
        }
        destroyFloatView();
        adjustItems();
        invalidate();
    }

    private void finishRemoveSelection()
    {
        if (mRemovePosition != -1)
        {
            if (mRemoveListener != null)
            {
                mRemoveListener.remove(mRemovePosition);
            }
            mRemovePosition = -1;
            mSelectionPosition = -1;
            mFocusedPosition = -1;
            if (mSelectionChangedListener != null)
            {
                mSelectionChangedListener.onSelectionChanged(mSelectionPosition, false);
            }
        }
    }

    private void finishSwap(int i, int j)
    {
        if (mDragListener != null)
        {
            if (i < j)
            {
                for (; i < j; i++)
                {
                    if (i >= 0)
                    {
                        mDragListener.drag(i, i + 1);
                        triggerSwapAnimation(i, i + 1);
                    }
                }

            } else
            {
                for (; i > j; i--)
                {
                    if (i >= 1)
                    {
                        mDragListener.drag(i, i - 1);
                        triggerSwapAnimation(i, i - 1);
                    }
                }

            }
        }
        if (j != -1)
        {
            mSelectionPosition = j;
            mFocusedPosition = j;
        }
        adjustItems();
    }

    private boolean floatViewIntersectsList()
    {
        return !mPickingUpContent && mFloatViewX <= mListView.getRight() && mFloatViewY <= mListView.getBottom() && mFloatViewX + mFloatViewWidth >= mListView.getLeft() && mFloatViewY + mFloatViewHeight >= mListView.getTop();
    }

    private int getClosestItemPosition()
    {
        for (int i = 0; i < mListView.getChildCount(); i++)
        {
            if (mTouchX - mListView.getLeft() < mListView.getChildAt(i).getRight())
            {
                return mListView.getFirstVisiblePosition() + i;
            }
        }

        return -1;
    }

    private boolean handleClick(int i, boolean flag)
    {
        View view = mListView.getChildAt(i - mListView.getFirstVisiblePosition());
        if (view != null)
        {
            if (mSelectionPosition == i)
            {
                view.setActivated(false);
                mSelectionPosition = -1;
                mFocusedPosition = -1;
            } else
            {
                view.setActivated(true);
                if (mSelectionPosition != -1)
                {
                    View view1 = mListView.getChildAt(mSelectionPosition - mListView.getFirstVisiblePosition());
                    if (view1 != null)
                    {
                        view1.setActivated(false);
                    }
                }
                mSelectionPosition = i;
                mFocusedPosition = i;
            }
            if (mSelectionChangedListener != null)
            {
                mSelectionChangedListener.onSelectionChanged(mSelectionPosition, flag);
            }
            adjustItems();
            invalidate();
            return true;
        } else
        {
            return false;
        }
    }

    private boolean handleContentViewTouch(MotionEvent motionevent)
    {
        int i;
        i = motionevent.getAction();
        mTouchListPosition = getClosestItemPosition();
        i & 0xff;
        JVM INSTR tableswitch 0 2: default 44
    //                   0 46
    //                   1 307
    //                   2 82;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        mTouchDownX = mTouchX;
        mTouchDownY = mTouchY;
        mActivePointerId = motionevent.getPointerId(0);
        mDownPosition = mSelectionPosition;
        continue; /* Loop/switch isn't completed */
_L4:
        int j = Math.abs(mTouchX - mTouchDownX);
        int k = Math.abs(mTouchY - mTouchDownY);
        int l = mFloatViewListPosition;
        if (mTouchListPosition != -1)
        {
            mFloatViewListPosition = mTouchListPosition;
        }
        boolean flag;
        if (mFloatViewInteractionListener != null && mFloatViewInteractionListener.canPickUpFloatView())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mListView != null)
        {
            motionevent = mListView.getAdapter();
        } else
        {
            motionevent = null;
        }
        if (mContentView != null && motionevent != null && motionevent.getCount() > 0 && (k >= mTouchSlop || j >= mTouchSlop) && mFloatView == null && flag)
        {
            pickUpContentView();
            return true;
        }
        if (mFloatView != null && !mDropping)
        {
            mFloatViewX = mTouchX - mXOffsetFromTouch;
            mFloatViewY = mTouchY - mYOffsetFromTouch;
            if (mFloatViewInteractionListener != null)
            {
                mFloatViewInteractionListener.floatViewMoved();
            }
            dragFloatView(l, mFloatViewListPosition);
            return true;
        }
        invalidate();
        if (true) goto _L1; else goto _L3
_L3:
        mDownPosition = -1;
        removeCallbacks(mCheckForLongPress);
        if (mFloatView != null && !mDropping)
        {
            if (mFloatViewInteractionListener != null && mFloatViewInteractionListener.floatViewDropped(mFloatViewListPosition) && canDelete())
            {
                mFloatViewDestroyAnimator.start();
                removeSelection();
            } else
            {
                mDropAnimator.start();
            }
            mDragScroller.stopScrolling(true);
            invalidate();
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void handleDragScroll()
    {
        boolean flag = floatViewIntersectsList();
        if ((float)(mTouchX - mListView.getLeft()) > (float)(mListView.getWidth() * 2) * 0.33F && flag)
        {
            mDragScroller.startScrolling(1);
            return;
        }
        if ((float)(mTouchX - mListView.getLeft()) < (float)mListView.getWidth() * 0.33F && flag)
        {
            mDragScroller.startScrolling(0);
            return;
        } else
        {
            mDragScroller.stopScrolling(true);
            return;
        }
    }

    private boolean handleListViewTouch(MotionEvent motionevent)
    {
        int i;
        i = motionevent.getAction();
        mTouchListPosition = getClosestItemPosition();
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 60
    //                   0 62
    //                   1 392
    //                   2 111
    //                   3 60
    //                   4 60
    //                   5 60
    //                   6 370;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5
_L1:
        return false;
_L2:
        mTouchDownX = mTouchX;
        mTouchDownY = mTouchY;
        mActivePointerId = motionevent.getPointerId(0);
        mDownPosition = mTouchListPosition;
        postDelayed(mCheckForLongPress, PICK_UP_DURATION);
        continue; /* Loop/switch isn't completed */
_L4:
        int j;
        j = mFloatViewListPosition;
        if (mTouchListPosition != -1)
        {
            mFloatViewListPosition = mTouchListPosition;
        }
        int k = Math.abs(mTouchY - mTouchDownY);
        int l = Math.abs(mTouchX - mTouchDownX);
        boolean flag;
        if (mFloatViewInteractionListener != null && mFloatViewInteractionListener.canPickUpFloatView())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mFloatView == null && l < mTouchSlop && k >= mTouchSlop && mTouchY - mTouchDownY < 0 && mSelectionPosition != mTouchListPosition && flag)
        {
            handleClick(mTouchListPosition, false);
        }
        if (mFloatView != null || l < mTouchSlop && k < mTouchSlop)
        {
            continue; /* Loop/switch isn't completed */
        }
        removeCallbacks(mCheckForLongPress);
        if (flag && pickUpView(mFloatViewListPosition))
        {
            invalidate();
            return true;
        }
        continue; /* Loop/switch isn't completed */
        if (mFloatView == null || mDropping) goto _L1; else goto _L6
_L6:
        mFloatViewX = mTouchX - mXOffsetFromTouch;
        mFloatViewY = mTouchY - mYOffsetFromTouch;
        if (mFloatViewInteractionListener != null)
        {
            mFloatViewInteractionListener.floatViewMoved();
        }
        dragFloatView(j, mFloatViewListPosition);
        return true;
_L5:
        if (motionevent.getPointerId((motionevent.getAction() & 0xff00) >> 8) != mActivePointerId)
        {
            continue; /* Loop/switch isn't completed */
        }
_L3:
        mDownPosition = -1;
        removeCallbacks(mCheckForLongPress);
        if (mFloatView != null && !mDropping)
        {
            if (mFloatViewInteractionListener != null && mFloatViewInteractionListener.floatViewDropped(mFloatViewListPosition) && canDelete())
            {
                mFloatViewDestroyAnimator.start();
                removeSelection();
            } else
            {
                mDropAnimator.start();
            }
            mDragScroller.stopScrolling(true);
            invalidate();
            return true;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    private boolean pickUpContentView()
    {
        if (mSelectionPosition == -1)
        {
            int i = mCurrentlyPlayingProvider.getCurrentlyPlayingPosition();
            handleClick(i, false);
            mFloatViewListPosition = i;
            mSelectionPosition = i;
        }
        createFloatViewFromContentView();
        if (mFloatViewInteractionListener != null)
        {
            mFloatViewInteractionListener.floatViewPickedUp(mSelectionPosition);
        }
        invalidate();
        return true;
    }

    private boolean pickUpView(int i)
    {
        if (i == mSelectionPosition && i != -1)
        {
            createFloatView(i);
            if (mFloatViewInteractionListener != null)
            {
                mFloatViewInteractionListener.floatViewPickedUp(i);
            }
            invalidate();
            return true;
        } else
        {
            return false;
        }
    }

    private void triggerSwapAnimation(final int to, final int swapViewStartLeft)
    {
        final Object observer = mListView.getChildAt(swapViewStartLeft - mListView.getFirstVisiblePosition());
        if (observer == null)
        {
            swapViewStartLeft = 0;
        } else
        {
            swapViewStartLeft = ((View) (observer)).getLeft();
        }
        observer = getViewTreeObserver();
        ((ViewTreeObserver) (observer)).addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

            final DragSortWidget this$0;
            final ViewTreeObserver val$observer;
            final int val$swapViewStartLeft;
            final int val$to;

            public boolean onPreDraw()
            {
                observer.removeOnPreDrawListener(this);
                Object obj = mListView.getChildAt(to - mListView.getFirstVisiblePosition());
                if (obj != null)
                {
                    int i = ((View) (obj)).getLeft();
                    ((View) (obj)).setTranslationX(swapViewStartLeft - i);
                    obj = ObjectAnimator.ofFloat(obj, View.TRANSLATION_X, new float[] {
                        0.0F
                    });
                    ((ObjectAnimator) (obj)).setDuration(100L);
                    ((ObjectAnimator) (obj)).addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

                        final _cls1 this$1;

                        public void onAnimationUpdate(ValueAnimator valueanimator)
                        {
                            mListView.invalidate();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    ((ObjectAnimator) (obj)).start();
                }
                return true;
            }

            
            {
                this$0 = DragSortWidget.this;
                observer = viewtreeobserver;
                to = i;
                swapViewStartLeft = j;
                super();
            }
        });
    }

    public boolean canDelete()
    {
        return !mPickingUpContent;
    }

    public void cleanUp()
    {
        mSelectionPosition = -1;
        mFocusedPosition = -1;
        mRemovePosition = -1;
        mDropping = false;
        mRemoving = false;
        destroyFloatView();
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (mFloatView != null)
        {
            canvas.save();
            canvas.translate(mFloatViewX, mFloatViewY);
            canvas.clipRect(0, 0, mFloatViewWidth, mFloatViewHeight);
            canvas.saveLayerAlpha(0.0F, 0.0F, mFloatViewWidth, mFloatViewHeight, (int)mFloatViewAlpha, 31);
            mFloatView.layout(0, 0, mFloatViewWidth, mFloatViewHeight);
            mFloatView.draw(canvas);
            canvas.restore();
            canvas.restore();
            mFloatViewActivatedDrawable.setBounds(mFloatViewX, mFloatViewY, mFloatViewX + mFloatViewWidth, mFloatViewY + mFloatViewHeight);
            mFloatViewActivatedDrawable.setAlpha((int)mFloatViewAlpha);
            mFloatViewActivatedDrawable.draw(canvas);
        } else
        if (mSelectionPosition != -1)
        {
            View view = mListView.getChildAt(mSelectionPosition - mListView.getFirstVisiblePosition());
            if (view != null && !mRemoving)
            {
                mActivatedDrawable.setBounds(view.getLeft() + mListView.getLeft(), view.getTop() + mListView.getTop(), view.getRight() + mListView.getLeft(), view.getBottom() + mListView.getTop());
                mActivatedDrawable.setAlpha(255);
                mActivatedDrawable.draw(canvas);
                return;
            }
        }
    }

    public boolean floatViewIsFromContentView()
    {
        return isFromContentView;
    }

    public Rect getFloatViewBounds()
    {
        if (mFloatView != null)
        {
            return new Rect(mFloatViewX, mFloatViewY, mFloatViewX + mFloatViewWidth, mFloatViewY + mFloatViewHeight);
        } else
        {
            return null;
        }
    }

    public boolean hasFloatView()
    {
        return mFloatView != null;
    }

    public void onFinishInflate()
    {
        mListView = (HorizontalListView)findViewById(0x102000a);
        mListView.setOnTouchListener(this);
        mListView.setOnItemClickListener(this);
        mListView.setFingerScrollEnabled(true);
        mListView.setOnScrollListener(this);
        mCheckForLongPress = new CheckForLongPress();
        mMaxScrollSpeed = getResources().getDisplayMetrics().xdpi * 0.1F;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (mTouchX - mListView.getLeft() >= 0 && mTouchX - mListView.getLeft() < mListView.getWidth() && mTouchY - mListView.getTop() >= 0 && mTouchY - mListView.getTop() < mListView.getHeight())
        {
            handleClick(i, true);
        }
    }

    public void onScroll()
    {
        invalidate();
        removeCallbacks(mCheckForLongPress);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return onTouch(view, motionevent, 0, 0);
    }

    public boolean onTouch(View view, MotionEvent motionevent, int i, int j)
    {
        boolean flag = false;
        mTouchX = (int)motionevent.getX() + view.getLeft() + i;
        mTouchY = (int)motionevent.getY() + view.getTop() + j;
        if (view == mListView)
        {
            isFromContentView = false;
            flag = handleListViewTouch(motionevent);
        } else
        if (view == mContentView)
        {
            isFromContentView = true;
            return handleContentViewTouch(motionevent);
        }
        return flag;
    }

    public void releaseReferences()
    {
        setAdapter(null);
        mCurrentlyPlayingProvider = null;
        mContentView = null;
    }

    public void removeSelection()
    {
        mRemoveAnimator.start();
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (listadapter != null)
        {
            if (listadapter instanceof FloatViewInteractionListener)
            {
                setFloatViewInteractionListener((FloatViewInteractionListener)listadapter);
            }
            if (listadapter instanceof DragListener)
            {
                setDragListener((DragListener)listadapter);
            }
            if (listadapter instanceof RemoveListener)
            {
                setRemoveListener((RemoveListener)listadapter);
            }
            if (listadapter instanceof SelectionChangedListener)
            {
                setSelectionChangedListener((SelectionChangedListener)listadapter);
            }
            if (mAdapterWrapper == null)
            {
                mAdapterWrapper = new DragSortAdapterWrapper(getContext());
            }
            mAdapterWrapper.setAdapter(listadapter);
            mListView.setAdapter(mAdapterWrapper);
        } else
        {
            setFloatViewInteractionListener(null);
            setDragListener(null);
            setRemoveListener(null);
            setSelectionChangedListener(null);
            mListView.setAdapter(null);
            if (mAdapterWrapper != null)
            {
                mAdapterWrapper.setAdapter(null);
                return;
            }
        }
    }

    public void setContentView(View view, Rect rect)
    {
        mContentView = view;
        mContentViewBounds = rect;
        view.setOnTouchListener(this);
    }

    public void setCurrentlyPlayingProvider(CurrentlyPlayingProvider currentlyplayingprovider)
    {
        mCurrentlyPlayingProvider = currentlyplayingprovider;
    }

    public void setDragListener(DragListener draglistener)
    {
        mDragListener = draglistener;
    }

    public void setFirstItem(int i)
    {
        mListView.setSelection(i);
        if (mFloatView != null && !mDropping)
        {
            dragFloatView(mFloatViewListPosition, getClosestItemPosition());
        }
    }

    public void setFloatViewInteractionListener(FloatViewInteractionListener floatviewinteractionlistener)
    {
        mFloatViewInteractionListener = floatviewinteractionlistener;
    }

    public void setFocused(int i)
    {
        mFocusedPosition = i;
        adjustItems();
        mListView.invalidate();
    }

    public void setRemoveListener(RemoveListener removelistener)
    {
        mRemoveListener = removelistener;
    }

    public void setSelection(int i)
    {
        mSelectionPosition = i;
        if (i != -1)
        {
            mFocusedPosition = i;
        }
        adjustItems();
        invalidate();
    }

    public void setSelectionChangedListener(SelectionChangedListener selectionchangedlistener)
    {
        mSelectionChangedListener = selectionchangedlistener;
    }






/*
    static float access$1002(DragSortWidget dragsortwidget, float f)
    {
        dragsortwidget.mFloatViewAlpha = f;
        return f;
    }

*/


/*
    static int access$102(DragSortWidget dragsortwidget, int i)
    {
        dragsortwidget.mFloatViewListPosition = i;
        return i;
    }

*/






/*
    static int access$1402(DragSortWidget dragsortwidget, int i)
    {
        dragsortwidget.mFloatViewWidth = i;
        return i;
    }

*/



/*
    static int access$1502(DragSortWidget dragsortwidget, int i)
    {
        dragsortwidget.mFloatViewHeight = i;
        return i;
    }

*/



/*
    static int access$1602(DragSortWidget dragsortwidget, int i)
    {
        dragsortwidget.mXOffsetFromTouch = i;
        return i;
    }

*/



/*
    static int access$1702(DragSortWidget dragsortwidget, int i)
    {
        dragsortwidget.mYOffsetFromTouch = i;
        return i;
    }

*/





/*
    static boolean access$2002(DragSortWidget dragsortwidget, boolean flag)
    {
        dragsortwidget.mPickingUpContent = flag;
        return flag;
    }

*/



/*
    static int access$2102(DragSortWidget dragsortwidget, int i)
    {
        dragsortwidget.mRemovePosition = i;
        return i;
    }

*/

















/*
    static int access$702(DragSortWidget dragsortwidget, int i)
    {
        dragsortwidget.mFloatViewX = i;
        return i;
    }

*/



/*
    static int access$802(DragSortWidget dragsortwidget, int i)
    {
        dragsortwidget.mFloatViewY = i;
        return i;
    }

*/


    // Unreferenced inner class co/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper$1

/* anonymous class */
    class DragSortAdapterWrapper._cls1 extends DataSetObserver
    {

        final DragSortAdapterWrapper this$1;

        public void onChanged()
        {
            notifyDataSetChanged();
            adjustItems();
        }

            
            {
                this$1 = DragSortAdapterWrapper.this;
                super();
            }
    }

}

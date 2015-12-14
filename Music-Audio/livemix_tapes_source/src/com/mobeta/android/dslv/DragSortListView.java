// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortController, DragSortItemView, DragSortItemViewCheckable

public class DragSortListView extends ListView
{
    private class AdapterWrapper extends BaseAdapter
    {

        private ListAdapter mAdapter;
        final DragSortListView this$0;

        public boolean areAllItemsEnabled()
        {
            return mAdapter.areAllItemsEnabled();
        }

        public ListAdapter getAdapter()
        {
            return mAdapter;
        }

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

        public int getItemViewType(int i)
        {
            return mAdapter.getItemViewType(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view != null)
            {
                viewgroup = (DragSortItemView)view;
                View view1 = viewgroup.getChildAt(0);
                View view2 = mAdapter.getView(i, view1, DragSortListView.this);
                view = viewgroup;
                if (view2 != view1)
                {
                    if (view1 != null)
                    {
                        viewgroup.removeViewAt(0);
                    }
                    viewgroup.addView(view2);
                    view = viewgroup;
                }
            } else
            {
                viewgroup = mAdapter.getView(i, null, DragSortListView.this);
                if (viewgroup instanceof Checkable)
                {
                    view = new DragSortItemViewCheckable(getContext());
                } else
                {
                    view = new DragSortItemView(getContext());
                }
                view.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
                view.addView(viewgroup);
            }
            adjustItem(getHeaderViewsCount() + i, view, true);
            return view;
        }

        public int getViewTypeCount()
        {
            return mAdapter.getViewTypeCount();
        }

        public boolean hasStableIds()
        {
            return mAdapter.hasStableIds();
        }

        public boolean isEmpty()
        {
            return mAdapter.isEmpty();
        }

        public boolean isEnabled(int i)
        {
            return mAdapter.isEnabled(i);
        }

        public AdapterWrapper(ListAdapter listadapter)
        {
            this$0 = DragSortListView.this;
            super();
            mAdapter = listadapter;
            mAdapter.registerDataSetObserver(new _cls1());
        }
    }

    public static interface DragListener
    {

        public abstract void drag(int i, int j);
    }

    public static interface DragScrollProfile
    {

        public abstract float getSpeed(float f, long l);
    }

    private class DragScroller
        implements Runnable
    {

        public static final int DOWN = 1;
        public static final int STOP = -1;
        public static final int UP = 0;
        private float dt;
        private int dy;
        private boolean mAbort;
        private long mCurrTime;
        private int mFirstFooter;
        private int mLastHeader;
        private long mPrevTime;
        private float mScrollSpeed;
        private boolean mScrolling;
        private int scrollDir;
        private long tStart;
        final DragSortListView this$0;

        public int getScrollDir()
        {
            if (mScrolling)
            {
                return scrollDir;
            } else
            {
                return -1;
            }
        }

        public boolean isScrolling()
        {
            return mScrolling;
        }

        public void run()
        {
            if (mAbort)
            {
                mScrolling = false;
                return;
            }
            int j = getFirstVisiblePosition();
            int i = getLastVisiblePosition();
            int l = getCount();
            int k = getPaddingTop();
            int i1 = getHeight() - k - getPaddingBottom();
            int j1 = Math.min(mY, mFloatViewMid + mFloatViewHeightHalf);
            int k1 = Math.max(mY, mFloatViewMid - mFloatViewHeightHalf);
            View view1;
            if (scrollDir == 0)
            {
                View view = getChildAt(0);
                if (view == null)
                {
                    mScrolling = false;
                    return;
                }
                if (j == 0 && view.getTop() == k)
                {
                    mScrolling = false;
                    return;
                }
                mScrollSpeed = mScrollProfile.getSpeed((mUpScrollStartYF - (float)k1) / mDragUpScrollHeight, mPrevTime);
            } else
            {
                View view2 = getChildAt(i - j);
                if (view2 == null)
                {
                    mScrolling = false;
                    return;
                }
                if (i == l - 1 && view2.getBottom() <= i1 + k)
                {
                    mScrolling = false;
                    return;
                }
                mScrollSpeed = -mScrollProfile.getSpeed(((float)j1 - mDownScrollStartYF) / mDragDownScrollHeight, mPrevTime);
            }
            mCurrTime = SystemClock.uptimeMillis();
            dt = mCurrTime - mPrevTime;
            dy = Math.round(mScrollSpeed * dt);
            if (dy >= 0)
            {
                dy = Math.min(i1, dy);
                i = j;
            } else
            {
                dy = Math.max(-i1, dy);
            }
            view1 = getChildAt(i - j);
            l = view1.getTop() + dy;
            j = l;
            if (i == 0)
            {
                j = l;
                if (l > k)
                {
                    j = k;
                }
            }
            mBlockLayoutRequests = true;
            setSelectionFromTop(i, j - k);
            layoutChildren();
            invalidate();
            mBlockLayoutRequests = false;
            doDragFloatView(i, view1, false);
            mPrevTime = mCurrTime;
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
                removeCallbacks(this);
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
            this$0 = DragSortListView.this;
            super();
            mScrolling = false;
        }
    }

    public static interface DragSortListener
        extends DropListener, DragListener, RemoveListener
    {
    }

    private class DragSortTracker
    {

        StringBuilder mBuilder;
        File mFile;
        private int mNumFlushes;
        private int mNumInBuffer;
        private boolean mTracking;
        final DragSortListView this$0;

        public void appendState()
        {
            if (mTracking) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i;
            int j;
            int k;
            mBuilder.append("<DSLVState>\n");
            j = getChildCount();
            k = getFirstVisiblePosition();
            mBuilder.append("    <Positions>");
            i = 0;
_L9:
            if (i < j) goto _L4; else goto _L3
_L3:
            mBuilder.append("</Positions>\n");
            mBuilder.append("    <Tops>");
            i = 0;
_L10:
            if (i < j) goto _L6; else goto _L5
_L5:
            mBuilder.append("</Tops>\n");
            mBuilder.append("    <Bottoms>");
            i = 0;
_L11:
            if (i < j) goto _L8; else goto _L7
_L7:
            mBuilder.append("</Bottoms>\n");
            mBuilder.append("    <FirstExpPos>").append(mFirstExpPos).append("</FirstExpPos>\n");
            mBuilder.append("    <FirstExpBlankHeight>").append(getItemHeight(mFirstExpPos) - getChildHeight(mFirstExpPos)).append("</FirstExpBlankHeight>\n");
            mBuilder.append("    <SecondExpPos>").append(mSecondExpPos).append("</SecondExpPos>\n");
            mBuilder.append("    <SecondExpBlankHeight>").append(getItemHeight(mSecondExpPos) - getChildHeight(mSecondExpPos)).append("</SecondExpBlankHeight>\n");
            mBuilder.append("    <SrcPos>").append(mSrcPos).append("</SrcPos>\n");
            mBuilder.append("    <SrcHeight>").append(mFloatViewHeight + getDividerHeight()).append("</SrcHeight>\n");
            mBuilder.append("    <ViewHeight>").append(getHeight()).append("</ViewHeight>\n");
            mBuilder.append("    <LastY>").append(mLastY).append("</LastY>\n");
            mBuilder.append("    <FloatY>").append(mFloatViewMid).append("</FloatY>\n");
            mBuilder.append("    <ShuffleEdges>");
            i = 0;
_L12:
            if (i < j)
            {
                break MISSING_BLOCK_LABEL_544;
            }
            mBuilder.append("</ShuffleEdges>\n");
            mBuilder.append("</DSLVState>\n");
            mNumInBuffer = mNumInBuffer + 1;
            if (mNumInBuffer > 1000)
            {
                flush();
                mNumInBuffer = 0;
                return;
            }
              goto _L1
_L4:
            mBuilder.append(k + i).append(",");
            i++;
              goto _L9
_L6:
            mBuilder.append(getChildAt(i).getTop()).append(",");
            i++;
              goto _L10
_L8:
            mBuilder.append(getChildAt(i).getBottom()).append(",");
            i++;
              goto _L11
            mBuilder.append(getShuffleEdge(k + i, getChildAt(i).getTop())).append(",");
            i++;
              goto _L12
        }

        public void flush()
        {
            boolean flag;
            if (!mTracking)
            {
                return;
            }
            flag = true;
            if (mNumFlushes == 0)
            {
                flag = false;
            }
            try
            {
                FileWriter filewriter = new FileWriter(mFile, flag);
                filewriter.write(mBuilder.toString());
                mBuilder.delete(0, mBuilder.length());
                filewriter.flush();
                filewriter.close();
                mNumFlushes = mNumFlushes + 1;
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }

        public void startTracking()
        {
            mBuilder.append("<DSLVStates>\n");
            mNumFlushes = 0;
            mTracking = true;
        }

        public void stopTracking()
        {
            if (mTracking)
            {
                mBuilder.append("</DSLVStates>\n");
                flush();
                mTracking = false;
            }
        }

        public DragSortTracker()
        {
            this$0 = DragSortListView.this;
            super();
            mBuilder = new StringBuilder();
            mNumInBuffer = 0;
            mNumFlushes = 0;
            mTracking = false;
            mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            if (mFile.exists())
            {
                break MISSING_BLOCK_LABEL_77;
            }
            mFile.createNewFile();
            Log.d("mobeta", "file created");
            return;
            dragsortlistview;
            Log.w("mobeta", "Could not create dslv_state.txt");
            Log.d("mobeta", getMessage());
            return;
        }
    }

    private class DropAnimator extends SmoothAnimator
    {

        private int mDropPos;
        private float mInitDeltaX;
        private float mInitDeltaY;
        private int srcPos;
        final DragSortListView this$0;

        private int getTargetY()
        {
            int i = getFirstVisiblePosition();
            int j = (mItemHeightCollapsed + getDividerHeight()) / 2;
            View view = getChildAt(mDropPos - i);
            if (view != null)
            {
                if (mDropPos == srcPos)
                {
                    return view.getTop();
                }
                if (mDropPos < srcPos)
                {
                    return view.getTop() - j;
                } else
                {
                    return (view.getBottom() + j) - mFloatViewHeight;
                }
            } else
            {
                cancel();
                return -1;
            }
        }

        public void onStart()
        {
            mDropPos = mFloatPos;
            srcPos = mSrcPos;
            mDragState = 2;
            mInitDeltaY = mFloatLoc.y - getTargetY();
            mInitDeltaX = mFloatLoc.x - getPaddingLeft();
        }

        public void onStop()
        {
            dropFloatView();
        }

        public void onUpdate(float f, float f1)
        {
            int i = getTargetY();
            int j = getPaddingLeft();
            f = mFloatLoc.y - i;
            float f2 = mFloatLoc.x - j;
            f1 = 1.0F - f1;
            if (f1 < Math.abs(f / mInitDeltaY) || f1 < Math.abs(f2 / mInitDeltaX))
            {
                mFloatLoc.y = (int)(mInitDeltaY * f1) + i;
                mFloatLoc.x = getPaddingLeft() + (int)(mInitDeltaX * f1);
                doDragFloatView(true);
            }
        }

        public DropAnimator(float f, int i)
        {
            this$0 = DragSortListView.this;
            super(f, i);
        }
    }

    public static interface DropListener
    {

        public abstract void drop(int i, int j);
    }

    public static interface FloatViewManager
    {

        public abstract View onCreateFloatView(int i);

        public abstract void onDestroyFloatView(View view);

        public abstract void onDragFloatView(View view, Point point, Point point1);
    }

    private class HeightCache
    {

        private SparseIntArray mMap;
        private int mMaxSize;
        private ArrayList mOrder;
        final DragSortListView this$0;

        public void add(int i, int j)
        {
            int k = mMap.get(i, -1);
            if (k != j)
            {
                if (k == -1)
                {
                    if (mMap.size() == mMaxSize)
                    {
                        mMap.delete(((Integer)mOrder.remove(0)).intValue());
                    }
                } else
                {
                    mOrder.remove(Integer.valueOf(i));
                }
                mMap.put(i, j);
                mOrder.add(Integer.valueOf(i));
            }
        }

        public void clear()
        {
            mMap.clear();
            mOrder.clear();
        }

        public int get(int i)
        {
            return mMap.get(i, -1);
        }

        public HeightCache(int i)
        {
            this$0 = DragSortListView.this;
            super();
            mMap = new SparseIntArray(i);
            mOrder = new ArrayList(i);
            mMaxSize = i;
        }
    }

    private class LiftAnimator extends SmoothAnimator
    {

        private float mFinalDragDeltaY;
        private float mInitDragDeltaY;
        final DragSortListView this$0;

        public void onStart()
        {
            mInitDragDeltaY = mDragDeltaY;
            mFinalDragDeltaY = mFloatViewHeightHalf;
        }

        public void onUpdate(float f, float f1)
        {
            if (mDragState != 4)
            {
                cancel();
                return;
            } else
            {
                mDragDeltaY = (int)(mFinalDragDeltaY * f1 + (1.0F - f1) * mInitDragDeltaY);
                mFloatLoc.y = mY - mDragDeltaY;
                doDragFloatView(true);
                return;
            }
        }

        public LiftAnimator(float f, int i)
        {
            this$0 = DragSortListView.this;
            super(f, i);
        }
    }

    private class RemoveAnimator extends SmoothAnimator
    {

        private int mFirstChildHeight;
        private int mFirstPos;
        private float mFirstStartBlank;
        private float mFloatLocX;
        private int mSecondChildHeight;
        private int mSecondPos;
        private float mSecondStartBlank;
        private int srcPos;
        final DragSortListView this$0;

        public void onStart()
        {
            float f;
            int i;
            i = -1;
            mFirstChildHeight = -1;
            mSecondChildHeight = -1;
            mFirstPos = mFirstExpPos;
            mSecondPos = mSecondExpPos;
            srcPos = mSrcPos;
            mDragState = 1;
            mFloatLocX = mFloatLoc.x;
            if (!mUseRemoveVelocity)
            {
                break MISSING_BLOCK_LABEL_201;
            }
            f = 2.0F * (float)getWidth();
            if (mRemoveVelocityX != 0.0F) goto _L2; else goto _L1
_L1:
            DragSortListView dragsortlistview = DragSortListView.this;
            if (mFloatLocX >= 0.0F)
            {
                i = 1;
            }
            dragsortlistview.mRemoveVelocityX = (float)i * f;
_L4:
            return;
_L2:
            f *= 2.0F;
            if (mRemoveVelocityX < 0.0F && mRemoveVelocityX > -f)
            {
                mRemoveVelocityX = -f;
                return;
            }
            if (mRemoveVelocityX <= 0.0F || mRemoveVelocityX >= f) goto _L4; else goto _L3
_L3:
            mRemoveVelocityX = f;
            return;
            destroyFloatView();
            return;
        }

        public void onStop()
        {
            doRemoveItem();
        }

        public void onUpdate(float f, float f1)
        {
            View view;
            int l;
            f = 1.0F - f1;
            l = getFirstVisiblePosition();
            view = getChildAt(mFirstPos - l);
            if (!mUseRemoveVelocity) goto _L2; else goto _L1
_L1:
            f1 = (float)(SystemClock.uptimeMillis() - mStartTime) / 1000F;
            if (f1 != 0.0F) goto _L4; else goto _L3
_L3:
            return;
_L4:
            float f2 = mRemoveVelocityX;
            int i1 = getWidth();
            DragSortListView dragsortlistview = DragSortListView.this;
            float f3 = dragsortlistview.mRemoveVelocityX;
            int i;
            if (mRemoveVelocityX > 0.0F)
            {
                i = 1;
            } else
            {
                i = -1;
            }
            dragsortlistview.mRemoveVelocityX = (float)i * f1 * (float)i1 + f3;
            mFloatLocX = mFloatLocX + f2 * f1;
            mFloatLoc.x = (int)mFloatLocX;
            if (mFloatLocX < (float)i1 && mFloatLocX > (float)(-i1))
            {
                mStartTime = SystemClock.uptimeMillis();
                doDragFloatView(true);
                return;
            }
_L2:
            if (view != null)
            {
                if (mFirstChildHeight == -1)
                {
                    mFirstChildHeight = getChildHeight(mFirstPos, view, false);
                    mFirstStartBlank = view.getHeight() - mFirstChildHeight;
                }
                int j = Math.max((int)(mFirstStartBlank * f), 1);
                android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
                layoutparams.height = mFirstChildHeight + j;
                view.setLayoutParams(layoutparams);
            }
            if (mSecondPos != mFirstPos)
            {
                View view1 = getChildAt(mSecondPos - l);
                if (view1 != null)
                {
                    if (mSecondChildHeight == -1)
                    {
                        mSecondChildHeight = getChildHeight(mSecondPos, view1, false);
                        mSecondStartBlank = view1.getHeight() - mSecondChildHeight;
                    }
                    int k = Math.max((int)(mSecondStartBlank * f), 1);
                    android.view.ViewGroup.LayoutParams layoutparams1 = view1.getLayoutParams();
                    layoutparams1.height = mSecondChildHeight + k;
                    view1.setLayoutParams(layoutparams1);
                    return;
                }
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        public RemoveAnimator(float f, int i)
        {
            this$0 = DragSortListView.this;
            super(f, i);
            mFirstChildHeight = -1;
            mSecondChildHeight = -1;
        }
    }

    public static interface RemoveListener
    {

        public abstract void remove(int i);
    }

    private class SmoothAnimator
        implements Runnable
    {

        private float mA;
        private float mAlpha;
        private float mB;
        private float mC;
        private boolean mCanceled;
        private float mD;
        private float mDurationF;
        protected long mStartTime;
        final DragSortListView this$0;

        public void cancel()
        {
            mCanceled = true;
        }

        public void onStart()
        {
        }

        public void onStop()
        {
        }

        public void onUpdate(float f, float f1)
        {
        }

        public void run()
        {
            if (mCanceled)
            {
                return;
            }
            float f = (float)(SystemClock.uptimeMillis() - mStartTime) / mDurationF;
            if (f >= 1.0F)
            {
                onUpdate(1.0F, 1.0F);
                onStop();
                return;
            } else
            {
                onUpdate(f, transform(f));
                post(this);
                return;
            }
        }

        public void start()
        {
            mStartTime = SystemClock.uptimeMillis();
            mCanceled = false;
            onStart();
            post(this);
        }

        public float transform(float f)
        {
            if (f < mAlpha)
            {
                return mA * f * f;
            }
            if (f < 1.0F - mAlpha)
            {
                return mB + mC * f;
            } else
            {
                return 1.0F - mD * (f - 1.0F) * (f - 1.0F);
            }
        }

        public SmoothAnimator(float f, int i)
        {
            this$0 = DragSortListView.this;
            super();
            mAlpha = f;
            mDurationF = i;
            f = 1.0F / (mAlpha * 2.0F * (1.0F - mAlpha));
            mD = f;
            mA = f;
            mB = mAlpha / ((mAlpha - 1.0F) * 2.0F);
            mC = 1.0F / (1.0F - mAlpha);
        }
    }


    private static final int DRAGGING = 4;
    public static final int DRAG_NEG_X = 2;
    public static final int DRAG_NEG_Y = 8;
    public static final int DRAG_POS_X = 1;
    public static final int DRAG_POS_Y = 4;
    private static final int DROPPING = 2;
    private static final int IDLE = 0;
    private static final int NO_CANCEL = 0;
    private static final int ON_INTERCEPT_TOUCH_EVENT = 2;
    private static final int ON_TOUCH_EVENT = 1;
    private static final int REMOVING = 1;
    private static final int STOPPED = 3;
    private static final int sCacheSize = 3;
    private AdapterWrapper mAdapterWrapper;
    private boolean mAnimate;
    private boolean mBlockLayoutRequests;
    private MotionEvent mCancelEvent;
    private int mCancelMethod;
    private HeightCache mChildHeightCache;
    private float mCurrFloatAlpha;
    private int mDownScrollStartY;
    private float mDownScrollStartYF;
    private int mDragDeltaX;
    private int mDragDeltaY;
    private float mDragDownScrollHeight;
    private float mDragDownScrollStartFrac;
    private boolean mDragEnabled;
    private int mDragFlags;
    private DragListener mDragListener;
    private DragScroller mDragScroller;
    private DragSortTracker mDragSortTracker;
    private int mDragStartY;
    private int mDragState;
    private float mDragUpScrollHeight;
    private float mDragUpScrollStartFrac;
    private DropAnimator mDropAnimator;
    private DropListener mDropListener;
    private int mFirstExpPos;
    private float mFloatAlpha;
    private Point mFloatLoc;
    private int mFloatPos;
    private View mFloatView;
    private int mFloatViewHeight;
    private int mFloatViewHeightHalf;
    private boolean mFloatViewInvalidated;
    private FloatViewManager mFloatViewManager;
    private int mFloatViewMid;
    private boolean mFloatViewOnMeasured;
    private boolean mIgnoreTouchEvent;
    private boolean mInTouchEvent;
    private int mItemHeightCollapsed;
    private boolean mLastCallWasIntercept;
    private int mLastX;
    private int mLastY;
    private LiftAnimator mLiftAnimator;
    private boolean mListViewIntercepted;
    private float mMaxScrollSpeed;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private RemoveAnimator mRemoveAnimator;
    private RemoveListener mRemoveListener;
    private float mRemoveVelocityX;
    private View mSampleViewTypes[];
    private DragScrollProfile mScrollProfile;
    private int mSecondExpPos;
    private float mSlideFrac;
    private float mSlideRegionFrac;
    private int mSrcPos;
    private Point mTouchLoc;
    private boolean mTrackDragSort;
    private int mUpScrollStartY;
    private float mUpScrollStartYF;
    private boolean mUseRemoveVelocity;
    private int mWidthMeasureSpec;
    private int mX;
    private int mY;

    public DragSortListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFloatLoc = new Point();
        mTouchLoc = new Point();
        mFloatViewOnMeasured = false;
        mFloatAlpha = 1.0F;
        mCurrFloatAlpha = 1.0F;
        mAnimate = false;
        mDragEnabled = true;
        mDragState = 0;
        mItemHeightCollapsed = 1;
        mWidthMeasureSpec = 0;
        mSampleViewTypes = new View[1];
        mDragUpScrollStartFrac = 0.3333333F;
        mDragDownScrollStartFrac = 0.3333333F;
        mMaxScrollSpeed = 0.5F;
        mScrollProfile = new DragScrollProfile() {

            final DragSortListView this$0;

            public float getSpeed(float f, long l2)
            {
                return mMaxScrollSpeed * f;
            }

            
            {
                this$0 = DragSortListView.this;
                super();
            }
        };
        mDragFlags = 0;
        mLastCallWasIntercept = false;
        mInTouchEvent = false;
        mFloatViewManager = null;
        mCancelMethod = 0;
        mSlideRegionFrac = 0.25F;
        mSlideFrac = 0.0F;
        mTrackDragSort = false;
        mBlockLayoutRequests = false;
        mIgnoreTouchEvent = false;
        mChildHeightCache = new HeightCache(3);
        mRemoveVelocityX = 0.0F;
        mListViewIntercepted = false;
        mFloatViewInvalidated = false;
        char c1 = '\226';
        char c = '\226';
        int j = c;
        int i = c1;
        if (attributeset != null)
        {
            context = getContext().obtainStyledAttributes(attributeset, R.styleable.DragSortListView, 0, 0);
            mItemHeightCollapsed = Math.max(1, context.getDimensionPixelSize(0, 1));
            mTrackDragSort = context.getBoolean(5, false);
            if (mTrackDragSort)
            {
                mDragSortTracker = new DragSortTracker();
            }
            mFloatAlpha = context.getFloat(6, mFloatAlpha);
            mCurrFloatAlpha = mFloatAlpha;
            mDragEnabled = context.getBoolean(10, mDragEnabled);
            mSlideRegionFrac = Math.max(0.0F, Math.min(1.0F, 1.0F - context.getFloat(7, 0.75F)));
            boolean flag;
            if (mSlideRegionFrac > 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mAnimate = flag;
            setDragScrollStart(context.getFloat(1, mDragUpScrollStartFrac));
            mMaxScrollSpeed = context.getFloat(2, mMaxScrollSpeed);
            i = context.getInt(8, c1);
            j = context.getInt(9, c);
            if (context.getBoolean(17, true))
            {
                flag = context.getBoolean(12, false);
                int k = context.getInt(4, 1);
                boolean flag1 = context.getBoolean(11, true);
                int l = context.getInt(13, 0);
                int i1 = context.getResourceId(14, 0);
                int j1 = context.getResourceId(15, 0);
                int k1 = context.getResourceId(16, 0);
                int l1 = context.getColor(3, 0xff000000);
                attributeset = new DragSortController(this, i1, l, k, k1, j1);
                attributeset.setRemoveEnabled(flag);
                attributeset.setSortEnabled(flag1);
                attributeset.setBackgroundColor(l1);
                mFloatViewManager = attributeset;
                setOnTouchListener(attributeset);
            }
            context.recycle();
        }
        mDragScroller = new DragScroller();
        if (i > 0)
        {
            mRemoveAnimator = new RemoveAnimator(0.5F, i);
        }
        if (j > 0)
        {
            mDropAnimator = new DropAnimator(0.5F, j);
        }
        mCancelEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
        mObserver = new DataSetObserver() {

            final DragSortListView this$0;

            private void cancel()
            {
                if (mDragState == 4)
                {
                    cancelDrag();
                }
            }

            public void onChanged()
            {
                cancel();
            }

            public void onInvalidated()
            {
                cancel();
            }

            
            {
                this$0 = DragSortListView.this;
                super();
            }
        };
    }

    private void adjustAllItems()
    {
        int j = getFirstVisiblePosition();
        int k = getLastVisiblePosition();
        int i = Math.max(0, getHeaderViewsCount() - j);
        k = Math.min(k - j, getCount() - 1 - getFooterViewsCount() - j);
        do
        {
            if (i > k)
            {
                return;
            }
            View view = getChildAt(i);
            if (view != null)
            {
                adjustItem(j + i, view, false);
            }
            i++;
        } while (true);
    }

    private void adjustItem(int i)
    {
        View view = getChildAt(i - getFirstVisiblePosition());
        if (view != null)
        {
            adjustItem(i, view, false);
        }
    }

    private void adjustItem(int i, View view, boolean flag)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        int j;
        boolean flag1;
        int k;
        if (i != mSrcPos && i != mFirstExpPos && i != mSecondExpPos)
        {
            j = -2;
        } else
        {
            j = calcItemHeight(i, view, flag);
        }
        if (j != layoutparams.height)
        {
            layoutparams.height = j;
            view.setLayoutParams(layoutparams);
        }
        if (i != mFirstExpPos && i != mSecondExpPos) goto _L2; else goto _L1
_L1:
        if (i >= mSrcPos) goto _L4; else goto _L3
_L3:
        ((DragSortItemView)view).setGravity(80);
_L2:
        k = view.getVisibility();
        flag1 = false;
        j = ((flag1) ? 1 : 0);
        if (i == mSrcPos)
        {
            j = ((flag1) ? 1 : 0);
            if (mFloatView != null)
            {
                j = 4;
            }
        }
        if (j != k)
        {
            view.setVisibility(j);
        }
        return;
_L4:
        if (i > mSrcPos)
        {
            ((DragSortItemView)view).setGravity(48);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void adjustOnReorder()
    {
        int j = getFirstVisiblePosition();
        if (mSrcPos < j)
        {
            View view = getChildAt(0);
            int i = 0;
            if (view != null)
            {
                i = view.getTop();
            }
            setSelectionFromTop(j - 1, i - getPaddingTop());
        }
    }

    private int adjustScroll(int i, View view, int j, int k)
    {
        boolean flag = false;
        int j2 = getChildHeight(i);
        int l1 = view.getHeight();
        int i2 = calcItemHeight(i, j2);
        int k1 = l1;
        int j1 = i2;
        int l = j1;
        int i1 = k1;
        if (i != mSrcPos)
        {
            i1 = k1 - j2;
            l = j1 - j2;
        }
        k1 = mFloatViewHeight;
        j1 = k1;
        if (mSrcPos != mFirstExpPos)
        {
            j1 = k1;
            if (mSrcPos != mSecondExpPos)
            {
                j1 = k1 - mItemHeightCollapsed;
            }
        }
        if (i <= j)
        {
            j = ((flag) ? 1 : 0);
            if (i > mFirstExpPos)
            {
                j = 0 + (j1 - l);
            }
        } else
        {
            if (i == k)
            {
                if (i <= mFirstExpPos)
                {
                    return 0 + (i1 - j1);
                }
                if (i == mSecondExpPos)
                {
                    return 0 + (l1 - i2);
                } else
                {
                    return 0 + i1;
                }
            }
            if (i <= mFirstExpPos)
            {
                return 0 - j1;
            }
            j = ((flag) ? 1 : 0);
            if (i == mSecondExpPos)
            {
                return 0 - l;
            }
        }
        return j;
    }

    private static int buildRunList(SparseBooleanArray sparsebooleanarray, int i, int j, int ai[], int ai1[])
    {
        int k;
        int l;
        int i1;
        int j1;
        i1 = 0;
        l = findFirstSetIndex(sparsebooleanarray, i, j);
        if (l == -1)
        {
            return 0;
        }
        j1 = sparsebooleanarray.keyAt(l);
        k = j1 + 1;
        l++;
_L2:
        int k1;
label0:
        {
            if (l < sparsebooleanarray.size())
            {
                k1 = sparsebooleanarray.keyAt(l);
                if (k1 < j)
                {
                    break label0;
                }
            }
            l = k;
            if (k == j)
            {
                l = i;
            }
            ai[i1] = j1;
            ai1[i1] = l;
            k = i1 + 1;
            j = k;
            if (k > 1)
            {
                j = k;
                if (ai[0] == i)
                {
                    j = k;
                    if (ai1[k - 1] == i)
                    {
                        ai[0] = ai[k - 1];
                        j = k - 1;
                    }
                }
            }
            return j;
        }
        if (sparsebooleanarray.valueAt(l))
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        l++;
        if (true) goto _L2; else goto _L1
_L1:
        if (k1 == k)
        {
            k++;
        } else
        {
            ai[i1] = j1;
            ai1[i1] = k;
            i1++;
            j1 = k1;
            k = k1 + 1;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private int calcItemHeight(int i, int j)
    {
        getDividerHeight();
        boolean flag;
        int k;
        int l;
        if (mAnimate && mFirstExpPos != mSecondExpPos)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = mFloatViewHeight - mItemHeightCollapsed;
        l = (int)(mSlideFrac * (float)k);
        if (i == mSrcPos)
        {
            if (mSrcPos == mFirstExpPos)
            {
                if (flag)
                {
                    return l + mItemHeightCollapsed;
                } else
                {
                    return mFloatViewHeight;
                }
            }
            if (mSrcPos == mSecondExpPos)
            {
                return mFloatViewHeight - l;
            } else
            {
                return mItemHeightCollapsed;
            }
        }
        if (i == mFirstExpPos)
        {
            if (flag)
            {
                return j + l;
            } else
            {
                return j + k;
            }
        }
        if (i == mSecondExpPos)
        {
            return (j + k) - l;
        } else
        {
            return j;
        }
    }

    private int calcItemHeight(int i, View view, boolean flag)
    {
        return calcItemHeight(i, getChildHeight(i, view, flag));
    }

    private void clearPositions()
    {
        mSrcPos = -1;
        mFirstExpPos = -1;
        mSecondExpPos = -1;
        mFloatPos = -1;
    }

    private void continueDrag(int i, int j)
    {
        mFloatLoc.x = i - mDragDeltaX;
        mFloatLoc.y = j - mDragDeltaY;
        doDragFloatView(true);
        i = Math.min(j, mFloatViewMid + mFloatViewHeightHalf);
        j = Math.max(j, mFloatViewMid - mFloatViewHeightHalf);
        int k = mDragScroller.getScrollDir();
        if (i > mLastY && i > mDownScrollStartY && k != 1)
        {
            if (k != -1)
            {
                mDragScroller.stopScrolling(true);
            }
            mDragScroller.startScrolling(1);
        } else
        {
            if (j < mLastY && j < mUpScrollStartY && k != 0)
            {
                if (k != -1)
                {
                    mDragScroller.stopScrolling(true);
                }
                mDragScroller.startScrolling(0);
                return;
            }
            if (j >= mUpScrollStartY && i <= mDownScrollStartY && mDragScroller.isScrolling())
            {
                mDragScroller.stopScrolling(true);
                return;
            }
        }
    }

    private void destroyFloatView()
    {
        if (mFloatView != null)
        {
            mFloatView.setVisibility(8);
            if (mFloatViewManager != null)
            {
                mFloatViewManager.onDestroyFloatView(mFloatView);
            }
            mFloatView = null;
            invalidate();
        }
    }

    private void doActionUpOrCancel()
    {
        mCancelMethod = 0;
        mInTouchEvent = false;
        if (mDragState == 3)
        {
            mDragState = 0;
        }
        mCurrFloatAlpha = mFloatAlpha;
        mListViewIntercepted = false;
        mChildHeightCache.clear();
    }

    private void doDragFloatView(int i, View view, boolean flag)
    {
        mBlockLayoutRequests = true;
        updateFloatView();
        int j = mFirstExpPos;
        int k = mSecondExpPos;
        boolean flag1 = updatePositions();
        if (flag1)
        {
            adjustAllItems();
            j = adjustScroll(i, view, j, k);
            setSelectionFromTop(i, (view.getTop() + j) - getPaddingTop());
            layoutChildren();
        }
        if (flag1 || flag)
        {
            invalidate();
        }
        mBlockLayoutRequests = false;
    }

    private void doDragFloatView(boolean flag)
    {
        int i = getFirstVisiblePosition();
        int j = getChildCount() / 2;
        View view = getChildAt(getChildCount() / 2);
        if (view == null)
        {
            return;
        } else
        {
            doDragFloatView(i + j, view, flag);
            return;
        }
    }

    private void doRemoveItem()
    {
        doRemoveItem(mSrcPos - getHeaderViewsCount());
    }

    private void doRemoveItem(int i)
    {
        mDragState = 1;
        if (mRemoveListener != null)
        {
            mRemoveListener.remove(i);
        }
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        if (mInTouchEvent)
        {
            mDragState = 3;
            return;
        } else
        {
            mDragState = 0;
            return;
        }
    }

    private void drawDivider(int i, Canvas canvas)
    {
        Drawable drawable = getDivider();
        int i1 = getDividerHeight();
        if (drawable != null && i1 != 0)
        {
            ViewGroup viewgroup = (ViewGroup)getChildAt(i - getFirstVisiblePosition());
            if (viewgroup != null)
            {
                int k = getPaddingLeft();
                int l = getWidth() - getPaddingRight();
                int j = viewgroup.getChildAt(0).getHeight();
                if (i > mSrcPos)
                {
                    j = viewgroup.getTop() + j;
                    i = j + i1;
                } else
                {
                    i = viewgroup.getBottom() - j;
                    j = i - i1;
                }
                canvas.save();
                canvas.clipRect(k, j, l, i);
                drawable.setBounds(k, j, l, i);
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void dropFloatView()
    {
        mDragState = 2;
        if (mDropListener != null && mFloatPos >= 0 && mFloatPos < getCount())
        {
            int i = getHeaderViewsCount();
            mDropListener.drop(mSrcPos - i, mFloatPos - i);
        }
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        adjustAllItems();
        if (mInTouchEvent)
        {
            mDragState = 3;
            return;
        } else
        {
            mDragState = 0;
            return;
        }
    }

    private static int findFirstSetIndex(SparseBooleanArray sparsebooleanarray, int i, int j)
    {
        int k = sparsebooleanarray.size();
        i = insertionIndexForKey(sparsebooleanarray, i);
        do
        {
label0:
            {
label1:
                {
                    if (i < k && sparsebooleanarray.keyAt(i) < j && !sparsebooleanarray.valueAt(i))
                    {
                        break label0;
                    }
                    if (i != k)
                    {
                        k = i;
                        if (sparsebooleanarray.keyAt(i) < j)
                        {
                            break label1;
                        }
                    }
                    k = -1;
                }
                return k;
            }
            i++;
        } while (true);
    }

    private int getChildHeight(int i)
    {
        int j = 0;
        if (i != mSrcPos)
        {
            View view = getChildAt(i - getFirstVisiblePosition());
            if (view != null)
            {
                return getChildHeight(i, view, false);
            }
            int l = mChildHeightCache.get(i);
            j = l;
            if (l == -1)
            {
                Object obj = getAdapter();
                int k = ((ListAdapter) (obj)).getItemViewType(i);
                int i1 = ((ListAdapter) (obj)).getViewTypeCount();
                if (i1 != mSampleViewTypes.length)
                {
                    mSampleViewTypes = new View[i1];
                }
                if (k >= 0)
                {
                    if (mSampleViewTypes[k] == null)
                    {
                        obj = ((ListAdapter) (obj)).getView(i, null, this);
                        mSampleViewTypes[k] = ((View) (obj));
                    } else
                    {
                        obj = ((ListAdapter) (obj)).getView(i, mSampleViewTypes[k], this);
                    }
                } else
                {
                    obj = ((ListAdapter) (obj)).getView(i, null, this);
                }
                k = getChildHeight(i, ((View) (obj)), true);
                mChildHeightCache.add(i, k);
                return k;
            }
        }
        return j;
    }

    private int getChildHeight(int i, View view, boolean flag)
    {
        boolean flag1 = false;
        if (i == mSrcPos)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            android.view.ViewGroup.LayoutParams layoutparams;
            if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount())
            {
                view = ((ViewGroup)view).getChildAt(0);
            }
            layoutparams = view.getLayoutParams();
            if (layoutparams != null && layoutparams.height > 0)
            {
                return layoutparams.height;
            }
            i = view.getHeight();
            if (i == 0 || flag)
            {
                measureItem(view);
                return view.getMeasuredHeight();
            }
        }
        return i;
    }

    private int getItemHeight(int i)
    {
        View view = getChildAt(i - getFirstVisiblePosition());
        if (view != null)
        {
            return view.getHeight();
        } else
        {
            return calcItemHeight(i, getChildHeight(i));
        }
    }

    private int getShuffleEdge(int i, int j)
    {
        int k = getHeaderViewsCount();
        int l = getFooterViewsCount();
        if (i <= k || i >= getCount() - l)
        {
            return j;
        }
        int i1 = getDividerHeight();
        int k1 = mFloatViewHeight - mItemHeightCollapsed;
        int j1 = getChildHeight(i);
        int l1 = getItemHeight(i);
        l = j;
        if (mSecondExpPos <= mSrcPos)
        {
            if (i == mSecondExpPos && mFirstExpPos != mSecondExpPos)
            {
                if (i == mSrcPos)
                {
                    k = (j + l1) - mFloatViewHeight;
                } else
                {
                    k = (j + (l1 - j1)) - k1;
                }
            } else
            {
                k = l;
                if (i > mSecondExpPos)
                {
                    k = l;
                    if (i <= mSrcPos)
                    {
                        k = j - k1;
                    }
                }
            }
        } else
        if (i > mSrcPos && i <= mFirstExpPos)
        {
            k = j + k1;
        } else
        {
            k = l;
            if (i == mSecondExpPos)
            {
                k = l;
                if (mFirstExpPos != mSecondExpPos)
                {
                    k = j + (l1 - j1);
                }
            }
        }
        if (i <= mSrcPos)
        {
            return k + (mFloatViewHeight - i1 - getChildHeight(i - 1)) / 2;
        } else
        {
            return k + (j1 - i1 - mFloatViewHeight) / 2;
        }
    }

    private static int insertionIndexForKey(SparseBooleanArray sparsebooleanarray, int i)
    {
        int j = 0;
        int k = sparsebooleanarray.size();
        do
        {
            if (k - j <= 0)
            {
                return j;
            }
            int l = j + k >> 1;
            if (sparsebooleanarray.keyAt(l) < i)
            {
                j = l + 1;
            } else
            {
                k = l;
            }
        } while (true);
    }

    private void invalidateFloatView()
    {
        mFloatViewInvalidated = true;
    }

    private void measureFloatView()
    {
        if (mFloatView != null)
        {
            measureItem(mFloatView);
            mFloatViewHeight = mFloatView.getMeasuredHeight();
            mFloatViewHeightHalf = mFloatViewHeight / 2;
        }
    }

    private void measureItem(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        Object obj = layoutparams;
        if (layoutparams == null)
        {
            obj = new android.widget.AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }
        int j = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec, getListPaddingLeft() + getListPaddingRight(), ((android.view.ViewGroup.LayoutParams) (obj)).width);
        int i;
        if (((android.view.ViewGroup.LayoutParams) (obj)).height > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(((android.view.ViewGroup.LayoutParams) (obj)).height, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(j, i);
    }

    private void printPosData()
    {
        Log.d("mobeta", (new StringBuilder("mSrcPos=")).append(mSrcPos).append(" mFirstExpPos=").append(mFirstExpPos).append(" mSecondExpPos=").append(mSecondExpPos).toString());
    }

    private static int rotate(int i, int j, int k, int l)
    {
        int i1 = l - k;
        j = i + j;
        if (j < k)
        {
            i = j + i1;
        } else
        {
            i = j;
            if (j >= l)
            {
                return j - i1;
            }
        }
        return i;
    }

    private void saveTouchCoords(MotionEvent motionevent)
    {
        int i = motionevent.getAction() & 0xff;
        if (i != 0)
        {
            mLastX = mX;
            mLastY = mY;
        }
        mX = (int)motionevent.getX();
        mY = (int)motionevent.getY();
        if (i == 0)
        {
            mLastX = mX;
            mLastY = mY;
        }
        mOffsetX = (int)motionevent.getRawX() - mX;
        mOffsetY = (int)motionevent.getRawY() - mY;
    }

    private void updateFloatView()
    {
        if (mFloatViewManager != null)
        {
            mTouchLoc.set(mX, mY);
            mFloatViewManager.onDragFloatView(mFloatView, mFloatLoc, mTouchLoc);
        }
        int i = mFloatLoc.x;
        int l = mFloatLoc.y;
        int j = getPaddingLeft();
        int k;
        int i1;
        int j1;
        if ((mDragFlags & 1) == 0 && i > j)
        {
            mFloatLoc.x = j;
        } else
        if ((mDragFlags & 2) == 0 && i < j)
        {
            mFloatLoc.x = j;
        }
        j = getHeaderViewsCount();
        k = getFooterViewsCount();
        i1 = getFirstVisiblePosition();
        j1 = getLastVisiblePosition();
        i = getPaddingTop();
        if (i1 < j)
        {
            i = getChildAt(j - i1 - 1).getBottom();
        }
        j = i;
        if ((mDragFlags & 8) == 0)
        {
            j = i;
            if (i1 <= mSrcPos)
            {
                j = Math.max(getChildAt(mSrcPos - i1).getTop(), i);
            }
        }
        i = getHeight() - getPaddingBottom();
        if (j1 >= getCount() - k - 1)
        {
            i = getChildAt(getCount() - k - 1 - i1).getBottom();
        }
        k = i;
        if ((mDragFlags & 4) == 0)
        {
            k = i;
            if (j1 >= mSrcPos)
            {
                k = Math.min(getChildAt(mSrcPos - i1).getBottom(), i);
            }
        }
        if (l < j)
        {
            mFloatLoc.y = j;
        } else
        if (mFloatViewHeight + l > k)
        {
            mFloatLoc.y = k - mFloatViewHeight;
        }
        mFloatViewMid = mFloatLoc.y + mFloatViewHeightHalf;
    }

    private boolean updatePositions()
    {
        int i;
        int j;
        int k;
        int i1;
        int j1;
        int i2;
        i = getFirstVisiblePosition();
        i1 = mFirstExpPos;
        View view1 = getChildAt(i1 - i);
        View view = view1;
        if (view1 == null)
        {
            i1 = i + getChildCount() / 2;
            view = getChildAt(i1 - i);
        }
        j = view.getTop();
        j1 = view.getHeight();
        i = getShuffleEdge(i1, j);
        k = i;
        i2 = getDividerHeight();
        if (mFloatViewMid >= i) goto _L2; else goto _L1
_L1:
        int l;
        l = j;
        j = i1;
_L5:
        float f;
        int k1;
        int l1;
        boolean flag;
        if (j >= 0)
        {
label0:
            {
                i1 = j - 1;
                i = getItemHeight(i1);
                if (i1 != 0)
                {
                    break label0;
                }
                i = l - i2 - i;
                j = i1;
            }
        }
_L4:
        i1 = getHeaderViewsCount();
        l1 = getFooterViewsCount();
        flag = false;
        j1 = mFirstExpPos;
        k1 = mSecondExpPos;
        f = mSlideFrac;
        if (mAnimate)
        {
            i2 = Math.abs(i - k);
            float f1;
            int j2;
            if (mFloatViewMid >= i)
            {
                l = i;
                i = k;
                k = l;
            }
            l = (int)(0.5F * mSlideRegionFrac * (float)i2);
            f1 = l;
            k += l;
            if (mFloatViewMid < k)
            {
                mFirstExpPos = j - 1;
                mSecondExpPos = j;
                mSlideFrac = (0.5F * (float)(k - mFloatViewMid)) / f1;
            } else
            if (mFloatViewMid < i - l)
            {
                mFirstExpPos = j;
                mSecondExpPos = j;
            } else
            {
                mFirstExpPos = j;
                mSecondExpPos = j + 1;
                mSlideFrac = 0.5F * (1.0F + (float)(i - mFloatViewMid) / f1);
            }
        } else
        {
            mFirstExpPos = j;
            mSecondExpPos = j;
        }
        if (mFirstExpPos < i1)
        {
            j = i1;
            mFirstExpPos = j;
            mSecondExpPos = j;
        } else
        if (mSecondExpPos >= getCount() - l1)
        {
            j = getCount() - l1 - 1;
            mFirstExpPos = j;
            mSecondExpPos = j;
        }
        if (mFirstExpPos != j1 || mSecondExpPos != k1 || mSlideFrac != f)
        {
            flag = true;
        }
        if (j != mFloatPos)
        {
            if (mDragListener != null)
            {
                mDragListener.drag(mFloatPos - i1, j - i1);
            }
            mFloatPos = j;
            flag = true;
        }
        return flag;
        j1 = l - (i + i2);
        l = getShuffleEdge(i1, j1);
        i = l;
        j = i1;
        if (mFloatViewMid >= l) goto _L4; else goto _L3
_L3:
        k = l;
        i = l;
        j = i1;
        l = j1;
          goto _L5
_L2:
        j2 = getCount();
        l = k;
        k1 = j;
_L7:
        j = i1;
        k = l;
        if (i1 < j2)
        {
label1:
            {
                if (i1 != j2 - 1)
                {
                    break label1;
                }
                i = k1 + i2 + j1;
                j = i1;
                k = l;
            }
        }
          goto _L4
        k1 += i2 + j1;
        l1 = getItemHeight(i1 + 1);
        j1 = getShuffleEdge(i1 + 1, k1);
        i = j1;
        j = i1;
        k = l;
        if (mFloatViewMid < j1) goto _L4; else goto _L6
_L6:
        l = j1;
        i1++;
        i = j1;
        j1 = l1;
          goto _L7
    }

    private void updateScrollStarts()
    {
        int i = getPaddingTop();
        int j = getHeight() - i - getPaddingBottom();
        float f = j;
        mUpScrollStartYF = (float)i + mDragUpScrollStartFrac * f;
        mDownScrollStartYF = (float)i + (1.0F - mDragDownScrollStartFrac) * f;
        mUpScrollStartY = (int)mUpScrollStartYF;
        mDownScrollStartY = (int)mDownScrollStartYF;
        mDragUpScrollHeight = mUpScrollStartYF - (float)i;
        mDragDownScrollHeight = (float)(i + j) - mDownScrollStartYF;
    }

    public void cancelDrag()
    {
label0:
        {
            if (mDragState == 4)
            {
                mDragScroller.stopScrolling(true);
                destroyFloatView();
                clearPositions();
                adjustAllItems();
                if (!mInTouchEvent)
                {
                    break label0;
                }
                mDragState = 3;
            }
            return;
        }
        mDragState = 0;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (mDragState != 0)
        {
            if (mFirstExpPos != mSrcPos)
            {
                drawDivider(mFirstExpPos, canvas);
            }
            if (mSecondExpPos != mFirstExpPos && mSecondExpPos != mSrcPos)
            {
                drawDivider(mSecondExpPos, canvas);
            }
        }
        if (mFloatView != null)
        {
            int k = mFloatView.getWidth();
            int l = mFloatView.getHeight();
            int j = mFloatLoc.x;
            int i1 = getWidth();
            int i = j;
            if (j < 0)
            {
                i = -j;
            }
            float f;
            if (i < i1)
            {
                f = (float)(i1 - i) / (float)i1;
                f *= f;
            } else
            {
                f = 0.0F;
            }
            i = (int)(255F * mCurrFloatAlpha * f);
            canvas.save();
            canvas.translate(mFloatLoc.x, mFloatLoc.y);
            canvas.clipRect(0, 0, k, l);
            canvas.saveLayerAlpha(0.0F, 0.0F, k, l, i, 31);
            mFloatView.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    public float getFloatAlpha()
    {
        return mCurrFloatAlpha;
    }

    public ListAdapter getInputAdapter()
    {
        if (mAdapterWrapper == null)
        {
            return null;
        } else
        {
            return mAdapterWrapper.getAdapter();
        }
    }

    public boolean isDragEnabled()
    {
        return mDragEnabled;
    }

    protected void layoutChildren()
    {
        super.layoutChildren();
        if (mFloatView != null)
        {
            if (mFloatView.isLayoutRequested() && !mFloatViewOnMeasured)
            {
                measureFloatView();
            }
            mFloatView.layout(0, 0, mFloatView.getMeasuredWidth(), mFloatView.getMeasuredHeight());
            mFloatViewOnMeasured = false;
        }
    }

    public boolean listViewIntercepted()
    {
        return mListViewIntercepted;
    }

    public void moveCheckState(int i, int j)
    {
        int ai[];
        int ai1[];
        int k;
        int l;
        int i1;
        SparseBooleanArray sparsebooleanarray = getCheckedItemPositions();
        k = i;
        l = j;
        if (j < i)
        {
            k = j;
            l = i;
        }
        i1 = l + 1;
        ai = new int[sparsebooleanarray.size()];
        ai1 = new int[sparsebooleanarray.size()];
        l = buildRunList(sparsebooleanarray, k, i1, ai, ai1);
        if (l != 1 || ai[0] != ai1[0]) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
        while (i != l) 
        {
            setItemChecked(rotate(ai[i], -1, k, i1), true);
            setItemChecked(rotate(ai1[i], -1, k, i1), false);
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        i = 0;
        while (i != l) 
        {
            setItemChecked(ai[i], false);
            setItemChecked(ai1[i], true);
            i++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void moveItem(int i, int j)
    {
        if (mDropListener != null)
        {
            int k = getInputAdapter().getCount();
            if (i >= 0 && i < k && j >= 0 && j < k)
            {
                mDropListener.drop(i, j);
            }
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 1 3: default 40
    //                   1 61
    //                   2 82
    //                   3 42;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L4:
        if (mDragState == 4)
        {
            cancelDrag();
        }
        doActionUpOrCancel();
        continue; /* Loop/switch isn't completed */
_L2:
        if (mDragState == 4)
        {
            stopDrag(false);
        }
        doActionUpOrCancel();
        continue; /* Loop/switch isn't completed */
_L3:
        continueDrag((int)motionevent.getX(), (int)motionevent.getY());
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mTrackDragSort)
        {
            mDragSortTracker.appendState();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (mDragEnabled) goto _L2; else goto _L1
_L1:
        boolean flag1 = super.onInterceptTouchEvent(motionevent);
_L6:
        return flag1;
_L2:
        int i;
        boolean flag;
        saveTouchCoords(motionevent);
        mLastCallWasIntercept = true;
        i = motionevent.getAction() & 0xff;
        if (i == 0)
        {
            if (mDragState != 0)
            {
                mIgnoreTouchEvent = true;
                return true;
            }
            mInTouchEvent = true;
        }
        flag = false;
        if (mFloatView == null) goto _L4; else goto _L3
_L3:
        flag = true;
_L8:
        if (i == 1)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        if (i != 3) goto _L6; else goto _L5
_L5:
        mInTouchEvent = false;
        return flag;
_L4:
        if (super.onInterceptTouchEvent(motionevent))
        {
            mListViewIntercepted = true;
            flag = true;
        }
        switch (i)
        {
        case 2: // '\002'
        default:
            if (flag)
            {
                mCancelMethod = 1;
            } else
            {
                mCancelMethod = 2;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            doActionUpOrCancel();
            break;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (mFloatView != null)
        {
            if (mFloatView.isLayoutRequested())
            {
                measureFloatView();
            }
            mFloatViewOnMeasured = true;
        }
        mWidthMeasureSpec = i;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        updateScrollStarts();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!mIgnoreTouchEvent) goto _L2; else goto _L1
_L1:
        boolean flag1;
        mIgnoreTouchEvent = false;
        flag1 = false;
_L4:
        return flag1;
_L2:
        if (!mDragEnabled)
        {
            return super.onTouchEvent(motionevent);
        }
        flag1 = false;
        boolean flag = mLastCallWasIntercept;
        mLastCallWasIntercept = false;
        if (!flag)
        {
            saveTouchCoords(motionevent);
        }
        if (mDragState == 4)
        {
            onDragTouchEvent(motionevent);
            return true;
        }
        flag = flag1;
        if (mDragState == 0)
        {
            flag = flag1;
            if (super.onTouchEvent(motionevent))
            {
                flag = true;
            }
        }
        switch (motionevent.getAction() & 0xff)
        {
        case 2: // '\002'
        default:
            flag1 = flag;
            if (flag)
            {
                mCancelMethod = 1;
                return flag;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            doActionUpOrCancel();
            return flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void removeCheckState(int i)
    {
        SparseBooleanArray sparsebooleanarray = getCheckedItemPositions();
        if (sparsebooleanarray.size() != 0)
        {
            int ai[] = new int[sparsebooleanarray.size()];
            int ai1[] = new int[sparsebooleanarray.size()];
            int k = sparsebooleanarray.keyAt(sparsebooleanarray.size() - 1) + 1;
            int l = buildRunList(sparsebooleanarray, i, k, ai, ai1);
            int j = 0;
            while (j != l) 
            {
                if (ai[j] != i && (ai1[j] >= ai[j] || ai1[j] <= i))
                {
                    setItemChecked(rotate(ai[j], -1, i, k), true);
                }
                setItemChecked(rotate(ai1[j], -1, i, k), false);
                j++;
            }
        }
    }

    public void removeItem(int i)
    {
        mUseRemoveVelocity = false;
        removeItem(i, 0.0F);
    }

    public void removeItem(int i, float f)
    {
        if (mDragState != 0 && mDragState != 4) goto _L2; else goto _L1
_L1:
        if (mDragState == 0)
        {
            mSrcPos = getHeaderViewsCount() + i;
            mFirstExpPos = mSrcPos;
            mSecondExpPos = mSrcPos;
            mFloatPos = mSrcPos;
            View view = getChildAt(mSrcPos - getFirstVisiblePosition());
            if (view != null)
            {
                view.setVisibility(4);
            }
        }
        mDragState = 1;
        mRemoveVelocityX = f;
        if (!mInTouchEvent) goto _L4; else goto _L3
_L3:
        mCancelMethod;
        JVM INSTR tableswitch 1 2: default 124
    //                   1 139
    //                   2 151;
           goto _L4 _L5 _L6
_L4:
        if (mRemoveAnimator == null)
        {
            break; /* Loop/switch isn't completed */
        }
        mRemoveAnimator.start();
_L2:
        return;
_L5:
        super.onTouchEvent(mCancelEvent);
        continue; /* Loop/switch isn't completed */
_L6:
        super.onInterceptTouchEvent(mCancelEvent);
        if (true) goto _L4; else goto _L7
_L7:
        doRemoveItem(i);
        return;
    }

    public void requestLayout()
    {
        if (!mBlockLayoutRequests)
        {
            super.requestLayout();
        }
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (listadapter != null)
        {
            mAdapterWrapper = new AdapterWrapper(listadapter);
            listadapter.registerDataSetObserver(mObserver);
            if (listadapter instanceof DropListener)
            {
                setDropListener((DropListener)listadapter);
            }
            if (listadapter instanceof DragListener)
            {
                setDragListener((DragListener)listadapter);
            }
            if (listadapter instanceof RemoveListener)
            {
                setRemoveListener((RemoveListener)listadapter);
            }
        } else
        {
            mAdapterWrapper = null;
        }
        super.setAdapter(mAdapterWrapper);
    }

    public void setDragEnabled(boolean flag)
    {
        mDragEnabled = flag;
    }

    public void setDragListener(DragListener draglistener)
    {
        mDragListener = draglistener;
    }

    public void setDragScrollProfile(DragScrollProfile dragscrollprofile)
    {
        if (dragscrollprofile != null)
        {
            mScrollProfile = dragscrollprofile;
        }
    }

    public void setDragScrollStart(float f)
    {
        setDragScrollStarts(f, f);
    }

    public void setDragScrollStarts(float f, float f1)
    {
        if (f1 > 0.5F)
        {
            mDragDownScrollStartFrac = 0.5F;
        } else
        {
            mDragDownScrollStartFrac = f1;
        }
        if (f > 0.5F)
        {
            mDragUpScrollStartFrac = 0.5F;
        } else
        {
            mDragUpScrollStartFrac = f;
        }
        if (getHeight() != 0)
        {
            updateScrollStarts();
        }
    }

    public void setDragSortListener(DragSortListener dragsortlistener)
    {
        setDropListener(dragsortlistener);
        setDragListener(dragsortlistener);
        setRemoveListener(dragsortlistener);
    }

    public void setDropListener(DropListener droplistener)
    {
        mDropListener = droplistener;
    }

    public void setFloatAlpha(float f)
    {
        mCurrFloatAlpha = f;
    }

    public void setFloatViewManager(FloatViewManager floatviewmanager)
    {
        mFloatViewManager = floatviewmanager;
    }

    public void setMaxScrollSpeed(float f)
    {
        mMaxScrollSpeed = f;
    }

    public void setRemoveListener(RemoveListener removelistener)
    {
        mRemoveListener = removelistener;
    }

    public boolean startDrag(int i, int j, int k, int l)
    {
        View view;
        if (mInTouchEvent && mFloatViewManager != null)
        {
            if ((view = mFloatViewManager.onCreateFloatView(i)) != null)
            {
                return startDrag(i, view, j, k, l);
            }
        }
        return false;
    }

    public boolean startDrag(int i, View view, int j, int k, int l)
    {
        boolean flag = true;
        if (mDragState == 0 && mInTouchEvent && mFloatView == null && view != null && mDragEnabled) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if (getParent() != null)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        i += getHeaderViewsCount();
        mFirstExpPos = i;
        mSecondExpPos = i;
        mSrcPos = i;
        mFloatPos = i;
        mDragState = 4;
        mDragFlags = 0;
        mDragFlags = mDragFlags | j;
        mFloatView = view;
        measureFloatView();
        mDragDeltaX = k;
        mDragDeltaY = l;
        mDragStartY = mY;
        mFloatLoc.x = mX - mDragDeltaX;
        mFloatLoc.y = mY - mDragDeltaY;
        view = getChildAt(mSrcPos - getFirstVisiblePosition());
        if (view != null)
        {
            view.setVisibility(4);
        }
        if (mTrackDragSort)
        {
            mDragSortTracker.startTracking();
        }
        switch (mCancelMethod)
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_260;
_L5:
        requestLayout();
        if (mLiftAnimator != null)
        {
            mLiftAnimator.start();
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        super.onTouchEvent(mCancelEvent);
          goto _L5
        super.onInterceptTouchEvent(mCancelEvent);
          goto _L5
    }

    public boolean stopDrag(boolean flag)
    {
        mUseRemoveVelocity = false;
        return stopDrag(flag, 0.0F);
    }

    public boolean stopDrag(boolean flag, float f)
    {
        if (mFloatView != null)
        {
            mDragScroller.stopScrolling(true);
            if (flag)
            {
                removeItem(mSrcPos - getHeaderViewsCount(), f);
            } else
            if (mDropAnimator != null)
            {
                mDropAnimator.start();
            } else
            {
                dropFloatView();
            }
            if (mTrackDragSort)
            {
                mDragSortTracker.stopTracking();
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean stopDragWithVelocity(boolean flag, float f)
    {
        mUseRemoveVelocity = true;
        return stopDrag(flag, f);
    }




































    // Unreferenced inner class com/mobeta/android/dslv/DragSortListView$AdapterWrapper$1

/* anonymous class */
    class AdapterWrapper._cls1 extends DataSetObserver
    {

        final AdapterWrapper this$1;

        public void onChanged()
        {
            notifyDataSetChanged();
        }

        public void onInvalidated()
        {
            notifyDataSetInvalidated();
        }

            
            {
                this$1 = AdapterWrapper.this;
                super();
            }
    }

}

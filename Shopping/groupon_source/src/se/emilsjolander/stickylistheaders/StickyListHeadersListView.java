// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;

// Referenced classes of package se.emilsjolander.stickylistheaders:
//            WrapperViewList, AdapterWrapper, WrapperView, SectionIndexerAdapterWrapper, 
//            StickyListHeadersAdapter

public class StickyListHeadersListView extends FrameLayout
{
    private class AdapterWrapperDataSetObserver extends DataSetObserver
    {

        final StickyListHeadersListView this$0;

        public void onChanged()
        {
            clearHeader();
        }

        public void onInvalidated()
        {
            clearHeader();
        }

        private AdapterWrapperDataSetObserver()
        {
            this$0 = StickyListHeadersListView.this;
            super();
        }

    }

    private class AdapterWrapperHeaderClickHandler
        implements AdapterWrapper.OnHeaderClickListener
    {

        final StickyListHeadersListView this$0;

        public void onHeaderClick(View view, int i, long l)
        {
            mOnHeaderClickListener.onHeaderClick(StickyListHeadersListView.this, view, i, l, false);
        }

        private AdapterWrapperHeaderClickHandler()
        {
            this$0 = StickyListHeadersListView.this;
            super();
        }

    }

    public static interface OnHeaderClickListener
    {

        public abstract void onHeaderClick(StickyListHeadersListView stickylistheaderslistview, View view, int i, long l, boolean flag);
    }

    public static interface OnStickyHeaderChangedListener
    {

        public abstract void onStickyHeaderChanged(StickyListHeadersListView stickylistheaderslistview, View view, int i, long l);
    }

    public static interface OnStickyHeaderOffsetChangedListener
    {

        public abstract void onStickyHeaderOffsetChanged(StickyListHeadersListView stickylistheaderslistview, View view, int i);
    }

    private class WrapperListScrollListener
        implements android.widget.AbsListView.OnScrollListener
    {

        final StickyListHeadersListView this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
            if (mOnScrollListenerDelegate != null)
            {
                mOnScrollListenerDelegate.onScroll(abslistview, i, j, k);
            }
            updateOrClearHeader(mList.getFixedFirstVisibleItem());
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            if (mOnScrollListenerDelegate != null)
            {
                mOnScrollListenerDelegate.onScrollStateChanged(abslistview, i);
            }
        }

        private WrapperListScrollListener()
        {
            this$0 = StickyListHeadersListView.this;
            super();
        }

    }

    private class WrapperViewListLifeCycleListener
        implements WrapperViewList.LifeCycleListener
    {

        final StickyListHeadersListView this$0;

        public void onDispatchDrawOccurred(Canvas canvas)
        {
label0:
            {
                if (android.os.Build.VERSION.SDK_INT < 8)
                {
                    updateOrClearHeader(mList.getFixedFirstVisibleItem());
                }
                if (mHeader != null)
                {
                    if (!mClippingToPadding)
                    {
                        break label0;
                    }
                    canvas.save();
                    canvas.clipRect(0, mPaddingTop, getRight(), getBottom());
                    drawChild(canvas, mHeader, 0L);
                    canvas.restore();
                }
                return;
            }
            drawChild(canvas, mHeader, 0L);
        }

        private WrapperViewListLifeCycleListener()
        {
            this$0 = StickyListHeadersListView.this;
            super();
        }

    }


    private AdapterWrapper mAdapter;
    private boolean mAreHeadersSticky;
    private boolean mClippingToPadding;
    private AdapterWrapperDataSetObserver mDataSetObserver;
    private Drawable mDivider;
    private int mDividerHeight;
    private float mDownY;
    private View mHeader;
    private Long mHeaderId;
    private Integer mHeaderOffset;
    private boolean mHeaderOwnsTouch;
    private Integer mHeaderPosition;
    private boolean mIsDrawingListUnderStickyHeader;
    private WrapperViewList mList;
    private OnHeaderClickListener mOnHeaderClickListener;
    private android.widget.AbsListView.OnScrollListener mOnScrollListenerDelegate;
    private OnStickyHeaderChangedListener mOnStickyHeaderChangedListener;
    private OnStickyHeaderOffsetChangedListener mOnStickyHeaderOffsetChangedListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mStickyHeaderTopOffset;
    private float mTouchSlop;

    public StickyListHeadersListView(Context context)
    {
        this(context, null);
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, R.attr.stickyListHeadersListViewStyle);
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeset, int i)
    {
        boolean flag1;
        flag1 = true;
        super(context, attributeset, i);
        mAreHeadersSticky = true;
        mClippingToPadding = true;
        mIsDrawingListUnderStickyHeader = true;
        mStickyHeaderTopOffset = 0;
        mPaddingLeft = 0;
        mPaddingTop = 0;
        mPaddingRight = 0;
        mPaddingBottom = 0;
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        mList = new WrapperViewList(context);
        mDivider = mList.getDivider();
        mDividerHeight = mList.getDividerHeight();
        mList.setDivider(null);
        mList.setDividerHeight(0);
        if (attributeset == null) goto _L2; else goto _L1
_L1:
        context = context.getTheme().obtainStyledAttributes(attributeset, R.styleable.StickyListHeadersListView, i, 0);
        i = context.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_padding, 0);
        mPaddingLeft = context.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingLeft, i);
        mPaddingTop = context.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingTop, i);
        mPaddingRight = context.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingRight, i);
        mPaddingBottom = context.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingBottom, i);
        setPadding(mPaddingLeft, mPaddingTop, mPaddingRight, mPaddingBottom);
        mClippingToPadding = context.getBoolean(R.styleable.StickyListHeadersListView_android_clipToPadding, true);
        super.setClipToPadding(true);
        mList.setClipToPadding(mClippingToPadding);
        i = context.getInt(R.styleable.StickyListHeadersListView_android_scrollbars, 512);
        attributeset = mList;
        boolean flag;
        if ((i & 0x200) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        attributeset.setVerticalScrollBarEnabled(flag);
        attributeset = mList;
        if ((i & 0x100) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        attributeset.setHorizontalScrollBarEnabled(flag);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            mList.setOverScrollMode(context.getInt(R.styleable.StickyListHeadersListView_android_overScrollMode, 0));
        }
        mList.setFadingEdgeLength(context.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_fadingEdgeLength, mList.getVerticalFadingEdgeLength()));
        i = context.getInt(R.styleable.StickyListHeadersListView_android_requiresFadingEdge, 0);
        if (i != 4096) goto _L4; else goto _L3
_L3:
        mList.setVerticalFadingEdgeEnabled(false);
        mList.setHorizontalFadingEdgeEnabled(true);
_L5:
        mList.setCacheColorHint(context.getColor(R.styleable.StickyListHeadersListView_android_cacheColorHint, mList.getCacheColorHint()));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mList.setChoiceMode(context.getInt(R.styleable.StickyListHeadersListView_android_choiceMode, mList.getChoiceMode()));
        }
        mList.setDrawSelectorOnTop(context.getBoolean(R.styleable.StickyListHeadersListView_android_drawSelectorOnTop, false));
        mList.setFastScrollEnabled(context.getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollEnabled, mList.isFastScrollEnabled()));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mList.setFastScrollAlwaysVisible(context.getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollAlwaysVisible, mList.isFastScrollAlwaysVisible()));
        }
        mList.setScrollBarStyle(context.getInt(R.styleable.StickyListHeadersListView_android_scrollbarStyle, 0));
        if (context.hasValue(R.styleable.StickyListHeadersListView_android_listSelector))
        {
            mList.setSelector(context.getDrawable(R.styleable.StickyListHeadersListView_android_listSelector));
        }
        mList.setScrollingCacheEnabled(context.getBoolean(R.styleable.StickyListHeadersListView_android_scrollingCache, mList.isScrollingCacheEnabled()));
        if (context.hasValue(R.styleable.StickyListHeadersListView_android_divider))
        {
            mDivider = context.getDrawable(R.styleable.StickyListHeadersListView_android_divider);
        }
        mList.setStackFromBottom(context.getBoolean(R.styleable.StickyListHeadersListView_android_stackFromBottom, false));
        mDividerHeight = context.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_dividerHeight, mDividerHeight);
        mList.setTranscriptMode(context.getInt(R.styleable.StickyListHeadersListView_android_transcriptMode, 0));
        mAreHeadersSticky = context.getBoolean(R.styleable.StickyListHeadersListView_hasStickyHeaders, true);
        mIsDrawingListUnderStickyHeader = context.getBoolean(R.styleable.StickyListHeadersListView_isDrawingListUnderStickyHeader, true);
        context.recycle();
_L2:
        mList.setLifeCycleListener(new WrapperViewListLifeCycleListener());
        mList.setOnScrollListener(new WrapperListScrollListener());
        addView(mList);
        return;
_L4:
        if (i != 8192)
        {
            break MISSING_BLOCK_LABEL_725;
        }
        mList.setVerticalFadingEdgeEnabled(true);
        mList.setHorizontalFadingEdgeEnabled(false);
          goto _L5
        attributeset;
        context.recycle();
        throw attributeset;
        mList.setVerticalFadingEdgeEnabled(false);
        mList.setHorizontalFadingEdgeEnabled(false);
          goto _L5
    }

    private void clearHeader()
    {
        if (mHeader != null)
        {
            removeView(mHeader);
            mHeader = null;
            mHeaderId = null;
            mHeaderPosition = null;
            mHeaderOffset = null;
            mList.setTopClippingLength(0);
            updateHeaderVisibilities();
        }
    }

    private void ensureHeaderHasCorrectLayoutParams(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if (layoutparams == null)
        {
            view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        } else
        if (layoutparams.height == -1 || layoutparams.width == -2)
        {
            layoutparams.height = -2;
            layoutparams.width = -1;
            view.setLayoutParams(layoutparams);
            return;
        }
    }

    private boolean isStartOfSection(int i)
    {
        return i == 0 || mAdapter.getHeaderId(i) != mAdapter.getHeaderId(i - 1);
    }

    private void measureHeader(View view)
    {
        if (view != null)
        {
            measureChild(view, android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - mPaddingLeft - mPaddingRight, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    private boolean requireSdkVersion(int i)
    {
        if (android.os.Build.VERSION.SDK_INT < i)
        {
            Log.e("StickyListHeaders", (new StringBuilder()).append("Api lvl must be at least ").append(i).append(" to call this method").toString());
            return false;
        } else
        {
            return true;
        }
    }

    private void setHeaderOffet(int i)
    {
        if (mHeaderOffset == null || mHeaderOffset.intValue() != i)
        {
            mHeaderOffset = Integer.valueOf(i);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                mHeader.setTranslationY(mHeaderOffset.intValue());
            } else
            {
                android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)mHeader.getLayoutParams();
                marginlayoutparams.topMargin = mHeaderOffset.intValue();
                mHeader.setLayoutParams(marginlayoutparams);
            }
            if (mOnStickyHeaderOffsetChangedListener != null)
            {
                mOnStickyHeaderOffsetChangedListener.onStickyHeaderOffsetChanged(this, mHeader, -mHeaderOffset.intValue());
            }
        }
    }

    private int stickyHeaderTop()
    {
        int j = mStickyHeaderTopOffset;
        int i;
        if (mClippingToPadding)
        {
            i = mPaddingTop;
        } else
        {
            i = 0;
        }
        return i + j;
    }

    private void swapHeader(View view)
    {
        if (mHeader != null)
        {
            removeView(mHeader);
        }
        mHeader = view;
        addView(mHeader);
        if (mOnHeaderClickListener != null)
        {
            mHeader.setOnClickListener(new android.view.View.OnClickListener() {

                final StickyListHeadersListView this$0;

                public void onClick(View view1)
                {
                    mOnHeaderClickListener.onHeaderClick(StickyListHeadersListView.this, mHeader, mHeaderPosition.intValue(), mHeaderId.longValue(), true);
                }

            
            {
                this$0 = StickyListHeadersListView.this;
                super();
            }
            });
        }
        mHeader.setClickable(true);
    }

    private void updateHeader(int i)
    {
        if (mHeaderPosition == null || mHeaderPosition.intValue() != i)
        {
            mHeaderPosition = Integer.valueOf(i);
            long l = mAdapter.getHeaderId(i);
            if (mHeaderId == null || mHeaderId.longValue() != l)
            {
                mHeaderId = Long.valueOf(l);
                View view = mAdapter.getHeaderView(mHeaderPosition.intValue(), mHeader, this);
                if (mHeader != view)
                {
                    if (view == null)
                    {
                        throw new NullPointerException("header may not be null");
                    }
                    swapHeader(view);
                }
                ensureHeaderHasCorrectLayoutParams(mHeader);
                measureHeader(mHeader);
                if (mOnStickyHeaderChangedListener != null)
                {
                    mOnStickyHeaderChangedListener.onStickyHeaderChanged(this, mHeader, i, mHeaderId.longValue());
                }
                mHeaderOffset = null;
            }
        }
        int k = stickyHeaderTop();
        i = 0;
        do
        {
label0:
            {
                int j = k;
                if (i < mList.getChildCount())
                {
                    View view1 = mList.getChildAt(i);
                    boolean flag;
                    if ((view1 instanceof WrapperView) && ((WrapperView)view1).hasHeader())
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    flag = mList.containsFooterView(view1);
                    if (view1.getTop() < stickyHeaderTop() || j == 0 && !flag)
                    {
                        break label0;
                    }
                    j = Math.min(view1.getTop() - mHeader.getMeasuredHeight(), k);
                }
                setHeaderOffet(j);
                if (!mIsDrawingListUnderStickyHeader)
                {
                    mList.setTopClippingLength(mHeader.getMeasuredHeight() + mHeaderOffset.intValue());
                }
                updateHeaderVisibilities();
                return;
            }
            i++;
        } while (true);
    }

    private void updateHeaderVisibilities()
    {
        int j = stickyHeaderTop();
        int k = mList.getChildCount();
        int i = 0;
        while (i < k) 
        {
            Object obj = mList.getChildAt(i);
            if (obj instanceof WrapperView)
            {
                obj = (WrapperView)obj;
                if (((WrapperView) (obj)).hasHeader())
                {
                    View view = ((WrapperView) (obj)).mHeader;
                    if (((WrapperView) (obj)).getTop() < j)
                    {
                        if (view.getVisibility() != 4)
                        {
                            view.setVisibility(4);
                        }
                    } else
                    if (view.getVisibility() != 0)
                    {
                        view.setVisibility(0);
                    }
                }
            }
            i++;
        }
    }

    private void updateOrClearHeader(int i)
    {
label0:
        {
            boolean flag2 = false;
            int j;
            if (mAdapter == null)
            {
                j = 0;
            } else
            {
                j = mAdapter.getCount();
            }
            if (j == 0 || !mAreHeadersSticky)
            {
                return;
            }
            int k = i - mList.getHeaderViewsCount();
            i = k;
            if (mList.getChildCount() > 0)
            {
                i = k;
                if (mList.getChildAt(0).getBottom() < stickyHeaderTop())
                {
                    i = k + 1;
                }
            }
            boolean flag;
            boolean flag1;
            if (mList.getChildCount() != 0)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (k && mList.getFirstVisiblePosition() == 0 && mList.getChildAt(0).getTop() >= stickyHeaderTop())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (i <= j - 1)
            {
                flag = flag2;
                if (i >= 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
        if (!k || flag || flag1)
        {
            clearHeader();
            return;
        } else
        {
            updateHeader(i);
            return;
        }
    }

    public void addHeaderView(View view)
    {
        mList.addHeaderView(view);
    }

    public void addHeaderView(View view, Object obj, boolean flag)
    {
        mList.addHeaderView(view, obj, flag);
    }

    public boolean areHeadersSticky()
    {
        return mAreHeadersSticky;
    }

    public boolean canScrollVertically(int i)
    {
        return mList.canScrollVertically(i);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (mList.getVisibility() == 0 || mList.getAnimation() != null)
        {
            drawChild(canvas, mList, 0L);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if ((motionevent.getAction() & 0xff) == 0)
        {
            mDownY = motionevent.getY();
            boolean flag;
            if (mHeader != null && mDownY <= (float)(mHeader.getHeight() + mHeaderOffset.intValue()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mHeaderOwnsTouch = flag;
        }
        if (mHeaderOwnsTouch)
        {
            if (mHeader != null && Math.abs(mDownY - motionevent.getY()) <= mTouchSlop)
            {
                return mHeader.dispatchTouchEvent(motionevent);
            }
            if (mHeader != null)
            {
                MotionEvent motionevent1 = MotionEvent.obtain(motionevent);
                motionevent1.setAction(3);
                mHeader.dispatchTouchEvent(motionevent1);
                motionevent1.recycle();
            }
            motionevent = MotionEvent.obtain(motionevent.getDownTime(), motionevent.getEventTime(), motionevent.getAction(), motionevent.getX(), mDownY, motionevent.getMetaState());
            motionevent.setAction(0);
            boolean flag1 = mList.dispatchTouchEvent(motionevent);
            motionevent.recycle();
            mHeaderOwnsTouch = false;
            return flag1;
        } else
        {
            return mList.dispatchTouchEvent(motionevent);
        }
    }

    public StickyListHeadersAdapter getAdapter()
    {
        if (mAdapter == null)
        {
            return null;
        } else
        {
            return mAdapter.mDelegate;
        }
    }

    public boolean getAreHeadersSticky()
    {
        return areHeadersSticky();
    }

    public int getCheckedItemCount()
    {
        if (requireSdkVersion(11))
        {
            return mList.getCheckedItemCount();
        } else
        {
            return 0;
        }
    }

    public long[] getCheckedItemIds()
    {
        if (requireSdkVersion(8))
        {
            return mList.getCheckedItemIds();
        } else
        {
            return null;
        }
    }

    public int getCheckedItemPosition()
    {
        return mList.getCheckedItemPosition();
    }

    public SparseBooleanArray getCheckedItemPositions()
    {
        return mList.getCheckedItemPositions();
    }

    public int getCount()
    {
        return mList.getCount();
    }

    public Drawable getDivider()
    {
        return mDivider;
    }

    public int getDividerHeight()
    {
        return mDividerHeight;
    }

    public View getEmptyView()
    {
        return mList.getEmptyView();
    }

    public int getFirstVisiblePosition()
    {
        return mList.getFirstVisiblePosition();
    }

    public int getFooterViewsCount()
    {
        return mList.getFooterViewsCount();
    }

    public int getHeaderOverlap(int i)
    {
        int j = 0;
        if (!isStartOfSection(Math.max(0, i - getHeaderViewsCount())))
        {
            View view = mAdapter.getHeaderView(i, null, mList);
            if (view == null)
            {
                throw new NullPointerException("header may not be null");
            }
            ensureHeaderHasCorrectLayoutParams(view);
            measureHeader(view);
            j = view.getMeasuredHeight();
        }
        return j;
    }

    public int getHeaderViewsCount()
    {
        return mList.getHeaderViewsCount();
    }

    public Object getItemAtPosition(int i)
    {
        return mList.getItemAtPosition(i);
    }

    public int getLastVisiblePosition()
    {
        return mList.getLastVisiblePosition();
    }

    public int getListChildCount()
    {
        return mList.getChildCount();
    }

    public int getOverScrollMode()
    {
        if (requireSdkVersion(9))
        {
            return mList.getOverScrollMode();
        } else
        {
            return 0;
        }
    }

    public int getPaddingBottom()
    {
        return mPaddingBottom;
    }

    public int getPaddingLeft()
    {
        return mPaddingLeft;
    }

    public int getPaddingRight()
    {
        return mPaddingRight;
    }

    public int getPaddingTop()
    {
        return mPaddingTop;
    }

    public int getScrollBarStyle()
    {
        return mList.getScrollBarStyle();
    }

    public int getStickyHeaderTopOffset()
    {
        return mStickyHeaderTopOffset;
    }

    public ListView getWrappedList()
    {
        return mList;
    }

    public boolean isHorizontalScrollBarEnabled()
    {
        return mList.isHorizontalScrollBarEnabled();
    }

    public boolean isVerticalScrollBarEnabled()
    {
        return mList.isVerticalScrollBarEnabled();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        mList.layout(0, 0, mList.getMeasuredWidth(), getHeight());
        if (mHeader != null)
        {
            i = ((android.view.ViewGroup.MarginLayoutParams)mHeader.getLayoutParams()).topMargin;
            mHeader.layout(mPaddingLeft, i, mHeader.getMeasuredWidth() + mPaddingLeft, mHeader.getMeasuredHeight() + i);
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        measureHeader(mHeader);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        super.onRestoreInstanceState(android.view.View.BaseSavedState.EMPTY_STATE);
        mList.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState()
    {
        if (super.onSaveInstanceState() != android.view.View.BaseSavedState.EMPTY_STATE)
        {
            throw new IllegalStateException("Handling non empty state of parent class is not implemented");
        } else
        {
            return mList.onSaveInstanceState();
        }
    }

    public void removeHeaderView(View view)
    {
        mList.removeHeaderView(view);
    }

    public void setAdapter(StickyListHeadersAdapter stickylistheadersadapter)
    {
        if (stickylistheadersadapter == null)
        {
            if (mAdapter instanceof SectionIndexerAdapterWrapper)
            {
                ((SectionIndexerAdapterWrapper)mAdapter).mSectionIndexerDelegate = null;
            }
            if (mAdapter != null)
            {
                mAdapter.mDelegate = null;
            }
            mList.setAdapter(null);
            clearHeader();
            return;
        }
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }
        if (stickylistheadersadapter instanceof SectionIndexer)
        {
            mAdapter = new SectionIndexerAdapterWrapper(getContext(), stickylistheadersadapter);
        } else
        {
            mAdapter = new AdapterWrapper(getContext(), stickylistheadersadapter);
        }
        mDataSetObserver = new AdapterWrapperDataSetObserver();
        mAdapter.registerDataSetObserver(mDataSetObserver);
        if (mOnHeaderClickListener != null)
        {
            mAdapter.setOnHeaderClickListener(new AdapterWrapperHeaderClickHandler());
        } else
        {
            mAdapter.setOnHeaderClickListener(null);
        }
        mAdapter.setDivider(mDivider, mDividerHeight);
        mList.setAdapter(mAdapter);
        clearHeader();
    }

    public void setAreHeadersSticky(boolean flag)
    {
        mAreHeadersSticky = flag;
        if (!flag)
        {
            clearHeader();
        } else
        {
            updateOrClearHeader(mList.getFixedFirstVisibleItem());
        }
        mList.invalidate();
    }

    public void setBlockLayoutChildren(boolean flag)
    {
        mList.setBlockLayoutChildren(flag);
    }

    public void setChoiceMode(int i)
    {
        mList.setChoiceMode(i);
    }

    public void setClipToPadding(boolean flag)
    {
        if (mList != null)
        {
            mList.setClipToPadding(flag);
        }
        mClippingToPadding = flag;
    }

    public void setDivider(Drawable drawable)
    {
        mDivider = drawable;
        if (mAdapter != null)
        {
            mAdapter.setDivider(mDivider, mDividerHeight);
        }
    }

    public void setDividerHeight(int i)
    {
        mDividerHeight = i;
        if (mAdapter != null)
        {
            mAdapter.setDivider(mDivider, mDividerHeight);
        }
    }

    public void setDrawingListUnderStickyHeader(boolean flag)
    {
        mIsDrawingListUnderStickyHeader = flag;
        mList.setTopClippingLength(0);
    }

    public void setEmptyView(View view)
    {
        mList.setEmptyView(view);
    }

    public void setFastScrollAlwaysVisible(boolean flag)
    {
        if (requireSdkVersion(11))
        {
            mList.setFastScrollAlwaysVisible(flag);
        }
    }

    public void setFastScrollEnabled(boolean flag)
    {
        mList.setFastScrollEnabled(flag);
    }

    public void setHorizontalScrollBarEnabled(boolean flag)
    {
        mList.setHorizontalScrollBarEnabled(flag);
    }

    public void setMultiChoiceModeListener(android.widget.AbsListView.MultiChoiceModeListener multichoicemodelistener)
    {
        if (requireSdkVersion(11))
        {
            mList.setMultiChoiceModeListener(multichoicemodelistener);
        }
    }

    public void setOnCreateContextMenuListener(android.view.View.OnCreateContextMenuListener oncreatecontextmenulistener)
    {
        mList.setOnCreateContextMenuListener(oncreatecontextmenulistener);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onheaderclicklistener)
    {
label0:
        {
            mOnHeaderClickListener = onheaderclicklistener;
            if (mAdapter != null)
            {
                if (mOnHeaderClickListener == null)
                {
                    break label0;
                }
                mAdapter.setOnHeaderClickListener(new AdapterWrapperHeaderClickHandler());
                if (mHeader != null)
                {
                    mHeader.setOnClickListener(new android.view.View.OnClickListener() {

                        final StickyListHeadersListView this$0;

                        public void onClick(View view)
                        {
                            mOnHeaderClickListener.onHeaderClick(StickyListHeadersListView.this, mHeader, mHeaderPosition.intValue(), mHeaderId.longValue(), true);
                        }

            
            {
                this$0 = StickyListHeadersListView.this;
                super();
            }
                    });
                }
            }
            return;
        }
        mAdapter.setOnHeaderClickListener(null);
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        mList.setOnItemClickListener(onitemclicklistener);
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        mList.setOnItemLongClickListener(onitemlongclicklistener);
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        mOnScrollListenerDelegate = onscrolllistener;
    }

    public void setOnStickyHeaderChangedListener(OnStickyHeaderChangedListener onstickyheaderchangedlistener)
    {
        mOnStickyHeaderChangedListener = onstickyheaderchangedlistener;
    }

    public void setOnStickyHeaderOffsetChangedListener(OnStickyHeaderOffsetChangedListener onstickyheaderoffsetchangedlistener)
    {
        mOnStickyHeaderOffsetChangedListener = onstickyheaderoffsetchangedlistener;
    }

    public void setOnTouchListener(final android.view.View.OnTouchListener l)
    {
        if (l != null)
        {
            mList.setOnTouchListener(new android.view.View.OnTouchListener() {

                final StickyListHeadersListView this$0;
                final android.view.View.OnTouchListener val$l;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return l.onTouch(StickyListHeadersListView.this, motionevent);
                }

            
            {
                this$0 = StickyListHeadersListView.this;
                l = ontouchlistener;
                super();
            }
            });
            return;
        } else
        {
            mList.setOnTouchListener(null);
            return;
        }
    }

    public void setOverScrollMode(int i)
    {
        if (requireSdkVersion(9) && mList != null)
        {
            mList.setOverScrollMode(i);
        }
    }

    public void setPadding(int i, int j, int k, int l)
    {
        mPaddingLeft = i;
        mPaddingTop = j;
        mPaddingRight = k;
        mPaddingBottom = l;
        if (mList != null)
        {
            mList.setPadding(i, j, k, l);
        }
        super.setPadding(0, 0, 0, 0);
        requestLayout();
    }

    public void setScrollBarStyle(int i)
    {
        mList.setScrollBarStyle(i);
    }

    public void setSelection(int i)
    {
        setSelectionFromTop(i, 0);
    }

    public void setSelectionFromTop(int i, int j)
    {
        int l = 0;
        int k;
        if (mAdapter == null)
        {
            k = 0;
        } else
        {
            k = getHeaderOverlap(i);
        }
        if (!mClippingToPadding)
        {
            l = mPaddingTop;
        }
        mList.setSelectionFromTop(i, (j + k) - l);
    }

    public void setSelector(int i)
    {
        mList.setSelector(i);
    }

    public void setSelector(Drawable drawable)
    {
        mList.setSelector(drawable);
    }

    public void setStackFromBottom(boolean flag)
    {
        mList.setStackFromBottom(flag);
    }

    public void setStickyHeaderTopOffset(int i)
    {
        mStickyHeaderTopOffset = i;
        updateOrClearHeader(mList.getFixedFirstVisibleItem());
    }

    public void setTranscriptMode(int i)
    {
        mList.setTranscriptMode(i);
    }

    public void setVerticalScrollBarEnabled(boolean flag)
    {
        mList.setVerticalScrollBarEnabled(flag);
    }

    public boolean showContextMenu()
    {
        return mList.showContextMenu();
    }

    public void smoothScrollToPositionFromTop(int i, int j, int k)
    {
        int i1 = 0;
        if (requireSdkVersion(11))
        {
            int l;
            if (mAdapter == null)
            {
                l = 0;
            } else
            {
                l = getHeaderOverlap(i);
            }
            if (!mClippingToPadding)
            {
                i1 = mPaddingTop;
            }
            mList.smoothScrollToPositionFromTop(i, (j + l) - i1, k);
        }
    }












}

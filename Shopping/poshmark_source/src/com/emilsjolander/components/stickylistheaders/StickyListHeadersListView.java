// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.emilsjolander.components.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import java.lang.reflect.Field;
import java.util.ArrayList;

// Referenced classes of package com.emilsjolander.components.stickylistheaders:
//            WrapperView, AdapterWrapper, SectionIndexerAdapterWrapper, StickyListHeadersAdapter

public class StickyListHeadersListView extends ListView
{
    public static interface OnHeaderClickListener
    {

        public abstract void onHeaderClick(StickyListHeadersListView stickylistheaderslistview, View view, int i, long l, boolean flag);
    }


    private AdapterWrapper mAdapter;
    private AdapterWrapper.OnHeaderClickListener mAdapterHeaderClickListener = new AdapterWrapper.OnHeaderClickListener() {

        final StickyListHeadersListView this$0;

        public void onHeaderClick(View view, int j, long l)
        {
            if (mOnHeaderClickListener != null)
            {
                mOnHeaderClickListener.onHeaderClick(StickyListHeadersListView.this, view, j, l, false);
            }
        }

            
            {
                this$0 = StickyListHeadersListView.this;
                super();
            }
    };
    private boolean mAreHeadersSticky;
    private final Rect mClippingRect;
    private Boolean mClippingToPadding;
    private Long mCurrentHeaderId;
    private DataSetObserver mDataSetChangedObserver = new DataSetObserver() {

        final StickyListHeadersListView this$0;

        public void onChanged()
        {
            reset();
        }

        public void onInvalidated()
        {
            reset();
        }

            
            {
                this$0 = StickyListHeadersListView.this;
                super();
            }
    };
    private Drawable mDivider;
    private int mDividerHeight;
    private boolean mDrawingListUnderStickyHeader;
    private ArrayList mFooterViews;
    private View mHeader;
    private boolean mHeaderBeingPressed;
    private int mHeaderBottomPosition;
    private float mHeaderDownY;
    private Integer mHeaderPosition;
    private OnHeaderClickListener mOnHeaderClickListener;
    private android.widget.AbsListView.OnScrollListener mOnScrollListener = new android.widget.AbsListView.OnScrollListener() {

        final StickyListHeadersListView this$0;

        public void onScroll(AbsListView abslistview, int j, int k, int l)
        {
            if (mOnScrollListenerDelegate != null)
            {
                mOnScrollListenerDelegate.onScroll(abslistview, j, k, l);
            }
            if (android.os.Build.VERSION.SDK_INT >= 8)
            {
                scrollChanged(j);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int j)
        {
            if (mOnScrollListenerDelegate != null)
            {
                mOnScrollListenerDelegate.onScrollStateChanged(abslistview, j);
            }
        }

            
            {
                this$0 = StickyListHeadersListView.this;
                super();
            }
    };
    private android.widget.AbsListView.OnScrollListener mOnScrollListenerDelegate;
    private Field mSelectorPositionField;
    private Rect mSelectorRect;
    private ViewConfiguration mViewConfig;

    public StickyListHeadersListView(Context context)
    {
        this(context, null);
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010074);
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mAreHeadersSticky = true;
        mClippingRect = new Rect();
        mCurrentHeaderId = null;
        mHeaderDownY = -1F;
        mHeaderBeingPressed = false;
        mDrawingListUnderStickyHeader = false;
        mSelectorRect = new Rect();
        super.setOnScrollListener(mOnScrollListener);
        super.setDivider(null);
        super.setDividerHeight(0);
        mViewConfig = ViewConfiguration.get(context);
        if (mClippingToPadding == null)
        {
            mClippingToPadding = Boolean.valueOf(true);
        }
        try
        {
            context = android/widget/AbsListView.getDeclaredField("mSelectorRect");
            context.setAccessible(true);
            mSelectorRect = (Rect)context.get(this);
            mSelectorPositionField = android/widget/AbsListView.getDeclaredField("mSelectorPosition");
            mSelectorPositionField.setAccessible(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    private void drawStickyHeader(Canvas canvas)
    {
        int i = getHeaderHeight();
        int j = mHeaderBottomPosition - i;
        mClippingRect.left = getPaddingLeft();
        mClippingRect.right = getWidth() - getPaddingRight();
        mClippingRect.bottom = j + i;
        Rect rect = mClippingRect;
        if (mClippingToPadding.booleanValue())
        {
            i = getPaddingTop();
        } else
        {
            i = 0;
        }
        rect.top = i;
        canvas.save();
        canvas.clipRect(mClippingRect);
        canvas.translate(getPaddingLeft(), j);
        mHeader.draw(canvas);
        canvas.restore();
    }

    private int fixedFirstVisibleItem(int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return i;
        }
        int k = 0;
        do
        {
label0:
            {
                int j = i;
                if (k < getChildCount())
                {
                    if (getChildAt(k).getBottom() < 0)
                    {
                        break label0;
                    }
                    j = i + k;
                }
                i = j;
                if (!mClippingToPadding.booleanValue())
                {
                    i = j;
                    if (getPaddingTop() > 0)
                    {
                        i = j;
                        if (super.getChildAt(0).getTop() > 0)
                        {
                            i = j;
                            if (j > 0)
                            {
                                i = j - 1;
                            }
                        }
                    }
                }
                return i;
            }
            k++;
        } while (true);
    }

    private int getHeaderHeight()
    {
        if (mHeader == null)
        {
            return 0;
        } else
        {
            return mHeader.getMeasuredHeight();
        }
    }

    private int getSelectorPosition()
    {
        if (mSelectorPositionField == null)
        {
            for (int i = 0; i < getChildCount(); i++)
            {
                if (getChildAt(i).getBottom() == mSelectorRect.bottom)
                {
                    return fixedFirstVisibleItem(getFirstVisiblePosition()) + i;
                }
            }

            break MISSING_BLOCK_LABEL_69;
        }
        int j = mSelectorPositionField.getInt(this);
        return j;
        Object obj;
        obj;
        ((IllegalArgumentException) (obj)).printStackTrace();
_L2:
        return -1;
        obj;
        ((IllegalAccessException) (obj)).printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean isScrollBarOverlay()
    {
        int i = getScrollBarStyle();
        return i == 0 || i == 0x2000000;
    }

    private void measureHeader()
    {
        int j = getWidth();
        int k = getPaddingLeft();
        int l = getPaddingRight();
        android.view.ViewGroup.LayoutParams layoutparams;
        int i;
        if (isScrollBarOverlay())
        {
            i = 0;
        } else
        {
            i = getVerticalScrollbarWidth();
        }
        j = android.view.View.MeasureSpec.makeMeasureSpec(j - k - l - i, 0x40000000);
        layoutparams = mHeader.getLayoutParams();
        if (layoutparams != null && layoutparams.height > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        mHeader.measure(j, i);
        mHeader.layout(getPaddingLeft(), 0, getWidth() - getPaddingRight(), mHeader.getMeasuredHeight());
    }

    private void positionSelectorRect()
    {
        if (!mSelectorRect.isEmpty())
        {
            int i = getSelectorPosition();
            if (i >= 0)
            {
                Object obj = getChildAt(i - fixedFirstVisibleItem(getFirstVisiblePosition()));
                if (obj instanceof WrapperView)
                {
                    obj = (WrapperView)obj;
                    mSelectorRect.top = ((WrapperView) (obj)).getTop() + ((WrapperView) (obj)).mItemTop;
                }
            }
        }
    }

    private void reset()
    {
        mHeader = null;
        mCurrentHeaderId = null;
        mHeaderPosition = null;
        mHeaderBottomPosition = -1;
    }

    private void scrollChanged(int i)
    {
        View view;
        int j;
        boolean flag;
        int l;
        int l1;
        int i2;
        int j2;
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
        l1 = getHeaderViewsCount();
        i2 = fixedFirstVisibleItem(i) - l1;
        if (i2 < 0 || i2 > j - 1)
        {
            reset();
            updateHeaderVisibilities();
            invalidate();
            return;
        }
        if (mHeaderPosition == null || mHeaderPosition.intValue() != i2)
        {
            mHeaderPosition = Integer.valueOf(i2);
            mCurrentHeaderId = Long.valueOf(mAdapter.getHeaderId(i2));
            mHeader = mAdapter.getHeaderView(mHeaderPosition.intValue(), mHeader, this);
            measureHeader();
        }
        j2 = getChildCount();
        if (j2 == 0)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        view = null;
        l = 0x7fffffff;
        flag = false;
        j = 0;
_L3:
        View view1;
        View view2;
        int i1;
        int j1;
        int k1;
        if (j >= j2)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        view2 = super.getChildAt(j);
        if (mFooterViews != null && mFooterViews.contains(view2))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j1 = view2.getTop();
        if (mClippingToPadding.booleanValue())
        {
            i1 = getPaddingTop();
        } else
        {
            i1 = 0;
        }
        k1 = j1 - i1;
        if (k1 >= 0) goto _L2; else goto _L1
_L1:
        j1 = l;
        i1 = ((flag) ? 1 : 0);
        view1 = view;
_L8:
        j++;
        view = view1;
        flag = i1;
        l = j1;
          goto _L3
_L2:
        if (view == null || !flag && !((WrapperView)view).hasHeader()) goto _L5; else goto _L4
_L4:
        if (i != 0) goto _L7; else goto _L6
_L6:
        view1 = view;
        i1 = ((flag) ? 1 : 0);
        j1 = l;
        if (!((WrapperView)view2).hasHeader()) goto _L8; else goto _L7
_L7:
        view1 = view;
        i1 = ((flag) ? 1 : 0);
        j1 = l;
        if (k1 >= l) goto _L8; else goto _L5
_L5:
        view1 = view2;
        j1 = k1;
        i1 = i;
          goto _L8
        int k = getHeaderHeight();
        if (view != null && (flag || ((WrapperView)view).hasHeader()))
        {
            if (i2 == l1 && super.getChildAt(0).getTop() > 0 && !mClippingToPadding.booleanValue())
            {
                mHeaderBottomPosition = 0;
            } else
            {
                if (mClippingToPadding.booleanValue())
                {
                    i = getPaddingTop();
                } else
                {
                    i = 0;
                }
                mHeaderBottomPosition = Math.min(view.getTop(), k + i);
                if (mHeaderBottomPosition < i)
                {
                    i = k + i;
                } else
                {
                    i = mHeaderBottomPosition;
                }
                mHeaderBottomPosition = i;
            }
        } else
        {
            if (mClippingToPadding.booleanValue())
            {
                i = getPaddingTop();
            } else
            {
                i = 0;
            }
            mHeaderBottomPosition = i + k;
        }
        updateHeaderVisibilities();
        invalidate();
        return;
    }

    private void updateHeaderVisibilities()
    {
        int i;
        int j;
        int k;
        if (mClippingToPadding.booleanValue())
        {
            i = getPaddingTop();
        } else
        {
            i = 0;
        }
        k = getChildCount();
        j = 0;
        while (j < k) 
        {
            Object obj = super.getChildAt(j);
            if (!(obj instanceof WrapperView))
            {
                continue;
            }
            obj = (WrapperView)obj;
            if (((WrapperView) (obj)).hasHeader())
            {
                View view = ((WrapperView) (obj)).mHeader;
                if (((WrapperView) (obj)).getTop() < i)
                {
                    view.setVisibility(4);
                } else
                {
                    view.setVisibility(0);
                }
            }
            j++;
        }
    }

    private AdapterWrapper wrapAdapter(ListAdapter listadapter)
    {
        if (listadapter instanceof SectionIndexer)
        {
            listadapter = new SectionIndexerAdapterWrapper(getContext(), (StickyListHeadersAdapter)listadapter);
        } else
        {
            listadapter = new AdapterWrapper(getContext(), (StickyListHeadersAdapter)listadapter);
        }
        listadapter.setDivider(mDivider);
        listadapter.setDividerHeight(mDividerHeight);
        listadapter.registerDataSetObserver(mDataSetChangedObserver);
        listadapter.setOnHeaderClickListener(mAdapterHeaderClickListener);
        return listadapter;
    }

    public void addFooterView(View view)
    {
        super.addFooterView(view);
        if (mFooterViews == null)
        {
            mFooterViews = new ArrayList();
        }
        mFooterViews.add(view);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            scrollChanged(getFirstVisiblePosition());
        }
        positionSelectorRect();
        if (!mAreHeadersSticky || mHeader == null)
        {
            super.dispatchDraw(canvas);
            return;
        }
        if (!mDrawingListUnderStickyHeader)
        {
            mClippingRect.set(0, mHeaderBottomPosition, getWidth(), getHeight());
            canvas.save();
            canvas.clipRect(mClippingRect);
        }
        super.dispatchDraw(canvas);
        if (!mDrawingListUnderStickyHeader)
        {
            canvas.restore();
        }
        drawStickyHeader(canvas);
    }

    public boolean getAreHeadersSticky()
    {
        return mAreHeadersSticky;
    }

    public StickyListHeadersAdapter getWrappedAdapter()
    {
        if (mAdapter == null)
        {
            return null;
        } else
        {
            return mAdapter.mDelegate;
        }
    }

    public View getWrappedView(int i)
    {
        View view1 = getChildAt(i);
        View view = view1;
        if (view1 instanceof WrapperView)
        {
            view = ((WrapperView)view1).mItem;
        }
        return view;
    }

    public boolean isDrawingListUnderStickyHeader()
    {
        return mDrawingListUnderStickyHeader;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (flag)
        {
            reset();
            scrollChanged(getFirstVisiblePosition());
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i != 0 || motionevent.getY() > (float)mHeaderBottomPosition) goto _L2; else goto _L1
_L1:
        mHeaderDownY = motionevent.getY();
        mHeaderBeingPressed = true;
        mHeader.setPressed(true);
        mHeader.invalidate();
        invalidate(0, 0, getWidth(), mHeaderBottomPosition);
_L4:
        return true;
_L2:
        if (!mHeaderBeingPressed)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        if (Math.abs(motionevent.getY() - mHeaderDownY) >= (float)mViewConfig.getScaledTouchSlop())
        {
            break; /* Loop/switch isn't completed */
        }
        if (i == 1 || i == 3)
        {
            mHeaderDownY = -1F;
            mHeaderBeingPressed = false;
            mHeader.setPressed(false);
            mHeader.invalidate();
            invalidate(0, 0, getWidth(), mHeaderBottomPosition);
            if (mOnHeaderClickListener != null)
            {
                mOnHeaderClickListener.onHeaderClick(this, mHeader, mHeaderPosition.intValue(), mCurrentHeaderId.longValue(), true);
                return true;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        mHeaderDownY = -1F;
        mHeaderBeingPressed = false;
        mHeader.setPressed(false);
        mHeader.invalidate();
        invalidate(0, 0, getWidth(), mHeaderBottomPosition);
        return super.onTouchEvent(motionevent);
    }

    public boolean performItemClick(View view, int i, long l)
    {
        View view1 = view;
        if (view instanceof WrapperView)
        {
            view1 = ((WrapperView)view).mItem;
        }
        return super.performItemClick(view1, i, l);
    }

    public boolean removeFooterView(View view)
    {
        if (super.removeFooterView(view))
        {
            mFooterViews.remove(view);
            return true;
        } else
        {
            return false;
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (isInEditMode())
        {
            super.setAdapter(listadapter);
            return;
        }
        if (listadapter == null)
        {
            mAdapter = null;
            reset();
            super.setAdapter(null);
            return;
        }
        if (!(listadapter instanceof StickyListHeadersAdapter))
        {
            throw new IllegalArgumentException("Adapter must implement StickyListHeadersAdapter");
        } else
        {
            mAdapter = wrapAdapter(listadapter);
            reset();
            super.setAdapter(mAdapter);
            return;
        }
    }

    public void setAreHeadersSticky(boolean flag)
    {
        if (mAreHeadersSticky != flag)
        {
            mAreHeadersSticky = flag;
            requestLayout();
        }
    }

    public void setClipToPadding(boolean flag)
    {
        super.setClipToPadding(flag);
        mClippingToPadding = Boolean.valueOf(flag);
    }

    public void setDivider(Drawable drawable)
    {
        mDivider = drawable;
        if (drawable != null)
        {
            int i = drawable.getIntrinsicHeight();
            if (i >= 0)
            {
                setDividerHeight(i);
            }
        }
        if (mAdapter != null)
        {
            mAdapter.setDivider(drawable);
            requestLayout();
            invalidate();
        }
    }

    public void setDividerHeight(int i)
    {
        mDividerHeight = i;
        if (mAdapter != null)
        {
            mAdapter.setDividerHeight(i);
            requestLayout();
            invalidate();
        }
    }

    public void setDrawingListUnderStickyHeader(boolean flag)
    {
        mDrawingListUnderStickyHeader = flag;
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onheaderclicklistener)
    {
        mOnHeaderClickListener = onheaderclicklistener;
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        mOnScrollListenerDelegate = onscrolllistener;
    }




}

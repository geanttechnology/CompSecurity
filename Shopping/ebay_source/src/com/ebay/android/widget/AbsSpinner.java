// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

// Referenced classes of package com.ebay.android.widget:
//            AdapterView

public abstract class AbsSpinner extends AdapterView
{
    class RecycleBin
    {

        private SparseArray mScrapHeap;
        final AbsSpinner this$0;

        void clear()
        {
            SparseArray sparsearray = mScrapHeap;
            int j = sparsearray.size();
            for (int i = 0; i < j; i++)
            {
                View view = (View)sparsearray.valueAt(i);
                if (view != null)
                {
                    removeDetachedView(view, true);
                }
            }

            sparsearray.clear();
        }

        View get(int i)
        {
            View view = (View)mScrapHeap.get(i);
            if (view != null)
            {
                mScrapHeap.delete(i);
            }
            return view;
        }

        View peek(int i)
        {
            return (View)mScrapHeap.get(i);
        }

        public void put(int i, View view)
        {
            mScrapHeap.put(i, view);
        }

        RecycleBin()
        {
            this$0 = AbsSpinner.this;
            super();
            mScrapHeap = new SparseArray();
        }
    }

    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        int position;
        long selectedId;

        public String toString()
        {
            return (new StringBuilder()).append("AbsSpinner.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" selectedId=").append(selectedId).append(" position=").append(position).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeLong(selectedId);
            parcel.writeInt(position);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            selectedId = parcel.readLong();
            position = parcel.readInt();
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    SpinnerAdapter mAdapter;
    boolean mBlockLayoutRequests;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    Interpolator mInterpolator;
    RecycleBin mRecycler;
    View mSelectedView;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    public AbsSpinner(Context context)
    {
        super(context);
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mSpinnerPadding = new Rect();
        mSelectedView = null;
        mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    public AbsSpinner(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AbsSpinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mSpinnerPadding = new Rect();
        mSelectedView = null;
        mRecycler = new RecycleBin();
        initAbsSpinner();
        attributeset = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.AbsSpinner, i, 0);
        CharSequence acharsequence[] = attributeset.getTextArray(0);
        if (acharsequence != null)
        {
            context = new ArrayAdapter(context, 0x1090008, acharsequence);
            context.setDropDownViewResource(0x1090009);
            setAdapter(context);
        }
        attributeset.recycle();
    }

    private void initAbsSpinner()
    {
        setFocusable(true);
        setWillNotDraw(false);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new android.view.ViewGroup.LayoutParams(-1, -2);
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public SpinnerAdapter getAdapter()
    {
        return mAdapter;
    }

    int getChildHeight(View view)
    {
        return view.getMeasuredHeight();
    }

    int getChildWidth(View view)
    {
        return view.getMeasuredWidth();
    }

    public int getCount()
    {
        return mItemCount;
    }

    public View getSelectedView()
    {
        if (mItemCount > 0 && mSelectedPosition >= 0)
        {
            return getChildAt(mSelectedPosition - mFirstPosition);
        } else
        {
            return null;
        }
    }

    void handleDataChanged()
    {
        super.handleDataChanged();
    }

    abstract void layout(int i, boolean flag);

    protected void onMeasure(int i, int j)
    {
        int k1 = android.view.View.MeasureSpec.getMode(i);
        Rect rect = mSpinnerPadding;
        int k;
        int l;
        boolean flag;
        int j1;
        boolean flag1;
        boolean flag2;
        int l1;
        if (getPaddingLeft() > mSelectionLeftPadding)
        {
            k = getPaddingLeft();
        } else
        {
            k = mSelectionLeftPadding;
        }
        rect.left = k;
        rect = mSpinnerPadding;
        if (getPaddingTop() > mSelectionTopPadding)
        {
            k = getPaddingTop();
        } else
        {
            k = mSelectionTopPadding;
        }
        rect.top = k;
        rect = mSpinnerPadding;
        if (getPaddingRight() > mSelectionRightPadding)
        {
            k = getPaddingRight();
        } else
        {
            k = mSelectionRightPadding;
        }
        rect.right = k;
        rect = mSpinnerPadding;
        if (getPaddingBottom() > mSelectionBottomPadding)
        {
            k = getPaddingBottom();
        } else
        {
            k = mSelectionBottomPadding;
        }
        rect.bottom = k;
        if (mDataChanged)
        {
            handleDataChanged();
        }
        j1 = 0;
        flag1 = false;
        flag2 = true;
        l1 = getSelectedItemPosition();
        flag = flag2;
        l = j1;
        k = ((flag1) ? 1 : 0);
        if (l1 >= 0)
        {
            flag = flag2;
            l = j1;
            k = ((flag1) ? 1 : 0);
            if (mAdapter != null)
            {
                View view1 = mRecycler.get(l1);
                View view = view1;
                if (view1 == null)
                {
                    view = mAdapter.getView(l1, null, this);
                }
                if (view != null)
                {
                    mRecycler.put(l1, view);
                }
                flag = flag2;
                l = j1;
                k = ((flag1) ? 1 : 0);
                if (view != null)
                {
                    if (view.getLayoutParams() == null)
                    {
                        mBlockLayoutRequests = true;
                        view.setLayoutParams(generateDefaultLayoutParams());
                        mBlockLayoutRequests = false;
                    }
                    measureChild(view, i, j);
                    l = getChildHeight(view) + mSpinnerPadding.top + mSpinnerPadding.bottom;
                    k = getChildWidth(view) + mSpinnerPadding.left + mSpinnerPadding.right;
                    flag = false;
                }
            }
        }
        j1 = l;
        l = k;
        if (flag)
        {
            int i1 = mSpinnerPadding.top + mSpinnerPadding.bottom;
            j1 = i1;
            l = k;
            if (k1 == 0)
            {
                l = mSpinnerPadding.left + mSpinnerPadding.right;
                j1 = i1;
            }
        }
        k = Math.max(j1, getSuggestedMinimumHeight());
        l = Math.max(l, getSuggestedMinimumWidth());
        k = resolveSize(k, j);
        setMeasuredDimension(resolveSize(l, i), k);
        mHeightMeasureSpec = j;
        mWidthMeasureSpec = i;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (((SavedState) (parcelable)).selectedId >= 0L)
        {
            mDataChanged = true;
            mNeedSync = true;
            mSyncRowId = ((SavedState) (parcelable)).selectedId;
            mSyncPosition = ((SavedState) (parcelable)).position;
            mSyncMode = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.selectedId = getSelectedItemId();
        if (savedstate.selectedId >= 0L)
        {
            savedstate.position = getSelectedItemPosition();
            return savedstate;
        } else
        {
            savedstate.position = -1;
            return savedstate;
        }
    }

    public int pointToPosition(int i, int j)
    {
        Rect rect1 = mTouchFrame;
        Rect rect = rect1;
        if (rect1 == null)
        {
            mTouchFrame = new Rect();
            rect = mTouchFrame;
        }
        for (int k = getChildCount() - 1; k >= 0; k--)
        {
            View view = getChildAt(k);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            view.getHitRect(rect);
            if (rect.contains(i, j))
            {
                return mFirstPosition + k;
            }
        }

        return -1;
    }

    void recycleAllViews()
    {
        int j = getChildCount();
        RecycleBin recyclebin = mRecycler;
        for (int i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            recyclebin.put(mFirstPosition + i, view);
        }

    }

    public void requestLayout()
    {
        if (!mBlockLayoutRequests)
        {
            super.requestLayout();
        }
    }

    void resetList()
    {
        mDataChanged = false;
        mNeedSync = false;
        removeAllViewsInLayout();
        mOldSelectedPosition = -1;
        mOldSelectedRowId = 0x8000000000000000L;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((SpinnerAdapter)adapter);
    }

    public void setAdapter(SpinnerAdapter spinneradapter)
    {
        byte byte0 = -1;
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            resetList();
        }
        mAdapter = spinneradapter;
        mOldSelectedPosition = -1;
        mOldSelectedRowId = 0x8000000000000000L;
        if (mAdapter != null)
        {
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            checkFocus();
            mDataSetObserver = new AdapterView.AdapterDataSetObserver(this);
            mAdapter.registerDataSetObserver(mDataSetObserver);
            if (mItemCount > 0)
            {
                byte0 = 0;
            }
            setSelectedPositionInt(byte0);
            setNextSelectedPositionInt(byte0);
            if (mItemCount == 0)
            {
                checkSelectionChanged();
            }
        } else
        {
            checkFocus();
            resetList();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setSelection(int i)
    {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    public void setSelection(int i, boolean flag)
    {
        if (flag && mFirstPosition <= i && i <= (mFirstPosition + getChildCount()) - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setSelectionInt(i, flag);
    }

    void setSelectionInt(int i, boolean flag)
    {
        if (i != mOldSelectedPosition)
        {
            mBlockLayoutRequests = true;
            int j = mSelectedPosition;
            setNextSelectedPositionInt(i);
            layout(i - j, flag);
            mBlockLayoutRequests = false;
        }
    }

}

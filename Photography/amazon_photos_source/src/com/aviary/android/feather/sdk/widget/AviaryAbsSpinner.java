// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryAdapterView

public abstract class AviaryAbsSpinner extends AviaryAdapterView
{
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
            return (new StringBuilder()).append("AviaryAbsSpinner.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" selectedId=").append(selectedId).append(" position=").append(position).append("}").toString();
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


    Adapter mAdapter;
    boolean mBlockLayoutRequests;
    private DataSetObserver mDataSetObserver;
    int mDefaultPosition;
    int mHeightMeasureSpec;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    protected final List mRecycleBin;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    final Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    public AviaryAbsSpinner(Context context)
    {
        this(context, null);
    }

    public AviaryAbsSpinner(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AviaryAbsSpinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSpinnerPadding = new Rect();
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mRecycleBin = new ArrayList(10);
        initAbsSpinner();
    }

    private void emptyRecycler()
    {
        emptySubRecycler();
        if (mRecycleBin != null)
        {
            mRecycleBin.clear();
        }
    }

    private void initAbsSpinner()
    {
        setFocusable(true);
        setWillNotDraw(false);
    }

    protected void emptySubRecycler()
    {
        if (mRecycleBin != null)
        {
            for (int i = 0; i < mRecycleBin.size(); i++)
            {
                ((Queue)mRecycleBin.get(i)).clear();
            }

        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new android.view.ViewGroup.LayoutParams(-1, -2);
    }

    public Adapter getAdapter()
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

    abstract void layout(int i, boolean flag, boolean flag1);

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
        if (mPaddingLeft > mSelectionLeftPadding)
        {
            k = mPaddingLeft;
        } else
        {
            k = mSelectionLeftPadding;
        }
        rect.left = k;
        rect = mSpinnerPadding;
        if (mPaddingTop > mSelectionTopPadding)
        {
            k = mPaddingTop;
        } else
        {
            k = mSelectionTopPadding;
        }
        rect.top = k;
        rect = mSpinnerPadding;
        if (mPaddingRight > mSelectionRightPadding)
        {
            k = mPaddingRight;
        } else
        {
            k = mSelectionRightPadding;
        }
        rect.right = k;
        rect = mSpinnerPadding;
        if (mPaddingBottom > mSelectionBottomPadding)
        {
            k = mPaddingBottom;
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
                flag = flag2;
                l = j1;
                k = ((flag1) ? 1 : 0);
                if (l1 < mAdapter.getCount())
                {
                    k = mAdapter.getItemViewType(l1);
                    View view1 = (View)((Queue)mRecycleBin.get(k)).poll();
                    View view = view1;
                    if (view1 == null)
                    {
                        view = mAdapter.getView(l1, null, this);
                    }
                    if (view != null)
                    {
                        ((Queue)mRecycleBin.get(k)).offer(view);
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
        int k = mFirstPosition;
        for (int i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            int l = mAdapter.getItemViewType(k + i);
            ((Queue)mRecycleBin.get(l)).offer(view);
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
        Log.i("View", "emptyList");
        mDataChanged = false;
        mNeedSync = false;
        removeAllViewsInLayout();
        emptyRecycler();
        mOldSelectedPosition = -1;
        mOldSelectedRowId = 0x8000000000000000L;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    public void setAdapter(Adapter adapter)
    {
        int i;
        i = -1;
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            emptyRecycler();
            resetList();
        }
        mAdapter = adapter;
        mOldSelectedPosition = -1;
        mOldSelectedRowId = 0x8000000000000000L;
        if (mAdapter == null) goto _L2; else goto _L1
_L1:
        mOldItemCount = mItemCount;
        mItemCount = mAdapter.getCount();
        checkFocus();
        mDataSetObserver = new AviaryAdapterView.AdapterDataSetObserver(this);
        mAdapter.registerDataSetObserver(mDataSetObserver);
        if (mDefaultPosition < 0 || mDefaultPosition >= mItemCount) goto _L4; else goto _L3
_L3:
        i = mDefaultPosition;
_L6:
        int k = mAdapter.getViewTypeCount();
        for (int j = 0; j < k; j++)
        {
            mRecycleBin.add(new LinkedList());
        }

        break; /* Loop/switch isn't completed */
_L4:
        if (mItemCount > 0)
        {
            i = 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
        setSelectedPositionInt(i);
        setNextSelectedPositionInt(i);
        if (mItemCount == 0)
        {
            checkSelectionChanged();
        }
_L8:
        requestLayout();
        return;
_L2:
        checkFocus();
        resetList();
        checkSelectionChanged();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void setDefaultPosition(int i)
    {
        mDefaultPosition = i;
    }

    public void setPadding(int i, int j, int k, int l)
    {
        super.setPadding(i, j, k, l);
        mPaddingLeft = i;
        mPaddingBottom = l;
        mPaddingTop = j;
        mPaddingRight = k;
    }

    public void setSelection(int i)
    {
        if (mItemCount > 0 && i >= 0 && i < mItemCount)
        {
            setNextSelectedPositionInt(i);
            requestLayout();
            postInvalidate();
        }
    }

    public void setSelection(int i, boolean flag, boolean flag1)
    {
        if (flag && mFirstPosition <= i && i <= (mFirstPosition + getChildCount()) - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setSelectionInt(i, flag, flag1);
    }

    void setSelectionInt(int i, boolean flag, boolean flag1)
    {
        if (i != mOldSelectedPosition)
        {
            mBlockLayoutRequests = true;
            int j = mSelectedPosition;
            setNextSelectedPositionInt(i);
            layout(i - j, flag, flag1);
            mBlockLayoutRequests = false;
        }
    }
}

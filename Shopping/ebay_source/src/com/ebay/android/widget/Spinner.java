// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

// Referenced classes of package com.ebay.android.widget:
//            AbsSpinner

public class Spinner extends AbsSpinner
    implements android.content.DialogInterface.OnClickListener
{
    private static class DropDownAdapter
        implements ListAdapter, SpinnerAdapter
    {

        private SpinnerAdapter mAdapter;

        public boolean areAllItemsEnabled()
        {
            return true;
        }

        public int getCount()
        {
            if (mAdapter == null)
            {
                return 0;
            } else
            {
                return mAdapter.getCount();
            }
        }

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            if (mAdapter == null)
            {
                return null;
            } else
            {
                return mAdapter.getDropDownView(i, view, viewgroup);
            }
        }

        public Object getItem(int i)
        {
            if (mAdapter == null)
            {
                return null;
            } else
            {
                return mAdapter.getItem(i);
            }
        }

        public long getItemId(int i)
        {
            if (mAdapter == null)
            {
                return -1L;
            } else
            {
                return mAdapter.getItemId(i);
            }
        }

        public int getItemViewType(int i)
        {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            return getDropDownView(i, view, viewgroup);
        }

        public int getViewTypeCount()
        {
            return 1;
        }

        public boolean hasStableIds()
        {
            return mAdapter != null && mAdapter.hasStableIds();
        }

        public boolean isEmpty()
        {
            return getCount() == 0;
        }

        public boolean isEnabled(int i)
        {
            return true;
        }

        public void registerDataSetObserver(DataSetObserver datasetobserver)
        {
            if (mAdapter != null)
            {
                mAdapter.registerDataSetObserver(datasetobserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver datasetobserver)
        {
            if (mAdapter != null)
            {
                mAdapter.unregisterDataSetObserver(datasetobserver);
            }
        }

        public DropDownAdapter(SpinnerAdapter spinneradapter)
        {
            mAdapter = spinneradapter;
        }
    }


    private AlertDialog mPopup;
    private CharSequence mPrompt;

    public Spinner(Context context)
    {
        this(context, null);
    }

    public Spinner(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010081);
    }

    public Spinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.Spinner, i, 0);
        mPrompt = context.getString(4);
        context.recycle();
    }

    private View makeAndAddView(int i)
    {
        if (!mDataChanged)
        {
            View view = mRecycler.get(i);
            if (view != null)
            {
                setUpChild(view);
                return view;
            }
        }
        View view1 = mAdapter.getView(i, null, this);
        setUpChild(view1);
        return view1;
    }

    private void setUpChild(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, 0, layoutparams);
        view.setSelected(hasFocus());
        int i = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec, mSpinnerPadding.top + mSpinnerPadding.bottom, layoutparams.height);
        view.measure(ViewGroup.getChildMeasureSpec(mWidthMeasureSpec, mSpinnerPadding.left + mSpinnerPadding.right, layoutparams.width), i);
        i = mSpinnerPadding.top + (getMeasuredHeight() - mSpinnerPadding.bottom - mSpinnerPadding.top - view.getMeasuredHeight()) / 2;
        int j = view.getMeasuredHeight();
        view.layout(0, i, 0 + view.getMeasuredWidth(), i + j);
    }

    public int getBaseline()
    {
        Object obj = null;
        View view;
        if (getChildCount() > 0)
        {
            view = getChildAt(0);
        } else
        {
            view = obj;
            if (mAdapter != null)
            {
                view = obj;
                if (mAdapter.getCount() > 0)
                {
                    view = makeAndAddView(0);
                }
            }
        }
        if (view != null)
        {
            return view.getTop() + view.getBaseline();
        } else
        {
            return -1;
        }
    }

    public CharSequence getPrompt()
    {
        return mPrompt;
    }

    void layout(int i, boolean flag)
    {
        i = mSpinnerPadding.left;
        int j = getRight();
        int k = getLeft();
        int l = mSpinnerPadding.left;
        int i1 = mSpinnerPadding.right;
        if (mDataChanged)
        {
            handleDataChanged();
        }
        if (mItemCount == 0)
        {
            resetList();
            return;
        }
        if (mNextSelectedPosition >= 0)
        {
            setSelectedPositionInt(mNextSelectedPosition);
        }
        recycleAllViews();
        removeAllViewsInLayout();
        mFirstPosition = mSelectedPosition;
        View view = makeAndAddView(mSelectedPosition);
        int j1 = view.getMeasuredWidth();
        view.offsetLeftAndRight(((j - k - l - i1) / 2 + i) - j1 / 2);
        mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        setSelection(i);
        dialoginterface.dismiss();
        mPopup = null;
    }

    protected void onDetachedFromWindow()
    {
        Exception exception;
        super.onDetachedFromWindow();
        if (mPopup != null && mPopup.isShowing())
        {
            try
            {
                mPopup.dismiss();
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                mPopup = null;
                return;
            }
            finally
            {
                mPopup = null;
            }
            mPopup = null;
        }
        return;
        throw exception;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mInLayout = true;
        layout(0, false);
        mInLayout = false;
    }

    public boolean performClick()
    {
        boolean flag1 = super.performClick();
        boolean flag = flag1;
        if (!flag1)
        {
            flag = true;
            Object obj = getContext();
            DropDownAdapter dropdownadapter = new DropDownAdapter(getAdapter());
            obj = new android.support.v7.app.AlertDialog.Builder(((Context) (obj)));
            if (mPrompt != null)
            {
                ((android.support.v7.app.AlertDialog.Builder) (obj)).setTitle(mPrompt);
            }
            mPopup = ((android.support.v7.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(dropdownadapter, getSelectedItemPosition(), this).show();
        }
        return flag;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onitemclicklistener)
    {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    public void setPrompt(CharSequence charsequence)
    {
        mPrompt = charsequence;
    }

    public void setPromptId(int i)
    {
        mPrompt = getContext().getText(i);
    }
}

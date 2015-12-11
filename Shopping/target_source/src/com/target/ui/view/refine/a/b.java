// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import com.target.ui.util.u;
import java.util.List;

public class com.target.ui.view.refine.a.b extends e
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel);

        public abstract void b(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel);
    }

    private static class b
    {

        final TextView count;
        int position;
        final RadioButton radioButton;
        final View rootContainer;

        public b(View view)
        {
            position = -1;
            rootContainer = view.findViewById(0x7f100562);
            radioButton = (RadioButton)view.findViewById(0x7f100563);
            count = (TextView)view.findViewById(0x7f100564);
        }
    }


    private static final int NULL_INT = -1;
    public static final String TAG = com/target/ui/view/refine/a/b.getSimpleName();
    private int mCurrentlySelectedPosition;
    private a mListener;
    private int mPreviouslySelPosition;
    private com.target.ui.model.refine.ProductSortModel.SortLabel mSelectedSortBy;
    private List mSortByList;

    public com.target.ui.view.refine.a.b(Context context, List list)
    {
        super(context, list);
        mSortByList = list;
        mCurrentlySelectedPosition = -1;
        setNotifyOnChange(false);
    }

    private void a(int i, b b1)
    {
        b1 = b1.radioButton;
        boolean flag;
        if (i == mCurrentlySelectedPosition)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b1.setChecked(flag);
    }

    private void a(b b1, com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
    {
        if (b1 == null || sortlabel == null)
        {
            return;
        } else
        {
            b1.radioButton.setEnabled(true);
            b1.radioButton.setText(getContext().getString(sortlabel.b()));
            b1.radioButton.setTag(b1);
            b1.radioButton.setOnClickListener(this);
            return;
        }
    }

    private int b(List list, com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
    {
        if (sortlabel == null)
        {
            return -1;
        } else
        {
            return list.indexOf(sortlabel);
        }
    }

    public void a()
    {
        mCurrentlySelectedPosition = -1;
        notifyDataSetChanged();
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public void a(List list, com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
    {
        mSortByList.clear();
        mSortByList.addAll(list);
        mSelectedSortBy = sortlabel;
        mCurrentlySelectedPosition = b(list, sortlabel);
        clear();
        addAll(list);
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel = (com.target.ui.model.refine.ProductSortModel.SortLabel)getItem(i);
        if (view == null)
        {
            view = mInflater.inflate(0x7f0301cf, viewgroup, false);
            viewgroup = new b(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (b)view.getTag();
        }
        viewgroup.position = i;
        al.c(((b) (viewgroup)).count);
        a(viewgroup, sortlabel);
        a(i, viewgroup);
        return view;
    }

    public void onClick(View view)
    {
        com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel;
        view = (b)u.a(view.getTag(), com/target/ui/view/refine/a/b$b);
        if (view == null)
        {
            return;
        }
        mPreviouslySelPosition = mCurrentlySelectedPosition;
        mCurrentlySelectedPosition = ((b) (view)).position;
        sortlabel = (com.target.ui.model.refine.ProductSortModel.SortLabel)mSortByList.get(mCurrentlySelectedPosition);
        if (mPreviouslySelPosition != -1)
        {
            view = (com.target.ui.model.refine.ProductSortModel.SortLabel)mSortByList.get(mPreviouslySelPosition);
        } else
        {
            view = null;
        }
        if (mCurrentlySelectedPosition == mPreviouslySelPosition) goto _L2; else goto _L1
_L1:
        if (mListener != null)
        {
            if (view != null)
            {
                mListener.b(view);
            }
            mSelectedSortBy = sortlabel;
            mListener.a(sortlabel);
        }
_L4:
        notifyDataSetInvalidated();
        return;
_L2:
        mCurrentlySelectedPosition = -1;
        if (mListener != null)
        {
            mSelectedSortBy = null;
            mListener.b(sortlabel);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}

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
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.ui.adapter.b.e;
import com.target.ui.util.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class com.target.ui.view.refine.a.a extends e
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a(ProductEntry productentry);

        public abstract void b(ProductEntry productentry);
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
    public static final String TAG = com/target/ui/view/refine/a/a.getSimpleName();
    private List mCategoryFacets;
    private int mCurrentlySelectedPosition;
    private a mListener;
    private int mPreviouslySelPosition;
    private List mSelectedFacets;

    public com.target.ui.view.refine.a.a(Context context, List list)
    {
        super(context, list);
        mCategoryFacets = list;
        mSelectedFacets = Collections.emptyList();
        mCurrentlySelectedPosition = -1;
        setNotifyOnChange(false);
    }

    private void a(int i, b b1, ProductEntry productentry)
    {
        Iterator iterator = mSelectedFacets.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((ProductEntry)iterator.next()).d().equalsIgnoreCase(productentry.d()))
            {
                continue;
            }
            mCurrentlySelectedPosition = i;
            break;
        } while (true);
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

    private void a(b b1, ProductEntry productentry)
    {
        productentry = String.format(getContext().getString(0x7f090474), new Object[] {
            Integer.valueOf(productentry.a())
        });
        b1.count.setText(productentry);
    }

    private void b(b b1, ProductEntry productentry)
    {
        if (b1 == null || productentry == null)
        {
            return;
        } else
        {
            b1.radioButton.setEnabled(true);
            b1.radioButton.setText(productentry.d());
            b1.radioButton.setTag(b1);
            b1.radioButton.setOnClickListener(this);
            return;
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

    public void a(List list, List list1)
    {
        mSelectedFacets.clear();
        mCategoryFacets.clear();
        mCategoryFacets.addAll(list);
        mSelectedFacets.addAll(list1);
        clear();
        addAll(list);
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ProductEntry productentry = (ProductEntry)getItem(i);
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
        b(viewgroup, productentry);
        a(viewgroup, productentry);
        a(i, viewgroup, productentry);
        return view;
    }

    public void onClick(View view)
    {
        ProductEntry productentry;
        view = (b)u.a(view.getTag(), com/target/ui/view/refine/a/a$b);
        if (view == null)
        {
            return;
        }
        mPreviouslySelPosition = mCurrentlySelectedPosition;
        mCurrentlySelectedPosition = ((b) (view)).position;
        productentry = (ProductEntry)mCategoryFacets.get(((b) (view)).position);
        if (mPreviouslySelPosition != -1)
        {
            view = (ProductEntry)mCategoryFacets.get(mPreviouslySelPosition);
        } else
        {
            view = null;
        }
        if (mCurrentlySelectedPosition == mPreviouslySelPosition) goto _L2; else goto _L1
_L1:
        if (mListener != null && mListener != null)
        {
            if (view != null)
            {
                mListener.b(view);
            }
            mListener.a(productentry);
        }
_L4:
        notifyDataSetInvalidated();
        return;
_L2:
        mCurrentlySelectedPosition = -1;
        if (mListener != null)
        {
            mListener.b(productentry);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}

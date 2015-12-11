// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.adapter.b.e;
import com.target.ui.util.u;
import java.util.List;

public class ProductAddToListDialogAdapter extends e
{
    static class ViewHolder extends com.target.ui.view.a
    {

        int position;
        RadioButton radioButton;
        TextView title;

        public ViewHolder(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(ListSummary listsummary);
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final ProductAddToListDialogAdapter this$0;

        public void onClick(View view)
        {
            view = (ViewHolder)u.a(view.getTag(), com/target/ui/adapter/product/ProductAddToListDialogAdapter$ViewHolder);
            if (view != null)
            {
                if (ProductAddToListDialogAdapter.a(ProductAddToListDialogAdapter.this) != ((ViewHolder) (view)).position)
                {
                    ProductAddToListDialogAdapter.a(ProductAddToListDialogAdapter.this, ((ViewHolder) (view)).position);
                    notifyDataSetChanged();
                }
                if (ProductAddToListDialogAdapter.b(ProductAddToListDialogAdapter.this) != null)
                {
                    view = (ListSummary)getItem(((ViewHolder) (view)).position);
                    ProductAddToListDialogAdapter.b(ProductAddToListDialogAdapter.this).a(view);
                    return;
                }
            }
        }

        private b()
        {
            this$0 = ProductAddToListDialogAdapter.this;
            super();
        }

    }


    private static final int DEFAULT_POS = 0;
    private static final int NULL_INT = -1;
    private a mListener;
    private int mSelectedPos;

    public ProductAddToListDialogAdapter(Context context, List list)
    {
        super(context, list);
        mSelectedPos = 0;
        setNotifyOnChange(false);
    }

    static int a(ProductAddToListDialogAdapter productaddtolistdialogadapter)
    {
        return productaddtolistdialogadapter.mSelectedPos;
    }

    static int a(ProductAddToListDialogAdapter productaddtolistdialogadapter, int i)
    {
        productaddtolistdialogadapter.mSelectedPos = i;
        return i;
    }

    static a b(ProductAddToListDialogAdapter productaddtolistdialogadapter)
    {
        return productaddtolistdialogadapter.mListener;
    }

    public ListSummary a()
    {
        ListSummary listsummary = null;
        if (getCount() > 0)
        {
            listsummary = (ListSummary)getItem(0);
        }
        return listsummary;
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public void a(List list)
    {
        clear();
        a(((java.util.Collection) (list)));
        notifyDataSetChanged();
    }

    public void b()
    {
        mSelectedPos = -1;
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
        ListSummary listsummary = (ListSummary)getItem(i);
        RadioButton radiobutton;
        if (view == null)
        {
            view = mInflater.inflate(0x7f0300fe, null, false);
            viewgroup = new ViewHolder(view);
            view.setOnClickListener(new b());
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        viewgroup.position = i;
        radiobutton = ((ViewHolder) (viewgroup)).radioButton;
        if (i == mSelectedPos)
        {
            flag = true;
        }
        radiobutton.setChecked(flag);
        ((ViewHolder) (viewgroup)).title.setText(listsummary.getTitle());
        ((ViewHolder) (viewgroup)).radioButton.setTag(viewgroup);
        ((ViewHolder) (viewgroup)).radioButton.setOnClickListener(new b());
        return view;
    }
}

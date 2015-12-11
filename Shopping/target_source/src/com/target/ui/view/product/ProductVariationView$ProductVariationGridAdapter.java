// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.f.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.target.mothership.util.p;
import com.target.ui.adapter.b.c;
import com.target.ui.adapter.b.e;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.util.al;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.a;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            ProductVariationView

class setNotifyOnChange extends e
{
    class ViewHolder extends a
    {

        ImageView checkView;
        ImageView greyOut;
        BitmapImageView imageView;
        private final View root;
        final ProductVariationView.ProductVariationGridAdapter this$1;

        static View a(ViewHolder viewholder)
        {
            return viewholder.root;
        }

        public ViewHolder(View view)
        {
            this$1 = ProductVariationView.ProductVariationGridAdapter.this;
            super(view);
            root = view;
        }
    }


    private List mGridItemList;
    private int mSelectedPos;
    final ProductVariationView this$0;

    private void a(ViewHolder viewholder, int i)
    {
        if (mSelectedPos != -1 && i == mSelectedPos)
        {
            String s = getResources().getString(0x7f09048e);
            viewholder.checkView.setContentDescription(s);
            com.target.ui.view.product.ViewHolder.a(viewholder).setBackgroundResource(0x7f020233);
            al.b(viewholder.checkView);
            return;
        } else
        {
            com.target.ui.view.product.ViewHolder.a(viewholder).setBackgroundResource(0x7f020232);
            al.a(new View[] {
                viewholder.checkView, viewholder.greyOut
            });
            return;
        }
    }

    private void a(ViewHolder viewholder, GridItem griditem)
    {
        griditem = griditem.c();
        int i = getContext().getResources().getDimensionPixelSize(0x7f0a027e);
        griditem = p.a(griditem.toString(), i);
        c.a(getContext(), griditem, viewholder.imageView);
        al.b(viewholder.imageView);
    }

    private void b(ViewHolder viewholder, GridItem griditem)
    {
        if (b(griditem))
        {
            griditem = getResources().getString(0x7f09048d, new Object[] {
                griditem.b()
            });
            al.b(viewholder.greyOut);
        } else
        {
            griditem = griditem.b();
            al.c(viewholder.greyOut);
        }
        viewholder.imageView.setContentDescription(griditem);
    }

    private boolean b(GridItem griditem)
    {
        if (com.target.ui.view.product.ProductVariationView.a(ProductVariationView.this) != null)
        {
            if ((griditem = (Boolean)com.target.ui.view.product.ProductVariationView.a(ProductVariationView.this).d().get(new h(com.target.ui.view.product.ProductVariationView.c(ProductVariationView.this), griditem))) != null)
            {
                boolean flag;
                if (!griditem.booleanValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public int a(GridItem griditem)
    {
        if (griditem != null && mGridItemList != null) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= mGridItemList.size())
                {
                    break label1;
                }
                j = i;
                if (griditem.equals(mGridItemList.get(i)))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public void a(int i)
    {
        mSelectedPos = i;
        notifyDataSetChanged();
    }

    public void a(List list)
    {
        clear();
        addAll(list);
        mGridItemList = list;
        notifyDataSetChanged();
    }

    public boolean a()
    {
        return mSelectedPos != -1;
    }

    public int b()
    {
        return mSelectedPos;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        GridItem griditem;
        if (view == null)
        {
            view = mInflater.inflate(0x7f030196, viewgroup, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        griditem = (GridItem)getItem(i);
        a(viewgroup, griditem);
        a(viewgroup, i);
        b(viewgroup, griditem);
        return view;
    }

    public ViewHolder.root(Context context, List list)
    {
        this$0 = ProductVariationView.this;
        super(context, list);
        mSelectedPos = -1;
        mGridItemList = list;
        setNotifyOnChange(false);
    }
}

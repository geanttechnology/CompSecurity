// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.f.h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.target.mothership.util.p;
import com.target.ui.adapter.b.e;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.util.ah;
import com.target.ui.util.al;
import com.target.ui.view.BitmapImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            FixedHeightGridView

public class ProductVariationView extends LinearLayout
{
    class ProductVariationGridAdapter extends e
    {

        private List mGridItemList;
        private int mSelectedPos;
        final ProductVariationView this$0;

        private void a(ViewHolder viewholder, int k)
        {
            if (mSelectedPos != -1 && k == mSelectedPos)
            {
                String s = getResources().getString(0x7f09048e);
                viewholder.checkView.setContentDescription(s);
                ViewHolder.a(viewholder).setBackgroundResource(0x7f020233);
                al.b(viewholder.checkView);
                return;
            } else
            {
                ViewHolder.a(viewholder).setBackgroundResource(0x7f020232);
                al.a(new View[] {
                    viewholder.checkView, viewholder.greyOut
                });
                return;
            }
        }

        private void a(ViewHolder viewholder, GridItem griditem)
        {
            griditem = griditem.c();
            int k = getContext().getResources().getDimensionPixelSize(0x7f0a027e);
            griditem = p.a(griditem.toString(), k);
            com.target.ui.adapter.b.c.a(getContext(), griditem, viewholder.imageView);
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
            if (ProductVariationView.a(ProductVariationView.this) != null)
            {
                if ((griditem = (Boolean)ProductVariationView.a(ProductVariationView.this).d().get(new h(ProductVariationView.c(ProductVariationView.this), griditem))) != null)
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
            int l = -1;
_L4:
            return l;
_L2:
            int k = 0;
label0:
            do
            {
label1:
                {
                    if (k >= mGridItemList.size())
                    {
                        break label1;
                    }
                    l = k;
                    if (griditem.equals(mGridItemList.get(k)))
                    {
                        break label0;
                    }
                    k++;
                }
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
            return -1;
        }

        public void a(int k)
        {
            mSelectedPos = k;
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

        public View getView(int k, View view, ViewGroup viewgroup)
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
            griditem = (GridItem)getItem(k);
            a(viewgroup, griditem);
            a(viewgroup, k);
            b(viewgroup, griditem);
            return view;
        }

        public ProductVariationGridAdapter(Context context, List list)
        {
            this$0 = ProductVariationView.this;
            super(context, list);
            mSelectedPos = -1;
            mGridItemList = list;
            setNotifyOnChange(false);
        }
    }

    class ProductVariationGridAdapter.ViewHolder extends com.target.ui.view.a
    {

        ImageView checkView;
        ImageView greyOut;
        BitmapImageView imageView;
        private final View root;
        final ProductVariationGridAdapter this$1;

        static View a(ProductVariationGridAdapter.ViewHolder viewholder)
        {
            return viewholder.root;
        }

        public ProductVariationGridAdapter.ViewHolder(View view)
        {
            this$1 = ProductVariationGridAdapter.this;
            super(view);
            root = view;
        }
    }

    static class Views extends com.target.ui.view.a
    {

        Spinner dropDown;
        View dropDownBottomDiv;
        View dropDownTopDiv;
        FixedHeightGridView gridView;
        View gridViewBottomDiv;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.widget.AdapterView.OnItemClickListener
    {

        final ProductVariationView this$0;

        public void onItemClick(AdapterView adapterview, View view, int k, long l)
        {
            adapterview = (ProductVariationGridAdapter)com.target.ui.view.product.ProductVariationView.e(ProductVariationView.this).gridView.getAdapter();
            if (adapterview.b() == k)
            {
                adapterview.a(-1);
            } else
            {
                adapterview.a(k);
            }
            if (adapterview.a())
            {
                ProductVariationView.a(ProductVariationView.this, (GridItem)adapterview.getItem(k));
                ProductVariationView.b(ProductVariationView.this, ProductVariationView.b(ProductVariationView.this));
                return;
            } else
            {
                ProductVariationView.c(ProductVariationView.this, null);
                ProductVariationView.b(ProductVariationView.this, ProductVariationView.b(ProductVariationView.this));
                ProductVariationView.g(ProductVariationView.this);
                return;
            }
        }

        private a()
        {
            this$0 = ProductVariationView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(GridItem griditem);

        public abstract void a(ListItem listitem, GridItem griditem);
    }

    class c extends e
    {

        private List mListItemList;
        private int mSelectedPos;
        final ProductVariationView this$0;

        private View a(int k, ViewGroup viewgroup)
        {
            viewgroup = LayoutInflater.from(getContext()).inflate(0x7f0301bc, viewgroup, false);
            TextView textview = (TextView)viewgroup.findViewById(0x7f100525);
            ListItem listitem = (ListItem)getItem(k);
            a(textview, listitem, k);
            a(textview, listitem);
            return viewgroup;
        }

        private void a(TextView textview, ListItem listitem)
        {
            if (b(listitem))
            {
                listitem = getResources().getString(0x7f09048d, new Object[] {
                    listitem.b()
                });
                textview.setTextColor(getResources().getColor(0x7f0f00e4));
            } else
            {
                listitem = listitem.b();
                textview.setTextColor(getResources().getColor(0x7f0f00f3));
            }
            textview.setContentDescription(listitem);
        }

        private void a(TextView textview, ListItem listitem, int k)
        {
            textview.setText(listitem.b());
            if (mSelectedPos == k)
            {
                listitem = ah.a(getContext(), com.target.ui.util.ah.a.MEDIUM);
            } else
            {
                listitem = ah.a(getContext(), com.target.ui.util.ah.a.LIGHT);
            }
            textview.setTypeface(listitem);
        }

        private View b(int k, ViewGroup viewgroup)
        {
            viewgroup = LayoutInflater.from(getContext()).inflate(0x7f0301bb, viewgroup, false);
            TextView textview = (TextView)viewgroup.findViewById(0x7f100524);
            ListItem listitem = (ListItem)getItem(k);
            a(textview, listitem, k);
            a(textview, listitem);
            return viewgroup;
        }

        private boolean b(ListItem listitem)
        {
            if (ProductVariationView.a(ProductVariationView.this) != null)
            {
                if ((listitem = (Boolean)ProductVariationView.a(ProductVariationView.this).d().get(new h(listitem, ProductVariationView.b(ProductVariationView.this)))) != null)
                {
                    boolean flag;
                    if (!listitem.booleanValue())
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

        public int a(ListItem listitem)
        {
            if (listitem != null && mListItemList != null) goto _L2; else goto _L1
_L1:
            int l = -1;
_L4:
            return l;
_L2:
            int k = 0;
label0:
            do
            {
label1:
                {
                    if (k >= mListItemList.size())
                    {
                        break label1;
                    }
                    l = k;
                    if (listitem.equals(mListItemList.get(k)))
                    {
                        break label0;
                    }
                    k++;
                }
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
            return -1;
        }

        public void a(int k)
        {
            mSelectedPos = k;
            notifyDataSetChanged();
        }

        public void a(List list)
        {
            clear();
            addAll(list);
            mListItemList = list;
            notifyDataSetChanged();
        }

        public View getDropDownView(int k, View view, ViewGroup viewgroup)
        {
            return b(k, viewgroup);
        }

        public View getView(int k, View view, ViewGroup viewgroup)
        {
            return a(k, viewgroup);
        }

        public c(Context context, List list)
        {
            this$0 = ProductVariationView.this;
            super(context, list);
            mSelectedPos = -1;
            mListItemList = list;
            setNotifyOnChange(false);
        }
    }

    private class d
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final ProductVariationView this$0;

        public void onItemSelected(AdapterView adapterview, View view, int k, long l)
        {
            if (ProductVariationView.d(ProductVariationView.this))
            {
                ProductVariationView.a(ProductVariationView.this, false);
                return;
            }
            adapterview = (ListItem)((c)com.target.ui.view.product.ProductVariationView.e(ProductVariationView.this).dropDown.getAdapter()).getItem(k);
            view = getResources().getString(0x7f090490);
            if (adapterview.b().contains(view))
            {
                ProductVariationView.a(ProductVariationView.this, null);
                ProductVariationView.f(ProductVariationView.this).a(-1);
                ProductVariationView.g(ProductVariationView.this);
            } else
            {
                ProductVariationView.f(ProductVariationView.this).a(k);
                ProductVariationView.b(ProductVariationView.this, adapterview);
            }
            ProductVariationView.c(ProductVariationView.this, ProductVariationView.c(ProductVariationView.this));
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        private d()
        {
            this$0 = ProductVariationView.this;
            super();
        }

    }


    private static final int DEFAULT_VALUE = -1;
    private c mDropdownAdapter;
    private ProductVariationGridAdapter mGridViewAdapter;
    private boolean mIsFistPass;
    private b mListener;
    private GridItem mSelectedGridItem;
    private ListItem mSelectedListItem;
    private ProductVariationModel mVariationModel;
    private Views mViews;

    public ProductVariationView(Context context)
    {
        super(context);
        b();
    }

    public ProductVariationView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public ProductVariationView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        b();
    }

    static ListItem a(ProductVariationView productvariationview, ListItem listitem)
    {
        productvariationview.mSelectedListItem = listitem;
        return listitem;
    }

    static ProductVariationModel a(ProductVariationView productvariationview)
    {
        return productvariationview.mVariationModel;
    }

    private List a(String s, List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(0, new ListItem(s.toLowerCase(), s.toLowerCase()));
            arraylist.addAll(list);
            return arraylist;
        }
    }

    private void a(GridItem griditem)
    {
        if (mVariationModel == null)
        {
            return;
        } else
        {
            mSelectedGridItem = griditem;
            mDropdownAdapter.notifyDataSetChanged();
            e();
            f();
            return;
        }
    }

    private void a(ListItem listitem)
    {
        if (mVariationModel == null)
        {
            return;
        } else
        {
            mSelectedListItem = listitem;
            mGridViewAdapter.notifyDataSetChanged();
            f();
            return;
        }
    }

    static void a(ProductVariationView productvariationview, GridItem griditem)
    {
        productvariationview.a(griditem);
    }

    static boolean a(ProductVariationView productvariationview, boolean flag)
    {
        productvariationview.mIsFistPass = flag;
        return flag;
    }

    static GridItem b(ProductVariationView productvariationview)
    {
        return productvariationview.mSelectedGridItem;
    }

    private void b()
    {
        inflate(getContext(), 0x7f030204, this);
        mViews = new Views(this);
        mDropdownAdapter = new c(getContext(), new ArrayList());
        mGridViewAdapter = new ProductVariationGridAdapter(getContext(), new ArrayList());
        mViews.dropDown.setAdapter(mDropdownAdapter);
        mViews.gridView.setAdapter(mGridViewAdapter);
        c();
        mIsFistPass = true;
    }

    private void b(GridItem griditem)
    {
        mVariationModel.a(griditem);
    }

    private void b(ListItem listitem)
    {
        mVariationModel.a(listitem);
    }

    private void b(ProductVariationModel productvariationmodel)
    {
        e(productvariationmodel);
        f(productvariationmodel);
    }

    static void b(ProductVariationView productvariationview, GridItem griditem)
    {
        productvariationview.b(griditem);
    }

    static void b(ProductVariationView productvariationview, ListItem listitem)
    {
        productvariationview.a(listitem);
    }

    static GridItem c(ProductVariationView productvariationview, GridItem griditem)
    {
        productvariationview.mSelectedGridItem = griditem;
        return griditem;
    }

    static ListItem c(ProductVariationView productvariationview)
    {
        return productvariationview.mSelectedListItem;
    }

    private void c()
    {
        mViews.dropDown.setOnItemSelectedListener(new d());
        mViews.gridView.setOnItemClickListener(new a());
    }

    private void c(ProductVariationModel productvariationmodel)
    {
        e(productvariationmodel);
        al.a(new View[] {
            mViews.gridView, mViews.gridViewBottomDiv
        });
    }

    static void c(ProductVariationView productvariationview, ListItem listitem)
    {
        productvariationview.b(listitem);
    }

    private void d()
    {
        mViews.dropDown.setOnItemSelectedListener(null);
        mViews.gridView.setOnItemClickListener(null);
    }

    private void d(ProductVariationModel productvariationmodel)
    {
        f(productvariationmodel);
        al.a(new View[] {
            mViews.dropDown, mViews.dropDownTopDiv, mViews.dropDownBottomDiv
        });
    }

    static boolean d(ProductVariationView productvariationview)
    {
        return productvariationview.mIsFistPass;
    }

    static Views e(ProductVariationView productvariationview)
    {
        return productvariationview.mViews;
    }

    private void e()
    {
        while (mListener == null || !h()) 
        {
            return;
        }
        mListener.a(mSelectedGridItem);
    }

    private void e(ProductVariationModel productvariationmodel)
    {
        StringBuffer stringbuffer = new StringBuffer(getResources().getString(0x7f090490));
        stringbuffer.append(" ");
        stringbuffer.append(productvariationmodel.e());
        mDropdownAdapter.a(a(stringbuffer.toString(), productvariationmodel.b()));
        productvariationmodel = productvariationmodel.f();
        if (productvariationmodel != null)
        {
            mSelectedListItem = productvariationmodel;
            int k = mDropdownAdapter.a(productvariationmodel);
            mDropdownAdapter.a(k);
            mViews.dropDown.setSelection(k);
        }
        al.b(new View[] {
            mViews.dropDown, mViews.dropDownTopDiv, mViews.dropDownBottomDiv
        });
    }

    static c f(ProductVariationView productvariationview)
    {
        return productvariationview.mDropdownAdapter;
    }

    private void f()
    {
        while (mListener == null || !i()) 
        {
            return;
        }
        mListener.a(mSelectedListItem, mSelectedGridItem);
    }

    private void f(ProductVariationModel productvariationmodel)
    {
        mGridViewAdapter.a(productvariationmodel.c());
        productvariationmodel = productvariationmodel.g();
        if (productvariationmodel != null)
        {
            mSelectedGridItem = productvariationmodel;
            int k = mGridViewAdapter.a(productvariationmodel);
            mGridViewAdapter.a(k);
        }
        al.b(new View[] {
            mViews.gridView, mViews.gridViewBottomDiv
        });
    }

    private void g()
    {
        while (mListener == null || !j()) 
        {
            return;
        }
        mListener.a();
        mDropdownAdapter.notifyDataSetChanged();
        mGridViewAdapter.notifyDataSetChanged();
    }

    static void g(ProductVariationView productvariationview)
    {
        productvariationview.g();
    }

    private boolean h()
    {
        if (!mVariationModel.a().equals(com.target.ui.model.product.ProductVariationModel.a.TWO_DIMENSION))
        {
            return false;
        }
        if (i())
        {
            Boolean boolean1 = (Boolean)mVariationModel.d().get(new h(mSelectedListItem, mSelectedGridItem));
            boolean flag;
            if (boolean1 == null)
            {
                flag = false;
            } else
            if (!boolean1.booleanValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        } else
        {
            return true;
        }
    }

    private boolean i()
    {
        boolean flag = true;
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[];

            static 
            {
                $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType = new int[com.target.ui.model.product.ProductVariationModel.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product.ProductVariationModel.a.SINGLE_DIMENSION_LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product.ProductVariationModel.a.SINGLE_DIMENSION_GRID.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product.ProductVariationModel.a.TWO_DIMENSION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.model.product.ProductVariationModel.VariationType[mVariationModel.a().ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 48
    //                   2 57
    //                   3 66;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L6:
        return flag;
_L2:
        if (mSelectedListItem == null)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (mSelectedGridItem == null)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mSelectedListItem == null || mSelectedGridItem == null)
        {
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean j()
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = false;
        _cls1..SwitchMap.com.target.ui.model.product.ProductVariationModel.VariationType[mVariationModel.a().ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 48
    //                   2 57
    //                   3 66;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L6:
        return flag;
_L2:
        if (mSelectedListItem == null) goto _L6; else goto _L5
_L5:
        return false;
_L3:
        if (mSelectedGridItem == null) goto _L6; else goto _L7
_L7:
        return false;
_L4:
        if (mSelectedListItem == null) goto _L9; else goto _L8
_L8:
        flag = flag1;
        if (mSelectedGridItem != null) goto _L10; else goto _L9
_L9:
        flag = true;
_L10:
        return flag;
    }

    public void a()
    {
        d();
    }

    public void a(ProductVariationModel productvariationmodel)
    {
        if (productvariationmodel == null)
        {
            return;
        }
        mVariationModel = productvariationmodel;
        switch (_cls1..SwitchMap.com.target.ui.model.product.ProductVariationModel.VariationType[productvariationmodel.a().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            c(productvariationmodel);
            return;

        case 2: // '\002'
            d(productvariationmodel);
            return;

        case 3: // '\003'
            b(productvariationmodel);
            break;
        }
    }

    public void setClickListener(b b1)
    {
        mListener = b1;
    }
}

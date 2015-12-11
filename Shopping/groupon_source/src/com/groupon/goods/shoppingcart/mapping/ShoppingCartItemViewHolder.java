// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.mapping;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.goods.shoppingcart.ShoppingCartItemPresenter;
import com.groupon.goods.shoppingcart.ShoppingCartItemView;
import com.groupon.models.shoppingCart.ShoppingCartItem;
import com.groupon.util.HumanReadableCountdownFormatC;
import com.groupon.util.ImageUrl;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.view.UrlImageView;
import com.squareup.otto.Bus;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class ShoppingCartItemViewHolder extends GrouponViewHolder
    implements ShoppingCartItemView
{
    private class OnQuantityItemSelectedListener
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        private final ShoppingCartItem item;
        private final int itemPosition;
        final ShoppingCartItemViewHolder this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (Integer)adapterview.getAdapter().getItem(i);
            presenter.onQuantitySelected(item, adapterview.intValue(), itemPosition);
        }

        public void onNothingSelected(AdapterView adapterview)
        {
            presenter.onQuantitySelected(item, 0, itemPosition);
        }

        public OnQuantityItemSelectedListener(ShoppingCartItem shoppingcartitem, int i)
        {
            this$0 = ShoppingCartItemViewHolder.this;
            super();
            item = shoppingcartitem;
            itemPosition = i;
        }
    }

    private static class QuantityAdapter extends ArrayAdapter
    {

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            view = (TextView)super.getDropDownView(i, view, viewgroup);
            if (((Integer)getItem(i)).intValue() == 0)
            {
                view.setText(getContext().getString(0x7f080314));
            }
            return view;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            view = (TextView)super.getView(i, view, viewgroup);
            viewgroup = (Integer)getItem(i);
            view.setText(getContext().getString(0x7f08009f, new Object[] {
                viewgroup
            }));
            return view;
        }

        public QuantityAdapter(Context context, int i, List list)
        {
            super(context, i, list);
        }
    }


    Bus bus;
    private final UrlImageView imageView;
    private final ShoppingCartItemPresenter presenter;
    private final TextView pricesView;
    private final Spinner quantitySpinner;
    private final View quantityView;
    private final Button removeButton;
    private final Resources resources;
    HumanReadableCountdownFormatC timeLeftFormat;
    private final TextView timeLeftView;
    private final TextView titleView;

    public ShoppingCartItemViewHolder(View view)
    {
        super(view);
        RoboGuice.getInjector(view.getContext()).injectMembers(this);
        presenter = new ShoppingCartItemPresenter(this, timeLeftFormat, bus);
        titleView = (TextView)ButterKnife.findById(view, 0x7f10007a);
        imageView = (UrlImageView)ButterKnife.findById(view, 0x7f100076);
        pricesView = (TextView)ButterKnife.findById(view, 0x7f1003d0);
        quantityView = ButterKnife.findById(view, 0x7f1003d1);
        quantitySpinner = (Spinner)ButterKnife.findById(view, 0x7f1003d2);
        removeButton = (Button)ButterKnife.findById(view, 0x7f100120);
        timeLeftView = (TextView)ButterKnife.findById(view, 0x7f10023e);
        resources = view.getResources();
    }

    public void bind(final int itemPosition, final ShoppingCartItem item, boolean flag)
    {
        presenter.setItem(item, flag);
        quantitySpinner.setOnItemSelectedListener(new OnQuantityItemSelectedListener(item, itemPosition));
        itemView.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final ShoppingCartItemViewHolder this$0;
            final ShoppingCartItem val$item;

            public boolean onLongClick(View view)
            {
                presenter.onToggleEditMode(item);
                return true;
            }

            
            {
                this$0 = ShoppingCartItemViewHolder.this;
                item = shoppingcartitem;
                super();
            }
        });
        removeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShoppingCartItemViewHolder this$0;
            final ShoppingCartItem val$item;
            final int val$itemPosition;

            public void onClick(View view)
            {
                presenter.onQuantitySelected(item, 0, itemPosition);
            }

            
            {
                this$0 = ShoppingCartItemViewHolder.this;
                item = shoppingcartitem;
                itemPosition = i;
                super();
            }
        });
    }

    public void setImage(String s)
    {
        imageView.setImageUrl(new ImageUrl(s));
    }

    public void setPrices(String s, String s1)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (Strings.notEmpty(s))
        {
            spannablestringbuilder.append(s);
            spannablestringbuilder.setSpan(new StrikethroughSpan(), 0, spannablestringbuilder.length(), 33);
            spannablestringbuilder.append(" ");
            spannablestringbuilder.setSpan(new AbsoluteSizeSpan(resources.getDimensionPixelSize(0x7f0b009b)), 0, spannablestringbuilder.length(), 33);
            spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0e00f4)), 0, spannablestringbuilder.length(), 33);
            spannablestringbuilder.setSpan(new TypefaceSpan(resources.getString(0x7f080511)), 0, spannablestringbuilder.length(), 33);
        }
        if (Strings.notEmpty(s1))
        {
            int i = spannablestringbuilder.length();
            spannablestringbuilder.append(s1);
            spannablestringbuilder.setSpan(new AbsoluteSizeSpan(resources.getDimensionPixelSize(0x7f0b0099)), i, spannablestringbuilder.length(), 33);
            spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0e0004)), i, spannablestringbuilder.length(), 33);
            spannablestringbuilder.setSpan(new TypefaceSpan(resources.getString(0x7f080511)), 0, spannablestringbuilder.length(), 33);
        }
        pricesView.setText(spannablestringbuilder);
    }

    public void setQuantity(int i, List list)
    {
        QuantityAdapter quantityadapter = new QuantityAdapter(itemView.getContext(), 0x7f030208, list);
        quantitySpinner.setAdapter(quantityadapter);
        quantitySpinner.setSelection(list.indexOf(Integer.valueOf(i)));
    }

    public void setTimeLeft(String s)
    {
        timeLeftView.setText(s);
    }

    public void setTitle(String s)
    {
        titleView.setText(s);
    }

    public void showQuantity(boolean flag)
    {
        View view = quantityView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void showRemove(boolean flag)
    {
        Button button = removeButton;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        button.setVisibility(i);
    }

    public void showSoldOut()
    {
        setTimeLeft(resources.getString(0x7f080098));
        showTimeLeft(true);
    }

    public void showTimeLeft(boolean flag)
    {
        TextView textview = timeLeftView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        textview.setVisibility(i);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.mapping;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.models.shoppingCart.ShoppingCartCustomField;
import roboguice.util.Strings;

public class ShoppingCartCustomFieldViewHolder
{

    private final TextView labelText;
    private final Resources resources;
    private final TextView valueText;

    public ShoppingCartCustomFieldViewHolder(View view)
    {
        labelText = (TextView)ButterKnife.findById(view, 0x7f1002d3);
        valueText = (TextView)ButterKnife.findById(view, 0x7f100249);
        resources = view.getResources();
    }

    public void bind(ShoppingCartCustomField shoppingcartcustomfield, String s)
    {
        labelText.setText(shoppingcartcustomfield.label);
        if (shoppingcartcustomfield.required && Strings.isEmpty(s))
        {
            valueText.setText(0x7f0800a1);
            valueText.setTextColor(resources.getColor(0x7f0e0145));
            return;
        } else
        {
            valueText.setText(s);
            valueText.setTextColor(resources.getColor(0x7f0e00d7));
            return;
        }
    }
}

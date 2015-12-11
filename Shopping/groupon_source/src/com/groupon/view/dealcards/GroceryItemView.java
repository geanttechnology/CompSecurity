// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.db.models.SnapGroceryDetail;
import com.groupon.view.UrlImageView;

public class GroceryItemView extends CardView
{

    TextView cashBack;
    UrlImageView imageView;
    TextView titleLabel;

    public GroceryItemView(Context context)
    {
        super(context, null, 0);
    }

    public GroceryItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0);
    }

    public GroceryItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setGroceryDetail(SnapGroceryDetail snapgrocerydetail)
    {
        if (snapgrocerydetail.productName != null)
        {
            titleLabel.setText(snapgrocerydetail.productName);
        }
        imageView.setImageUrl(snapgrocerydetail.imgPath);
        if (snapgrocerydetail.dateSoldOut != null)
        {
            cashBack.setText(getContext().getString(0x7f08005f));
            cashBack.setTextColor(getResources().getColor(0x7f0e00d7));
        } else
        {
            cashBack.setText((new StringBuilder()).append(snapgrocerydetail.cashBackPrefix).append(snapgrocerydetail.cashBack).append(" ").append(snapgrocerydetail.cashBackSuffix).toString());
        }
        setTag(0x7f100001, snapgrocerydetail);
    }
}

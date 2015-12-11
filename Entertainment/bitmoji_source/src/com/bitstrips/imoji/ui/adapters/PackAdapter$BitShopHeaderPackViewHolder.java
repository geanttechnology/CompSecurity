// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.bitstrips.imoji.models.BitshopPack;
import com.bitstrips.imoji.util.PicassoBorderTransformation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            PackAdapter

public static class headerLayout extends headerLayout
{

    private static final int HEADER_RADIUS = 40;
    FrameLayout headerLayout;
    TextView headerPrice;
    int horizontalPadding;
    int imojiPrimaryColor;
    ImageView packHanger;
    int priceColor;
    int verticalPadding;

    private void markAsPurchased()
    {
        headerPrice.setEnabled(false);
        headerPrice.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        headerPrice.setText(0x7f060034);
        headerPrice.setTextColor(imojiPrimaryColor);
    }

    private void markAsUnpurchasedWithPrice(String s)
    {
        headerPrice.setEnabled(true);
        headerPrice.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        if (s == null)
        {
            headerPrice.setText(0x7f060032);
        } else
        {
            headerPrice.setText(s);
        }
        headerPrice.setTextColor(priceColor);
    }

    public void setBackground(String s)
    {
        Picasso.with(mHeaderTopImage.getContext()).load(s).placeholder(new ColorDrawable(mItem.mItem().getBgColor())).transform(new PicassoBorderTransformation(40)).into(mHeaderBottomImage);
    }



    public (View view)
    {
        super(view);
        ButterKnife.bind(this, view);
        headerLayout.setBackground(null);
    }
}

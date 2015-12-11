// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.poshmark.utils.ViewUtils;

public class PMPriceView extends View
{

    String listingPrice;
    String originalPrice;
    Paint paint;

    public PMPriceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        originalPrice = "$2000";
        listingPrice = "$3000";
        paint = new Paint(1);
        initInternal();
    }

    private void initInternal()
    {
        int i = getResources().getColor(0x7f090040);
        paint.setColor(i);
        float f = ViewUtils.dipToPixels(getContext(), 22F);
        paint.setTextSize(f);
        paint.setAntiAlias(true);
        paint.setFlags(1);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.getWidth();
    }

    public void setListingPrice(String s)
    {
        listingPrice = s;
    }

    public void setOriginalPrice(String s)
    {
        originalPrice = s;
    }
}

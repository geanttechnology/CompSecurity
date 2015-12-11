// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.util.o;
import com.target.mothership.util.p;
import com.target.ui.model.pi_blackfriday_deals.PiBlackFridayDeal;
import com.target.ui.util.ac;
import com.target.ui.util.al;
import com.target.ui.view.b.a;

public class BlackFridayDealView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        TextView dealLocation;
        TextView dealTitle;
        ImageView imageView;

        public Views(View view)
        {
            super(view);
        }
    }


    public static final float ASPECT_RATIO = 0.8F;
    private int mApproximateCardHeight;
    private Point mMeasureSpec;
    private a mMeasurer;
    private Views mViews;

    public BlackFridayDealView(Context context)
    {
        super(context);
        mMeasureSpec = new Point();
        a();
    }

    public BlackFridayDealView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMeasureSpec = new Point();
        a();
    }

    public BlackFridayDealView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMeasureSpec = new Point();
        a();
    }

    private void a()
    {
        mMeasurer = new a(0.80000001192092896D);
        inflate(getContext(), getLayoutResource(), this);
        mViews = new Views(this);
        mApproximateCardHeight = ac.a(getContext());
    }

    private void a(ImageView imageview, String s)
    {
        if (o.g(s))
        {
            u.a(getContext()).a(s).a(imageview);
            return;
        } else
        {
            u.a(getContext()).a(0x7f0201ae).a(imageview);
            return;
        }
    }

    protected Point a(int i, int j)
    {
        mMeasurer.a(i, j);
        j = mMeasurer.a();
        i = mMeasurer.b();
        j = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
        i = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        mMeasureSpec.set(j, i);
        return mMeasureSpec;
    }

    protected int getLayoutResource()
    {
        return 0x7f030169;
    }

    protected void onMeasure(int i, int j)
    {
        Point point = a(i, j);
        super.onMeasure(point.x, point.y);
    }

    public void setBlackFridayAdDetails(String s)
    {
        al.c(mViews.dealLocation);
        mViews.dealTitle.setGravity(17);
        mViews.dealTitle.setText(getResources().getString(0x7f090506));
        a(mViews.imageView, s);
    }

    public void setDealDetails(PiBlackFridayDeal piblackfridaydeal)
    {
        mViews.dealLocation.setText(piblackfridaydeal.a());
        mViews.dealTitle.setText(piblackfridaydeal.b());
        piblackfridaydeal = p.a(piblackfridaydeal.d(), mApproximateCardHeight);
        a(mViews.imageView, piblackfridaydeal);
    }
}

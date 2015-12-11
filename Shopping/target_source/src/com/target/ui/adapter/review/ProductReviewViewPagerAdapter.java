// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.review;

import android.content.Context;
import android.support.v4.view.ac;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.model.bazaar_voice.interfaces.ProductSecondaryReview;
import com.target.ui.view.StarRatingView;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ProductReviewViewPagerAdapter extends ac
{

    private static final float PAGE_WIDTH = 1F;
    private final LayoutInflater mLayoutInflater;
    private List mReviewsList;

    public ProductReviewViewPagerAdapter(Context context)
    {
        mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        mReviewsList = Collections.emptyList();
    }

    public Object a(ViewGroup viewgroup, int i)
    {
        View view = mLayoutInflater.inflate(0x7f0301b9, viewgroup, false);
        ((StarRatingView)view.findViewById(0x7f10051c)).setRating(((ProductSecondaryReview)mReviewsList.get(i)).a().floatValue());
        ((TextView)view.findViewById(0x7f10051d)).setText(((ProductSecondaryReview)mReviewsList.get(i)).b());
        viewgroup.addView(view);
        return view;
    }

    public void a(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((LinearLayout)obj);
    }

    public void a(List list)
    {
        mReviewsList = list;
        c();
    }

    public boolean a(View view, Object obj)
    {
        return view == obj;
    }

    public int b()
    {
        return mReviewsList.size();
    }

    public float d(int i)
    {
        return 1.0F;
    }
}

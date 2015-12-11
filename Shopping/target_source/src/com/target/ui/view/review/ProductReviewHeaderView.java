// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.review;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.mothership.model.bazaar_voice.interfaces.ProductSecondaryReview;
import com.target.ui.adapter.review.ProductReviewViewPagerAdapter;
import com.target.ui.view.common.ViewPagerIndicator;
import java.util.List;

public class ProductReviewHeaderView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        ViewPagerIndicator indicator;
        ViewPager viewPages;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.support.v4.view.ViewPager.f
    {

        final ProductReviewHeaderView this$0;

        public void a(int i)
        {
            ProductReviewHeaderView.a(ProductReviewHeaderView.this).indicator.a(i);
            ProductReviewHeaderView.a(ProductReviewHeaderView.this).indicator.setContentDescription(((ProductSecondaryReview)ProductReviewHeaderView.b(ProductReviewHeaderView.this).get(i)).b());
        }

        public void a(int i, float f, int j)
        {
        }

        public void b(int i)
        {
        }

        private a()
        {
            this$0 = ProductReviewHeaderView.this;
            super();
        }

    }


    private static final int DEFAULT_INDEX = 0;
    private static final int OFF_PAGE_LIMIT = 2;
    public static final String TAG = com/target/ui/view/review/ProductReviewHeaderView.getSimpleName();
    private ProductReviewViewPagerAdapter mAdapter;
    private List mReviewData;
    private Views mViews;

    public ProductReviewHeaderView(Context context)
    {
        super(context);
        a();
    }

    public ProductReviewHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ProductReviewHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static Views a(ProductReviewHeaderView productreviewheaderview)
    {
        return productreviewheaderview.mViews;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301b8, this);
        mViews = new Views(this);
        b();
    }

    static List b(ProductReviewHeaderView productreviewheaderview)
    {
        return productreviewheaderview.mReviewData;
    }

    private void b()
    {
        mAdapter = new ProductReviewViewPagerAdapter(getContext());
        mViews.viewPages.setAdapter(mAdapter);
        mViews.viewPages.setOffscreenPageLimit(2);
        mViews.viewPages.setOnPageChangeListener(new a());
    }

    public void setData(List list)
    {
        mReviewData = list;
        mAdapter.a(mReviewData);
        mViews.indicator.setPageCount(mReviewData.size());
        if (!mReviewData.isEmpty())
        {
            mViews.indicator.setContentDescription(((ProductSecondaryReview)mReviewData.get(0)).b());
        }
    }

}

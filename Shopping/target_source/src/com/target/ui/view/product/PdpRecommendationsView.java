// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.ui.adapter.product.d;
import com.target.ui.view.BitmapImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PdpRecommendationsView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        RecyclerView recommendations;
        TextView title;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(BitmapImageView bitmapimageview, ProductDetails productdetails);
    }

    private class b
        implements com.target.ui.adapter.product.d.a
    {

        final PdpRecommendationsView this$0;

        public void a(BitmapImageView bitmapimageview, ProductDetails productdetails)
        {
            if (PdpRecommendationsView.a(PdpRecommendationsView.this) == null)
            {
                return;
            } else
            {
                PdpRecommendationsView.a(PdpRecommendationsView.this).a(bitmapimageview, productdetails);
                return;
            }
        }

        private b()
        {
            this$0 = PdpRecommendationsView.this;
            super();
        }

    }


    private d mAdapter;
    private a mListener;
    private List mRecommendationsItems;
    private Views mViews;

    public PdpRecommendationsView(Context context)
    {
        super(context);
        mRecommendationsItems = new ArrayList();
        a();
    }

    public PdpRecommendationsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mRecommendationsItems = new ArrayList();
        a();
    }

    public PdpRecommendationsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mRecommendationsItems = new ArrayList();
        a();
    }

    static a a(PdpRecommendationsView pdprecommendationsview)
    {
        return pdprecommendationsview.mListener;
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f030193, this);
        mViews = new Views(this);
        b();
    }

    private void b()
    {
        LinearLayoutManager linearlayoutmanager = new LinearLayoutManager(getContext(), 0, false);
        mAdapter = new d(mRecommendationsItems);
        mAdapter.a(new b());
        mViews.recommendations.setLayoutManager(linearlayoutmanager);
        mViews.recommendations.setAdapter(mAdapter);
        mViews.recommendations.setHasFixedSize(true);
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setHeader(String s)
    {
        mViews.title.setText(s);
    }

    public void setRecommendations(ProductRecommendations productrecommendations)
    {
        mRecommendationsItems.clear();
        ProductDetails productdetails;
        for (productrecommendations = productrecommendations.a().iterator(); productrecommendations.hasNext(); mRecommendationsItems.add(productdetails))
        {
            productdetails = (ProductDetails)productrecommendations.next();
        }

        mAdapter.d();
    }
}

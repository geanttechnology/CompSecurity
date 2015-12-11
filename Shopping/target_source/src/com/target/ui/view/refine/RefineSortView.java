// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.a.a.e;
import com.target.ui.model.refine.ProductSortModel;
import com.target.ui.view.product.FixedHeightListView;
import com.target.ui.view.refine.a.b;
import java.util.ArrayList;

// Referenced classes of package com.target.ui.view.refine:
//            BaseRefineView, RefineCategoryView

public class RefineSortView extends BaseRefineView
{
    static class Views extends com.target.ui.view.a
    {

        FixedHeightListView listView;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel);

        public abstract void b(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel);
    }

    private class b
        implements com.target.ui.view.refine.a.b.a
    {

        final RefineSortView this$0;

        public void a(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
        {
            if (RefineSortView.a(RefineSortView.this) != null)
            {
                RefineSortView.a(RefineSortView.this).a(sortlabel);
            }
        }

        public void b(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
        {
            if (RefineSortView.a(RefineSortView.this) != null)
            {
                RefineSortView.a(RefineSortView.this).b(sortlabel);
            }
        }

        private b()
        {
            this$0 = RefineSortView.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/view/refine/RefineCategoryView.getSimpleName();
    private com.target.ui.view.refine.a.b mAdapter;
    private boolean mIsPreSelected;
    private a mListener;
    private ProductSortModel mSortModel;
    private Views mViews;

    public RefineSortView(Context context)
    {
        super(context);
        c();
    }

    public RefineSortView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public RefineSortView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    static a a(RefineSortView refinesortview)
    {
        return refinesortview.mListener;
    }

    private void c()
    {
        inflate(getContext(), 0x7f0301c9, this);
        mViews = new Views(this);
        mAdapter = new com.target.ui.view.refine.a.b(getContext(), new ArrayList());
        mAdapter.a(new b());
        mViews.listView.setAdapter(mAdapter);
    }

    public void a()
    {
        if (mSortModel == null)
        {
            return;
        } else
        {
            mSortModel.b();
            mIsPreSelected = mSortModel.c().b();
            mAdapter.a();
            return;
        }
    }

    protected boolean b()
    {
        return mIsPreSelected;
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setData(ProductSortModel productsortmodel)
    {
        if (productsortmodel == null)
        {
            return;
        } else
        {
            mSortModel = productsortmodel;
            mIsPreSelected = productsortmodel.c().b();
            mAdapter.a(productsortmodel.a(), (com.target.ui.model.refine.ProductSortModel.SortLabel)productsortmodel.c().d());
            return;
        }
    }

}

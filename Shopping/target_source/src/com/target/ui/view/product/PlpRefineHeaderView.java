// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.b.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.ui.view.ConfigurableDropShadowView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            FacetTokenView

public class PlpRefineHeaderView extends RelativeLayout
{
    static class Views extends com.target.ui.view.a
    {

        ConfigurableDropShadowView dropShadow;
        RecyclerView recyclerView;
        View refineButton;
        TextView resultCount;
        View selectedFacetWrapper;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(ProductEntry productentry);
    }

    public static class b
    {

        private int mResultCount;
        private List mSelectedFacetsList;

        public int a()
        {
            return mResultCount;
        }

        public List b()
        {
            return mSelectedFacetsList;
        }

        public b(int i, List list)
        {
            mResultCount = i;
            mSelectedFacetsList = list;
        }
    }

    private static class c extends android.support.v7.widget.RecyclerView.a
    {

        private a mOnSelectedFacetClickListener;
        private List mSelectedFacetsInternal;

        static a a(c c1)
        {
            return c1.mOnSelectedFacetClickListener;
        }

        public int a()
        {
            return mSelectedFacetsInternal.size();
        }

        public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
        {
            return c(viewgroup, i);
        }

        public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
        {
            a((b)t, i);
        }

        public void a(a a1)
        {
            mOnSelectedFacetClickListener = a1;
        }

        public void a(b b1, int i)
        {
            FacetTokenView facettokenview = (FacetTokenView)b1.itemView;
            ProductEntry productentry = (ProductEntry)mSelectedFacetsInternal.get(i);
            if (productentry.f())
            {
                b1 = productentry.d();
            } else
            {
                b1 = (String)productentry.c().d();
            }
            facettokenview.setFacetLabel(b1);
            facettokenview.setOnClickListener(productentry. new android.view.View.OnClickListener() {

                final c this$0;
                final ProductEntry val$productEntry;

                public void onClick(View view)
                {
                    if (c.a(c.this) == null)
                    {
                        return;
                    } else
                    {
                        c.a(c.this).a(productEntry);
                        return;
                    }
                }

            
            {
                this$0 = final_c1;
                productEntry = ProductEntry.this;
                super();
            }
            });
        }

        public b c(ViewGroup viewgroup, int i)
        {
            return new b(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030161, viewgroup, false));
        }

        public c(List list)
        {
            mSelectedFacetsInternal = new ArrayList();
            mSelectedFacetsInternal = list;
        }
    }

    public static interface c.a
    {

        public abstract void a(ProductEntry productentry);
    }

    public static class c.b extends android.support.v7.widget.RecyclerView.t
    {

        public c.b(View view)
        {
            super(view);
        }
    }


    private static final int SELECTED_FACET_ANIMATION_DURATION_MS = 200;
    private c mAdapter;
    private Animator mHeightAnimator;
    private a mListener;
    private List mSelectedFacets;
    private Views mViews;
    private int mWrapperHeight;

    public PlpRefineHeaderView(Context context)
    {
        super(context);
        mSelectedFacets = new ArrayList();
        b();
    }

    public PlpRefineHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSelectedFacets = new ArrayList();
        b();
    }

    public PlpRefineHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSelectedFacets = new ArrayList();
        b();
    }

    static a a(PlpRefineHeaderView plprefineheaderview)
    {
        return plprefineheaderview.mListener;
    }

    private void a(float f, boolean flag)
    {
        if (mAdapter.a() == 0)
        {
            return;
        }
        if (mHeightAnimator != null)
        {
            mHeightAnimator.cancel();
            mHeightAnimator = null;
        }
        if (!flag)
        {
            mViews.selectedFacetWrapper.setTranslationY(f);
            return;
        } else
        {
            mHeightAnimator = ObjectAnimator.ofFloat(mViews.selectedFacetWrapper, View.TRANSLATION_Y, new float[] {
                mViews.selectedFacetWrapper.getTranslationY(), f
            });
            mHeightAnimator.setDuration(200L);
            mHeightAnimator.setInterpolator(new android.support.v4.view.b.b());
            mHeightAnimator.start();
            return;
        }
    }

    private void b()
    {
        inflate(getContext(), 0x7f0301b0, this);
        mViews = new Views(this);
        mWrapperHeight = getContext().getResources().getDimensionPixelSize(0x7f0a027a);
        setDropShadowStrength(0.0F);
        mViews.refineButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PlpRefineHeaderView this$0;

            public void onClick(View view)
            {
                if (PlpRefineHeaderView.a(PlpRefineHeaderView.this) == null)
                {
                    return;
                } else
                {
                    PlpRefineHeaderView.a(PlpRefineHeaderView.this).a();
                    return;
                }
            }

            
            {
                this$0 = PlpRefineHeaderView.this;
                super();
            }
        });
        mAdapter = new c(mSelectedFacets);
        mAdapter.a(new c.a() {

            final PlpRefineHeaderView this$0;

            public void a(ProductEntry productentry)
            {
                if (PlpRefineHeaderView.a(PlpRefineHeaderView.this) == null)
                {
                    return;
                } else
                {
                    PlpRefineHeaderView.a(PlpRefineHeaderView.this).a(productentry);
                    return;
                }
            }

            
            {
                this$0 = PlpRefineHeaderView.this;
                super();
            }
        });
        LinearLayoutManager linearlayoutmanager = new LinearLayoutManager(getContext(), 0, false);
        mViews.recyclerView.setLayoutManager(linearlayoutmanager);
        mViews.recyclerView.setAdapter(mAdapter);
    }

    public void a()
    {
        float f = mViews.selectedFacetWrapper.getTranslationY();
        float f1 = mWrapperHeight;
        if (Float.compare(f, -f1 / 2.0F) < 0)
        {
            f = -f1;
        } else
        {
            f = 0.0F;
        }
        a(f, true);
    }

    public void a(float f)
    {
        float f1;
        float f2;
        f1 = 0.0F;
        f = mViews.selectedFacetWrapper.getTranslationY() + f;
        f2 = mWrapperHeight;
        if ((float)Float.compare(f, 0.0F) <= 0.0F) goto _L2; else goto _L1
_L1:
        f = f1;
_L4:
        a(f, false);
        return;
_L2:
        if ((float)Float.compare(f, -f2) < 0.0F)
        {
            f = -f2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(boolean flag)
    {
        a(0.0F, flag);
    }

    public void setData(b b1)
    {
        mViews.resultCount.setText(getResources().getQuantityString(0x7f110007, b1.a(), new Object[] {
            Integer.valueOf(b1.a())
        }));
        mSelectedFacets.clear();
        mSelectedFacets.addAll(b1.b());
        mAdapter.d();
        if (b1.b().isEmpty())
        {
            mViews.selectedFacetWrapper.setTranslationY(-mWrapperHeight);
        }
    }

    public void setDropShadowStrength(float f)
    {
        mViews.dropShadow.setStrength(f);
    }

    public void setOnItemClickListener(a a1)
    {
        mListener = a1;
    }
}

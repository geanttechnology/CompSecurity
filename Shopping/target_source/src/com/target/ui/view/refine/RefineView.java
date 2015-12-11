// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.model.refine.ProductSortModel;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.refine:
//            RefineColorView, RefinePriceView, RefineGenericView, RefineFacetsExpandView, 
//            RefineSortExpandView, RefineSortView, BaseRefineFacetsContainer

public class RefineView extends LinearLayout
{
    public static interface a
    {

        public abstract void a(ProductEntry productentry);

        public abstract void a(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel);

        public abstract void b(ProductEntry productentry);

        public abstract void b(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel);
    }

    private class b
        implements RefineFacetsExpandView.b
    {

        final RefineView this$0;

        public void a(ProductEntry productentry)
        {
            if (RefineView.a(RefineView.this) != null)
            {
                RefineView.a(RefineView.this).a(productentry);
            }
        }

        public void a(boolean flag)
        {
        }

        public void b(ProductEntry productentry)
        {
            if (RefineView.a(RefineView.this) != null)
            {
                RefineView.a(RefineView.this).b(productentry);
            }
        }

        private b()
        {
            this$0 = RefineView.this;
            super();
        }

    }

    private class c
        implements RefineSortExpandView.a
    {

        final RefineView this$0;

        public void a(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
        {
            if (RefineView.a(RefineView.this) != null)
            {
                RefineView.a(RefineView.this).a(sortlabel);
            }
        }

        public void a(boolean flag)
        {
        }

        public void b(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
        {
            if (RefineView.a(RefineView.this) != null)
            {
                RefineView.a(RefineView.this).b(sortlabel);
            }
        }

        private c()
        {
            this$0 = RefineView.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/view/refine/RefineView.getSimpleName();
    private a mListener;

    public RefineView(Context context)
    {
        super(context);
        a();
    }

    public RefineView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public RefineView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private BaseRefineFacetsContainer a(ProductRefineModel productrefinemodel, com.target.ui.model.refine.ProductRefineModel.b b1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$model$refine$ProductRefineModel$FacetType[];

            static 
            {
                $SwitchMap$com$target$ui$model$refine$ProductRefineModel$FacetType = new int[com.target.ui.model.refine.ProductRefineModel.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$model$refine$ProductRefineModel$FacetType[com.target.ui.model.refine.ProductRefineModel.a.COLOR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$model$refine$ProductRefineModel$FacetType[com.target.ui.model.refine.ProductRefineModel.a.PRICE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$model$refine$ProductRefineModel$FacetType[com.target.ui.model.refine.ProductRefineModel.a.CATEGORY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$model$refine$ProductRefineModel$FacetType[com.target.ui.model.refine.ProductRefineModel.a.OTHERS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        RefineGenericView refinegenericview;
        switch (_cls1..SwitchMap.com.target.ui.model.refine.ProductRefineModel.FacetType[b1.a().ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            RefineColorView refinecolorview = new RefineColorView(getContext());
            refinecolorview.a(productrefinemodel.a(b1), productrefinemodel.b(b1));
            return refinecolorview;

        case 2: // '\002'
            RefinePriceView refinepriceview = new RefinePriceView(getContext());
            refinepriceview.a(productrefinemodel.a(b1), productrefinemodel.b(b1));
            return refinepriceview;

        case 3: // '\003'
        case 4: // '\004'
            refinegenericview = new RefineGenericView(getContext());
            break;
        }
        refinegenericview.a(productrefinemodel.a(b1), productrefinemodel.b(b1));
        return refinegenericview;
    }

    static a a(RefineView refineview)
    {
        return refineview.mListener;
    }

    private void a()
    {
        setOrientation(1);
    }

    private void a(ProductRefineModel productrefinemodel)
    {
        RefineFacetsExpandView refinefacetsexpandview;
        for (Iterator iterator = productrefinemodel.c().iterator(); iterator.hasNext(); addView(refinefacetsexpandview))
        {
            com.target.ui.model.refine.ProductRefineModel.b b1 = (com.target.ui.model.refine.ProductRefineModel.b)iterator.next();
            refinefacetsexpandview = new RefineFacetsExpandView(getContext());
            refinefacetsexpandview.a(b1.b(), a(productrefinemodel, b1));
            refinefacetsexpandview.setClickListener(new b(null));
        }

    }

    private void a(ProductSortModel productsortmodel)
    {
        if (productsortmodel == null)
        {
            return;
        } else
        {
            RefineSortExpandView refinesortexpandview = new RefineSortExpandView(getContext());
            refinesortexpandview.setChildData(b(productsortmodel));
            refinesortexpandview.setClickListener(new c(null));
            addView(refinesortexpandview);
            return;
        }
    }

    private RefineSortView b(ProductSortModel productsortmodel)
    {
        RefineSortView refinesortview = new RefineSortView(getContext());
        refinesortview.setData(productsortmodel);
        return refinesortview;
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setData(ProductRefineModel productrefinemodel)
    {
        removeAllViews();
        a(productrefinemodel.b());
        a(productrefinemodel);
    }

}

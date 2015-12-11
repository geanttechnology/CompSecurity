// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;

// Referenced classes of package com.target.ui.view.product:
//            ProductVariationView

public class PdpVariationView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        ProductVariationView productVariationView;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(GridItem griditem);

        public abstract void a(ListItem listitem, GridItem griditem);
    }

    private class b
        implements ProductVariationView.b
    {

        final PdpVariationView this$0;

        public void a()
        {
            if (PdpVariationView.a(PdpVariationView.this) == null)
            {
                return;
            } else
            {
                PdpVariationView.a(PdpVariationView.this).a();
                return;
            }
        }

        public void a(GridItem griditem)
        {
            if (PdpVariationView.a(PdpVariationView.this) == null)
            {
                return;
            } else
            {
                PdpVariationView.a(PdpVariationView.this).a(griditem);
                return;
            }
        }

        public void a(ListItem listitem, GridItem griditem)
        {
            if (PdpVariationView.a(PdpVariationView.this) == null)
            {
                return;
            } else
            {
                PdpVariationView.a(PdpVariationView.this).a(listitem, griditem);
                return;
            }
        }

        private b()
        {
            this$0 = PdpVariationView.this;
            super();
        }

    }


    private a mListener;
    private Views mViews;

    public PdpVariationView(Context context)
    {
        super(context);
        a();
    }

    public PdpVariationView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public PdpVariationView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(PdpVariationView pdpvariationview)
    {
        return pdpvariationview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f030195, this);
        mViews = new Views(this);
        mViews.productVariationView.setClickListener(new b());
    }

    public void a(ProductVariationModel productvariationmodel)
    {
        mViews.productVariationView.a(productvariationmodel);
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}

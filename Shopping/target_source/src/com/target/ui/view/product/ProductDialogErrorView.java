// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.view.product:
//            ProductDialogZipCodeView

public class ProductDialogErrorView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        TargetErrorView errorView;
        ProductDialogZipCodeView zipCodeView;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.common.c
    {

        final ProductDialogErrorView this$0;

        public void A_()
        {
            if (ProductDialogErrorView.a(ProductDialogErrorView.this) == null || ProductDialogErrorView.b(ProductDialogErrorView.this) == null)
            {
                return;
            } else
            {
                ProductDialogErrorView.b(ProductDialogErrorView.this).a();
                return;
            }
        }

        private a()
        {
            this$0 = ProductDialogErrorView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(String s);
    }

    private class c
        implements ProductDialogZipCodeView.b
    {

        final ProductDialogErrorView this$0;

        public void a(String s)
        {
            if (ProductDialogErrorView.a(ProductDialogErrorView.this) == null || ProductDialogErrorView.b(ProductDialogErrorView.this) == null)
            {
                return;
            } else
            {
                ProductDialogErrorView.b(ProductDialogErrorView.this).a(s);
                return;
            }
        }

        private c()
        {
            this$0 = ProductDialogErrorView.this;
            super();
        }

    }


    private b mListener;
    private Views mViews;

    public ProductDialogErrorView(Context context)
    {
        super(context);
        a(context);
    }

    public ProductDialogErrorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public ProductDialogErrorView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static Views a(ProductDialogErrorView productdialogerrorview)
    {
        return productdialogerrorview.mViews;
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0301b1, this);
        mViews = new Views(this);
        mViews.errorView.setClickListener(new a());
        mViews.zipCodeView.setZipCodeListener(new c());
    }

    static b b(ProductDialogErrorView productdialogerrorview)
    {
        return productdialogerrorview.mListener;
    }

    public void a(String s, boolean flag)
    {
        mViews.errorView.a("", s, flag);
    }

    public void setClickListener(b b1)
    {
        mListener = b1;
    }

    public void setZipCode(String s)
    {
        mViews.zipCodeView.setZipCode(s);
    }
}

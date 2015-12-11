// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.view.ZipCodeChooserView;

public class ProductDialogZipCodeView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        ZipCodeChooserView zipCode;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.ZipCodeChooserView.d
    {

        final ProductDialogZipCodeView this$0;

        public void a(String s)
        {
            if (ProductDialogZipCodeView.a(ProductDialogZipCodeView.this) == null)
            {
                return;
            } else
            {
                ProductDialogZipCodeView.a(ProductDialogZipCodeView.this).a(s);
                return;
            }
        }

        private a()
        {
            this$0 = ProductDialogZipCodeView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(String s);
    }


    private b mListener;
    private Views mViews;

    public ProductDialogZipCodeView(Context context)
    {
        super(context);
        a();
    }

    public ProductDialogZipCodeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ProductDialogZipCodeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static b a(ProductDialogZipCodeView productdialogzipcodeview)
    {
        return productdialogzipcodeview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301c2, this);
        mViews = new Views(this);
        mViews.zipCode.setZipCodeListener(new a());
    }

    public void setZipCode(String s)
    {
        mViews.zipCode.setZipCode(s);
    }

    public void setZipCodeListener(b b1)
    {
        mListener = b1;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.target.mothership.util.o;

public class ProductAddToListFooter extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        EditText editText;
        RadioButton radioButton;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(boolean flag);
    }

    private class b
        implements android.view.View.OnFocusChangeListener
    {

        final ProductAddToListFooter this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (flag)
            {
                ProductAddToListFooter.b(ProductAddToListFooter.this).radioButton.setChecked(true);
            }
        }

        private b()
        {
            this$0 = ProductAddToListFooter.this;
            super();
        }

    }

    private class c
        implements TextWatcher
    {

        final ProductAddToListFooter this$0;

        public void afterTextChanged(Editable editable)
        {
            ProductAddToListFooter.a(ProductAddToListFooter.this, editable.toString());
            if (ProductAddToListFooter.a(ProductAddToListFooter.this) == null)
            {
                return;
            } else
            {
                ProductAddToListFooter.a(ProductAddToListFooter.this).a(o.g(ProductAddToListFooter.c(ProductAddToListFooter.this).trim()));
                return;
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private c()
        {
            this$0 = ProductAddToListFooter.this;
            super();
        }

    }

    private class d
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final ProductAddToListFooter this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            ProductAddToListFooter.a(ProductAddToListFooter.this, flag);
            if (flag)
            {
                if (ProductAddToListFooter.a(ProductAddToListFooter.this) != null)
                {
                    ProductAddToListFooter.a(ProductAddToListFooter.this).a();
                    ProductAddToListFooter.a(ProductAddToListFooter.this).a(o.g(ProductAddToListFooter.b(ProductAddToListFooter.this).editText.getText().toString()));
                }
                ProductAddToListFooter.b(ProductAddToListFooter.this).editText.requestFocus();
                com.target.ui.util.e.a.c(ProductAddToListFooter.b(ProductAddToListFooter.this).editText);
            }
        }

        private d()
        {
            this$0 = ProductAddToListFooter.this;
            super();
        }

    }


    private boolean mIsShoppingListSelected;
    private a mListener;
    private String mShoppingListTitle;
    private Views mViews;

    public ProductAddToListFooter(Context context)
    {
        super(context);
        b();
    }

    public ProductAddToListFooter(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public ProductAddToListFooter(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    static a a(ProductAddToListFooter productaddtolistfooter)
    {
        return productaddtolistfooter.mListener;
    }

    static String a(ProductAddToListFooter productaddtolistfooter, String s)
    {
        productaddtolistfooter.mShoppingListTitle = s;
        return s;
    }

    static boolean a(ProductAddToListFooter productaddtolistfooter, boolean flag)
    {
        productaddtolistfooter.mIsShoppingListSelected = flag;
        return flag;
    }

    static Views b(ProductAddToListFooter productaddtolistfooter)
    {
        return productaddtolistfooter.mViews;
    }

    private void b()
    {
        setOrientation(0);
        inflate(getContext(), 0x7f0300ff, this);
        mViews = new Views(this);
        c();
        d();
    }

    static String c(ProductAddToListFooter productaddtolistfooter)
    {
        return productaddtolistfooter.mShoppingListTitle;
    }

    private void c()
    {
        mShoppingListTitle = "";
        mIsShoppingListSelected = false;
    }

    private void d()
    {
        mViews.radioButton.setOnCheckedChangeListener(new d());
        mViews.editText.addTextChangedListener(new c());
        mViews.editText.setOnFocusChangeListener(new b());
    }

    public void a()
    {
        mShoppingListTitle = "";
        if (mViews != null)
        {
            mViews.radioButton.setChecked(false);
            mViews.editText.clearFocus();
        }
    }

    public String getShoppingListTitle()
    {
        return mShoppingListTitle;
    }

    public boolean isSelected()
    {
        return mIsShoppingListSelected;
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}

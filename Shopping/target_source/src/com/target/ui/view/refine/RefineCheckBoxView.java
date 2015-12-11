// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.ui.util.al;

public class RefineCheckBoxView extends LinearLayout
    implements android.widget.CompoundButton.OnCheckedChangeListener
{
    static class Views extends com.target.ui.view.a
    {

        CheckBox checkBox;
        TextView count;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(ProductEntry productentry);

        public abstract void b(ProductEntry productentry);
    }


    public static final String TAG = com/target/ui/view/refine/RefineCheckBoxView.getSimpleName();
    private a mListener;
    private ProductEntry mProductEntry;
    private Views mViews;

    public RefineCheckBoxView(Context context)
    {
        super(context);
        b();
    }

    public RefineCheckBoxView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public RefineCheckBoxView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    private void b()
    {
        inflate(getContext(), 0x7f0301cb, this);
        mViews = new Views(this);
        mViews.checkBox.setOnCheckedChangeListener(this);
    }

    public void a()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.checkBox.setChecked(false);
            return;
        }
    }

    public void a(ProductEntry productentry, boolean flag, boolean flag1)
    {
        if (mViews == null)
        {
            return;
        }
        mProductEntry = productentry;
        String s;
        if (productentry.f())
        {
            s = productentry.d();
        } else
        {
            s = (String)productentry.c().d();
        }
        mViews.checkBox.setChecked(flag);
        mViews.checkBox.setText(s);
        mViews.checkBox.setTag(productentry);
        mViews.checkBox.setOnCheckedChangeListener(this);
        if (flag1)
        {
            productentry = String.format(getResources().getString(0x7f090474), new Object[] {
                Integer.valueOf(productentry.a())
            });
            mViews.count.setText(productentry);
            al.b(mViews.count);
            return;
        } else
        {
            al.c(mViews.count);
            return;
        }
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (mListener == null)
        {
            return;
        }
        if (compoundbutton.isChecked())
        {
            mListener.a(mProductEntry);
            return;
        } else
        {
            mListener.b(mProductEntry);
            return;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

}

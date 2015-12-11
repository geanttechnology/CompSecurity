// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.mothership.model.product.interfaces.ProductRgbValue;
import com.target.ui.util.o;
import java.util.Iterator;
import java.util.List;

public class RefineCheckBoxAndColorImageView extends LinearLayout
    implements android.widget.CompoundButton.OnCheckedChangeListener
{
    static class Views extends com.target.ui.view.a
    {

        CheckBox checkBox;
        ImageView colorImg;

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


    public static final String TAG = com/target/ui/view/refine/RefineCheckBoxAndColorImageView.getSimpleName();
    private static final String WHITE_COLOR = "white";
    private a mListener;
    private ProductEntry mProductEntry;
    private Views mViews;

    public RefineCheckBoxAndColorImageView(Context context)
    {
        super(context);
        b();
    }

    public RefineCheckBoxAndColorImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public RefineCheckBoxAndColorImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    private void a(ImageView imageview, List list)
    {
        if (imageview == null)
        {
            return;
        }
        if (list.isEmpty())
        {
            imageview.setImageResource(0x7f02012a);
            return;
        }
        int i = 0;
        list = list.iterator();
        if (list.hasNext())
        {
            i = ((ProductRgbValue)list.next()).a();
        }
        o.a(imageview, i);
    }

    private void b()
    {
        inflate(getContext(), 0x7f0301ca, this);
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

    public void a(ProductEntry productentry, boolean flag)
    {
        if (mViews == null)
        {
            return;
        }
        mProductEntry = productentry;
        mViews.checkBox.setChecked(flag);
        mViews.checkBox.setText((CharSequence)productentry.c().c());
        mViews.checkBox.setTag(productentry);
        mViews.checkBox.setOnCheckedChangeListener(this);
        if (((String)productentry.c().c()).trim().equalsIgnoreCase("white"))
        {
            mViews.colorImg.setImageResource(0x7f0201f1);
            return;
        } else
        {
            a(mViews.colorImg, productentry.e());
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

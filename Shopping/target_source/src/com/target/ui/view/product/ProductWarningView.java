// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.model.product.interfaces.ProductChokingHazard;
import java.util.Iterator;
import java.util.List;

public class ProductWarningView extends LinearLayout
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a(ProductChokingHazard productchokinghazard);
    }


    private a mListener;
    private List mProductChockingHazards;

    public ProductWarningView(Context context)
    {
        super(context);
        a();
    }

    public ProductWarningView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ProductWarningView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        setOrientation(1);
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            int i = ((Integer)view.getTag()).intValue();
            mListener.a((ProductChokingHazard)mProductChockingHazards.get(i));
            return;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setWarningData(List list)
    {
        if (list != null)
        {
            mProductChockingHazards = list;
            removeAllViews();
            list = mProductChockingHazards.iterator();
            int i = 0;
            while (list.hasNext()) 
            {
                ProductChokingHazard productchokinghazard = (ProductChokingHazard)list.next();
                View view = LayoutInflater.from(getContext()).inflate(0x7f030197, this, false);
                ((TextView)view.findViewById(0x7f1004a1)).setText(Html.fromHtml(productchokinghazard.a()));
                view.setOnClickListener(this);
                view.setTag(Integer.valueOf(i));
                addView(view);
                i++;
            }
        }
    }
}

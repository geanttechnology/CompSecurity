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
import com.target.mothership.model.product.interfaces.ProductFeature;
import com.target.ui.util.al;
import java.util.Iterator;
import java.util.List;

public class ProductFeaturesView extends LinearLayout
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a(ProductFeature productfeature);
    }


    private a mListener;
    private List mProductFeatures;

    public ProductFeaturesView(Context context)
    {
        super(context);
        a();
    }

    public ProductFeaturesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ProductFeaturesView(Context context, AttributeSet attributeset, int i)
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
            mListener.a((ProductFeature)mProductFeatures.get(i));
            return;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setProductFeatures(List list)
    {
        if (list != null)
        {
            mProductFeatures = list;
            removeAllViews();
            list = mProductFeatures.iterator();
            int i = 0;
            while (list.hasNext()) 
            {
                Object obj = (ProductFeature)list.next();
                View view = LayoutInflater.from(getContext()).inflate(0x7f030191, this, false);
                TextView textview = (TextView)view.findViewById(0x7f1004d1);
                TextView textview1 = (TextView)view.findViewById(0x7f1004d2);
                String s = ((ProductFeature) (obj)).a();
                obj = ((ProductFeature) (obj)).b();
                if (s != null && obj != null)
                {
                    textview.setText(Html.fromHtml(s));
                    textview1.setText(Html.fromHtml(((String) (obj))));
                    al.b(new View[] {
                        textview1, textview
                    });
                } else
                {
                    al.a(new View[] {
                        textview1, textview
                    });
                }
                if (mListener != null)
                {
                    view.setOnClickListener(this);
                }
                view.setTag(Integer.valueOf(i));
                addView(view);
                i++;
            }
        }
    }
}

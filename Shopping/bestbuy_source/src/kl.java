// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.bbyobjects.ProductImageGallery;

public class kl extends LinearLayout
{

    final ProductImageGallery a;
    private Context b;

    public kl(ProductImageGallery productimagegallery, Context context)
    {
        a = productimagegallery;
        super(context);
        b = context;
    }

    public void a(int i)
    {
        for (int j = 0; j < i; j++)
        {
            ImageView imageview = new ImageView(b);
            imageview.setImageResource(0x7f0200f7);
            imageview.setTag(Integer.valueOf(j));
            if (j == 0)
            {
                imageview.setSelected(true);
            }
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2, 1.0F);
            layoutparams.setMargins(10, 0, 10, 0);
            addView(imageview, layoutparams);
            imageview.setOnClickListener(new android.view.View.OnClickListener(imageview) {

                final ImageView a;
                final kl b;

                public void onClick(View view)
                {
                    view = view.getTag().toString();
                    ProductImageGallery.c(b.a).setCurrentItem(Integer.parseInt(view));
                    a.setSelected(true);
                }

            
            {
                b = kl.this;
                a = imageview;
                super();
            }
            });
        }

    }

    public void b(int i)
    {
        int j = 0;
        while (j < getChildCount()) 
        {
            ImageView imageview = (ImageView)getChildAt(j);
            if (i == j)
            {
                if (imageview != null)
                {
                    imageview.setSelected(true);
                }
            } else
            {
                imageview.setSelected(false);
            }
            j++;
        }
    }
}

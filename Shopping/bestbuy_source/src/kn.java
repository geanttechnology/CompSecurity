// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bestbuy.android.bbyobjects.ProductImageGallery;
import java.util.List;

public class kn extends PagerAdapter
{

    Context a;
    List b;
    final ProductImageGallery c;

    public kn(ProductImageGallery productimagegallery, Context context, List list)
    {
        c = productimagegallery;
        super();
        b = list;
        a = context;
    }

    public void destroyItem(View view, int i, Object obj)
    {
        ((ViewPager)view).removeView((RelativeLayout)obj);
    }

    public int getCount()
    {
        return b.size();
    }

    public Object instantiateItem(View view, int i)
    {
        RelativeLayout relativelayout = (RelativeLayout)ProductImageGallery.a(c).inflate(0x7f030041, null);
        ImageView imageview = (ImageView)relativelayout.findViewById(0x7f0c0109);
        String s = (String)b.get(i);
        if (s != null && s.length() > 0)
        {
            ng.a(s, imageview, false);
        }
        relativelayout.setOnClickListener(new android.view.View.OnClickListener(i) {

            final int a;
            final kn b;

            public void onClick(View view1)
            {
                if (ProductImageGallery.b(b.c) != null)
                {
                    ProductImageGallery.b(b.c).a(a);
                }
            }

            
            {
                b = kn.this;
                a = i;
                super();
            }
        });
        ((ViewPager)view).addView(relativelayout, 0);
        return relativelayout;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (RelativeLayout)obj;
    }

    public Parcelable saveState()
    {
        return null;
    }
}

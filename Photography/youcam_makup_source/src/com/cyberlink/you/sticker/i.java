// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cyberlink.you.n;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment

class i
{

    final StickerFragment a;
    private LinearLayout b;
    private ViewPager c;
    private int d;

    public i(StickerFragment stickerfragment, LinearLayout linearlayout, ViewPager viewpager)
    {
        a = stickerfragment;
        super();
        b = linearlayout;
        c = viewpager;
    }

    public void a(int j)
    {
        int k = 0;
        while (k < b.getChildCount()) 
        {
            View view = b.getChildAt(k);
            boolean flag;
            if (k == j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            k++;
        }
    }

    public void a(Context context)
    {
        if (context == null)
        {
            return;
        }
        int i1 = c.getAdapter().getCount();
        int j1 = b.getChildCount();
        if (j1 < i1)
        {
            for (int j = 0; j < i1 - j1; j++)
            {
                ImageView imageview = new ImageView(context);
                imageview.setImageResource(n.u_image_selector_dot_index);
                b.addView(imageview);
            }

        }
        if (d < i1)
        {
            for (int k = d; k < i1; k++)
            {
                b.getChildAt(k).setVisibility(0);
            }

        } else
        if (d > i1)
        {
            for (int l = i1; l < j1; l++)
            {
                b.getChildAt(l).setVisibility(8);
            }

        }
        if (i1 == 1)
        {
            b.getChildAt(0).setVisibility(8);
        } else
        {
            b.getChildAt(0).setVisibility(0);
        }
        d = i1;
        a(0);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.utility.x;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a extends PagerAdapter
{

    final ShareInActivity a;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return ShareInActivity.o(a).size();
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        if (i < ShareInActivity.o(a).size())
        {
            x x1 = (x)ShareInActivity.o(a).get(i);
            ImageView imageview = (ImageView)LayoutInflater.from(a).inflate(k.bc_view_item_share_in_image, viewgroup, false);
            imageview.setImageBitmap(x1.c);
            imageview.setTag(x1);
            viewgroup.addView(imageview);
            return x1;
        } else
        {
            return null;
        }
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return obj == view.getTag();
    }

    (ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}

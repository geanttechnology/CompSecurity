// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.i;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CirclePager

class a
    implements android.support.v4.view.geChangeListener
{

    final CirclePager a;

    public void onPageScrollStateChanged(int j)
    {
    }

    public void onPageScrolled(int j, float f, int k)
    {
    }

    public void onPageSelected(int j)
    {
label0:
        {
            Object obj;
label1:
            {
                if (j < CirclePager.l(a).getChildCount())
                {
                    obj = (Integer)CirclePager.l(a).getTag();
                    if (obj == null)
                    {
                        break label0;
                    }
                    if (((Integer) (obj)).intValue() != j)
                    {
                        break label1;
                    }
                }
                return;
            }
            obj = (ImageView)CirclePager.l(a).getChildAt(((Integer) (obj)).intValue());
            if (obj != null)
            {
                ((ImageView) (obj)).setImageResource(i.bc_dot_g);
            }
        }
        ImageView imageview = (ImageView)CirclePager.l(a).getChildAt(j);
        if (imageview != null)
        {
            imageview.setImageResource(i.bc_dot_n);
        }
        CirclePager.l(a).setTag(Integer.valueOf(j));
    }

    (CirclePager circlepager)
    {
        a = circlepager;
        super();
    }
}

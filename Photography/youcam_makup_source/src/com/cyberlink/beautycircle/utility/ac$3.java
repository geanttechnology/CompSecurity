// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ac

class a
    implements android.view.OnClickListener
{

    final ac a;

    public void onClick(View view)
    {
        int i = 0;
        while (i < ac.c(a).size()) 
        {
            View view1 = (View)ac.c(a).get(i);
            View view2 = ac.f(a).getChildAt(i);
            float f;
            boolean flag;
            if (view1 == view)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                f = 1.5F;
            } else
            {
                f = 1.0F;
            }
            view1.setScaleX(f);
            if (flag)
            {
                f = 1.5F;
            } else
            {
                f = 1.0F;
            }
            view1.setScaleY(f);
            if (flag)
            {
                f = 0.9F;
            } else
            {
                f = 0.7F;
            }
            view1.setAlpha(f);
            view2.findViewById(j.product_tag_border).setSelected(flag);
            if (flag)
            {
                ac.g(a).smoothScrollTo((int)view2.getX(), (int)view2.getY());
            }
            i++;
        }
    }

    (ac ac1)
    {
        a = ac1;
        super();
    }
}

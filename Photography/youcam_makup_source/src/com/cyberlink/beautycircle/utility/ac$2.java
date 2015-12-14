// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.view.View;
import android.widget.ImageView;
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
        boolean flag = true;
        ac.a(a, true);
        view = a;
        if (ac.e(a).isSelected())
        {
            flag = false;
        }
        view.a(flag);
        for (int i = 0; i < ac.c(a).size(); i++)
        {
            ac.f(a).getChildAt(i).findViewById(j.product_tag_border).setSelected(false);
        }

    }

    (ac ac1)
    {
        a = ac1;
        super();
    }
}

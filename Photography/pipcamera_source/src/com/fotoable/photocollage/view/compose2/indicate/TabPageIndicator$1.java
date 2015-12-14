// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.indicate;

import android.support.v4.view.ViewPager;
import android.view.View;
import mp;
import mq;

// Referenced classes of package com.fotoable.photocollage.view.compose2.indicate:
//            TabPageIndicator

class a
    implements android.view.r
{

    final TabPageIndicator a;

    public void onClick(View view)
    {
        view = (mq)view;
        int i = TabPageIndicator.access$000(a).getCurrentItem();
        int j = view.a();
        TabPageIndicator.access$000(a).setCurrentItem(j);
        if (i == j && TabPageIndicator.access$100(a) != null)
        {
            TabPageIndicator.access$100(a).a(j);
        }
    }

    I(TabPageIndicator tabpageindicator)
    {
        a = tabpageindicator;
        super();
    }
}

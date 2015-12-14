// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            TabPageIndicator, d

final class a
    implements android.view.r
{

    private TabPageIndicator a;

    public final void onClick(View view)
    {
        view = (d)view;
        TabPageIndicator.a(a).getCurrentItem();
        int i = ((d) (view)).a;
        TabPageIndicator.a(a).setCurrentItem(i);
    }

    (TabPageIndicator tabpageindicator)
    {
        a = tabpageindicator;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPager;
import android.view.View;
import viewpagerindicator.TabPageIndicator;

public class cfr
    implements android.view.View.OnClickListener
{

    final TabPageIndicator a;

    public cfr(TabPageIndicator tabpageindicator)
    {
        a = tabpageindicator;
        super();
    }

    public void onClick(View view)
    {
        view = (cfu)view;
        int i = TabPageIndicator.access$000(a).getCurrentItem();
        int j = view.a();
        TabPageIndicator.access$000(a).setCurrentItem(j);
        if (i == j && TabPageIndicator.access$100(a) != null)
        {
            TabPageIndicator.access$100(a).a(j);
        }
    }
}

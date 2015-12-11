// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;


// Referenced classes of package com.bestbuy.android.activities.browseproduct:
//            BrowseCategoryFragment

class a
    implements android.support.v4.view.tener
{

    final BrowseCategoryFragment a;

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            a.c();
        } else
        if (i == 1)
        {
            a.d();
            return;
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
    }

    (BrowseCategoryFragment browsecategoryfragment)
    {
        a = browsecategoryfragment;
        super();
    }
}

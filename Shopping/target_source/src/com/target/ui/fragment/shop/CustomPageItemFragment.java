// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.common.page_item.PageIdentifier;
import com.target.mothership.common.params.PageItemParams;
import com.target.ui.analytics.a.aw;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

public class CustomPageItemFragment extends PageItemFragment
{
    public static interface a
    {

        public static final PageIdentifier CHILD_CATEGORY_PAGE_IDENTIFIER = new PageIdentifier("category-children");

    }


    public CustomPageItemFragment()
    {
    }

    public static CustomPageItemFragment a(PageItemParams pageitemparams, PageIdentifier pageidentifier)
    {
        CustomPageItemFragment custompageitemfragment = new CustomPageItemFragment();
        custompageitemfragment.setArguments(b(pageitemparams, pageidentifier));
        return custompageitemfragment;
    }

    private void d()
    {
        aw.a(r()).e();
    }

    protected void a(long l)
    {
        d();
    }

    protected PageItemFragment.b b()
    {
        return PageItemFragment.b.CUSTOM;
    }

    public void e()
    {
        d();
    }
}

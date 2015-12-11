// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.ui.analytics.a.ba;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

public class CategoriesPageItemFragment extends PageItemFragment
{

    public CategoriesPageItemFragment()
    {
    }

    public static CategoriesPageItemFragment a()
    {
        CategoriesPageItemFragment categoriespageitemfragment = new CategoriesPageItemFragment();
        categoriespageitemfragment.setArguments(j());
        return categoriespageitemfragment;
    }

    private void b(long l)
    {
        if (s())
        {
            return;
        } else
        {
            ba.a(l, this).e();
            return;
        }
    }

    protected void a(long l)
    {
        b(l);
    }

    protected PageItemFragment.b b()
    {
        return PageItemFragment.b.CATEGORIES;
    }

    protected void c()
    {
        U();
        JVM INSTR tableswitch 2 3: default 28
    //                   2 38
    //                   3 43;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_43;
_L1:
        boolean flag = hasOptionsMenu();
_L4:
        if (!flag)
        {
            return;
        } else
        {
            super.c();
            return;
        }
_L2:
        flag = false;
          goto _L4
        flag = true;
          goto _L4
    }

    public void e()
    {
        b(0L);
    }
}

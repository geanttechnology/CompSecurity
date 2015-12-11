// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.b;
import com.target.mothership.model.a;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.product.interfaces.Product;

// Referenced classes of package com.target.mothership.model.list:
//            h, f, e

public class g extends a
{

    public static final int FLAG_PROVIDER_LOCAL = 0;
    public static final int FLAG_PROVIDER_NETWORK = 1;
    private e mListBaseDataSource;

    public g(com.target.mothership.model.list.interfaces.a a1, Guest guest)
    {
        if (guest == null || guest.isAnonymous())
        {
            guest = com.target.mothership.model.guest.b.a();
        }
        if (com.target.mothership.b.a().m())
        {
            mListBaseDataSource = new h(a1, guest);
            return;
        } else
        {
            mListBaseDataSource = new f(a1, guest);
            return;
        }
    }

    public void a(d d1)
    {
        mListBaseDataSource.a(d1);
    }

    public void a(ListItem listitem, int i, d d1)
    {
        if (i <= 99) goto _L2; else goto _L1
_L1:
        int j = 99;
_L4:
        mListBaseDataSource.a(listitem, j, d1);
        return;
_L2:
        j = i;
        if (i < 1)
        {
            j = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(ListItem listitem, d d1)
    {
        mListBaseDataSource.a(listitem, d1);
    }

    public void a(ListItem listitem, String s, d d1)
    {
        mListBaseDataSource.a(listitem, s, d1);
    }

    public void a(Product product, Integer integer, int i, d d1)
    {
        mListBaseDataSource.a(product, integer.intValue(), i, d1);
    }

    public void a(Product product, Integer integer, d d1)
    {
        mListBaseDataSource.a(product, integer.intValue(), d1);
    }

    public void a(String s, d d1)
    {
        a(null, null, s, null, d1);
    }

    public void a(String s, Integer integer, int i, d d1)
    {
        mListBaseDataSource.a(s, integer.intValue(), i, d1);
    }

    public void a(String s, Integer integer, d d1)
    {
        mListBaseDataSource.a(s, integer.intValue(), d1);
    }

    public void a(String s, String s1, String s2, String s3, d d1)
    {
        mListBaseDataSource.a(s, s1, s2, s3, d1);
    }

    public void b(d d1)
    {
        mListBaseDataSource.b(d1);
    }

    public void b(ListItem listitem, int i, d d1)
    {
        mListBaseDataSource.b(listitem, i, d1);
    }

    public void b(ListItem listitem, d d1)
    {
        mListBaseDataSource.b(listitem, d1);
    }

    public void c(d d1)
    {
        mListBaseDataSource.c(d1);
    }

    public void c(ListItem listitem, d d1)
    {
        mListBaseDataSource.c(listitem, d1);
    }

    public void d(d d1)
    {
        mListBaseDataSource.d(d1);
    }
}

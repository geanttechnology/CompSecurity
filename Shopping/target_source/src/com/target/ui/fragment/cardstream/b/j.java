// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import com.google.a.b.d;
import com.google.a.b.h;
import com.target.ui.fragment.cardstream.CardStreamOnClickHandler;
import com.target.ui.fragment.cardstream.SingleShoppingListData;
import com.target.ui.fragment.cardstream.b;
import com.target.ui.fragment.cardstream.c.i;
import com.target.ui.fragment.cardstream.f.e;
import java.util.Collection;
import java.util.Set;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            b, a, e

public class j
    implements com.target.ui.fragment.cardstream.b.b, com.target.ui.fragment.cardstream.c.a.a
{

    private final i mDataSource;
    private final com.target.ui.fragment.cardstream.b.e mSimpleStorage;

    public j(com.target.ui.fragment.cardstream.b.e e1, i k)
    {
        mSimpleStorage = e1;
        mDataSource = k;
    }

    private e d()
    {
        int k;
        if (f())
        {
            k = 0x7f0900e9;
        } else
        {
            k = 0x7f0900e7;
        }
        return com.target.ui.fragment.cardstream.b.a.a(0x7f02005a).a(a.sShowActionsListBothActions).b(0x7f100004).c(k).a(CardStreamOnClickHandler.a()).e(0x7f100005).c(0x7f0900e8).a(CardStreamOnClickHandler.a(c())).a();
    }

    private e e()
    {
        return com.target.ui.fragment.cardstream.f.e.a(0x7f100010).c(0x7f0900ed).a();
    }

    private boolean f()
    {
        com.google.a.a.e e1 = mDataSource.f();
        return e1.b() && !((SingleShoppingListData)e1.c()).listItems.isEmpty();
    }

    private boolean g()
    {
        com.google.a.a.e e1 = mDataSource.f();
        if (!e1.b())
        {
            return false;
        }
        boolean flag;
        if (com.google.a.b.d.a(((SingleShoppingListData)e1.c()).listItems, i.sOnlyShowIncompleteItems).size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void a(com.google.a.a.e e1)
    {
        while (!e1.b() || ((SingleShoppingListData)e1.c()).listItems.isEmpty()) 
        {
            return;
        }
        mSimpleStorage.a(true);
    }

    public boolean a()
    {
        return mDataSource.g() && !g() && !mSimpleStorage.a().contains(c());
    }

    public com.google.a.a.e b()
    {
        return com.google.a.a.e.b(new b(0x7f030028, d(), e(), c()));
    }

    public com.target.ui.fragment.cardstream.e c()
    {
        return com.target.ui.fragment.cardstream.e.SHOPPING_LIST_ENGAGEMENT;
    }
}

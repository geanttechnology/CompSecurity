// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import com.google.a.b.e;
import com.google.a.b.h;
import com.target.a.a.b;
import com.target.b.a;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.cardstream.CardStreamOnClickHandler;
import com.target.ui.fragment.cardstream.SingleShoppingListData;
import com.target.ui.fragment.cardstream.c.i;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            b, a

public class k
    implements com.target.ui.fragment.cardstream.b.b
{

    private static final String LOG_TAG = "ShowStoreMapCardManager";
    private final com.target.ui.fragment.cardstream.f.e mChrome = d();
    private final i mDataSource;
    private final a mRelevantStoreProvider;

    public k(a a1, i j)
    {
        mRelevantStoreProvider = a1;
        mDataSource = j;
    }

    private SingleShoppingListData a(SingleShoppingListData singleshoppinglistdata)
    {
        h h1;
        if (singleshoppinglistdata != null)
        {
            if (!(h1 = com.google.a.b.e.a(singleshoppinglistdata.listItems).a(i.sOnlyShowIncompleteItems).a()).isEmpty())
            {
                return new SingleShoppingListData(singleshoppinglistdata.listSummary, h1);
            }
        }
        return null;
    }

    private com.target.ui.fragment.cardstream.f.e d()
    {
        return com.target.ui.fragment.cardstream.b.a.a(0x7f020054, 0x7f0900e5).a(a.sHideActionsList).b(0x7f100006).d(0).a();
    }

    private com.target.ui.fragment.cardstream.f.e e()
    {
        Object obj = (com.google.a.a.e)mRelevantStoreProvider.b();
        if (!((com.google.a.a.e) (obj)).b())
        {
            return null;
        } else
        {
            SingleShoppingListData singleshoppinglistdata = a((SingleShoppingListData)mDataSource.f().d());
            obj = CardStreamOnClickHandler.a((Store)((com.google.a.a.e) (obj)).c(), singleshoppinglistdata);
            return com.target.ui.fragment.cardstream.f.e.a(0x7f100006).a(((com.target.ui.fragment.cardstream.f.b.e) (obj))).a();
        }
    }

    public boolean a()
    {
        com.google.a.a.e e1 = (com.google.a.a.e)mRelevantStoreProvider.b();
        return e1.b() && ((RelevantStoreSummary)e1.c()).a();
    }

    public com.google.a.a.e b()
    {
        com.target.ui.fragment.cardstream.f.e e1 = e();
        if (e1 == null)
        {
            com.target.a.a.b.d("ShowStoreMapCardManager", "Could not build card data");
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(new com.target.ui.fragment.cardstream.b(0x7f03002a, mChrome, e1, c()));
        }
    }

    public com.target.ui.fragment.cardstream.e c()
    {
        return com.target.ui.fragment.cardstream.e.SHOW_STORE_MAP_VIEW;
    }
}

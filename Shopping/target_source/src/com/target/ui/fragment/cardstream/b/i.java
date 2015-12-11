// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import com.google.a.b.k;
import com.target.ui.fragment.cardstream.CardStreamOnClickHandler;
import com.target.ui.fragment.cardstream.SingleShoppingListData;
import com.target.ui.fragment.cardstream.b;
import com.target.ui.fragment.cardstream.f.e;
import com.target.ui.model.list.ListDetailItem;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            b, a

public class i
    implements com.target.ui.fragment.cardstream.b.b
{

    private static final com.google.a.a.b sToViewtagenSet = new com.google.a.a.b() {

        private final com.target.ui.fragment.cardstream.f.b.e mOnClickMutation = CardStreamOnClickHandler.a();

        public e a(ListDetailItem listdetailitem)
        {
            return com.target.ui.fragment.cardstream.f.e.a(0x7f100010).a(listdetailitem.b()).e(0x7f10000d).a(mOnClickMutation).a();
        }

        public volatile Object a(Object obj)
        {
            return a((ListDetailItem)obj);
        }

    };
    private final e mChrome = e();
    private final com.target.ui.fragment.cardstream.c.i mDataSource;

    public i(com.target.ui.fragment.cardstream.c.i j)
    {
        mDataSource = j;
    }

    private e a(List list)
    {
        return com.target.ui.fragment.cardstream.f.e.a(0x7f1000b8).a(0x7f030029, k.a(list, sToViewtagenSet)).a();
    }

    private List d()
    {
        if (!mDataSource.g())
        {
            return Collections.emptyList();
        } else
        {
            return com.google.a.b.e.a(((SingleShoppingListData)mDataSource.f().c()).listItems).a(com.target.ui.fragment.cardstream.c.i.sOnlyShowIncompleteItems).a();
        }
    }

    private e e()
    {
        return com.target.ui.fragment.cardstream.b.a.a(0x7f020055, 0x7f0900e4).a(a.sHideActionsList).b(0x7f100006).d(0).a();
    }

    public boolean a()
    {
        return !d().isEmpty();
    }

    public com.google.a.a.e b()
    {
        Object obj = d();
        if (((List) (obj)).isEmpty())
        {
            return com.google.a.a.e.e();
        } else
        {
            obj = a(((List) (obj)));
            return com.google.a.a.e.b(new b(0x7f030027, mChrome, ((e) (obj)), c()));
        }
    }

    public com.target.ui.fragment.cardstream.e c()
    {
        return com.target.ui.fragment.cardstream.e.SHOPPING_LIST;
    }

}

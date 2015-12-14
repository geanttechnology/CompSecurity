// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import myobfuscated.bp.c;

// Referenced classes of package com.picsart.shop:
//            o, s, p, a, 
//            k

final class t>
    implements c
{

    private int a;
    private o b;

    public final void a(ArrayList arraylist)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = b.getActivity();
        if (fragmentactivity == null || fragmentactivity.isFinishing())
        {
            return;
        }
        if (o.p(b))
        {
            o.a(b, false);
            if (o.q(b) != null)
            {
                o.q(b).a();
            }
        }
        if (arraylist.size() < 20)
        {
            o.r(b);
            if (o.s(b) != null)
            {
                o.s(b).b = o.t(b);
            }
        }
        if (arraylist.size() == 0 && a == 0)
        {
            o.b(b).setVisibility(0);
            o.b(b).setText(b.getString(0x7f0805bd));
        }
        o.o(b).setVisibility(8);
        com.picsart.shop.a.a(fragmentactivity).a(arraylist);
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            com.socialin.android.apiv3.model.ItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ItemsListResponse.ShopItem)arraylist.next();
            if (shopitem.isVisible && !o.d(b).a(shopitem))
            {
                o.d(b).b(shopitem);
            }
        } while (true);
        o.u(b).setVisibility(8);
    }

    ssBar(o o1, int i)
    {
        b = o1;
        a = i;
        super();
    }
}

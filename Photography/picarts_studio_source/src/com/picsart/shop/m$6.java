// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import myobfuscated.bp.c;

// Referenced classes of package com.picsart.shop:
//            m, a, ShopItemActivity

final class t>
    implements c
{

    private String a;
    private m b;

    public final void a(ArrayList arraylist)
    {
        Activity activity = b.getActivity();
        if (activity != null && !activity.isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        com.picsart.shop.a.a(activity);
        com.picsart.shop.a.a().a(arraylist);
        arraylist = arraylist.iterator();
        com.socialin.android.apiv3.model.ItemsListResponse.ShopItem shopitem;
        do
        {
            if (!arraylist.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            shopitem = (com.socialin.android.apiv3.model.ItemsListResponse.ShopItem)arraylist.next();
        } while (!a.equals(shopitem.data.shopItemUid));
        b.a(shopitem);
        if (activity instanceof ShopItemActivity)
        {
            ((ShopItemActivity)activity).a(shopitem);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    ItemActivity(m m1, String s)
    {
        b = m1;
        a = s;
        super();
    }
}

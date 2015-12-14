// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import com.socialin.android.apiv3.util.PublicSyncInventory;
import com.socialin.android.billing.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.bp.b;
import myobfuscated.bp.c;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a
    implements b
{

    private MainPagerActivity a;

    public final void a()
    {
    }

    public final void a(List list)
    {
        m.a(a, a.getString(0x7f0808be)).requestShopItems(true, new c(list) {

            private List a;

            public final void a(ArrayList arraylist)
            {
                PublicSyncInventory.createEmptyInventoryFile();
                for (arraylist = arraylist.iterator(); arraylist.hasNext();)
                {
                    com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.next();
                    Iterator iterator = a.iterator();
                    while (iterator.hasNext()) 
                    {
                        if (((String)iterator.next()).equals(shopitem.data.shopItemUid))
                        {
                            PublicSyncInventory.writeShopItem(shopitem);
                        }
                    }
                }

            }

            
            {
                a = list;
                super();
            }
        });
    }

    _cls1.a(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}

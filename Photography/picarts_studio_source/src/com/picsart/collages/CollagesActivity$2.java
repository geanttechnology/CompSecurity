// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.content.Intent;
import android.view.View;
import com.picsart.shop.ShopItemActivity;

// Referenced classes of package com.picsart.collages:
//            CollagesActivity

final class a
    implements android.view.r
{

    private CollagesActivity a;

    public final void onClick(View view)
    {
        view = new Intent(a, com/picsart/shop/ShopItemActivity);
        view.putExtra("selectedShopItemId", "ad_remover");
        a.startActivityForResult(view, 114);
    }

    (CollagesActivity collagesactivity)
    {
        a = collagesactivity;
        super();
    }
}

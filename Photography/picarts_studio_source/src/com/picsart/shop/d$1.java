// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.picsart.shop:
//            d, ShopItemsListActivity

final class t>
    implements android.view..OnClickListener
{

    private d a;

    public final void onClick(View view)
    {
        Intent intent = new Intent(d.a(a), com/picsart/shop/ShopItemsListActivity);
        intent.putExtra("selectedTag", ((TextView)view).getText().toString());
        intent.putExtra("fromSource", "shopCategories");
        d.b(a).startActivity(intent);
    }

    xt(d d1)
    {
        a = d1;
        super();
    }
}

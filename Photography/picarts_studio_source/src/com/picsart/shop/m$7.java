// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.picsart.shop:
//            m, ShopItemsListActivity

final class t>
    implements android.view..OnClickListener
{

    private m a;

    public final void onClick(View view)
    {
        Activity activity = a.getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        } else
        {
            Intent intent = new Intent(activity, com/picsart/shop/ShopItemsListActivity);
            intent.putExtra("selectedTag", ((TextView)view).getText().toString());
            intent.putExtra("fromSource", m.j(a));
            activity.startActivity(intent);
            return;
        }
    }

    e(m m1)
    {
        a = m1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            SelectBuyerActivity

final class he
    implements android.view.View.OnClickListener
{

    private SelectBuyerActivity a;

    he(SelectBuyerActivity selectbuyeractivity)
    {
        a = selectbuyeractivity;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("ou_select_buyer_do_later");
        Toast.makeText(a, a.getResources().getString(0x7f0900d7), 1).show();
        a.finish();
    }
}

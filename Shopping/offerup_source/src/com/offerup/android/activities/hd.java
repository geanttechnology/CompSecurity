// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.view.View;
import com.offerup.android.dto.Item;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            SelectBuyerActivity, hi

final class hd
    implements android.view.View.OnClickListener
{

    private SelectBuyerActivity a;

    hd(SelectBuyerActivity selectbuyeractivity)
    {
        a = selectbuyeractivity;
        super();
    }

    public final void onClick(View view)
    {
        a.g = ProgressDialog.show(a, "", "Loading...");
        com.offerup.android.tracker.a.a("ou_select_buyer_elsewhere", com.offerup.android.activities.SelectBuyerActivity.a(a).getId());
        android.support.v4.e.a.a(com.offerup.android.activities.SelectBuyerActivity.a(a).getId(), 0L, 0, new hi(a, (byte)0));
    }
}

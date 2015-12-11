// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.offerup.android.tracker.a;
import java.util.ArrayList;

// Referenced classes of package com.offerup.android.activities:
//            SelectBuyerActivity, a, ExpandedSelectBuyerActivity

final class hh
    implements android.view.View.OnClickListener
{

    private ArrayList a;
    private SelectBuyerActivity b;

    hh(SelectBuyerActivity selectbuyeractivity, ArrayList arraylist)
    {
        b = selectbuyeractivity;
        a = arraylist;
        super();
    }

    public final void onClick(View view)
    {
        view = b.f;
        com.offerup.android.dto.Item item = com.offerup.android.activities.SelectBuyerActivity.a(b);
        ArrayList arraylist = a;
        Intent intent = new Intent(((com.offerup.android.activities.a) (view)).a, com/offerup/android/activities/ExpandedSelectBuyerActivity);
        intent.putParcelableArrayListExtra("buyerList", arraylist);
        intent.putExtra("item", item);
        ((com.offerup.android.activities.a) (view)).a.startActivityForResult(intent, 11);
        com.offerup.android.tracker.a.a("ou_select_buyer_see_all", null);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.view.View;
import android.widget.AdapterView;
import eq;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPBuyingOptionsFragment

class a
    implements android.widget.istener
{

    final PLPBuyingOptionsFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)PLPBuyingOptionsFragment.a(a).get(i);
        PLPBuyingOptionsFragment.b(a).clear();
        if (!adapterview.contains("New Condition")) goto _L2; else goto _L1
_L1:
        PLPBuyingOptionsFragment.b(a).addAll(PLPBuyingOptionsFragment.c(a));
_L4:
        PLPBuyingOptionsFragment.f(a).notifyDataSetChanged();
        return;
_L2:
        if (adapterview.contains("Open-Box Condition"))
        {
            PLPBuyingOptionsFragment.b(a).addAll(PLPBuyingOptionsFragment.d(a));
        } else
        if (adapterview.contains("Refurbished Condition"))
        {
            PLPBuyingOptionsFragment.b(a).addAll(PLPBuyingOptionsFragment.e(a));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    Q(PLPBuyingOptionsFragment plpbuyingoptionsfragment)
    {
        a = plpbuyingoptionsfragment;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.view.View;
import android.widget.AdapterView;
import eg;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPSourceProductAvailabilityFragment

class a
    implements android.widget.urceProductAvailabilityFragment._cls1
{

    final PDPSourceProductAvailabilityFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)PDPSourceProductAvailabilityFragment.a(a).get(i);
        PDPSourceProductAvailabilityFragment.b(a).clear();
        if (!adapterview.contains("New Condition")) goto _L2; else goto _L1
_L1:
        PDPSourceProductAvailabilityFragment.b(a).addAll(PDPSourceProductAvailabilityFragment.c(a));
_L4:
        PDPSourceProductAvailabilityFragment.f(a).notifyDataSetChanged();
        return;
_L2:
        if (adapterview.contains("Open-Box Condition"))
        {
            PDPSourceProductAvailabilityFragment.b(a).addAll(PDPSourceProductAvailabilityFragment.d(a));
        } else
        if (adapterview.contains("Refurbished Condition"))
        {
            PDPSourceProductAvailabilityFragment.b(a).addAll(PDPSourceProductAvailabilityFragment.e(a));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    (PDPSourceProductAvailabilityFragment pdpsourceproductavailabilityfragment)
    {
        a = pdpsourceproductavailabilityfragment;
        super();
    }
}

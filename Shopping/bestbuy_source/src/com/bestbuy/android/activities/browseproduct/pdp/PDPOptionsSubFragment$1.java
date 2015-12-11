// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.api.lib.models.pdp.ContractOption;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPOptionsSubFragment, PDPFragment, PDPFragmentContainer

class a
    implements android.widget.istener
{

    final PDPOptionsSubFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!PDPOptionsSubFragment.a(a))
        {
            view = (ContractOption)PDPOptionsSubFragment.b(a).get(i);
            adapterview = a.getParentFragment();
            view = new PDPFragment(view.getSku(), view.getProductId(), false);
            ((PDPFragmentContainer)adapterview).e();
            ((PDPFragmentContainer)adapterview).a(view, false);
        }
    }

    (PDPOptionsSubFragment pdpoptionssubfragment)
    {
        a = pdpoptionssubfragment;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.support.v4.app.Fragment;
import android.view.View;
import com.bestbuy.android.api.lib.models.pdp.Option;
import java.util.HashMap;
import lu;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPOptionFragment, PDPFragment, PDPFragmentContainer

class a
    implements android.view.
{

    final Option a;
    final PDPOptionFragment b;

    public void onClick(View view)
    {
        view = new HashMap();
        view.put("&&products", (new StringBuilder()).append(";").append(a.getSku()).toString());
        lu.b(lu.an, view);
        view = b.getParentFragment();
        PDPFragment pdpfragment = new PDPFragment(a.getSku(), null, false);
        ((PDPFragmentContainer)view.getParentFragment()).a(pdpfragment, true);
    }

    (PDPOptionFragment pdpoptionfragment, Option option)
    {
        b = pdpoptionfragment;
        a = option;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.view.View;
import java.util.List;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPOptionFragment

class a
    implements android.view.
{

    final List a;
    final PDPOptionFragment b;

    public void onClick(View view)
    {
        PDPOptionFragment.a(b, a);
    }

    (PDPOptionFragment pdpoptionfragment, List list)
    {
        b = pdpoptionfragment;
        a = list;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, ProductListFragment

class a
    implements android.view.oductListActivity._cls15
{

    final ProductListActivity a;

    public void onClick(View view)
    {
        int i = Integer.parseInt(view.getTag().toString());
        ProductListActivity.d(a).a(i);
    }

    (ProductListActivity productlistactivity)
    {
        a = productlistactivity;
        super();
    }
}

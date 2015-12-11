// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListItem, am

class a
    implements android.view.er
{

    final ProductListItem a;

    public void onClick(View view)
    {
        if (ProductListItem.a(a) != null)
        {
            ProductListItem.a(a).b(ProductListItem.b(a));
        }
    }

    _cls9(ProductListItem productlistitem)
    {
        a = productlistitem;
        super();
    }
}

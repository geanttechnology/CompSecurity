// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ListingListItem, t

class a
    implements android.view.er
{

    final ListingListItem a;

    public void onClick(View view)
    {
        if (ListingListItem.a(a) != null)
        {
            ListingListItem.a(a).a(ListingListItem.b(a));
        }
    }

    _cls9(ListingListItem listinglistitem)
    {
        a = listinglistitem;
        super();
    }
}

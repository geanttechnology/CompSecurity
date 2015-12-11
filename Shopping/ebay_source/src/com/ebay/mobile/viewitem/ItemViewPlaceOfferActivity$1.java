// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.view.View;
import android.view.Window;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewPlaceOfferActivity

class this._cls0
    implements android.view.rActivity._cls1
{

    final ItemViewPlaceOfferActivity this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            getWindow().setSoftInputMode(5);
        }
    }

    ()
    {
        this$0 = ItemViewPlaceOfferActivity.this;
        super();
    }
}

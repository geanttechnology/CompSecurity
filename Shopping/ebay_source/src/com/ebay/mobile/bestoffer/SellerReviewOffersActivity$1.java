// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.Toast;
import com.ebay.mobile.Item;

// Referenced classes of package com.ebay.mobile.bestoffer:
//            SellerReviewOffersActivity

class this._cls0
    implements android.view.rsActivity._cls1
{

    final SellerReviewOffersActivity this$0;

    public boolean onLongClick(View view)
    {
        ((ClipboardManager)getSystemService("clipboard")).setText(SellerReviewOffersActivity.access$100(SellerReviewOffersActivity.this).title.Content());
        Toast.makeText(SellerReviewOffersActivity.this, getString(0x7f070269), 0).show();
        return true;
    }

    ()
    {
        this$0 = SellerReviewOffersActivity.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoreDetailsFragment

class a
    implements android.content.Listener
{

    final StoreDetailsFragment a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder()).append("tel:").append(StoreDetailsFragment.d(a).getStoreDetails().getPhone()).toString()));
        a.d.startActivity(intent);
        dialoginterface.cancel();
    }

    (StoreDetailsFragment storedetailsfragment)
    {
        a = storedetailsfragment;
        super();
    }
}

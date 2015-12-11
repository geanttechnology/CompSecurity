// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.target.ui.view.store:
//            StoreDetailHeaderView

class val.phoneNumber
    implements android.view.eaderView._cls3
{

    final StoreDetailHeaderView this$0;
    final String val$phoneNumber;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.DIAL");
        view.setData(Uri.parse((new StringBuilder()).append("tel:").append(val$phoneNumber).toString()));
        getContext().startActivity(view);
    }

    ()
    {
        this$0 = final_storedetailheaderview;
        val$phoneNumber = String.this;
        super();
    }
}

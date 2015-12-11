// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

// Referenced classes of package com.ebay.mobile.checkout.delivery:
//            DeliverySchedulingActivity

class this._cls0
    implements android.content.r
{

    final DeliverySchedulingActivity this$0;

    public void onShow(DialogInterface dialoginterface)
    {
        ((AlertDialog)dialoginterface).getButton(-1).setTextSize(0, getResources().getDimension(0x7f090154));
    }

    ()
    {
        this$0 = DeliverySchedulingActivity.this;
        super();
    }
}

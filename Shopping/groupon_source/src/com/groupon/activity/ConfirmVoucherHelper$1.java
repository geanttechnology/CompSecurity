// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Activity;
import android.view.View;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.ArrayList;

// Referenced classes of package com.groupon.activity:
//            ConfirmVoucherHelper, IntentFactory

class val.closest
    implements android.view.elper._cls1
{

    final ConfirmVoucherHelper this$0;
    final int val$closest;
    final ArrayList val$locations;
    final String val$loggerSpecifier;
    final MyGrouponItem val$voucher;

    public void onClick(View view)
    {
        ConfirmVoucherHelper.access$000(ConfirmVoucherHelper.this).logClick("", "small_map_click", val$loggerSpecifier, "");
        ConfirmVoucherHelper.access$200(ConfirmVoucherHelper.this).startActivity(ConfirmVoucherHelper.access$100(ConfirmVoucherHelper.this).newShowOnMapIntent(val$locations, val$voucher.name, val$closest));
    }

    em()
    {
        this$0 = final_confirmvoucherhelper;
        val$loggerSpecifier = s;
        val$locations = arraylist;
        val$voucher = mygrouponitem;
        val$closest = I.this;
        super();
    }
}

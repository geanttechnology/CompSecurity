// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller;

import android.content.Context;
import android.view.View;
import com.groupon.Channel;
import com.groupon.db.models.Option;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BookingUtil;

// Referenced classes of package com.groupon.mvc.controller:
//            BottomBarController

private class <init>
    implements android.view.ClickListener
{

    final BottomBarController this$0;

    private void logDateTimeFinderBuyButtonClick()
    {
        ClickExtraInfo clickextrainfo = new ClickExtraInfo();
        clickextrainfo.type = BottomBarController.access$1200(BottomBarController.this).searchIntentCategory._mth0();
        String s;
        if (BottomBarController.access$1200(BottomBarController.this).partialIntent)
        {
            s = "partial";
        } else
        {
            s = "full";
        }
        clickextrainfo.intent = s;
        BottomBarController.access$400(BottomBarController.this).logClick("", "book_and_buy_click", BottomBarController.access$1600(BottomBarController.this).name(), JsonEncodedNSTField.NULL_JSON_NST_FIELD, clickextrainfo);
    }

    public void onClick(View view)
    {
        logDateTimeFinderBuyButtonClick();
        boolean flag;
        if (BottomBarController.access$1000(BottomBarController.this) && BottomBarController.access$1100(BottomBarController.this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = BottomBarController.access$1700(BottomBarController.this).createDateTimeFinderSchedulerIntent(BottomBarController.access$1200(BottomBarController.this), BottomBarController.access$1300(BottomBarController.this), BottomBarController.access$1400(BottomBarController.this).remoteId, BottomBarController.access$1500(BottomBarController.this), BottomBarController.access$1600(BottomBarController.this), flag, false);
        BottomBarController.access$800(BottomBarController.this).startActivity(view);
    }

    private Y()
    {
        this$0 = BottomBarController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

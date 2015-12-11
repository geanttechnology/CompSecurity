// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.RedemptionExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            Groupon, IntentFactory

class this._cls0
    implements android.view.kListener
{

    final Groupon this$0;

    public void onClick(View view)
    {
        view = new ClickMetadata(getPageViewId(), Groupon.access$000(Groupon.this).remoteId);
        RedemptionExtraInfo redemptionextrainfo = new RedemptionExtraInfo(Groupon.access$000(Groupon.this).grouponNumber, Groupon.access$000(Groupon.this).redemptionCode, Groupon.access$000(Groupon.this).uuid);
        Groupon.access$600(Groupon.this).logClick("", "cancel_order_click", "cancel_order", view, redemptionextrainfo);
        view = Groupon.access$500(Groupon.this).newCancelOrderIntent();
        view.putExtra("dealId", Groupon.access$000(Groupon.this).dealId);
        view.putExtra("orderID", Groupon.access$000(Groupon.this).orderId);
        view.putExtra("optionId", Groupon.access$000(Groupon.this).dealOptionId);
        startActivityForResult(view, 10146);
    }

    ry()
    {
        this$0 = Groupon.this;
        super();
    }
}

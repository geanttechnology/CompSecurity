// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.RedemptionExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;

// Referenced classes of package com.groupon.activity:
//            Redeem

class this._cls0
    implements android.view.ickListener
{

    final Redeem this$0;

    public void onClick(View view)
    {
        GrouponDialogFragment.show(getFragmentManager(), Redeem.access$1100(Redeem.this).getDialogFragment(Integer.valueOf(0x7f080414), Integer.valueOf(0x7f080413), Integer.valueOf(0x7f080232), Integer.valueOf(0x7f080205), false), "groupon_mark_as_redeemed_dialog");
        view = new ClickMetadata(getPageViewId(), Redeem.access$000(Redeem.this).remoteId);
        RedemptionExtraInfo redemptionextrainfo = new RedemptionExtraInfo(Redeem.access$000(Redeem.this).grouponNumber, Redeem.access$000(Redeem.this).redemptionCode, Redeem.access$000(Redeem.this).uuid);
        Redeem.access$1200(Redeem.this).logClick("", "redeem_voucher", Redeem.access$000(Redeem.this).dealId, view, redemptionextrainfo);
    }

    k.Logger()
    {
        this$0 = Redeem.this;
        super();
    }
}

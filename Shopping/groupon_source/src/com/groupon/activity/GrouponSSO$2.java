// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            GrouponSSO, IntentFactory

class this._cls0
    implements android.view.istener
{

    final GrouponSSO this$0;

    public void onClick(View view)
    {
        Logger logger = GrouponSSO.access$000(GrouponSSO.this);
        String s;
        if (isComingFromCheckout != null)
        {
            view = "checkout";
        } else
        {
            view = com/groupon/activity/GrouponSSO.getSimpleName();
        }
        if (dealId != null)
        {
            s = dealId;
        } else
        {
            s = "";
        }
        logger.logClick("", "sso_switchuser_click", view, s);
        startActivityForResult(GrouponSSO.access$200(GrouponSSO.this).newLoginIntent(GrouponSSO.this, next, dealId, optionId, isComingFromCheckout), 10142);
    }

    ()
    {
        this$0 = GrouponSSO.this;
        super();
    }
}

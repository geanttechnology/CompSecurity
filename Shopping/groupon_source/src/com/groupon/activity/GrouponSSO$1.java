// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            GrouponSSO, Login

class this._cls0
    implements android.view.istener
{

    final GrouponSSO this$0;

    public void onClick(View view)
    {
        ssoSignInButton.startSpinning();
        Logger logger = GrouponSSO.access$000(GrouponSSO.this);
        String s;
        if (isComingFromCheckout != null)
        {
            view = "checkout";
        } else
        {
            view = com/groupon/activity/Login.getSimpleName();
        }
        if (dealId != null)
        {
            s = dealId;
        } else
        {
            s = "";
        }
        logger.logClick("", "sso_continue_click", view, s);
        GrouponSSO.access$100(GrouponSSO.this);
    }

    gger()
    {
        this$0 = GrouponSSO.this;
        super();
    }
}

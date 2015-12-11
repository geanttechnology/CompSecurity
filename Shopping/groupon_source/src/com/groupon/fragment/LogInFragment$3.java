// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.activity.Login;
import com.groupon.service.LoginService;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment

class this._cls0
    implements android.view.ener
{

    final LogInFragment this$0;

    public void onClick(View view)
    {
        if (!LogInFragment.access$200(LogInFragment.this) || !isAdded())
        {
            return;
        }
        String s = getLoginRedesign().getDealId();
        Logger logger = LogInFragment.this.logger;
        if (Strings.notEmpty(s))
        {
            view = "purchase_flow";
        } else
        {
            view = "other";
        }
        logger.logLogin("", view, s, Logger.NULL_NST_FIELD);
        LogInFragment.this.logger.logClick("", "signin_click", com/groupon/activity/Login.getSimpleName(), "");
        view = getLoginRedesign().getIsComingFromCheckout();
        if (view != null && view.booleanValue())
        {
            LogInFragment.this.logger.logClick("", "signin_click", "checkout", s);
        }
        if (loginService.hasAccessToken() ^ loginService.hasFacebookSession() && !loginService.isLoggedInViaEmail())
        {
            loginService.logout();
        }
        LogInFragment.access$300(LogInFragment.this);
    }

    r()
    {
        this$0 = LogInFragment.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import com.amazon.identity.auth.accounts.AccountsCallbackHelpers;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.platform.metric.MetricUtils;
import java.util.TimerTask;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

private class <init> extends TimerTask
{

    final AuthPortalUIActivity this$0;

    public void run()
    {
        String s = (new StringBuilder()).append(AuthPortalUIActivity.access$000(AuthPortalUIActivity.this)).append(":NetworkState:").append(MetricUtils.isNetworkAvailable(AuthPortalUIActivity.access$100(AuthPortalUIActivity.this))).toString();
        AuthPortalUIActivity.access$200(AuthPortalUIActivity.this).incrementCounter(s);
        AuthPortalUIActivity.access$300(AuthPortalUIActivity.this, AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.TWORK_FAILURE.lue(), "Unable to render content. Request timed out."));
    }

    private r()
    {
        this$0 = AuthPortalUIActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

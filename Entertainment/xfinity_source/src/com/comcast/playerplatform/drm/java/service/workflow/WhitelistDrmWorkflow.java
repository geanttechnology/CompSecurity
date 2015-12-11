// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import android.content.Context;
import com.adobe.ave.drm.DRMAcquireLicenseSettings;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.util.AuthenticationDelegate;
import com.comcast.playerplatform.drm.java.util.DrmUtil;
import com.comcast.playerplatform.util.android.MoneyTrace;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractStreamingDrmWorkflow

public class WhitelistDrmWorkflow extends AbstractStreamingDrmWorkflow
{

    public WhitelistDrmWorkflow(ClientStateInterface clientstateinterface, AuthenticationDelegate authenticationdelegate, Context context, HttpClient httpclient, MoneyTrace moneytrace)
    {
        super(clientstateinterface, authenticationdelegate, context, httpclient, moneytrace);
        licenseSettings = DRMAcquireLicenseSettings.ALLOW_SERVER;
    }

    public void validate()
    {
        acquireVoucher(DrmUtil.generateWhiteListString());
    }
}

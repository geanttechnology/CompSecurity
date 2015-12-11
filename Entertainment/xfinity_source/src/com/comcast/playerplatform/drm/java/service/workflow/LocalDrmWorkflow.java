// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import android.content.Context;
import com.adobe.ave.drm.DRMAcquireLicenseSettings;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.util.AuthenticationDelegate;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractStreamingDrmWorkflow

public class LocalDrmWorkflow extends AbstractStreamingDrmWorkflow
{

    public LocalDrmWorkflow(ClientStateInterface clientstateinterface, AuthenticationDelegate authenticationdelegate, HttpClient httpclient, Context context)
    {
        super(clientstateinterface, authenticationdelegate, context, httpclient, null);
        licenseSettings = DRMAcquireLicenseSettings.LOCAL_ONLY;
    }

    public void validate()
    {
        acquireVoucher(null);
    }
}

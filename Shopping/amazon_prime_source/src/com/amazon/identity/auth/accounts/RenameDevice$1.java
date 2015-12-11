// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.RenameDeviceResponse;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            RenameDevice, AmazonAccountManager

class erviceCallListener extends DefaultAmazonWebserviceCallListener
{

    final RenameDevice this$0;
    final Callback val$callback;
    final String val$directedId;

    public void onAuthenticationFailed()
    {
        RenameDevice.access$000(RenameDevice.this, val$callback, 2, "Authentication failure performing rename device request");
    }

    public void onNetworkFailure()
    {
        RenameDevice.access$000(RenameDevice.this, val$callback, 1, "Network failure performing rename device request");
    }

    public void onParseError$6fe276bc()
    {
        RenameDevice.access$000(RenameDevice.this, val$callback, 4, "Parsing failure performing rename device request");
    }

    public void onResponseComplete(Object obj)
    {
        MAPLog.i(RenameDevice.access$100(), "Completed the rename device request");
        obj = (RenameDeviceResponse)obj;
        if (obj == null)
        {
            RenameDevice.access$000(RenameDevice.this, val$callback, 7, " Unrecognized response from server");
            return;
        }
        int i = ((RenameDeviceResponse) (obj)).getError();
        obj = ((RenameDeviceResponse) (obj)).getMessage();
        if (i == 0)
        {
            MAPLog.i(RenameDevice.access$100(), "Successfully completed the rename device request");
            RenameDevice.access$200(RenameDevice.this).setUserData(val$directedId, "com.amazon.dcp.sso.property.devicename", ((String) (obj)));
            MAPLog.i(RenameDevice.access$100(), "RenameDevice completed successfully.");
            SSOMetrics.renameDeviceRequestSuccess();
            val$callback.onSuccess(RenameDevice.access$300$38a6f778(((String) (obj))));
            return;
        } else
        {
            RenameDevice.access$000(RenameDevice.this, val$callback, i, ((String) (obj)));
            return;
        }
    }

    s()
    {
        this$0 = final_renamedevice;
        val$callback = callback1;
        val$directedId = String.this;
        super();
    }
}

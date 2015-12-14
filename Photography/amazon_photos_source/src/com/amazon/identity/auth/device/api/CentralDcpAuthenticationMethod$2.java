// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.dcp.sso.IRequestAuthenticationMethod;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.BoundServiceCaller;
import com.amazon.identity.auth.device.utils.ADPCorpusSigningCallbackHelpers;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            CentralDcpAuthenticationMethod, Callback

class val.directedId extends BoundServiceCaller
{

    final CentralDcpAuthenticationMethod this$0;
    final PlatformMetricsTimer val$bindTimer;
    final Callback val$callback;
    final CallbackFuture val$callbackFuture;
    final byte val$corpus[];
    final String val$directedId;
    final Bundle val$signCorpusOption;

    protected void serviceDisconnected()
    {
        MAPLog.e(CentralDcpAuthenticationMethod.TAG, "AuthenticatedRequestService is disconnected. It's probably crashed.");
        ADPCorpusSigningCallbackHelpers.callbackError(val$callbackFuture, 1, "AuthenticatedRequestService is disconnected. It's probably crashed.");
    }

    protected void useService(IBinder ibinder)
    {
        Object obj;
        PlatformMetricsTimer platformmetricstimer;
        obj = null;
        val$bindTimer.stop();
        platformmetricstimer = MetricsHelper.startVerboseTimer(CentralDcpAuthenticationMethod.METRICS_COMPONENT_NAME, "signCorpusByDirectedIdWrapper");
        byte abyte0[];
        byte abyte1[];
        abyte0 = val$corpus;
        abyte1 = com.amazon.dcp.sso..asInterface(ibinder);
        if (!mFeatureSet.hasFeature(Feature.DirectedIdSupported)) goto _L2; else goto _L1
_L1:
        ibinder = abyte1.signCorpusByDirectedId("SHA256WithRSA", val$directedId, abyte0);
_L3:
        obj = CentralDcpAuthenticationMethod.TAG;
        obj = CentralDcpAuthenticationMethod.this;
        abyte0 = val$callbackFuture;
        abyte1 = val$corpus;
        Bundle bundle = val$signCorpusOption;
        Callback callback1 = val$callback;
        ((CentralDcpAuthenticationMethod) (obj)).parseResponse$438b682c(ibinder, abyte0, abyte1, bundle);
        platformmetricstimer.stop();
        unbind();
        return;
_L2:
        Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, val$directedId);
        if (account == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        ibinder = account.type;
_L4:
        if (account == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = account.name;
        ibinder = abyte1.signCorpus("SHA256WithRSA", ibinder, ((String) (obj)), abyte0);
          goto _L3
        ibinder = null;
          goto _L4
        ibinder;
        MAPLog.e(CentralDcpAuthenticationMethod.TAG, "Cannot receive corpus authentication from dcp! Connection to DCP has been lost.", ibinder);
        ADPCorpusSigningCallbackHelpers.callbackError(val$callbackFuture, 1, "Cannot receive corpus authentication from dcp! Connection to DCP has been lost.");
        platformmetricstimer.stop();
        unbind();
        return;
        ibinder;
        MAPLog.e(CentralDcpAuthenticationMethod.TAG, "Unknown error during signCorpus execution.", ibinder);
        ADPCorpusSigningCallbackHelpers.callbackError(val$callbackFuture, 5, ibinder.toString());
        platformmetricstimer.stop();
        unbind();
        return;
        ibinder;
        platformmetricstimer.stop();
        unbind();
        throw ibinder;
          goto _L3
    }

    (Callback callback1, String s)
    {
        this$0 = final_centraldcpauthenticationmethod;
        val$bindTimer = platformmetricstimer;
        val$corpus = abyte0;
        val$callbackFuture = callbackfuture;
        val$signCorpusOption = Bundle.this;
        val$callback = callback1;
        val$directedId = s;
        super(final_context, final_intent, 1);
    }
}

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
import com.amazon.identity.auth.device.features.FeatureSetCache;
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
        MAPLog.e(CentralDcpAuthenticationMethod.access$100(), "AuthenticatedRequestService is disconnected. It's probably crashed.");
        ADPCorpusSigningCallbackHelpers.callbackError(val$callbackFuture, 1, "AuthenticatedRequestService is disconnected. It's probably crashed.");
    }

    protected void useService(IBinder ibinder)
    {
        String s;
        PlatformMetricsTimer platformmetricstimer;
        s = null;
        val$bindTimer.stop();
        platformmetricstimer = MetricsHelper.startVerboseTimer(CentralDcpAuthenticationMethod.access$000(), "signCorpusByDirectedIdWrapper");
        byte abyte0[];
        IRequestAuthenticationMethod irequestauthenticationmethod;
        abyte0 = val$corpus;
        irequestauthenticationmethod = com.amazon.dcp.sso..asInterface(ibinder);
        if (!getFeatureSet().hasFeature(Feature.DirectedIdSupported)) goto _L2; else goto _L1
_L1:
        ibinder = irequestauthenticationmethod.signCorpusByDirectedId("SHA256WithRSA", val$directedId, abyte0);
_L3:
        CentralDcpAuthenticationMethod.access$100();
        CentralDcpAuthenticationMethod.access$300(CentralDcpAuthenticationMethod.this, ibinder, val$callbackFuture, val$corpus, val$signCorpusOption, val$callback);
        platformmetricstimer.stop();
        unbind();
        return;
_L2:
        Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(CentralDcpAuthenticationMethod.access$200(CentralDcpAuthenticationMethod.this), val$directedId);
        if (account == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        ibinder = account.type;
_L4:
        if (account == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        s = account.name;
        ibinder = irequestauthenticationmethod.signCorpus("SHA256WithRSA", ibinder, s, abyte0);
          goto _L3
        ibinder = null;
          goto _L4
        ibinder;
        MAPLog.e(CentralDcpAuthenticationMethod.access$100(), "Cannot receive corpus authentication from dcp! Connection to DCP has been lost.", ibinder);
        ADPCorpusSigningCallbackHelpers.callbackError(val$callbackFuture, 1, "Cannot receive corpus authentication from dcp! Connection to DCP has been lost.");
        platformmetricstimer.stop();
        unbind();
        return;
        ibinder;
        MAPLog.e(CentralDcpAuthenticationMethod.access$100(), "Unknown error during signCorpus execution.", ibinder);
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

    (Bundle bundle, Callback callback1, String s)
    {
        this$0 = final_centraldcpauthenticationmethod;
        val$bindTimer = platformmetricstimer;
        val$corpus = abyte0;
        val$callbackFuture = CallbackFuture.this;
        val$signCorpusOption = bundle;
        val$callback = callback1;
        val$directedId = s;
        super(final_context, final_intent, final_i);
    }
}

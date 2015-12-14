// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.dcp.sso.IRequestAuthenticationMethod;
import com.amazon.dcp.sso.ReturnValueOrError;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.SyncBoundServiceCaller;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            CentralDcpAuthenticationMethod, AuthenticationType

class t> extends SyncBoundServiceCaller
{

    final CentralDcpAuthenticationMethod this$0;
    final PlatformMetricsTimer val$bindTimer;
    final byte val$body[];
    final Map val$headers;
    final AtomicReference val$requestAuthVal;
    final Uri val$serviceUri;
    final String val$verb;

    protected void useService(IBinder ibinder)
    {
        PlatformMetricsTimer platformmetricstimer;
        val$bindTimer.stop();
        platformmetricstimer = MetricsHelper.startVerboseTimer(CentralDcpAuthenticationMethod.METRICS_COMPONENT_NAME, "getAuthenticationParams");
        byte abyte0[];
        Object obj;
        Object obj1;
        Uri uri;
        String s;
        IRequestAuthenticationMethod irequestauthenticationmethod;
        String s1;
        uri = val$serviceUri;
        s = val$verb;
        obj = val$headers;
        abyte0 = val$body;
        irequestauthenticationmethod = com.amazon.dcp.sso..asInterface(ibinder);
        s1 = mAuthTypeString;
        obj1 = mDirectedId;
        ibinder = Collections.EMPTY_MAP;
        if (!AuthenticationType.OAuth.getValue().equals(s1))
        {
            ibinder = ((IBinder) (obj));
        } else
        {
            abyte0 = new byte[0];
        }
        if (!mFeatureSet.hasFeature(Feature.DirectedIdSupported)) goto _L2; else goto _L1
_L1:
        ibinder = irequestauthenticationmethod.getAuthenticationParametersForRequestByDirectedId(s1, ((String) (obj1)), uri, s, ibinder, abyte0);
_L5:
        abyte0 = CentralDcpAuthenticationMethod.TAG;
        val$requestAuthVal.set(ibinder);
        platformmetricstimer.stop();
        doneUsingService();
        return;
_L2:
        obj1 = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, ((String) (obj1)));
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        obj = ((Account) (obj1)).type;
_L6:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        obj1 = ((Account) (obj1)).name;
_L7:
        ibinder = irequestauthenticationmethod.getAuthenticationParametersForRequest(s1, ((String) (obj)), ((String) (obj1)), uri, s, ibinder, abyte0);
          goto _L5
_L4:
        obj = null;
          goto _L6
        obj1 = null;
          goto _L7
        ibinder;
        MAPLog.e(CentralDcpAuthenticationMethod.TAG, "Could not receive request authentication from dcp!", ibinder);
        ibinder = new ReturnValueOrError(6, "Connection to DCP has been lost");
        val$requestAuthVal.set(ibinder);
        platformmetricstimer.stop();
        doneUsingService();
        return;
        ibinder;
        MAPLog.e(CentralDcpAuthenticationMethod.TAG, "Unknown error during getAuthenticationBundle execution.", ibinder);
        ibinder = new ReturnValueOrError(5, ibinder.toString());
        val$requestAuthVal.set(ibinder);
        platformmetricstimer.stop();
        doneUsingService();
        return;
        ibinder;
        val$requestAuthVal.set(null);
        platformmetricstimer.stop();
        doneUsingService();
        throw ibinder;
          goto _L5
    }

    (byte abyte0[], AtomicReference atomicreference)
    {
        this$0 = final_centraldcpauthenticationmethod;
        val$bindTimer = platformmetricstimer;
        val$serviceUri = uri;
        val$verb = s;
        val$headers = Map.this;
        val$body = abyte0;
        val$requestAuthVal = atomicreference;
        super(final_context, final_intent, 1);
    }
}

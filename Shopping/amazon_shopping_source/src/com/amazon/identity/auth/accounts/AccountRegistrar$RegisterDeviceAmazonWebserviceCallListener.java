// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.AuthenticationChallenge;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceError;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.platform.metric.MetricsHelper;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar

private static abstract class mMAPAccountManager extends DefaultAmazonWebserviceCallListener
{

    protected final mListener mListener;
    protected final MAPAccountManager mMAPAccountManager;

    protected abstract void cleanupDeviceState(RegisterDeviceErrorType registerdeviceerrortype);

    public void onAuthenticationFailed()
    {
        MAPLog.e(AccountRegistrar.access$000(), "Authentication failure performing registration request");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
    }

    public void onNetworkFailure()
    {
        MAPLog.e(AccountRegistrar.access$000(), "Network failure performing registration request");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
    }

    public void onParseError(ParseError parseerror)
    {
        MAPLog.e(AccountRegistrar.access$000(), "Parsing failure performing registration request");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
    }

    protected abstract mListener onRegisterResponseComplete(RegisterDeviceResponse registerdeviceresponse);

    public void onResponseComplete(Object obj)
    {
        Object obj1;
        MAPLog.i(AccountRegistrar.access$000(), "Successfully completed the registration request");
        obj1 = (RegisterDeviceResponse)obj;
        if (obj1 == null)
        {
            MAPLog.e(AccountRegistrar.access$000(), "Registration Error: Null response");
            mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
            return;
        }
        if (((RegisterDeviceResponse) (obj1)).getError() == null) goto _L2; else goto _L1
_L1:
        Object obj2;
        obj = ((RegisterDeviceResponse) (obj1)).getError();
        obj2 = ((RegisterDeviceError) (obj)).getType().getErrorString();
        MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("Error string: ")).append(((String) (obj2))).toString());
        h.RegisterDeviceErrorType[((RegisterDeviceError) (obj)).getType().ordinal()];
        JVM INSTR tableswitch 1 17: default 176
    //                   1 210
    //                   2 234
    //                   3 258
    //                   4 282
    //                   5 357
    //                   6 381
    //                   7 405
    //                   8 429
    //                   9 453
    //                   10 477
    //                   11 501
    //                   12 525
    //                   13 549
    //                   14 573
    //                   15 611
    //                   16 649
    //                   17 696;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20
_L3:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: Unrecognized response. If this is a 1st party Amazon device and is not corrected from a retry, please verify that your device has been fulfilled.");
        AccountRegistrar.access$000();
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
_L21:
        cleanupDeviceState(((RegisterDeviceError) (obj)).getType());
        return;
_L4:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: Customer not found. The credential is invalid.");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L5:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: Device already registered");
        mListener.mListener(com.amazon.identity.auth.device.api.D, null);
        continue; /* Loop/switch isn't completed */
_L6:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: Duplicate device name");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L7:
        MAPLog.i(AccountRegistrar.access$000(), "Registration Error: Challenge Response Received");
        obj1 = ((RegisterDeviceResponse) (obj1)).getChallenge();
        if (obj1 == null)
        {
            MAPLog.e(AccountRegistrar.access$000(), "Registration Error: Unknown. Challenge Exception was missing.");
            mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        } else
        {
            obj2 = new Bundle();
            ((Bundle) (obj2)).putBundle("com.amazon.identity.auth.ChallengeException", ((AuthenticationChallenge) (obj1)).toBundle());
            mListener.mListener(com.amazon.identity.auth.device.api.D, ((Bundle) (obj2)));
        }
        continue; /* Loop/switch isn't completed */
_L8:
        MAPLog.e(AccountRegistrar.access$000(), "MAP internal bug: One or more required values are missing");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L9:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: One or more required values are invalid");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L10:
        MAPLog.e(AccountRegistrar.access$000(), "MAP internal bug: The Protocol is not supported. SSL required");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L11:
        MAPLog.e(AccountRegistrar.access$000(), "MAP internal bug: The HTTP method is not valid. For example, using POST instead of GET");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L12:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: The server has encountered a runtime error, or the service is temporarily overloaded or unavailable, try again later");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L13:
        MAPLog.e(AccountRegistrar.access$000(), "MAP internal bug: The feature is not implemented");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L14:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: The directedId is invalid. e.g. The customer directedId is invalid. The device directedId is invalid");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L15:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: The device information is invalid. The device serial number is too long");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L16:
        MAPLog.e(AccountRegistrar.access$000(), "Registration Error: The service is temporarily overloaded or unavailable, try again later");
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L17:
        MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("Registration Error: ")).append(((String) (obj2))).toString());
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L18:
        MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("Registration Error: ")).append(((String) (obj2))).toString());
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L19:
        MAPLog.i(AccountRegistrar.access$000(), (new StringBuilder("Registration Error: ")).append(((String) (obj2))).toString());
        MetricsHelper.increasePeriodicCounter("PrimaryAccountDeregisteredWhenRegisterSecondaryWithPanda", new String[0]);
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        continue; /* Loop/switch isn't completed */
_L20:
        MAPLog.i(AccountRegistrar.access$000(), (new StringBuilder("Registration Error: ")).append(((String) (obj2))).toString());
        mListener.mListener(com.amazon.identity.auth.device.api.istener, null);
        if (true) goto _L21; else goto _L2
_L2:
        obj = onRegisterResponseComplete(((RegisterDeviceResponse) (obj1)));
        if (((onRegisterResponseComplete) (obj)).onRegisterResponseComplete == null)
        {
            mListener.mListener(((mListener) (obj)).mListener(), ((mListener) (obj)).mListener(), ((mListener) (obj)).mListener);
            return;
        } else
        {
            MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("Registration Error: ")).append(((mListener) (obj)).mListener.istener()).toString());
            mListener.mListener(((mListener) (obj)).mListener, null);
            return;
        }
    }

    public ( )
    {
        mListener = ;
        mMAPAccountManager = null;
    }

    public mMAPAccountManager(mMAPAccountManager mmapaccountmanager, MAPAccountManager mapaccountmanager)
    {
        mListener = mmapaccountmanager;
        mMAPAccountManager = mapaccountmanager;
    }
}

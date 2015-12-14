// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.storage.CookieJar;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar, AccountDataCollector, AccountRegistrarAuthenticator

class stener extends gisterDeviceAmazonWebserviceCallListener
{

    final AccountRegistrar this$0;
    final AccountRegistrarAuthenticator val$accountRegAuth;
    final String val$deviceType;
    final String val$email;
    final stener val$listener;
    final String val$privateKeyOverWrite;
    final String val$serialNumber;

    protected void cleanupDeviceState(final RegisterDeviceErrorType error)
    {
        if (error != RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceNotRegisteredPanda && error != RegisterDeviceErrorType.RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary)
        {
            return;
        }
        if (mMAPAccountManager == null)
        {
            MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("MAPAccountManager not initialized. Not able to deregister the device due to error ")).append(error.name()).toString());
            return;
        } else
        {
            mMAPAccountManager.deregisterDevice(new Callback() {

                final AccountRegistrar._cls5 this$1;
                final RegisterDeviceErrorType val$error;

                public void onError(Bundle bundle)
                {
                    MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("Got error while deregistering device in response to error : ")).append(error.name()).toString());
                    int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode", -1);
                    bundle = bundle.getString("com.amazon.dcp.sso.ErrorMessage");
                    MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("Error Code: ")).append(i).toString());
                    MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("Error message: ")).append(bundle).toString());
                }

                public void onSuccess(Bundle bundle)
                {
                    if (bundle.containsKey("com.amazon.dcp.sso.ErrorCode"))
                    {
                        onError(bundle);
                        return;
                    } else
                    {
                        MAPLog.e(AccountRegistrar.access$000(), (new StringBuilder("Finished deregistering device in response to error : ")).append(error.name()).toString());
                        return;
                    }
                }

            
            {
                this$1 = AccountRegistrar._cls5.this;
                error = registerdeviceerrortype;
                super();
            }
            });
            return;
        }
    }

    protected gisterInfo onRegisterResponseComplete(RegisterDeviceResponse registerdeviceresponse)
    {
        Object obj = AccountRegistrar.this;
        Object obj1 = val$accountRegAuth;
        AccountRegistrar.access$300$32336411(((AccountRegistrar) (obj)), registerdeviceresponse);
        if (AccountRegistrar.access$500(AccountRegistrar.this, registerdeviceresponse))
        {
            AccountRegistrar.access$400(AccountRegistrar.this, registerdeviceresponse, val$accountRegAuth);
            MAPLog.w(AccountRegistrar.access$000(), "Cannot register the device, because anonymous credentials were returned from the server. FRO has either already been called or this device is not associated with an account.");
            return new gisterInfo(com.amazon.identity.auth.device.api.egistrationError.REGISTER_FAILED);
        }
        AccountDataCollector accountdatacollector = new AccountDataCollector();
        if (val$email != null)
        {
            accountdatacollector.setEmail(val$email);
        }
        obj1 = registerdeviceresponse.getUserName();
        obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj = " ";
        }
        accountdatacollector.setUserName(((String) (obj)));
        accountdatacollector.setDeviceName(registerdeviceresponse.getDeviceName());
        accountdatacollector.setDeviceEmail(registerdeviceresponse.getEmail());
        accountdatacollector.setAdpToken(registerdeviceresponse.getAdpToken());
        if (registerdeviceresponse.getPrivateKey() != null)
        {
            MAPLog.i(AccountRegistrar.access$000(), "Registration returned server generated credentials.");
            accountdatacollector.setPrivateKey(registerdeviceresponse.getPrivateKey());
        } else
        {
            if (val$privateKeyOverWrite == null)
            {
                MAPLog.e(AccountRegistrar.access$000(), "No private key to set after register.");
                val$listener.failure(com.amazon.identity.auth.device.api.egistrationError.REGISTER_FAILED, null);
            }
            MAPLog.i(AccountRegistrar.access$000(), "The device will use self generated credentials.");
            accountdatacollector.setPrivateKey(val$privateKeyOverWrite);
        }
        accountdatacollector.setDeviceSerialNumber(val$serialNumber);
        accountdatacollector.setDeviceType(val$deviceType);
        accountdatacollector.setDirectedId(registerdeviceresponse.getDirectedId());
        obj = new CookieJar(registerdeviceresponse.getCookiesRetrievedFromFIRS());
        accountdatacollector.setXMainToken(((CookieJar) (obj)).getXmain());
        accountdatacollector.setXMainAndXAcbCookies(((CookieJar) (obj)).getInternationalXMainAndXAcbCookies());
        accountdatacollector.setXfsnCookie(registerdeviceresponse.getStoreAuthenticationCookie());
        accountdatacollector.setAccountPool(registerdeviceresponse.getAccountPool());
        accountdatacollector.setCustomerRegion(registerdeviceresponse.getCustomerRegion());
        accountdatacollector.setCor(registerdeviceresponse.getCor());
        accountdatacollector.setSourceOfCor(registerdeviceresponse.getSourceOfCor());
        accountdatacollector.setPfm(registerdeviceresponse.getPfm());
        accountdatacollector.setCredentialsMap(registerdeviceresponse.getCredentialsReceived());
        accountdatacollector.setCookies(registerdeviceresponse.getCookiesRetrievedFromPanda());
        accountdatacollector.setAccessToken(registerdeviceresponse.getAccessToken());
        accountdatacollector.setAccessTokenExpiresIn(registerdeviceresponse.getAccessTokenExpiresIn());
        accountdatacollector.setRefreshToken(registerdeviceresponse.getRefreshToken());
        return new gisterInfo(accountdatacollector.getUserDataNecessaryForAccountCreation());
    }

    (String s2, String s3)
    {
        this$0 = final_accountregistrar;
        val$accountRegAuth = accountregistrarauthenticator;
        val$email = s;
        val$privateKeyOverWrite = s1;
        val$listener = stener.this;
        val$serialNumber = s2;
        val$deviceType = s3;
        super(final_stener, final_mapaccountmanager);
    }
}

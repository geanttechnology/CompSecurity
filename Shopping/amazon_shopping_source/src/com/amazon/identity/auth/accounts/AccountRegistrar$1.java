// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.attributes.UserProperties;
import com.amazon.identity.auth.device.storage.CookieJar;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar, AccountDataCollector

class stener extends gisterDeviceAmazonWebserviceCallListener
{

    final AccountRegistrar this$0;
    final String val$directedId;

    protected void cleanupDeviceState(RegisterDeviceErrorType registerdeviceerrortype)
    {
    }

    protected gisterInfo onRegisterResponseComplete(RegisterDeviceResponse registerdeviceresponse)
    {
        AccountDataCollector accountdatacollector = new AccountDataCollector();
        accountdatacollector.setUserName(registerdeviceresponse.getUserName());
        accountdatacollector.setDeviceName(registerdeviceresponse.getDeviceName());
        UserProperties.storeDeviceName(AccountRegistrar.access$100(AccountRegistrar.this), val$directedId, registerdeviceresponse.getDeviceName());
        String s = registerdeviceresponse.getEmail();
        if (s != null)
        {
            accountdatacollector.setDeviceEmail(s);
        } else
        {
            MAPLog.i(AccountRegistrar.access$000(), "Was not able to updated device email since it was not returned");
        }
        accountdatacollector.setAdpToken(registerdeviceresponse.getAdpToken());
        accountdatacollector.setPrivateKey(registerdeviceresponse.getPrivateKey());
        accountdatacollector.setDirectedId(registerdeviceresponse.getDirectedId());
        registerdeviceresponse = getCookieJar(registerdeviceresponse);
        accountdatacollector.setXMainToken(registerdeviceresponse.getXmain());
        accountdatacollector.setXMainAndXAcbCookies(registerdeviceresponse.getInternationalXMainAndXAcbCookies());
        return new gisterInfo(accountdatacollector.getCurrentUserData());
    }

    stener(String s)
    {
        this$0 = final_accountregistrar;
        val$directedId = s;
        super(stener.this);
    }
}

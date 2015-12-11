// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import com.comcast.cim.model.user.AuthKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.authentication:
//            UserCredentials, AuthResponseHandler

public class AuthenticationClient
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/authentication/AuthenticationClient);
    private final AndroidDevice androidDevice;
    private final HttpService authService;
    private final ObjectMapper objectMapper;
    private final XipRequestProviderFactory requestProviderFactory;

    public AuthenticationClient(AndroidDevice androiddevice, HttpService httpservice, XipRequestProviderFactory xiprequestproviderfactory, ObjectMapper objectmapper)
    {
        objectMapper = objectmapper;
        Validate.notNull(androiddevice);
        Validate.notNull(httpservice);
        androidDevice = androiddevice;
        authService = httpservice;
        requestProviderFactory = xiprequestproviderfactory;
    }

    public AuthKeys authenticate(UserCredentials usercredentials)
    {
        LOG.debug("authenticating");
        RequestProvider requestprovider = requestProviderFactory.create("login", "POST");
        requestprovider.addHttpEntityParameter("username", usercredentials.getUsername());
        requestprovider.addHttpEntityParameter("password", usercredentials.getPassword());
        requestprovider.addHttpEntityParameter("deviceId", androidDevice.getDeviceId());
        requestprovider.addHttpEntityParameter("deviceName", androidDevice.getDeviceName());
        requestprovider.addHttpEntityParameter("deviceType", androidDevice.getDeviceType());
        requestprovider.addHttpEntityParameter("appId", androidDevice.getAppId());
        LOG.debug("generated requestProvider");
        usercredentials = (AuthResponseHandler)authService.executeRequest(requestprovider, new Provider() {

            final AuthenticationClient this$0;

            public AuthResponseHandler get()
            {
                return new AuthResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = AuthenticationClient.this;
                super();
            }
        });
        LOG.debug("executed requestProvider");
        return usercredentials.getAuthKeys();
    }


}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.request.signing.SignedHTTPRequestProvider;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import com.comcast.cim.model.user.AuthKeys;
import com.comcast.cim.model.user.XipUser;
import com.fasterxml.jackson.databind.ObjectMapper;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            RegisterDeviceResponseHandler, DeviceRegistration

public class RegisterDeviceClient
{

    private final String deviceDisplayName;
    private final ObjectMapper objectMapper;
    private final HttpService registerDeviceService;
    private final XipRequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;

    public RegisterDeviceClient(HttpService httpservice, AndroidDevice androiddevice, ObjectMapper objectmapper, XipRequestProviderFactory xiprequestproviderfactory, RequestSignerFactory requestsignerfactory)
    {
        registerDeviceService = httpservice;
        deviceDisplayName = androiddevice.getDeviceDisplayName();
        requestProviderFactory = xiprequestproviderfactory;
        requestSignerFactory = requestsignerfactory;
        objectMapper = objectmapper;
    }

    public DeviceRegistration registerDevice(XipUser xipuser)
    {
        xipuser = new SignedHTTPRequestProvider(requestProviderFactory.create("proxy/ams/xip/device/download/register", "POST"), requestSignerFactory.create(xipuser.getAuthKeys().getConsumerKey(), xipuser.getAuthKeys().getConsumerSecret()));
        xipuser.addHttpEntityParameter("mso", "comcast");
        xipuser.addHttpEntityParameter("deviceName", deviceDisplayName);
        xipuser.setSocketTimeout(15000L);
        return ((RegisterDeviceResponseHandler)registerDeviceService.executeRequest(xipuser, new Provider() {

            final RegisterDeviceClient this$0;

            public RegisterDeviceResponseHandler get()
            {
                return new RegisterDeviceResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = RegisterDeviceClient.this;
                super();
            }
        })).getDeviceRegistration();
    }

}

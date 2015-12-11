// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.request.signing.SignedHTTPRequestProvider;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import com.comcast.cim.model.user.AuthKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            RegistrationListResponseHandler

public class RegistrationListClient
{

    private final ObjectMapper objectMapper;
    private final HttpService registrationListHttpService;
    private final XipRequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;

    public RegistrationListClient(HttpService httpservice, ObjectMapper objectmapper, XipRequestProviderFactory xiprequestproviderfactory, RequestSignerFactory requestsignerfactory)
    {
        registrationListHttpService = httpservice;
        objectMapper = objectmapper;
        requestProviderFactory = xiprequestproviderfactory;
        requestSignerFactory = requestsignerfactory;
    }

    public List getDeviceRegistrationList(AuthKeys authkeys)
    {
        authkeys = new SignedHTTPRequestProvider(requestProviderFactory.create("proxy/ams/xip/device/download/devices", "GET"), requestSignerFactory.create(authkeys.getConsumerKey(), authkeys.getConsumerSecret()));
        authkeys.setSocketTimeout(15000L);
        return ((RegistrationListResponseHandler)registrationListHttpService.executeRequest(authkeys, new Provider() {

            final RegistrationListClient this$0;

            public RegistrationListResponseHandler get()
            {
                return new RegistrationListResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = RegistrationListClient.this;
                super();
            }
        })).getDeviceList();
    }

}

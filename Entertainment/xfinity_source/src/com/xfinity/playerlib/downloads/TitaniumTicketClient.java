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
import com.xfinity.playerlib.model.consumable.hal.HalVideoProfile;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            TitaniumTicketResponseHandler, TitaniumTicket

public class TitaniumTicketClient
{

    private final ObjectMapper objectMapper;
    private final XipRequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;
    private final HttpService titaniumTicketService;

    public TitaniumTicketClient(HttpService httpservice, ObjectMapper objectmapper, XipRequestProviderFactory xiprequestproviderfactory, RequestSignerFactory requestsignerfactory)
    {
        titaniumTicketService = httpservice;
        objectMapper = objectmapper;
        requestProviderFactory = xiprequestproviderfactory;
        requestSignerFactory = requestsignerfactory;
    }

    public TitaniumTicket getTitaniumTicket(AuthKeys authkeys, VideoEntitlement videoentitlement, HalVideoProfile halvideoprofile)
    {
        authkeys = new SignedHTTPRequestProvider(requestProviderFactory.create("proxy/ams/video/titanium-access", "POST"), requestSignerFactory.create(authkeys.getConsumerKey(), authkeys.getConsumerSecret()));
        try
        {
            videoentitlement = URLDecoder.decode(videoentitlement.getXedata(), "UTF-8");
            halvideoprofile = URLDecoder.decode(halvideoprofile.getSecData(), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (AuthKeys authkeys)
        {
            throw new RuntimeException(authkeys);
        }
        authkeys.addHttpEntityParameter("mso", "comcast");
        authkeys.addHttpEntityParameter("svm", halvideoprofile);
        authkeys.addHttpEntityParameter("xedata", videoentitlement);
        authkeys.addHttpEntityParameter("drmType", "adobeAccess");
        authkeys.setSocketTimeout(15000L);
        return ((TitaniumTicketResponseHandler)titaniumTicketService.executeRequest(authkeys, new Provider() {

            final TitaniumTicketClient this$0;

            public TitaniumTicketResponseHandler get()
            {
                return new TitaniumTicketResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = TitaniumTicketClient.this;
                super();
            }
        })).getTitaniumTicket();
    }

}

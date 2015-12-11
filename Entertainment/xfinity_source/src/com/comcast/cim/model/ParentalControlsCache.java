// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model;

import com.comcast.cim.cmasl.http.request.DefaultCacheableRequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.request.signing.SignedHTTPRequestProvider;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.XipServer;
import com.comcast.cim.http.parentalcontrols.ParentalControlsResponseHandler;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import com.comcast.cim.model.user.AuthKeys;
import com.comcast.cim.model.user.UserManager;
import com.comcast.cim.model.user.XipUser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParentalControlsCache extends RevalidatingCachingTask
{

    private final HttpService httpService;
    private final ObjectMapper objectMapper;
    private final RequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;
    private final UserManager userManager;
    private final XipServer xipServer;

    public ParentalControlsCache(HttpService httpservice, RevalidationPolicy revalidationpolicy, XipServer xipserver, UserManager usermanager, ObjectMapper objectmapper, RequestProviderFactory requestproviderfactory, RequestSignerFactory requestsignerfactory)
    {
        super(revalidationpolicy);
        userManager = usermanager;
        httpService = httpservice;
        xipServer = xipserver;
        objectMapper = objectmapper;
        requestProviderFactory = requestproviderfactory;
        requestSignerFactory = requestsignerfactory;
    }

    protected ParentalControlsSettings fetchResourceWithNoCache()
    {
        Object obj1 = (XipUser)userManager.getUser();
        Object obj = ((XipUser) (obj1)).getAuthKeys();
        obj1 = ((XipUser) (obj1)).getUserName();
        obj = new DefaultCacheableRequestProvider(new SignedHTTPRequestProvider(requestProviderFactory.create((new StringBuilder()).append(xipServer).append("proxy/parentalcontrols/user/summary").toString()), requestSignerFactory.create(((AuthKeys) (obj)).getConsumerKey(), ((AuthKeys) (obj)).getConsumerSecret())), ((String) (obj1)));
        return ((ParentalControlsResponseHandler)httpService.executeRequest(((com.comcast.cim.cmasl.http.request.RequestProvider) (obj)), new Provider() {

            final ParentalControlsCache this$0;

            public ParentalControlsResponseHandler get()
            {
                return new ParentalControlsResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = ParentalControlsCache.this;
                super();
            }
        })).getParentalControlsSettings();
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }

}

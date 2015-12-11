// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.entitlement;

import com.comcast.cim.cmasl.http.request.DefaultCacheableRequestProvider;
import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.request.signing.SignedHTTPRequestProvider;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import com.comcast.cim.model.user.AuthKeys;
import com.comcast.cim.model.user.UserManager;
import com.comcast.cim.model.user.XipUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.xfinity.playerlib.model.entitlement:
//            EntitlementResponseHandler, VideoEntitlement

public class VideoEntitlementCache extends RevalidatingCachingTask
{

    private HttpService httpService;
    private final ObjectMapper objectMapper;
    private final XipRequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;
    private UserManager userManager;

    public VideoEntitlementCache(HttpService httpservice, RevalidationPolicy revalidationpolicy, UserManager usermanager, XipRequestProviderFactory xiprequestproviderfactory, RequestSignerFactory requestsignerfactory, ObjectMapper objectmapper)
    {
        super(revalidationpolicy);
        Validate.notNull(httpservice);
        Validate.notNull(usermanager);
        httpService = httpservice;
        userManager = usermanager;
        requestProviderFactory = xiprequestproviderfactory;
        requestSignerFactory = requestsignerfactory;
        objectMapper = objectmapper;
    }

    protected VideoEntitlement fetchResourceWithNoCache()
    {
        Object obj1 = (XipUser)userManager.getUser();
        Object obj = ((XipUser) (obj1)).getAuthKeys();
        obj1 = ((XipUser) (obj1)).getUserName();
        obj = new DefaultCacheableRequestProvider(new SignedHTTPRequestProvider(requestProviderFactory.create("proxy/edata/entitlement"), requestSignerFactory.create(((AuthKeys) (obj)).getConsumerKey(), ((AuthKeys) (obj)).getConsumerSecret())), ((String) (obj1)));
        return ((EntitlementResponseHandler)httpService.executeRequest(((com.comcast.cim.cmasl.http.request.RequestProvider) (obj)), new Provider() {

            final VideoEntitlementCache this$0;

            public EntitlementResponseHandler get()
            {
                return new EntitlementResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = VideoEntitlementCache.this;
                super();
            }
        })).getVideoEntitlement();
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }

}

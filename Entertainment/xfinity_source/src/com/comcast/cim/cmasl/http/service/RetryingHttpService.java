// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.service;

import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.http.response.ResponseHandler;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.utils.provider.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.http.service:
//            HttpService

public class RetryingHttpService
    implements HttpService
{
    public static interface RetryPredicate
    {

        public abstract boolean shouldRetry(CimException cimexception, int i);
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/http/service/RetryingHttpService);
    private final HttpService delegateService;
    private final RetryPredicate predicate;

    public RetryingHttpService(HttpService httpservice, RetryPredicate retrypredicate)
    {
        delegateService = httpservice;
        predicate = retrypredicate;
    }

    public ResponseHandler executeRequest(RequestProvider requestprovider, Provider provider)
    {
        int i = 0;
_L2:
        ResponseHandler responsehandler = delegateService.executeRequest(requestprovider, provider);
        return responsehandler;
        CimException cimexception;
        cimexception;
        if (predicate.shouldRetry(cimexception, i))
        {
            LOG.warn("Caught exception processing request, retrying", cimexception);
            i++;
        } else
        {
            throw cimexception;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

}

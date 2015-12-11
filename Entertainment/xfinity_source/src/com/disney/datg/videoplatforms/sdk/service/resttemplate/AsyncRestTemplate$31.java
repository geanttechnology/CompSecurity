// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.resttemplate;

import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import java.util.List;
import java.util.concurrent.Callable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.resttemplate:
//            AsyncRestTemplate, RestTemplateRequest

class val.asyncHandler
    implements Callable
{

    final AsyncRestTemplate this$0;
    final HttpRequestHandler val$asyncHandler;
    final Request val$request;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public ResponseEntity call()
    {
        ResponseEntity responseentity;
        ResponseEntity responseentity1;
        ResponseEntity responseentity2;
        ResponseEntity responseentity3;
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        responseentity = null;
        responseentity1 = responseentity;
        responseentity2 = obj;
        responseentity3 = obj1;
        .SwitchMap.org.springframework.http.HttpMethod[val$request.getHttpMethod().ordinal()];
        JVM INSTR tableswitch 1 1: default 219
    //                   1 132;
           goto _L1 _L2
_L1:
        responseentity1 = responseentity;
        responseentity2 = obj;
        responseentity3 = obj1;
        try
        {
            responseentity = AsyncRestTemplate.access$000(AsyncRestTemplate.this).exchange(val$request.getServiceUri(), val$request.getHttpMethod(), ((RestTemplateRequest)val$request).createHttpEntity(), val$request.getResponseType());
        }
        catch (HttpStatusCodeException httpstatuscodeexception)
        {
            val$asyncHandler.onError(val$request, httpstatuscodeexception);
            return responseentity1;
        }
        catch (ResourceAccessException resourceaccessexception)
        {
            val$asyncHandler.onError(val$request, resourceaccessexception);
            return responseentity2;
        }
        catch (RestClientException restclientexception)
        {
            val$asyncHandler.onError(val$request, restclientexception);
            return responseentity3;
        }
        responseentity1 = responseentity;
        responseentity2 = responseentity;
        responseentity3 = responseentity;
        val$asyncHandler.onResponse(val$request, responseentity);
        return responseentity;
_L2:
        responseentity1 = responseentity;
        responseentity2 = obj;
        responseentity3 = obj1;
        AsyncRestTemplate.access$000(AsyncRestTemplate.this).getMessageConverters().add(new FormHttpMessageConverter());
        if (true) goto _L1; else goto _L3
_L3:
    }

    ()
    {
        this$0 = final_asyncresttemplate;
        val$request = request1;
        val$asyncHandler = HttpRequestHandler.this;
        super();
    }
}

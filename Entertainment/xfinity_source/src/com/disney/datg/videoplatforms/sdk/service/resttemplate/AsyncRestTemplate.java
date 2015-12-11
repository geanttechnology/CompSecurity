// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.resttemplate;

import com.disney.datg.videoplatforms.sdk.common.ThreadPoolAccessor;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.resttemplate:
//            RestTemplateRequest

public class AsyncRestTemplate
{

    private static String TAG = "AsyncRestTemplate";
    private RestTemplate restTemplate;

    public AsyncRestTemplate(RestTemplate resttemplate)
    {
        restTemplate = resttemplate;
    }

    public Future exchange(final Request request, final HttpRequestHandler asyncHandler)
    {
        if (asyncHandler != null)
        {
            asyncHandler.onRequest(request);
        }
        return ThreadPoolAccessor.getManager().execute(new Callable() {

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
                static class _cls35
                {

                    static final int $SwitchMap$org$springframework$http$HttpMethod[];

                    static 
                    {
                        $SwitchMap$org$springframework$http$HttpMethod = new int[HttpMethod.values().length];
                        try
                        {
                            $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.POST.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror) { }
                    }
                }

                _cls35..SwitchMap.org.springframework.http.HttpMethod[request.getHttpMethod().ordinal()];
                JVM INSTR tableswitch 1 1: default 219
            //                           1 132;
                   goto _L1 _L2
_L1:
                responseentity1 = responseentity;
                responseentity2 = obj;
                responseentity3 = obj1;
                try
                {
                    responseentity = restTemplate.exchange(request.getServiceUri(), request.getHttpMethod(), ((RestTemplateRequest)request).createHttpEntity(), request.getResponseType());
                }
                catch (HttpStatusCodeException httpstatuscodeexception)
                {
                    asyncHandler.onError(request, httpstatuscodeexception);
                    return responseentity1;
                }
                catch (ResourceAccessException resourceaccessexception)
                {
                    asyncHandler.onError(request, resourceaccessexception);
                    return responseentity2;
                }
                catch (RestClientException restclientexception)
                {
                    asyncHandler.onError(request, restclientexception);
                    return responseentity3;
                }
                responseentity1 = responseentity;
                responseentity2 = responseentity;
                responseentity3 = responseentity;
                asyncHandler.onResponse(request, responseentity);
                return responseentity;
_L2:
                responseentity1 = responseentity;
                responseentity2 = obj;
                responseentity3 = obj1;
                restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = AsyncRestTemplate.this;
                request = request1;
                asyncHandler = httprequesthandler;
                super();
            }
        });
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
    }

    public Future getForObject(final Request request, final HttpRequestHandler asyncHandler)
    {
        if (asyncHandler != null)
        {
            asyncHandler.onRequest(request);
        }
        return ThreadPoolAccessor.getManager().execute(new Callable() {

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
                Object obj1;
                Object obj2;
                Object obj4;
                Object obj5;
                Object obj6;
                obj1 = null;
                obj2 = null;
                obj4 = null;
                obj5 = null;
                obj6 = null;
                _cls35..SwitchMap.org.springframework.http.HttpMethod[request.getHttpMethod().ordinal()];
                JVM INSTR tableswitch 1 1: default 244
            //                           1 120;
                   goto _L1 _L2
_L1:
                byte abyte0[] = (byte[])restTemplate.getForObject(request.getServiceUri(), [B);
                Object obj;
                obj = obj6;
                if (abyte0 == null)
                {
                    break MISSING_BLOCK_LABEL_118;
                }
                obj = obj6;
                if (abyte0.length <= 0)
                {
                    break MISSING_BLOCK_LABEL_118;
                }
                obj = new ResponseEntity(abyte0, HttpStatus.OK);
                asyncHandler.onResponse(request, ((ResponseEntity) (obj)));
                return ((ResponseEntity) (obj));
_L2:
                restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
                  goto _L1
                obj;
_L10:
                asyncHandler.onError(request, ((Exception) (obj)));
                return ((ResponseEntity) (obj1));
                obj;
                obj1 = obj2;
_L8:
                asyncHandler.onError(request, ((Exception) (obj)));
                return ((ResponseEntity) (obj1));
                obj;
                obj1 = obj4;
_L6:
                asyncHandler.onError(request, ((Exception) (obj)));
                return ((ResponseEntity) (obj1));
                obj;
                obj1 = obj5;
_L4:
                ((Exception) (obj)).printStackTrace();
                return ((ResponseEntity) (obj1));
                Object obj3;
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L4; else goto _L3
_L3:
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L6; else goto _L5
_L5:
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L8; else goto _L7
_L7:
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L10; else goto _L9
_L9:
            }

            
            {
                this$0 = AsyncRestTemplate.this;
                request = request1;
                asyncHandler = httprequesthandler;
                super();
            }
        });
    }


}

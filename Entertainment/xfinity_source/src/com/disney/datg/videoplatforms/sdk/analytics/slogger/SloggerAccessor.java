// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics.slogger;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.service.Accessor;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import com.disney.datg.videoplatforms.sdk.service.resttemplate.RestTemplateRequest;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics.slogger:
//            SloggerDeserializer

public class SloggerAccessor extends Accessor
{

    private Map headers;

    public SloggerAccessor(String s, Map map, HttpRequestHandler httprequesthandler)
    {
        super(s, httprequesthandler);
        headers = map;
    }

    public Future getServiceAsync()
        throws AndroidSDKException
    {
        Object obj;
        try
        {
            obj = new RestTemplateRequest(new URI(getServiceEndpoint()), HttpMethod.GET, [B);
            ((Request) (obj)).setHeaders(new HttpHeaders());
            if (headers != null)
            {
                Iterator iterator = headers.keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    if (headers.get(s) != null)
                    {
                        ((Request) (obj)).addHeader(s, (String)headers.get(s));
                    }
                } while (true);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (getRequestHandler() != null)
            {
                getRequestHandler().onError(null, ((Exception) (obj)));
            }
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_INVALID_HOST, ((URISyntaxException) (obj)).getMessage());
        }
        catch (Exception exception)
        {
            if (getRequestHandler() != null)
            {
                getRequestHandler().onError(null, exception);
            }
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_INVALID_HOST, exception.getMessage());
        }
        obj = (new SloggerDeserializer(new ByteArrayHttpMessageConverter(), [B)).getForObjectAsync(((Request) (obj)), getTimeout(), new HttpRequestHandler() {

            final SloggerAccessor this$0;

            public void onError(Request request, Exception exception1)
            {
label0:
                {
                    if (getRequestHandler() != null)
                    {
                        if (!(exception1 instanceof HttpStatusCodeException))
                        {
                            break label0;
                        }
                        getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR));
                    }
                    return;
                }
                if (exception1 instanceof ResourceAccessException)
                {
                    if (exception1.getCause() instanceof SocketTimeoutException)
                    {
                        getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR));
                        return;
                    } else
                    {
                        getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR));
                        return;
                    }
                } else
                {
                    getRequestHandler().onError(request, exception1);
                    return;
                }
            }

            public void onRequest(Request request)
            {
                if (getRequestHandler() != null)
                {
                    getRequestHandler().onRequest(request);
                }
            }

            public void onResponse(Request request, ResponseEntity responseentity)
            {
                if (getRequestHandler() != null)
                {
                    HttpStatus httpstatus = responseentity.getStatusCode();
                    if (httpstatus == HttpStatus.CREATED)
                    {
                        getRequestHandler().onResponse(request, responseentity);
                    } else
                    if (httpstatus == HttpStatus.NOT_FOUND)
                    {
                        getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR));
                        return;
                    }
                }
            }

            
            {
                this$0 = SloggerAccessor.this;
                super();
            }
        });
        return ((Future) (obj));
    }










}

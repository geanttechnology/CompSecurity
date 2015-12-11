// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.service.resttemplate.RestTemplateRequest;
import com.disney.datg.videoplatforms.sdk.service.serialization.ConfigApiDeserializer;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Future;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service:
//            Accessor, HttpRequestHandler, Request

public class ConfigAccessor extends Accessor
{

    public ConfigAccessor(String s, HttpRequestHandler httprequesthandler)
    {
        super(s, httprequesthandler);
    }

    public Future getServiceAsync()
        throws AndroidSDKException
    {
        Object obj;
        try
        {
            obj = new RestTemplateRequest(new URI(getServiceEndpoint()), HttpMethod.GET, com/disney/datg/videoplatforms/sdk/models/api/Config);
            obj = (new ConfigApiDeserializer()).executeAsync(((Request) (obj)), getTimeout(), new HttpRequestHandler() {

                final ConfigAccessor this$0;

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
                            getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_ERROR));
                        }
                        return;
                    }
                    if (exception1 instanceof ResourceAccessException)
                    {
                        if (exception1.getCause() instanceof SocketTimeoutException)
                        {
                            getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_TIMEOUT));
                            return;
                        } else
                        {
                            getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_IO_ERROR));
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
label0:
                    {
label1:
                        {
                            if (getRequestHandler() != null)
                            {
                                if (!responseentity.hasBody())
                                {
                                    break label0;
                                }
                                Config config = (Config)responseentity.getBody();
                                if (config == null || config.getFeatures() == null || config.getWebservices() == null)
                                {
                                    break label1;
                                }
                                getRequestHandler().onResponse(request, responseentity);
                            }
                            return;
                        }
                        getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_ERROR));
                        return;
                    }
                    getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_ERROR));
                }

            
            {
                this$0 = ConfigAccessor.this;
                super();
            }
            });
        }
        catch (URISyntaxException urisyntaxexception)
        {
            if (getRequestHandler() != null)
            {
                getRequestHandler().onError(null, urisyntaxexception);
            }
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_INVALID_HOST, urisyntaxexception.getMessage());
        }
        catch (Exception exception)
        {
            if (getRequestHandler() != null)
            {
                getRequestHandler().onError(null, exception);
            }
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_INVALID_HOST, exception.getMessage());
        }
        return ((Future) (obj));
    }
}

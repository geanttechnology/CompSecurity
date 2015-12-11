// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.service.resttemplate.RestTemplateRequest;
import com.disney.datg.videoplatforms.sdk.service.serialization.GeoApiDeserializer;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Future;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service:
//            Accessor, HttpRequestHandler, Request

public class GeoAccessor extends Accessor
{

    private MultiValueMap postParams;

    public GeoAccessor(String s, MultiValueMap multivaluemap, HttpRequestHandler httprequesthandler)
    {
        super(s, httprequesthandler);
        postParams = multivaluemap;
    }

    public Future getServiceAsync()
        throws AndroidSDKException
    {
        Object obj;
        try
        {
            obj = new RestTemplateRequest(new URI(getServiceEndpoint()), HttpMethod.POST, null, postParams, com/disney/datg/videoplatforms/sdk/models/api/GeoLocation);
            obj = (new GeoApiDeserializer()).executeAsync(((Request) (obj)), getTimeout(), new HttpRequestHandler() {

                final GeoAccessor this$0;

                public void onError(Request request, Exception exception)
                {
label0:
                    {
                        if (getRequestHandler() != null)
                        {
                            if (!(exception instanceof HttpStatusCodeException))
                            {
                                break label0;
                            }
                            getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_ERROR));
                        }
                        return;
                    }
                    if (exception instanceof ResourceAccessException)
                    {
                        if (exception.getCause() instanceof SocketTimeoutException)
                        {
                            getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_TIMEOUT));
                            return;
                        } else
                        {
                            getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_IO_ERROR));
                            return;
                        }
                    } else
                    {
                        getRequestHandler().onError(request, exception);
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
                                GeoLocation geolocation = (GeoLocation)responseentity.getBody();
                                if (geolocation == null || geolocation.getUser() == null)
                                {
                                    break label1;
                                }
                                getRequestHandler().onResponse(request, responseentity);
                            }
                            return;
                        }
                        getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_ERROR));
                        return;
                    }
                    getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_ERROR));
                }

            
            {
                this$0 = GeoAccessor.this;
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
        return ((Future) (obj));
    }
}

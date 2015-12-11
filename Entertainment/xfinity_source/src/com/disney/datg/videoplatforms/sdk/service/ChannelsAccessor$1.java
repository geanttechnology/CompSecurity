// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.api.Channels;
import java.net.SocketTimeoutException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service:
//            HttpRequestHandler, ChannelsAccessor, Request

class this._cls0
    implements HttpRequestHandler
{

    final ChannelsAccessor this$0;

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
                getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR));
            }
            return;
        }
        if (exception instanceof ResourceAccessException)
        {
            if (exception.getCause() instanceof SocketTimeoutException)
            {
                getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT));
                return;
            } else
            {
                getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_IO_ERROR));
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
                    Channels channels = (Channels)responseentity.getBody();
                    if (channels == null || channels.getChannel() == null)
                    {
                        break label1;
                    }
                    getRequestHandler().onResponse(request, responseentity);
                }
                return;
            }
            getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR));
            return;
        }
        getRequestHandler().onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR));
    }

    ()
    {
        this$0 = ChannelsAccessor.this;
        super();
    }
}

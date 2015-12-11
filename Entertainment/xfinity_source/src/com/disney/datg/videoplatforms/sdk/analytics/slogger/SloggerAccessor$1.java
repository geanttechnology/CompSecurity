// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics.slogger;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import java.net.SocketTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics.slogger:
//            SloggerAccessor

class this._cls0
    implements HttpRequestHandler
{

    final SloggerAccessor this$0;

    public void onError(Request request, Exception exception)
    {
label0:
        {
            if (SloggerAccessor.access$500(SloggerAccessor.this) != null)
            {
                if (!(exception instanceof HttpStatusCodeException))
                {
                    break label0;
                }
                SloggerAccessor.access$600(SloggerAccessor.this).onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR));
            }
            return;
        }
        if (exception instanceof ResourceAccessException)
        {
            if (exception.getCause() instanceof SocketTimeoutException)
            {
                SloggerAccessor.access$700(SloggerAccessor.this).onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR));
                return;
            } else
            {
                SloggerAccessor.access$800(SloggerAccessor.this).onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR));
                return;
            }
        } else
        {
            SloggerAccessor.access$900(SloggerAccessor.this).onError(request, exception);
            return;
        }
    }

    public void onRequest(Request request)
    {
        if (SloggerAccessor.access$300(SloggerAccessor.this) != null)
        {
            SloggerAccessor.access$400(SloggerAccessor.this).onRequest(request);
        }
    }

    public void onResponse(Request request, ResponseEntity responseentity)
    {
        if (SloggerAccessor.access$000(SloggerAccessor.this) != null)
        {
            HttpStatus httpstatus = responseentity.getStatusCode();
            if (httpstatus == HttpStatus.CREATED)
            {
                SloggerAccessor.access$100(SloggerAccessor.this).onResponse(request, responseentity);
            } else
            if (httpstatus == HttpStatus.NOT_FOUND)
            {
                SloggerAccessor.access$200(SloggerAccessor.this).onError(request, new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR));
                return;
            }
        }
    }

    ()
    {
        this$0 = SloggerAccessor.this;
        super();
    }
}

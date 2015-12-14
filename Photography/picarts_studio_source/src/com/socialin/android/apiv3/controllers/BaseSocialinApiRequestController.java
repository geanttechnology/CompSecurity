// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.content.Context;
import android.text.TextUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.SocialinApiException;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.util.ApiRequestStatus;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import com.socialin.asyncnet.d;

public abstract class BaseSocialinApiRequestController
    implements ApiRequestStatus, d
{

    protected int cacheConfig;
    protected int code;
    public d listener;
    public RequestParams params;
    protected int status;

    public BaseSocialinApiRequestController()
    {
        status = -1;
        cacheConfig = getDefaultCacheConfig();
    }

    public BaseSocialinApiRequestController(Context context)
    {
        status = -1;
        cacheConfig = getDefaultCacheConfig();
    }

    public void cancelRequest(String s)
    {
        b.a().a(getRequestId());
        if (!TextUtils.isEmpty(s))
        {
            b.a().a(s);
        }
        status = -1;
    }

    public void doRequest()
    {
        doRequest(null);
    }

    public void doRequest(String s)
    {
        doRequest(s, params);
    }

    public abstract void doRequest(String s, RequestParams requestparams);

    public int getCacheConfig()
    {
        return cacheConfig;
    }

    public int getCode()
    {
        return code;
    }

    public int getDefaultCacheConfig()
    {
        return 4;
    }

    public int getRequestId()
    {
        return -1;
    }

    public RequestParams getRequestParams()
    {
        return params;
    }

    public int getRequestStatus()
    {
        return status;
    }

    public void onCancelRequest(Response response, Request request)
    {
    }

    public volatile void onCancelRequest(Object obj, Request request)
    {
        onCancelRequest((Response)obj, request);
    }

    public void onFailure(Exception exception, Request request)
    {
        status = 1;
        if (listener != null)
        {
            listener.onFailure(exception, request);
        }
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
        if (listener != null)
        {
            listener.onProgressUpdate(ainteger);
        }
    }

    public void onSuccess(Response response, Request request)
    {
        if (response != null && !"error".equals(response.status)) goto _L2; else goto _L1
_L1:
        if (response == null) goto _L4; else goto _L3
_L3:
        if ("user_not_found".equals(response.reason))
        {
            SocialinV3.getInstance().logoutUser();
        }
        onFailure(new SocialinApiException(response.status, response.message, response.reason), request);
_L6:
        return;
_L4:
        onFailure(new SocialinApiException("-1", "Result object is null", ""), request);
        return;
_L2:
        status = 2;
        if (listener != null)
        {
            listener.onSuccess(response, request);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((Response)obj, request);
    }

    public void setCacheConfig(int i)
    {
        cacheConfig = i;
    }

    public void setCode(int i)
    {
        code = i;
    }

    public void setRequestCompleteListener(d d1)
    {
        listener = d1;
    }

    public void setRequestParams(RequestParams requestparams)
    {
        params = requestparams;
    }
}

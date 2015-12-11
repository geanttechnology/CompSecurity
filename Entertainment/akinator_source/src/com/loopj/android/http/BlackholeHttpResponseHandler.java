// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, ResponseHandlerInterface

public class BlackholeHttpResponseHandler extends AsyncHttpResponseHandler
{

    public BlackholeHttpResponseHandler()
    {
    }

    public void onCancel()
    {
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onFinish()
    {
    }

    public void onPostProcessResponse(ResponseHandlerInterface responsehandlerinterface, HttpResponse httpresponse)
    {
    }

    public void onPreProcessResponse(ResponseHandlerInterface responsehandlerinterface, HttpResponse httpresponse)
    {
    }

    public void onProgress(long l, long l1)
    {
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
    }

    public void onUserException(Throwable throwable)
    {
    }
}

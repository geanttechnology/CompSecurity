// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Message;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, SyncHttpClient

class Handler extends AsyncHttpResponseHandler
{

    final SyncHttpClient this$0;

    public void onFailure(Throwable throwable, String s)
    {
        SyncHttpClient.access$102(SyncHttpClient.this, onRequestFailed(throwable, s));
    }

    public void onSuccess(String s)
    {
        SyncHttpClient.access$102(SyncHttpClient.this, s);
    }

    protected void sendMessage(Message message)
    {
        handleMessage(message);
    }

    void sendResponseMessage(HttpResponse httpresponse)
    {
        SyncHttpClient.access$002(SyncHttpClient.this, httpresponse.getStatusLine().getStatusCode());
        super.sendResponseMessage(httpresponse);
    }

    Handler()
    {
        this$0 = SyncHttpClient.this;
        super();
    }
}

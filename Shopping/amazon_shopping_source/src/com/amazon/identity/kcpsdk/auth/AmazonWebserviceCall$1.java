// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            AmazonWebserviceCallResponseParser, AmazonWebserviceCall, ParseErrorException, IAmazonWebServiceCallback

class this._cls0
    implements AmazonWebserviceCallResponseParser
{

    final AmazonWebserviceCall this$0;

    public String getErrorCode(HttpURLConnection httpurlconnection)
    {
        return null;
    }

    public Object parse(WebResponseHeaders webresponseheaders, byte abyte0[])
        throws ParseErrorException, IOException
    {
        mWebServiceCallback.onHeadersReceived(webresponseheaders);
        if (abyte0 != null)
        {
            mWebServiceCallback.onBodyChunkReceived(abyte0, abyte0.length);
        }
        MAPLog.i(AmazonWebserviceCall.access$000(), "Request complete");
        mWebServiceCallback.onRequestComplete();
        return null;
    }

    ck()
    {
        this$0 = AmazonWebserviceCall.this;
        super();
    }
}

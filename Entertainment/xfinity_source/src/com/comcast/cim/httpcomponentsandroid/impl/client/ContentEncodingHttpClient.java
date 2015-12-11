// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.client.protocol.RequestAcceptEncoding;
import com.comcast.cim.httpcomponentsandroid.client.protocol.ResponseContentEncoding;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.BasicHttpProcessor;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client:
//            DefaultHttpClient

public class ContentEncodingHttpClient extends DefaultHttpClient
{

    public ContentEncodingHttpClient()
    {
        this(null);
    }

    public ContentEncodingHttpClient(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        super(clientconnectionmanager, httpparams);
    }

    public ContentEncodingHttpClient(HttpParams httpparams)
    {
        this(null, httpparams);
    }

    protected BasicHttpProcessor createHttpProcessor()
    {
        BasicHttpProcessor basichttpprocessor = super.createHttpProcessor();
        basichttpprocessor.addRequestInterceptor(new RequestAcceptEncoding());
        basichttpprocessor.addResponseInterceptor(new ResponseContentEncoding());
        return basichttpprocessor;
    }
}

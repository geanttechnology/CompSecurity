// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpProcessor;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
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

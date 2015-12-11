// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.content.Context;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.kcpsdk.common.IWebResponseParser;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import java.io.IOException;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            IAmazonWebserviceCaller, ParseErrorException, AmazonWebserviceCall, StandardAmazonWebServiceCallback, 
//            WebResponseParserAdapter, RequestSigner, AmazonWebserviceCallResponseParser, IAmazonWebserviceCallListener, 
//            IAmazonWebserviceCall

public class AmazonWebserviceCaller
    implements IAmazonWebserviceCaller
{

    private final Context mContext;
    private RequestSigner mRequestSigner;
    private final Tracer mTracer;

    public AmazonWebserviceCaller(Context context, RequestSigner requestsigner, Tracer tracer)
    {
        mRequestSigner = null;
        mRequestSigner = requestsigner;
        mContext = context;
        mTracer = tracer;
    }

    public Object call$2b76e8ff(WebRequest webrequest, AmazonWebserviceCallResponseParser amazonwebservicecallresponseparser)
        throws IOException, ParseErrorException
    {
        return AmazonWebserviceCall.run(mContext, webrequest, amazonwebservicecallresponseparser, mRequestSigner, mTracer);
    }

    public IAmazonWebserviceCall createCall(WebRequest webrequest, IWebResponseParser iwebresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener)
    {
        iwebresponseparser = new StandardAmazonWebServiceCallback(iwebresponseparser, iamazonwebservicecalllistener, webrequest.getAuthenticationRequired());
        return new AmazonWebserviceCall(mContext, webrequest, iwebresponseparser, mRequestSigner, mTracer);
    }

    public IAmazonWebserviceCall createCall(WebRequest webrequest, WebResponseParser webresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener)
    {
        return createCall(webrequest, ((IWebResponseParser) (new WebResponseParserAdapter(webresponseparser))), iamazonwebservicecalllistener);
    }
}

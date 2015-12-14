// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.credentials.AccountCredentialsHolder;
import com.amazon.identity.kcpsdk.auth.AmazonWebserviceCallResponseParser;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCall;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCaller;
import com.amazon.identity.kcpsdk.auth.ParseErrorException;
import com.amazon.identity.kcpsdk.auth.RequestSigner;
import com.amazon.identity.kcpsdk.auth.StandardAmazonWebServiceCallback;
import com.amazon.identity.kcpsdk.auth.WebResponseParserAdapter;
import com.amazon.identity.kcpsdk.common.IWebResponseParser;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import java.io.IOException;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AsyncAmazonWebserviceCall, Tracer

public class AsyncAmazonWebserviceCaller
    implements IAmazonWebserviceCaller
{

    private Context mContext;
    private AccountCredentials mCredentials;
    private RequestSigner mRequestSigner;
    private final Tracer mTracer;

    public AsyncAmazonWebserviceCaller(Context context, AccountCredentials accountcredentials, Tracer tracer)
    {
        mContext = null;
        mRequestSigner = null;
        mCredentials = null;
        mContext = context;
        mCredentials = accountcredentials;
        mRequestSigner = new RequestSigner(mCredentials);
        mTracer = tracer;
    }

    public AsyncAmazonWebserviceCaller(Context context, String s, Tracer tracer)
    {
        this(context, AccountCredentialsHolder.getCredentialsForAccount(context, s), tracer);
    }

    public Object call$2b76e8ff(WebRequest webrequest, AmazonWebserviceCallResponseParser amazonwebservicecallresponseparser)
        throws IOException, ParseErrorException
    {
        throw new RuntimeException("This should not be called!");
    }

    public AsyncAmazonWebserviceCall createCall(WebRequest webrequest, IWebResponseParser iwebresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener)
    {
        if (mCredentials != null)
        {
            AccountCredentials accountcredentials = mCredentials;
            Context context = mContext;
            if (accountcredentials.isStale$faab209())
            {
                mCredentials = AccountCredentialsHolder.getInstance(mContext);
                boolean flag = mRequestSigner.getUseLegacyAuthentication();
                mRequestSigner = new RequestSigner(mCredentials);
                mRequestSigner.setUseLegacyAuthentication(flag);
            }
        }
        iwebresponseparser = new StandardAmazonWebServiceCallback(iwebresponseparser, iamazonwebservicecalllistener, webrequest.getAuthenticationRequired());
        return new AsyncAmazonWebserviceCall(mContext, webrequest, iwebresponseparser, mRequestSigner, mTracer);
    }

    public AsyncAmazonWebserviceCall createCall(WebRequest webrequest, WebResponseParser webresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener)
    {
        return createCall(webrequest, ((IWebResponseParser) (new WebResponseParserAdapter(webresponseparser))), iamazonwebservicecalllistener);
    }

    public volatile IAmazonWebserviceCall createCall(WebRequest webrequest, WebResponseParser webresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener)
    {
        return createCall(webrequest, webresponseparser, iamazonwebservicecalllistener);
    }
}

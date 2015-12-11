// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import amazon.communication.MissingCredentialsException;
import amazon.communication.authentication.RequestContext;
import amazon.communication.authentication.SigningException;
import android.content.Context;
import android.net.Uri;
import com.amazon.dp.logger.DPLogger;
import com.amazon.identity.auth.device.api.AuthenticationType;
import java.net.URI;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.communication.authentication:
//            AbstractDcpRequestSigner

public class DcpOAuthRequestSigner extends AbstractDcpRequestSigner
{

    protected static final String AUTH_TYPE;
    private static final DPLogger log = new DPLogger("TComm.DcpOAuthRequestSigner");

    public DcpOAuthRequestSigner(Context context)
    {
        super(context);
    }

    public void signRequest(HttpRequestBase httprequestbase)
        throws SigningException, MissingCredentialsException
    {
        validateRequest(httprequestbase);
        Uri uri = Uri.parse(httprequestbase.getURI().toString());
        byte abyte0[] = EMPTY_BODY;
        signRequest(httprequestbase, AUTH_TYPE, uri, abyte0, null);
    }

    public void signRequest(HttpRequestBase httprequestbase, RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        if (requestcontext != null)
        {
            throw new UnsupportedOperationException("DcpOAuthRequestSigner does not support client-provided RequestContext");
        } else
        {
            signRequest(httprequestbase);
            return;
        }
    }

    static 
    {
        AUTH_TYPE = AuthenticationType.OAuth.toString();
    }
}

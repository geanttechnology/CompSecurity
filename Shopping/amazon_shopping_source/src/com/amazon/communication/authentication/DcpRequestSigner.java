// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import amazon.communication.MissingCredentialsException;
import amazon.communication.authentication.RequestContext;
import amazon.communication.authentication.SigningException;
import android.net.Uri;
import com.amazon.dp.logger.DPLogger;
import com.amazon.identity.auth.device.api.AuthenticationType;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;

// Referenced classes of package com.amazon.communication.authentication:
//            AbstractDcpRequestSigner

public class DcpRequestSigner extends AbstractDcpRequestSigner
{

    protected static final String AUTH_TYPE;
    private static final DPLogger log = new DPLogger("TComm.DcpRequestSigner");

    protected byte[] extractBody(HttpRequestBase httprequestbase)
        throws SigningException
    {
        if (!(httprequestbase instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_209;
        }
        HttpEntity httpentity = ((HttpEntityEnclosingRequest)httprequestbase).getEntity();
        if (httpentity == null) goto _L2; else goto _L1
_L1:
        HttpEntity httpentity1 = httpentity;
        InputStream inputstream = httpentity.getContent();
        httpentity1 = httpentity;
        byte abyte1[] = new byte[inputstream.available()];
        httpentity1 = httpentity;
        inputstream.read(abyte1);
        byte abyte0[];
        abyte0 = abyte1;
        httpentity1 = httpentity;
        if (httpentity.isRepeatable())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        httpentity1 = httpentity;
        ((HttpEntityEnclosingRequest)httprequestbase).setEntity(new ByteArrayEntity(abyte1));
        abyte0 = abyte1;
_L7:
        httprequestbase = abyte0;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        httpentity.consumeContent();
        httprequestbase = abyte0;
_L3:
        if (httprequestbase != null)
        {
            return httprequestbase;
        } else
        {
            return EMPTY_BODY;
        }
        httprequestbase;
        log.warn("extractBody", "Error consuming remainder of entity content", new Object[] {
            httprequestbase
        });
        httprequestbase = abyte0;
          goto _L3
        httprequestbase;
        httpentity = null;
_L6:
        httpentity1 = httpentity;
        throw new SigningException("Error getting content from http entity", httprequestbase);
        httprequestbase;
_L5:
        if (httpentity1 != null)
        {
            try
            {
                httpentity1.consumeContent();
            }
            catch (Exception exception)
            {
                log.warn("extractBody", "Error consuming remainder of entity content", new Object[] {
                    exception
                });
            }
        }
        throw httprequestbase;
        httprequestbase;
        httpentity1 = null;
        if (true) goto _L5; else goto _L4
_L4:
        httprequestbase;
        if (true) goto _L6; else goto _L2
_L2:
        abyte0 = null;
          goto _L7
        httprequestbase = null;
          goto _L3
    }

    public void signRequest(HttpRequestBase httprequestbase, RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        validateRequest(httprequestbase);
        Uri uri = Uri.parse(httprequestbase.getURI().toString());
        byte abyte0[] = extractBody(httprequestbase);
        signRequest(httprequestbase, AUTH_TYPE, uri, abyte0, requestcontext);
    }

    static 
    {
        AUTH_TYPE = AuthenticationType.ADPAuthenticator.toString();
    }
}

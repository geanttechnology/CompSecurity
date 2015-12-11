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

    public DcpRequestSigner(Context context)
    {
        super(context);
    }

    protected byte[] extractBody(HttpRequestBase httprequestbase)
        throws SigningException
    {
        byte abyte0[];
        Object obj;
        Object obj1;
        abyte0 = null;
        obj1 = null;
        if (!(httprequestbase instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        obj = null;
        abyte0 = null;
        HttpEntity httpentity = ((HttpEntityEnclosingRequest)httprequestbase).getEntity();
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        abyte0 = httpentity;
        obj = httpentity;
        obj1 = httpentity.getContent();
        abyte0 = httpentity;
        obj = httpentity;
        byte abyte1[] = new byte[((InputStream) (obj1)).available()];
        abyte0 = httpentity;
        obj = httpentity;
        ((InputStream) (obj1)).read(abyte1);
        obj1 = abyte1;
        abyte0 = httpentity;
        obj = httpentity;
        if (httpentity.isRepeatable())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        abyte0 = httpentity;
        obj = httpentity;
        ((HttpEntityEnclosingRequest)httprequestbase).setEntity(new ByteArrayEntity(abyte1));
        obj1 = abyte1;
        abyte0 = ((byte []) (obj1));
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        httpentity.consumeContent();
        abyte0 = ((byte []) (obj1));
_L1:
        if (abyte0 != null)
        {
            return abyte0;
        } else
        {
            return EMPTY_BODY;
        }
        httprequestbase;
        log.warn("extractBody", "Error consuming remainder of entity content", new Object[] {
            httprequestbase
        });
        abyte0 = ((byte []) (obj1));
          goto _L1
        httprequestbase;
        obj = abyte0;
        throw new SigningException("Error getting content from http entity", httprequestbase);
        httprequestbase;
        if (obj != null)
        {
            try
            {
                ((HttpEntity) (obj)).consumeContent();
            }
            catch (Exception exception)
            {
                log.warn("extractBody", "Error consuming remainder of entity content", new Object[] {
                    exception
                });
            }
        }
        throw httprequestbase;
    }

    public void signRequest(HttpRequestBase httprequestbase)
        throws SigningException, MissingCredentialsException
    {
        signRequest(httprequestbase, null);
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

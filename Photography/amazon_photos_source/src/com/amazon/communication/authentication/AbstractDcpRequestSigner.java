// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import amazon.communication.MissingCredentialsException;
import amazon.communication.authentication.AccountRequestContext;
import amazon.communication.authentication.RequestContext;
import amazon.communication.authentication.SigningException;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.amazon.dp.logger.DPFormattedMessage;
import com.amazon.dp.logger.DPLogger;
import com.amazon.identity.auth.device.api.AuthenticationMethod;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.communication.authentication:
//            RequestSigner, DcpUriSanitizer

public abstract class AbstractDcpRequestSigner
    implements RequestSigner
{

    protected static final byte EMPTY_BODY[] = new byte[0];
    private static final DPLogger log = new DPLogger("TComm.AbstractDcpRequestSigner");
    protected final Context mContext;
    protected final MAPAccountManager mMapAccountManager;

    protected void callAuthenticationService(HttpRequestBase httprequestbase, String s, Uri uri, byte abyte0[], RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
label0:
        {
label1:
            {
                log.debug("callAuthenticationService", "signing request", new Object[0]);
                Object obj = null;
                if (requestcontext != null)
                {
                    if (!(requestcontext instanceof AccountRequestContext))
                    {
                        break label1;
                    }
                    obj = (AccountRequestContext)requestcontext;
                }
                obj = getAmazonAccount(((AccountRequestContext) (obj)));
                requestcontext = httprequestbase.getMethod();
                uri = DcpUriSanitizer.sanitizeUriForDcp(uri);
                log.debug("callAuthenticationService", "Signing request", new Object[] {
                    "authType", s, "method", requestcontext, "body.length", Integer.valueOf(abyte0.length)
                });
                uri = (new AuthenticationMethodFactory(mContext, ((String) (obj)))).newAuthenticationMethod(s).getAuthenticationHeadersForRequest(uri, httprequestbase.getMethod(), Collections.emptyMap(), abyte0, null);
                try
                {
                    uri = (Bundle)uri.get(1000L, TimeUnit.MILLISECONDS);
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    throw new SigningException(DPFormattedMessage.toDPFormat("callAuthenticationService", "MAPError signing request", new Object[] {
                        "authType", s, "method", requestcontext, "body.length", Integer.valueOf(abyte0.length)
                    }), httprequestbase);
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    throw new SigningException(DPFormattedMessage.toDPFormat("callAuthenticationService", "timed out getting authentication result", new Object[] {
                        "authType", s, "method", requestcontext, "body.length", Integer.valueOf(abyte0.length), "timeoutInMs", Integer.valueOf(1000)
                    }), httprequestbase);
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    throw new SigningException(DPFormattedMessage.toDPFormat("callAuthenticationService", "Interrupted getting authentication result", new Object[] {
                        "authType", s, "method", requestcontext, "body.length", Integer.valueOf(abyte0.length), "timeoutInMs", Integer.valueOf(1000)
                    }), httprequestbase);
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    throw new SigningException(DPFormattedMessage.toDPFormat("callAuthenticationService", "ExecutionException getting authentication result", new Object[] {
                        "authType", s, "method", requestcontext, "body.length", Integer.valueOf(abyte0.length), "timeoutInMs", Integer.valueOf(1000)
                    }), httprequestbase);
                }
                s = uri.getBundle("auth.headers");
                for (uri = s.keySet().iterator(); uri.hasNext(); httprequestbase.setHeader(abyte0, s.getString(abyte0)))
                {
                    abyte0 = (String)uri.next();
                    log.debug("signRequest", "transferring header to request", new Object[] {
                        "key", abyte0, "value", s.getString(abyte0)
                    });
                }

                break label0;
            }
            throw new SigningException("The RequestContext must be an AccountRequestContext");
        }
    }

    protected String getAmazonAccount(AccountRequestContext accountrequestcontext)
        throws MissingCredentialsException
    {
        if (accountrequestcontext != null && accountrequestcontext.getDirectedId() != null)
        {
            accountrequestcontext = accountrequestcontext.getDirectedId();
        } else
        {
            if (accountrequestcontext != null && AccountRequestContext.EMPTY_ACCOUNT.equals(accountrequestcontext))
            {
                return mMapAccountManager.getPrimaryAccount();
            }
            String s = mMapAccountManager.getPrimaryAccount();
            accountrequestcontext = s;
            if (s == null)
            {
                throw new MissingCredentialsException("No amazon account found");
            }
        }
        return accountrequestcontext;
    }

    protected void signRequest(HttpRequestBase httprequestbase, String s, Uri uri, byte abyte0[], RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IllegalStateException("This method cannot be called on the main thread");
        } else
        {
            callAuthenticationService(httprequestbase, s, uri, abyte0, requestcontext);
            return;
        }
    }

    protected void validateRequest(HttpRequestBase httprequestbase)
    {
        if (httprequestbase == null)
        {
            throw new IllegalArgumentException("Request cannot be null");
        } else
        {
            return;
        }
    }

}

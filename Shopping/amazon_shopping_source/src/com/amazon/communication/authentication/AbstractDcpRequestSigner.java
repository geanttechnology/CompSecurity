// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import amazon.communication.MissingCredentialsException;
import amazon.communication.authentication.AccountRequestContext;
import amazon.communication.authentication.RequestContext;
import amazon.communication.authentication.SigningException;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.amazon.dcp.sso.IRequestAuthenticationMethod;
import com.amazon.dcp.sso.ReturnValueOrError;
import com.amazon.dp.logger.DPLogger;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.communication.authentication:
//            RequestSigner, DcpUriSanitizer

public abstract class AbstractDcpRequestSigner
    implements RequestSigner
{

    protected static final byte EMPTY_BODY[] = new byte[0];
    private static final DPLogger log = new DPLogger("TComm.AbstractDcpRequestSigner");
    protected final AtomicReference mAuthService;
    protected final ServiceConnection mAuthServiceConnection;
    protected int mBindCount;
    protected final Lock mBindCounterLock;
    protected final Context mContext;
    protected final MAPAccountManager mMapAccountManager;
    protected final Condition mServiceConnectedCondition;
    protected final Lock mServiceConnectedLock;

    private void bindService()
    {
        log.debug("bindService", "attempt to bind service", new Object[0]);
        mBindCounterLock.lock();
        mBindCount = mBindCount + 1;
        boolean flag = mContext.bindService(new Intent("com.amazon.dcp.sso.action.GET_DEVICE_CREDENTIALS"), mAuthServiceConnection, 5);
        log.verbose("bindService", "bound service", new Object[] {
            "bindResult", Boolean.valueOf(flag), "bindCount", Integer.valueOf(mBindCount)
        });
        mBindCounterLock.unlock();
        return;
        Exception exception;
        exception;
        mBindCounterLock.unlock();
        throw exception;
    }

    private void unbindService(boolean flag)
    {
        mBindCounterLock.lock();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        mBindCount = mBindCount - 1;
        if (mBindCount <= 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        log.debug("unbindService", "requests are waiting for sign, should not unbind", new Object[] {
            "bind count", Integer.valueOf(mBindCount)
        });
        mBindCounterLock.unlock();
        return;
        mBindCount = 0;
        mServiceConnectedLock.lock();
        log.verbose("unbindService", "unbinding service", new Object[] {
            "force unbind", Boolean.valueOf(flag)
        });
        mAuthService.set(null);
        mContext.unbindService(mAuthServiceConnection);
        mServiceConnectedLock.unlock();
_L2:
        mBindCounterLock.unlock();
        return;
        Object obj;
        obj;
        log.info("unbindService", "caught IllegalArgumentException unbinding, ignoring", new Object[] {
            "message", ((IllegalArgumentException) (obj)).getMessage()
        });
        mServiceConnectedLock.unlock();
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        mBindCounterLock.unlock();
        throw obj;
        obj;
        mServiceConnectedLock.unlock();
        throw obj;
    }

    protected void callAuthenticationService(HttpRequestBase httprequestbase, String s, Uri uri, byte abyte0[], RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        if (requestcontext == null) goto _L2; else goto _L1
_L1:
        if (!(requestcontext instanceof AccountRequestContext)) goto _L4; else goto _L3
_L3:
        requestcontext = (AccountRequestContext)requestcontext;
_L6:
        requestcontext = getAmazonAccount(requestcontext);
        IRequestAuthenticationMethod irequestauthenticationmethod = getRequestAuthMethod();
        String s1 = httprequestbase.getMethod();
        uri = DcpUriSanitizer.sanitizeUriForDcp(uri);
        log.debug("signRequest", "Signing request", new Object[] {
            "authType", s, "method", s1, "uri", uri, "body.length", Integer.valueOf(abyte0.length)
        });
        try
        {
            log.debug("callAuthenticationService", "signing with directedId", new Object[] {
                "directedId", requestcontext
            });
            s = irequestauthenticationmethod.getAuthenticationParametersForRequestByDirectedId(s, requestcontext, uri, s1, Collections.emptyMap(), abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequestBase httprequestbase)
        {
            throw new SigningException("remote exception", httprequestbase);
        }
        checkResultForErrors(s);
        transferAuthHeadersToRequest(s, httprequestbase);
        return;
_L4:
        throw new SigningException("The RequestContext must be an AccountRequestContext");
_L2:
        requestcontext = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void checkAndCallAuthenticationService(HttpRequestBase httprequestbase, String s, Uri uri, byte abyte0[], RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        if (mAuthService.get() == null)
        {
            throw new IllegalStateException("AuthenticationService connection is null");
        } else
        {
            callAuthenticationService(httprequestbase, s, uri, abyte0, requestcontext);
            return;
        }
    }

    protected void checkResultForErrors(ReturnValueOrError returnvalueorerror)
        throws SigningException
    {
        if (returnvalueorerror.isError())
        {
            log.error("signRequest", "error calling signing service", new Object[] {
                "response message", returnvalueorerror.getResponseMessage()
            });
            throw new SigningException("Error calling signing service");
        } else
        {
            return;
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

    protected IRequestAuthenticationMethod getRequestAuthMethod()
    {
        return com.amazon.dcp.sso.IRequestAuthenticationMethod.Stub.asInterface((IBinder)mAuthService.get());
    }

    protected void signRequest(HttpRequestBase httprequestbase, String s, Uri uri, byte abyte0[], RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IllegalStateException("This method cannot be called on the main thread");
        }
        log.verbose("signRequest", "authservice", new Object[] {
            mAuthService
        });
        bindService();
        waitForService();
        checkAndCallAuthenticationService(httprequestbase, s, uri, abyte0, requestcontext);
        unbindService(false);
        return;
        httprequestbase;
        unbindService(false);
        throw httprequestbase;
    }

    protected void transferAuthHeadersToRequest(ReturnValueOrError returnvalueorerror, HttpRequestBase httprequestbase)
    {
        if (httprequestbase != null)
        {
            returnvalueorerror = returnvalueorerror.getResponse().getBundle("auth.headers");
            if (returnvalueorerror == null)
            {
                log.info("transferAuthHeadersToRequest", "no headers returned in auth bundle", new Object[0]);
                return;
            }
            Iterator iterator = returnvalueorerror.keySet().iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                httprequestbase.setHeader(s, returnvalueorerror.getString(s));
            }
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

    protected void waitForService()
        throws SigningException
    {
        long l;
        if (mAuthService.get() != null)
        {
            return;
        }
        l = System.currentTimeMillis();
        log.debug("waitForService", "waiting for service to bind", new Object[0]);
        mServiceConnectedLock.lock();
        Object obj = mAuthService.get();
label0:
        {
            if (obj != null)
            {
                mServiceConnectedLock.unlock();
                return;
            }
            try
            {
                if (!mServiceConnectedCondition.await(2000L, TimeUnit.MILLISECONDS))
                {
                    log.debug("waitForService", "Timed out waiting for service binder", new Object[0]);
                    throw new SigningException("Timed out waiting for service binder");
                }
                break label0;
            }
            catch (InterruptedException interruptedexception) { }
            finally
            {
                mServiceConnectedLock.unlock();
                throw exception;
            }
        }
        log.debug("waitForService", "Interrupted waiting for service binder", new Object[0]);
        throw new SigningException("Interrupted waiting for service binder");
        mServiceConnectedLock.unlock();
        long l1 = System.currentTimeMillis();
        log.debug("waitForService", "finished waiting for service to bind", new Object[] {
            "elapsedMs", Long.valueOf(l1 - l)
        });
        return;
    }

}

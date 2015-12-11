// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.IWebResponseParser;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            IAmazonWebServiceCallback, AuthenticatedResponseHandlerAdapter, DefaultAmazonWebserviceCallListener, IAmazonWebserviceCallListener

public class StandardAmazonWebServiceCallback
    implements IAmazonWebServiceCallback
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback.getName();
    private AuthenticatedResponseHandlerAdapter mAuthRespHandler;
    private IAmazonWebserviceCallListener mListener;
    private IWebResponseParser mResponseParser;
    private StringBuilder mResponseString;

    public StandardAmazonWebServiceCallback(IWebResponseParser iwebresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener, boolean flag)
    {
        if (iamazonwebservicecalllistener != null)
        {
            mListener = iamazonwebservicecalllistener;
        } else
        {
            mListener = new DefaultAmazonWebserviceCallListener();
        }
        mResponseParser = iwebresponseparser;
        mResponseString = new StringBuilder();
        if (flag)
        {
            mAuthRespHandler = new AuthenticatedResponseHandlerAdapter(mResponseParser);
            mResponseParser = mAuthRespHandler;
        }
    }

    private boolean responseHasError(Object obj)
    {
        if (obj != null)
        {
            try
            {
                obj = obj.getClass().getMethod("getError", new Class[0]).invoke(obj, new Object[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            if (obj == null)
            {
                return false;
            }
        }
        return true;
    }

    public void onBodyChunkReceived(byte abyte0[], int i)
    {
        if (mResponseParser.shouldParseBody())
        {
            if (mResponseString.length() < 1024)
            {
                int j;
                if (mResponseString.length() + i > 1024)
                {
                    j = 1024 - mResponseString.length();
                } else
                {
                    j = i;
                }
                mResponseString.append(new String(abyte0, 0, j));
            }
            mResponseParser.parseBodyChunk(abyte0, i);
        }
    }

    public void onHeadersReceived(WebResponseHeaders webresponseheaders)
    {
        mResponseParser.beginParse(webresponseheaders);
    }

    public void onNetworkError()
    {
        mListener.onNetworkFailure();
    }

    public void onRequestComplete()
    {
        mResponseParser.endParse();
        if (mResponseParser.getParseError() != ParseError.ParseErrorNoError)
        {
            mResponseParser.getParseError();
            mListener.onParseError$6fe276bc();
            return;
        }
        if (mAuthRespHandler != null && !mAuthRespHandler.authenticationSucceeded())
        {
            mListener.onAuthenticationFailed();
            return;
        } else
        {
            Object obj = mResponseParser.getParsedResponse();
            responseHasError(obj);
            mListener.onResponseComplete(obj);
            return;
        }
    }

}

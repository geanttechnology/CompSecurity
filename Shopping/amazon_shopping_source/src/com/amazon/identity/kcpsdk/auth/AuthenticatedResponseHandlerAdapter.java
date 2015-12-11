// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.IWebResponseParser;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            AuthenticatedResponseHandler, CredentialStatus

public class AuthenticatedResponseHandlerAdapter
    implements IWebResponseParser
{

    private AuthenticatedResponseHandler mAuthResponseHandler;
    private IWebResponseParser mInnerResponseParser;

    public AuthenticatedResponseHandlerAdapter(IWebResponseParser iwebresponseparser)
    {
        mInnerResponseParser = iwebresponseparser;
        mAuthResponseHandler = new AuthenticatedResponseHandler(null);
    }

    public boolean authenticationSucceeded()
    {
        return mAuthResponseHandler.authenticationSucceeded();
    }

    public void beginParse(WebResponseHeaders webresponseheaders)
    {
        if (mInnerResponseParser != null)
        {
            mInnerResponseParser.beginParse(webresponseheaders);
        }
        mAuthResponseHandler.beginParse(webresponseheaders);
    }

    public ParseError endParse()
    {
        if (mInnerResponseParser != null)
        {
            mInnerResponseParser.endParse();
        }
        mAuthResponseHandler.endParse();
        return getParseError();
    }

    public String getCredentialErrorText()
    {
        return mAuthResponseHandler.getCredentialErrorText();
    }

    public CredentialStatus getCredentialStatus()
    {
        return mAuthResponseHandler.getCredentialStatus();
    }

    public String getCredentialWarningText()
    {
        return mAuthResponseHandler.getCredentialWarningText();
    }

    public ParseError getParseError()
    {
        if (mInnerResponseParser != null && mInnerResponseParser.getParseError() != ParseError.ParseErrorNoError)
        {
            return mInnerResponseParser.getParseError();
        } else
        {
            return mAuthResponseHandler.getParseError();
        }
    }

    public Object getParsedResponse()
    {
        if (mInnerResponseParser == null)
        {
            return null;
        } else
        {
            return mInnerResponseParser.getParsedResponse();
        }
    }

    public ParseError parseBodyChunk(byte abyte0[], int i)
    {
        if (mInnerResponseParser != null && mInnerResponseParser.shouldParseBody())
        {
            mInnerResponseParser.parseBodyChunk(abyte0, i);
        }
        if (mAuthResponseHandler.shouldParseBody())
        {
            mAuthResponseHandler.parseBodyChunk(abyte0, i);
        }
        return getParseError();
    }

    public boolean shouldParseBody()
    {
        return mInnerResponseParser != null && mInnerResponseParser.shouldParseBody() || mAuthResponseHandler.shouldParseBody();
    }
}

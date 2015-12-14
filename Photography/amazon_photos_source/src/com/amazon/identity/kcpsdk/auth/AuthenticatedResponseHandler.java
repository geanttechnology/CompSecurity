// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.FIRSError;
import com.amazon.identity.kcpsdk.common.FIRSErrorParser;
import com.amazon.identity.kcpsdk.common.FIRSErrorType;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import com.amazon.identity.kcpsdk.common.XMLParser;
import com.amazon.identity.kcpsdk.common.XMLParserHelpers;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AuthenticatedResponseHandler extends WebResponseParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler.getName();
    private boolean mAuthSucceeded;
    private ParseError mInnerParseError;
    private final WebResponseParser mNextParser = null;
    private ParseError mOuterParseError;
    private final XMLParser mParser = new XMLParser();
    private boolean mShouldTryParsing;

    public AuthenticatedResponseHandler()
    {
        super(com/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandler.getName());
        mInnerParseError = ParseError.ParseErrorNoError;
        mOuterParseError = ParseError.ParseErrorNoError;
        mAuthSucceeded = true;
    }

    public boolean authenticationSucceeded()
    {
        return mAuthSucceeded;
    }

    public Object getParsedResponse()
    {
        if (mNextParser == null)
        {
            return null;
        } else
        {
            return mNextParser.getParsedResponse();
        }
    }

    protected boolean internalBeginParse(WebResponseHeaders webresponseheaders)
    {
        if (mNextParser != null)
        {
            mNextParser.beginParse(webresponseheaders);
        }
        long l = webresponseheaders.getStatusCode();
        webresponseheaders = webresponseheaders.getHeaderByName("content-type");
        boolean flag;
        if (l == 500L || l == 200L && (webresponseheaders == null || "text/xml".equals(webresponseheaders)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShouldTryParsing = flag;
        if (mShouldTryParsing)
        {
            MAPLog.formattedInfo(TAG, "AuthenticatedResponseHandler: beginParse: Response could be an authentication error. Will try to parse as an authentication error. Status Code: %d Content-Type: %s", new Object[] {
                Long.valueOf(l), webresponseheaders
            });
        }
        return true;
    }

    protected void internalEndParse()
    {
        boolean flag1 = false;
        if (!mShouldTryParsing) goto _L2; else goto _L1
_L1:
        if (mOuterParseError != ParseError.ParseErrorNoError) goto _L4; else goto _L3
_L3:
        Object obj = mParser.parseEndOfDocument();
        if (obj == null) goto _L4; else goto _L5
_L5:
        FIRSError firserror = FIRSErrorParser.parseError(((Document) (obj)));
        if (firserror != null && firserror.getErrorType() == FIRSErrorType.FIRSErrorTypeInternalError) goto _L7; else goto _L6
_L6:
        boolean flag;
        obj = ((Document) (obj)).getDocumentElement();
        if (obj == null || !((Element) (obj)).getTagName().equals("Errors"))
        {
            flag = false;
        } else
        {
            obj = XMLParserHelpers.getFirstElementWithTag(((Element) (obj)), "Error");
            if (obj == null)
            {
                flag = false;
            } else
            {
                obj = XMLParserHelpers.getFirstElementWithTag(((Element) (obj)), "Code");
                if (obj == null)
                {
                    flag = false;
                } else
                {
                    flag = "DEVICE_MASTER_SERVICE_ERROR".equals(((Element) (obj)).getTextContent());
                }
            }
        }
        if (!flag) goto _L4; else goto _L7
_L7:
        MAPLog.i(TAG, "AuthenticatedResponseHandler: endParse: Server returned an authentication error. You can ignore any malformed response errors from the inner parser.");
        flag = flag1;
_L9:
        mAuthSucceeded = flag;
_L2:
        if (mInnerParseError == ParseError.ParseErrorNoError && mNextParser != null && mNextParser.shouldParseBody())
        {
            mInnerParseError = mNextParser.endParse();
        }
        if (mAuthSucceeded)
        {
            obj = mInnerParseError;
        } else
        {
            obj = mOuterParseError;
        }
        setParseError(((ParseError) (obj)));
        return;
_L4:
        flag = true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void internalParseBodyChunk(byte abyte0[], long l)
    {
        if (mOuterParseError == ParseError.ParseErrorNoError && mShouldTryParsing)
        {
            mParser.parseChunk(abyte0, l);
        }
        if (mInnerParseError == ParseError.ParseErrorNoError && mNextParser != null && mNextParser.shouldParseBody())
        {
            mInnerParseError = mNextParser.parseBodyChunk(abyte0, l);
        }
    }

    public boolean shouldParseBody()
    {
        return mNextParser != null && mNextParser.shouldParseBody() || mShouldTryParsing;
    }

}

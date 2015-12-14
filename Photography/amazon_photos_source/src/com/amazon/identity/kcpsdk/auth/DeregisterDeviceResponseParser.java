// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.FIRSErrorParser;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import com.amazon.identity.kcpsdk.common.XMLParser;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            DeregisterDeviceResponse, DeregisterDeviceError, DeregisterDeviceErrorType

public class DeregisterDeviceResponseParser extends WebResponseParser
{

    private final XMLParser mParser = new XMLParser();
    private DeregisterDeviceResponse mResponse;

    public DeregisterDeviceResponseParser()
    {
        super(com/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser.getName());
    }

    public DeregisterDeviceResponse getParsedResponse()
    {
        return mResponse;
    }

    public volatile Object getParsedResponse()
    {
        return getParsedResponse();
    }

    protected void internalEndParse()
    {
        org.w3c.dom.Document document = mParser.parseEndOfDocument();
        if (document == null)
        {
            setParseError(ParseError.ParseErrorMalformedBody);
            return;
        }
        DeregisterDeviceResponse deregisterdeviceresponse = new DeregisterDeviceResponse();
        if (FIRSErrorParser.parseError(document) != null)
        {
            deregisterdeviceresponse.setError(new DeregisterDeviceError(DeregisterDeviceErrorType.DeregisterDeviceErrorTypeFailed));
        }
        mResponse = deregisterdeviceresponse;
    }

    protected void internalParseBodyChunk(byte abyte0[], long l)
    {
        mParser.parseChunk(abyte0, l);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.AmazonDevice.Identity.Common.IWebResponseParser;
import com.AmazonDevice.Identity.Common.ParseError;
import com.AmazonDevice.Identity.Common.WebResponseHeaders;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOODMSUserIdentifier

protected static class parseError
    implements IWebResponseParser
{
    protected static class ResponseInfo
    {

        public final long httpCode;
        public final String response;

        public ResponseInfo(long l, String s)
        {
            httpCode = l;
            response = s;
        }
    }


    private Long httpCode;
    private ParseError parseError;
    private final ByteArrayOutputStream stream = new ByteArrayOutputStream();

    public void beginParse(WebResponseHeaders webresponseheaders)
    {
        httpCode = Long.valueOf(webresponseheaders.getStatusCode());
        if (httpCode.longValue() < 200L || httpCode.longValue() >= 300L)
        {
            parseError = ParseError.ParseErrorHttpError;
        }
    }

    public ParseError endParse()
    {
        return parseError;
    }

    public ParseError getParseError()
    {
        return parseError;
    }

    public ResponseInfo getParsedResponse()
    {
        Object obj;
        try
        {
            obj = stream.toString("UTF-8");
            obj = new ResponseInfo(httpCode.longValue(), ((String) (obj)));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return new ResponseInfo(500L, (new StringBuilder()).append("Error decoding response ").append(unsupportedencodingexception.getMessage()).toString());
        }
        return ((ResponseInfo) (obj));
    }

    public volatile Object getParsedResponse()
    {
        return getParsedResponse();
    }

    public ParseError parseBodyChunk(byte abyte0[], int i)
    {
        stream.write(abyte0, 0, i);
        return parseError;
    }

    public boolean shouldParseBody()
    {
        return true;
    }

    protected ResponseInfo.response()
    {
        parseError = ParseError.ParseErrorNoError;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            PandaResponseJsonParser

public abstract class JsonWebResponseParser extends WebResponseParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/JsonWebResponseParser.getName();
    private final ByteArrayOutputStream mBuffer = new ByteArrayOutputStream();
    private final PandaResponseJsonParser mParser;
    private Object mResponse;

    public JsonWebResponseParser(String s, PandaResponseJsonParser pandaresponsejsonparser)
    {
        super(s);
        mResponse = null;
        mParser = pandaresponsejsonparser;
    }

    public Object getParsedResponse()
    {
        return mResponse;
    }

    protected boolean internalBeginParse(WebResponseHeaders webresponseheaders)
    {
        return true;
    }

    protected void internalEndParse()
    {
        try
        {
            mBuffer.close();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, " Failed to close buffer");
        }
        try
        {
            JSONObject jsonobject = new JSONObject(new String(mBuffer.toByteArray(), "UTF-8"));
            String s = TAG;
            jsonobject.toString();
            mResponse = mParser.parse(jsonobject);
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException(unsupportedencodingexception);
        }
        catch (JSONException jsonexception)
        {
            setParseError(ParseError.ParseErrorMalformedBody);
        }
    }

    protected void internalParseBodyChunk(byte abyte0[], long l)
    {
        mBuffer.write(abyte0, 0, (int)l);
    }

}

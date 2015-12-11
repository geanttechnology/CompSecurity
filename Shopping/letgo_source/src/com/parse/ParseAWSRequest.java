// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.parse:
//            ParseRequest, ParseHttpResponse, ParseException, ProgressCallback, 
//            ParseIOUtils

class ParseAWSRequest extends ParseRequest
{

    public ParseAWSRequest(ParseRequest.Method method, String s)
    {
        super(method, s);
    }

    protected cu onResponseAsync(ParseHttpResponse parsehttpresponse, ProgressCallback progresscallback)
    {
        int l;
        int i = parsehttpresponse.getStatusCode();
        if (i >= 200 && i < 300 || i == 304)
        {
            if (method != ParseRequest.Method.GET)
            {
                return null;
            }
        } else
        {
            if (method == ParseRequest.Method.GET)
            {
                progresscallback = "Download from";
            } else
            {
                progresscallback = "Upload to";
            }
            return cu.a(new ParseException(100, String.format("%s S3 failed. %s", new Object[] {
                progresscallback, parsehttpresponse.getReasonPhrase()
            })));
        }
        l = parsehttpresponse.getTotalSize();
        Object obj = parsehttpresponse.getContent();
        parsehttpresponse = ((ParseHttpResponse) (obj));
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        parsehttpresponse = ((ParseHttpResponse) (obj));
        byte abyte0[] = new byte[32768];
        int j = 0;
_L4:
        parsehttpresponse = ((ParseHttpResponse) (obj));
        int k = ((InputStream) (obj)).read(abyte0, 0, abyte0.length);
        if (k == -1) goto _L2; else goto _L1
_L1:
        parsehttpresponse = ((ParseHttpResponse) (obj));
        bytearrayoutputstream.write(abyte0, 0, k);
        k = j + k;
        j = k;
        if (progresscallback == null) goto _L4; else goto _L3
_L3:
        j = k;
        if (l == -1) goto _L4; else goto _L5
_L5:
        parsehttpresponse = ((ParseHttpResponse) (obj));
        progresscallback.done(Integer.valueOf(Math.round(((float)k / (float)l) * 100F)));
        j = k;
          goto _L4
        progresscallback;
_L9:
        parsehttpresponse = ((ParseHttpResponse) (obj));
        progresscallback = cu.a(progresscallback);
        ParseIOUtils.closeQuietly(((InputStream) (obj)));
        return progresscallback;
_L2:
        parsehttpresponse = ((ParseHttpResponse) (obj));
        progresscallback = cu.a(bytearrayoutputstream.toByteArray());
        ParseIOUtils.closeQuietly(((InputStream) (obj)));
        return progresscallback;
        parsehttpresponse;
        obj = null;
        progresscallback = parsehttpresponse;
_L7:
        ParseIOUtils.closeQuietly(((InputStream) (obj)));
        throw progresscallback;
        progresscallback;
        obj = parsehttpresponse;
        if (true) goto _L7; else goto _L6
_L6:
        progresscallback;
        obj = null;
        if (true) goto _L9; else goto _L8
_L8:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import com.parse.http.ParseHttpResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseRequest, ParseException, ParseExecutors, ProgressCallback, 
//            ParseFileUtils, ParseIOUtils

class ParseAWSRequest extends ParseRequest
{

    private final File tempFile;

    public ParseAWSRequest(com.parse.http.ParseHttpRequest.Method method, String s, File file)
    {
        super(method, s);
        tempFile = file;
    }

    protected j onResponseAsync(final ParseHttpResponse response, final ProgressCallback downloadProgressCallback)
    {
        int i = response.getStatusCode();
        if (i >= 200 && i < 300 || i == 304)
        {
            if (method != com.parse.http.ParseHttpRequest.Method.GET)
            {
                return null;
            } else
            {
                return j.a(new Callable() {

                    final ParseAWSRequest this$0;
                    final ProgressCallback val$downloadProgressCallback;
                    final ParseHttpResponse val$response;

                    public volatile Object call()
                        throws Exception
                    {
                        return call();
                    }

                    public Void call()
                        throws Exception
                    {
                        long l1;
                        long l3;
                        l3 = response.getTotalSize();
                        l1 = 0L;
                        Object obj = response.getContent();
                        Object obj1;
                        byte abyte0[];
                        obj1 = ParseFileUtils.openOutputStream(tempFile);
                        abyte0 = new byte[32768];
_L4:
                        int k = ((InputStream) (obj)).read(abyte0, 0, abyte0.length);
                        if (k == -1) goto _L2; else goto _L1
_L1:
                        ((FileOutputStream) (obj1)).write(abyte0, 0, k);
                        long l2;
                        l2 = l1 + (long)k;
                        l1 = l2;
                        if (downloadProgressCallback == null) goto _L4; else goto _L3
_L3:
                        l1 = l2;
                        if (l3 == -1L) goto _L4; else goto _L5
_L5:
                        int l = Math.round(((float)l2 / (float)l3) * 100F);
                        downloadProgressCallback.done(Integer.valueOf(l));
                        l1 = l2;
                          goto _L4
                        Exception exception;
                        exception;
                        obj1 = obj;
                        obj = exception;
_L7:
                        ParseIOUtils.closeQuietly(((InputStream) (obj1)));
                        throw obj;
_L2:
                        ParseIOUtils.closeQuietly(((InputStream) (obj)));
                        return null;
                        obj;
                        obj1 = null;
                        if (true) goto _L7; else goto _L6
_L6:
                    }

            
            {
                this$0 = ParseAWSRequest.this;
                response = parsehttpresponse;
                downloadProgressCallback = progresscallback;
                super();
            }
                }, ParseExecutors.io());
            }
        }
        if (method == com.parse.http.ParseHttpRequest.Method.GET)
        {
            downloadProgressCallback = "Download from";
        } else
        {
            downloadProgressCallback = "Upload to";
        }
        return j.a(new ParseException(100, String.format("%s S3 failed. %s", new Object[] {
            downloadProgressCallback, response.getReasonPhrase()
        })));
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.http.ParseHttpResponse;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseAWSRequest, ParseFileUtils, ProgressCallback, ParseIOUtils

class 
    implements Callable
{

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
        long l;
        long l2;
        l2 = val$response.getTotalSize();
        l = 0L;
        Object obj = val$response.getContent();
        Object obj1;
        byte abyte0[];
        obj1 = ParseFileUtils.openOutputStream(ParseAWSRequest.access$000(ParseAWSRequest.this));
        abyte0 = new byte[32768];
_L4:
        int i = ((InputStream) (obj)).read(abyte0, 0, abyte0.length);
        if (i == -1) goto _L2; else goto _L1
_L1:
        ((FileOutputStream) (obj1)).write(abyte0, 0, i);
        long l1;
        l1 = l + (long)i;
        l = l1;
        if (val$downloadProgressCallback == null) goto _L4; else goto _L3
_L3:
        l = l1;
        if (l2 == -1L) goto _L4; else goto _L5
_L5:
        int j = Math.round(((float)l1 / (float)l2) * 100F);
        val$downloadProgressCallback.done(Integer.valueOf(j));
        l = l1;
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

    onse()
    {
        this$0 = final_parseawsrequest;
        val$response = parsehttpresponse;
        val$downloadProgressCallback = ProgressCallback.this;
        super();
    }
}

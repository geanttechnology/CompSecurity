// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.okio.BufferedSink;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Request

static final class nit> extends nit>
{

    final MediaType val$contentType;
    final File val$file;

    public long contentLength()
    {
        return val$file.length();
    }

    public MediaType contentType()
    {
        return val$contentType;
    }

    public void writeTo(BufferedSink bufferedsink)
        throws IOException
    {
        Object obj1;
        long l;
        l = contentLength();
        if (l == 0L)
        {
            return;
        }
        obj1 = null;
        Object obj = new FileInputStream(val$file);
        obj1 = new byte[(int)Math.min(8192L, l)];
_L3:
        int i = ((InputStream) (obj)).read(((byte []) (obj1)));
        if (i == -1) goto _L2; else goto _L1
_L1:
        bufferedsink.write(((byte []) (obj1)), 0, i);
          goto _L3
        obj1;
        bufferedsink = ((BufferedSink) (obj));
        obj = obj1;
_L5:
        Util.closeQuietly(bufferedsink);
        throw obj;
_L2:
        Util.closeQuietly(((java.io.Closeable) (obj)));
        return;
        obj;
        bufferedsink = ((BufferedSink) (obj1));
        if (true) goto _L5; else goto _L4
_L4:
    }

    (MediaType mediatype, File file1)
    {
        val$contentType = mediatype;
        val$file = file1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.flurry.sdk:
//            ky, lt, lb

public class kz extends ky
{

    public kz(lb lb)
    {
        super(lb);
    }

    public void a(OutputStream outputstream, Object obj)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(outputstream);
        super.a(gzipoutputstream, obj);
        lt.a(gzipoutputstream);
        return;
        outputstream;
        obj = null;
_L2:
        lt.a(((java.io.Closeable) (obj)));
        throw outputstream;
        outputstream;
        obj = gzipoutputstream;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Object b(InputStream inputstream)
    {
        Object obj;
        obj = null;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        obj = new GZIPInputStream(inputstream);
        inputstream = ((InputStream) (super.b(((InputStream) (obj)))));
        lt.a(((java.io.Closeable) (obj)));
        obj = inputstream;
        return obj;
        inputstream;
        obj = null;
_L2:
        lt.a(((java.io.Closeable) (obj)));
        throw inputstream;
        inputstream;
        if (true) goto _L2; else goto _L1
_L1:
    }
}

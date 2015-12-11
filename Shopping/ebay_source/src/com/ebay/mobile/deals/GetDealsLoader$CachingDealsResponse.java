// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import com.ebay.nautilus.kernel.io.CacheStream;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.ebay.mobile.deals:
//            GetDealsLoader

private static final class file extends com.ebay.common.net.deals.
{

    private final File file;

    private InputStream makeCacheStream(InputStream inputstream)
    {
        Object obj;
        Object obj1;
        Object obj3;
        obj = null;
        obj1 = null;
        obj3 = null;
        Object obj2 = new BufferedOutputStream(new FileOutputStream(file), 8192);
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(((java.io.OutputStream) (obj2)));
        obj1 = gzipoutputstream;
        obj = gzipoutputstream;
        obj2 = new CacheStream(inputstream, gzipoutputstream);
        if (obj2 == null)
        {
            StreamUtil.closeQuietly(gzipoutputstream);
            obj = obj2;
        } else
        {
            obj = obj2;
        }
        if (obj != null)
        {
            return ((InputStream) (obj));
        } else
        {
            return inputstream;
        }
        obj2;
_L4:
        obj = obj1;
        ((IOException) (obj2)).printStackTrace();
        obj = obj3;
        if (true)
        {
            StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
            obj = obj3;
        }
        break MISSING_BLOCK_LABEL_72;
        inputstream;
_L2:
        if (true)
        {
            StreamUtil.closeQuietly(((java.io.Closeable) (obj)));
        }
        throw inputstream;
        inputstream;
        obj = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        obj1 = obj2;
        obj2 = obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.
    {
        InputStream inputstream1;
        if (inputstream == null || file == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        inputstream1 = inputstream;
        inputstream = makeCacheStream(inputstream);
        inputstream1 = inputstream;
        super.CacheStream(inputstream);
        StreamUtil.closeQuietly(inputstream);
        if (false && (inputstream instanceof CacheStream))
        {
            file.delete();
        }
        return;
        inputstream;
        StreamUtil.closeQuietly(inputstream1);
        if (true && (inputstream1 instanceof CacheStream))
        {
            file.delete();
        }
        throw inputstream;
    }

    public ception(File file1)
    {
        file = file1;
    }
}

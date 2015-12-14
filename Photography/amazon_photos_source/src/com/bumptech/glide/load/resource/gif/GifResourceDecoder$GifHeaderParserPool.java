// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.util.Util;
import java.util.Queue;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifResourceDecoder

static class Q
{

    private final Queue pool = Util.createQueue(0);

    public GifHeaderParser obtain(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        GifHeaderParser gifheaderparser1 = (GifHeaderParser)pool.poll();
        GifHeaderParser gifheaderparser;
        gifheaderparser = gifheaderparser1;
        if (gifheaderparser1 != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        gifheaderparser = new GifHeaderParser();
        abyte0 = gifheaderparser.setData(abyte0);
        this;
        JVM INSTR monitorexit ;
        return abyte0;
        abyte0;
        throw abyte0;
    }

    public void release(GifHeaderParser gifheaderparser)
    {
        this;
        JVM INSTR monitorenter ;
        gifheaderparser.clear();
        pool.offer(gifheaderparser);
        this;
        JVM INSTR monitorexit ;
        return;
        gifheaderparser;
        throw gifheaderparser;
    }

    Q()
    {
    }
}

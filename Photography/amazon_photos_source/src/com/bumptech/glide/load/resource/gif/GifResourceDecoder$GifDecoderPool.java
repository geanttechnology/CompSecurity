// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.util.Util;
import java.util.Queue;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifResourceDecoder

static class 
{

    private final Queue pool = Util.createQueue(0);

    public GifDecoder obtain(com.bumptech.glide.gifdecoder.erPool erpool)
    {
        this;
        JVM INSTR monitorenter ;
        GifDecoder gifdecoder1 = (GifDecoder)pool.poll();
        GifDecoder gifdecoder;
        gifdecoder = gifdecoder1;
        if (gifdecoder1 != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        gifdecoder = new GifDecoder(erpool);
        this;
        JVM INSTR monitorexit ;
        return gifdecoder;
        erpool;
        throw erpool;
    }

    public void release(GifDecoder gifdecoder)
    {
        this;
        JVM INSTR monitorenter ;
        gifdecoder.clear();
        pool.offer(gifdecoder);
        this;
        JVM INSTR monitorexit ;
        return;
        gifdecoder;
        throw gifdecoder;
    }

    ()
    {
    }
}

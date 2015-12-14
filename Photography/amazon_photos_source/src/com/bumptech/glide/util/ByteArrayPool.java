// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.util;

import android.util.Log;
import java.util.Queue;

// Referenced classes of package com.bumptech.glide.util:
//            Util

public final class ByteArrayPool
{

    private static final ByteArrayPool BYTE_ARRAY_POOL = new ByteArrayPool();
    private final Queue tempQueue = Util.createQueue(0);

    private ByteArrayPool()
    {
    }

    public static ByteArrayPool get()
    {
        return BYTE_ARRAY_POOL;
    }

    public byte[] getBytes()
    {
        byte abyte1[];
        synchronized (tempQueue)
        {
            abyte1 = (byte[])tempQueue.poll();
        }
        abyte0 = abyte1;
        if (abyte1 == null)
        {
            byte abyte2[] = new byte[0x10000];
            abyte0 = abyte2;
            if (Log.isLoggable("ByteArrayPool", 3))
            {
                Log.d("ByteArrayPool", "Created temp bytes");
                abyte0 = abyte2;
            }
        }
        return abyte0;
        exception;
        abyte0;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean releaseBytes(byte abyte0[])
    {
        boolean flag;
        if (abyte0.length != 0x10000)
        {
            return false;
        }
        flag = false;
        Queue queue = tempQueue;
        queue;
        JVM INSTR monitorenter ;
        if (tempQueue.size() >= 32)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        flag = true;
        tempQueue.offer(abyte0);
        queue;
        JVM INSTR monitorexit ;
        return flag;
        abyte0;
        queue;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

}

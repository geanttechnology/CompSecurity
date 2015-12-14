// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            RollingSampleBuffer

private static final class capacity
{

    private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private int absoluteReadIndex;
    private int capacity;
    private byte encryptionKeys[][];
    private int flags[];
    private long offsets[];
    private int queueSize;
    private int relativeReadIndex;
    private int relativeWriteIndex;
    private int sizes[];
    private long timesUs[];

    public void clear()
    {
        absoluteReadIndex = 0;
        relativeReadIndex = 0;
        relativeWriteIndex = 0;
        queueSize = 0;
    }

    public void commitSample(long l, int i, long l1, int j, byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        timesUs[relativeWriteIndex] = l;
        offsets[relativeWriteIndex] = l1;
        sizes[relativeWriteIndex] = j;
        flags[relativeWriteIndex] = i;
        encryptionKeys[relativeWriteIndex] = abyte0;
        queueSize = queueSize + 1;
        if (queueSize != capacity) goto _L2; else goto _L1
_L1:
        i = capacity + 1000;
        abyte0 = new long[i];
        long al[] = new long[i];
        int ai[] = new int[i];
        int ai1[] = new int[i];
        byte abyte1[][] = new byte[i][];
        j = capacity - relativeReadIndex;
        System.arraycopy(offsets, relativeReadIndex, abyte0, 0, j);
        System.arraycopy(timesUs, relativeReadIndex, al, 0, j);
        System.arraycopy(flags, relativeReadIndex, ai, 0, j);
        System.arraycopy(sizes, relativeReadIndex, ai1, 0, j);
        System.arraycopy(encryptionKeys, relativeReadIndex, abyte1, 0, j);
        int k = relativeReadIndex;
        System.arraycopy(offsets, 0, abyte0, j, k);
        System.arraycopy(timesUs, 0, al, j, k);
        System.arraycopy(flags, 0, ai, j, k);
        System.arraycopy(sizes, 0, ai1, j, k);
        System.arraycopy(encryptionKeys, 0, abyte1, j, k);
        offsets = abyte0;
        timesUs = al;
        flags = ai;
        sizes = ai1;
        encryptionKeys = abyte1;
        relativeReadIndex = 0;
        relativeWriteIndex = capacity;
        queueSize = capacity;
        capacity = i;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        relativeWriteIndex = relativeWriteIndex + 1;
        if (relativeWriteIndex == capacity)
        {
            relativeWriteIndex = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }

    public long discardUpstreamSamples(int i)
    {
        i = getWriteIndex() - i;
        boolean flag;
        if (i >= 0 && i <= queueSize)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (i == 0)
        {
            if (absoluteReadIndex == 0)
            {
                return 0L;
            }
            if (relativeWriteIndex == 0)
            {
                i = capacity;
            } else
            {
                i = relativeWriteIndex;
            }
            i--;
            return offsets[i] + (long)sizes[i];
        } else
        {
            queueSize = queueSize - i;
            relativeWriteIndex = ((relativeWriteIndex + capacity) - i) % capacity;
            return offsets[relativeWriteIndex];
        }
    }

    public int getReadIndex()
    {
        return absoluteReadIndex;
    }

    public int getWriteIndex()
    {
        return absoluteReadIndex + queueSize;
    }

    public long moveToNextSample()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        queueSize = queueSize - 1;
        i = relativeReadIndex;
        relativeReadIndex = i + 1;
        absoluteReadIndex = absoluteReadIndex + 1;
        if (relativeReadIndex == capacity)
        {
            relativeReadIndex = 0;
        }
        if (queueSize <= 0) goto _L2; else goto _L1
_L1:
        long l = offsets[relativeReadIndex];
_L4:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        long l1;
        l = sizes[i];
        l1 = offsets[i];
        l += l1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean peekSample(SampleHolder sampleholder, asHolder asholder)
    {
        this;
        JVM INSTR monitorenter ;
        int i = queueSize;
        if (i != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        sampleholder.timeUs = timesUs[relativeReadIndex];
        sampleholder.size = sizes[relativeReadIndex];
        sampleholder.flags = flags[relativeReadIndex];
        asholder.offset = offsets[relativeReadIndex];
        asholder.encryptionKeyId = encryptionKeys[relativeReadIndex];
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        sampleholder;
        throw sampleholder;
    }

    public long skipToKeyframeBefore(long l)
    {
        long l2 = -1L;
        this;
        JVM INSTR monitorenter ;
        long l1 = l2;
        if (queueSize == 0) goto _L2; else goto _L1
_L1:
        l1 = timesUs[relativeReadIndex];
        if (l >= l1) goto _L4; else goto _L3
_L3:
        l1 = l2;
_L2:
        this;
        JVM INSTR monitorexit ;
        return l1;
_L4:
        if (relativeWriteIndex != 0) goto _L6; else goto _L5
_L5:
        int i = capacity;
_L9:
        l1 = l2;
        if (l > timesUs[i - 1])
        {
            continue; /* Loop/switch isn't completed */
        }
        int k;
        i = 0;
        k = -1;
        int j = relativeReadIndex;
_L10:
        if (j != relativeWriteIndex && timesUs[j] <= l) goto _L8; else goto _L7
_L7:
        l1 = l2;
        if (k == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        queueSize = queueSize - k;
        relativeReadIndex = (relativeReadIndex + k) % capacity;
        absoluteReadIndex = absoluteReadIndex + k;
        l1 = offsets[relativeReadIndex];
        continue; /* Loop/switch isn't completed */
_L6:
        i = relativeWriteIndex;
          goto _L9
_L8:
        if ((flags[j] & 1) != 0)
        {
            k = i;
        }
        j = (j + 1) % capacity;
        i++;
          goto _L10
        Exception exception;
        exception;
        throw exception;
        if (true) goto _L2; else goto _L11
_L11:
    }

    public asHolder()
    {
        capacity = 1000;
        offsets = new long[capacity];
        timesUs = new long[capacity];
        flags = new int[capacity];
        sizes = new int[capacity];
        encryptionKeys = new byte[capacity][];
    }
}

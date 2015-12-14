// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.CryptoInfo;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.upstream.Allocation;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorInput

final class RollingSampleBuffer
{
    private static final class InfoQueue
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

        public boolean peekSample(SampleHolder sampleholder, SampleExtrasHolder sampleextrasholder)
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
            sampleextrasholder.offset = offsets[relativeReadIndex];
            sampleextrasholder.encryptionKeyId = encryptionKeys[relativeReadIndex];
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

        public InfoQueue()
        {
            capacity = 1000;
            offsets = new long[capacity];
            timesUs = new long[capacity];
            flags = new int[capacity];
            sizes = new int[capacity];
            encryptionKeys = new byte[capacity][];
        }
    }

    private static final class SampleExtrasHolder
    {

        public byte encryptionKeyId[];
        public long offset;

        private SampleExtrasHolder()
        {
        }

    }


    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private final LinkedBlockingDeque dataQueue = new LinkedBlockingDeque();
    private final SampleExtrasHolder extrasHolder = new SampleExtrasHolder();
    private final InfoQueue infoQueue = new InfoQueue();
    private Allocation lastAllocation;
    private int lastAllocationOffset;
    private final ParsableByteArray scratch = new ParsableByteArray(32);
    private long totalBytesDropped;
    private long totalBytesWritten;

    public RollingSampleBuffer(Allocator allocator1)
    {
        allocator = allocator1;
        allocationLength = allocator1.getIndividualAllocationLength();
        lastAllocationOffset = allocationLength;
    }

    private void dropDownstreamTo(long l)
    {
        int j = (int)(l - totalBytesDropped) / allocationLength;
        for (int i = 0; i < j; i++)
        {
            allocator.release((Allocation)dataQueue.remove());
            totalBytesDropped = totalBytesDropped + (long)allocationLength;
        }

    }

    private void dropUpstreamFrom(long l)
    {
        int j = (int)(l - totalBytesDropped);
        int i = j / allocationLength;
        int i1 = j % allocationLength;
        j = dataQueue.size() - i - 1;
        i = j;
        if (i1 == 0)
        {
            i = j + 1;
        }
        for (int k = 0; k < i; k++)
        {
            allocator.release((Allocation)dataQueue.removeLast());
        }

        lastAllocation = (Allocation)dataQueue.peekLast();
        i = i1;
        if (i1 == 0)
        {
            i = allocationLength;
        }
        lastAllocationOffset = i;
    }

    private static void ensureCapacity(ParsableByteArray parsablebytearray, int i)
    {
        if (parsablebytearray.limit() < i)
        {
            parsablebytearray.reset(new byte[i], i);
        }
    }

    private int prepareForAppend(int i)
    {
        if (lastAllocationOffset == allocationLength)
        {
            lastAllocationOffset = 0;
            lastAllocation = allocator.allocate();
            dataQueue.add(lastAllocation);
        }
        return Math.min(i, allocationLength - lastAllocationOffset);
    }

    private void readData(long l, ByteBuffer bytebuffer, int i)
    {
        int k;
        for (; i > 0; i -= k)
        {
            dropDownstreamTo(l);
            int j = (int)(l - totalBytesDropped);
            k = Math.min(i, allocationLength - j);
            Allocation allocation = (Allocation)dataQueue.peek();
            bytebuffer.put(allocation.data, allocation.translateOffset(j), k);
            l += k;
        }

    }

    private void readData(long l, byte abyte0[], int i)
    {
        int i1;
        for (int j = 0; j < i; j += i1)
        {
            dropDownstreamTo(l);
            int k = (int)(l - totalBytesDropped);
            i1 = Math.min(i - j, allocationLength - k);
            Allocation allocation = (Allocation)dataQueue.peek();
            System.arraycopy(allocation.data, allocation.translateOffset(k), abyte0, j, i1);
            l += i1;
        }

    }

    private void readEncryptionData(SampleHolder sampleholder, SampleExtrasHolder sampleextrasholder)
    {
        int ai[];
        int ai1[];
        int k;
        long l;
label0:
        {
            l = sampleextrasholder.offset;
            readData(l, scratch.data, 1);
            l++;
            k = scratch.data[0];
            int ai2[];
            int i;
            long l1;
            if ((k & 0x80) != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            k &= 0x7f;
            if (sampleholder.cryptoInfo.iv == null)
            {
                sampleholder.cryptoInfo.iv = new byte[16];
            }
            readData(l, sampleholder.cryptoInfo.iv, k);
            l += k;
            if (i != 0)
            {
                readData(l, scratch.data, 2);
                l += 2L;
                scratch.setPosition(0);
                k = scratch.readUnsignedShort();
            } else
            {
                k = 1;
            }
            ai1 = sampleholder.cryptoInfo.numBytesOfClearData;
            if (ai1 != null)
            {
                ai = ai1;
                if (ai1.length >= k)
                {
                    break label0;
                }
            }
            ai = new int[k];
        }
label1:
        {
            ai2 = sampleholder.cryptoInfo.numBytesOfEncryptedData;
            if (ai2 != null)
            {
                ai1 = ai2;
                if (ai2.length >= k)
                {
                    break label1;
                }
            }
            ai1 = new int[k];
        }
        if (i != 0)
        {
            i = k * 6;
            ensureCapacity(scratch, i);
            readData(l, scratch.data, i);
            l1 = l + (long)i;
            scratch.setPosition(0);
            i = 0;
            do
            {
                l = l1;
                if (i >= k)
                {
                    break;
                }
                ai[i] = scratch.readUnsignedShort();
                ai1[i] = scratch.readUnsignedIntToInt();
                i++;
            } while (true);
        } else
        {
            ai[0] = 0;
            ai1[0] = sampleholder.size - (int)(l - sampleextrasholder.offset);
        }
        sampleholder.cryptoInfo.set(k, ai, ai1, sampleextrasholder.encryptionKeyId, sampleholder.cryptoInfo.iv, 1);
        int j = (int)(l - sampleextrasholder.offset);
        sampleextrasholder.offset = sampleextrasholder.offset + (long)j;
        sampleholder.size = sampleholder.size - j;
    }

    public int appendData(ExtractorInput extractorinput, int i, boolean flag)
        throws IOException, InterruptedException
    {
        i = prepareForAppend(i);
        i = extractorinput.read(lastAllocation.data, lastAllocation.translateOffset(lastAllocationOffset), i);
        if (i == -1)
        {
            if (flag)
            {
                return -1;
            } else
            {
                throw new EOFException();
            }
        } else
        {
            lastAllocationOffset = lastAllocationOffset + i;
            totalBytesWritten = totalBytesWritten + (long)i;
            return i;
        }
    }

    public int appendData(DataSource datasource, int i, boolean flag)
        throws IOException
    {
        i = prepareForAppend(i);
        i = datasource.read(lastAllocation.data, lastAllocation.translateOffset(lastAllocationOffset), i);
        if (i == -1)
        {
            if (flag)
            {
                return -1;
            } else
            {
                throw new EOFException();
            }
        } else
        {
            lastAllocationOffset = lastAllocationOffset + i;
            totalBytesWritten = totalBytesWritten + (long)i;
            return i;
        }
    }

    public void appendData(ParsableByteArray parsablebytearray, int i)
    {
        int j;
        for (; i > 0; i -= j)
        {
            j = prepareForAppend(i);
            parsablebytearray.readBytes(lastAllocation.data, lastAllocation.translateOffset(lastAllocationOffset), j);
            lastAllocationOffset = lastAllocationOffset + j;
            totalBytesWritten = totalBytesWritten + (long)j;
        }

    }

    public void clear()
    {
        infoQueue.clear();
        for (; !dataQueue.isEmpty(); allocator.release((Allocation)dataQueue.remove())) { }
        totalBytesDropped = 0L;
        totalBytesWritten = 0L;
        lastAllocation = null;
        lastAllocationOffset = allocationLength;
    }

    public void commitSample(long l, int i, long l1, int j, byte abyte0[])
    {
        infoQueue.commitSample(l, i, l1, j, abyte0);
    }

    public void discardUpstreamSamples(int i)
    {
        totalBytesWritten = infoQueue.discardUpstreamSamples(i);
        dropUpstreamFrom(totalBytesWritten);
    }

    public int getReadIndex()
    {
        return infoQueue.getReadIndex();
    }

    public int getWriteIndex()
    {
        return infoQueue.getWriteIndex();
    }

    public long getWritePosition()
    {
        return totalBytesWritten;
    }

    public boolean peekSample(SampleHolder sampleholder)
    {
        return infoQueue.peekSample(sampleholder, extrasHolder);
    }

    public boolean readSample(SampleHolder sampleholder)
    {
        if (!infoQueue.peekSample(sampleholder, extrasHolder))
        {
            return false;
        }
        if (sampleholder.isEncrypted())
        {
            readEncryptionData(sampleholder, extrasHolder);
        }
        if (sampleholder.data == null || sampleholder.data.capacity() < sampleholder.size)
        {
            sampleholder.replaceBuffer(sampleholder.size);
        }
        if (sampleholder.data != null)
        {
            readData(extrasHolder.offset, sampleholder.data, sampleholder.size);
        }
        dropDownstreamTo(infoQueue.moveToNextSample());
        return true;
    }

    public void skipSample()
    {
        dropDownstreamTo(infoQueue.moveToNextSample());
    }

    public boolean skipToKeyframeBefore(long l)
    {
        l = infoQueue.skipToKeyframeBefore(l);
        if (l == -1L)
        {
            return false;
        } else
        {
            dropDownstreamTo(l);
            return true;
        }
    }
}

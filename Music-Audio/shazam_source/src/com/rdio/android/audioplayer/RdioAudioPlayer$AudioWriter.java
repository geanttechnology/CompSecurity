// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import com.rdio.android.audioplayer.io.AndroidByteBuffer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

private class setGaplessParameters
{
    public class WriteBuffer
    {

        private byte data[];
        private int offset;
        private int size;
        final RdioAudioPlayer.AudioWriter this$1;

        public void get(AndroidByteBuffer androidbytebuffer, int i)
        {
            androidbytebuffer.get(data, 0, i);
            offset = 0;
            size = i;
        }

        public int getCapacity()
        {
            if (getData() != null)
            {
                return getData().length;
            } else
            {
                return 0;
            }
        }

        public byte[] getData()
        {
            return data;
        }

        public int getOffset()
        {
            return offset;
        }

        public int getSize()
        {
            return size;
        }

        public void resize(int i)
        {
            data = new byte[i];
            offset = 0;
            size = 0;
        }

        public int trimPadding(int i, int j)
        {
            int l = (getOffset() + getSize()) - 1;
            int k;
            for (k = 0; k < i && l >= getOffset() && data[l] == 0; k++)
            {
                l--;
            }

            i = k - k % j;
            size = size - i;
            return i;
        }

        public int trimPriming(int i, int j)
        {
            for (int k = getCapacity(); getOffset() < i && getOffset() < k && getData()[getOffset()] == 0;)
            {
                offset = offset + 1;
            }

            offset = offset - offset % j;
            size = size - offset;
            return offset;
        }

        public WriteBuffer(int i)
        {
            this$1 = RdioAudioPlayer.AudioWriter.this;
            super();
            resize(i);
        }
    }


    public static final int TRIM_ALL_SILENCE = 0x7fffffff;
    public static final int TRIM_NONE = 0;
    private final int DEFAULT_SAMPLE_SIZE = 4;
    private final String GAPLESS_TAG = "Gapless";
    private final int INVALID_INDEX = -1;
    private List bufferList;
    private int currIndex;
    private int firstIndex;
    private boolean isGapless;
    private int numBuffers;
    private int sampleSize;
    final RdioAudioPlayer this$0;
    private int totalPaddingBytesTrimmed;
    private int totalPrimingBytesTrimmed;
    private int trimPadding;
    private int trimPriming;

    public int getTotalPaddingBytesTrimmed()
    {
        return totalPaddingBytesTrimmed;
    }

    public int getTotalPrimingBytesTrimmed()
    {
        return totalPrimingBytesTrimmed;
    }

    public void setGaplessParameters(int i, int j)
    {
        setGaplessParameters(i, j, 4);
    }

    public void setGaplessParameters(int i, int j, int k)
    {
        trimPriming = i;
        trimPadding = j;
        sampleSize = k;
        boolean flag;
        if (trimPriming != 0 || trimPadding != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isGapless = flag;
        firstIndex = -1;
        currIndex = 0;
    }

    public void write(AndroidByteBuffer androidbytebuffer, int i, boolean flag)
    {
        WriteBuffer writebuffer;
        if (bufferList.size() <= currIndex)
        {
            writebuffer = new WriteBuffer(i);
            bufferList.add(writebuffer);
        } else
        {
            WriteBuffer writebuffer1 = (WriteBuffer)bufferList.get(currIndex);
            writebuffer = writebuffer1;
            if (writebuffer1.getCapacity() < i)
            {
                writebuffer1.resize(i);
                writebuffer = writebuffer1;
            }
        }
        writebuffer.get(androidbytebuffer, i);
        if (firstIndex == -1 && currIndex == numBuffers - 1)
        {
            firstIndex = 0;
        }
        androidbytebuffer = writebuffer;
        if (isGapless)
        {
            if (trimPriming > 0)
            {
                int j = Math.min(trimPriming, writebuffer.getSize());
                i = writebuffer.getSize();
                j = writebuffer.trimPriming(j, sampleSize);
                if (j != i || j == trimPriming)
                {
                    trimPriming = 0;
                } else
                {
                    trimPriming = trimPriming - j;
                }
                totalPrimingBytesTrimmed = j + totalPrimingBytesTrimmed;
            }
            if (flag && trimPadding > 0)
            {
                i = currIndex + 1;
                do
                {
                    i = ((i + numBuffers) - 1) % numBuffers;
                    androidbytebuffer = (WriteBuffer)bufferList.get(i);
                    j = androidbytebuffer.getSize();
                    int k = androidbytebuffer.trimPadding(trimPadding, sampleSize);
                    if (k != j || k == trimPadding)
                    {
                        trimPadding = 0;
                    } else
                    {
                        trimPadding = trimPadding - k;
                    }
                } while (trimPadding != 0 && i != firstIndex);
                totalPaddingBytesTrimmed = k + totalPaddingBytesTrimmed;
            }
            if (firstIndex != -1)
            {
                androidbytebuffer = (WriteBuffer)bufferList.get(firstIndex);
            } else
            {
                androidbytebuffer = null;
            }
        }
        if (androidbytebuffer != null && androidbytebuffer.getSize() > 0)
        {
            RdioAudioPlayer.this.write(androidbytebuffer.getData(), androidbytebuffer.getOffset(), androidbytebuffer.getSize());
        }
        if (firstIndex != -1)
        {
            i = firstIndex;
        } else
        {
            i = currIndex + 1;
        }
        currIndex = i;
        if (firstIndex != -1)
        {
            firstIndex = (firstIndex + 1) % numBuffers;
        }
        if (isGapless && flag)
        {
            if (firstIndex == -1)
            {
                i = 0;
            } else
            {
                i = firstIndex;
            }
            for (; i != currIndex; i = (i + 1) % numBuffers)
            {
                androidbytebuffer = (WriteBuffer)bufferList.get(i);
                if (androidbytebuffer.getSize() > 0)
                {
                    RdioAudioPlayer.this.write(androidbytebuffer.getData(), androidbytebuffer.getOffset(), androidbytebuffer.getSize());
                }
            }

            firstIndex = -1;
            currIndex = 0;
        }
    }

    public WriteBuffer.resize(int i)
    {
        this$0 = RdioAudioPlayer.this;
        super();
        numBuffers = i;
        bufferList = new ArrayList();
        setGaplessParameters(0, 0);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import com.rdio.android.audioplayer.io.AndroidByteBuffer;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

public class resize
{

    private byte data[];
    private int offset;
    private int size;
    final offset this$1;

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

    public (int i)
    {
        this$1 = this._cls1.this;
        super();
        resize(i);
    }
}

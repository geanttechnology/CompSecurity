// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.io;

import android.util.Log;
import java.nio.ByteBuffer;

// Referenced classes of package com.rdio.android.audioplayer.io:
//            MediaBuffer

public class AndroidByteBuffer
    implements MediaBuffer
{

    public ByteBuffer buffer;

    public AndroidByteBuffer()
    {
    }

    public void clear()
    {
        buffer.clear();
    }

    public void get(byte abyte0[], int i, int j)
    {
        buffer.get(abyte0, i, j);
    }

    public void peek(byte abyte0[], int i, int j)
    {
        get(abyte0, i, j);
        buffer.flip();
    }

    public void put(byte abyte0[], int i, int j)
    {
        if (buffer.remaining() < j)
        {
            Log.e("AndroidByteBuffer", "Requested put() byte count is greater than bytes in buffer");
        }
        buffer.put(abyte0, i, Math.min(j, buffer.remaining()));
        buffer.flip();
    }

    public void putMediaData(int i, byte abyte0[], int j, byte abyte1[], int k)
    {
        if (i > 0)
        {
            buffer.position(i);
        }
        if (buffer.remaining() < j + k)
        {
            Log.e("AndroidByteBuffer", "Requested put() byte count is greater than bytes in buffer");
        }
        buffer.put(abyte0, 0, j);
        buffer.put(abyte1, 0, Math.min(k, buffer.remaining()));
        buffer.flip();
    }
}

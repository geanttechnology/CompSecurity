// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer:
//            CryptoInfo

public final class SampleHolder
{

    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    private final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo = new CryptoInfo();
    public ByteBuffer data;
    public int flags;
    public int size;
    public long timeUs;

    public SampleHolder(int i)
    {
        bufferReplacementMode = i;
    }

    public void clearData()
    {
        if (data != null)
        {
            data.clear();
        }
    }

    public boolean isDecodeOnly()
    {
        return (flags & 0x8000000) != 0;
    }

    public boolean isEncrypted()
    {
        return (flags & 2) != 0;
    }

    public boolean isSyncFrame()
    {
        return (flags & 1) != 0;
    }

    public boolean replaceBuffer(int i)
    {
        switch (bufferReplacementMode)
        {
        default:
            return false;

        case 1: // '\001'
            data = ByteBuffer.allocate(i);
            return true;

        case 2: // '\002'
            data = ByteBuffer.allocateDirect(i);
            break;
        }
        return true;
    }
}

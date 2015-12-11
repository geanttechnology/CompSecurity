// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.content;

import java.nio.ByteBuffer;

// Referenced classes of package com.immersion.content:
//            a

public class HapticHeaderUtils extends a
{

    public static int b = 33;
    public static int c = 1;
    public static int d = 2;
    public static int e;
    long a;
    private byte f[];
    private int g;

    public HapticHeaderUtils()
    {
        int i = b;
        switch ((i * (c + i)) % d)
        {
        default:
            b = 43;
            c = 80;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            super();
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    private native int calculateBlockRateNative(long l);

    private native int calculateBlockSizeNative(long l);

    private native int calculateByteOffsetIntoHapticDataNative(long l, int i);

    private native void disposeNative(long l);

    private native int getMajorVersionNumberNative(long l);

    private native int getNumChannelsNative(long l);

    private native long init(byte abyte0[], int i);

    public final int a()
    {
        if (((b + c) * b) % d != e)
        {
            b = 80;
            e = 84;
        }
        return calculateBlockSizeNative(a);
    }

    public final int a(int i)
    {
        long l = a;
        switch (((c + 80) * 80) % d)
        {
        default:
            b = 89;
            e = 80;
            // fall through

        case 0: // '\0'
            return calculateByteOffsetIntoHapticDataNative(l, i);
        }
    }

    public final void a(ByteBuffer bytebuffer, int i)
    {
        g = i;
        f = new byte[g];
        bytebuffer.get(f, 0, g);
        a = init(f, g);
    }

    public final int b()
    {
        if (((b + 1) * b) % d != 0)
        {
            b = 80;
            e = 12;
        }
        return calculateBlockRateNative(a);
    }

    public final int c()
    {
        return getMajorVersionNumberNative(a);
    }

    public final int d()
    {
        if (((b + 1) * b) % d != e)
        {
            b = 92;
            e = 80;
        }
        int i;
        try
        {
            i = getNumChannelsNative(a);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return i;
    }

    public final void e()
    {
        if (((b + 1) * b) % d != e)
        {
            b = 80;
            e = 92;
        }
        disposeNative(a);
    }
}

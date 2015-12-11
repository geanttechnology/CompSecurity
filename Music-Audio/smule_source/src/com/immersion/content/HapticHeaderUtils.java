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
    private byte i[];
    private int j;

    public HapticHeaderUtils()
    {
        int k = b;
        switch ((k * (c + k)) % d)
        {
        default:
            b = 43;
            c = a();
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

    public static int a()
    {
        return 80;
    }

    private native int calculateBlockRateNative(long l);

    private native int calculateBlockSizeNative(long l);

    private native int calculateByteOffsetIntoHapticDataNative(long l, int k);

    public static int d()
    {
        return 0;
    }

    private native void disposeNative(long l);

    public static int e()
    {
        return 1;
    }

    private native int getMajorVersionNumberNative(long l);

    private native int getNumChannelsNative(long l);

    private native long init(byte abyte0[], int k);

    public int a(int k)
    {
        long l1 = a;
        int l = a();
        switch ((l * (c + l)) % d)
        {
        default:
            b = 89;
            e = a();
            // fall through

        case 0: // '\0'
            return calculateByteOffsetIntoHapticDataNative(l1, k);
        }
    }

    public void a(ByteBuffer bytebuffer, int k)
    {
        j = k;
        i = new byte[j];
        bytebuffer.get(i, 0, j);
        a = init(i, j);
    }

    public int b()
    {
        if (((b + c) * b) % d != e)
        {
            b = a();
            e = 84;
        }
        int k = calculateBlockSizeNative(a);
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (0)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        break label0;

                    case 1: // '\001'
                        continue label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        return k;
    }

    public int c()
    {
        if (((b + e()) * b) % d != d())
        {
            b = a();
            e = 12;
        }
        return calculateBlockRateNative(a);
    }

    public int f()
    {
        return getMajorVersionNumberNative(a);
    }

    public int g()
    {
        if (((b + e()) * b) % d != e)
        {
            b = 92;
            e = a();
        }
        int k;
        try
        {
            k = getNumChannelsNative(a);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return k;
    }

    public void h()
    {
label0:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (0)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        break label0;

                    case 1: // '\001'
                        continue label0;
                    }
                }
                break;

            case 0: // '\0'
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        if (((b + e()) * b) % d != e)
        {
            b = a();
            e = 92;
        }
        disposeNative(a);
    }
}

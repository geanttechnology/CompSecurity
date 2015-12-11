// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.b.a;
import com.gimbal.internal.proximity.core.b.b;
import java.util.Arrays;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            m

public final class j
{

    private static final byte c[] = {
        3, 7
    };
    private static final byte d[] = {
        -1
    };
    public byte a[];
    public m b;

    public j(byte abyte0[])
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            throw new b(a.c);
        }
        byte byte2 = a(abyte0, (byte)0);
        a(abyte0, (byte)1, c);
        if (byte2 != 2 && byte2 != 16)
        {
            throw new b(a.d);
        }
        a = Arrays.copyOfRange(abyte0, 2, byte2 + 2);
        byte byte0 = (byte)(byte2 + 2);
        byte byte1 = (byte)(byte0 + 1);
        byte2 = a(abyte0, byte0);
        byte byte3 = (byte)(byte1 + 1);
        a(abyte0, byte1, d);
        if (byte2 < 2)
        {
            throw new b(a.c);
        } else
        {
            b = new m();
            b.c = Arrays.copyOfRange(abyte0, byte3, byte3 + byte2);
            b.a = Arrays.copyOfRange(abyte0, byte3, byte3 + 2);
            b.b = Arrays.copyOfRange(abyte0, byte3 + 2, byte2 + byte3);
            return;
        }
    }

    private static byte a(byte abyte0[], byte byte0)
    {
        if (abyte0 == null || byte0 >= abyte0.length || byte0 < 0)
        {
            throw new b(a.c);
        }
        byte byte1 = (byte)(abyte0[byte0] & 0xff);
        if (abyte0.length <= byte0 + byte1)
        {
            throw new b(a.c);
        } else
        {
            return (byte)(byte1 - 1);
        }
    }

    private static byte a(byte abyte0[], byte byte0, byte abyte1[])
    {
        if (abyte0 == null || byte0 >= abyte0.length || byte0 < 0)
        {
            throw new b(a.c);
        }
        byte byte1 = (byte)(abyte0[byte0] & 0xff);
        int i = abyte1.length;
        for (byte0 = 0; byte0 < i; byte0++)
        {
            if (byte1 == abyte1[byte0])
            {
                return byte1;
            }
        }

        throw new b(a.d);
    }

    public final String toString()
    {
        return String.format("AdvertisementData:[serviceId:%s], [manufacturerSpecificData: %s", new Object[] {
            com.gimbal.internal.c.c.a(a), b.toString()
        });
    }

}

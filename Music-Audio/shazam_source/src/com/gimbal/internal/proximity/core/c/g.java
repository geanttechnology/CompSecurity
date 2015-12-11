// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import com.gimbal.a.a;
import com.gimbal.a.b;
import com.gimbal.internal.c.c;
import java.nio.ByteOrder;
import java.util.UUID;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            d

public class g
{

    private static a a = c.e(com/gimbal/internal/proximity/core/c/g.getSimpleName());
    private static b b = c.f(com/gimbal/internal/proximity/core/c/g.getSimpleName());

    public g()
    {
    }

    public static String a(String s)
    {
        boolean flag = false;
        s = s.getBytes();
        int j = s.length - 1;
        int k = 0;
        int i;
        do
        {
            i = ((flag) ? 1 : 0);
            if (k >= j)
            {
                break;
            }
            byte byte0 = s[k];
            s[k] = s[j];
            s[j] = byte0;
            k++;
            j--;
        } while (true);
        while (i < s.length) 
        {
            byte byte1 = s[i];
            if (byte1 != 45)
            {
                s[i] = s[i + 1];
                s[i + 1] = byte1;
            } else
            {
                s[i] = byte1;
                i++;
                byte1 = s[i];
                s[i] = s[i + 1];
                s[i + 1] = byte1;
            }
            i += 2;
        }
        return new String(s);
    }

    public static UUID a(byte abyte0[])
    {
        if (abyte0 == null || abyte0.length != 16)
        {
            return null;
        } else
        {
            return UUID.fromString(String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x", new Object[] {
                Byte.valueOf(abyte0[15]), Byte.valueOf(abyte0[14]), Byte.valueOf(abyte0[13]), Byte.valueOf(abyte0[12]), Byte.valueOf(abyte0[11]), Byte.valueOf(abyte0[10]), Byte.valueOf(abyte0[9]), Byte.valueOf(abyte0[8]), Byte.valueOf(abyte0[7]), Byte.valueOf(abyte0[6]), 
                Byte.valueOf(abyte0[5]), Byte.valueOf(abyte0[4]), Byte.valueOf(abyte0[3]), Byte.valueOf(abyte0[2]), Byte.valueOf(abyte0[1]), Byte.valueOf(abyte0[0])
            }));
        }
    }

    public static UUID[] a()
    {
        UUID auuid[] = new UUID[5121];
        String s;
        String s1;
        int i;
        int j;
        try
        {
            s = com.gimbal.internal.proximity.core.c.d.b;
        }
        catch (Exception exception)
        {
            b.d("Got exception while creating UUIDs", new Object[] {
                exception
            });
            return auuid;
        }
        j = 0;
        i = 0;
        if (j > 4095)
        {
            break; /* Loop/switch isn't completed */
        }
        auuid[i] = UUID.fromString(s.concat(String.format("%03x", new Object[] {
            Integer.valueOf(j)
        })));
        j++;
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_16;
_L1:
        s = d.d;
        j = 0;
_L4:
        if (j > 1023)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s.concat(String.format("%03x", new Object[] {
            Integer.valueOf(j + 2048)
        })).concat(d.e);
        a(s1);
        auuid[i] = UUID.fromString(s1);
        j++;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        auuid[i] = UUID.fromString(com.gimbal.internal.proximity.core.c.d.c);
        ByteOrder.nativeOrder();
        return auuid;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.b.a;

import java.net.DatagramPacket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package org.a.a.b.a:
//            c, e

public final class b
    implements c
{

    private final byte a[] = new byte[48];
    private volatile DatagramPacket b;

    public b()
    {
    }

    private int b(int i)
    {
        return (a[i] & 0xff) << 24 | (a[i + 1] & 0xff) << 16 | (a[i + 2] & 0xff) << 8 | a[i + 3] & 0xff;
    }

    private e c(int i)
    {
        return new e((long)(a[i] & 0xff) << 56 | (long)(a[i + 1] & 0xff) << 48 | (long)(a[i + 2] & 0xff) << 40 | (long)(a[i + 3] & 0xff) << 32 | (long)(a[i + 4] & 0xff) << 24 | (long)(a[i + 5] & 0xff) << 16 | (long)(a[i + 6] & 0xff) << 8 | (long)(a[i + 7] & 0xff));
    }

    private int f()
    {
        return (a[0] & 0xff) >> 3 & 7;
    }

    private String g()
    {
        int i = f();
        int j = a[1] & 0xff;
        if (i == 3 || i == 4)
        {
            if (j == 0 || j == 1)
            {
                StringBuilder stringbuilder = new StringBuilder();
                i = 0;
                do
                {
                    if (i > 3)
                    {
                        break;
                    }
                    char c1 = (char)a[i + 12];
                    if (c1 == 0)
                    {
                        break;
                    }
                    stringbuilder.append(c1);
                    i++;
                } while (true);
                return stringbuilder.toString();
            }
            if (i == 4)
            {
                return h();
            }
        }
        if (j >= 2)
        {
            return (new StringBuilder()).append(a[12] & 0xff).append(".").append(a[13] & 0xff).append(".").append(a[14] & 0xff).append(".").append(a[15] & 0xff).toString();
        } else
        {
            return h();
        }
    }

    private String h()
    {
        return Integer.toHexString(b(12));
    }

    public final void a()
    {
        a[0] = (byte)(a[0] & 0xf8 | 3);
    }

    public final void a(int i)
    {
        a[0] = (byte)(a[0] & 0xc7 | (i & 7) << 3);
    }

    public final void a(e e1)
    {
        int i;
        long l;
        if (e1 == null)
        {
            l = 0L;
        } else
        {
            l = e1.a;
        }
        for (i = 7; i >= 0; i--)
        {
            a[i + 40] = (byte)(int)(255L & l);
            l >>>= 8;
        }

    }

    public final e b()
    {
        return c(40);
    }

    public final e c()
    {
        return c(24);
    }

    public final e d()
    {
        return c(32);
    }

    public final DatagramPacket e()
    {
        this;
        JVM INSTR monitorenter ;
        DatagramPacket datagrampacket;
        if (b == null)
        {
            b = new DatagramPacket(a, a.length);
            b.setPort(123);
        }
        datagrampacket = b;
        this;
        JVM INSTR monitorexit ;
        return datagrampacket;
        Exception exception;
        exception;
        throw exception;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("[version:")).append(f()).append(", mode:").append((a[0] & 0xff) >> 0 & 7).append(", poll:").append(a[2]).append(", precision:").append(a[3]).append(", delay:").append(b(4)).append(", dispersion(ms):").append((double)b(8) / 65.536000000000001D).append(", id:").append(g()).append(", xmitTime:");
        e e1 = c(40);
        if (e1.b == null)
        {
            e1.b = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS", Locale.US);
            e1.b.setTimeZone(TimeZone.getDefault());
        }
        Date date = new Date(org.a.a.b.a.e.a(e1.a));
        return stringbuilder.append(e1.b.format(date)).append(" ]").toString();
    }
}

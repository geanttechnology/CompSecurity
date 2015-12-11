// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class fq
{

    public long a;
    public long b;
    public long c;

    public fq()
    {
    }

    private static long a(byte abyte0[], int i)
    {
        int j = abyte0[i];
        int k = abyte0[i + 1];
        int l = abyte0[i + 2];
        byte byte0 = abyte0[i + 3];
        i = j;
        if ((j & 0x80) == 128)
        {
            i = (j & 0x7f) + 128;
        }
        j = k;
        if ((k & 0x80) == 128)
        {
            j = (k & 0x7f) + 128;
        }
        k = l;
        if ((l & 0x80) == 128)
        {
            k = (l & 0x7f) + 128;
        }
        l = byte0;
        if ((byte0 & 0x80) == 128)
        {
            l = (byte0 & 0x7f) + 128;
        }
        long l1 = i;
        long l2 = j;
        long l3 = k;
        return (long)l + ((l2 << 16) + (l1 << 24) + (l3 << 8));
    }

    private static long b(byte abyte0[], int i)
    {
        return (a(abyte0, i) - 0x83aa7e80L) * 1000L + (a(abyte0, i + 4) * 1000L) / 0x100000000L;
    }

    public final boolean a(String s, int i)
    {
        Object obj1 = null;
        Object obj = new DatagramSocket();
        ((DatagramSocket) (obj)).setSoTimeout(i);
        obj1 = InetAddress.getByName(s);
        s = new byte[48];
        obj1 = new DatagramPacket(s, s.length, ((InetAddress) (obj1)), 123);
        s[0] = 27;
        long l;
        long l1;
        long l2;
        l2 = System.currentTimeMillis();
        l = SystemClock.elapsedRealtime();
        l1 = l2 / 1000L;
        long l3 = l1 + 0x83aa7e80L;
        s[40] = (byte)(int)(l3 >> 24);
        s[41] = (byte)(int)(l3 >> 16);
        s[42] = (byte)(int)(l3 >> 8);
        s[43] = (byte)(int)(l3 >> 0);
        l1 = (0x100000000L * (l2 - 1000L * l1)) / 1000L;
        s[44] = (byte)(int)(l1 >> 24);
        s[45] = (byte)(int)(l1 >> 16);
        s[46] = (byte)(int)(l1 >> 8);
        s[47] = (byte)(int)(Math.random() * 255D);
        ((DatagramSocket) (obj)).send(((DatagramPacket) (obj1)));
        ((DatagramSocket) (obj)).receive(new DatagramPacket(s, s.length));
        l1 = SystemClock.elapsedRealtime();
        l2 += l1 - l;
        long l4 = b(s, 24);
        long l5 = b(s, 32);
        long l6 = b(s, 40);
        a = ((l6 - l2) + (l5 - l4)) / 2L + l2;
        b = l1;
        c = l1 - l - (l6 - l5);
        ((DatagramSocket) (obj)).close();
        return true;
        s;
        obj = null;
_L4:
        if (obj != null)
        {
            ((DatagramSocket) (obj)).close();
        }
        return false;
        s;
        obj = obj1;
_L2:
        if (obj != null)
        {
            ((DatagramSocket) (obj)).close();
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        if (true) goto _L4; else goto _L3
_L3:
    }
}

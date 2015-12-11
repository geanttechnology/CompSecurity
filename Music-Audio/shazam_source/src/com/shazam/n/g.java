// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.n;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.a.a.b.a.a;
import org.a.a.b.a.b;
import org.a.a.b.a.c;
import org.a.a.b.a.d;
import org.a.a.b.a.e;

// Referenced classes of package com.shazam.n:
//            d

public final class g
    implements com.shazam.n.d
{

    private final a a;

    public g(a a1)
    {
        a = a1;
    }

    public final d a(InetAddress inetaddress)
    {
        a a1 = a;
        if (!a1.c())
        {
            a1.a();
        }
        b b1 = new b();
        b1.a();
        b1.a(a1.e);
        DatagramPacket datagrampacket = b1.e();
        datagrampacket.setAddress(inetaddress);
        datagrampacket.setPort(123);
        inetaddress = new b();
        DatagramPacket datagrampacket1 = inetaddress.e();
        b1.a(e.a());
        a1.b.send(datagrampacket);
        a1.b.receive(datagrampacket1);
        inetaddress = new d(inetaddress, System.currentTimeMillis());
        a.b();
        return inetaddress;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.MulticastSocket;

final class cft
    implements Runnable
{

    private String a;
    private MulticastSocket b;
    private cfs c;

    cft(cfs cfs1, String s, MulticastSocket multicastsocket)
    {
        c = cfs1;
        a = s;
        b = multicastsocket;
        super();
    }

    public final void run()
    {
        java.net.DatagramPacket datagrampacket;
        try
        {
            datagrampacket = cfs.b(a);
        }
        catch (IOException ioexception)
        {
            c.a.a("Error sending Magic packet: %s", ioexception);
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            c.a.c("Error parsing mac address [%s]: %s", new Object[] {
                a, numberformatexception
            });
            return;
        }
        if (datagrampacket == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        b.send(datagrampacket);
    }
}

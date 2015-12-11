// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class cfs
{

    final chq a;
    private final ScheduledExecutorService b = Executors.newScheduledThreadPool(3);

    public cfs(chq chq1)
    {
        a = chq1;
    }

    private MulticastSocket a(NetworkInterface networkinterface)
    {
        MulticastSocket multicastsocket;
        try
        {
            multicastsocket = new MulticastSocket();
            multicastsocket.setNetworkInterface(networkinterface);
            multicastsocket.setBroadcast(true);
        }
        catch (IOException ioexception)
        {
            a.c("Error creating socket on interface %s: %s", new Object[] {
                networkinterface.getDisplayName(), ioexception
            });
            return null;
        }
        return multicastsocket;
    }

    static DatagramPacket b(String s)
    {
        InetAddress inetaddress;
        try
        {
            inetaddress = InetAddress.getByName("255.255.255.255");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (s.length() != 17)
        {
            throw new NumberFormatException("Mac address should be 17 characters long");
        }
        int l = (s.length() - 2) / 5;
        byte abyte0[] = new byte[6];
        for (int i = 0; i < 6; i++)
        {
            abyte0[i] = (byte)Integer.parseInt(s.substring(i * l, i * l + 2), 16);
        }

        s = new byte[102];
        for (int j = 0; j < 6; j++)
        {
            s[j] = -1;
        }

        for (int k = 1; k <= 16; k++)
        {
            System.arraycopy(abyte0, 0, s, k * 6, 6);
        }

        return new DatagramPacket(s, 102, inetaddress, 9);
    }

    public final void a(String s)
    {
        Object obj = cfm.a();
        if (!((List) (obj)).isEmpty())
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                MulticastSocket multicastsocket = a((NetworkInterface)((Iterator) (obj)).next());
                if (multicastsocket != null)
                {
                    int i = 0;
                    while (i < 3) 
                    {
                        b.schedule(new cft(this, s, multicastsocket), i * 300, TimeUnit.MILLISECONDS);
                        i++;
                    }
                }
            }
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.IOException;
import java.net.MulticastSocket;

final class cfo
    implements Runnable
{

    private String a;
    private MulticastSocket b;

    cfo(cfm cfm1, String s, MulticastSocket multicastsocket)
    {
        a = s;
        b = multicastsocket;
        super();
    }

    public final void run()
    {
        java.net.DatagramPacket datagrampacket;
        try
        {
            datagrampacket = cfm.a(a);
        }
        catch (IOException ioexception)
        {
            Log.e(cfm.b(), "Error sending M-search:", ioexception);
            return;
        }
        if (datagrampacket == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        b.send(datagrampacket);
    }
}

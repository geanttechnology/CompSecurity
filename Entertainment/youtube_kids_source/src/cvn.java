// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class cvn
    implements Runnable
{

    private final ExecutorService a = Executors.newFixedThreadPool(2);
    private cvm b;

    public cvn(cvm cvm1)
    {
        b = cvm1;
        super();
    }

    public final void run()
    {
        java.net.Socket socket;
        for (; !Thread.interrupted(); a.execute(new cvo(b, socket)))
        {
            socket = b.c.accept();
        }

          goto _L1
        Object obj;
        obj;
        if (!((SocketException) (obj)).getMessage().equals("Socket closed")) goto _L3; else goto _L2
_L2:
        bmo.e("Server socket closed");
_L5:
        a.shutdownNow();
        return;
_L1:
        a.shutdownNow();
        return;
_L3:
        bmo.a("SocketException when accepting a new connection", ((Throwable) (obj)));
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        a.shutdownNow();
        throw obj;
        obj;
        bmo.a("IOException when accepting a new connection", ((Throwable) (obj)));
        a.shutdownNow();
        return;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MulticastSocket;

final class cfp
    implements Runnable
{

    private MulticastSocket a;
    private cfm b;

    cfp(cfm cfm1, MulticastSocket multicastsocket)
    {
        b = cfm1;
        a = multicastsocket;
        super();
    }

    public final void run()
    {
        cfm.a(b, a, cfm.c());
    }
}

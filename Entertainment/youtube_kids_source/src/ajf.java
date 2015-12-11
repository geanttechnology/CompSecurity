// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.media.RemoteControlClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ajf extends is
    implements cuj
{

    public final aiq a;
    public final ir b;
    public final amd c;
    public final ip d;
    public int e;
    public amd f;
    private final List g = new ArrayList();
    private final chq h;
    private ame i;

    public ajf(Context context, amd amd1, ii ii, aiq aiq1, ip ip1, chq chq1)
    {
        e = 0;
        b = ir.a(context);
        c = (amd)b.a(amd1);
        context = b;
        ir.a(ii);
        a = aiq1;
        d = (ip)b.a(ip1);
        h = (chq)b.a(chq1);
    }

    public final void a(ajg ajg1)
    {
        this;
        JVM INSTR monitorenter ;
        g.add(ajg1);
        this;
        JVM INSTR monitorexit ;
        return;
        ajg1;
        throw ajg1;
    }

    public final void a(RemoteControlClient remotecontrolclient)
    {
        b.a();
        ir ir1 = b;
        ir.a(remotecontrolclient);
    }

    public final void a(ir ir1, iz iz1)
    {
        ir1 = h;
        ir1 = String.valueOf(iz1);
        (new StringBuilder(String.valueOf(ir1).length() + 12)).append("Route added ").append(ir1);
        a.b(iz1);
    }

    public final void a(iz iz1)
    {
        chq chq1 = h;
        String s = String.valueOf(iz1);
        chq1.a((new StringBuilder(String.valueOf(s).length() + 15)).append("Route selected ").append(s).toString());
        if (a.d(iz1) || ais.a(iz1))
        {
            f = c;
        } else
        {
            f = null;
        }
        i = null;
        a(true);
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = g.iterator(); iterator.hasNext(); ((ajg)iterator.next()).a(f)) { }
        break MISSING_BLOCK_LABEL_47;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public final void b(ajg ajg1)
    {
        this;
        JVM INSTR monitorenter ;
        g.remove(ajg1);
        this;
        JVM INSTR monitorexit ;
        return;
        ajg1;
        throw ajg1;
    }

    public final void b(RemoteControlClient remotecontrolclient)
    {
        b.a();
        ir ir1 = b;
        ir.b(remotecontrolclient);
    }

    public final void b(ir ir1, iz iz1)
    {
        ir1 = h;
        ir1 = String.valueOf(iz1);
        (new StringBuilder(String.valueOf(ir1).length() + 14)).append("Route removed ").append(ir1);
        a.c(iz1);
    }

    public final void b(iz iz1)
    {
        chq chq1 = h;
        iz1 = String.valueOf(iz1);
        chq1.a((new StringBuilder(String.valueOf(iz1).length() + 17)).append("Route unselected ").append(iz1).toString());
        a.a();
        f = null;
        a(true);
    }

    public final void onMdxScreenDisconnecting(amh amh)
    {
        amh = b;
        ir.b().c();
        f = null;
        a(false);
    }
}

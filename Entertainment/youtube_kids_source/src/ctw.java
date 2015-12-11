// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class ctw
{

    final bje a;
    Throwable b;
    volatile csg c;
    ctv d;

    public ctw(bje bje1)
    {
        a = bje1;
        c = new csg(ctr.a, ctr.a);
    }

    private void handlePlayerGeometryEvent(csg csg1)
    {
        c = csg1;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        b();
        b = null;
        d = new ctv(this);
        a.a(d);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(ctn ctn)
    {
        j();
        d.a = ctn;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (d != null)
        {
            a.b(d);
            d = null;
            b = new Throwable("currentPlaybackSequenceMonitor became null here");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        ctv ctv1 = d;
        boolean flag;
        if (ctv1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public int d()
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        j();
        k = d.d;
        this;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean e()
    {
        this;
        JVM INSTR monitorenter ;
        ctv ctv1;
        j();
        ctv1 = d;
        if (ctv1.c == ctk.d) goto _L2; else goto _L1
_L1:
        boolean flag = ctv1.a();
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean f()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        j();
        flag = d.a();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public csg g()
    {
        return c;
    }

    public String h()
    {
        j();
        return d.b;
    }

    public ctn i()
    {
        this;
        JVM INSTR monitorenter ;
        ctn ctn;
        j();
        ctn = d.a;
        this;
        JVM INSTR monitorexit ;
        return ctn;
        Exception exception;
        exception;
        throw exception;
    }

    void j()
    {
        if (!c())
        {
            throw new RuntimeException("PlaybackMonitor queried outside playback sequence", b);
        } else
        {
            return;
        }
    }
}

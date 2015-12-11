// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;

final class nj
    implements bjp
{

    private File a;
    private ass b;
    private ni c;

    nj(ni ni1)
    {
        c = ni1;
        super();
    }

    private ass b()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = (File)c.a.o().b_();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((ass) (obj));
_L2:
        if (!((File) (obj)).equals(a))
        {
            a = ((File) (obj));
            b = new ata(new File(((File) (obj)), "exo"), new asz(c.a.s().m()));
        }
        obj = b;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final Object b_()
    {
        return b();
    }
}

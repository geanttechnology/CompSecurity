// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import java.io.IOException;

public final class avb extends avi
{

    private awi c;
    private auz d;

    public avb(auz auz1, awi awi)
    {
        d = auz1;
        c = awi;
        super();
    }

    protected final void a(awb awb)
    {
        awb = ((awb) (d.a));
        awb;
        JVM INSTR monitorenter ;
        d.c.a = c;
        d.b.a(a);
        d.c.a = null;
_L1:
        awb;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        a(((awn) (b(new Status(2100)))));
        d.c.a = null;
          goto _L1
        obj;
        awb;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        d.c.a = null;
        throw obj;
    }
}

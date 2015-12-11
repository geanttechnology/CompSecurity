// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import java.io.IOException;
import org.json.JSONObject;

public final class ave extends avi
{

    private awi c;
    private long d;
    private int e;
    private JSONObject f;
    private auz g;

    public ave(auz auz1, awi awi, long l, int i, JSONObject jsonobject)
    {
        g = auz1;
        c = awi;
        d = l;
        e = i;
        f = jsonobject;
        super();
    }

    protected final void a(awb awb)
    {
        awb = ((awb) (g.a));
        awb;
        JVM INSTR monitorenter ;
        g.c.a = c;
        g.b.a(a, d, e, f);
        g.c.a = null;
_L1:
        awb;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        a(((awn) (b(new Status(2100)))));
        g.c.a = null;
          goto _L1
        obj;
        awb;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        g.c.a = null;
        throw obj;
    }
}

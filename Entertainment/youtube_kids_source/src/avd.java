// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import java.io.IOException;
import org.json.JSONObject;

public final class avd extends avi
{

    private awi c;
    private JSONObject d;
    private auz e;

    public avd(auz auz1, awi awi, JSONObject jsonobject)
    {
        e = auz1;
        c = awi;
        d = jsonobject;
        super();
    }

    protected final void a(awb awb)
    {
        awb = ((awb) (e.a));
        awb;
        JVM INSTR monitorenter ;
        e.c.a = c;
        e.b.b(a, d);
        e.c.a = null;
_L1:
        awb;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        a(((awn) (b(new Status(2100)))));
        e.c.a = null;
          goto _L1
        obj;
        awb;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        e.c.a = null;
        throw obj;
    }
}

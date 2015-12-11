// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.Map;

class avf extends avx
{

    private WeakReference a;
    private WeakReference b;

    avf(Map map, Object obj, qk qk)
    {
        super(qk);
        a = new WeakReference(map);
        b = new WeakReference(obj);
    }

    public void a(Status status)
    {
        Map map;
        Object obj;
        map = (Map)a.get();
        obj = b.get();
        if (status.b().e() || map == null || obj == null) goto _L2; else goto _L1
_L1:
        map;
        JVM INSTR monitorenter ;
        obj = (awd)map.remove(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((awd) (obj)).a();
        map;
        JVM INSTR monitorexit ;
_L2:
        a(status);
        return;
        status;
        map;
        JVM INSTR monitorexit ;
        throw status;
    }
}

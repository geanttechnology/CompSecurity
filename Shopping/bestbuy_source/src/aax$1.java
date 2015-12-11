// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.Map;

class ang.Object
    implements vd
{

    final aax a;

    public void a(gu gu, Map map)
    {
label0:
        {
            synchronized (aax.a(a))
            {
                if (!aax.b(a).isDone())
                {
                    break label0;
                }
            }
            return;
        }
        map = new aaz(1, map);
        acb.e((new StringBuilder()).append("Invalid ").append(map.e()).append(" request error: ").append(map.b()).toString());
        aax.b(a).a(map);
        gu;
        JVM INSTR monitorexit ;
        return;
        map;
        gu;
        JVM INSTR monitorexit ;
        throw map;
    }

    (aax aax1)
    {
        a = aax1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.Map;

class ang.Object
    implements vd
{

    final aax a;

    public void a(gu gu1, Map map)
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
        aaz aaz1;
        String s;
        aaz1 = new aaz(-2, map);
        s = aaz1.d();
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        acb.e("URL missing in loadAdUrl GMSG.");
        obj;
        JVM INSTR monitorexit ;
        return;
        gu1;
        obj;
        JVM INSTR monitorexit ;
        throw gu1;
        if (s.contains("%40mediation_adapters%40"))
        {
            gu1 = s.replaceAll("%40mediation_adapters%40", abm.a(gu1.getContext(), (String)map.get("check_adapters"), aax.c(a)));
            aaz1.a(gu1);
            acb.d((new StringBuilder()).append("Ad request URL modified to ").append(gu1).toString());
        }
        aax.b(a).a(aaz1);
        obj;
        JVM INSTR monitorexit ;
    }

    (aax aax1)
    {
        a = aax1;
        super();
    }
}

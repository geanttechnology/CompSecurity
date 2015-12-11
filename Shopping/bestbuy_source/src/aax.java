// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.Map;
import java.util.concurrent.Future;

public final class aax
{

    gu a;
    public final vd b = new vd() {

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
            map = new aaz(1, map);
            acb.e((new StringBuilder()).append("Invalid ").append(map.e()).append(" request error: ").append(map.b()).toString());
            aax.b(a).a(map);
            gu1;
            JVM INSTR monitorexit ;
            return;
            map;
            gu1;
            JVM INSTR monitorexit ;
            throw map;
        }

            
            {
                a = aax.this;
                super();
            }
    };
    public final vd c = new vd() {

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
            String s1;
            aaz1 = new aaz(-2, map);
            s1 = aaz1.d();
            if (s1 != null)
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
            if (s1.contains("%40mediation_adapters%40"))
            {
                gu1 = s1.replaceAll("%40mediation_adapters%40", abm.a(gu1.getContext(), (String)map.get("check_adapters"), aax.c(a)));
                aaz1.a(gu1);
                acb.d((new StringBuilder()).append("Ad request URL modified to ").append(gu1).toString());
            }
            aax.b(a).a(aaz1);
            obj;
            JVM INSTR monitorexit ;
        }

            
            {
                a = aax.this;
                super();
            }
    };
    private final Object d = new Object();
    private String e;
    private abs f;

    public aax(String s)
    {
        f = new abs();
        e = s;
    }

    static Object a(aax aax1)
    {
        return aax1.d;
    }

    static abs b(aax aax1)
    {
        return aax1.f;
    }

    static String c(aax aax1)
    {
        return aax1.e;
    }

    public Future a()
    {
        return f;
    }

    public void a(gu gu1)
    {
        ady.b("setAdWebView must be called on the main thread.");
        a = gu1;
    }

    public void b()
    {
        ady.b("destroyAdWebView must be called on the main thread.");
        if (a != null)
        {
            a.destroy();
            a = null;
        }
    }
}

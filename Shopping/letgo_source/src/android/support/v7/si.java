// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.concurrent.Future;

// Referenced classes of package android.support.v7:
//            ua, ul, ox, sk, 
//            tk

public final class si
{

    ul a;
    pm.d b;
    public final ox c = new ox() {

        final si a;

        public void zza(ul ul1, Map map)
        {
label0:
            {
                synchronized (si.a(a))
                {
                    if (!si.b(a).isDone())
                    {
                        break label0;
                    }
                }
                return;
            }
            if (si.c(a).equals(map.get("request_id")))
            {
                break MISSING_BLOCK_LABEL_55;
            }
            ul1;
            JVM INSTR monitorexit ;
            return;
            map;
            ul1;
            JVM INSTR monitorexit ;
            throw map;
            map = new sk(1, map);
            zzb.zzaE((new StringBuilder()).append("Invalid ").append(map.e()).append(" request error: ").append(map.b()).toString());
            si.b(a).b(map);
            ul1;
            JVM INSTR monitorexit ;
        }

            
            {
                a = si.this;
                super();
            }
    };
    public final ox d = new ox() {

        final si a;

        public void zza(ul ul1, Map map)
        {
label0:
            {
                synchronized (si.a(a))
                {
                    if (!si.b(a).isDone())
                    {
                        break label0;
                    }
                }
                return;
            }
            sk sk1;
            sk1 = new sk(-2, map);
            if (si.c(a).equals(sk1.g()))
            {
                break MISSING_BLOCK_LABEL_100;
            }
            zzb.zzaE((new StringBuilder()).append(sk1.g()).append(" ==== ").append(si.c(a)).toString());
            obj;
            JVM INSTR monitorexit ;
            return;
            ul1;
            obj;
            JVM INSTR monitorexit ;
            throw ul1;
            String s2 = sk1.d();
            if (s2 != null)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            zzb.zzaE("URL missing in loadAdUrl GMSG.");
            obj;
            JVM INSTR monitorexit ;
            return;
            if (s2.contains("%40mediation_adapters%40"))
            {
                ul1 = s2.replaceAll("%40mediation_adapters%40", tk.a(ul1.getContext(), (String)map.get("check_adapters"), si.d(a)));
                sk1.a(ul1);
                zzb.v((new StringBuilder()).append("Ad request URL modified to ").append(ul1).toString());
            }
            si.b(a).b(sk1);
            obj;
            JVM INSTR monitorexit ;
        }

            
            {
                a = si.this;
                super();
            }
    };
    private final Object e = new Object();
    private String f;
    private String g;
    private ua h;

    public si(String s, String s1)
    {
        h = new ua();
        g = s1;
        f = s;
    }

    static Object a(si si1)
    {
        return si1.e;
    }

    static ua b(si si1)
    {
        return si1.h;
    }

    static String c(si si1)
    {
        return si1.f;
    }

    static String d(si si1)
    {
        return si1.g;
    }

    public pm.d a()
    {
        return b;
    }

    public void a(pm.d d1)
    {
        b = d1;
    }

    public void a(ul ul1)
    {
        a = ul1;
    }

    public Future b()
    {
        return h;
    }

    public void c()
    {
        if (a != null)
        {
            a.destroy();
            a = null;
        }
    }
}

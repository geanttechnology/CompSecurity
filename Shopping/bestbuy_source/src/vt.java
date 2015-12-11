// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.internal.fh;
import java.util.Iterator;
import java.util.List;

public final class vt
{

    private final fh a;
    private final wd b;
    private final Context c;
    private final Object d = new Object();
    private final vv e;
    private boolean f;
    private vy g;

    public vt(Context context, fh fh1, wd wd, vv vv1)
    {
        f = false;
        c = context;
        a = fh1;
        b = wd;
        e = vv1;
    }

    public vz a(long l, long l1)
    {
        Iterator iterator;
        acb.a("Starting mediation.");
        iterator = e.a.iterator();
_L4:
        vu vu1;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_247;
        }
        vu1 = (vu)iterator.next();
        acb.c((new StringBuilder()).append("Trying mediation network: ").append(vu1.b).toString());
        iterator1 = vu1.c.iterator();
_L2:
        String s;
label0:
        {
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)iterator1.next();
            vz vz1;
            synchronized (d)
            {
                if (!f)
                {
                    break label0;
                }
                vz1 = new vz(-1);
            }
            return vz1;
        }
        g = new vy(c, s, b, e, vu1, a.c, a.d, a.k);
        obj;
        JVM INSTR monitorexit ;
        obj = g.a(l, l1);
        if (((vz) (obj)).a == 0)
        {
            acb.a("Adapter succeeded.");
            return ((vz) (obj));
        }
        break MISSING_BLOCK_LABEL_219;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (((vz) (obj)).c != null)
        {
            aca.a.post(new Runnable(((vz) (obj))) {

                final vz a;
                final vt b;

                public void run()
                {
                    try
                    {
                        a.c.c();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        acb.d("Could not destroy mediation adapter.", remoteexception);
                    }
                }

            
            {
                b = vt.this;
                a = vz1;
                super();
            }
            });
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        return new vz(1);
    }

    public void a()
    {
        synchronized (d)
        {
            f = true;
            if (g != null)
            {
                g.a();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

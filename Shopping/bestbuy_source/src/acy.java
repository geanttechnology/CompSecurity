// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;

public abstract class acy
    implements adg, qd
{

    public static final String d[] = {
        "service_esmobile", "service_googleme"
    };
    private final Context a;
    final Handler b;
    boolean c;
    private final Looper e;
    private final Object f = new Object();
    private IInterface g;
    private final ArrayList h = new ArrayList();
    private adc i;
    private int j;
    private final String k[];
    private final ade l;

    protected transient acy(Context context, Looper looper, qo qo1, qp qp1, String as[])
    {
        j = 1;
        c = false;
        a = (Context)ady.a(context);
        e = (Looper)ady.a(looper, "Looper must not be null");
        l = new ade(context, looper, this);
        b = new acz(this, looper);
        a(as);
        k = as;
        a((qo)ady.a(qo1));
        a((qp)ady.a(qp1));
    }

    static adc a(acy acy1, adc adc1)
    {
        acy1.i = adc1;
        return adc1;
    }

    static ade a(acy acy1)
    {
        return acy1.l;
    }

    private void a(int i1, IInterface iinterface)
    {
        boolean flag2 = true;
        boolean flag;
        boolean flag1;
        if (i1 == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (iinterface != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag != flag1)
        {
            flag2 = false;
        }
        ady.b(flag2);
        synchronized (f)
        {
            j = i1;
            g = iinterface;
        }
        return;
        iinterface;
        obj;
        JVM INSTR monitorexit ;
        throw iinterface;
    }

    static void a(acy acy1, int i1, IInterface iinterface)
    {
        acy1.a(i1, iinterface);
    }

    private boolean a(int i1, int j1, IInterface iinterface)
    {
label0:
        {
            synchronized (f)
            {
                if (j == i1)
                {
                    break label0;
                }
            }
            return false;
        }
        a(j1, iinterface);
        obj;
        JVM INSTR monitorexit ;
        return true;
        iinterface;
        obj;
        JVM INSTR monitorexit ;
        throw iinterface;
    }

    static boolean a(acy acy1, int i1, int j1, IInterface iinterface)
    {
        return acy1.a(i1, j1, iinterface);
    }

    static ArrayList b(acy acy1)
    {
        return acy1.h;
    }

    static adc c(acy acy1)
    {
        return acy1.i;
    }

    static Context d(acy acy1)
    {
        return acy1.a;
    }

    public void a()
    {
        c = true;
        a(2, ((IInterface) (null)));
        int i1 = pu.a(a);
        if (i1 != 0)
        {
            a(1, ((IInterface) (null)));
            b.sendMessage(b.obtainMessage(3, Integer.valueOf(i1)));
        } else
        {
            if (i != null)
            {
                Log.e("GmsClient", (new StringBuilder()).append("Calling connect() while still connected, missing disconnect() for ").append(d()).toString());
                adh.a(a).b(d(), i);
            }
            i = new adc(this);
            if (!adh.a(a).a(d(), i))
            {
                Log.e("GmsClient", (new StringBuilder()).append("unable to connect to service: ").append(d()).toString());
                b.sendMessage(b.obtainMessage(3, Integer.valueOf(9)));
                return;
            }
        }
    }

    public void a(int i1)
    {
        b.sendMessage(b.obtainMessage(4, Integer.valueOf(i1)));
    }

    protected void a(int i1, IBinder ibinder, Bundle bundle)
    {
        b.sendMessage(b.obtainMessage(1, new add(this, i1, ibinder, bundle)));
    }

    public final void a(ada ada1)
    {
        synchronized (h)
        {
            h.add(ada1);
        }
        b.sendMessage(b.obtainMessage(2, ada1));
        return;
        ada1;
        arraylist;
        JVM INSTR monitorexit ;
        throw ada1;
    }

    protected abstract void a(adp adp, adb adb1);

    public void a(qo qo1)
    {
        l.a(qo1);
    }

    public void a(qp qp1)
    {
        l.a(qp1);
    }

    protected transient void a(String as[])
    {
    }

    protected abstract IInterface b(IBinder ibinder);

    public void b()
    {
        c = false;
        ArrayList arraylist = h;
        arraylist;
        JVM INSTR monitorenter ;
        int j1 = h.size();
        int i1 = 0;
_L2:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        ((ada)h.get(i1)).d();
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        h.clear();
        arraylist;
        JVM INSTR monitorexit ;
        a(1, ((IInterface) (null)));
        if (i != null)
        {
            adh.a(a).b(d(), i);
            i = null;
        }
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final void c(IBinder ibinder)
    {
        try
        {
            a(adq.a(ibinder), new adb(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            Log.w("GmsClient", "service died");
            a(1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            Log.w("GmsClient", "Remote exception occurred", ibinder);
        }
    }

    public boolean c()
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (j == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bundle c_()
    {
        return null;
    }

    protected abstract String d();

    public boolean d_()
    {
        return c;
    }

    protected abstract String e();

    public boolean g()
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (j == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Context h()
    {
        return a;
    }

    protected final void i()
    {
        if (!c())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    public final IInterface j()
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        if (j == 4)
        {
            throw new DeadObjectException();
        }
        break MISSING_BLOCK_LABEL_28;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        i();
        IInterface iinterface;
        boolean flag;
        if (g != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.a(flag, "Client is connected but service is null");
        iinterface = g;
        obj;
        JVM INSTR monitorexit ;
        return iinterface;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;

public abstract class axi
    implements awb, axr
{

    public final Context a;
    public final Handler b;
    public final axp c;
    private final Looper d;
    private IInterface e;
    private final ArrayList f;
    private axn g;
    private volatile int h;
    private boolean i;

    public axi(Context context)
    {
        f = new ArrayList();
        h = 1;
        i = false;
        a = (Context)a.d(context);
        d = context.getMainLooper();
        c = new axp(d, this);
        b = new axj(this, d);
    }

    public transient axi(Context context, Looper looper, awk awk1, avt avt1, String as[])
    {
        f = new ArrayList();
        h = 1;
        i = false;
        a = (Context)a.d(context);
        d = (Looper)a.f(looper, "Looper must not be null");
        c = new axp(looper, this);
        b = new axj(this, looper);
        context = (awk)a.d(awk1);
        c.a(context);
        a((avt)a.d(avt1));
    }

    static IInterface a(axi axi1, IInterface iinterface)
    {
        axi1.e = iinterface;
        return iinterface;
    }

    static axn a(axi axi1, axn axn1)
    {
        axi1.g = null;
        return null;
    }

    static axp a(axi axi1)
    {
        return axi1.c;
    }

    private void a(int j)
    {
        int k = h;
        h = j;
    }

    static void a(axi axi1, int j)
    {
        axi1.a(j);
    }

    static ArrayList b(axi axi1)
    {
        return axi1.f;
    }

    static IInterface c(axi axi1)
    {
        return axi1.e;
    }

    static axn d(axi axi1)
    {
        return axi1.g;
    }

    static Context e(axi axi1)
    {
        return axi1.a;
    }

    public abstract IInterface a(IBinder ibinder);

    public final void a()
    {
        i = true;
        a(2);
        int j = avw.a(a);
        if (j != 0)
        {
            a(1);
            b.sendMessage(b.obtainMessage(3, Integer.valueOf(j)));
        } else
        {
            if (g != null)
            {
                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
                e = null;
                axs.a(a).b(e(), g);
            }
            g = new axn(this);
            if (!axs.a(a).a(e(), g))
            {
                Log.e("GmsClient", (new StringBuilder("unable to connect to service: ")).append(e()).toString());
                b.sendMessage(b.obtainMessage(3, Integer.valueOf(9)));
                return;
            }
        }
    }

    public void a(int j, IBinder ibinder, Bundle bundle)
    {
        b.sendMessage(b.obtainMessage(1, new axo(this, j, ibinder, bundle)));
    }

    public final void a(avt avt1)
    {
        c.a(avt1);
    }

    public abstract void a(aya aya, axm axm1);

    public void b()
    {
        i = false;
        ArrayList arraylist = f;
        arraylist;
        JVM INSTR monitorenter ;
        int k = f.size();
        int j = 0;
_L2:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ((axk)f.get(j)).c();
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        f.clear();
        arraylist;
        JVM INSTR monitorexit ;
        a(1);
        e = null;
        if (g != null)
        {
            axs.a(a).b(e(), g);
            g = null;
        }
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final void b(IBinder ibinder)
    {
        try
        {
            a(ayb.a(ibinder), new axm(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            Log.w("GmsClient", "service died");
        }
    }

    public final boolean c()
    {
        return h == 3;
    }

    public final Looper d()
    {
        return d;
    }

    public abstract String e();

    public abstract String f();

    public final boolean g()
    {
        return h == 2;
    }

    public final void h()
    {
        if (!c())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    public Bundle h_()
    {
        return null;
    }

    public final IInterface i()
    {
        h();
        return e;
    }

    public final boolean i_()
    {
        return i;
    }

}

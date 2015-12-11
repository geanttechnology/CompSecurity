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
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ig;
import com.google.android.gms.internal.il;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class azh extends axi
{

    private static final Object A = new Object();
    private static final Object B = new Object();
    private static final azv k = new azv("CastClientImpl");
    public final Map d = new HashMap();
    public azk e;
    public boolean f;
    public boolean g;
    public double h;
    public final AtomicLong i = new AtomicLong(0L);
    public Map j;
    private final CastDevice l;
    private final aun m;
    private final Handler n;
    private final long o;
    private String p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private String u;
    private String v;
    private Bundle w;
    private azj x;
    private awh y;
    private awh z;

    public azh(Context context, Looper looper, CastDevice castdevice, long l1, aun aun1, awk awk, 
            avt avt)
    {
        super(context, looper, awk, avt, null);
        l = castdevice;
        m = aun1;
        o = l1;
        n = new Handler(looper);
        j = new HashMap();
        m();
        x = new azj(this);
        a(x);
    }

    static awh a(azh azh1, awh awh1)
    {
        azh1.y = null;
        return null;
    }

    static ApplicationMetadata a(azh azh1, ApplicationMetadata applicationmetadata)
    {
        return applicationmetadata;
    }

    static String a(azh azh1, String s1)
    {
        azh1.u = s1;
        return s1;
    }

    static void a(azh azh1)
    {
        azh1.n();
    }

    static void a(azh azh1, ig ig1)
    {
        ig1 = ig1.b;
        boolean flag;
        if (!a.g(ig1, azh1.p))
        {
            azh1.p = ig1;
            flag = true;
        } else
        {
            flag = false;
        }
        k.a("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(azh1.q)
        });
        if (azh1.m != null && (flag || azh1.q))
        {
            ig1 = azh1.m;
        }
        azh1.q = false;
    }

    static void a(azh azh1, il il1)
    {
        ApplicationMetadata applicationmetadata = il1.e;
        double d1 = il1.b;
        int i1;
        boolean flag;
        boolean flag1;
        if (d1 != (0.0D / 0.0D) && d1 != azh1.h)
        {
            azh1.h = d1;
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = il1.c;
        if (flag1 != azh1.f)
        {
            azh1.f = flag1;
            flag = true;
        }
        k.a("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(azh1.r)
        });
        if (azh1.m != null && (flag || azh1.r))
        {
            azh1.m.a();
        }
        i1 = il1.d;
        if (i1 != azh1.s)
        {
            azh1.s = i1;
            flag = true;
        } else
        {
            flag = false;
        }
        k.a("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(azh1.r)
        });
        if (azh1.m != null && (flag || azh1.r))
        {
            aun aun1 = azh1.m;
            i1 = azh1.s;
        }
        i1 = il1.f;
        if (i1 != azh1.t)
        {
            azh1.t = i1;
            flag = true;
        } else
        {
            flag = false;
        }
        k.a("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(azh1.r)
        });
        if (azh1.m != null && (flag || azh1.r))
        {
            il1 = azh1.m;
            int j1 = azh1.t;
        }
        azh1.r = false;
    }

    static awh b(azh azh1, awh awh1)
    {
        azh1.z = null;
        return null;
    }

    static String b(azh azh1, String s1)
    {
        azh1.v = s1;
        return s1;
    }

    static void b(azh azh1)
    {
        azh1.m();
    }

    static awh c(azh azh1)
    {
        return azh1.y;
    }

    static aun d(azh azh1)
    {
        return azh1.m;
    }

    static Handler e(azh azh1)
    {
        return azh1.n;
    }

    static Map f(azh azh1)
    {
        return azh1.d;
    }

    static CastDevice g(azh azh1)
    {
        return azh1.l;
    }

    static Map h(azh azh1)
    {
        return azh1.j;
    }

    static awh i(azh azh1)
    {
        return azh1.z;
    }

    static azv j()
    {
        return k;
    }

    static Object k()
    {
        return A;
    }

    static Object l()
    {
        return B;
    }

    private void m()
    {
        g = false;
        s = -1;
        t = -1;
        p = null;
        h = 0.0D;
        f = false;
    }

    private void n()
    {
        k.a("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (d)
        {
            d.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final IInterface a(IBinder ibinder)
    {
        return azr.a(ibinder);
    }

    protected final void a(int i1, IBinder ibinder, Bundle bundle)
    {
        k.a("in onPostInitHandler; statusCode=%d", new Object[] {
            Integer.valueOf(i1)
        });
        int j1;
        if (i1 == 0 || i1 == 1001)
        {
            g = true;
            q = true;
            r = true;
        } else
        {
            g = false;
        }
        j1 = i1;
        if (i1 == 1001)
        {
            w = new Bundle();
            w.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            j1 = 0;
        }
        super.a(j1, ibinder, bundle);
    }

    public void a(awh awh1)
    {
        synchronized (A)
        {
            if (y != null)
            {
                y.a(new azi(new Status(2002)));
            }
            y = awh1;
        }
        return;
        awh1;
        obj;
        JVM INSTR monitorexit ;
        throw awh1;
    }

    protected final void a(aya aya1, axm axm)
    {
        Bundle bundle = new Bundle();
        k.a("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] {
            u, v
        });
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", l);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", o);
        if (u != null)
        {
            bundle.putString("last_application_id", u);
            if (v != null)
            {
                bundle.putString("last_session_id", v);
            }
        }
        e = new azk(this);
        aya1.a(axm, 0x5e3530, super.a.getPackageName(), e.asBinder(), bundle);
    }

    public final void a(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        auo auo1;
        synchronized (d)
        {
            auo1 = (auo)d.remove(s1);
        }
        if (auo1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((azq)i()).c(s1);
        return;
        s1;
        map;
        JVM INSTR monitorexit ;
        throw s1;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        k.a(illegalstateexception, "Error unregistering namespace (%s): %s", new Object[] {
            s1, illegalstateexception.getMessage()
        });
        return;
    }

    public final void a(String s1, awh awh1)
    {
        Object obj = B;
        obj;
        JVM INSTR monitorenter ;
        if (z == null) goto _L2; else goto _L1
_L1:
        awh1.a(new Status(2001));
_L4:
        ((azq)i()).a(s1);
        return;
_L2:
        z = awh1;
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final void b()
    {
        k.a("disconnect(); ServiceListener=%s, isConnected=%b", new Object[] {
            e, Boolean.valueOf(c())
        });
        azk azk1 = e;
        e = null;
        if (azk1 == null || !azk1.a())
        {
            k.a("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        n();
        if (c() || g())
        {
            ((azq)i()).a();
        }
        super.b();
        return;
        Object obj;
        obj;
        k.a(((Throwable) (obj)), "Error while disconnecting the controller interface: %s", new Object[] {
            ((RemoteException) (obj)).getMessage()
        });
        super.b();
        return;
        obj;
        super.b();
        throw obj;
    }

    protected final String e()
    {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected final String f()
    {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public final Bundle h_()
    {
        if (w != null)
        {
            Bundle bundle = w;
            w = null;
            return bundle;
        } else
        {
            return super.h_();
        }
    }

}

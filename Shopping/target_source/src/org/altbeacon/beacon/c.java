// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.altbeacon.beacon.d.a;
import org.altbeacon.beacon.service.BeaconService;
import org.altbeacon.beacon.service.StartRMData;
import org.altbeacon.beacon.service.h;

// Referenced classes of package org.altbeacon.beacon:
//            a, b, Region, g, 
//            f

public class c
{

    protected static c a = null;
    protected static a e;
    protected static String f = "http://data.altbeacon.org/android-distance.json";
    protected static Class g = org/altbeacon/beacon/service/h;
    private static boolean p = false;
    private static boolean q = false;
    protected g b;
    protected g c;
    protected f d;
    private Context h;
    private final ConcurrentMap i = new ConcurrentHashMap();
    private Messenger j;
    private final ArrayList k = new ArrayList();
    private final ArrayList l = new ArrayList();
    private final ArrayList m = new ArrayList();
    private boolean n;
    private boolean o;
    private long r;
    private long s;
    private long t;
    private long u;
    private ServiceConnection v;

    protected c(Context context)
    {
        j = null;
        b = null;
        c = null;
        d = null;
        n = false;
        o = true;
        r = 1100L;
        s = 0L;
        t = 10000L;
        u = 0x493e0L;
        v = new _cls1();
        h = context;
        if (!q)
        {
            m();
        }
        m.add(new org.altbeacon.beacon.a());
    }

    static Messenger a(c c1, Messenger messenger)
    {
        c1.j = messenger;
        return messenger;
    }

    static ConcurrentMap a(c c1)
    {
        return c1.i;
    }

    public static c a(Context context)
    {
        if (a == null)
        {
            org.altbeacon.beacon.c.c.a("BeaconManager", "BeaconManager instance creation", new Object[0]);
            a = new c(context);
        }
        return a;
    }

    public static String e()
    {
        return f;
    }

    public static Class f()
    {
        return g;
    }

    public static a g()
    {
        return e;
    }

    public static boolean i()
    {
        return p;
    }

    private String j()
    {
        String s1 = h.getPackageName();
        org.altbeacon.beacon.c.c.a("BeaconManager", "callback packageName: %s", new Object[] {
            s1
        });
        return s1;
    }

    private long k()
    {
        if (n)
        {
            return t;
        } else
        {
            return r;
        }
    }

    private long l()
    {
        if (n)
        {
            return u;
        } else
        {
            return s;
        }
    }

    private void m()
    {
    /* block-local class not found */
    class b {}

        if (h.getPackageManager().queryIntentServices(new Intent(h, org/altbeacon/beacon/service/BeaconService), 0x10000).size() == 0)
        {
            throw new b();
        } else
        {
            return;
        }
    }

    public List a()
    {
        if (b())
        {
            return Collections.unmodifiableList(m);
        } else
        {
            return m;
        }
    }

    public void a(Region region)
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            org.altbeacon.beacon.c.c.c("BeaconManager", "Not supported prior to API 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        if (j == null)
        {
            throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 2, 0, 0);
        message.obj = new StartRMData(region, j(), k(), l(), n);
        j.send(message);
        synchronized (l)
        {
            l.add(region);
        }
        return;
        region;
        arraylist;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void a(b b1)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            org.altbeacon.beacon.c.c.c("BeaconManager", "Not supported prior to API 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        ConcurrentMap concurrentmap = i;
        concurrentmap;
        JVM INSTR monitorenter ;
    /* block-local class not found */
    class a {}

        if ((a)i.putIfAbsent(b1, new a(null)) == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        org.altbeacon.beacon.c.c.a("BeaconManager", "This consumer is already bound", new Object[0]);
_L1:
        return;
        b1;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw b1;
        org.altbeacon.beacon.c.c.a("BeaconManager", "This consumer is not bound.  binding: %s", new Object[] {
            b1
        });
        b1.bindService(new Intent(b1.getApplicationContext(), org/altbeacon/beacon/service/BeaconService), v, 1);
        org.altbeacon.beacon.c.c.a("BeaconManager", "consumer count is now: %s", new Object[] {
            Integer.valueOf(i.size())
        });
          goto _L1
    }

    public void a(g g1)
    {
        b = g1;
    }

    public void b(Region region)
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            org.altbeacon.beacon.c.c.c("BeaconManager", "Not supported prior to API 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        if (j == null)
        {
            throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 3, 0, 0);
        message.obj = new StartRMData(region, j(), k(), l(), n);
        j.send(message);
        ArrayList arraylist = l;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = l.iterator();
        Region region1 = null;
_L2:
        Region region2;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        region2 = (Region)iterator.next();
        if (region.a().equals(region2.a()))
        {
            region1 = region2;
        }
        if (true) goto _L2; else goto _L1
_L1:
        l.remove(region1);
        arraylist;
        JVM INSTR monitorexit ;
        return;
        region;
        arraylist;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void b(b b1)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            org.altbeacon.beacon.c.c.c("BeaconManager", "Not supported prior to API 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        ConcurrentMap concurrentmap = i;
        concurrentmap;
        JVM INSTR monitorenter ;
        if (!i.containsKey(b1))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        org.altbeacon.beacon.c.c.a("BeaconManager", "Unbinding", new Object[0]);
        b1.unbindService(v);
        i.remove(b1);
        if (i.size() == 0)
        {
            j = null;
            n = false;
        }
_L1:
        return;
        b1;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw b1;
        org.altbeacon.beacon.c.c.a("BeaconManager", "This consumer is not bound to: %s", new Object[] {
            b1
        });
        org.altbeacon.beacon.c.c.a("BeaconManager", "Bound consumers: ", new Object[0]);
        b1 = i.entrySet().iterator();
        while (b1.hasNext()) 
        {
            org.altbeacon.beacon.c.c.a("BeaconManager", String.valueOf(((java.util.Map.Entry)b1.next()).getValue()), new Object[0]);
        }
          goto _L1
    }

    public boolean b()
    {
        ConcurrentMap concurrentmap = i;
        concurrentmap;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (i.size() > 0 && j != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        concurrentmap;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public f c()
    {
        return d;
    }

    public g d()
    {
        return b;
    }

    protected g h()
    {
        return c;
    }


    /* member class not found */
    class _cls1 {}

}

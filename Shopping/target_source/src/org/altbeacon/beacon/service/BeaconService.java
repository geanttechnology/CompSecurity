// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.b.e;
import org.altbeacon.beacon.c.c;
import org.altbeacon.beacon.d;
import org.altbeacon.beacon.service.a.a;
import org.altbeacon.beacon.service.a.b;

// Referenced classes of package org.altbeacon.beacon.service:
//            c, e, RangingData, a, 
//            i, d, MonitoringData, StartRMData, 
//            b

public class BeaconService extends Service
{
    static class a extends Handler
    {

        private final WeakReference a;

        public void handleMessage(Message message)
        {
            BeaconService beaconservice;
            StartRMData startrmdata;
label0:
            {
label1:
                {
label2:
                    {
label3:
                        {
label4:
                            {
                                beaconservice = (BeaconService)a.get();
                                startrmdata = (StartRMData)message.obj;
                                if (beaconservice != null)
                                {
                                    switch (message.what)
                                    {
                                    default:
                                        super.handleMessage(message);
                                        break;

                                    case 2: // '\002'
                                        break label4;

                                    case 3: // '\003'
                                        break label3;

                                    case 4: // '\004'
                                        break label2;

                                    case 5: // '\005'
                                        break label1;

                                    case 6: // '\006'
                                        break label0;
                                    }
                                }
                                return;
                            }
                            org.altbeacon.beacon.c.c.b("BeaconService", "start ranging received", new Object[0]);
                            beaconservice.a(startrmdata.c(), new org.altbeacon.beacon.service.a(startrmdata.d()));
                            beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
                            return;
                        }
                        org.altbeacon.beacon.c.c.b("BeaconService", "stop ranging received", new Object[0]);
                        beaconservice.a(startrmdata.c());
                        beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
                        return;
                    }
                    org.altbeacon.beacon.c.c.b("BeaconService", "start monitoring received", new Object[0]);
                    beaconservice.b(startrmdata.c(), new org.altbeacon.beacon.service.a(startrmdata.d()));
                    beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
                    return;
                }
                org.altbeacon.beacon.c.c.b("BeaconService", "stop monitoring received", new Object[0]);
                beaconservice.b(startrmdata.c());
                beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
                return;
            }
            org.altbeacon.beacon.c.c.b("BeaconService", "set scan intervals received", new Object[0]);
            beaconservice.a(startrmdata.a(), startrmdata.b(), startrmdata.e());
        }

        a(BeaconService beaconservice)
        {
            a = new WeakReference(beaconservice);
        }
    }

    private class b
    {

        int a;
        BluetoothDevice b;
        byte c[];
        final BeaconService d;

        public b(BluetoothDevice bluetoothdevice, int i1, byte abyte0[])
        {
            d = BeaconService.this;
            super();
            b = bluetoothdevice;
            a = i1;
            c = abyte0;
        }
    }

    private class c extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        org.altbeacon.beacon.service.b a;
        final BeaconService b;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient Void a(b ab[])
        {
            b b1 = ab[0];
            Iterator iterator = org.altbeacon.beacon.service.BeaconService.e(b).iterator();
            ab = null;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Beacon beacon = ((d)iterator.next()).a(b1.c, b1.a, b1.b);
                ab = beacon;
                if (beacon == null)
                {
                    continue;
                }
                ab = beacon;
                break;
            } while (true);
            if (ab != null)
            {
                a.c();
                org.altbeacon.beacon.service.BeaconService.a(b, ab);
            }
            return null;
        }

        protected void a(Void void1)
        {
        }

        protected transient void a(Void avoid[])
        {
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "BeaconService$c#doInBackground", null);
_L1:
            aobj = a((b[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "BeaconService$c#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "BeaconService$c#onPostExecute", null);
_L1:
            a((Void)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "BeaconService$c#onPostExecute", null);
              goto _L1
        }

        protected void onPreExecute()
        {
        }

        protected void onProgressUpdate(Object aobj[])
        {
            a((Void[])aobj);
        }

        private c()
        {
            b = BeaconService.this;
            super();
            a = org.altbeacon.beacon.service.b.a();
        }

    }


    int a;
    final Messenger b = new Messenger(new a(this));
    protected org.altbeacon.beacon.service.a.a c;
    private Map d;
    private Map e;
    private Handler f;
    private int g;
    private org.altbeacon.a.b h;
    private org.altbeacon.beacon.b.c i;
    private List j;
    private org.altbeacon.beacon.service.a.b k;
    private boolean l;
    private org.altbeacon.beacon.service.c m;
    private ExecutorService n;
    private List o;

    public BeaconService()
    {
        d = new HashMap();
        e = new HashMap();
        f = new Handler();
        g = 0;
        i = null;
        l = false;
        m = new org.altbeacon.beacon.service.c();
        o = null;
        c = new org.altbeacon.beacon.service.a.a() {

            final BeaconService a;

            public void a()
            {
label0:
                {
                    org.altbeacon.beacon.service.BeaconService.b(a);
                    org.altbeacon.beacon.service.BeaconService.c(a);
                    if (org.altbeacon.beacon.service.BeaconService.d(a) != null)
                    {
                        org.altbeacon.beacon.c.c.c("BeaconService", "Simulated scan data is deprecated and will be removed in a future release. Please use the new BeaconSimulator interface instead.", new Object[0]);
                        ApplicationInfo applicationinfo = a.getApplicationInfo();
                        int i1 = applicationinfo.flags & 2;
                        applicationinfo.flags = i1;
                        if (i1 != 0)
                        {
                            Beacon beacon;
                            for (Iterator iterator = org.altbeacon.beacon.service.BeaconService.d(a).iterator(); iterator.hasNext(); org.altbeacon.beacon.service.BeaconService.a(a, beacon))
                            {
                                beacon = (Beacon)iterator.next();
                            }

                        } else
                        {
                            org.altbeacon.beacon.c.c.c("BeaconService", "Simulated scan data provided, but ignored because we are not running in debug mode.  Please remove simulated scan data for production.", new Object[0]);
                        }
                    }
                    if (org.altbeacon.beacon.c.g() != null)
                    {
                        if (org.altbeacon.beacon.c.g().a() == null)
                        {
                            break label0;
                        }
                        ApplicationInfo applicationinfo1 = a.getApplicationInfo();
                        int j1 = applicationinfo1.flags & 2;
                        applicationinfo1.flags = j1;
                        if (j1 != 0)
                        {
                            Beacon beacon1;
                            for (Iterator iterator1 = org.altbeacon.beacon.c.g().a().iterator(); iterator1.hasNext(); org.altbeacon.beacon.service.BeaconService.a(a, beacon1))
                            {
                                beacon1 = (Beacon)iterator1.next();
                            }

                        } else
                        {
                            org.altbeacon.beacon.c.c.c("BeaconService", "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.", new Object[0]);
                        }
                    }
                    return;
                }
                org.altbeacon.beacon.c.c.c("BeaconService", "getBeacons is returning null. No simulated beacons to report.", new Object[0]);
            }

            public void a(BluetoothDevice bluetoothdevice, int i1, byte abyte0[])
            {
                c c1;
                ExecutorService executorservice;
                b ab[];
                c1 = a. new c();
                executorservice = org.altbeacon.beacon.service.BeaconService.a(a);
                ab = new b[1];
                ab[0] = a. new b(bluetoothdevice, i1, abyte0);
                if (!(c1 instanceof AsyncTask))
                {
                    c1.executeOnExecutor(executorservice, ab);
                    return;
                }
                try
                {
                    AsyncTaskInstrumentation.executeOnExecutor((AsyncTask)c1, executorservice, ab);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (BluetoothDevice bluetoothdevice)
                {
                    org.altbeacon.beacon.c.c.c("BeaconService", "Ignoring scan result because we cannot keep up.", new Object[0]);
                }
                return;
            }

            
            {
                a = BeaconService.this;
                super();
            }
        };
    }

    private List a(Beacon beacon, Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Region region = (Region)collection.next();
            if (region != null)
            {
                if (region.a(beacon))
                {
                    arraylist.add(region);
                } else
                {
                    org.altbeacon.beacon.c.c.a("BeaconService", "This region (%s) does not match beacon: %s", new Object[] {
                        region, beacon
                    });
                }
            }
        } while (true);
        return arraylist;
    }

    static ExecutorService a(BeaconService beaconservice)
    {
        return beaconservice.n;
    }

    private void a()
    {
        Map map = d;
        map;
        JVM INSTR monitorenter ;
        Region region;
        org.altbeacon.beacon.service.e e1;
        for (Iterator iterator = d.keySet().iterator(); iterator.hasNext(); e1.a().a(this, "rangingData", new RangingData(e1.b(), region)))
        {
            region = (Region)iterator.next();
            e1 = (org.altbeacon.beacon.service.e)d.get(region);
            org.altbeacon.beacon.c.c.a("BeaconService", "Calling ranging callback", new Object[0]);
        }

        break MISSING_BLOCK_LABEL_100;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        map;
        JVM INSTR monitorexit ;
    }

    private void a(Beacon beacon)
    {
        if (org.altbeacon.beacon.service.i.a().b())
        {
            org.altbeacon.beacon.service.i.a().a(beacon);
        }
        a = a + 1;
        if (org.altbeacon.beacon.c.c.a())
        {
            org.altbeacon.beacon.c.c.a("BeaconService", "beacon detected : %s", new Object[] {
                beacon.toString()
            });
        }
        beacon = m.a(beacon);
        if (beacon == null)
        {
            if (org.altbeacon.beacon.c.c.a())
            {
                org.altbeacon.beacon.c.c.a("BeaconService", "not processing detections for GATT extra data beacon", new Object[0]);
            }
            return;
        }
        List list;
        synchronized (e)
        {
            list = a(beacon, ((Collection) (e.keySet())));
        }
        obj = list.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Region region = (Region)((Iterator) (obj)).next();
            org.altbeacon.beacon.service.d d1 = (org.altbeacon.beacon.service.d)e.get(region);
            if (d1 != null && d1.b())
            {
                d1.a().a(this, "monitoringData", new MonitoringData(d1.d(), region));
            }
        } while (true);
        break MISSING_BLOCK_LABEL_192;
        beacon;
        obj;
        JVM INSTR monitorexit ;
        throw beacon;
        org.altbeacon.beacon.c.c.a("BeaconService", "looking for ranging region matches for this beacon", new Object[0]);
        Map map = d;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = a(beacon, ((Collection) (d.keySet()))).iterator();
_L2:
        Object obj1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_301;
            }
            obj1 = (Region)iterator.next();
            org.altbeacon.beacon.c.c.a("BeaconService", "matches ranging region: %s", new Object[] {
                obj1
            });
            obj1 = (org.altbeacon.beacon.service.e)d.get(obj1);
        } while (obj1 == null);
        ((org.altbeacon.beacon.service.e) (obj1)).a(beacon);
        if (true) goto _L2; else goto _L1
_L1:
        beacon;
        map;
        JVM INSTR monitorexit ;
        throw beacon;
        map;
        JVM INSTR monitorexit ;
    }

    static void a(BeaconService beaconservice, Beacon beacon)
    {
        beaconservice.a(beacon);
    }

    private void b()
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = e.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Region region = (Region)iterator.next();
            org.altbeacon.beacon.service.d d1 = (org.altbeacon.beacon.service.d)e.get(region);
            if (d1.c())
            {
                org.altbeacon.beacon.c.c.a("BeaconService", "found a monitor that expired: %s", new Object[] {
                    region
                });
                d1.a().a(this, "monitoringData", new MonitoringData(d1.d(), region));
            }
        } while (true);
        break MISSING_BLOCK_LABEL_112;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        map;
        JVM INSTR monitorexit ;
    }

    static void b(BeaconService beaconservice)
    {
        beaconservice.b();
    }

    static void c(BeaconService beaconservice)
    {
        beaconservice.a();
    }

    static List d(BeaconService beaconservice)
    {
        return beaconservice.o;
    }

    static List e(BeaconService beaconservice)
    {
        return beaconservice.j;
    }

    public void a(long l1, long l2, boolean flag)
    {
        k.a(l1, l2, flag);
    }

    public void a(Region region)
    {
        int i1;
        synchronized (d)
        {
            d.remove(region);
            i1 = d.size();
            org.altbeacon.beacon.c.c.a("BeaconService", "Currently ranging %s regions.", new Object[] {
                Integer.valueOf(d.size())
            });
        }
        if (i1 == 0 && e.size() == 0)
        {
            k.b();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void a(Region region, org.altbeacon.beacon.service.a a1)
    {
        synchronized (d)
        {
            if (d.containsKey(region))
            {
                org.altbeacon.beacon.c.c.b("BeaconService", "Already ranging that region -- will replace existing region.", new Object[0]);
                d.remove(region);
            }
            d.put(region, new org.altbeacon.beacon.service.e(a1));
            org.altbeacon.beacon.c.c.a("BeaconService", "Currently ranging %s regions.", new Object[] {
                Integer.valueOf(d.size())
            });
        }
        k.a();
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void b(Region region)
    {
        org.altbeacon.beacon.c.c.a("BeaconService", "stopMonitoring called", new Object[0]);
        int i1;
        synchronized (e)
        {
            e.remove(region);
            i1 = e.size();
        }
        org.altbeacon.beacon.c.c.a("BeaconService", "Currently monitoring %s regions.", new Object[] {
            Integer.valueOf(e.size())
        });
        if (i1 == 0 && d.size() == 0)
        {
            k.b();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void b(Region region, org.altbeacon.beacon.service.a a1)
    {
        org.altbeacon.beacon.c.c.a("BeaconService", "startMonitoring called", new Object[0]);
        synchronized (e)
        {
            if (e.containsKey(region))
            {
                org.altbeacon.beacon.c.c.b("BeaconService", "Already monitoring that region -- will replace existing region monitor.", new Object[0]);
                e.remove(region);
            }
            e.put(region, new org.altbeacon.beacon.service.d(a1));
        }
        org.altbeacon.beacon.c.c.a("BeaconService", "Currently monitoring %s regions.", new Object[] {
            Integer.valueOf(e.size())
        });
        k.a();
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public IBinder onBind(Intent intent)
    {
        org.altbeacon.beacon.c.c.b("BeaconService", "binding", new Object[0]);
        g = g + 1;
        return b.getBinder();
    }

    public void onCreate()
    {
        org.altbeacon.beacon.c.c.b("BeaconService", "beaconService version %s is starting up", new Object[] {
            "2.3.2"
        });
        h = new org.altbeacon.a.b(this);
        h.a();
        n = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        k = org.altbeacon.beacon.service.a.b.a(this, 1100L, 0L, l, c, h);
        j = org.altbeacon.beacon.c.a(getApplicationContext()).a();
        i = new e(this, org.altbeacon.beacon.c.e());
        Beacon.a(i);
        try
        {
            o = (List)Class.forName("org.altbeacon.beacon.SimulatedScanData").getField("beacons").get(null);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            org.altbeacon.beacon.c.c.a("BeaconService", "No org.altbeacon.beacon.SimulatedScanData class exists.", new Object[0]);
            return;
        }
        catch (Exception exception)
        {
            org.altbeacon.beacon.c.c.b(exception, "BeaconService", "Cannot get simulated Scan data.  Make sure your org.altbeacon.beacon.SimulatedScanData class defines a field with the signature 'public static List<Beacon> beacons'", new Object[0]);
        }
    }

    public void onDestroy()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            org.altbeacon.beacon.c.c.c("BeaconService", "Not supported prior to API 18.", new Object[0]);
            return;
        } else
        {
            h.b();
            org.altbeacon.beacon.c.c.b("BeaconService", "onDestroy called.  stopping scanning", new Object[0]);
            f.removeCallbacksAndMessages(null);
            k.b();
            return;
        }
    }

    public boolean onUnbind(Intent intent)
    {
        org.altbeacon.beacon.c.c.b("BeaconService", "unbinding", new Object[0]);
        g = g - 1;
        return false;
    }
}

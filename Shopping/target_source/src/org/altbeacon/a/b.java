// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.altbeacon.beacon.c.c;

public class b
{

    private boolean a;
    private boolean b;
    private long c;
    private long d;
    private long e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private Context j;
    private a k;
    private final Set l = new HashSet();
    private final BroadcastReceiver m = new _cls1();

    public b(Context context)
    {
        a = false;
        b = false;
        c = 0L;
        d = 0L;
        e = 0L;
        f = 0;
        g = 0;
        h = false;
        i = 0L;
        j = null;
        j = context.getApplicationContext();
        org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "constructed", new Object[0]);
        j();
    }

    static long a(b b1, long l1)
    {
        b1.c = l1;
        return l1;
    }

    static boolean a(b b1)
    {
        return b1.a;
    }

    static boolean a(b b1, boolean flag)
    {
        b1.b = flag;
        return flag;
    }

    static long b(b b1, long l1)
    {
        b1.d = l1;
        return l1;
    }

    static void b(b b1)
    {
        b1.h();
    }

    static long c(b b1)
    {
        return b1.d;
    }

    static long d(b b1)
    {
        return b1.c;
    }

    private int e()
    {
        return 1590;
    }

    private void f()
    {
    /* block-local class not found */
    class a {}

        if (k != null)
        {
            k.a();
        }
        if (System.currentTimeMillis() - i > 60000L)
        {
            i();
        }
    }

    private void g()
    {
        g = g + 1;
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "about to check if discovery is active", new Object[0]);
        if (!bluetoothadapter.isDiscovering())
        {
            org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Recovery attempt started", new Object[0]);
            a = true;
            b = false;
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "about to command discovery", new Object[0]);
            if (!bluetoothadapter.startDiscovery())
            {
                org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Can't start discovery.  Is Bluetooth turned on?", new Object[0]);
            }
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "startDiscovery commanded.  isDiscovering()=%s", new Object[] {
                Boolean.valueOf(bluetoothadapter.isDiscovering())
            });
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "We will be cancelling this discovery in %s milliseconds.", new Object[] {
                Integer.valueOf(5000)
            });
            k();
            return;
        } else
        {
            org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Already discovering.  Recovery attempt abandoned.", new Object[0]);
            return;
        }
    }

    private void h()
    {
        org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Recovery attempt finished", new Object[0]);
        synchronized (l)
        {
            l.clear();
        }
        a = false;
        return;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void i()
    {
        Object obj;
        obj = null;
        i = (new Date()).getTime();
        Object obj1 = new OutputStreamWriter(j.openFileOutput("BluetoothCrashResolverState.txt", 0));
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(e).append("\n").toString());
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(f).append("\n").toString());
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(g).append("\n").toString());
        Exception exception;
        if (h)
        {
            obj = "1\n";
        } else
        {
            obj = "0\n";
        }
        ((OutputStreamWriter) (obj1)).write(((String) (obj)));
        obj = l;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = l.iterator(); iterator.hasNext(); ((OutputStreamWriter) (obj1)).write("\n"))
        {
            ((OutputStreamWriter) (obj1)).write((String)iterator.next());
        }

          goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = obj1;
        }
        finally { }
_L5:
        org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Can't write macs to %s", new Object[] {
            "BluetoothCrashResolverState.txt"
        });
        if (obj != null)
        {
            try
            {
                ((OutputStreamWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "Wrote %s Bluetooth addresses", new Object[] {
            Integer.valueOf(l.size())
        });
        return;
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            try
            {
                ((OutputStreamWriter) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj;
        obj1 = null;
_L3:
        if (obj1 != null)
        {
            try
            {
                ((OutputStreamWriter) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        throw obj;
        exception;
        obj1 = obj;
        obj = exception;
        if (true) goto _L3; else goto _L2
_L2:
        IOException ioexception;
        ioexception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void j()
    {
        Object obj = null;
        Object obj2 = new BufferedReader(new InputStreamReader(j.openFileInput("BluetoothCrashResolverState.txt")));
        obj = obj2;
        String s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj = obj2;
        e = Long.parseLong(s);
        obj = obj2;
        s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        obj = obj2;
        f = Integer.parseInt(s);
        obj = obj2;
        s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = obj2;
        g = Integer.parseInt(s);
        obj = obj2;
        s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        obj = obj2;
        h = false;
        obj = obj2;
        if (!s.equals("1"))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        obj = obj2;
        h = true;
_L2:
        obj = obj2;
        s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj2;
        l.add(s);
        if (true) goto _L2; else goto _L1
        obj;
_L8:
        obj = obj2;
        org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Can't read macs from %s", new Object[] {
            "BluetoothCrashResolverState.txt"
        });
        Exception exception;
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "Read %s Bluetooth addresses", new Object[] {
            Integer.valueOf(l.size())
        });
        return;
_L1:
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        break MISSING_BLOCK_LABEL_181;
        obj;
        obj2 = null;
_L6:
        obj = obj2;
        org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Can't parse file %s", new Object[] {
            "BluetoothCrashResolverState.txt"
        });
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        break MISSING_BLOCK_LABEL_181;
        exception;
        obj2 = obj;
        obj = exception;
_L4:
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2) { }
        }
        throw obj;
        exception;
        obj2 = obj;
        obj = exception;
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        obj2 = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void k()
    {
        Thread.sleep(5000L);
        if (!b)
        {
            org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.", new Object[0]);
        }
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothadapter.isDiscovering())
        {
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "Cancelling discovery", new Object[0]);
            bluetoothadapter.cancelDiscovery();
            return;
        }
        try
        {
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "Discovery not running.  Won't cancel it", new Object[0]);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "DiscoveryCanceller sleep interrupted.", new Object[0]);
        }
        return;
    }

    public void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentfilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        j.registerReceiver(m, intentfilter);
        org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "started listening for BluetoothAdapter events", new Object[0]);
    }

    public void a(BluetoothDevice bluetoothdevice, android.bluetooth.BluetoothAdapter.LeScanCallback lescancallback)
    {
        int i1 = l.size();
        synchronized (l)
        {
            l.add(bluetoothdevice.getAddress());
        }
        int j1 = l.size();
        if (i1 != j1 && j1 % 100 == 0)
        {
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "Distinct Bluetooth devices seen: %s", new Object[] {
                Integer.valueOf(l.size())
            });
        }
        if (l.size() > e() && !a)
        {
            org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Large number of Bluetooth devices detected: %s Proactively attempting to clear out address list to prevent a crash", new Object[] {
                Integer.valueOf(l.size())
            });
            org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "Stopping LE Scan", new Object[0]);
            BluetoothAdapter.getDefaultAdapter().stopLeScan(lescancallback);
            g();
            f();
        }
        return;
        bluetoothdevice;
        set;
        JVM INSTR monitorexit ;
        throw bluetoothdevice;
    }

    public void b()
    {
        j.unregisterReceiver(m);
        org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "stopped listening for BluetoothAdapter events", new Object[0]);
        i();
    }

    public void c()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "Ignoring crashes before API 18, because BLE is unsupported.", new Object[0]);
            return;
        }
        org.altbeacon.beacon.c.c.c("BluetoothCrashResolver", "BluetoothService crash detected", new Object[0]);
        if (l.size() > 0)
        {
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "Distinct Bluetooth devices seen at crash: %s", new Object[] {
                Integer.valueOf(l.size())
            });
        }
        e = (new Date()).getTime();
        f = f + 1;
        if (a)
        {
            org.altbeacon.beacon.c.c.a("BluetoothCrashResolver", "Ignoring Bluetooth crash because recovery is already in progress.", new Object[0]);
        } else
        {
            g();
        }
        f();
    }

    public boolean d()
    {
        return a;
    }

    /* member class not found */
    class _cls1 {}

}

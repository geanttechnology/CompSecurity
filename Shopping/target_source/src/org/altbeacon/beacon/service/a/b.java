// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import java.util.Date;
import org.altbeacon.beacon.c.c;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;

// Referenced classes of package org.altbeacon.beacon.service.a:
//            d, c, a

public abstract class b
{

    protected long a;
    protected boolean b;
    protected final Context c;
    protected long d;
    protected final Handler e = new Handler();
    protected final org.altbeacon.a.b f;
    protected final a g;
    protected boolean h;
    protected boolean i;
    private BluetoothAdapter j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private boolean o;
    private boolean p;
    private long q;
    private PendingIntent r;

    protected b(Context context, long l1, long l2, boolean flag, a a1, 
            org.altbeacon.a.b b1)
    {
        k = 0L;
        l = 0L;
        a = 0L;
        m = 0L;
        o = false;
        p = false;
        h = false;
        i = false;
        r = null;
        q = l1;
        d = l2;
        c = context;
        g = a1;
        f = b1;
        h = flag;
    }

    public static b a(Context context, long l1, long l2, boolean flag, a a1, org.altbeacon.a.b b1)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            org.altbeacon.beacon.c.c.c("CycledLeScanner", "Not supported prior to API 18.", new Object[0]);
            return null;
        }
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            org.altbeacon.beacon.c.c.b("CycledLeScanner", "This is not Android 5.0.  We are using old scanning APIs", new Object[0]);
            flag1 = false;
        } else
        if (org.altbeacon.beacon.c.i())
        {
            org.altbeacon.beacon.c.c.b("CycledLeScanner", "This Android 5.0, but L scanning is disabled. We are using old scanning APIs", new Object[0]);
            flag1 = false;
        } else
        {
            org.altbeacon.beacon.c.c.b("CycledLeScanner", "This Android 5.0.  We are using new scanning APIs", new Object[0]);
            flag1 = true;
        }
        if (flag1)
        {
            return new d(context, l1, l2, flag, a1, b1);
        } else
        {
            return new org.altbeacon.beacon.service.a.c(context, l1, l2, flag, a1, b1);
        }
    }

    private void l()
    {
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "Done with scan cycle", new Object[0]);
        g.a();
        if (n)
        {
            if (h() != null)
            {
                if (h().isEnabled())
                {
                    try
                    {
                        org.altbeacon.beacon.c.c.a("CycledLeScanner", "stopping bluetooth le scan", new Object[0]);
                        g();
                    }
                    catch (Exception exception)
                    {
                        org.altbeacon.beacon.c.c.a(exception, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
                    }
                    l = (new Date()).getTime();
                } else
                {
                    org.altbeacon.beacon.c.c.a("CycledLeScanner", "Bluetooth is disabled.  Cannot scan for beacons.", new Object[0]);
                }
            }
            a = m();
            if (p)
            {
                a(Boolean.valueOf(true));
            }
        }
        if (!p)
        {
            org.altbeacon.beacon.c.c.a("CycledLeScanner", "Scanning disabled.  No ranging or monitoring regions are active.", new Object[0]);
            o = false;
            k();
        }
    }

    private long m()
    {
        if (d == 0L)
        {
            return System.currentTimeMillis();
        } else
        {
            long l1 = q;
            long l2 = d;
            l1 = d - System.currentTimeMillis() % (l1 + l2);
            org.altbeacon.beacon.c.c.a("CycledLeScanner", "Normalizing between scan period from %s to %s", new Object[] {
                Long.valueOf(d), Long.valueOf(l1)
            });
            return l1 + System.currentTimeMillis();
        }
    }

    public void a()
    {
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "start called", new Object[0]);
        p = true;
        if (!o)
        {
            a(Boolean.valueOf(true));
            return;
        } else
        {
            org.altbeacon.beacon.c.c.a("CycledLeScanner", "scanning already started", new Object[0]);
            return;
        }
    }

    public void a(long l1, long l2, boolean flag)
    {
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "Set scan periods called with %s, %s Background mode must have changed.", new Object[] {
            Long.valueOf(l1), Long.valueOf(l2)
        });
        if (h != flag)
        {
            i = true;
        }
        h = flag;
        q = l1;
        d = l2;
        long l3;
        if (h)
        {
            org.altbeacon.beacon.c.c.a("CycledLeScanner", "We are in the background.  Setting wakeup alarm", new Object[0]);
            i();
        } else
        {
            org.altbeacon.beacon.c.c.a("CycledLeScanner", "We are not in the background.  Cancelling wakeup alarm", new Object[0]);
            k();
        }
        l3 = (new Date()).getTime();
        if (a > l3)
        {
            l2 = l + l2;
            if (l2 < a)
            {
                a = l2;
                org.altbeacon.beacon.c.c.b("CycledLeScanner", "Adjusted nextScanStartTime to be %s", new Object[] {
                    new Date(a)
                });
            }
        }
        if (m > l3)
        {
            l1 = k + l1;
            if (l1 < m)
            {
                m = l1;
                org.altbeacon.beacon.c.c.b("CycledLeScanner", "Adjusted scanStopTime to be %s", new Object[] {
                    Long.valueOf(m)
                });
            }
        }
    }

    protected void a(Boolean boolean1)
    {
        o = true;
        if (h() == null)
        {
            org.altbeacon.beacon.c.c.d("CycledLeScanner", "No Bluetooth adapter.  beaconService cannot scan.", new Object[0]);
        }
        if (!boolean1.booleanValue())
        {
            break MISSING_BLOCK_LABEL_299;
        }
        if (d())
        {
            return;
        }
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "starting a new scan cycle", new Object[0]);
        if (n && !b && !i) goto _L2; else goto _L1
_L1:
        n = true;
        b = false;
        if (h() == null) goto _L4; else goto _L3
_L3:
        if (!h().isEnabled()) goto _L6; else goto _L5
_L5:
        if (f == null || !f.d()) goto _L8; else goto _L7
_L7:
        org.altbeacon.beacon.c.c.c("CycledLeScanner", "Skipping scan because crash recovery is in progress.", new Object[0]);
_L9:
        k = (new Date()).getTime();
_L4:
        m = (new Date()).getTime() + q;
        f();
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "Scan started", new Object[0]);
        return;
_L8:
        if (!p)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        if (!i)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        i = false;
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "restarting a bluetooth le scan", new Object[0]);
_L10:
        e();
          goto _L9
        boolean1;
        org.altbeacon.beacon.c.c.b(boolean1, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
          goto _L9
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "starting a new bluetooth le scan", new Object[0]);
          goto _L10
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "Scanning unnecessary - no monitoring or ranging active.", new Object[0]);
          goto _L9
_L6:
        try
        {
            org.altbeacon.beacon.c.c.a("CycledLeScanner", "Bluetooth is disabled.  Cannot scan for beacons.", new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            org.altbeacon.beacon.c.c.b(boolean1, "CycledLeScanner", "Exception starting Bluetooth scan.  Perhaps Bluetooth is disabled or unavailable?", new Object[0]);
        }
          goto _L4
_L2:
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "We are already scanning", new Object[0]);
          goto _L4
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "disabling scan", new Object[0]);
        n = false;
        c();
        l = (new Date()).getTime();
        return;
          goto _L9
    }

    public void b()
    {
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "stop called", new Object[0]);
        p = false;
        if (o)
        {
            a(Boolean.valueOf(false));
        }
        if (j != null)
        {
            c();
            l = (new Date()).getTime();
        }
    }

    protected abstract void c();

    protected abstract boolean d();

    protected abstract void e();

    protected void f()
    {
        long l1 = 1000L;
        long l2 = m - (new Date()).getTime();
        if (l2 > 0L)
        {
            org.altbeacon.beacon.c.c.a("CycledLeScanner", "Waiting to stop scan cycle for another %s milliseconds", new Object[] {
                Long.valueOf(l2)
            });
            if (h)
            {
                i();
            }
            Handler handler = e;
            _cls1 _lcls1 = new _cls1();
            if (l2 <= 1000L)
            {
                l1 = l2;
            }
            handler.postDelayed(_lcls1, l1);
            return;
        } else
        {
            l();
            return;
        }
    }

    protected abstract void g();

    protected BluetoothAdapter h()
    {
        if (j == null)
        {
            j = ((BluetoothManager)c.getApplicationContext().getSystemService("bluetooth")).getAdapter();
            if (j == null)
            {
                org.altbeacon.beacon.c.c.c("CycledLeScanner", "Failed to construct a BluetoothAdapter", new Object[0]);
            }
        }
        return j;
    }

    protected void i()
    {
        long l1 = 0x493e0L;
        if (0x493e0L < d)
        {
            l1 = d;
        }
        if (l1 < q)
        {
            l1 = q;
        }
        ((AlarmManager)c.getSystemService("alarm")).set(0, System.currentTimeMillis() + l1, j());
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", new Object[] {
            Long.valueOf(l1), j()
        });
    }

    protected PendingIntent j()
    {
        if (r == null)
        {
            Intent intent = new Intent();
            intent.setClassName(c, org/altbeacon/beacon/startup/StartupBroadcastReceiver.getName());
            intent.putExtra("wakeup", true);
            r = PendingIntent.getBroadcast(c, 0, intent, 0x8000000);
        }
        return r;
    }

    protected void k()
    {
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "cancel wakeup alarm: %s", new Object[] {
            r
        });
        ((AlarmManager)c.getSystemService("alarm")).set(0, System.currentTimeMillis() + 0x7fffffffffffffffL, j());
        org.altbeacon.beacon.c.c.a("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", new Object[] {
            Long.valueOf(0x7fffffffffffffffL), j()
        });
    }

    /* member class not found */
    class _cls1 {}

}

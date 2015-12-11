// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.kahuna.sdk.m;
import com.kahuna.sdk.r;
import com.kahuna.sdk.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            ahg, ahc

public class ahh
{
    private static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(android/support/v7/ahh$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("SCANNING", 0);
            b = new a("NOT_SCANNING", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }

    private class b
        implements Runnable
    {

        final ahh a;
        private Object b;
        private boolean c;

        public void a()
        {
            synchronized (b)
            {
                c = true;
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public boolean b()
        {
label0:
            {
                synchronized (b)
                {
                    if (c)
                    {
                        break label0;
                    }
                }
                return true;
            }
            c = false;
            if (ahh.d() == a.a)
            {
                return true;
            }
            break MISSING_BLOCK_LABEL_41;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            obj;
            JVM INSTR monitorexit ;
            return false;
        }

        public void run()
        {
            boolean flag;
            synchronized (b)
            {
                ahh.a(a.a);
            }
            flag = c;
_L2:
            if (flag)
            {
                break MISSING_BLOCK_LABEL_288;
            }
            ahh.a(a, new HashSet(ahh.a(a)));
            ahh.a(a).clear();
            ahh.e().startLeScan(ahh.b(a));
            if (m.s())
            {
                Log.d("Kahuna", "Beginning BLE Scan");
            }
            Thread.sleep(10000L);
            if (m.s())
            {
                Log.d("Kahuna", "BLE Scan resting period");
            }
            ahh.e().stopLeScan(ahh.b(a));
            obj = ahh.c(ahh.f());
            obj;
            JVM INSTR monitorenter ;
            Iterator iterator = ahh.d(a).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ahg ahg1 = (ahg)iterator.next();
                if (ahh.a(ahh.e(ahh.f()), ahg1) && !ahh.a(ahh.a(a), ahg1))
                {
                    if (m.s())
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Tracking iBeacon exit for UUID: ").append(ahg1.b()).toString());
                    }
                    ahh.f(ahh.f()).a(ahg1, "exit");
                }
            } while (true);
            break; /* Loop/switch isn't completed */
            Exception exception;
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
                ((Exception) (obj)).printStackTrace();
            }
_L3:
            synchronized (b)
            {
                flag = c;
            }
            if (true) goto _L2; else goto _L1
            exception1;
            obj;
            JVM INSTR monitorexit ;
            throw exception1;
            exception2;
            obj;
            JVM INSTR monitorexit ;
            throw exception2;
_L1:
            obj;
            JVM INSTR monitorexit ;
            Thread.sleep(10000L);
              goto _L3
            synchronized (b)
            {
                ahh.a(a.b);
                c = false;
            }
            return;
            exception3;
            obj1;
            JVM INSTR monitorexit ;
            throw exception3;
        }
    }


    private static final byte a[] = {
        2, 1, 6, 26, -1, 76, 0, 2, 21
    };
    private static BluetoothAdapter c;
    private static a d;
    private static b e;
    private static final ahh k = new ahh();
    private m b;
    private Set f;
    private Set g;
    private boolean h;
    private Object i;
    private Set j;
    private android.bluetooth.BluetoothAdapter.LeScanCallback l;

    private ahh()
    {
        f = new HashSet();
        g = new HashSet();
        h = false;
        i = new Object();
        j = new HashSet();
        l = new android.bluetooth.BluetoothAdapter.LeScanCallback() {

            final ahh a;

            public void onLeScan(BluetoothDevice bluetoothdevice, int i1, byte abyte0[])
            {
                abyte0 = ahh.a(a, abyte0);
                if (abyte0 == null)
                {
                    return;
                }
                abyte0.b(bluetoothdevice.getName());
                abyte0.c(bluetoothdevice.getAddress());
                abyte0.c(i1);
                abyte0.b((int)ahh.a(a, abyte0.e(), i1));
                if (m.s())
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Beacon scanned ").append(bluetoothdevice.getName()).append(" ").append(abyte0.b()).append(" ").append(bluetoothdevice.getAddress()).toString());
                }
                synchronized (ahh.c(ahh.f()))
                {
                    if (ahh.a(ahh.e(ahh.f()), abyte0) && !ahh.a(ahh.d(a), abyte0))
                    {
                        if (m.s())
                        {
                            Log.d("Kahuna", (new StringBuilder()).append("Tracking iBeacon enter for UUID: ").append(abyte0.b()).toString());
                        }
                        ahh.f(ahh.f()).a(abyte0, "enter");
                    }
                }
                ahh.a(a).add(abyte0);
                return;
                abyte0;
                bluetoothdevice;
                JVM INSTR monitorexit ;
                throw abyte0;
            }

            
            {
                a = ahh.this;
                super();
            }
        };
    }

    private double a(int i1, double d1)
    {
        if (d1 == 0.0D)
        {
            return -1D;
        }
        d1 = (d1 * 1.0D) / (double)i1;
        if (d1 < 1.0D)
        {
            return Math.pow(d1, 10D);
        } else
        {
            return Math.pow(d1, 7.7095000000000002D) * 0.89976D + 0.111D;
        }
    }

    static double a(ahh ahh1, int i1, double d1)
    {
        return ahh1.a(i1, d1);
    }

    static ahg a(ahh ahh1, byte abyte0[])
    {
        return ahh1.b(abyte0);
    }

    static a a(a a1)
    {
        d = a1;
        return a1;
    }

    static Set a(ahh ahh1)
    {
        return ahh1.g;
    }

    static Set a(ahh ahh1, Set set)
    {
        ahh1.f = set;
        return set;
    }

    private static JSONArray a(Set set)
    {
        if (set == null || set.isEmpty())
        {
            return new JSONArray();
        }
        JSONArray jsonarray = new JSONArray();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            JSONObject jsonobject = ((ahg)set.next()).g();
            if (jsonobject != null)
            {
                jsonarray.put(jsonobject);
            }
        } while (true);
        return jsonarray;
    }

    public static void a(m m1, JSONObject jsonobject, Context context)
    {
        if (m1 != null && (m1 instanceof m)) goto _L2; else goto _L1
_L1:
        Log.e("Kahuna", "You cannot request to process iBeacons externally from the Kahuna SDK. Aborting!");
_L4:
        return;
_L2:
        JSONArray jsonarray = jsonobject.optJSONArray("beacon");
        if (jsonarray == null) goto _L4; else goto _L3
_L3:
        if (k.h) goto _L6; else goto _L5
_L5:
        if (!m.s()) goto _L4; else goto _L7
_L7:
        Log.w("Kahuna", "App doens't have required permissions for iBeacon Monitoring. Aborting processing of server response");
        return;
_L9:
        if (!m.s()) goto _L4; else goto _L8
_L8:
        Log.d("Kahuna", (new StringBuilder()).append("Caught exception in iBeacon Manager process server iBeacons: ").append(m1).toString());
        return;
_L6:
        ArrayList arraylist;
        int j1;
        long l2;
        arraylist = new ArrayList();
        j1 = jsonarray.length();
        l2 = System.currentTimeMillis() / 1000L;
        JSONObject jsonobject1;
        Exception exception;
        String s;
        String s1;
        int k1;
        int l1;
        long l3;
        for (int i1 = 0; i1 >= j1; i1++)
        {
            break MISSING_BLOCK_LABEL_271;
        }

        jsonobject1 = jsonarray.getJSONObject(i1);
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        s = jsonobject1.getString("id");
        s1 = jsonobject1.getString("uuid");
        k1 = jsonobject1.optInt("major", -1);
        l1 = jsonobject1.optInt("minor", -1);
        l3 = jsonobject1.optLong("expiry", -1L);
        if (l3 <= 0L || l3 >= l2)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        if (m.s())
        {
            Log.e("Kahuna", "Received iBeacon monitor request that already expired, ignoring...");
        }
        break MISSING_BLOCK_LABEL_365;
        arraylist.add(new ahg(s, s1, k1, l1, l3));
        break MISSING_BLOCK_LABEL_365;
        exception;
        if (m.s())
        {
            Log.d("Kahuna", "Encountered error processing geofence regions from Kahuna servers.");
            exception.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_365;
        ahc.a(jsonobject.optInt("am_interval", -1));
        if (a())
        {
            ahc.c();
        }
        jsonobject = ((JSONObject) (k.i));
        jsonobject;
        JVM INSTR monitorenter ;
        if (arraylist.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_347;
        }
        k.j.addAll(arraylist);
        ahc.a(m1);
_L10:
        r.a(m1, context, a(k.j));
        return;
        m1;
        jsonobject;
        JVM INSTR monitorexit ;
        try
        {
            throw m1;
        }
        // Misplaced declaration of an exception variable
        catch (m m1) { }
          goto _L9
        k.j.clear();
        ahc.b(m1);
          goto _L10
    }

    protected static boolean a()
    {
        return d == a.a;
    }

    public static boolean a(m m1)
    {
        if (m1 == null || !(m1 instanceof m))
        {
            Log.e("Kahuna", "You cannot use IBeacon Manager externally from the Kahuna SDK. Aborting!");
            return false;
        } else
        {
            return k.h;
        }
    }

    static boolean a(Set set, ahg ahg1)
    {
        return b(set, ahg1);
    }

    private boolean a(byte abyte0[])
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (Arrays.equals(Arrays.copyOfRange(a, 0, 2), Arrays.copyOfRange(abyte0, 0, 2)))
        {
            flag = flag1;
            if (Arrays.equals(Arrays.copyOfRange(a, 3, a.length), Arrays.copyOfRange(abyte0, 3, a.length)))
            {
                flag = true;
            }
        }
        return flag;
    }

    static android.bluetooth.BluetoothAdapter.LeScanCallback b(ahh ahh1)
    {
        return ahh1.l;
    }

    private ahg b(byte abyte0[])
    {
        if (a(abyte0))
        {
            byte abyte1[] = Arrays.copyOfRange(abyte0, a.length, a.length + 16);
            int i1 = a.length + 16;
            byte byte0 = abyte0[i1];
            byte byte1 = abyte0[i1 + 1];
            byte byte2 = abyte0[i1 + 2];
            byte byte3 = abyte0[i1 + 3];
            ahg ahg1 = new ahg(null, ahg.a(abyte1), byte0 << 8 & 0xff00 | byte1 & 0xff, byte2 << 8 & 0xff00 | byte3 & 0xff, 0L);
            ahg1.a((abyte0[i1 + 4] << 24) >> 24);
            return ahg1;
        } else
        {
            return null;
        }
    }

    public static Set b(m m1)
    {
        if (m1 == null || !(m1 instanceof m))
        {
            Log.e("Kahuna", "You cannot use IBeacon Manager externally from the Kahuna SDK. Aborting!");
            return new HashSet();
        }
        m1 = new HashSet();
        Object obj = k.i;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = k.j.iterator(); iterator.hasNext(); m1.add(((ahg)iterator.next()).a())) { }
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (m.s())
        {
            Log.w("Kahuna", (new StringBuilder()).append("Caught exception when getting currently monitored beacons: ").append(obj).toString());
        }
_L2:
        return m1;
_L1:
        obj;
        JVM INSTR monitorexit ;
          goto _L2
    }

    public static void b()
    {
        if (k.h) goto _L2; else goto _L1
_L1:
        if (m.s())
        {
            Log.w("Kahuna", "App doens't have required permissions for iBeacon Monitoring. Aborting request for scan");
        }
_L4:
        return;
_L2:
        synchronized (k.i)
        {
            if (k.j.size() != 0)
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
        if (d == a.b)
        {
            (new Thread(e)).start();
            return;
        }
        if (e != null && !e.b())
        {
            (new Thread(e)).start();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static boolean b(Set set, ahg ahg1)
    {
        if (set == null || set.isEmpty())
        {
            return false;
        }
        for (set = set.iterator(); set.hasNext();)
        {
            ahg ahg2 = (ahg)set.next();
            if (ahg2.equals(ahg1))
            {
                if (v.a(ahg1.a()))
                {
                    ahg1.a(ahg2.a());
                }
                return true;
            }
        }

        return false;
    }

    static Object c(ahh ahh1)
    {
        return ahh1.i;
    }

    public static void c()
    {
        if (e != null && d == a.a)
        {
            e.a();
        }
        Object obj = k.i;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = k.f.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ahg ahg1 = (ahg)iterator.next();
            if (b(k.j, ahg1))
            {
                if (m.s())
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Tracking iBeacon exit for UUID: ").append(ahg1.b()).toString());
                }
                k.b.a(ahg1, "exit");
            }
        } while (true);
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
_L2:
        k.f.clear();
        if (!k.h && m.s())
        {
            Log.w("Kahuna", "App doens't have required permissions for iBeacon Monitoring. Aborting request for scan");
        }
        return;
_L1:
        obj;
        JVM INSTR monitorexit ;
          goto _L2
    }

    static a d()
    {
        return d;
    }

    static Set d(ahh ahh1)
    {
        return ahh1.f;
    }

    static BluetoothAdapter e()
    {
        return c;
    }

    static Set e(ahh ahh1)
    {
        return ahh1.j;
    }

    static ahh f()
    {
        return k;
    }

    static m f(ahh ahh1)
    {
        return ahh1.b;
    }

    static 
    {
        d = a.b;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.easibeacon.protocol;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Referenced classes of package com.easibeacon.protocol:
//            IBeacon, IBeaconListener

public class IBeaconProtocol
{
    private final class a
        implements Comparator
    {

        final IBeaconProtocol a;

        public final int compare(Object obj, Object obj1)
        {
            obj = (IBeacon)obj;
            obj1 = (IBeacon)obj1;
            return ((IBeacon) (obj)).getProximity() - ((IBeacon) (obj1)).getProximity();
        }

        private a()
        {
            a = IBeaconProtocol.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    public static final byte ADV_PREFIX[] = {
        2, 1, 6, 26, -1, 76, 0, 2, 21
    };
    public static final String EASIBEACON_IDPREFIX = "easiBeacon_";
    public static final int SCANNING_PERIOD = 10000;
    public static final int SEARCH_END_EMPTY = 2;
    public static final int SEARCH_END_SUCCESS = 3;
    public static final int SEARCH_STARTED = 1;
    public static final int UNDETERMINABLE_PROXIMITY = -1;
    public static final int UUID_LEN = 16;
    private static IBeaconProtocol a = null;
    private BluetoothAdapter b;
    private IBeaconListener c;
    private byte d[];
    private boolean e;
    private IBeacon f;
    private final ArrayList g = new ArrayList();
    private final android.bluetooth.BluetoothAdapter.LeScanCallback h = new android.bluetooth.BluetoothAdapter.LeScanCallback() {

        final IBeaconProtocol a;

        public final void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
        {
            abyte0 = IBeaconProtocol.a(a, abyte0);
            if (abyte0 != null)
            {
                abyte0.setRssi(i);
                abyte0.setMacAddress(bluetoothdevice.getAddress());
                if (bluetoothdevice.getName().startsWith("easiBeacon_"))
                {
                    abyte0.setEasiBeacon(true);
                } else
                {
                    abyte0.setEasiBeacon(false);
                }
                if (abyte0.isEasiBeacon())
                {
                    abyte0.setProximity((int)IBeaconProtocol.a(abyte0.getPowerValue(), i));
                } else
                {
                    abyte0.setProximity(-1);
                }
                if (!IBeaconProtocol.a(a).contains(abyte0))
                {
                    IBeaconProtocol.a(a).add(abyte0);
                    Collections.sort(IBeaconProtocol.a(a), a. new a((byte)0));
                    IBeaconProtocol.b(a).beaconFound(abyte0);
                    return;
                }
            }
        }

            
            {
                a = IBeaconProtocol.this;
                super();
            }
    };

    private IBeaconProtocol()
    {
        d = null;
        f = null;
    }

    static double a(int i, double d1)
    {
        if (d1 == 0.0D)
        {
            return -1D;
        }
        d1 = (d1 * 1.0D) / (double)i;
        if (d1 < 1.0D)
        {
            return Math.pow(d1, 10D);
        } else
        {
            return Math.pow(d1, 7.7095000000000002D) * 0.89976D + 0.111D;
        }
    }

    static IBeacon a(IBeaconProtocol ibeaconprotocol, byte abyte0[])
    {
        if (Arrays.equals(ADV_PREFIX, Arrays.copyOfRange(abyte0, 0, ADV_PREFIX.length)))
        {
            byte abyte1[] = Arrays.copyOfRange(abyte0, ADV_PREFIX.length, ADV_PREFIX.length + 16);
            if (ibeaconprotocol.d == null || Arrays.equals(ibeaconprotocol.d, abyte1))
            {
                int i = ADV_PREFIX.length + 16;
                ibeaconprotocol = new IBeacon();
                ibeaconprotocol.setUuid(abyte1);
                ibeaconprotocol.setMajor(abyte0[i] << 8 & 0xff00 | abyte0[i + 1] & 0xff);
                ibeaconprotocol.setMinor(abyte0[i + 2] << 8 & 0xff00 | abyte0[i + 3] & 0xff);
                ibeaconprotocol.setPowerValue(abyte0[i + 4]);
                return ibeaconprotocol;
            }
        }
        return null;
    }

    static ArrayList a(IBeaconProtocol ibeaconprotocol)
    {
        return ibeaconprotocol.g;
    }

    static IBeaconListener b(IBeaconProtocol ibeaconprotocol)
    {
        return ibeaconprotocol.c;
    }

    static boolean c(IBeaconProtocol ibeaconprotocol)
    {
        ibeaconprotocol.e = false;
        return false;
    }

    static android.bluetooth.BluetoothAdapter.LeScanCallback d(IBeaconProtocol ibeaconprotocol)
    {
        return ibeaconprotocol.h;
    }

    static BluetoothAdapter e(IBeaconProtocol ibeaconprotocol)
    {
        return ibeaconprotocol.b;
    }

    static void f(IBeaconProtocol ibeaconprotocol)
    {
        IBeacon ibeacon;
        if (!ibeaconprotocol.g.isEmpty())
        {
            ibeacon = (IBeacon)ibeaconprotocol.g.get(0);
        } else
        {
            ibeacon = null;
        }
        if (ibeaconprotocol.f == null && ibeacon != null)
        {
            ibeaconprotocol.c.enterRegion(ibeacon);
            ibeaconprotocol.f = ibeacon;
        } else
        {
            if (ibeaconprotocol.f != null && ibeacon != null && ibeaconprotocol.f.equals(ibeacon))
            {
                ibeaconprotocol.f = ibeacon;
                return;
            }
            if (ibeaconprotocol.f != null && ibeacon != null && !ibeaconprotocol.f.equals(ibeacon))
            {
                ibeaconprotocol.c.exitRegion(ibeaconprotocol.f);
                ibeaconprotocol.c.enterRegion(ibeacon);
                ibeaconprotocol.f = ibeacon;
                return;
            }
            if (ibeaconprotocol.f != null && ibeacon == null)
            {
                ibeaconprotocol.c.exitRegion(ibeaconprotocol.f);
                ibeaconprotocol.f = null;
                return;
            }
        }
    }

    public static IBeaconProtocol getInstance(Context context)
    {
        if (a == null)
        {
            a = new IBeaconProtocol();
            if (!initializeBluetoothAdapter(context))
            {
                return null;
            }
        }
        return a;
    }

    public static boolean initializeBluetoothAdapter(Context context)
    {
        context = (BluetoothManager)context.getSystemService("bluetooth");
        a.b = context.getAdapter();
        return a.b != null && a.b.isEnabled();
    }

    public BluetoothDevice getDevice(String s)
    {
        return b.getRemoteDevice(s);
    }

    public ArrayList getIBeaconsByProximity()
    {
        return g;
    }

    public IBeaconListener getListener()
    {
        return c;
    }

    public boolean isScanning()
    {
        return e;
    }

    public void reset()
    {
        f = null;
    }

    public void scanIBeacons(boolean flag)
    {
        if (flag)
        {
            (new Handler()).postDelayed(new Runnable() {

                final IBeaconProtocol a;

                public final void run()
                {
                    IBeaconProtocol.c(a);
                    IBeaconProtocol.e(a).stopLeScan(IBeaconProtocol.d(a));
                    if (IBeaconProtocol.a(a).isEmpty())
                    {
                        IBeaconProtocol.b(a).searchState(2);
                    } else
                    {
                        IBeaconProtocol.b(a).searchState(3);
                    }
                    IBeaconProtocol.f(a);
                }

            
            {
                a = IBeaconProtocol.this;
                super();
            }
            }, 10000L);
            e = true;
            g.clear();
            b.startLeScan(h);
            c.searchState(1);
            return;
        } else
        {
            e = false;
            b.stopLeScan(h);
            c.searchState(3);
            return;
        }
    }

    public void setListener(IBeaconListener ibeaconlistener)
    {
        c = ibeaconlistener;
    }

    public void setScanUUID(byte abyte0[])
    {
        d = abyte0;
    }

}

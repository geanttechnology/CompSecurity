// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.radiusnetworks.ibeacon.client.IBeaconDataFactory;
import com.radiusnetworks.ibeacon.client.NullIBeaconDataFactory;

// Referenced classes of package com.radiusnetworks.ibeacon:
//            IBeaconManager, IBeaconDataNotifier

public class IBeacon
{

    public static final int PROXIMITY_FAR = 3;
    public static final int PROXIMITY_IMMEDIATE = 1;
    public static final int PROXIMITY_NEAR = 2;
    public static final int PROXIMITY_UNKNOWN = 0;
    private static final String TAG = "IBeacon";
    private static final char hexArray[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    protected static IBeaconDataFactory iBeaconDataFactory = new NullIBeaconDataFactory();
    protected Double accuracy;
    protected String bluetoothAddress;
    protected int major;
    protected int minor;
    protected Integer proximity;
    protected String proximityUuid;
    protected int rssi;
    protected Double runningAverageRssi;
    protected int txPower;

    protected IBeacon()
    {
        runningAverageRssi = null;
    }

    protected IBeacon(IBeacon ibeacon)
    {
        runningAverageRssi = null;
        major = ibeacon.major;
        minor = ibeacon.minor;
        accuracy = ibeacon.accuracy;
        proximity = ibeacon.proximity;
        runningAverageRssi = ibeacon.runningAverageRssi;
        rssi = ibeacon.rssi;
        proximityUuid = ibeacon.proximityUuid;
        txPower = ibeacon.txPower;
        bluetoothAddress = ibeacon.bluetoothAddress;
    }

    public IBeacon(String s, int i, int j)
    {
        runningAverageRssi = null;
        proximityUuid = s.toLowerCase();
        major = i;
        minor = j;
        rssi = rssi;
        txPower = -59;
        rssi = 0;
    }

    protected IBeacon(String s, int i, int j, int k, int l)
    {
        runningAverageRssi = null;
        proximityUuid = s.toLowerCase();
        major = i;
        minor = j;
        rssi = l;
        txPower = k;
    }

    private static String bytesToHex(byte abyte0[])
    {
        char ac[] = new char[abyte0.length * 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac[i * 2] = hexArray[j >>> 4];
            ac[i * 2 + 1] = hexArray[j & 0xf];
        }

        return new String(ac);
    }

    protected static double calculateAccuracy(int i, double d)
    {
        double d1;
        if (d == 0.0D)
        {
            d1 = -1D;
        } else
        {
            if (IBeaconManager.debug)
            {
                Log.d("IBeacon", (new StringBuilder()).append("calculating accuracy based on rssi of ").append(d).toString());
            }
            d1 = (d * 1.0D) / (double)i;
            if (d1 < 1.0D)
            {
                return Math.pow(d1, 10D);
            }
            double d2 = Math.pow(d1, 7.7095000000000002D) * 0.89976D + 0.111D;
            d1 = d2;
            if (IBeaconManager.debug)
            {
                Log.d("IBeacon", (new StringBuilder()).append(" avg rssi: ").append(d).append(" accuracy: ").append(d2).toString());
                return d2;
            }
        }
        return d1;
    }

    protected static int calculateProximity(double d)
    {
        if (d < 0.0D)
        {
            return 0;
        }
        if (d < 0.5D)
        {
            return 1;
        }
        return d > 4D ? 3 : 2;
    }

    public static IBeacon fromScanData(byte abyte0[], int i)
    {
        return fromScanData(abyte0, i, null);
    }

    public static IBeacon fromScanData(byte abyte0[], int i, BluetoothDevice bluetoothdevice)
    {
        int j = 2;
_L5:
        if (j > 5)
        {
            break MISSING_BLOCK_LABEL_548;
        }
        if ((abyte0[j + 2] & 0xff) != 2 || (abyte0[j + 3] & 0xff) != 21) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L8:
        if (flag) goto _L4; else goto _L3
_L3:
        if (IBeaconManager.debug)
        {
            Log.d("IBeacon", (new StringBuilder()).append("This is not an iBeacon advertisment (no 0215 seen in bytes 4-7).  The bytes I see are: ").append(bytesToHex(abyte0)).toString());
        }
        abyte0 = null;
_L7:
        return abyte0;
_L2:
        if ((abyte0[j] & 0xff) == 45 && (abyte0[j + 1] & 0xff) == 36 && (abyte0[j + 2] & 0xff) == 191 && (abyte0[j + 3] & 0xff) == 22)
        {
            if (IBeaconManager.debug)
            {
                Log.d("IBeacon", "This is a proprietary Estimote beacon advertisement that does not meet the iBeacon standard.  Identifiers cannot be read.");
            }
            abyte0 = new IBeacon();
            abyte0.major = 0;
            abyte0.minor = 0;
            abyte0.proximityUuid = "00000000-0000-0000-0000-000000000000";
            abyte0.txPower = -55;
            return abyte0;
        }
        if ((abyte0[j] & 0xff) == 173 && (abyte0[j + 1] & 0xff) == 119 && (abyte0[j + 2] & 0xff) == 0 && (abyte0[j + 3] & 0xff) == 198)
        {
            if (IBeaconManager.debug)
            {
                Log.d("IBeacon", "This is a proprietary Gimbal beacon advertisement that does not meet the iBeacon standard.  Identifiers cannot be read.");
            }
            abyte0 = new IBeacon();
            abyte0.major = 0;
            abyte0.minor = 0;
            abyte0.proximityUuid = "00000000-0000-0000-0000-000000000000";
            abyte0.txPower = -55;
            return abyte0;
        }
        j++;
          goto _L5
_L4:
        IBeacon ibeacon;
        ibeacon = new IBeacon();
        ibeacon.major = (abyte0[j + 20] & 0xff) * 256 + (abyte0[j + 21] & 0xff);
        ibeacon.minor = (abyte0[j + 22] & 0xff) * 256 + (abyte0[j + 23] & 0xff);
        ibeacon.txPower = abyte0[j + 24];
        ibeacon.rssi = i;
        byte abyte1[] = new byte[16];
        System.arraycopy(abyte0, j + 4, abyte1, 0, 16);
        abyte0 = bytesToHex(abyte1);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(abyte0.substring(0, 8));
        stringbuilder.append("-");
        stringbuilder.append(abyte0.substring(8, 12));
        stringbuilder.append("-");
        stringbuilder.append(abyte0.substring(12, 16));
        stringbuilder.append("-");
        stringbuilder.append(abyte0.substring(16, 20));
        stringbuilder.append("-");
        stringbuilder.append(abyte0.substring(20, 32));
        ibeacon.proximityUuid = stringbuilder.toString();
        abyte0 = ibeacon;
        if (bluetoothdevice == null) goto _L7; else goto _L6
_L6:
        ibeacon.bluetoothAddress = bluetoothdevice.getAddress();
        return ibeacon;
        flag = false;
          goto _L8
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof IBeacon)
        {
            if (((IBeacon) (obj = (IBeacon)obj)).getMajor() == getMajor() && ((IBeacon) (obj)).getMinor() == getMinor() && ((IBeacon) (obj)).getProximityUuid().equals(getProximityUuid()))
            {
                return true;
            }
        }
        return false;
    }

    public double getAccuracy()
    {
        if (accuracy != null) goto _L2; else goto _L1
_L1:
        double d1 = rssi;
        if (runningAverageRssi == null) goto _L4; else goto _L3
_L3:
        double d = runningAverageRssi.doubleValue();
_L6:
        accuracy = Double.valueOf(calculateAccuracy(txPower, d));
_L2:
        return accuracy.doubleValue();
_L4:
        d = d1;
        if (IBeaconManager.debug)
        {
            Log.d("IBeacon", "Not using running average RSSI because it is null");
            d = d1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getBluetoothAddress()
    {
        return bluetoothAddress;
    }

    public int getMajor()
    {
        return major;
    }

    public int getMinor()
    {
        return minor;
    }

    public int getProximity()
    {
        if (proximity == null)
        {
            proximity = Integer.valueOf(calculateProximity(getAccuracy()));
        }
        return proximity.intValue();
    }

    public String getProximityUuid()
    {
        return proximityUuid;
    }

    public int getRssi()
    {
        return rssi;
    }

    public int getTxPower()
    {
        return txPower;
    }

    public int hashCode()
    {
        return minor;
    }

    public void requestData(IBeaconDataNotifier ibeacondatanotifier)
    {
        iBeaconDataFactory.requestIBeaconData(this, ibeacondatanotifier);
    }

}

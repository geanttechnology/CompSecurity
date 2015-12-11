// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.ParcelUuid;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.UUID;
import org.altbeacon.beacon.logging.LogManager;

// Referenced classes of package org.altbeacon.beacon:
//            Beacon, BeaconParser

public class BeaconTransmitter
{

    public static final int NOT_SUPPORTED_BLE = 2;
    public static final int NOT_SUPPORTED_CANNOT_GET_ADVERTISER = 4;
    public static final int NOT_SUPPORTED_CANNOT_GET_ADVERTISER_MULTIPLE_ADVERTISEMENTS = 5;
    public static final int NOT_SUPPORTED_MIN_SDK = 1;
    public static final int NOT_SUPPORTED_MULTIPLE_ADVERTISEMENTS = 3;
    public static final int SUPPORTED = 0;
    private static final String TAG = "BeaconTransmitter";
    private AdvertiseCallback mAdvertiseCallback;
    private int mAdvertiseMode;
    private int mAdvertiseTxPowerLevel;
    private AdvertiseCallback mAdvertisingClientCallback;
    private Beacon mBeacon;
    private BeaconParser mBeaconParser;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    private boolean mStarted;

    public BeaconTransmitter(Context context, BeaconParser beaconparser)
    {
        mAdvertiseMode = 0;
        mAdvertiseTxPowerLevel = 3;
        mBeaconParser = beaconparser;
        context = (BluetoothManager)context.getSystemService("bluetooth");
        if (context != null)
        {
            mBluetoothAdapter = context.getAdapter();
            mBluetoothLeAdvertiser = mBluetoothAdapter.getBluetoothLeAdvertiser();
            LogManager.d("BeaconTransmitter", "new BeaconTransmitter constructed.  mbluetoothLeAdvertiser is %s", new Object[] {
                mBluetoothLeAdvertiser
            });
            return;
        } else
        {
            LogManager.e("BeaconTransmitter", "Failed to get BluetoothManager", new Object[0]);
            return;
        }
    }

    public static int checkTransmissionSupported(Context context)
    {
        int i = 0;
        if (android.os.Build.VERSION.SDK_INT >= 21) goto _L2; else goto _L1
_L1:
        i = 1;
_L4:
        return i;
_L2:
        if (!context.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))
        {
            return 2;
        }
        if (((BluetoothManager)context.getSystemService("bluetooth")).getAdapter().getBluetoothLeAdvertiser() != null) goto _L4; else goto _L3
_L3:
        boolean flag = ((BluetoothManager)context.getSystemService("bluetooth")).getAdapter().isMultipleAdvertisementSupported();
        return flag ? 4 : 5;
        context;
        return 4;
    }

    private AdvertiseCallback getAdvertiseCallback()
    {
        if (mAdvertiseCallback == null)
        {
            mAdvertiseCallback = new _cls1();
        }
        return mAdvertiseCallback;
    }

    private static ParcelUuid parseUuidFrom(byte abyte0[])
    {
        ParcelUuid parceluuid = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int i = abyte0.length;
        if (i != 2 && i != 4 && i != 16)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("uuidBytes length invalid - ").append(i).toString());
        }
        if (i == 16)
        {
            abyte0 = ByteBuffer.wrap(abyte0).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(abyte0.getLong(8), abyte0.getLong(0)));
        }
        long l;
        if (i == 2)
        {
            l = (long)(abyte0[0] & 0xff) + (long)((abyte0[1] & 0xff) << 8);
        } else
        {
            l = (long)(abyte0[0] & 0xff) + (long)((abyte0[1] & 0xff) << 8) + (long)((abyte0[2] & 0xff) << 16) + (long)((abyte0[3] & 0xff) << 24);
        }
        return new ParcelUuid(new UUID(parceluuid.getUuid().getMostSignificantBits() + (l << 32), parceluuid.getUuid().getLeastSignificantBits()));
    }

    public int getAdvertiseMode()
    {
        return mAdvertiseMode;
    }

    public int getAdvertiseTxPowerLevel()
    {
        return mAdvertiseTxPowerLevel;
    }

    public boolean isStarted()
    {
        return mStarted;
    }

    public void setAdvertiseMode(int i)
    {
        mAdvertiseMode = i;
    }

    public void setAdvertiseTxPowerLevel(int i)
    {
        mAdvertiseTxPowerLevel = i;
    }

    public void setBeacon(Beacon beacon)
    {
        mBeacon = beacon;
    }

    public void setBeaconParser(BeaconParser beaconparser)
    {
        mBeaconParser = beaconparser;
    }

    public void startAdvertising()
    {
        if (mBeacon == null)
        {
            throw new NullPointerException("Beacon cannot be null.  Set beacon before starting advertising");
        }
        int j = mBeacon.getManufacturer();
        int k = mBeacon.getServiceUuid();
        if (mBeaconParser == null)
        {
            throw new NullPointerException("You must supply a BeaconParser instance to BeaconTransmitter.");
        }
        byte abyte0[] = mBeaconParser.getBeaconAdvertisementData(mBeacon);
        Object obj = "";
        for (int i = 0; i < abyte0.length; i++)
        {
            obj = (new StringBuilder()).append(((String) (obj))).append(String.format("%02X", new Object[] {
                Byte.valueOf(abyte0[i])
            })).toString();
            obj = (new StringBuilder()).append(((String) (obj))).append(" ").toString();
        }

        Identifier identifier = mBeacon.getId1();
        Object obj1;
        Object obj2;
        if (mBeacon.getIdentifiers().size() > 1)
        {
            obj1 = mBeacon.getId2();
        } else
        {
            obj1 = "";
        }
        if (mBeacon.getIdentifiers().size() > 2)
        {
            obj2 = mBeacon.getId3();
        } else
        {
            obj2 = "";
        }
        LogManager.d("BeaconTransmitter", "Starting advertising with ID1: %s ID2: %s ID3: %s and data: %s of size %s", new Object[] {
            identifier, obj1, obj2, obj, Integer.valueOf(abyte0.length)
        });
        try
        {
            obj = new android.bluetooth.le.AdvertiseData.Builder();
        }
        catch (Exception exception)
        {
            LogManager.e(exception, "BeaconTransmitter", "Cannot start advertising due to exception", new Object[0]);
            return;
        }
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        ((android.bluetooth.le.AdvertiseData.Builder) (obj)).addServiceData(parseUuidFrom(new byte[] {
            (byte)(k >> 8 & 0xff), (byte)(k & 0xff)
        }), abyte0);
_L1:
        obj1 = new android.bluetooth.le.AdvertiseSettings.Builder();
        ((android.bluetooth.le.AdvertiseSettings.Builder) (obj1)).setAdvertiseMode(mAdvertiseMode);
        ((android.bluetooth.le.AdvertiseSettings.Builder) (obj1)).setTxPowerLevel(mAdvertiseTxPowerLevel);
        ((android.bluetooth.le.AdvertiseSettings.Builder) (obj1)).setConnectable(false);
        mBluetoothLeAdvertiser.startAdvertising(((android.bluetooth.le.AdvertiseSettings.Builder) (obj1)).build(), ((android.bluetooth.le.AdvertiseData.Builder) (obj)).build(), getAdvertiseCallback());
        LogManager.d("BeaconTransmitter", "Started advertisement with callback: %s", new Object[] {
            getAdvertiseCallback()
        });
        return;
        ((android.bluetooth.le.AdvertiseData.Builder) (obj)).addManufacturerData(j, abyte0);
          goto _L1
    }

    public void startAdvertising(Beacon beacon)
    {
        startAdvertising(beacon, null);
    }

    public void startAdvertising(Beacon beacon, AdvertiseCallback advertisecallback)
    {
        mBeacon = beacon;
        mAdvertisingClientCallback = advertisecallback;
        startAdvertising();
    }

    public void stopAdvertising()
    {
        if (!mStarted)
        {
            LogManager.d("BeaconTransmitter", "Skipping stop advertising -- not started", new Object[0]);
            return;
        } else
        {
            LogManager.d("BeaconTransmitter", "Stopping advertising with object %s", new Object[] {
                mBluetoothLeAdvertiser
            });
            mAdvertisingClientCallback = null;
            mBluetoothLeAdvertiser.stopAdvertising(getAdvertiseCallback());
            mStarted = false;
            return;
        }
    }



/*
    static boolean access$102(BeaconTransmitter beacontransmitter, boolean flag)
    {
        beacontransmitter.mStarted = flag;
        return flag;
    }

*/

    /* member class not found */
    class _cls1 {}

}

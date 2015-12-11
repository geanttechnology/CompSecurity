// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.client.BeaconDataFactory;
import org.altbeacon.beacon.client.NullBeaconDataFactory;
import org.altbeacon.beacon.distance.DistanceCalculator;
import org.altbeacon.beacon.logging.LogManager;

// Referenced classes of package org.altbeacon.beacon:
//            Identifier, BeaconDataNotifier

public class Beacon
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private static final String TAG = "Beacon";
    protected static BeaconDataFactory beaconDataFactory = new NullBeaconDataFactory();
    protected static DistanceCalculator sDistanceCalculator = null;
    protected int mBeaconTypeCode;
    protected String mBluetoothAddress;
    protected String mBluetoothName;
    protected List mDataFields;
    protected Double mDistance;
    protected List mIdentifiers;
    protected int mManufacturer;
    protected int mRssi;
    private Double mRunningAverageRssi;
    protected int mServiceUuid;
    protected int mTxPower;

    protected Beacon()
    {
        mRunningAverageRssi = null;
        mIdentifiers = new ArrayList(1);
        mDataFields = new ArrayList(1);
    }

    protected Beacon(Parcel parcel)
    {
        mRunningAverageRssi = null;
        int k = parcel.readInt();
        mIdentifiers = new ArrayList(k);
        for (int i = 0; i < k; i++)
        {
            mIdentifiers.add(Identifier.parse(parcel.readString()));
        }

        mDistance = Double.valueOf(parcel.readDouble());
        mRssi = parcel.readInt();
        mTxPower = parcel.readInt();
        mBluetoothAddress = parcel.readString();
        mBeaconTypeCode = parcel.readInt();
        mServiceUuid = parcel.readInt();
        k = parcel.readInt();
        mDataFields = new ArrayList(k);
        for (int j = 0; j < k; j++)
        {
            mDataFields.add(Long.valueOf(parcel.readLong()));
        }

        mManufacturer = parcel.readInt();
        mBluetoothName = parcel.readString();
    }

    protected Beacon(Beacon beacon)
    {
        mRunningAverageRssi = null;
        mIdentifiers = new ArrayList(beacon.mIdentifiers.size());
        mDataFields = new ArrayList(beacon.mDataFields.size());
        for (int i = 0; i < beacon.mIdentifiers.size(); i++)
        {
            mIdentifiers.add(beacon.mIdentifiers.get(i));
        }

        mDistance = beacon.mDistance;
        mRunningAverageRssi = beacon.mRunningAverageRssi;
        mRssi = beacon.mRssi;
        mTxPower = beacon.mTxPower;
        mBluetoothAddress = beacon.mBluetoothAddress;
        mBeaconTypeCode = beacon.getBeaconTypeCode();
        mServiceUuid = beacon.getServiceUuid();
        mBluetoothName = beacon.mBluetoothName;
    }

    protected static Double calculateDistance(int i, double d)
    {
        if (getDistanceCalculator() != null)
        {
            return Double.valueOf(getDistanceCalculator().calculateDistance(i, d));
        } else
        {
            LogManager.e("Beacon", "Distance calculator not set.  Distance will bet set to -1", new Object[0]);
            return Double.valueOf(-1D);
        }
    }

    public static DistanceCalculator getDistanceCalculator()
    {
        return sDistanceCalculator;
    }

    public static void setDistanceCalculator(DistanceCalculator distancecalculator)
    {
        sDistanceCalculator = distancecalculator;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Beacon))
        {
            return false;
        }
        obj = (Beacon)obj;
        if (mIdentifiers.size() != ((Beacon) (obj)).mIdentifiers.size())
        {
            return false;
        }
        for (int i = 0; i < mIdentifiers.size(); i++)
        {
            if (!((Identifier)mIdentifiers.get(i)).equals(((Beacon) (obj)).mIdentifiers.get(i)))
            {
                return false;
            }
        }

        return true;
    }

    public int getBeaconTypeCode()
    {
        return mBeaconTypeCode;
    }

    public String getBluetoothAddress()
    {
        return mBluetoothAddress;
    }

    public String getBluetoothName()
    {
        return mBluetoothName;
    }

    public List getDataFields()
    {
        return Collections.unmodifiableList(mDataFields);
    }

    public double getDistance()
    {
        if (mDistance == null)
        {
            double d = mRssi;
            if (mRunningAverageRssi != null)
            {
                d = mRunningAverageRssi.doubleValue();
            } else
            {
                LogManager.d("Beacon", "Not using running average RSSI because it is null", new Object[0]);
            }
            mDistance = calculateDistance(mTxPower, d);
        }
        return mDistance.doubleValue();
    }

    public Identifier getId1()
    {
        return (Identifier)mIdentifiers.get(0);
    }

    public Identifier getId2()
    {
        return (Identifier)mIdentifiers.get(1);
    }

    public Identifier getId3()
    {
        return (Identifier)mIdentifiers.get(2);
    }

    public Identifier getIdentifier(int i)
    {
        return (Identifier)mIdentifiers.get(i);
    }

    public List getIdentifiers()
    {
        return Collections.unmodifiableList(mIdentifiers);
    }

    public int getManufacturer()
    {
        return mManufacturer;
    }

    public int getRssi()
    {
        return mRssi;
    }

    public int getServiceUuid()
    {
        return mServiceUuid;
    }

    public int getTxPower()
    {
        return mTxPower;
    }

    public int hashCode()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 1;
        for (Iterator iterator = mIdentifiers.iterator(); iterator.hasNext();)
        {
            Identifier identifier = (Identifier)iterator.next();
            stringbuilder.append("id");
            stringbuilder.append(i);
            stringbuilder.append(": ");
            stringbuilder.append(identifier.toString());
            stringbuilder.append(" ");
            i++;
        }

        return stringbuilder.toString().hashCode();
    }

    public void requestData(BeaconDataNotifier beacondatanotifier)
    {
        beaconDataFactory.requestBeaconData(this, beacondatanotifier);
    }

    public void setRssi(int i)
    {
        mRssi = i;
    }

    public void setRunningAverageRssi(double d)
    {
        mRunningAverageRssi = Double.valueOf(d);
        mDistance = null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 1;
        Iterator iterator = mIdentifiers.iterator();
        while (iterator.hasNext()) 
        {
            Object obj = (Identifier)iterator.next();
            if (i > 1)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append("id");
            stringbuilder.append(i);
            stringbuilder.append(": ");
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = ((Identifier) (obj)).toString();
            }
            stringbuilder.append(((String) (obj)));
            i++;
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mIdentifiers.size());
        LogManager.d("Beacon", "serializing identifiers of size %s", new Object[] {
            Integer.valueOf(mIdentifiers.size())
        });
        Iterator iterator1 = mIdentifiers.iterator();
        while (iterator1.hasNext()) 
        {
            Object obj = (Identifier)iterator1.next();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((Identifier) (obj)).toString();
            }
            parcel.writeString(((String) (obj)));
        }
        parcel.writeDouble(getDistance());
        parcel.writeInt(mRssi);
        parcel.writeInt(mTxPower);
        parcel.writeString(mBluetoothAddress);
        parcel.writeInt(mBeaconTypeCode);
        parcel.writeInt(mServiceUuid);
        parcel.writeInt(mDataFields.size());
        for (Iterator iterator = mDataFields.iterator(); iterator.hasNext(); parcel.writeLong(((Long)iterator.next()).longValue())) { }
        parcel.writeInt(mManufacturer);
        parcel.writeString(mBluetoothName);
    }


    // Unreferenced inner class org/altbeacon/beacon/Beacon$Builder
    /* block-local class not found */
    class Builder {}


    /* member class not found */
    class _cls1 {}

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            DataPointEnvelope

public interface IMetricsService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IMetricsService
    {

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            boolean flag;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.amazon.client.metrics.IMetricsService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.client.metrics.IMetricsService");
                record(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.createTypedArrayList(DataPointEnvelope.CREATOR));
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.amazon.client.metrics.IMetricsService");
                flag = getRecordMetricsSetting();
                parcel1.writeNoException();
                break;
            }
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.client.metrics.IMetricsService");
        }
    }


    public abstract boolean getRecordMetricsSetting()
        throws RemoteException;

    public abstract void record(int i, String s, String s1, long l, List list)
        throws RemoteException;
}

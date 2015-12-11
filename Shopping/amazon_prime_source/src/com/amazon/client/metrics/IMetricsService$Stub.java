// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            IMetricsService, DataPointEnvelope

public static abstract class attachInterface extends Binder
    implements IMetricsService
{
    private static class Proxy
        implements IMetricsService
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.amazon.client.metrics.IMetricsService";
        }

        public boolean getRecordMetricsSetting()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.amazon.client.metrics.IMetricsService");
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i != 0)
            {
                flag = true;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void record(int i, String s, String s1, long l, List list)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.client.metrics.IMetricsService");
            parcel.writeInt(i);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeLong(l);
            parcel.writeTypedList(list);
            mRemote.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            s;
            parcel.recycle();
            throw s;
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    private static final String DESCRIPTOR = "com.amazon.client.metrics.IMetricsService";
    static final int TRANSACTION_getRecordMetricsSetting = 2;
    static final int TRANSACTION_record = 1;

    public static IMetricsService asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.client.metrics.IMetricsService");
        if (iinterface != null && (iinterface instanceof IMetricsService))
        {
            return (IMetricsService)iinterface;
        } else
        {
            return new Proxy(ibinder);
        }
    }

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

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.client.metrics.IMetricsService");
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.ir;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication.ir:
//            ParcelableIRServiceEndpoint

public interface IIdentityResolver
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IIdentityResolver
    {

        static final int TRANSACTION_getEndpointForServiceName = 1;
        static final int TRANSACTION_resolveServiceEndpoint = 2;

        public static IIdentityResolver asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.communication.ir.IIdentityResolver");
            if (iinterface != null && (iinterface instanceof IIdentityResolver))
            {
                return (IIdentityResolver)iinterface;
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
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.amazon.communication.ir.IIdentityResolver");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.communication.ir.IIdentityResolver");
                parcel = getEndpointForServiceName(parcel.readString());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                    return true;
                } else
                {
                    parcel1.writeInt(0);
                    return true;
                }

            case 2: // '\002'
                parcel.enforceInterface("com.amazon.communication.ir.IIdentityResolver");
                parcel = resolveServiceEndpoint(parcel.readString(), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                break;
            }
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
                return true;
            } else
            {
                parcel1.writeInt(0);
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.communication.ir.IIdentityResolver");
        }
    }

    private static class Stub.Proxy
        implements IIdentityResolver
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public ParcelableIRServiceEndpoint getEndpointForServiceName(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.communication.ir.IIdentityResolver");
            parcel.writeString(s);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (ParcelableIRServiceEndpoint)ParcelableIRServiceEndpoint.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public String getInterfaceDescriptor()
        {
            return "com.amazon.communication.ir.IIdentityResolver";
        }

        public ParcelableIRServiceEndpoint resolveServiceEndpoint(String s, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.communication.ir.IIdentityResolver");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (ParcelableIRServiceEndpoint)ParcelableIRServiceEndpoint.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract ParcelableIRServiceEndpoint getEndpointForServiceName(String s)
        throws RemoteException;

    public abstract ParcelableIRServiceEndpoint resolveServiceEndpoint(String s, String s1, String s2)
        throws RemoteException;
}

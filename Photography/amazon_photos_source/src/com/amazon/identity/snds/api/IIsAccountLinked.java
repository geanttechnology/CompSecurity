// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.identity.snds.api:
//            ReturnValueOrError

public interface IIsAccountLinked
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IIsAccountLinked
    {

        public static IIsAccountLinked asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.identity.snds.api.IIsAccountLinked");
            if (iinterface != null && (iinterface instanceof IIsAccountLinked))
            {
                return (IIsAccountLinked)iinterface;
            } else
            {
                return new Proxy(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.amazon.identity.snds.api.IIsAccountLinked");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.identity.snds.api.IIsAccountLinked");
                parcel = isAccountLinked(parcel.readString(), parcel.readInt());
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
    }

    private static class Stub.Proxy
        implements IIsAccountLinked
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public ReturnValueOrError isAccountLinked(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.identity.snds.api.IIsAccountLinked");
            parcel.writeString(s);
            parcel.writeInt(i);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (ReturnValueOrError)ReturnValueOrError.CREATOR.createFromParcel(parcel1);
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


    public abstract ReturnValueOrError isAccountLinked(String s, int i)
        throws RemoteException;
}

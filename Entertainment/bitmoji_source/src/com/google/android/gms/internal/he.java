// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;

// Referenced classes of package com.google.android.gms.internal:
//            hd

public interface he
    extends IInterface
{
    public static abstract class a extends Binder
        implements he
    {

        public static he M(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            if (iinterface != null && (iinterface instanceof he))
            {
                return (he)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            hd hd;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
                hd = com.google.android.gms.internal.hd.a.L(parcel.readStrongBinder());
                break;
            }
            UserAddressRequest useraddressrequest;
            if (parcel.readInt() != 0)
            {
                useraddressrequest = (UserAddressRequest)UserAddressRequest.CREATOR.createFromParcel(parcel);
            } else
            {
                useraddressrequest = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(hd, useraddressrequest, parcel);
            parcel1.writeNoException();
            return true;
        }
    }

    private static class a.a
        implements he
    {

        private IBinder ky;

        public void a(hd hd1, UserAddressRequest useraddressrequest, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
            if (hd1 == null) goto _L2; else goto _L1
_L1:
            hd1 = hd1.asBinder();
_L5:
            parcel.writeStrongBinder(hd1);
            if (useraddressrequest == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            useraddressrequest.writeToParcel(parcel, 0);
_L6:
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_127;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L7:
            ky.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            hd1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            hd1;
            parcel1.recycle();
            parcel.recycle();
            throw hd1;
            parcel.writeInt(0);
              goto _L7
        }

        public IBinder asBinder()
        {
            return ky;
        }

        a.a(IBinder ibinder)
        {
            ky = ibinder;
        }
    }


    public abstract void a(hd hd, UserAddressRequest useraddressrequest, Bundle bundle)
        throws RemoteException;
}

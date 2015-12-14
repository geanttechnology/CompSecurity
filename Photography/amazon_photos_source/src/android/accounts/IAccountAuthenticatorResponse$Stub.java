// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.accounts;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.accounts:
//            IAccountAuthenticatorResponse

public static abstract class attachInterface extends Binder
    implements IAccountAuthenticatorResponse
{

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
            parcel1.writeString("android.accounts.IAccountAuthenticatorResponse");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.(parcel);
            } else
            {
                parcel = null;
            }
            onResult(parcel);
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            onRequestContinued();
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            onError(parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }

    public _cls9()
    {
        attachInterface(this, "android.accounts.IAccountAuthenticatorResponse");
    }
}

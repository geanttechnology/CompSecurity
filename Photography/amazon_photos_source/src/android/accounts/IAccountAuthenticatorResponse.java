// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.accounts;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAccountAuthenticatorResponse
    extends IInterface
{
    public static abstract class Stub extends Binder
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
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
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

        public Stub()
        {
            attachInterface(this, "android.accounts.IAccountAuthenticatorResponse");
        }
    }


    public abstract void onError(int i, String s)
        throws RemoteException;

    public abstract void onRequestContinued()
        throws RemoteException;

    public abstract void onResult(Bundle bundle)
        throws RemoteException;
}

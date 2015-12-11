// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.content.pm:
//            IPackageInstallObserver

public static abstract class attachInterface extends Binder
    implements IPackageInstallObserver
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
            parcel1.writeString("android.content.pm.IPackageInstallObserver");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("android.content.pm.IPackageInstallObserver");
            packageInstalled(parcel.readString(), parcel.readInt());
            return true;
        }
    }

    public ()
    {
        attachInterface(this, "android.content.pm.IPackageInstallObserver");
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.content.pm:
//            IPackageDeleteObserver

public static abstract class attachInterface extends Binder
    implements IPackageDeleteObserver
{

    private boolean isPreIceCreamSandwich()
    {
        return android.os.er.Stub < 14;
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
            parcel1.writeString("android.content.pm.IPackageDeleteObserver");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("android.content.pm.IPackageDeleteObserver");
            break;
        }
        if (isPreIceCreamSandwich())
        {
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            packageDeleted(flag);
            return true;
        } else
        {
            packageDeleted(parcel.readString(), parcel.readInt());
            return true;
        }
    }

    public ()
    {
        attachInterface(this, "android.content.pm.IPackageDeleteObserver");
    }
}

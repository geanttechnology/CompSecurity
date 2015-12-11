// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzap

public static abstract class zza.zznJ extends Binder
    implements zzap
{
    private static class zza
        implements zzap
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zzt(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            int i;
            i = 1;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IEventReleaseCallback");
            if (!flag)
            {
                i = 0;
            }
            parcel.writeInt(i);
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel.recycle();
            throw exception;
        }

        zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static zzap zzaV(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
        if (iinterface != null && (iinterface instanceof zzap))
        {
            return (zzap)iinterface;
        } else
        {
            return new zza(ibinder);
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
            parcel1.writeString("com.google.android.gms.drive.internal.IEventReleaseCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
            break;
        }
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzt(flag);
        return true;
    }
}

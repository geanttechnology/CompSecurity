// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DeleteAllUserDataRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzmy

public static abstract class zza.zznI extends Binder
    implements zzmy
{
    private static class zza
        implements zzmy
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(DeleteAllUserDataRequest deletealluserdatarequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
            if (deletealluserdatarequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            deletealluserdatarequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            deletealluserdatarequest;
            parcel.recycle();
            throw deletealluserdatarequest;
        }

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static zzmy zzbA(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
        if (iinterface != null && (iinterface instanceof zzmy))
        {
            return (zzmy)iinterface;
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
            parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (DeleteAllUserDataRequest)DeleteAllUserDataRequest.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        zza(parcel);
        return true;
    }
}

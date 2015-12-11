// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SyncInfoResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzok

public static abstract class zza.zznJ extends Binder
    implements zzok
{
    private static class zza
        implements zzok
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(SyncInfoResult syncinforesult)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.ISyncInfoCallback");
            if (syncinforesult == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            syncinforesult.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            syncinforesult;
            parcel.recycle();
            throw syncinforesult;
        }

        zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static zzok zzbK(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISyncInfoCallback");
        if (iinterface != null && (iinterface instanceof zzok))
        {
            return (zzok)iinterface;
        } else
        {
            return new zza(ibinder);
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
            parcel1.writeString("com.google.android.gms.fitness.internal.ISyncInfoCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.ISyncInfoCallback");
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (SyncInfoResult)SyncInfoResult.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        zza(parcel);
        return true;
    }
}

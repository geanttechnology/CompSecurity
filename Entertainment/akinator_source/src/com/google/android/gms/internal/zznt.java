// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

public interface zznt
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zznt
    {

        public static zznt zzbt(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
            if (iinterface != null && (iinterface instanceof zznt))
            {
                return (zznt)iinterface;
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
                parcel1.writeString("com.google.android.gms.fitness.internal.IDailyTotalCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (DailyTotalResult)DailyTotalResult.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zza(parcel);
            return true;
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDailyTotalCallback");
        }
    }

    private static class zza.zza
        implements zznt
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(DailyTotalResult dailytotalresult)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IDailyTotalCallback");
            if (dailytotalresult == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            dailytotalresult.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            dailytotalresult;
            parcel.recycle();
            throw dailytotalresult;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(DailyTotalResult dailytotalresult)
        throws RemoteException;
}

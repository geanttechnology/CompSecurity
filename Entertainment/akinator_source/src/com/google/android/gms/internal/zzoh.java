// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

public interface zzoh
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzoh
    {

        public static zzoh zzbH(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
            if (iinterface != null && (iinterface instanceof zzoh))
            {
                return (zzoh)iinterface;
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
                parcel1.writeString("com.google.android.gms.fitness.internal.ISessionReadCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (SessionReadResult)SessionReadResult.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zza(parcel);
            return true;
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionReadCallback");
        }
    }

    private static class zza.zza
        implements zzoh
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(SessionReadResult sessionreadresult)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionReadCallback");
            if (sessionreadresult == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            sessionreadresult.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessionreadresult;
            parcel.recycle();
            throw sessionreadresult;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(SessionReadResult sessionreadresult)
        throws RemoteException;
}

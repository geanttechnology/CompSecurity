// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface zzoi
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzoi
    {

        public static zzoi zzbI(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
            if (iinterface != null && (iinterface instanceof zzoi))
            {
                return (zzoi)iinterface;
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
                parcel1.writeString("com.google.android.gms.fitness.internal.ISessionStopCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (SessionStopResult)SessionStopResult.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zza(parcel);
            return true;
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionStopCallback");
        }
    }

    private static class zza.zza
        implements zzoi
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(SessionStopResult sessionstopresult)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionStopCallback");
            if (sessionstopresult == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            sessionstopresult.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessionstopresult;
            parcel.recycle();
            throw sessionstopresult;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(SessionStopResult sessionstopresult)
        throws RemoteException;
}

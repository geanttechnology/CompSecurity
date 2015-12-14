// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;

public interface zzpu
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzpu
    {

        public static zzpu zzdA(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            if (iinterface != null && (iinterface instanceof zzpu))
            {
                return (zzpu)iinterface;
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
                parcel1.writeString("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                if (parcel.readInt() != 0)
                {
                    parcel1 = (Status)Status.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (AttestationData)AttestationData.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(parcel1, parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                zzel(parcel.readString());
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                if (parcel.readInt() != 0)
                {
                    parcel1 = (Status)Status.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (SafeBrowsingData)SafeBrowsingData.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(parcel1, parcel);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
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
            zzap(flag);
            return true;
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        }
    }

    private static class zza.zza
        implements zzpu
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(Status status, AttestationData attestationdata)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            if (status == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
_L3:
            if (attestationdata == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            parcel.writeInt(1);
            attestationdata.writeToParcel(parcel, 0);
_L4:
            zznI.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            status;
            parcel.recycle();
            throw status;
            parcel.writeInt(0);
              goto _L4
        }

        public void zza(Status status, SafeBrowsingData safebrowsingdata)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            if (status == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
_L3:
            if (safebrowsingdata == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            parcel.writeInt(1);
            safebrowsingdata.writeToParcel(parcel, 0);
_L4:
            zznI.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            status;
            parcel.recycle();
            throw status;
            parcel.writeInt(0);
              goto _L4
        }

        public void zzap(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            int i;
            i = 1;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            if (!flag)
            {
                i = 0;
            }
            parcel.writeInt(i);
            zznI.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel.recycle();
            throw exception;
        }

        public void zzel(String s)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            parcel.writeString(s);
            zznI.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            s;
            parcel.recycle();
            throw s;
        }

        zza.zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public abstract void zza(Status status, AttestationData attestationdata)
        throws RemoteException;

    public abstract void zza(Status status, SafeBrowsingData safebrowsingdata)
        throws RemoteException;

    public abstract void zzap(boolean flag)
        throws RemoteException;

    public abstract void zzel(String s)
        throws RemoteException;
}

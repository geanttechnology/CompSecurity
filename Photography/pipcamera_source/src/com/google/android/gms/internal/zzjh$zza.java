// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzjh

public abstract class zza extends Binder
    implements zzjh
{

    public static zzjh zzan(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
        class zza
            implements zzjh
        {

            private IBinder zznF;

            public IBinder asBinder()
            {
                return zznF;
            }

            public void zzi(Status status)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
                if (status == null)
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
_L1:
                zznF.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                status;
                parcel1.recycle();
                parcel.recycle();
                throw status;
            }

            zza(IBinder ibinder)
            {
                zznF = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzjh))
        {
            return (zzjh)iinterface;
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
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (Status)Status.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        zzi(parcel);
        parcel1.writeNoException();
        return true;
    }
}

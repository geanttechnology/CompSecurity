// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzkd

public abstract class zza extends Binder
    implements zzkd
{

    public static zzkd zzao(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
        class zza
            implements zzkd
        {

            private IBinder zznJ;

            public IBinder asBinder()
            {
                return zznJ;
            }

            public void zza(Account account, int i, zzkc zzkc1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
                if (account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                parcel.writeInt(i);
                if (zzkc1 == null)
                {
                    break MISSING_BLOCK_LABEL_111;
                }
                account = zzkc1.asBinder();
_L4:
                parcel.writeStrongBinder(account);
                zznJ.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                account;
                parcel1.recycle();
                parcel.recycle();
                throw account;
                account = null;
                  goto _L4
            }

            zza(IBinder ibinder)
            {
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzkd))
        {
            return (zzkd)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
            break;
        }
        Account account;
        if (parcel.readInt() != 0)
        {
            account = (Account)Account.CREATOR.createFromParcel(parcel);
        } else
        {
            account = null;
        }
        zza(account, parcel.readInt(), zzan(parcel.readStrongBinder()));
        parcel1.writeNoException();
        return true;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.auth.api.signin.internal:
//            zzd

public abstract class nt extends Binder
    implements zzd
{

    public static zzd zzay(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        class zza
            implements zzd
        {

            private IBinder zznJ;

            public IBinder asBinder()
            {
                return zznJ;
            }

            public void zza(GoogleSignInAccount googlesigninaccount, Status status)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                if (googlesigninaccount == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                googlesigninaccount.writeToParcel(parcel, 0);
_L3:
                if (status == null)
                {
                    break MISSING_BLOCK_LABEL_96;
                }
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
_L4:
                zznJ.transact(101, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                googlesigninaccount;
                parcel1.recycle();
                parcel.recycle();
                throw googlesigninaccount;
                parcel.writeInt(0);
                  goto _L4
            }

            public void zza(Status status, Intent intent)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                if (status == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
_L3:
                if (intent == null)
                {
                    break MISSING_BLOCK_LABEL_95;
                }
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L4:
                zznJ.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                status;
                parcel1.recycle();
                parcel.recycle();
                throw status;
                parcel.writeInt(0);
                  goto _L4
            }

            public void zzk(Status status)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                if (status == null)
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
_L1:
                zznJ.transact(2, parcel, parcel1, 0);
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

            public void zzl(Status status)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                if (status == null)
                {
                    break MISSING_BLOCK_LABEL_57;
                }
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
_L1:
                zznJ.transact(102, parcel, parcel1, 0);
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

            public void zzm(Status status)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                if (status == null)
                {
                    break MISSING_BLOCK_LABEL_57;
                }
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
_L1:
                zznJ.transact(103, parcel, parcel1, 0);
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
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzd))
        {
            return (zzd)iinterface;
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
            parcel1.writeString("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            Status status;
            if (parcel.readInt() != 0)
            {
                status = (Status)Status.CREATOR.createFromParcel(parcel);
            } else
            {
                status = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Intent)Intent.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zza(status, parcel);
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            if (parcel.readInt() != 0)
            {
                parcel = (Status)Status.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zzk(parcel);
            parcel1.writeNoException();
            return true;

        case 101: // 'e'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            GoogleSignInAccount googlesigninaccount;
            if (parcel.readInt() != 0)
            {
                googlesigninaccount = (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(parcel);
            } else
            {
                googlesigninaccount = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Status)Status.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zza(googlesigninaccount, parcel);
            parcel1.writeNoException();
            return true;

        case 102: // 'f'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            if (parcel.readInt() != 0)
            {
                parcel = (Status)Status.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zzl(parcel);
            parcel1.writeNoException();
            return true;

        case 103: // 'g'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (Status)Status.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        zzm(parcel);
        parcel1.writeNoException();
        return true;
    }
}

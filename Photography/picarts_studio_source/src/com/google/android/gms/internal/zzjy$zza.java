// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzjy

public abstract class zza extends Binder
    implements zzjy
{

    public static zzjy zzal(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
        class zza
            implements zzjy
        {

            private IBinder zznJ;

            public IBinder asBinder()
            {
                return zznJ;
            }

            public void zza(zzjx zzjx1, String s)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                if (zzjx1 == null)
                {
                    break MISSING_BLOCK_LABEL_66;
                }
                zzjx1 = zzjx1.asBinder();
_L1:
                parcel.writeStrongBinder(zzjx1);
                parcel.writeString(s);
                zznJ.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                zzjx1 = null;
                  goto _L1
                zzjx1;
                parcel1.recycle();
                parcel.recycle();
                throw zzjx1;
            }

            public void zzb(zzjx zzjx1, String s)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                if (zzjx1 == null)
                {
                    break MISSING_BLOCK_LABEL_66;
                }
                zzjx1 = zzjx1.asBinder();
_L1:
                parcel.writeStrongBinder(zzjx1);
                parcel.writeString(s);
                zznJ.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                zzjx1 = null;
                  goto _L1
                zzjx1;
                parcel1.recycle();
                parcel.recycle();
                throw zzjx1;
            }

            zza(IBinder ibinder)
            {
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzjy))
        {
            return (zzjy)iinterface;
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
            parcel1.writeString("com.google.android.gms.appinvite.internal.IAppInviteService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
            zzb(zzak(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
            zza(zzak(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}

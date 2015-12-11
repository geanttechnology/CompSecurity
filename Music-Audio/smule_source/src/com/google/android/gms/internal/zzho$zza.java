// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzho

public abstract class zza extends Binder
    implements zzho
{

    public static zzho zzZ(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        class zza
            implements zzho
        {

            private IBinder zzlW;

            public IBinder asBinder()
            {
                return zzlW;
            }

            public void zza(zzhn zzhn1)
            {
                IBinder ibinder1;
                Parcel parcel;
                ibinder1 = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                if (zzhn1 == null)
                {
                    break MISSING_BLOCK_LABEL_23;
                }
                ibinder1 = zzhn1.asBinder();
                parcel.writeStrongBinder(ibinder1);
                zzlW.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                zzhn1;
                parcel.recycle();
                throw zzhn1;
            }

            zza(IBinder ibinder)
            {
                zzlW = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzho))
        {
            return (zzho)iinterface;
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
            parcel1.writeString("com.google.android.gms.common.internal.service.ICommonService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
            zza(zzY(parcel.readStrongBinder()));
            return true;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzmd

public abstract class zza extends Binder
    implements zzmd
{

    public static zzmd zzaQ(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        class zza
            implements zzmd
        {

            private IBinder zznJ;

            public IBinder asBinder()
            {
                return zznJ;
            }

            public void zza(zzmc zzmc1)
            {
                IBinder ibinder1;
                Parcel parcel;
                ibinder1 = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                if (zzmc1 == null)
                {
                    break MISSING_BLOCK_LABEL_23;
                }
                ibinder1 = zzmc1.asBinder();
                parcel.writeStrongBinder(ibinder1);
                zznJ.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                zzmc1;
                parcel.recycle();
                throw zzmc1;
            }

            zza(IBinder ibinder)
            {
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzmd))
        {
            return (zzmd)iinterface;
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
            zza(zzaP(parcel.readStrongBinder()));
            return true;
        }
    }
}

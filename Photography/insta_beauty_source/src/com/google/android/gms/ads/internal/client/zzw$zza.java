// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzw

public abstract class zza extends Binder
    implements zzw
{

    public static zzw zzp(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        class zza
            implements zzw
        {

            private IBinder zznF;

            public IBinder asBinder()
            {
                return zznF;
            }

            public IBinder zza(zzd zzd1, int i)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                if (zzd1 == null)
                {
                    break MISSING_BLOCK_LABEL_73;
                }
                zzd1 = zzd1.asBinder();
_L1:
                parcel.writeStrongBinder(zzd1);
                parcel.writeInt(i);
                zznF.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                zzd1 = parcel1.readStrongBinder();
                parcel1.recycle();
                parcel.recycle();
                return zzd1;
                zzd1 = null;
                  goto _L1
                zzd1;
                parcel1.recycle();
                parcel.recycle();
                throw zzd1;
            }

            zza(IBinder ibinder)
            {
                zznF = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzw))
        {
            return (zzw)iinterface;
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
            parcel1.writeString("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            parcel = zza(com.google.android.gms.dynamic.zzbg(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }
}

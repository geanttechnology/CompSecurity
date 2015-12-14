// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzq, zzo, zzp

class zznJ
    implements zzq
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(NativeAdOptionsParcel nativeadoptionsparcel)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        if (nativeadoptionsparcel == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        nativeadoptionsparcel.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        nativeadoptionsparcel;
        parcel1.recycle();
        parcel.recycle();
        throw nativeadoptionsparcel;
    }

    public void zza(zzcw zzcw1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        if (zzcw1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzcw1 = zzcw1.asBinder();
_L1:
        parcel.writeStrongBinder(zzcw1);
        zznJ.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzcw1 = null;
          goto _L1
        zzcw1;
        parcel1.recycle();
        parcel.recycle();
        throw zzcw1;
    }

    public void zza(zzcx zzcx1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        if (zzcx1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzcx1 = zzcx1.asBinder();
_L1:
        parcel.writeStrongBinder(zzcx1);
        zznJ.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzcx1 = null;
          goto _L1
        zzcx1;
        parcel1.recycle();
        parcel.recycle();
        throw zzcx1;
    }

    public void zza(String s, zzcz zzcz1, zzcy zzcy1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        parcel.writeString(s);
        if (zzcz1 == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        s = zzcz1.asBinder();
_L1:
        parcel.writeStrongBinder(s);
        s = obj;
        if (zzcy1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        s = zzcy1.asBinder();
        parcel.writeStrongBinder(s);
        zznJ.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s = null;
          goto _L1
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void zzb(zzo zzo1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        if (zzo1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzo1 = zzo1.asBinder();
_L1:
        parcel.writeStrongBinder(zzo1);
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzo1 = null;
          goto _L1
        zzo1;
        parcel1.recycle();
        parcel.recycle();
        throw zzo1;
    }

    public zzp zzbk()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        zzp zzp;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzp = zznJ(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return zzp;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    ionsParcel(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.oj;
import android.support.v7.ok;
import android.support.v7.ol;
import android.support.v7.om;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzp, zzn, zzo

private static class zznI
    implements zzp
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(oj oj1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        if (oj1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        oj1 = oj1.asBinder();
_L1:
        parcel.writeStrongBinder(oj1);
        zznI.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        oj1 = null;
          goto _L1
        oj1;
        parcel1.recycle();
        parcel.recycle();
        throw oj1;
    }

    public void zza(ok ok1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        if (ok1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        ok1 = ok1.asBinder();
_L1:
        parcel.writeStrongBinder(ok1);
        zznI.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ok1 = null;
          goto _L1
        ok1;
        parcel1.recycle();
        parcel.recycle();
        throw ok1;
    }

    public void zza(NativeAdOptionsParcel nativeadoptionsparcel)
        throws RemoteException
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
        zznI.transact(6, parcel, parcel1, 0);
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

    public void zza(String s, om om1, ol ol1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        parcel.writeString(s);
        if (om1 == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        s = om1.asBinder();
_L1:
        parcel.writeStrongBinder(s);
        s = obj;
        if (ol1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        s = ol1.asBinder();
        parcel.writeStrongBinder(s);
        zznI.transact(5, parcel, parcel1, 0);
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

    public void zzb(zzn zzn1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        if (zzn1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzn1 = zzn1.asBinder();
_L1:
        parcel.writeStrongBinder(zzn1);
        zznI.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzn1 = null;
          goto _L1
        zzn1;
        parcel1.recycle();
        parcel.recycle();
        throw zzn1;
    }

    public zzo zzbk()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        zzo zzo;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        zznI.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzo = zznI(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return zzo;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    ionsParcel(IBinder ibinder)
    {
        zznI = ibinder;
    }
}

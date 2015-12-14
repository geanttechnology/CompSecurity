// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzs, AdSizeParcel, zzn, zzo, 
//            zzu, zzv, zzi, AdRequestParcel

class zznJ
    implements zzs
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void destroy()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String getMediationAdapterClassName()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(18, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean isLoading()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(23, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean isReady()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void pause()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void resume()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void setManualImpressionsEnabled(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        int i;
        i = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (flag)
        {
            i = 1;
        }
        parcel.writeInt(i);
        zznJ.transact(22, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void showInterstitial()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void stopLoading()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void zza(AdSizeParcel adsizeparcel)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (adsizeparcel == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        adsizeparcel.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        adsizeparcel;
        parcel1.recycle();
        parcel.recycle();
        throw adsizeparcel;
    }

    public void zza(zzn zzn1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (zzn1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzn1 = zzn1.asBinder();
_L1:
        parcel.writeStrongBinder(zzn1);
        zznJ.transact(20, parcel, parcel1, 0);
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

    public void zza(zzo zzo1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (zzo1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzo1 = zzo1.asBinder();
_L1:
        parcel.writeStrongBinder(zzo1);
        zznJ.transact(7, parcel, parcel1, 0);
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

    public void zza(zzu zzu1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (zzu1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzu1 = zzu1.asBinder();
_L1:
        parcel.writeStrongBinder(zzu1);
        zznJ.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzu1 = null;
          goto _L1
        zzu1;
        parcel1.recycle();
        parcel.recycle();
        throw zzu1;
    }

    public void zza(zzv zzv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (zzv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzv1 = zzv1.asBinder();
_L1:
        parcel.writeStrongBinder(zzv1);
        zznJ.transact(21, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzv1 = null;
          goto _L1
        zzv1;
        parcel1.recycle();
        parcel.recycle();
        throw zzv1;
    }

    public void zza(zzck zzck1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (zzck1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzck1 = zzck1.asBinder();
_L1:
        parcel.writeStrongBinder(zzck1);
        zznJ.transact(19, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzck1 = null;
          goto _L1
        zzck1;
        parcel1.recycle();
        parcel.recycle();
        throw zzck1;
    }

    public void zza(zzfs zzfs1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (zzfs1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzfs1 = zzfs1.asBinder();
_L1:
        parcel.writeStrongBinder(zzfs1);
        zznJ.transact(14, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzfs1 = null;
          goto _L1
        zzfs1;
        parcel1.recycle();
        parcel.recycle();
        throw zzfs1;
    }

    public void zza(zzfw zzfw1, String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (zzfw1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        zzfw1 = zzfw1.asBinder();
_L1:
        parcel.writeStrongBinder(zzfw1);
        parcel.writeString(s);
        zznJ.transact(15, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzfw1 = null;
          goto _L1
        zzfw1;
        parcel1.recycle();
        parcel.recycle();
        throw zzfw1;
    }

    public zzd zzaM()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        zzd zzd;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzd = com.google.android.gms.dynamic.(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return zzd;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public AdSizeParcel zzaN()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        AdSizeParcel adsizeparcel = AdSizeParcel.CREATOR.zzc(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return adsizeparcel;
_L2:
        adsizeparcel = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void zzaP()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        zznJ.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean zzb(AdRequestParcel adrequestparcel)
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = true;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (adrequestparcel == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        parcel.writeInt(1);
        adrequestparcel.writeToParcel(parcel, 0);
_L1:
        int i;
        zznJ.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i == 0)
        {
            flag = false;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        parcel.writeInt(0);
          goto _L1
        adrequestparcel;
        parcel1.recycle();
        parcel.recycle();
        throw adrequestparcel;
    }

    cel(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}

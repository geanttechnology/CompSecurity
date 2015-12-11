// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.lk;

// Referenced classes of package com.google.android.gms.ads.internal.reward.mediation.client:
//            zza, RewardItemParcel

private static class zznI
    implements zza
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(lk lk1, RewardItemParcel rewarditemparcel)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null) goto _L2; else goto _L1
_L1:
        lk1 = lk1.asBinder();
_L5:
        parcel.writeStrongBinder(lk1);
        if (rewarditemparcel == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        rewarditemparcel.writeToParcel(parcel, 0);
_L6:
        zznI.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        lk1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
          goto _L5
    }

    public void zzb(lk lk1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        parcel.writeInt(i);
        zznI.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public void zzc(lk lk1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        parcel.writeInt(i);
        zznI.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public void zzg(lk lk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        zznI.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public void zzh(lk lk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        zznI.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public void zzi(lk lk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        zznI.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public void zzj(lk lk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        zznI.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public void zzk(lk lk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        zznI.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public void zzl(lk lk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        zznI.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public void zzm(lk lk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        zznI.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    rcel(IBinder ibinder)
    {
        zznI = ibinder;
    }
}

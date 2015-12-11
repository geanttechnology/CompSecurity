// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzfw, zzfv

class zznJ
    implements zzfw
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public boolean isValidPurchase(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = true;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        parcel.writeString(s);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i == 0)
        {
            flag = false;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void zza(zzfv zzfv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if (zzfv1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzfv1 = zzfv1.asBinder();
_L1:
        parcel.writeStrongBinder(zzfv1);
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzfv1 = null;
          goto _L1
        zzfv1;
        parcel1.recycle();
        parcel.recycle();
        throw zzfv1;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.d:
//            em, el

private static final class a
    implements em
{

    private IBinder a;

    public final void a(el el1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (el1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        el1 = el1.asBinder();
_L1:
        parcel.writeStrongBinder(el1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        el1 = null;
          goto _L1
        el1;
        parcel1.recycle();
        parcel.recycle();
        throw el1;
    }

    public final IBinder asBinder()
    {
        return a;
    }

    public (IBinder ibinder)
    {
        a = ibinder;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            ey, eo

final class fa
    implements ey
{

    private IBinder a;

    fa(IBinder ibinder)
    {
        a = ibinder;
    }

    public final void a(eo eo1, String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
        if (eo1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        eo1 = eo1.asBinder();
_L1:
        parcel.writeStrongBinder(eo1);
        parcel.writeString(s);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        eo1 = null;
          goto _L1
        eo1;
        parcel1.recycle();
        parcel.recycle();
        throw eo1;
    }

    public final IBinder asBinder()
    {
        return a;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;

// Referenced classes of package com.google.android.gms.internal:
//            i, x, bn

final class k
    implements i
{

    private IBinder a;

    k(IBinder ibinder)
    {
        a = ibinder;
    }

    public final IBinder a(a a1, x x1, String s, bn bn1, int j)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (a1 == null) goto _L2; else goto _L1
_L1:
        a1 = a1.asBinder();
_L5:
        parcel.writeStrongBinder(a1);
        if (x1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        x1.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        a1 = obj;
        if (bn1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        a1 = bn1.asBinder();
        parcel.writeStrongBinder(a1);
        parcel.writeInt(j);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        a1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return a1;
_L2:
        a1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        a1;
        parcel1.recycle();
        parcel.recycle();
        throw a1;
          goto _L5
    }

    public final IBinder asBinder()
    {
        return a;
    }
}

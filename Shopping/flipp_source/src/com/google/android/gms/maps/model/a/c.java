// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.a;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.j;

// Referenced classes of package com.google.android.gms.maps.model.a:
//            a

final class c
    implements a
{

    private IBinder a;

    c(IBinder ibinder)
    {
        a = ibinder;
    }

    public final Tile a(int i, int k, int l)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        parcel.writeInt(i);
        parcel.writeInt(k);
        parcel.writeInt(l);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = Tile.CREATOR;
        obj = j.a(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return ((Tile) (obj));
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final IBinder asBinder()
    {
        return a;
    }
}

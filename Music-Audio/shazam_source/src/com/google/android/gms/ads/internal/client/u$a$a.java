// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.c;
import com.google.android.gms.d.dg;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            u, AdSizeParcel

private static final class a
    implements u
{

    private IBinder a;

    public final IBinder a(c c1, AdSizeParcel adsizeparcel, String s, dg dg1, int i)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (c1 == null) goto _L2; else goto _L1
_L1:
        c1 = c1.asBinder();
_L5:
        parcel.writeStrongBinder(c1);
        if (adsizeparcel == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        adsizeparcel.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        c1 = obj;
        if (dg1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        c1 = dg1.asBinder();
        parcel.writeStrongBinder(c1);
        parcel.writeInt(i);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        c1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return c1;
_L2:
        c1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        c1;
        parcel1.recycle();
        parcel.recycle();
        throw c1;
          goto _L5
    }

    public final IBinder a(c c1, AdSizeParcel adsizeparcel, String s, dg dg1, int i, int j)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (c1 == null) goto _L2; else goto _L1
_L1:
        c1 = c1.asBinder();
_L5:
        parcel.writeStrongBinder(c1);
        if (adsizeparcel == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        adsizeparcel.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        c1 = obj;
        if (dg1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        c1 = dg1.asBinder();
        parcel.writeStrongBinder(c1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        c1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return c1;
_L2:
        c1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        c1;
        parcel1.recycle();
        parcel.recycle();
        throw c1;
          goto _L5
    }

    public final IBinder asBinder()
    {
        return a;
    }

    Parcel(IBinder ibinder)
    {
        a = ibinder;
    }
}

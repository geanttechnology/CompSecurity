// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.c;

// Referenced classes of package com.google.android.gms.d:
//            bm

public static abstract class a.a extends Binder
    implements bm
{
    private static final class a
        implements bm
    {

        private IBinder a;

        public final IBinder a(c c1, c c2, c c3, int i)
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            if (c1 == null) goto _L2; else goto _L1
_L1:
            c1 = c1.asBinder();
_L5:
            parcel.writeStrongBinder(c1);
            if (c2 == null) goto _L4; else goto _L3
_L3:
            c1 = c2.asBinder();
_L6:
            parcel.writeStrongBinder(c1);
            c1 = obj;
            if (c3 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            c1 = c3.asBinder();
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
            c1 = null;
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

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static bm a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (iinterface != null && (iinterface instanceof bm))
        {
            return (bm)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            parcel = a(com.google.android.gms.b.(parcel.readStrongBinder()), com.google.android.gms.b.(parcel.readStrongBinder()), com.google.android.gms.b.(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }
}

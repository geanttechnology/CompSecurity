// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.c;
import com.google.android.gms.d.dg;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            s

public static abstract class a.a extends Binder
    implements s
{
    private static final class a
        implements s
    {

        private IBinder a;

        public final IBinder a(c c1, String s1, dg dg1, int i)
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            if (c1 == null)
            {
                break MISSING_BLOCK_LABEL_109;
            }
            c1 = c1.asBinder();
_L1:
            parcel.writeStrongBinder(c1);
            parcel.writeString(s1);
            c1 = obj;
            if (dg1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
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
            c1 = null;
              goto _L1
            c1;
            parcel1.recycle();
            parcel.recycle();
            throw c1;
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


    public static s a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (iinterface != null && (iinterface instanceof s))
        {
            return (s)iinterface;
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
            parcel1.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            parcel = a(com.google.android.gms.b.a(parcel.readStrongBinder()), parcel.readString(), com.google.android.gms.d..a(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.d:
//            bu, br

public static abstract class a.a extends Binder
    implements bu
{
    private static final class a
        implements bu
    {

        private IBinder a;

        public final void a(br br1, String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            if (br1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            br1 = br1.asBinder();
_L1:
            parcel.writeStrongBinder(br1);
            parcel.writeString(s);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            br1 = null;
              goto _L1
            br1;
            parcel1.recycle();
            parcel.recycle();
            throw br1;
        }

        public final IBinder asBinder()
        {
            return a;
        }

        public a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            a(a(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}

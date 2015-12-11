// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

class aln
    implements all
{

    private IBinder a;

    aln(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a(aop aop1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
        if (aop1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        aop1 = aop1.asBinder();
_L1:
        parcel.writeStrongBinder(aop1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        aop1 = null;
          goto _L1
        aop1;
        parcel1.recycle();
        parcel.recycle();
        throw aop1;
    }

    public IBinder asBinder()
    {
        return a;
    }
}

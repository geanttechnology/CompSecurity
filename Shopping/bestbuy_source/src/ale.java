// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;

class ale
    implements alc
{

    private IBinder a;

    ale(IBinder ibinder)
    {
        a = ibinder;
    }

    public Bitmap a(aop aop1, int i, int j)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowRenderer");
        if (aop1 == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        aop1 = aop1.asBinder();
_L1:
        parcel.writeStrongBinder(aop1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        aop1 = obj;
        if (parcel1.readInt() != 0)
        {
            aop1 = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel1);
        }
        parcel1.recycle();
        parcel.recycle();
        return aop1;
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

class aqb
    implements apz
{

    private IBinder a;

    aqb(IBinder ibinder)
    {
        a = ibinder;
    }

    public ry a(ry ry1, int i, int j, String s, int k)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        if (ry1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        ry1 = ry1.asBinder();
_L1:
        parcel.writeStrongBinder(ry1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        parcel.writeInt(k);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry1;
        ry1 = null;
          goto _L1
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
    }

    public ry a(ry ry1, int i, int j, String s, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        if (ry1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        ry1 = ry1.asBinder();
_L1:
        parcel.writeStrongBinder(ry1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        parcel.writeString(s1);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry1;
        ry1 = null;
          goto _L1
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
    }

    public IBinder asBinder()
    {
        return a;
    }
}

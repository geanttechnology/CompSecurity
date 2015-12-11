// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ay;

class tv
    implements tt
{

    private IBinder a;

    tv(IBinder ibinder)
    {
        a = ibinder;
    }

    public IBinder a(ry ry1, ay ay1, String s, wd wd1, int i)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        if (ay1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        ay1.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        ry1 = obj;
        if (wd1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ry1 = wd1.asBinder();
        parcel.writeStrongBinder(ry1);
        parcel.writeInt(i);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return ry1;
_L2:
        ry1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
          goto _L5
    }

    public IBinder asBinder()
    {
        return a;
    }
}

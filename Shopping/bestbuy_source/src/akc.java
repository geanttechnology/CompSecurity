// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.internal.y;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

class akc
    implements aka
{

    private IBinder a;

    akc(IBinder ibinder)
    {
        a = ibinder;
    }

    public LatLng a(y y1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
        if (y1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        y1.writeToParcel(parcel, 0);
_L3:
        a.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        y1 = LatLng.CREATOR.a(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return y1;
_L2:
        parcel.writeInt(0);
          goto _L3
        y1;
        parcel1.recycle();
        parcel.recycle();
        throw y1;
        y1 = null;
          goto _L4
    }

    public LatLng a(ry ry1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
        if (ry1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        ry1 = ry1.asBinder();
_L1:
        parcel.writeStrongBinder(ry1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = obj;
        if (parcel1.readInt() != 0)
        {
            ry1 = LatLng.CREATOR.a(parcel1);
        }
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

    public VisibleRegion a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        VisibleRegion visibleregion = VisibleRegion.CREATOR.a(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return visibleregion;
_L2:
        visibleregion = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public ry a(LatLng latlng)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
        if (latlng == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L1:
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        latlng = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return latlng;
        parcel.writeInt(0);
          goto _L1
        latlng;
        parcel1.recycle();
        parcel.recycle();
        throw latlng;
    }

    public IBinder asBinder()
    {
        return a;
    }

    public y b(LatLng latlng)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
        if (latlng == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L3:
        a.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        latlng = y.CREATOR.a(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return latlng;
_L2:
        parcel.writeInt(0);
          goto _L3
        latlng;
        parcel1.recycle();
        parcel.recycle();
        throw latlng;
        latlng = null;
          goto _L4
    }
}

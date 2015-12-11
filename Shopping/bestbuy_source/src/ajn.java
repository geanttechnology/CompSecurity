// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

class ajn
    implements ajl
{

    private IBinder a;

    ajn(IBinder ibinder)
    {
        a = ibinder;
    }

    public ry a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ry ry;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        ry = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public ry a(float f)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ry ry;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        parcel.writeFloat(f);
        a.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        ry = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public ry a(float f, float f1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ry ry;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        parcel.writeFloat(f);
        parcel.writeFloat(f1);
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        ry = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public ry a(float f, int i, int j)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ry ry;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        parcel.writeFloat(f);
        parcel.writeInt(i);
        parcel.writeInt(j);
        a.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        ry = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public ry a(CameraPosition cameraposition)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (cameraposition == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        cameraposition.writeToParcel(parcel, 0);
_L1:
        a.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        cameraposition = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return cameraposition;
        parcel.writeInt(0);
          goto _L1
        cameraposition;
        parcel1.recycle();
        parcel.recycle();
        throw cameraposition;
    }

    public ry a(LatLng latlng)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (latlng == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L1:
        a.transact(8, parcel, parcel1, 0);
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

    public ry a(LatLng latlng, float f)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (latlng == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L1:
        parcel.writeFloat(f);
        a.transact(9, parcel, parcel1, 0);
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

    public ry a(LatLngBounds latlngbounds, int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (latlngbounds == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        parcel.writeInt(1);
        latlngbounds.writeToParcel(parcel, 0);
_L1:
        parcel.writeInt(i);
        a.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        latlngbounds = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return latlngbounds;
        parcel.writeInt(0);
          goto _L1
        latlngbounds;
        parcel1.recycle();
        parcel.recycle();
        throw latlngbounds;
    }

    public ry a(LatLngBounds latlngbounds, int i, int j, int k)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (latlngbounds == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        parcel.writeInt(1);
        latlngbounds.writeToParcel(parcel, 0);
_L1:
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeInt(k);
        a.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        latlngbounds = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return latlngbounds;
        parcel.writeInt(0);
          goto _L1
        latlngbounds;
        parcel1.recycle();
        parcel.recycle();
        throw latlngbounds;
    }

    public IBinder asBinder()
    {
        return a;
    }

    public ry b()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ry ry;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        ry = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public ry b(float f)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ry ry;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        parcel.writeFloat(f);
        a.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        ry = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

class aoi
    implements aog
{

    private IBinder a;

    aoi(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(double d1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        parcel.writeDouble(d1);
        a.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(float f1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        parcel.writeFloat(f1);
        a.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(int k)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        parcel.writeInt(k);
        a.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(LatLng latlng)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        if (latlng == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L1:
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        latlng;
        parcel1.recycle();
        parcel.recycle();
        throw latlng;
    }

    public void a(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        int k;
        k = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        if (flag)
        {
            k = 1;
        }
        parcel.writeInt(k);
        a.transact(15, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean a(aog aog1)
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        if (aog1 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        aog1 = aog1.asBinder();
_L1:
        int k;
        parcel.writeStrongBinder(aog1);
        a.transact(17, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        if (k != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        aog1 = null;
          goto _L1
        aog1;
        parcel1.recycle();
        parcel.recycle();
        throw aog1;
    }

    public IBinder asBinder()
    {
        return a;
    }

    public String b()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void b(float f1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        parcel.writeFloat(f1);
        a.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void b(int k)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        parcel.writeInt(k);
        a.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public LatLng c()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        LatLng latlng = LatLng.CREATOR.a(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return latlng;
_L2:
        latlng = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public double d()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        double d1;
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        d1 = parcel1.readDouble();
        parcel1.recycle();
        parcel.recycle();
        return d1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public float e()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        float f1;
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        f1 = parcel1.readFloat();
        parcel1.recycle();
        parcel.recycle();
        return f1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int f()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int k;
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return k;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int g()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int k;
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return k;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public float h()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        float f1;
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(14, parcel, parcel1, 0);
        parcel1.readException();
        f1 = parcel1.readFloat();
        parcel1.recycle();
        parcel.recycle();
        return f1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean i()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int k;
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(16, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        if (k != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int j()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int k;
        parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a.transact(18, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return k;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }
}

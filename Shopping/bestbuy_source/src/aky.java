// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

class aky
    implements akw
{

    private IBinder a;

    aky(IBinder ibinder)
    {
        a = ibinder;
    }

    public ajl a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ajl ajl;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
        a.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        ajl = ajm.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ajl;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public ajx a(ry ry1, GoogleMapOptions googlemapoptions)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        if (googlemapoptions == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        googlemapoptions.writeToParcel(parcel, 0);
_L6:
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = ajy.a(parcel1.readStrongBinder());
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

    public akj a(ry ry1, StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        if (streetviewpanoramaoptions == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        streetviewpanoramaoptions.writeToParcel(parcel, 0);
_L6:
        a.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = akk.a(parcel1.readStrongBinder());
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

    public void a(ry ry1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
        if (ry1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        ry1 = ry1.asBinder();
_L1:
        parcel.writeStrongBinder(ry1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ry1 = null;
          goto _L1
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
    }

    public void a(ry ry1, int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
        if (ry1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ry1 = ry1.asBinder();
_L1:
        parcel.writeStrongBinder(ry1);
        parcel.writeInt(i);
        a.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
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

    public aju b(ry ry1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
        if (ry1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        ry1 = ry1.asBinder();
_L1:
        parcel.writeStrongBinder(ry1);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = ajv.a(parcel1.readStrongBinder());
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

    public aod b()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        aod aod;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
        a.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        aod = aoe.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return aod;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public akg c(ry ry1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
        if (ry1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ry1 = ry1.asBinder();
_L1:
        parcel.writeStrongBinder(ry1);
        a.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = akh.a(parcel1.readStrongBinder());
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
}

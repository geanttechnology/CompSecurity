// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.gms.maps.model.j;
import com.google.android.gms.maps.model.u;

// Referenced classes of package com.google.android.gms.maps.a:
//            f

public static abstract class a.a extends Binder
    implements f
{
    private static final class a
        implements f
    {

        private IBinder a;

        public final c a(LatLng latlng)
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
            latlng = com.google.android.gms.b.c.a.a(parcel1.readStrongBinder());
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

        public final LatLng a(c c1)
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (c1 == null)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            c1 = c1.asBinder();
_L1:
            parcel.writeStrongBinder(c1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            c1 = obj;
            if (parcel1.readInt() != 0)
            {
                c1 = LatLng.CREATOR;
                c1 = j.a(parcel1);
            }
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

        public final VisibleRegion a()
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
            Object obj;
            obj = VisibleRegion.CREATOR;
            obj = u.a(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return ((VisibleRegion) (obj));
_L2:
            obj = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
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


    public static f a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
        if (iinterface != null && (iinterface instanceof f))
        {
            return (f)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int k)
    {
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, k);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            parcel = a(com.google.android.gms.b.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            c c1;
            if (parcel.readInt() != 0)
            {
                j j1 = LatLng.CREATOR;
                parcel = j.a(parcel);
            } else
            {
                parcel = null;
            }
            c1 = a(parcel);
            parcel1.writeNoException();
            parcel = obj;
            if (c1 != null)
            {
                parcel = c1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            parcel = a();
            parcel1.writeNoException();
            break;
        }
        if (parcel != null)
        {
            parcel1.writeInt(1);
            parcel.writeToParcel(parcel1, 1);
        } else
        {
            parcel1.writeInt(0);
        }
        return true;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public abstract class ake extends Binder
    implements akd
{

    public static akd a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (iinterface != null && (iinterface instanceof akd))
        {
            return (akd)iinterface;
        } else
        {
            return new akf(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj1 = null;
        Object obj = null;
        ry ry1 = null;
        boolean flag12 = false;
        boolean flag13 = false;
        boolean flag14 = false;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (parcel.readInt() != 0)
            {
                flag4 = true;
            }
            a(flag4);
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag5 = flag12;
            if (parcel.readInt() != 0)
            {
                flag5 = true;
            }
            b(flag5);
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag6 = flag13;
            if (parcel.readInt() != 0)
            {
                flag6 = true;
            }
            c(flag6);
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag7 = flag14;
            if (parcel.readInt() != 0)
            {
                flag7 = true;
            }
            d(flag7);
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag8 = a();
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag9 = b();
            parcel1.writeNoException();
            i = ((flag1) ? 1 : 0);
            if (flag9)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag10 = c();
            parcel1.writeNoException();
            i = ((flag2) ? 1 : 0);
            if (flag10)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag11 = d();
            parcel1.writeNoException();
            i = ((flag3) ? 1 : 0);
            if (flag11)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (parcel.readInt() != 0)
            {
                obj = StreetViewPanoramaCamera.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            a(((StreetViewPanoramaCamera) (obj)), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            parcel = e();
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
                return true;
            } else
            {
                parcel1.writeInt(0);
                return true;
            }

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a(parcel.readString());
            parcel1.writeNoException();
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            obj = ry1;
            if (parcel.readInt() != 0)
            {
                obj = LatLng.CREATOR.a(parcel);
            }
            a(((LatLng) (obj)));
            parcel1.writeNoException();
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = LatLng.CREATOR.a(parcel);
            }
            a(((LatLng) (obj)), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            parcel = f();
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
                return true;
            } else
            {
                parcel1.writeInt(0);
                return true;
            }

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a(amt.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a(amq.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a(amw.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            parcel = a(rz.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
                return true;
            } else
            {
                parcel1.writeInt(0);
                return true;
            }

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = StreetViewPanoramaOrientation.CREATOR.a(parcel);
        } else
        {
            parcel = null;
        }
        ry1 = a(parcel);
        parcel1.writeNoException();
        parcel = ((Parcel) (obj));
        if (ry1 != null)
        {
            parcel = ry1.asBinder();
        }
        parcel1.writeStrongBinder(parcel);
        return true;
    }
}

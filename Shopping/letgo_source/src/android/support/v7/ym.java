// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.g;
import com.google.android.gms.maps.model.j;
import com.google.android.gms.maps.model.k;

// Referenced classes of package android.support.v7:
//            lk

public interface ym
    extends IInterface
{
    public static abstract class a extends Binder
        implements ym
    {

        public static ym a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if (iinterface != null && (iinterface instanceof ym))
            {
                return (ym)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int l)
            throws RemoteException
        {
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            Object obj9 = null;
            Object obj = null;
            lk lk1 = null;
            Object obj1 = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, l);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                obj = a();
                parcel1.writeNoException();
                parcel = obj4;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                obj = b();
                parcel1.writeNoException();
                parcel = obj5;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                obj = a(parcel.readFloat(), parcel.readFloat());
                parcel1.writeNoException();
                parcel = obj6;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                obj = a(parcel.readFloat());
                parcel1.writeNoException();
                parcel = obj7;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                obj = b(parcel.readFloat());
                parcel1.writeNoException();
                parcel = obj8;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                obj = a(parcel.readFloat(), parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                parcel = obj9;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                if (parcel.readInt() != 0)
                {
                    parcel = CameraPosition.CREATOR.a(parcel);
                } else
                {
                    parcel = null;
                }
                lk1 = a(parcel);
                parcel1.writeNoException();
                parcel = ((Parcel) (obj));
                if (lk1 != null)
                {
                    parcel = lk1.asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                if (parcel.readInt() != 0)
                {
                    parcel = LatLng.CREATOR.a(parcel);
                } else
                {
                    parcel = null;
                }
                obj = a(parcel);
                parcel1.writeNoException();
                parcel = lk1;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                if (parcel.readInt() != 0)
                {
                    obj = LatLng.CREATOR.a(parcel);
                } else
                {
                    obj = null;
                }
                obj = a(((LatLng) (obj)), parcel.readFloat());
                parcel1.writeNoException();
                parcel = obj1;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                if (parcel.readInt() != 0)
                {
                    obj = LatLngBounds.CREATOR.a(parcel);
                } else
                {
                    obj = null;
                }
                obj = a(((LatLngBounds) (obj)), parcel.readInt());
                parcel1.writeNoException();
                parcel = obj2;
                if (obj != null)
                {
                    parcel = ((lk) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = LatLngBounds.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            obj = a(((LatLngBounds) (obj)), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel = obj3;
            if (obj != null)
            {
                parcel = ((lk) (obj)).asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }

    private static class a.a
        implements ym
    {

        private IBinder a;

        public lk a()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            lk lk;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            lk = android.support.v7.lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public lk a(float f)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            lk lk;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            parcel.writeFloat(f);
            a.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            lk = android.support.v7.lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public lk a(float f, float f1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            lk lk;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            parcel.writeFloat(f);
            parcel.writeFloat(f1);
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            lk = android.support.v7.lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public lk a(float f, int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            lk lk;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            parcel.writeFloat(f);
            parcel.writeInt(i);
            parcel.writeInt(j);
            a.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            lk = android.support.v7.lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public lk a(CameraPosition cameraposition)
            throws RemoteException
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
            cameraposition = lk.a.a(parcel1.readStrongBinder());
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

        public lk a(LatLng latlng)
            throws RemoteException
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
            latlng = lk.a.a(parcel1.readStrongBinder());
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

        public lk a(LatLng latlng, float f)
            throws RemoteException
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
            latlng = lk.a.a(parcel1.readStrongBinder());
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

        public lk a(LatLngBounds latlngbounds, int i)
            throws RemoteException
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
            latlngbounds = lk.a.a(parcel1.readStrongBinder());
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

        public lk a(LatLngBounds latlngbounds, int i, int j, int k)
            throws RemoteException
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
            latlngbounds = lk.a.a(parcel1.readStrongBinder());
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

        public lk b()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            lk lk;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            lk = android.support.v7.lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public lk b(float f)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            lk lk;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            parcel.writeFloat(f);
            a.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            lk = android.support.v7.lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract lk a()
        throws RemoteException;

    public abstract lk a(float f)
        throws RemoteException;

    public abstract lk a(float f, float f1)
        throws RemoteException;

    public abstract lk a(float f, int i, int j)
        throws RemoteException;

    public abstract lk a(CameraPosition cameraposition)
        throws RemoteException;

    public abstract lk a(LatLng latlng)
        throws RemoteException;

    public abstract lk a(LatLng latlng, float f)
        throws RemoteException;

    public abstract lk a(LatLngBounds latlngbounds, int i)
        throws RemoteException;

    public abstract lk a(LatLngBounds latlngbounds, int i, int j, int k)
        throws RemoteException;

    public abstract lk b()
        throws RemoteException;

    public abstract lk b(float f)
        throws RemoteException;
}

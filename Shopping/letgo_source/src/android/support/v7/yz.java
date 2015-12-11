// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.h;
import com.google.android.gms.maps.i;

// Referenced classes of package android.support.v7:
//            ym, lk, yq, yu, 
//            yp, zx, yt

public interface yz
    extends IInterface
{
    public static abstract class a extends Binder
        implements yz
    {

        public static yz a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            if (iinterface != null && (iinterface instanceof yz))
            {
                return (yz)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int j, Parcel parcel, Parcel parcel1, int k)
            throws RemoteException
        {
            Object obj = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj1 = null;
            Object obj5 = null;
            Object obj2 = null;
            switch (j)
            {
            default:
                return super.onTransact(j, parcel, parcel1, k);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.ICreator");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                a(lk.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                obj = b(lk.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                parcel = obj2;
                if (obj != null)
                {
                    parcel = ((yp) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                obj1 = lk.a.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    parcel = GoogleMapOptions.CREATOR.a(parcel);
                } else
                {
                    parcel = null;
                }
                obj1 = a(((lk) (obj1)), parcel);
                parcel1.writeNoException();
                parcel = ((Parcel) (obj));
                if (obj1 != null)
                {
                    parcel = ((yq) (obj1)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                obj = a();
                parcel1.writeNoException();
                parcel = obj3;
                if (obj != null)
                {
                    parcel = ((ym) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                obj = b();
                parcel1.writeNoException();
                parcel = obj4;
                if (obj != null)
                {
                    parcel = ((zx) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                a(lk.a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                obj = lk.a.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    parcel = StreetViewPanoramaOptions.CREATOR.a(parcel);
                } else
                {
                    parcel = null;
                }
                obj = a(((lk) (obj)), parcel);
                parcel1.writeNoException();
                parcel = ((Parcel) (obj1));
                if (obj != null)
                {
                    parcel = ((yu) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                obj = c(lk.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                parcel = obj5;
                break;
            }
            if (obj != null)
            {
                parcel = ((yt) (obj)).asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }

    private static class a.a
        implements yz
    {

        private IBinder a;

        public ym a()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            ym ym;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            a.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            ym = android.support.v7.ym.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return ym;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public yq a(lk lk1, GoogleMapOptions googlemapoptions)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (googlemapoptions == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            googlemapoptions.writeToParcel(parcel, 0);
_L6:
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            lk1 = yq.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk1;
_L2:
            lk1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
              goto _L5
        }

        public yu a(lk lk1, StreetViewPanoramaOptions streetviewpanoramaoptions)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (streetviewpanoramaoptions == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            streetviewpanoramaoptions.writeToParcel(parcel, 0);
_L6:
            a.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            lk1 = yu.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk1;
_L2:
            lk1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
              goto _L5
        }

        public void a(lk lk1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (lk1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            lk1 = lk1.asBinder();
_L1:
            parcel.writeStrongBinder(lk1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            lk1 = null;
              goto _L1
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
        }

        public void a(lk lk1, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (lk1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            lk1 = lk1.asBinder();
_L1:
            parcel.writeStrongBinder(lk1);
            parcel.writeInt(i);
            a.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            lk1 = null;
              goto _L1
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
        }

        public IBinder asBinder()
        {
            return a;
        }

        public yp b(lk lk1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (lk1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            lk1 = lk1.asBinder();
_L1:
            parcel.writeStrongBinder(lk1);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            lk1 = yp.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk1;
            lk1 = null;
              goto _L1
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
        }

        public zx b()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            zx zx;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            a.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            zx = android.support.v7.zx.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return zx;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public yt c(lk lk1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (lk1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            lk1 = lk1.asBinder();
_L1:
            parcel.writeStrongBinder(lk1);
            a.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            lk1 = yt.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk1;
            lk1 = null;
              goto _L1
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract ym a()
        throws RemoteException;

    public abstract yq a(lk lk, GoogleMapOptions googlemapoptions)
        throws RemoteException;

    public abstract yu a(lk lk, StreetViewPanoramaOptions streetviewpanoramaoptions)
        throws RemoteException;

    public abstract void a(lk lk)
        throws RemoteException;

    public abstract void a(lk lk, int i)
        throws RemoteException;

    public abstract yp b(lk lk)
        throws RemoteException;

    public abstract zx b()
        throws RemoteException;

    public abstract yt c(lk lk)
        throws RemoteException;
}

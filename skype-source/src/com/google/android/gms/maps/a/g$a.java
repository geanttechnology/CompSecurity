// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.b.c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.i;
import com.google.android.gms.maps.model.n;
import com.google.android.gms.maps.model.p;
import com.google.android.gms.maps.model.q;

// Referenced classes of package com.google.android.gms.maps.a:
//            g, ae, ad, af, 
//            ag

public static abstract class a.a extends Binder
    implements g
{
    private static final class a
        implements g
    {

        private IBinder a;

        public final c a(StreetViewPanoramaOrientation streetviewpanoramaorientation)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (streetviewpanoramaorientation == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            parcel.writeInt(1);
            streetviewpanoramaorientation.writeToParcel(parcel, 0);
_L1:
            a.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            streetviewpanoramaorientation = com.google.android.gms.b.c.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return streetviewpanoramaorientation;
            parcel.writeInt(0);
              goto _L1
            streetviewpanoramaorientation;
            parcel1.recycle();
            parcel.recycle();
            throw streetviewpanoramaorientation;
        }

        public final StreetViewPanoramaOrientation a(c c1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (c1 == null)
            {
                break MISSING_BLOCK_LABEL_85;
            }
            c1 = c1.asBinder();
_L1:
            parcel.writeStrongBinder(c1);
            a.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            c1 = obj;
            if (parcel1.readInt() != 0)
            {
                c1 = StreetViewPanoramaOrientation.CREATOR;
                c1 = q.a(parcel1);
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

        public final void a(ad ad1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (ad1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            ad1 = ad1.asBinder();
_L1:
            parcel.writeStrongBinder(ad1);
            a.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ad1 = null;
              goto _L1
            ad1;
            parcel1.recycle();
            parcel.recycle();
            throw ad1;
        }

        public final void a(ae ae1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (ae1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            ae1 = ae1.asBinder();
_L1:
            parcel.writeStrongBinder(ae1);
            a.transact(15, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ae1 = null;
              goto _L1
            ae1;
            parcel1.recycle();
            parcel.recycle();
            throw ae1;
        }

        public final void a(af af1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (af1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            af1 = af1.asBinder();
_L1:
            parcel.writeStrongBinder(af1);
            a.transact(17, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            af1 = null;
              goto _L1
            af1;
            parcel1.recycle();
            parcel.recycle();
            throw af1;
        }

        public final void a(ag ag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (ag1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            ag1 = ag1.asBinder();
_L1:
            parcel.writeStrongBinder(ag1);
            a.transact(20, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ag1 = null;
              goto _L1
            ag1;
            parcel1.recycle();
            parcel.recycle();
            throw ag1;
        }

        public final void a(LatLng latlng)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (latlng == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            latlng.writeToParcel(parcel, 0);
_L1:
            a.transact(12, parcel, parcel1, 0);
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

        public final void a(LatLng latlng, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (latlng == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            parcel.writeInt(1);
            latlng.writeToParcel(parcel, 0);
_L1:
            parcel.writeInt(j);
            a.transact(13, parcel, parcel1, 0);
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

        public final void a(StreetViewPanoramaCamera streetviewpanoramacamera, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (streetviewpanoramacamera == null)
            {
                break MISSING_BLOCK_LABEL_73;
            }
            parcel.writeInt(1);
            streetviewpanoramacamera.writeToParcel(parcel, 0);
_L1:
            parcel.writeLong(l);
            a.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            streetviewpanoramacamera;
            parcel1.recycle();
            parcel.recycle();
            throw streetviewpanoramacamera;
        }

        public final void a(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            parcel.writeString(s);
            a.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public final void a(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int j;
            j = 1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (!flag)
            {
                j = 0;
            }
            parcel.writeInt(j);
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

        public final boolean a()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int j;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            j = parcel1.readInt();
            if (j != 0)
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

        public final IBinder asBinder()
        {
            return a;
        }

        public final void b(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int j;
            j = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (flag)
            {
                j = 1;
            }
            parcel.writeInt(j);
            a.transact(2, parcel, parcel1, 0);
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

        public final boolean b()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int j;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            j = parcel1.readInt();
            if (j != 0)
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

        public final void c(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int j;
            j = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (flag)
            {
                j = 1;
            }
            parcel.writeInt(j);
            a.transact(3, parcel, parcel1, 0);
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

        public final boolean c()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int j;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            j = parcel1.readInt();
            if (j != 0)
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

        public final void d(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int j;
            j = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (flag)
            {
                j = 1;
            }
            parcel.writeInt(j);
            a.transact(4, parcel, parcel1, 0);
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

        public final boolean d()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int j;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            j = parcel1.readInt();
            if (j != 0)
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

        public final StreetViewPanoramaCamera e()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Object obj;
            obj = StreetViewPanoramaCamera.CREATOR;
            obj = n.a(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return ((StreetViewPanoramaCamera) (obj));
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

        public final StreetViewPanoramaLocation f()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Object obj;
            obj = StreetViewPanoramaLocation.CREATOR;
            obj = p.a(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return ((StreetViewPanoramaLocation) (obj));
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

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static g a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (iinterface != null && (iinterface instanceof g))
        {
            return (g)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int j, Parcel parcel, Parcel parcel1, int k)
        throws RemoteException
    {
        Object obj6 = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj = null;
        Object obj4 = null;
        Object obj5 = null;
        boolean flag12 = false;
        boolean flag13 = false;
        boolean flag14 = false;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        switch (j)
        {
        default:
            return super.onTransact(j, parcel, parcel1, k);

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
            j = ((flag) ? 1 : 0);
            if (flag8)
            {
                j = 1;
            }
            parcel1.writeInt(j);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag9 = b();
            parcel1.writeNoException();
            j = ((flag1) ? 1 : 0);
            if (flag9)
            {
                j = 1;
            }
            parcel1.writeInt(j);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag10 = c();
            parcel1.writeNoException();
            j = ((flag2) ? 1 : 0);
            if (flag10)
            {
                j = 1;
            }
            parcel1.writeInt(j);
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean flag11 = d();
            parcel1.writeNoException();
            j = ((flag3) ? 1 : 0);
            if (flag11)
            {
                j = 1;
            }
            parcel1.writeInt(j);
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (parcel.readInt() != 0)
            {
                obj = StreetViewPanoramaCamera.CREATOR;
                obj = n.a(parcel);
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
            obj = obj5;
            if (parcel.readInt() != 0)
            {
                obj = LatLng.CREATOR;
                obj = i.a(parcel);
            }
            a(((LatLng) (obj)));
            parcel1.writeNoException();
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            obj = obj6;
            if (parcel.readInt() != 0)
            {
                obj = LatLng.CREATOR;
                obj = i.a(parcel);
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
            parcel = parcel.readStrongBinder();
            if (parcel == null)
            {
                parcel = obj1;
            } else
            {
                obj = parcel.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
                if (obj != null && (obj instanceof ae))
                {
                    parcel = (ae)obj;
                } else
                {
                    parcel = new .a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            parcel = parcel.readStrongBinder();
            if (parcel == null)
            {
                parcel = obj2;
            } else
            {
                obj = parcel.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                if (obj != null && (obj instanceof ad))
                {
                    parcel = (ad)obj;
                } else
                {
                    parcel = new .a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            parcel = parcel.readStrongBinder();
            if (parcel == null)
            {
                parcel = obj3;
            } else
            {
                obj = parcel.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                if (obj != null && (obj instanceof af))
                {
                    parcel = (af)obj;
                } else
                {
                    parcel = new .a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            parcel = a(com.google.android.gms.b.a(parcel.readStrongBinder()));
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
            c c1;
            if (parcel.readInt() != 0)
            {
                q q1 = StreetViewPanoramaOrientation.CREATOR;
                parcel = q.a(parcel);
            } else
            {
                parcel = null;
            }
            c1 = a(parcel);
            parcel1.writeNoException();
            parcel = ((Parcel) (obj));
            if (c1 != null)
            {
                parcel = c1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 20: // '\024'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            parcel = parcel.readStrongBinder();
            break;
        }
        if (parcel == null)
        {
            parcel = obj4;
        } else
        {
            android.os.IInterface iinterface = parcel.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaLongClickListener");
            if (iinterface != null && (iinterface instanceof ag))
            {
                parcel = (ag)iinterface;
            } else
            {
                parcel = new .a(parcel);
            }
        }
        a(parcel);
        parcel1.writeNoException();
        return true;
    }
}

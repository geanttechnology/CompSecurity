// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationRequestCreator;
import com.google.android.gms.location.a;
import com.google.android.gms.location.b;
import com.google.android.gms.location.c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBoundsCreator;
import com.google.android.gms.maps.model.LatLngCreator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            hf, hn, id, hv, 
//            hp, hr, hj, ho, 
//            ie, hs, hq

public interface hg
    extends IInterface
{
    public static abstract class a extends Binder
        implements hg
    {

        public static hg P(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (iinterface != null && (iinterface instanceof hg))
            {
                return (hg)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            boolean flag2 = false;
            boolean flag = false;
            Object obj8 = null;
            Object obj9 = null;
            Object obj10 = null;
            Object obj11 = null;
            Object obj1 = null;
            Object obj12 = null;
            Object obj13 = null;
            Object obj6 = null;
            id id3 = null;
            Object obj3 = null;
            Object obj7 = null;
            Object obj2 = null;
            Object obj4 = null;
            Object obj14 = null;
            Object obj = null;
            Object obj15 = null;
            Object obj5 = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj1 = parcel.createTypedArrayList(hj.CREATOR);
                obj = obj5;
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                }
                a(((List) (obj1)), ((PendingIntent) (obj)), hf.a.O(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj8;
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                }
                a(((PendingIntent) (obj)), hf.a.O(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                a(parcel.createStringArray(), hf.a.O(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                a(hf.a.O(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                long l = parcel.readLong();
                if (parcel.readInt() != 0)
                {
                    flag = true;
                }
                obj = obj9;
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                }
                a(l, flag, ((PendingIntent) (obj)));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj10;
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                }
                removeActivityUpdates(((PendingIntent) (obj)));
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = gk();
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

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj11;
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequest.CREATOR.createFromParcel(parcel);
                }
                a(((LocationRequest) (obj)), com.google.android.gms.location.a.a.N(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequest.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                }
                a(((LocationRequest) (obj)), ((PendingIntent) (obj1)));
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                a(com.google.android.gms.location.a.a.N(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj12;
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                }
                a(((PendingIntent) (obj)));
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                boolean flag1 = flag2;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                setMockMode(flag1);
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj13;
                if (parcel.readInt() != 0)
                {
                    obj = (Location)Location.CREATOR.createFromParcel(parcel);
                }
                setMockLocation(((Location) (obj)));
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                hn hn1;
                if (parcel.readInt() != 0)
                {
                    obj = LatLngBounds.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                i = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    hn1 = hn.CREATOR.aw(parcel);
                } else
                {
                    hn1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    id3 = id.CREATOR.aD(parcel);
                } else
                {
                    id3 = null;
                }
                a(((LatLngBounds) (obj)), i, hn1, id3, hv.a.R(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 15: // '\017'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                String s = parcel.readString();
                obj = obj6;
                if (parcel.readInt() != 0)
                {
                    obj = id.CREATOR.aD(parcel);
                }
                a(s, ((id) (obj)), hv.a.R(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                hn hn2;
                if (parcel.readInt() != 0)
                {
                    obj = LatLng.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    hn2 = hn.CREATOR.aw(parcel);
                } else
                {
                    hn2 = null;
                }
                if (parcel.readInt() != 0)
                {
                    id3 = id.CREATOR.aD(parcel);
                }
                a(((LatLng) (obj)), hn2, id3, hv.a.R(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 17: // '\021'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                id id1;
                if (parcel.readInt() != 0)
                {
                    obj = hn.CREATOR.aw(parcel);
                } else
                {
                    obj = null;
                }
                id1 = obj3;
                if (parcel.readInt() != 0)
                {
                    id1 = id.CREATOR.aD(parcel);
                }
                a(((hn) (obj)), id1, hv.a.R(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 42: // '*'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                String s1 = parcel.readString();
                obj = obj7;
                if (parcel.readInt() != 0)
                {
                    obj = id.CREATOR.aD(parcel);
                }
                b(s1, ((id) (obj)), hv.a.R(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 18: // '\022'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                id id2;
                PendingIntent pendingintent1;
                if (parcel.readInt() != 0)
                {
                    obj = hr.CREATOR.ay(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    id2 = id.CREATOR.aD(parcel);
                } else
                {
                    id2 = null;
                }
                pendingintent1 = obj2;
                if (parcel.readInt() != 0)
                {
                    pendingintent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                }
                a(((hr) (obj)), id2, pendingintent1);
                parcel1.writeNoException();
                return true;

            case 19: // '\023'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingintent;
                if (parcel.readInt() != 0)
                {
                    obj = id.CREATOR.aD(parcel);
                } else
                {
                    obj = null;
                }
                pendingintent = obj4;
                if (parcel.readInt() != 0)
                {
                    pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                }
                a(((id) (obj)), pendingintent);
                parcel1.writeNoException();
                return true;

            case 20: // '\024'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj14;
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequest.CREATOR.createFromParcel(parcel);
                }
                a(((LocationRequest) (obj)), com.google.android.gms.location.a.a.N(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 21: // '\025'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = aF(parcel.readString());
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

            case 24: // '\030'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                a(parcel.createTypedArrayList(hx.a.CREATOR));
                return true;

            case 25: // '\031'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = hp.CREATOR.ax(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = id.CREATOR.aD(parcel);
                }
                a(parcel1, ((id) (obj)));
                return true;

            case 26: // '\032'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Location location = obj15;
                if (parcel.readInt() != 0)
                {
                    location = (Location)Location.CREATOR.createFromParcel(parcel);
                }
                a(location, parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 34: // '"'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = aG(parcel.readString());
                parcel1.writeNoException();
                break;
            }
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
        }
    }

    private static class a.a
        implements hg
    {

        private IBinder ky;

        public void a(long l, boolean flag, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeLong(l);
            if (!flag)
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L1:
            ky.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public void a(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L1:
            ky.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public void a(PendingIntent pendingintent, hf hf1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L3:
            if (hf1 == null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            pendingintent = hf1.asBinder();
_L4:
            parcel.writeStrongBinder(pendingintent);
            parcel.writeString(s);
            ky.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
            pendingintent = null;
              goto _L4
        }

        public void a(Location location, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (location == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            parcel.writeInt(1);
            location.writeToParcel(parcel, 0);
_L1:
            parcel.writeInt(i);
            ky.transact(26, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            location;
            parcel1.recycle();
            parcel.recycle();
            throw location;
        }

        public void a(hf hf1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (hf1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            hf1 = hf1.asBinder();
_L1:
            parcel.writeStrongBinder(hf1);
            parcel.writeString(s);
            ky.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            hf1 = null;
              goto _L1
            hf1;
            parcel1.recycle();
            parcel.recycle();
            throw hf1;
        }

        public void a(hn hn1, id id1, hv hv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (hn1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            hn1.writeToParcel(parcel, 0);
_L5:
            if (id1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            id1.writeToParcel(parcel, 0);
_L6:
            if (hv1 == null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            hn1 = hv1.asBinder();
_L7:
            parcel.writeStrongBinder(hn1);
            ky.transact(17, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            hn1;
            parcel1.recycle();
            parcel.recycle();
            throw hn1;
_L4:
            parcel.writeInt(0);
              goto _L6
            hn1 = null;
              goto _L7
        }

        public void a(hp hp1, id id1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (hp1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            hp1.writeToParcel(parcel, 0);
_L3:
            if (id1 == null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            parcel.writeInt(1);
            id1.writeToParcel(parcel, 0);
_L4:
            ky.transact(25, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            hp1;
            parcel.recycle();
            throw hp1;
            parcel.writeInt(0);
              goto _L4
        }

        public void a(hr hr1, id id1, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (hr1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            hr1.writeToParcel(parcel, 0);
_L5:
            if (id1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            id1.writeToParcel(parcel, 0);
_L6:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L7:
            ky.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            hr1;
            parcel1.recycle();
            parcel.recycle();
            throw hr1;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void a(id id1, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (id1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            id1.writeToParcel(parcel, 0);
_L3:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L4:
            ky.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            id1;
            parcel1.recycle();
            parcel.recycle();
            throw id1;
            parcel.writeInt(0);
              goto _L4
        }

        public void a(LocationRequest locationrequest, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
_L3:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L4:
            ky.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
            parcel.writeInt(0);
              goto _L4
        }

        public void a(LocationRequest locationrequest, com.google.android.gms.location.a a1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
_L3:
            if (a1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            locationrequest = a1.asBinder();
_L4:
            parcel.writeStrongBinder(locationrequest);
            ky.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
            locationrequest = null;
              goto _L4
        }

        public void a(LocationRequest locationrequest, com.google.android.gms.location.a a1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
_L3:
            if (a1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            locationrequest = a1.asBinder();
_L4:
            parcel.writeStrongBinder(locationrequest);
            parcel.writeString(s);
            ky.transact(20, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
            locationrequest = null;
              goto _L4
        }

        public void a(com.google.android.gms.location.a a1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (a1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            a1 = a1.asBinder();
_L1:
            parcel.writeStrongBinder(a1);
            ky.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            a1 = null;
              goto _L1
            a1;
            parcel1.recycle();
            parcel.recycle();
            throw a1;
        }

        public void a(LatLng latlng, hn hn1, id id1, hv hv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (latlng == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlng.writeToParcel(parcel, 0);
_L7:
            if (hn1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            hn1.writeToParcel(parcel, 0);
_L8:
            if (id1 == null) goto _L6; else goto _L5
_L5:
            parcel.writeInt(1);
            id1.writeToParcel(parcel, 0);
_L9:
            if (hv1 == null)
            {
                break MISSING_BLOCK_LABEL_160;
            }
            latlng = hv1.asBinder();
_L10:
            parcel.writeStrongBinder(latlng);
            ky.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L7
            latlng;
            parcel1.recycle();
            parcel.recycle();
            throw latlng;
_L4:
            parcel.writeInt(0);
              goto _L8
_L6:
            parcel.writeInt(0);
              goto _L9
            latlng = null;
              goto _L10
        }

        public void a(LatLngBounds latlngbounds, int i, hn hn1, id id1, hv hv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (latlngbounds == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlngbounds.writeToParcel(parcel, 0);
_L7:
            parcel.writeInt(i);
            if (hn1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            hn1.writeToParcel(parcel, 0);
_L8:
            if (id1 == null) goto _L6; else goto _L5
_L5:
            parcel.writeInt(1);
            id1.writeToParcel(parcel, 0);
_L9:
            if (hv1 == null)
            {
                break MISSING_BLOCK_LABEL_168;
            }
            latlngbounds = hv1.asBinder();
_L10:
            parcel.writeStrongBinder(latlngbounds);
            ky.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L7
            latlngbounds;
            parcel1.recycle();
            parcel.recycle();
            throw latlngbounds;
_L4:
            parcel.writeInt(0);
              goto _L8
_L6:
            parcel.writeInt(0);
              goto _L9
            latlngbounds = null;
              goto _L10
        }

        public void a(String s, id id1, hv hv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(s);
            if (id1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            id1.writeToParcel(parcel, 0);
_L3:
            if (hv1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            s = hv1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            ky.transact(15, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public void a(List list)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeTypedList(list);
            ky.transact(24, parcel, null, 1);
            parcel.recycle();
            return;
            list;
            parcel.recycle();
            throw list;
        }

        public void a(List list, PendingIntent pendingintent, hf hf1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeTypedList(list);
            if (pendingintent == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L3:
            if (hf1 == null)
            {
                break MISSING_BLOCK_LABEL_118;
            }
            list = hf1.asBinder();
_L4:
            parcel.writeStrongBinder(list);
            parcel.writeString(s);
            ky.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            list;
            parcel1.recycle();
            parcel.recycle();
            throw list;
            list = null;
              goto _L4
        }

        public void a(String as[], hf hf1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeStringArray(as);
            if (hf1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            as = hf1.asBinder();
_L1:
            parcel.writeStrongBinder(as);
            parcel.writeString(s);
            ky.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            as = null;
              goto _L1
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
        }

        public Location aF(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(s);
            ky.transact(21, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (Location)Location.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public b aG(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(s);
            ky.transact(34, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = b.CREATOR.au(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public IBinder asBinder()
        {
            return ky;
        }

        public void b(String s, id id1, hv hv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(s);
            if (id1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            id1.writeToParcel(parcel, 0);
_L3:
            if (hv1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            s = hv1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            ky.transact(42, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public Location gk()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            ky.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Location location = (Location)Location.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return location;
_L2:
            location = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void removeActivityUpdates(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L1:
            ky.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public void setMockLocation(Location location)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (location == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            location.writeToParcel(parcel, 0);
_L1:
            ky.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            location;
            parcel1.recycle();
            parcel.recycle();
            throw location;
        }

        public void setMockMode(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            ky.transact(12, parcel, parcel1, 0);
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

        a.a(IBinder ibinder)
        {
            ky = ibinder;
        }
    }


    public abstract void a(long l, boolean flag, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void a(PendingIntent pendingintent)
        throws RemoteException;

    public abstract void a(PendingIntent pendingintent, hf hf, String s)
        throws RemoteException;

    public abstract void a(Location location, int i)
        throws RemoteException;

    public abstract void a(hf hf, String s)
        throws RemoteException;

    public abstract void a(hn hn, id id, hv hv)
        throws RemoteException;

    public abstract void a(hp hp, id id)
        throws RemoteException;

    public abstract void a(hr hr, id id, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void a(id id, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void a(LocationRequest locationrequest, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void a(LocationRequest locationrequest, com.google.android.gms.location.a a1)
        throws RemoteException;

    public abstract void a(LocationRequest locationrequest, com.google.android.gms.location.a a1, String s)
        throws RemoteException;

    public abstract void a(com.google.android.gms.location.a a1)
        throws RemoteException;

    public abstract void a(LatLng latlng, hn hn, id id, hv hv)
        throws RemoteException;

    public abstract void a(LatLngBounds latlngbounds, int i, hn hn, id id, hv hv)
        throws RemoteException;

    public abstract void a(String s, id id, hv hv)
        throws RemoteException;

    public abstract void a(List list)
        throws RemoteException;

    public abstract void a(List list, PendingIntent pendingintent, hf hf, String s)
        throws RemoteException;

    public abstract void a(String as[], hf hf, String s)
        throws RemoteException;

    public abstract Location aF(String s)
        throws RemoteException;

    public abstract b aG(String s)
        throws RemoteException;

    public abstract void b(String s, id id, hv hv)
        throws RemoteException;

    public abstract Location gk()
        throws RemoteException;

    public abstract void removeActivityUpdates(PendingIntent pendingintent)
        throws RemoteException;

    public abstract void setMockLocation(Location location)
        throws RemoteException;

    public abstract void setMockMode(boolean flag)
        throws RemoteException;
}

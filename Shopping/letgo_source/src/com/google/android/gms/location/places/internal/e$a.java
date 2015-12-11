// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.p;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.location.places.personalized.c;
import com.google.android.gms.location.places.r;
import com.google.android.gms.location.places.s;
import com.google.android.gms.location.places.y;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.j;
import com.google.android.gms.maps.model.k;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            e, PlacesParams, n, g, 
//            f

public static abstract class a.a extends Binder
    implements e
{
    private static class a
        implements e
    {

        private IBinder a;

        public void a(AddPlaceRequest addplacerequest, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (addplacerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            addplacerequest.writeToParcel(parcel, 0);
_L3:
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_108;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            addplacerequest = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            addplacerequest = g1.asBinder();
            parcel.writeStrongBinder(addplacerequest);
            a.transact(14, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            addplacerequest;
            parcel.recycle();
            throw addplacerequest;
            parcel.writeInt(0);
              goto _L4
        }

        public void a(NearbyAlertRequest nearbyalertrequest, PlacesParams placesparams, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (nearbyalertrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            nearbyalertrequest.writeToParcel(parcel, 0);
_L5:
            if (placesparams == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L6:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L7:
            a.transact(11, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            nearbyalertrequest;
            parcel.recycle();
            throw nearbyalertrequest;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void a(PlaceFilter placefilter, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placefilter == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placefilter.writeToParcel(parcel, 0);
_L3:
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            placefilter = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            placefilter = g1.asBinder();
            parcel.writeStrongBinder(placefilter);
            a.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            placefilter;
            parcel.recycle();
            throw placefilter;
            parcel.writeInt(0);
              goto _L4
        }

        public void a(PlaceReport placereport, PlacesParams placesparams)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placereport == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placereport.writeToParcel(parcel, 0);
_L3:
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            a.transact(15, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            placereport;
            parcel.recycle();
            throw placereport;
            parcel.writeInt(0);
              goto _L4
        }

        public void a(PlaceRequest placerequest, PlacesParams placesparams, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placerequest.writeToParcel(parcel, 0);
_L5:
            if (placesparams == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L6:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L7:
            a.transact(9, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            placerequest;
            parcel.recycle();
            throw placerequest;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void a(UserDataType userdatatype, LatLngBounds latlngbounds, List list, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (userdatatype == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            userdatatype.writeToParcel(parcel, 0);
_L5:
            if (latlngbounds == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            latlngbounds.writeToParcel(parcel, 0);
_L6:
            parcel.writeStringList(list);
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_144;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L7:
            userdatatype = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_90;
            }
            userdatatype = g1.asBinder();
            parcel.writeStrongBinder(userdatatype);
            a.transact(8, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            userdatatype;
            parcel.recycle();
            throw userdatatype;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void a(PlacesParams placesparams, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L4:
            a.transact(10, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            placesparams;
            parcel.recycle();
            throw placesparams;
            parcel.writeInt(0);
              goto _L4
        }

        public void a(PlaceAlias placealias, String s1, String s2, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placealias == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placealias.writeToParcel(parcel, 0);
_L3:
            parcel.writeString(s1);
            parcel.writeString(s2);
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_124;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            placealias = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            placealias = g1.asBinder();
            parcel.writeStrongBinder(placealias);
            a.transact(16, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            placealias;
            parcel.recycle();
            throw placealias;
            parcel.writeInt(0);
              goto _L4
        }

        public void a(LatLng latlng, PlaceFilter placefilter, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (latlng == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlng.writeToParcel(parcel, 0);
_L5:
            if (placefilter == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placefilter.writeToParcel(parcel, 0);
_L6:
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_135;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L7:
            latlng = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            latlng = g1.asBinder();
            parcel.writeStrongBinder(latlng);
            a.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            latlng;
            parcel.recycle();
            throw latlng;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void a(LatLngBounds latlngbounds, int i, String s1, PlaceFilter placefilter, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (latlngbounds == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlngbounds.writeToParcel(parcel, 0);
_L5:
            parcel.writeInt(i);
            parcel.writeString(s1);
            if (placefilter == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placefilter.writeToParcel(parcel, 0);
_L6:
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_151;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L7:
            latlngbounds = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            latlngbounds = g1.asBinder();
            parcel.writeStrongBinder(latlngbounds);
            a.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            latlngbounds;
            parcel.recycle();
            throw latlngbounds;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void a(String s1, int i, int l, int i1, PlacesParams placesparams, f f1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s1);
            parcel.writeInt(i);
            parcel.writeInt(l);
            parcel.writeInt(i1);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            s1 = obj;
            if (f1 == null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            s1 = f1.asBinder();
            parcel.writeStrongBinder(s1);
            a.transact(20, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
            if (true) goto _L4; else goto _L3
_L3:
            s1;
            parcel.recycle();
            throw s1;
        }

        public void a(String s1, int i, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s1);
            parcel.writeInt(i);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            s1 = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_60;
            }
            s1 = g1.asBinder();
            parcel.writeStrongBinder(s1);
            a.transact(18, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
            if (true) goto _L4; else goto _L3
_L3:
            s1;
            parcel.recycle();
            throw s1;
        }

        public void a(String s1, PlacesParams placesparams, f f1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s1);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            s1 = obj;
            if (f1 == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            s1 = f1.asBinder();
            parcel.writeStrongBinder(s1);
            a.transact(19, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
            if (true) goto _L4; else goto _L3
_L3:
            s1;
            parcel.recycle();
            throw s1;
        }

        public void a(String s1, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s1);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            s1 = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            s1 = g1.asBinder();
            parcel.writeStrongBinder(s1);
            a.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
            if (true) goto _L4; else goto _L3
_L3:
            s1;
            parcel.recycle();
            throw s1;
        }

        public void a(String s1, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s1);
            if (latlngbounds == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlngbounds.writeToParcel(parcel, 0);
_L5:
            if (autocompletefilter == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            autocompletefilter.writeToParcel(parcel, 0);
_L6:
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_144;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L7:
            s1 = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_90;
            }
            s1 = g1.asBinder();
            parcel.writeStrongBinder(s1);
            a.transact(13, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            s1;
            parcel.recycle();
            throw s1;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void a(List list, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeStringList(list);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            list = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            list = g1.asBinder();
            parcel.writeStrongBinder(list);
            a.transact(7, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
            if (true) goto _L4; else goto _L3
_L3:
            list;
            parcel.recycle();
            throw list;
        }

        public IBinder asBinder()
        {
            return a;
        }

        public void b(PlacesParams placesparams, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L4:
            a.transact(12, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            placesparams;
            parcel.recycle();
            throw placesparams;
            parcel.writeInt(0);
              goto _L4
        }

        public void b(String s1, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s1);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            s1 = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            s1 = g1.asBinder();
            parcel.writeStrongBinder(s1);
            a.transact(6, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
            if (true) goto _L4; else goto _L3
_L3:
            s1;
            parcel.recycle();
            throw s1;
        }

        public void b(List list, PlacesParams placesparams, g g1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeStringList(list);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            list = obj;
            if (g1 == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            list = g1.asBinder();
            parcel.writeStrongBinder(list);
            a.transact(17, parcel, null, 1);
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
            if (true) goto _L4; else goto _L3
_L3:
            list;
            parcel.recycle();
            throw list;
        }

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static e a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (iinterface != null && (iinterface instanceof e))
        {
            return (e)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int l)
        throws RemoteException
    {
        Object obj4 = null;
        String s2 = null;
        Object obj = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj8 = null;
        Object obj9 = null;
        Object obj10 = null;
        PlacesParams placesparams = null;
        int i1;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, l);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.location.places.internal.IGooglePlacesService");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (parcel.readInt() != 0)
            {
                parcel1 = LatLngBounds.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            i = parcel.readInt();
            s2 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                obj = PlaceFilter.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                placesparams = PlacesParams.CREATOR.a(parcel);
            }
            a(parcel1, i, s2, ((PlaceFilter) (obj)), placesparams, a(parcel.readStrongBinder()));
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obj = parcel.readString();
            parcel1 = obj4;
            if (parcel.readInt() != 0)
            {
                parcel1 = PlacesParams.CREATOR.a(parcel);
            }
            a(((String) (obj)), parcel1, a(parcel.readStrongBinder()));
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            Object obj1;
            if (parcel.readInt() != 0)
            {
                parcel1 = LatLng.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj = PlaceFilter.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            obj1 = s2;
            if (parcel.readInt() != 0)
            {
                obj1 = PlacesParams.CREATOR.a(parcel);
            }
            a(parcel1, ((PlaceFilter) (obj)), ((PlacesParams) (obj1)), a(parcel.readStrongBinder()));
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (parcel.readInt() != 0)
            {
                parcel1 = PlaceFilter.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj = PlacesParams.CREATOR.a(parcel);
            }
            a(parcel1, ((PlacesParams) (obj)), a(parcel.readStrongBinder()));
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obj = parcel.readString();
            parcel1 = obj5;
            if (parcel.readInt() != 0)
            {
                parcel1 = PlacesParams.CREATOR.a(parcel);
            }
            b(((String) (obj)), parcel1, a(parcel.readStrongBinder()));
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obj = parcel.createStringArrayList();
            parcel1 = obj6;
            if (parcel.readInt() != 0)
            {
                parcel1 = PlacesParams.CREATOR.a(parcel);
            }
            a(((List) (obj)), parcel1, a(parcel.readStrongBinder()));
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obj = parcel.createStringArrayList();
            parcel1 = obj7;
            if (parcel.readInt() != 0)
            {
                parcel1 = PlacesParams.CREATOR.a(parcel);
            }
            b(((List) (obj)), parcel1, a(parcel.readStrongBinder()));
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            PlacesParams placesparams1;
            java.util.ArrayList arraylist;
            if (parcel.readInt() != 0)
            {
                parcel1 = UserDataType.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj = LatLngBounds.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            arraylist = parcel.createStringArrayList();
            if (parcel.readInt() != 0)
            {
                placesparams1 = PlacesParams.CREATOR.a(parcel);
            } else
            {
                placesparams1 = null;
            }
            a(parcel1, ((LatLngBounds) (obj)), arraylist, placesparams1, a(parcel.readStrongBinder()));
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (parcel.readInt() != 0)
            {
                parcel1 = (PlaceRequest)PlaceRequest.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj = PlacesParams.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(parcel1, ((PlacesParams) (obj)), parcel);
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (parcel.readInt() != 0)
            {
                parcel1 = PlacesParams.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(parcel1, parcel);
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (parcel.readInt() != 0)
            {
                parcel1 = NearbyAlertRequest.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj = PlacesParams.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(parcel1, ((PlacesParams) (obj)), parcel);
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (parcel.readInt() != 0)
            {
                parcel1 = PlacesParams.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            b(parcel1, parcel);
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            String s3 = parcel.readString();
            PlacesParams placesparams2;
            if (parcel.readInt() != 0)
            {
                parcel1 = LatLngBounds.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj = AutocompleteFilter.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                placesparams2 = PlacesParams.CREATOR.a(parcel);
            } else
            {
                placesparams2 = null;
            }
            a(s3, parcel1, ((AutocompleteFilter) (obj)), placesparams2, a(parcel.readStrongBinder()));
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (parcel.readInt() != 0)
            {
                parcel1 = (AddPlaceRequest)AddPlaceRequest.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel1 = null;
            }
            obj = obj2;
            if (parcel.readInt() != 0)
            {
                obj = PlacesParams.CREATOR.a(parcel);
            }
            a(parcel1, ((PlacesParams) (obj)), a(parcel.readStrongBinder()));
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (parcel.readInt() != 0)
            {
                parcel1 = (PlaceReport)PlaceReport.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel1 = null;
            }
            obj = obj3;
            if (parcel.readInt() != 0)
            {
                obj = PlacesParams.CREATOR.a(parcel);
            }
            a(parcel1, ((PlacesParams) (obj)));
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            String s1;
            String s4;
            if (parcel.readInt() != 0)
            {
                parcel1 = PlaceAlias.CREATOR.a(parcel);
            } else
            {
                parcel1 = null;
            }
            s1 = parcel.readString();
            s4 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                obj = PlacesParams.CREATOR.a(parcel);
            } else
            {
                obj = null;
            }
            a(parcel1, s1, s4, ((PlacesParams) (obj)), a(parcel.readStrongBinder()));
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obj = parcel.readString();
            i = parcel.readInt();
            parcel1 = obj8;
            if (parcel.readInt() != 0)
            {
                parcel1 = PlacesParams.CREATOR.a(parcel);
            }
            a(((String) (obj)), i, parcel1, a(parcel.readStrongBinder()));
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obj = parcel.readString();
            parcel1 = obj9;
            if (parcel.readInt() != 0)
            {
                parcel1 = PlacesParams.CREATOR.a(parcel);
            }
            a(((String) (obj)), parcel1, a(parcel.readStrongBinder()));
            return true;

        case 20: // '\024'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obj = parcel.readString();
            i = parcel.readInt();
            l = parcel.readInt();
            i1 = parcel.readInt();
            parcel1 = obj10;
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = PlacesParams.CREATOR.a(parcel);
        }
        a(((String) (obj)), i, l, i1, parcel1, a(parcel.readStrongBinder()));
        return true;
    }
}

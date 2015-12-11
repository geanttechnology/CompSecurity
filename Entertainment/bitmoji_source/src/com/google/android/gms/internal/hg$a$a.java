// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.b;
import com.google.android.gms.location.c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            hg, hf, hn, id, 
//            hv, hp, hr

private static class ky
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

    public void a(LocationRequest locationrequest, a a1)
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

    public void a(LocationRequest locationrequest, a a1, String s)
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

    public void a(a a1)
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

    gBounds(IBinder ibinder)
    {
        ky = ibinder;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

class amr
    implements amp
{

    private IBinder a;

    amr(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a(StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
        if (streetviewpanoramacamera == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        streetviewpanoramacamera.writeToParcel(parcel, 0);
_L1:
        a.transact(1, parcel, parcel1, 0);
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

    public IBinder asBinder()
    {
        return a;
    }
}

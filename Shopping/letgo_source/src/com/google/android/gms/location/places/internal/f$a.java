// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            f

public static abstract class a.a extends Binder
    implements f
{
    private static class a
        implements f
    {

        private IBinder a;

        public void a(PlacePhotoMetadataResult placephotometadataresult)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            if (placephotometadataresult == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            placephotometadataresult.writeToParcel(parcel, 0);
_L1:
            a.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            placephotometadataresult;
            parcel.recycle();
            throw placephotometadataresult;
        }

        public void a(PlacePhotoResult placephotoresult)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            if (placephotoresult == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            placephotoresult.writeToParcel(parcel, 0);
_L1:
            a.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            placephotoresult;
            parcel.recycle();
            throw placephotoresult;
        }

        public IBinder asBinder()
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
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
        if (iinterface != null && (iinterface instanceof f))
        {
            return (f)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        Object obj1 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            parcel1 = obj;
            if (parcel.readInt() != 0)
            {
                parcel1 = (PlacePhotoMetadataResult)PlacePhotoMetadataResult.CREATOR.createFromParcel(parcel);
            }
            a(parcel1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            parcel1 = obj1;
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = (PlacePhotoResult)PlacePhotoResult.CREATOR.createFromParcel(parcel);
        }
        a(parcel1);
        return true;
    }
}

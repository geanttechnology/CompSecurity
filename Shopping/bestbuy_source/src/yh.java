// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class yh extends Binder
    implements yg
{

    public yh()
    {
        attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
    }

    public static yg a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        if (iinterface != null && (iinterface instanceof yg))
        {
            return (yg)iinterface;
        } else
        {
            return new yi(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            parcel = a();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            b(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            c(parcel.readInt());
            parcel1.writeNoException();
            return true;
        }
    }
}

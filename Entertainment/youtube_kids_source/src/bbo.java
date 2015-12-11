// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class bbo extends Binder
    implements bbn
{

    public bbo()
    {
        attachInterface(this, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    public static bbn a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        if (iinterface != null && (iinterface instanceof bbn))
        {
            return (bbn)iinterface;
        } else
        {
            return new bbp(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        boolean flag1 = false;
        boolean flag = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            parcel = a();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            a(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            boolean flag2 = a(ayi.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag2)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            boolean flag3 = b(ayi.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            i = ((flag1) ? 1 : 0);
            if (flag3)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            a(parcel.readString());
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            parcel = a(ayi.a(parcel.readStrongBinder()), ayi.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel = parcel.asBinder();
            } else
            {
                parcel = null;
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            parcel = c(ayi.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;
        }
    }
}

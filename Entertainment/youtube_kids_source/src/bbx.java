// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class bbx extends Binder
    implements bbw
{

    public static bbw a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (iinterface != null && (iinterface instanceof bbw))
        {
            return (bbw)iinterface;
        } else
        {
            return new bby(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        boolean flag1 = false;
        boolean flag = false;
        String s;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcel = a();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (parcel.readInt() != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag1 = a(flag1);
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag1)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcel = a(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            s = parcel.readString();
            break;
        }
        if (parcel.readInt() != 0)
        {
            flag1 = true;
        }
        a(s, flag1);
        parcel1.writeNoException();
        return true;
    }
}

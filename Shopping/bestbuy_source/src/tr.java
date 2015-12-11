// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;

public abstract class tr extends Binder
    implements tq
{

    public tr()
    {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static tq a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (iinterface != null && (iinterface instanceof tq))
        {
            return (tq)iinterface;
        } else
        {
            return new ts(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        ry ry1 = null;
        Object obj2 = null;
        Object obj = null;
        boolean flag = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.client.IAdManager");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            ry1 = a();
            parcel1.writeNoException();
            parcel = obj;
            if (ry1 != null)
            {
                parcel = ry1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            b();
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            boolean flag1 = c();
            parcel1.writeNoException();
            if (flag1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            Object obj1 = ry1;
            if (parcel.readInt() != 0)
            {
                obj1 = av.CREATOR.a(parcel);
            }
            boolean flag2 = a(((av) (obj1)));
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag2)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            d();
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            e();
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            a(to.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            a(tx.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            f();
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            g();
            parcel1.writeNoException();
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            h();
            parcel1.writeNoException();
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            parcel = i();
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

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            ay ay1 = obj2;
            if (parcel.readInt() != 0)
            {
                ay1 = ay.CREATOR.a(parcel);
            }
            a(ay1);
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            a(yk.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            a(yw.a(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            parcel = j();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            a(un.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }
}

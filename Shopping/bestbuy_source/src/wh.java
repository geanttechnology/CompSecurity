// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;

public abstract class wh extends Binder
    implements wg
{

    public wh()
    {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public static wg a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (iinterface != null && (iinterface instanceof wg))
        {
            return (wg)iinterface;
        } else
        {
            return new wi(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj1 = null;
        ay ay1 = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            ry ry2 = rz.a(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                ay1 = ay.CREATOR.a(parcel);
            } else
            {
                ay1 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj1 = av.CREATOR.a(parcel);
            } else
            {
                obj1 = null;
            }
            a(ry2, ay1, ((av) (obj1)), parcel.readString(), wm.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            obj1 = a();
            parcel1.writeNoException();
            parcel = ay1;
            if (obj1 != null)
            {
                parcel = ((ry) (obj1)).asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            ry ry3 = rz.a(parcel.readStrongBinder());
            Object obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = av.CREATOR.a(parcel);
            }
            a(ry3, ((av) (obj)), parcel.readString(), wm.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            b();
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            c();
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            ry ry4 = rz.a(parcel.readStrongBinder());
            ay ay2;
            av av2;
            if (parcel.readInt() != 0)
            {
                ay2 = ay.CREATOR.a(parcel);
            } else
            {
                ay2 = null;
            }
            if (parcel.readInt() != 0)
            {
                av2 = av.CREATOR.a(parcel);
            } else
            {
                av2 = null;
            }
            a(ry4, ay2, av2, parcel.readString(), parcel.readString(), wm.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            ry ry1 = rz.a(parcel.readStrongBinder());
            av av1;
            if (parcel.readInt() != 0)
            {
                av1 = av.CREATOR.a(parcel);
            } else
            {
                av1 = null;
            }
            a(ry1, av1, parcel.readString(), parcel.readString(), wm.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            d();
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            e();
            parcel1.writeNoException();
            return true;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;

// Referenced classes of package com.google.android.gms.internal:
//            bq, bs, x, ky, 
//            v, kx, bu

public abstract class br extends Binder
    implements bq
{

    public br()
    {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public static bq a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (iinterface != null && (iinterface instanceof bq))
        {
            return (bq)iinterface;
        } else
        {
            return new bs(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj1 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a a1 = b.a(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                obj = x.CREATOR;
                obj = com.google.android.gms.internal.ky.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                obj1 = v.CREATOR;
                obj1 = com.google.android.gms.internal.kx.a(parcel);
            } else
            {
                obj1 = null;
            }
            a(a1, ((x) (obj)), ((v) (obj1)), parcel.readString(), com.google.android.gms.internal.bu.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            obj1 = a();
            parcel1.writeNoException();
            parcel = ((Parcel) (obj));
            if (obj1 != null)
            {
                parcel = ((a) (obj1)).asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a a2 = b.a(parcel.readStrongBinder());
            obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = v.CREATOR;
                obj = com.google.android.gms.internal.kx.a(parcel);
            }
            a(a2, ((v) (obj)), parcel.readString(), com.google.android.gms.internal.bu.a(parcel.readStrongBinder()));
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
            a a3 = b.a(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                obj = x.CREATOR;
                obj = com.google.android.gms.internal.ky.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                obj1 = v.CREATOR;
                obj1 = com.google.android.gms.internal.kx.a(parcel);
            } else
            {
                obj1 = null;
            }
            a(a3, ((x) (obj)), ((v) (obj1)), parcel.readString(), parcel.readString(), com.google.android.gms.internal.bu.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            obj1 = b.a(parcel.readStrongBinder());
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = v.CREATOR;
            obj = com.google.android.gms.internal.kx.a(parcel);
        } else
        {
            obj = null;
        }
        a(((a) (obj1)), ((v) (obj)), parcel.readString(), parcel.readString(), com.google.android.gms.internal.bu.a(parcel.readStrongBinder()));
        parcel1.writeNoException();
        return true;
    }
}

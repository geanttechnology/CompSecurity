// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.b;

// Referenced classes of package com.google.android.gms.internal:
//            i, k, x, ky, 
//            bn, bp

public abstract class j extends Binder
    implements i
{

    public static i a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (iinterface != null && (iinterface instanceof i))
        {
            return (i)iinterface;
        } else
        {
            return new k(ibinder);
        }
    }

    public boolean onTransact(int l, Parcel parcel, Parcel parcel1, int i1)
    {
        com.google.android.gms.a.a a1;
        switch (l)
        {
        default:
            return super.onTransact(l, parcel, parcel1, i1);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            a1 = b.a(parcel.readStrongBinder());
            break;
        }
        Object obj;
        x x1;
        String s;
        if (parcel.readInt() != 0)
        {
            ky ky1 = x.CREATOR;
            x1 = ky.a(parcel);
        } else
        {
            x1 = null;
        }
        s = parcel.readString();
        obj = parcel.readStrongBinder();
        if (obj == null)
        {
            obj = null;
        } else
        {
            android.os.IInterface iinterface = ((IBinder) (obj)).queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            if (iinterface != null && (iinterface instanceof bn))
            {
                obj = (bn)iinterface;
            } else
            {
                obj = new bp(((IBinder) (obj)));
            }
        }
        parcel = a(a1, x1, s, ((bn) (obj)), parcel.readInt());
        parcel1.writeNoException();
        parcel1.writeStrongBinder(parcel);
        return true;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            gn, gq

public abstract class gp extends Binder
    implements gn
{

    public gp()
    {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public static gn a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        if (iinterface != null && (iinterface instanceof gn))
        {
            return (gn)iinterface;
        } else
        {
            return new gq(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        IBinder ibinder;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            i = parcel.readInt();
            ibinder = parcel.readStrongBinder();
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        a(i, ibinder, parcel);
        parcel1.writeNoException();
        return true;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;

// Referenced classes of package com.google.android.gms.internal:
//            ii, ik, gh, ih

public abstract class ij extends Binder
    implements ii
{

    public static ii a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
        if (iinterface != null && (iinterface instanceof ii))
        {
            return (ii)iinterface;
        } else
        {
            return new ik(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj3 = null;
        Object obj4 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.location.internal.ICopresenceCallbacks");
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
            if (parcel.readInt() != 0)
            {
                obj = Status.CREATOR;
                obj = d.a(parcel);
            }
            a(((Status) (obj)));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
            i = parcel.readInt();
            Object obj1 = obj3;
            if (parcel.readInt() != 0)
            {
                obj1 = gh.CREATOR;
                obj1 = ih.a(parcel);
            }
            a(i, ((gh) (obj1)));
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
            i = parcel.readInt();
            Object obj2 = obj4;
            if (parcel.readInt() != 0)
            {
                obj2 = gh.CREATOR;
                obj2 = ih.a(parcel);
            }
            b(i, ((gh) (obj2)));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
            i = parcel.readInt();
            break;
        }
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(i, flag);
        parcel1.writeNoException();
        return true;
    }
}

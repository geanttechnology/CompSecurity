// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class bar extends Binder
    implements baq
{

    public static baq a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.droidguard.internal.IDroidGuardService");
        if (iinterface != null && (iinterface instanceof baq))
        {
            return (baq)iinterface;
        } else
        {
            return new bas(ibinder);
        }
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
            parcel1.writeString("com.google.android.gms.droidguard.internal.IDroidGuardService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.droidguard.internal.IDroidGuardService");
            parcel1 = parcel.readStrongBinder();
            if (parcel1 == null)
            {
                parcel1 = ((Parcel) (obj));
            } else
            {
                obj = parcel1.queryLocalInterface("com.google.android.gms.droidguard.internal.IDroidGuardCallbacks");
                if (obj != null && (obj instanceof bak))
                {
                    parcel1 = (bak)obj;
                } else
                {
                    parcel1 = new bam(parcel1);
                }
            }
            a(parcel1, parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.droidguard.internal.IDroidGuardService");
            obj = a();
            parcel1.writeNoException();
            parcel = obj1;
            break;
        }
        if (obj != null)
        {
            parcel = ((ban) (obj)).asBinder();
        }
        parcel1.writeStrongBinder(parcel);
        return true;
    }
}

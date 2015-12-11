// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.al;

public abstract class auz extends Binder
    implements auy
{

    public auz()
    {
        attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
    }

    public static auy a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
        if (iinterface != null && (iinterface instanceof auy))
        {
            return (auy)iinterface;
        } else
        {
            return new ava(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.wearable.internal.IWearableListener");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            parcel1 = obj;
            if (parcel.readInt() != 0)
            {
                parcel1 = DataHolder.CREATOR.a(parcel);
            }
            a(parcel1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            parcel1 = obj1;
            if (parcel.readInt() != 0)
            {
                parcel1 = (ai)ai.CREATOR.createFromParcel(parcel);
            }
            a(parcel1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            parcel1 = obj2;
            if (parcel.readInt() != 0)
            {
                parcel1 = (al)al.CREATOR.createFromParcel(parcel);
            }
            a(parcel1);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            parcel1 = obj3;
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = (al)al.CREATOR.createFromParcel(parcel);
        }
        b(parcel1);
        return true;
    }
}

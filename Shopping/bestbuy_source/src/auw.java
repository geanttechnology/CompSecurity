// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.ab;
import com.google.android.gms.wearable.internal.ap;
import com.google.android.gms.wearable.internal.at;
import com.google.android.gms.wearable.internal.aw;
import com.google.android.gms.wearable.internal.p;
import com.google.android.gms.wearable.internal.r;
import com.google.android.gms.wearable.internal.t;
import com.google.android.gms.wearable.internal.v;
import com.google.android.gms.wearable.internal.x;
import com.google.android.gms.wearable.internal.z;

public abstract class auw extends Binder
    implements auv
{

    public auw()
    {
        attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
    }

    public static auv a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        if (iinterface != null && (iinterface instanceof auv))
        {
            return (auv)iinterface;
        } else
        {
            return new aux(ibinder);
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
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        Object obj10 = null;
        Object obj11 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (parcel.readInt() != 0)
            {
                obj = (r)r.CREATOR.createFromParcel(parcel);
            }
            a(((r) (obj)));
            parcel1.writeNoException();
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = (t)t.CREATOR.createFromParcel(parcel);
            }
            a(((t) (obj)));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj2;
            if (parcel.readInt() != 0)
            {
                obj = (ap)ap.CREATOR.createFromParcel(parcel);
            }
            a(((ap) (obj)));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj3;
            if (parcel.readInt() != 0)
            {
                obj = (x)x.CREATOR.createFromParcel(parcel);
            }
            a(((x) (obj)));
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj4;
            if (parcel.readInt() != 0)
            {
                obj = DataHolder.CREATOR.a(parcel);
            }
            a(((DataHolder) (obj)));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj5;
            if (parcel.readInt() != 0)
            {
                obj = (p)p.CREATOR.createFromParcel(parcel);
            }
            a(((p) (obj)));
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj6;
            if (parcel.readInt() != 0)
            {
                obj = (at)at.CREATOR.createFromParcel(parcel);
            }
            a(((at) (obj)));
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj7;
            if (parcel.readInt() != 0)
            {
                obj = (z)z.CREATOR.createFromParcel(parcel);
            }
            a(((z) (obj)));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj8;
            if (parcel.readInt() != 0)
            {
                obj = (ab)ab.CREATOR.createFromParcel(parcel);
            }
            a(((ab) (obj)));
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj9;
            if (parcel.readInt() != 0)
            {
                obj = (v)v.CREATOR.createFromParcel(parcel);
            }
            a(((v) (obj)));
            parcel1.writeNoException();
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj10;
            if (parcel.readInt() != 0)
            {
                obj = Status.CREATOR.a(parcel);
            }
            a(((Status) (obj)));
            parcel1.writeNoException();
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            obj = obj11;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = (aw)aw.CREATOR.createFromParcel(parcel);
        }
        a(((aw) (obj)));
        parcel1.writeNoException();
        return true;
    }
}

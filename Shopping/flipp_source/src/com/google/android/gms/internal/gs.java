// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            gr, gu, gp

public abstract class gs extends Binder
    implements gr
{

    public static gr a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (iinterface != null && (iinterface instanceof gr))
        {
            return (gr)iinterface;
        } else
        {
            return new gu(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj7 = null;
        Object obj8 = null;
        String as1[] = null;
        String s15 = null;
        IBinder ibinder1 = null;
        String s17 = null;
        Object obj9 = null;
        Object obj10 = null;
        Object obj11 = null;
        Object obj12 = null;
        Object obj13 = null;
        Object obj14 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            obj = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            obj7 = parcel.readString();
            obj8 = parcel.readString();
            as1 = parcel.createStringArray();
            s15 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(((gn) (obj)), i, ((String) (obj7)), ((String) (obj8)), as1, s15, parcel);
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            obj7 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            obj8 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            a(((gn) (obj7)), i, ((String) (obj8)), ((Bundle) (obj)));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            a(gp.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            a(gp.a(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            obj8 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            as1 = parcel.readString();
            Object obj1 = obj7;
            if (parcel.readInt() != 0)
            {
                obj1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            b(((gn) (obj8)), i, as1, ((Bundle) (obj1)));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn3 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            as1 = parcel.readString();
            Object obj2 = obj8;
            if (parcel.readInt() != 0)
            {
                obj2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            c(gn3, i, as1, ((Bundle) (obj2)));
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn4 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s3 = parcel.readString();
            Object obj3 = as1;
            if (parcel.readInt() != 0)
            {
                obj3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            d(gn4, i, s3, ((Bundle) (obj3)));
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn5 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s4 = parcel.readString();
            Object obj4 = s15;
            if (parcel.readInt() != 0)
            {
                obj4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            e(gn5, i, s4, ((Bundle) (obj4)));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s = parcel.readString();
            String s5 = parcel.readString();
            String as2[] = parcel.createStringArray();
            String s16 = parcel.readString();
            ibinder1 = parcel.readStrongBinder();
            s17 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(gn, i, s, s5, as2, s16, ibinder1, s17, parcel);
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            a(gp.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
            parcel1.writeNoException();
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn6 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s6 = parcel.readString();
            Object obj5 = ibinder1;
            if (parcel.readInt() != 0)
            {
                obj5 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            f(gn6, i, s6, ((Bundle) (obj5)));
            parcel1.writeNoException();
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn7 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s7 = parcel.readString();
            Object obj6 = s17;
            if (parcel.readInt() != 0)
            {
                obj6 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            g(gn7, i, s7, ((Bundle) (obj6)));
            parcel1.writeNoException();
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn8 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s8 = parcel.readString();
            Bundle bundle = obj9;
            if (parcel.readInt() != 0)
            {
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            h(gn8, i, s8, bundle);
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn9 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s9 = parcel.readString();
            Bundle bundle1 = obj10;
            if (parcel.readInt() != 0)
            {
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            i(gn9, i, s9, bundle1);
            parcel1.writeNoException();
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn10 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s10 = parcel.readString();
            Bundle bundle2 = obj11;
            if (parcel.readInt() != 0)
            {
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            j(gn10, i, s10, bundle2);
            parcel1.writeNoException();
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn11 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s11 = parcel.readString();
            Bundle bundle3 = obj12;
            if (parcel.readInt() != 0)
            {
                bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            k(gn11, i, s11, bundle3);
            parcel1.writeNoException();
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn12 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s12 = parcel.readString();
            Bundle bundle4 = obj13;
            if (parcel.readInt() != 0)
            {
                bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            l(gn12, i, s12, bundle4);
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn13 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s13 = parcel.readString();
            Bundle bundle5 = obj14;
            if (parcel.readInt() != 0)
            {
                bundle5 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            m(gn13, i, s13, bundle5);
            parcel1.writeNoException();
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn1 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s1 = parcel.readString();
            IBinder ibinder = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(gn1, i, s1, ibinder, parcel);
            parcel1.writeNoException();
            return true;

        case 20: // '\024'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            gn gn2 = gp.a(parcel.readStrongBinder());
            i = parcel.readInt();
            String s2 = parcel.readString();
            String as[] = parcel.createStringArray();
            String s14 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(gn2, i, s2, as, s14, parcel);
            parcel1.writeNoException();
            return true;

        case 21: // '\025'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            b(gp.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}

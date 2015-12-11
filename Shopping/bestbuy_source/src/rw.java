// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public abstract class rw extends Binder
    implements rv
{

    public rw()
    {
        attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
    }

    public static rv a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (iinterface != null && (iinterface instanceof rv))
        {
            return (rv)iinterface;
        } else
        {
            return new rx(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        ry ry3 = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj = null;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;
        boolean flag7 = false;
        boolean flag8 = false;
        boolean flag12 = false;
        boolean flag13 = false;
        boolean flag14 = false;
        boolean flag = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            ry3 = a();
            parcel1.writeNoException();
            parcel = obj;
            if (ry3 != null)
            {
                parcel = ry3.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            parcel = b();
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

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            i = c();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            rv rv1 = d();
            parcel1.writeNoException();
            parcel = ry3;
            if (rv1 != null)
            {
                parcel = rv1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            ry ry1 = e();
            parcel1.writeNoException();
            parcel = obj1;
            if (ry1 != null)
            {
                parcel = ry1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = f();
            parcel1.writeNoException();
            if (flag8)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            parcel = g();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            rv rv2 = h();
            parcel1.writeNoException();
            parcel = obj2;
            if (rv2 != null)
            {
                parcel = rv2.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            i = i();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = j();
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            ry ry2 = k();
            parcel1.writeNoException();
            parcel = obj3;
            if (ry2 != null)
            {
                parcel = ry2.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = l();
            parcel1.writeNoException();
            i = ((flag1) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = m();
            parcel1.writeNoException();
            i = ((flag2) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = n();
            parcel1.writeNoException();
            i = ((flag3) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = o();
            parcel1.writeNoException();
            i = ((flag4) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = p();
            parcel1.writeNoException();
            i = ((flag5) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = q();
            parcel1.writeNoException();
            i = ((flag6) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            flag8 = r();
            parcel1.writeNoException();
            i = ((flag7) ? 1 : 0);
            if (flag8)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 20: // '\024'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            a(rz.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 21: // '\025'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if (parcel.readInt() != 0)
            {
                flag8 = true;
            }
            a(flag8);
            parcel1.writeNoException();
            return true;

        case 22: // '\026'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean flag9 = flag12;
            if (parcel.readInt() != 0)
            {
                flag9 = true;
            }
            b(flag9);
            parcel1.writeNoException();
            return true;

        case 23: // '\027'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean flag10 = flag13;
            if (parcel.readInt() != 0)
            {
                flag10 = true;
            }
            c(flag10);
            parcel1.writeNoException();
            return true;

        case 24: // '\030'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean flag11 = flag14;
            if (parcel.readInt() != 0)
            {
                flag11 = true;
            }
            d(flag11);
            parcel1.writeNoException();
            return true;

        case 25: // '\031'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            Intent intent = obj4;
            if (parcel.readInt() != 0)
            {
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            }
            a(intent);
            parcel1.writeNoException();
            return true;

        case 26: // '\032'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            Intent intent1 = obj5;
            if (parcel.readInt() != 0)
            {
                intent1 = (Intent)Intent.CREATOR.createFromParcel(parcel);
            }
            a(intent1, parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 27: // '\033'
            parcel.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            b(rz.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }
}

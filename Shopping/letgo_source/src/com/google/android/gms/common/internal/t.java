// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.common.internal:
//            s, GetServiceRequest, ValidateAccountRequest

public interface t
    extends IInterface
{
    public static abstract class a extends Binder
        implements t
    {

        public static t a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (iinterface != null && (iinterface instanceof t))
            {
                return (t)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i1, Parcel parcel, Parcel parcel1, int j1)
            throws RemoteException
        {
            Object obj1 = null;
            Object obj2 = null;
            String as1[] = null;
            String s21 = null;
            IBinder ibinder1 = null;
            String s23 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            Object obj9 = null;
            Object obj10 = null;
            Object obj11 = null;
            Object obj12 = null;
            Object obj13 = null;
            Object obj14 = null;
            Object obj15 = null;
            Object obj16 = null;
            Object obj17 = null;
            Object obj = null;
            switch (i1)
            {
            default:
                return super.onTransact(i1, parcel, parcel1, j1);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                obj1 = parcel.readString();
                obj2 = parcel.readString();
                as1 = parcel.createStringArray();
                s21 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(((s) (obj)), i1, ((String) (obj1)), ((String) (obj2)), as1, s21, parcel);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                obj2 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                a(((s) (obj1)), i1, ((String) (obj2)), ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj2 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                as1 = parcel.readString();
                obj = obj1;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                b(((s) (obj2)), i1, as1, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                as1 = parcel.readString();
                obj = obj2;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                c(((s) (obj1)), i1, as1, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s1 = parcel.readString();
                obj = as1;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                d(((s) (obj1)), i1, s1, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s2 = parcel.readString();
                obj = s21;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                e(((s) (obj1)), i1, s2, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                obj1 = parcel.readString();
                String s3 = parcel.readString();
                String as2[] = parcel.createStringArray();
                String s22 = parcel.readString();
                ibinder1 = parcel.readStrongBinder();
                s23 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(((s) (obj)), i1, ((String) (obj1)), s3, as2, s22, ibinder1, s23, parcel);
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s4 = parcel.readString();
                obj = ibinder1;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                f(((s) (obj1)), i1, s4, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s5 = parcel.readString();
                obj = s23;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                g(((s) (obj1)), i1, s5, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s6 = parcel.readString();
                obj = obj3;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                h(((s) (obj1)), i1, s6, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s7 = parcel.readString();
                obj = obj4;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                i(((s) (obj1)), i1, s7, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 15: // '\017'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s8 = parcel.readString();
                obj = obj5;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                j(((s) (obj1)), i1, s8, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s9 = parcel.readString();
                obj = obj6;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                k(((s) (obj1)), i1, s9, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 17: // '\021'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s10 = parcel.readString();
                obj = obj7;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                l(((s) (obj1)), i1, s10, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 18: // '\022'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s11 = parcel.readString();
                obj = obj8;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                m(((s) (obj1)), i1, s11, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 19: // '\023'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                obj1 = parcel.readString();
                IBinder ibinder = parcel.readStrongBinder();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(((s) (obj)), i1, ((String) (obj1)), ibinder, parcel);
                parcel1.writeNoException();
                return true;

            case 20: // '\024'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                obj1 = parcel.readString();
                String as[] = parcel.createStringArray();
                String s20 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(((s) (obj)), i1, ((String) (obj1)), as, s20, parcel);
                parcel1.writeNoException();
                return true;

            case 21: // '\025'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                b(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 22: // '\026'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                c(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 23: // '\027'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s12 = parcel.readString();
                obj = obj9;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                n(((s) (obj1)), i1, s12, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 24: // '\030'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                d(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 25: // '\031'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s13 = parcel.readString();
                obj = obj10;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                o(((s) (obj1)), i1, s13, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 26: // '\032'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                e(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 27: // '\033'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s14 = parcel.readString();
                obj = obj11;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                p(((s) (obj1)), i1, s14, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 28: // '\034'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a();
                parcel1.writeNoException();
                return true;

            case 30: // '\036'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                obj1 = parcel.readString();
                String s15 = parcel.readString();
                String as3[] = parcel.createStringArray();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(((s) (obj)), i1, ((String) (obj1)), s15, as3, parcel);
                parcel1.writeNoException();
                return true;

            case 31: // '\037'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                f(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 32: // ' '
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                g(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 33: // '!'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 34: // '"'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 35: // '#'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 36: // '$'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                i(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 37: // '%'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s16 = parcel.readString();
                obj = obj12;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                q(((s) (obj1)), i1, s16, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 38: // '&'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s17 = parcel.readString();
                obj = obj13;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                r(((s) (obj1)), i1, s17, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 40: // '('
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                j(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 41: // ')'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s18 = parcel.readString();
                obj = obj14;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                s(((s) (obj1)), i1, s18, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 42: // '*'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                k(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 43: // '+'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s19 = parcel.readString();
                obj = obj15;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                t(((s) (obj1)), i1, s19, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 44: // ','
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                l(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 45: // '-'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m(com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 46: // '.'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                obj = obj16;
                if (parcel.readInt() != 0)
                {
                    obj = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                a(((s) (obj1)), ((GetServiceRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 47: // '/'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj1 = com.google.android.gms.common.internal.s.a.a(parcel.readStrongBinder());
                obj = obj17;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = (ValidateAccountRequest)ValidateAccountRequest.CREATOR.createFromParcel(parcel);
            }
            a(((s) (obj1)), ((ValidateAccountRequest) (obj)));
            parcel1.writeNoException();
            return true;
        }
    }

    private static class a.a
        implements t
    {

        private IBinder a;

        public void a()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            a.transact(28, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void a(s s1, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            a.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void a(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void a(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void a(s s1, int i1, String s2, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void a(s s1, int i1, String s2, String s3)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            parcel.writeString(s3);
            a.transact(34, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void a(s s1, int i1, String s2, String s3, String s4, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_100;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            parcel.writeString(s3);
            parcel.writeString(s4);
            parcel.writeStringArray(as);
            a.transact(33, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void a(s s1, int i1, String s2, String s3, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            parcel.writeString(s3);
            parcel.writeStringArray(as);
            a.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void a(s s1, int i1, String s2, String s3, String as[], Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            parcel.writeString(s3);
            parcel.writeStringArray(as);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(30, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void a(s s1, int i1, String s2, String s3, String as[], String s4, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            parcel.writeString(s3);
            parcel.writeStringArray(as);
            parcel.writeString(s4);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void a(s s1, int i1, String s2, String s3, String as[], String s4, IBinder ibinder, 
                String s5, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            parcel.writeString(s3);
            parcel.writeStringArray(as);
            parcel.writeString(s4);
            parcel.writeStrongBinder(ibinder);
            parcel.writeString(s5);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void a(s s1, int i1, String s2, String as[], String s3, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            parcel.writeStringArray(as);
            parcel.writeString(s3);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(20, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void a(s s1, GetServiceRequest getservicerequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            if (getservicerequest == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            getservicerequest.writeToParcel(parcel, 0);
_L6:
            a.transact(46, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void a(s s1, ValidateAccountRequest validateaccountrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            if (validateaccountrequest == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            validateaccountrequest.writeToParcel(parcel, 0);
_L6:
            a.transact(47, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public IBinder asBinder()
        {
            return a;
        }

        public void b(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(21, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void b(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void c(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(22, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void c(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void d(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(24, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void d(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void e(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(26, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void e(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void f(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(31, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void f(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void g(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(32, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void g(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(12, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void h(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(35, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void h(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void i(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(36, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void i(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void j(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(40, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void j(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(15, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void k(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(42, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void k(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void l(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(44, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void l(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(17, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void m(s s1, int i1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s1 = s1.asBinder();
_L1:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            a.transact(45, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1 = null;
              goto _L1
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void m(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void n(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(23, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void o(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(25, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void p(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(27, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void q(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(37, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void r(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(38, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void s(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(41, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        public void t(s s1, int i1, String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (s1 == null) goto _L2; else goto _L1
_L1:
            s1 = s1.asBinder();
_L5:
            parcel.writeStrongBinder(s1);
            parcel.writeInt(i1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(43, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            s1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
              goto _L5
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract void a()
        throws RemoteException;

    public abstract void a(s s1, int i1)
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, IBinder ibinder, Bundle bundle)
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, String s3)
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, String s3, String s4, String as[])
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, String s3, String as[])
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, String s3, String as[], Bundle bundle)
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, String s3, String as[], String s4, Bundle bundle)
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, String s3, String as[], String s4, IBinder ibinder, 
            String s5, Bundle bundle)
        throws RemoteException;

    public abstract void a(s s1, int i1, String s2, String as[], String s3, Bundle bundle)
        throws RemoteException;

    public abstract void a(s s1, GetServiceRequest getservicerequest)
        throws RemoteException;

    public abstract void a(s s1, ValidateAccountRequest validateaccountrequest)
        throws RemoteException;

    public abstract void b(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void b(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void c(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void c(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void d(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void d(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void e(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void e(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void f(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void f(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void g(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void g(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void h(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void h(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void i(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void i(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void j(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void j(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void k(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void k(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void l(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void l(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void m(s s1, int i1, String s2)
        throws RemoteException;

    public abstract void m(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void n(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void o(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void p(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void q(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void r(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void s(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;

    public abstract void t(s s1, int i1, String s2, Bundle bundle)
        throws RemoteException;
}

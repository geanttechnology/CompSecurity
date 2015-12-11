// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            em

public interface en
    extends IInterface
{
    public static abstract class a extends Binder
        implements en
    {

        public static en z(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (iinterface != null && (iinterface instanceof en))
            {
                return (en)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i1, Parcel parcel, Parcel parcel1, int j1)
            throws RemoteException
        {
            Object obj7 = null;
            Object obj8 = null;
            String as1[] = null;
            String s16 = null;
            IBinder ibinder1 = null;
            String s18 = null;
            Object obj9 = null;
            Object obj10 = null;
            Object obj11 = null;
            Object obj12 = null;
            Object obj13 = null;
            Object obj14 = null;
            Object obj15 = null;
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
                obj = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                obj7 = parcel.readString();
                obj8 = parcel.readString();
                as1 = parcel.createStringArray();
                s16 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(((em) (obj)), i1, ((String) (obj7)), ((String) (obj8)), as1, s16, parcel);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj7 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                obj8 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                a(((em) (obj7)), i1, ((String) (obj8)), ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.internal.em.a.y(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.internal.em.a.y(parcel.readStrongBinder()), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                obj8 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                as1 = parcel.readString();
                Object obj1 = obj7;
                if (parcel.readInt() != 0)
                {
                    obj1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                b(((em) (obj8)), i1, as1, ((Bundle) (obj1)));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em3 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                as1 = parcel.readString();
                Object obj2 = obj8;
                if (parcel.readInt() != 0)
                {
                    obj2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                c(em3, i1, as1, ((Bundle) (obj2)));
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em4 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s3 = parcel.readString();
                Object obj3 = as1;
                if (parcel.readInt() != 0)
                {
                    obj3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                d(em4, i1, s3, ((Bundle) (obj3)));
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em5 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s4 = parcel.readString();
                Object obj4 = s16;
                if (parcel.readInt() != 0)
                {
                    obj4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                e(em5, i1, s4, ((Bundle) (obj4)));
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s = parcel.readString();
                String s5 = parcel.readString();
                String as2[] = parcel.createStringArray();
                String s17 = parcel.readString();
                ibinder1 = parcel.readStrongBinder();
                s18 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(em, i1, s, s5, as2, s17, ibinder1, s18, parcel);
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.internal.em.a.y(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em6 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s6 = parcel.readString();
                Object obj5 = ibinder1;
                if (parcel.readInt() != 0)
                {
                    obj5 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                f(em6, i1, s6, ((Bundle) (obj5)));
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em7 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s7 = parcel.readString();
                Object obj6 = s18;
                if (parcel.readInt() != 0)
                {
                    obj6 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                g(em7, i1, s7, ((Bundle) (obj6)));
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em8 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s8 = parcel.readString();
                Bundle bundle = obj9;
                if (parcel.readInt() != 0)
                {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                h(em8, i1, s8, bundle);
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em9 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s9 = parcel.readString();
                Bundle bundle1 = obj10;
                if (parcel.readInt() != 0)
                {
                    bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                i(em9, i1, s9, bundle1);
                parcel1.writeNoException();
                return true;

            case 15: // '\017'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em10 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s10 = parcel.readString();
                Bundle bundle2 = obj11;
                if (parcel.readInt() != 0)
                {
                    bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                j(em10, i1, s10, bundle2);
                parcel1.writeNoException();
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em11 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s11 = parcel.readString();
                Bundle bundle3 = obj12;
                if (parcel.readInt() != 0)
                {
                    bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                k(em11, i1, s11, bundle3);
                parcel1.writeNoException();
                return true;

            case 17: // '\021'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em12 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s12 = parcel.readString();
                Bundle bundle4 = obj13;
                if (parcel.readInt() != 0)
                {
                    bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                l(em12, i1, s12, bundle4);
                parcel1.writeNoException();
                return true;

            case 18: // '\022'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em13 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s13 = parcel.readString();
                Bundle bundle5 = obj14;
                if (parcel.readInt() != 0)
                {
                    bundle5 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                m(em13, i1, s13, bundle5);
                parcel1.writeNoException();
                return true;

            case 19: // '\023'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em1 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s1 = parcel.readString();
                IBinder ibinder = parcel.readStrongBinder();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(em1, i1, s1, ibinder, parcel);
                parcel1.writeNoException();
                return true;

            case 20: // '\024'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em2 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s2 = parcel.readString();
                String as[] = parcel.createStringArray();
                String s15 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(em2, i1, s2, as, s15, parcel);
                parcel1.writeNoException();
                return true;

            case 21: // '\025'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                b(com.google.android.gms.internal.em.a.y(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 22: // '\026'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                c(com.google.android.gms.internal.em.a.y(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 23: // '\027'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                em em14 = com.google.android.gms.internal.em.a.y(parcel.readStrongBinder());
                i1 = parcel.readInt();
                String s14 = parcel.readString();
                Bundle bundle6 = obj15;
                if (parcel.readInt() != 0)
                {
                    bundle6 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                n(em14, i1, s14, bundle6);
                parcel1.writeNoException();
                return true;

            case 24: // '\030'
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                d(com.google.android.gms.internal.em.a.y(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static class a.a
        implements en
    {

        private IBinder ky;

        public void a(em em1, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            em1 = em1.asBinder();
_L1:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            ky.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            em1 = null;
              goto _L1
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
        }

        public void a(em em1, int i1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            em1 = em1.asBinder();
_L1:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            ky.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            em1 = null;
              goto _L1
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
        }

        public void a(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void a(em em1, int i1, String s, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void a(em em1, int i1, String s, String s1, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            em1 = em1.asBinder();
_L1:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeStringArray(as);
            ky.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            em1 = null;
              goto _L1
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
        }

        public void a(em em1, int i1, String s, String s1, String as[], String s2, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeStringArray(as);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void a(em em1, int i1, String s, String s1, String as[], String s2, IBinder ibinder, 
                String s3, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeStringArray(as);
            parcel.writeString(s2);
            parcel.writeStrongBinder(ibinder);
            parcel.writeString(s3);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void a(em em1, int i1, String s, String as[], String s1, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            parcel.writeStringArray(as);
            parcel.writeString(s1);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(20, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public IBinder asBinder()
        {
            return ky;
        }

        public void b(em em1, int i1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            em1 = em1.asBinder();
_L1:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            ky.transact(21, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            em1 = null;
              goto _L1
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
        }

        public void b(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void c(em em1, int i1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            em1 = em1.asBinder();
_L1:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            ky.transact(22, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            em1 = null;
              goto _L1
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
        }

        public void c(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void d(em em1, int i1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            em1 = em1.asBinder();
_L1:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            ky.transact(24, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            em1 = null;
              goto _L1
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
        }

        public void d(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void e(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void f(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void g(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(12, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void h(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void i(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void j(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(15, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void k(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void l(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(17, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void m(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        public void n(em em1, int i1, String s, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (em1 == null) goto _L2; else goto _L1
_L1:
            em1 = em1.asBinder();
_L5:
            parcel.writeStrongBinder(em1);
            parcel.writeInt(i1);
            parcel.writeString(s);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(23, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            em1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
              goto _L5
        }

        a.a(IBinder ibinder)
        {
            ky = ibinder;
        }
    }


    public abstract void a(em em, int i1)
        throws RemoteException;

    public abstract void a(em em, int i1, String s)
        throws RemoteException;

    public abstract void a(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void a(em em, int i1, String s, IBinder ibinder, Bundle bundle)
        throws RemoteException;

    public abstract void a(em em, int i1, String s, String s1, String as[])
        throws RemoteException;

    public abstract void a(em em, int i1, String s, String s1, String as[], String s2, Bundle bundle)
        throws RemoteException;

    public abstract void a(em em, int i1, String s, String s1, String as[], String s2, IBinder ibinder, 
            String s3, Bundle bundle)
        throws RemoteException;

    public abstract void a(em em, int i1, String s, String as[], String s1, Bundle bundle)
        throws RemoteException;

    public abstract void b(em em, int i1, String s)
        throws RemoteException;

    public abstract void b(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void c(em em, int i1, String s)
        throws RemoteException;

    public abstract void c(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void d(em em, int i1, String s)
        throws RemoteException;

    public abstract void d(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void e(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void f(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void g(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void h(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void i(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void j(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void k(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void l(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void m(em em, int i1, String s, Bundle bundle)
        throws RemoteException;

    public abstract void n(em em, int i1, String s, Bundle bundle)
        throws RemoteException;
}

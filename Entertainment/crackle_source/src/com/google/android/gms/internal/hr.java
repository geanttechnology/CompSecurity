// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ey, ho, ez

public interface hr
    extends IInterface
{
    public static abstract class a extends Binder
        implements hr
    {

        public static hr ax(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            if (iinterface != null && (iinterface instanceof hr))
            {
                return (hr)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Uri uri = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.plus.internal.IPlusService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                if (parcel.readInt() != 0)
                {
                    parcel = ey.CREATOR.x(parcel);
                } else
                {
                    parcel = null;
                }
                a(parcel);
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                parcel = getAccountName();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                clearDefaultAccount();
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                ho ho = com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
                } else
                {
                    uri = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(ho, uri, parcel);
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                ho ho1 = com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder());
                i = parcel.readInt();
                String s = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
                }
                a(ho1, i, s, uri, parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 17: // '\021'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                removeMoment(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 18: // '\022'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                c(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 19: // '\023'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 34: // '"'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel1.writeNoException();
                return true;

            case 40: // '('
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                d(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 41: // ')'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                parcel = eO();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 42: // '*'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                boolean flag = eP();
                parcel1.writeNoException();
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                parcel1.writeInt(i);
                return true;

            case 43: // '+'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                parcel = eQ();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 44: // ','
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                e(com.google.android.gms.internal.ho.a.au(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static class a.a
        implements hr
    {

        private IBinder dU;

        public void a(ey ey1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ey1 == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            ey1.writeToParcel(parcel, 0);
_L1:
            dU.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            ey1;
            parcel1.recycle();
            parcel.recycle();
            throw ey1;
        }

        public void a(ho ho1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            dU.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public void a(ho ho1, int i, int j, int k, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            parcel.writeString(s);
            dU.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public void a(ho ho1, int i, String s, Uri uri, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null) goto _L2; else goto _L1
_L1:
            ho1 = ho1.asBinder();
_L5:
            parcel.writeStrongBinder(ho1);
            parcel.writeInt(i);
            parcel.writeString(s);
            if (uri == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L6:
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ho1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
              goto _L5
        }

        public void a(ho ho1, Uri uri, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null) goto _L2; else goto _L1
_L1:
            ho1 = ho1.asBinder();
_L5:
            parcel.writeStrongBinder(ho1);
            if (uri == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L6:
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_128;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L7:
            dU.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ho1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
            parcel.writeInt(0);
              goto _L7
        }

        public void a(ho ho1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            parcel.writeString(s);
            dU.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public void a(ho ho1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            parcel.writeString(s);
            parcel.writeString(s1);
            dU.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public void a(ho ho1, List list)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            parcel.writeStringList(list);
            dU.transact(34, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public IBinder asBinder()
        {
            return dU;
        }

        public void b(ho ho1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            dU.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public void b(ho ho1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            parcel.writeString(s);
            dU.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public void c(ho ho1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            parcel.writeString(s);
            dU.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public void clearDefaultAccount()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            dU.transact(6, parcel, parcel1, 0);
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

        public void d(ho ho1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            parcel.writeString(s);
            dU.transact(40, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public void e(ho ho1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (ho1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            ho1 = ho1.asBinder();
_L1:
            parcel.writeStrongBinder(ho1);
            parcel.writeString(s);
            dU.transact(44, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ho1 = null;
              goto _L1
            ho1;
            parcel1.recycle();
            parcel.recycle();
            throw ho1;
        }

        public String eO()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            dU.transact(41, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public boolean eP()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            dU.transact(42, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i != 0)
            {
                flag = true;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public String eQ()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            dU.transact(43, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public String getAccountName()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            dU.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void removeMoment(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            parcel.writeString(s);
            dU.transact(17, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        a.a(IBinder ibinder)
        {
            dU = ibinder;
        }
    }


    public abstract void a(ey ey)
        throws RemoteException;

    public abstract void a(ho ho)
        throws RemoteException;

    public abstract void a(ho ho, int i, int j, int k, String s)
        throws RemoteException;

    public abstract void a(ho ho, int i, String s, Uri uri, String s1, String s2)
        throws RemoteException;

    public abstract void a(ho ho, Uri uri, Bundle bundle)
        throws RemoteException;

    public abstract void a(ho ho, String s)
        throws RemoteException;

    public abstract void a(ho ho, String s, String s1)
        throws RemoteException;

    public abstract void a(ho ho, List list)
        throws RemoteException;

    public abstract void b(ho ho)
        throws RemoteException;

    public abstract void b(ho ho, String s)
        throws RemoteException;

    public abstract void c(ho ho, String s)
        throws RemoteException;

    public abstract void clearDefaultAccount()
        throws RemoteException;

    public abstract void d(ho ho, String s)
        throws RemoteException;

    public abstract void e(ho ho, String s)
        throws RemoteException;

    public abstract String eO()
        throws RemoteException;

    public abstract boolean eP()
        throws RemoteException;

    public abstract String eQ()
        throws RemoteException;

    public abstract String getAccountName()
        throws RemoteException;

    public abstract void removeMoment(String s)
        throws RemoteException;
}

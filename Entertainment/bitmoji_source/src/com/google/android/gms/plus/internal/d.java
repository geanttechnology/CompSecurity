// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fi;
import java.util.List;

// Referenced classes of package com.google.android.gms.plus.internal:
//            b

public interface d
    extends IInterface
{
    public static abstract class a extends Binder
        implements d
    {

        public static d aA(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            if (iinterface != null && (iinterface instanceof d))
            {
                return (d)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            b b1 = null;
            Object obj = null;
            b b2;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.plus.internal.IPlusService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                if (parcel.readInt() != 0)
                {
                    parcel = fh.CREATOR.x(parcel);
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
                a(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b1 = com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    obj = (Uri)Uri.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                a(b1, ((Uri) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b1 = com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder());
                i = parcel.readInt();
                String s = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj = (Uri)Uri.CREATOR.createFromParcel(parcel);
                }
                a(b1, i, s, ((Uri) (obj)), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 17: // '\021'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                removeMoment(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 18: // '\022'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                c(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 19: // '\023'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 34: // '"'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel1.writeNoException();
                return true;

            case 40: // '('
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                d(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 41: // ')'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                parcel = hl();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 42: // '*'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                boolean flag = hm();
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
                parcel = hn();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 44: // ','
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                e(com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 45: // '-'
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b2 = com.google.android.gms.plus.internal.b.a.ay(parcel.readStrongBinder());
                obj = b1;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = fh.CREATOR.x(parcel);
            }
            a(b2, ((fh) (obj)));
            parcel1.writeNoException();
            return true;
        }
    }

    private static class a.a
        implements d
    {

        private IBinder ky;

        public void a(fh fh1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (fh1 == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            fh1.writeToParcel(parcel, 0);
_L1:
            ky.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            fh1;
            parcel1.recycle();
            parcel.recycle();
            throw fh1;
        }

        public void a(b b1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            ky.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public void a(b b1, int i, int j, int k, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            parcel.writeString(s);
            ky.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public void a(b b1, int i, String s, Uri uri, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null) goto _L2; else goto _L1
_L1:
            b1 = b1.asBinder();
_L5:
            parcel.writeStrongBinder(b1);
            parcel.writeInt(i);
            parcel.writeString(s);
            if (uri == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L6:
            parcel.writeString(s1);
            parcel.writeString(s2);
            ky.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            b1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
              goto _L5
        }

        public void a(b b1, Uri uri, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null) goto _L2; else goto _L1
_L1:
            b1 = b1.asBinder();
_L5:
            parcel.writeStrongBinder(b1);
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
            ky.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            b1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
            parcel.writeInt(0);
              goto _L7
        }

        public void a(b b1, fh fh1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null) goto _L2; else goto _L1
_L1:
            b1 = b1.asBinder();
_L5:
            parcel.writeStrongBinder(b1);
            if (fh1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            fh1.writeToParcel(parcel, 0);
_L6:
            ky.transact(45, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            b1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
              goto _L5
        }

        public void a(b b1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeString(s);
            ky.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public void a(b b1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public void a(b b1, List list)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeStringList(list);
            ky.transact(34, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public IBinder asBinder()
        {
            return ky;
        }

        public void b(b b1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            ky.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public void b(b b1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeString(s);
            ky.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public void c(b b1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeString(s);
            ky.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public void clearDefaultAccount()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            ky.transact(6, parcel, parcel1, 0);
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

        public void d(b b1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeString(s);
            ky.transact(40, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public void e(b b1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeString(s);
            ky.transact(44, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
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
            ky.transact(5, parcel, parcel1, 0);
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

        public String hl()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            ky.transact(41, parcel, parcel1, 0);
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

        public boolean hm()
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
            ky.transact(42, parcel, parcel1, 0);
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

        public String hn()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            ky.transact(43, parcel, parcel1, 0);
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
            ky.transact(17, parcel, parcel1, 0);
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
            ky = ibinder;
        }
    }


    public abstract void a(fh fh)
        throws RemoteException;

    public abstract void a(b b1)
        throws RemoteException;

    public abstract void a(b b1, int i, int j, int k, String s)
        throws RemoteException;

    public abstract void a(b b1, int i, String s, Uri uri, String s1, String s2)
        throws RemoteException;

    public abstract void a(b b1, Uri uri, Bundle bundle)
        throws RemoteException;

    public abstract void a(b b1, fh fh)
        throws RemoteException;

    public abstract void a(b b1, String s)
        throws RemoteException;

    public abstract void a(b b1, String s, String s1)
        throws RemoteException;

    public abstract void a(b b1, List list)
        throws RemoteException;

    public abstract void b(b b1)
        throws RemoteException;

    public abstract void b(b b1, String s)
        throws RemoteException;

    public abstract void c(b b1, String s)
        throws RemoteException;

    public abstract void clearDefaultAccount()
        throws RemoteException;

    public abstract void d(b b1, String s)
        throws RemoteException;

    public abstract void e(b b1, String s)
        throws RemoteException;

    public abstract String getAccountName()
        throws RemoteException;

    public abstract String hl()
        throws RemoteException;

    public abstract boolean hm()
        throws RemoteException;

    public abstract String hn()
        throws RemoteException;

    public abstract void removeMoment(String s)
        throws RemoteException;
}

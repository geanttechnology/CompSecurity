// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

// Referenced classes of package com.google.android.gms.internal:
//            ac, v, w, x, 
//            y, ab, ae

public static abstract class attachInterface extends Binder
    implements ac
{
    private static class a
        implements ac
    {

        private IBinder dU;

        public void H()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            dU.transact(11, parcel, parcel1, 0);
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

        public void a(ab ab1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (ab1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            ab1 = ab1.asBinder();
_L1:
            parcel.writeStrongBinder(ab1);
            dU.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ab1 = null;
              goto _L1
            ab1;
            parcel1.recycle();
            parcel.recycle();
            throw ab1;
        }

        public void a(ae ae1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (ae1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            ae1 = ae1.asBinder();
_L1:
            parcel.writeStrongBinder(ae1);
            dU.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ae1 = null;
              goto _L1
            ae1;
            parcel1.recycle();
            parcel.recycle();
            throw ae1;
        }

        public void a(x x1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (x1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            x1.writeToParcel(parcel, 0);
_L1:
            dU.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            x1;
            parcel1.recycle();
            parcel.recycle();
            throw x1;
        }

        public boolean a(v v1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (v1 == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            parcel.writeInt(1);
            v1.writeToParcel(parcel, 0);
_L1:
            int i;
            dU.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i == 0)
            {
                flag = false;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            parcel.writeInt(0);
              goto _L1
            v1;
            parcel1.recycle();
            parcel.recycle();
            throw v1;
        }

        public IBinder asBinder()
        {
            return dU;
        }

        public void destroy()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            dU.transact(2, parcel, parcel1, 0);
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

        public boolean isReady()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            dU.transact(3, parcel, parcel1, 0);
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

        public void pause()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            dU.transact(5, parcel, parcel1, 0);
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

        public void resume()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
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

        public void showInterstitial()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            dU.transact(9, parcel, parcel1, 0);
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

        public void stopLoading()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            dU.transact(10, parcel, parcel1, 0);
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

        public b x()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            b b1;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            dU.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            b1 = com.google.android.gms.dynamic.b.a.E(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return b1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public x y()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            dU.transact(12, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            x x1 = x.CREATOR.b(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return x1;
_L2:
            x1 = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        a(IBinder ibinder)
        {
            dU = ibinder;
        }
    }


    public static ac f(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (iinterface != null && (iinterface instanceof ac))
        {
            return (ac)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        b b1 = null;
        Object obj1 = null;
        Object obj = null;
        boolean flag = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.client.IAdManager");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            b1 = x();
            parcel1.writeNoException();
            parcel = ((Parcel) (obj));
            if (b1 != null)
            {
                parcel = b1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            destroy();
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            boolean flag1 = isReady();
            parcel1.writeNoException();
            if (flag1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            obj = b1;
            if (parcel.readInt() != 0)
            {
                obj = v.CREATOR.a(parcel);
            }
            boolean flag2 = a(((v) (obj)));
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag2)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            pause();
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            resume();
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            a(e(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            a(h(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            showInterstitial();
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            stopLoading();
            parcel1.writeNoException();
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            H();
            parcel1.writeNoException();
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            parcel = y();
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

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            obj = obj1;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = x.CREATOR.b(parcel);
        }
        a(((x) (obj)));
        parcel1.writeNoException();
        return true;
    }

    public a.dU()
    {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }
}

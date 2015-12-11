// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

// Referenced classes of package com.google.android.gms.internal:
//            gj, gh, gi

public static abstract class a.dU extends Binder
    implements gj
{
    private static class a
        implements gj
    {

        private IBinder dU;

        public void I(Status status)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.ICopresenceCallbacks");
            if (status == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
_L1:
            dU.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            status;
            parcel1.recycle();
            parcel.recycle();
            throw status;
        }

        public void a(int i, gh gh1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.ICopresenceCallbacks");
            parcel.writeInt(i);
            if (gh1 == null)
            {
                break MISSING_BLOCK_LABEL_65;
            }
            parcel.writeInt(1);
            gh1.writeToParcel(parcel, 0);
_L1:
            dU.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            gh1;
            parcel1.recycle();
            parcel.recycle();
            throw gh1;
        }

        public void a(int i, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.ICopresenceCallbacks");
            parcel.writeInt(i);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
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

        public IBinder asBinder()
        {
            return dU;
        }

        public void b(int i, gh gh1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.ICopresenceCallbacks");
            parcel.writeInt(i);
            if (gh1 == null)
            {
                break MISSING_BLOCK_LABEL_65;
            }
            parcel.writeInt(1);
            gh1.writeToParcel(parcel, 0);
_L1:
            dU.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            gh1;
            parcel1.recycle();
            parcel.recycle();
            throw gh1;
        }

        a(IBinder ibinder)
        {
            dU = ibinder;
        }
    }


    public static gj J(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
        if (iinterface != null && (iinterface instanceof gj))
        {
            return (gj)iinterface;
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
        Object obj = null;
        Object obj1 = null;
        Status status = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.location.internal.ICopresenceCallbacks");
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
            if (parcel.readInt() != 0)
            {
                status = Status.CREATOR.createFromParcel(parcel);
            }
            I(status);
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
            i = parcel.readInt();
            gh gh1 = obj;
            if (parcel.readInt() != 0)
            {
                gh1 = gh.CREATOR.ah(parcel);
            }
            a(i, gh1);
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
            i = parcel.readInt();
            gh gh2 = obj1;
            if (parcel.readInt() != 0)
            {
                gh2 = gh.CREATOR.ah(parcel);
            }
            b(i, gh2);
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.location.internal.ICopresenceCallbacks");
            i = parcel.readInt();
            break;
        }
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(i, flag);
        parcel1.writeNoException();
        return true;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.f;

// Referenced classes of package android.support.v7:
//            uz, va

public static abstract class a.a extends Binder
    implements uz
{
    private static class a
        implements uz
    {

        private IBinder a;

        public void a(va va1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (va1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            va1 = va1.asBinder();
_L1:
            parcel.writeStrongBinder(va1);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            va1 = null;
              goto _L1
            va1;
            parcel1.recycle();
            parcel.recycle();
            throw va1;
        }

        public void a(va va1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (va1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            va1 = va1.asBinder();
_L1:
            parcel.writeStrongBinder(va1);
            parcel.writeString(s);
            parcel.writeString(s1);
            a.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            va1 = null;
              goto _L1
            va1;
            parcel1.recycle();
            parcel.recycle();
            throw va1;
        }

        public void a(va va1, String s, UsageInfo ausageinfo[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (va1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            va1 = va1.asBinder();
_L1:
            parcel.writeStrongBinder(va1);
            parcel.writeString(s);
            parcel.writeTypedArray(ausageinfo, 0);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            va1 = null;
              goto _L1
            va1;
            parcel1.recycle();
            parcel.recycle();
            throw va1;
        }

        public void a(va va1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (va1 == null)
            {
                break MISSING_BLOCK_LABEL_77;
            }
            va1 = va1.asBinder();
_L1:
            parcel.writeStrongBinder(va1);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            a.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            va1 = null;
              goto _L1
            va1;
            parcel1.recycle();
            parcel.recycle();
            throw va1;
        }

        public void a(com.google.android.gms.appdatasearch.GetRecentContextCall.Request request, va va1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (request == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            request.writeToParcel(parcel, 0);
_L3:
            if (va1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            request = va1.asBinder();
_L4:
            parcel.writeStrongBinder(request);
            a.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            request;
            parcel1.recycle();
            parcel.recycle();
            throw request;
            request = null;
              goto _L4
        }

        public IBinder asBinder()
        {
            return a;
        }

        public void b(va va1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (va1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            va1 = va1.asBinder();
_L1:
            parcel.writeStrongBinder(va1);
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            va1 = null;
              goto _L1
            va1;
            parcel1.recycle();
            parcel.recycle();
            throw va1;
        }

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static uz a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (iinterface != null && (iinterface instanceof uz))
        {
            return (uz)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            a(a(parcel.readStrongBinder()), parcel.readString(), (UsageInfo[])parcel.createTypedArray(UsageInfo.CREATOR));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            a(a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            b(a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            va va = a(parcel.readStrongBinder());
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(va, flag);
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            com.google.android.gms.appdatasearch.centContextCall.Request request;
            if (parcel.readInt() != 0)
            {
                request = com.google.android.gms.appdatasearch.centContextCall.Request.CREATOR.a(parcel);
            } else
            {
                request = null;
            }
            a(request, a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            a(a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}

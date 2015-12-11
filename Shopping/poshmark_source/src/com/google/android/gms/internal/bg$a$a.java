// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

// Referenced classes of package com.google.android.gms.internal:
//            bg, ab, z, bh

private static class ky
    implements bg
{

    private IBinder ky;

    public void a(b b1, ab ab1, z z1, String s, bh bh1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (b1 == null) goto _L2; else goto _L1
_L1:
        b1 = b1.asBinder();
_L5:
        parcel.writeStrongBinder(b1);
        if (ab1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        ab1.writeToParcel(parcel, 0);
_L6:
        if (z1 == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        parcel.writeInt(1);
        z1.writeToParcel(parcel, 0);
_L7:
        parcel.writeString(s);
        b1 = obj;
        if (bh1 == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        b1 = bh1.asBinder();
        parcel.writeStrongBinder(b1);
        ky.transact(1, parcel, parcel1, 0);
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

    public void a(b b1, ab ab1, z z1, String s, String s1, bh bh1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (b1 == null) goto _L2; else goto _L1
_L1:
        b1 = b1.asBinder();
_L5:
        parcel.writeStrongBinder(b1);
        if (ab1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        ab1.writeToParcel(parcel, 0);
_L6:
        if (z1 == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        parcel.writeInt(1);
        z1.writeToParcel(parcel, 0);
_L7:
        parcel.writeString(s);
        parcel.writeString(s1);
        b1 = obj;
        if (bh1 == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        b1 = bh1.asBinder();
        parcel.writeStrongBinder(b1);
        ky.transact(6, parcel, parcel1, 0);
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

    public void a(b b1, z z1, String s, bh bh1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (b1 == null) goto _L2; else goto _L1
_L1:
        b1 = b1.asBinder();
_L5:
        parcel.writeStrongBinder(b1);
        if (z1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        z1.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        b1 = obj;
        if (bh1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        b1 = bh1.asBinder();
        parcel.writeStrongBinder(b1);
        ky.transact(3, parcel, parcel1, 0);
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

    public void a(b b1, z z1, String s, String s1, bh bh1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (b1 == null) goto _L2; else goto _L1
_L1:
        b1 = b1.asBinder();
_L5:
        parcel.writeStrongBinder(b1);
        if (z1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        z1.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        parcel.writeString(s1);
        b1 = obj;
        if (bh1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        b1 = bh1.asBinder();
        parcel.writeStrongBinder(b1);
        ky.transact(7, parcel, parcel1, 0);
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

    public IBinder asBinder()
    {
        return ky;
    }

    public void destroy()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        ky.transact(5, parcel, parcel1, 0);
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

    public b getView()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        b b1;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        ky.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        b1 = com.google.android.gms.dynamic..ky(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return b1;
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
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        ky.transact(4, parcel, parcel1, 0);
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

    (IBinder ibinder)
    {
        ky = ibinder;
    }
}

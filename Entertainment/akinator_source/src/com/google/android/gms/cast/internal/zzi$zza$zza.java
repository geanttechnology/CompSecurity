// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzi

private static class zznJ
    implements zzi
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void disconnect()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void zza(double d, double d1, boolean flag)
        throws RemoteException
    {
        Parcel parcel;
        int i;
        i = 1;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeDouble(d);
        parcel.writeDouble(d1);
        if (!flag)
        {
            i = 0;
        }
        parcel.writeInt(i);
        zznJ.transact(7, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void zza(String s, LaunchOptions launchoptions)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        if (launchoptions == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        parcel.writeInt(1);
        launchoptions.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(13, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        s;
        parcel.recycle();
        throw s;
    }

    public void zza(String s, String s1, JoinOptions joinoptions)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        parcel.writeString(s1);
        if (joinoptions == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        parcel.writeInt(1);
        joinoptions.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(14, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        s;
        parcel.recycle();
        throw s;
    }

    public void zza(String s, byte abyte0[], long l)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        parcel.writeByteArray(abyte0);
        parcel.writeLong(l);
        zznJ.transact(10, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void zza(boolean flag, double d, boolean flag1)
        throws RemoteException
    {
        Parcel parcel;
        boolean flag2;
        flag2 = true;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeDouble(d);
        if (flag1)
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        zznJ.transact(8, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void zzb(String s, String s1, long l)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeLong(l);
        zznJ.transact(9, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void zzbP(String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        zznJ.transact(5, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void zzbQ(String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        zznJ.transact(11, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void zzbR(String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        zznJ.transact(12, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void zzf(String s, boolean flag)
        throws RemoteException
    {
        Parcel parcel;
        int i;
        i = 1;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        if (!flag)
        {
            i = 0;
        }
        parcel.writeInt(i);
        zznJ.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void zzmT()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        zznJ.transact(6, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void zzne()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        zznJ.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void zzt(String s, String s1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        parcel.writeString(s1);
        zznJ.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}

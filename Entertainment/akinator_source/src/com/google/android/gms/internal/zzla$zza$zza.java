// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzla

private static class zznJ
    implements zzla
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zzbg(int i)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
        parcel.writeInt(i);
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}

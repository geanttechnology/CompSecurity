// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.support.v7:
//            nx, nw

private static class a
    implements nx
{

    private IBinder a;

    public void a(nw nw1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        if (nw1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        nw1 = nw1.asBinder();
_L1:
        parcel.writeStrongBinder(nw1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        nw1 = null;
          goto _L1
        nw1;
        parcel1.recycle();
        parcel.recycle();
        throw nw1;
    }

    public IBinder asBinder()
    {
        return a;
    }

    (IBinder ibinder)
    {
        a = ibinder;
    }
}

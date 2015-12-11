// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

class uo
    implements um
{

    private IBinder a;

    uo(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a(uj uj1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        if (uj1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        uj1 = uj1.asBinder();
_L1:
        parcel.writeStrongBinder(uj1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        uj1 = null;
          goto _L1
        uj1;
        parcel1.recycle();
        parcel.recycle();
        throw uj1;
    }

    public IBinder asBinder()
    {
        return a;
    }
}

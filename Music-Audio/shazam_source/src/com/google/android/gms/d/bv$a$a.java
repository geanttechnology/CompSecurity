// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.d:
//            bv, br

private static final class a
    implements bv
{

    private IBinder a;

    public final void a(br br1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        if (br1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        br1 = br1.asBinder();
_L1:
        parcel.writeStrongBinder(br1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        br1 = null;
          goto _L1
        br1;
        parcel1.recycle();
        parcel.recycle();
        throw br1;
    }

    public final IBinder asBinder()
    {
        return a;
    }

    public (IBinder ibinder)
    {
        a = ibinder;
    }
}

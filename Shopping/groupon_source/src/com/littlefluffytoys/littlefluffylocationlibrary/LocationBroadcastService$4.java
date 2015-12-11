// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.littlefluffytoys.littlefluffylocationlibrary:
//            LocationBroadcastService

class this._cls0 extends Binder
{

    final LocationBroadcastService this$0;

    protected boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        return super.onTransact(i, parcel, parcel1, j);
    }

    Q()
    {
        this$0 = LocationBroadcastService.this;
        super();
    }
}

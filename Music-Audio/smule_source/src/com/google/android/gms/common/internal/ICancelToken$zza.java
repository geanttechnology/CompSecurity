// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.common.internal:
//            ICancelToken

public abstract class zza extends Binder
    implements ICancelToken
{

    public static ICancelToken zzR(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
        class zza
            implements ICancelToken
        {

            private IBinder zzlW;

            public IBinder asBinder()
            {
                return zzlW;
            }

            public void cancel()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
                zzlW.transact(2, parcel, parcel1, 0);
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

            zza(IBinder ibinder)
            {
                zzlW = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof ICancelToken))
        {
            return (ICancelToken)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.common.internal.ICancelToken");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.common.internal.ICancelToken");
            cancel();
            parcel1.writeNoException();
            return true;
        }
    }
}

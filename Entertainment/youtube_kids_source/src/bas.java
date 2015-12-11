// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

final class bas
    implements baq
{

    private IBinder a;

    bas(IBinder ibinder)
    {
        a = ibinder;
    }

    public final ban a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ban ban;
        parcel.writeInterfaceToken("com.google.android.gms.droidguard.internal.IDroidGuardService");
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        ban = bao.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ban;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final void a(bak bak1, String s, Map map)
    {
        IBinder ibinder;
        Parcel parcel;
        ibinder = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.droidguard.internal.IDroidGuardService");
        if (bak1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ibinder = bak1.asBinder();
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeMap(map);
        a.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        bak1;
        parcel.recycle();
        throw bak1;
    }

    public final IBinder asBinder()
    {
        return a;
    }
}

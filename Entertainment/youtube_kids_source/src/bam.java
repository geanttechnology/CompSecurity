// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

final class bam
    implements bak
{

    private IBinder a;

    bam(IBinder ibinder)
    {
        a = ibinder;
    }

    public final void a(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.droidguard.internal.IDroidGuardCallbacks");
        parcel.writeByteArray(abyte0);
        a.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        abyte0;
        parcel.recycle();
        throw abyte0;
    }

    public final IBinder asBinder()
    {
        return a;
    }
}

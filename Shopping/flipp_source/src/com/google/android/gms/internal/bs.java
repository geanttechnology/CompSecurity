// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;

// Referenced classes of package com.google.android.gms.internal:
//            bq, v, bt, x

final class bs
    implements bq
{

    private IBinder a;

    bs(IBinder ibinder)
    {
        a = ibinder;
    }

    public final a a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        a a1;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        a1 = com.google.android.gms.a.b.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return a1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final void a(a a1, v v1, String s, bt bt1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (a1 == null) goto _L2; else goto _L1
_L1:
        a1 = a1.asBinder();
_L5:
        parcel.writeStrongBinder(a1);
        if (v1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        v1.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        a1 = obj;
        if (bt1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        a1 = bt1.asBinder();
        parcel.writeStrongBinder(a1);
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        a1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        a1;
        parcel1.recycle();
        parcel.recycle();
        throw a1;
          goto _L5
    }

    public final void a(a a1, v v1, String s, String s1, bt bt1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (a1 == null) goto _L2; else goto _L1
_L1:
        a1 = a1.asBinder();
_L5:
        parcel.writeStrongBinder(a1);
        if (v1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        v1.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        parcel.writeString(s1);
        a1 = obj;
        if (bt1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        a1 = bt1.asBinder();
        parcel.writeStrongBinder(a1);
        a.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        a1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        a1;
        parcel1.recycle();
        parcel.recycle();
        throw a1;
          goto _L5
    }

    public final void a(a a1, x x1, v v1, String s, bt bt1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (a1 == null) goto _L2; else goto _L1
_L1:
        a1 = a1.asBinder();
_L5:
        parcel.writeStrongBinder(a1);
        if (x1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        x1.writeToParcel(parcel, 0);
_L6:
        if (v1 == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        parcel.writeInt(1);
        v1.writeToParcel(parcel, 0);
_L7:
        parcel.writeString(s);
        a1 = obj;
        if (bt1 == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        a1 = bt1.asBinder();
        parcel.writeStrongBinder(a1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        a1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        a1;
        parcel1.recycle();
        parcel.recycle();
        throw a1;
        parcel.writeInt(0);
          goto _L7
    }

    public final void a(a a1, x x1, v v1, String s, String s1, bt bt1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (a1 == null) goto _L2; else goto _L1
_L1:
        a1 = a1.asBinder();
_L5:
        parcel.writeStrongBinder(a1);
        if (x1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        x1.writeToParcel(parcel, 0);
_L6:
        if (v1 == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        parcel.writeInt(1);
        v1.writeToParcel(parcel, 0);
_L7:
        parcel.writeString(s);
        parcel.writeString(s1);
        a1 = obj;
        if (bt1 == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        a1 = bt1.asBinder();
        parcel.writeStrongBinder(a1);
        a.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        a1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        a1;
        parcel1.recycle();
        parcel.recycle();
        throw a1;
        parcel.writeInt(0);
          goto _L7
    }

    public final IBinder asBinder()
    {
        return a;
    }

    public final void b()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        a.transact(4, parcel, parcel1, 0);
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

    public final void c()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        a.transact(5, parcel, parcel1, 0);
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
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;

class wi
    implements wg
{

    private IBinder a;

    wi(IBinder ibinder)
    {
        a = ibinder;
    }

    public ry a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ry ry1;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(ry ry1, av av1, String s, String s1, wl wl1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        if (av1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        av1.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        parcel.writeString(s1);
        ry1 = obj;
        if (wl1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        ry1 = wl1.asBinder();
        parcel.writeStrongBinder(ry1);
        a.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ry1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
          goto _L5
    }

    public void a(ry ry1, av av1, String s, wl wl1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        if (av1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        av1.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        ry1 = obj;
        if (wl1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ry1 = wl1.asBinder();
        parcel.writeStrongBinder(ry1);
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ry1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
          goto _L5
    }

    public void a(ry ry1, ay ay1, av av1, String s, String s1, wl wl1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        if (ay1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        ay1.writeToParcel(parcel, 0);
_L6:
        if (av1 == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        parcel.writeInt(1);
        av1.writeToParcel(parcel, 0);
_L7:
        parcel.writeString(s);
        parcel.writeString(s1);
        ry1 = obj;
        if (wl1 == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        ry1 = wl1.asBinder();
        parcel.writeStrongBinder(ry1);
        a.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ry1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
        parcel.writeInt(0);
          goto _L7
    }

    public void a(ry ry1, ay ay1, av av1, String s, wl wl1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        if (ay1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        ay1.writeToParcel(parcel, 0);
_L6:
        if (av1 == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        parcel.writeInt(1);
        av1.writeToParcel(parcel, 0);
_L7:
        parcel.writeString(s);
        ry1 = obj;
        if (wl1 == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        ry1 = wl1.asBinder();
        parcel.writeStrongBinder(ry1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        ry1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
        parcel.writeInt(0);
          goto _L7
    }

    public IBinder asBinder()
    {
        return a;
    }

    public void b()
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

    public void c()
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

    public void d()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        a.transact(8, parcel, parcel1, 0);
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

    public void e()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        a.transact(9, parcel, parcel1, 0);
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.internal.ar;
import com.google.android.gms.wearable.internal.b;

class avd
    implements avb
{

    private IBinder a;

    avd(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(22, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void a(auv auv1, Uri uri)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (uri == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        uri.writeToParcel(parcel, 0);
_L6:
        a.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void a(auv auv1, Asset asset)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (asset == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        asset.writeToParcel(parcel, 0);
_L6:
        a.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void a(auv auv1, PutDataRequest putdatarequest)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (putdatarequest == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        putdatarequest.writeToParcel(parcel, 0);
_L6:
        a.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void a(auv auv1, c c1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (c1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        c1.writeToParcel(parcel, 0);
_L6:
        a.transact(20, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void a(auv auv1, ar ar1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (ar1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        ar1.writeToParcel(parcel, 0);
_L6:
        a.transact(17, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void a(auv auv1, b b1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (b1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        b1.writeToParcel(parcel, 0);
_L6:
        a.transact(16, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void a(auv auv1, String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        parcel.writeString(s);
        a.transact(21, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void a(auv auv1, String s, String s1, byte abyte0[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeByteArray(abyte0);
        a.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public IBinder asBinder()
    {
        return a;
    }

    public void b(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void b(auv auv1, Uri uri)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (uri == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        uri.writeToParcel(parcel, 0);
_L6:
        a.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void b(auv auv1, c c1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (c1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        c1.writeToParcel(parcel, 0);
_L6:
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void b(auv auv1, String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        parcel.writeString(s);
        a.transact(23, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void c(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(14, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void c(auv auv1, Uri uri)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null) goto _L2; else goto _L1
_L1:
        auv1 = auv1.asBinder();
_L5:
        parcel.writeStrongBinder(auv1);
        if (uri == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        uri.writeToParcel(parcel, 0);
_L6:
        a.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        auv1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
          goto _L5
    }

    public void c(auv auv1, String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        parcel.writeString(s);
        a.transact(24, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void d(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(15, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void e(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(18, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void f(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(19, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void g(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(25, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void h(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(26, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void i(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void j(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }

    public void k(auv auv1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
        if (auv1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        auv1 = auv1.asBinder();
_L1:
        parcel.writeStrongBinder(auv1);
        a.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        auv1 = null;
          goto _L1
        auv1;
        parcel1.recycle();
        parcel.recycle();
        throw auv1;
    }
}

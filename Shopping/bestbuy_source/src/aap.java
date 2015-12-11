// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;

class aap
    implements aan
{

    private IBinder a;

    aap(IBinder ibinder)
    {
        a = ibinder;
    }

    public fj a(fh fh1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (fh1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        fh1.writeToParcel(parcel, 0);
_L3:
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        fh1 = fj.CREATOR.a(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return fh1;
_L2:
        parcel.writeInt(0);
          goto _L3
        fh1;
        parcel1.recycle();
        parcel.recycle();
        throw fh1;
        fh1 = null;
          goto _L4
    }

    public IBinder asBinder()
    {
        return a;
    }
}

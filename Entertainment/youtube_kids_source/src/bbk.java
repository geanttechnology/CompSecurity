// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

final class bbk
    implements bbi
{

    private IBinder a;

    bbk(IBinder ibinder)
    {
        a = ibinder;
    }

    public final Bundle a(String s, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        parcel.writeString(s);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L3:
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return s;
_L2:
        parcel.writeInt(0);
          goto _L3
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
        s = null;
          goto _L4
    }

    public final Bundle a(String s, String s1, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        parcel.writeString(s);
        parcel.writeString(s1);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L3:
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        s = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return s;
_L2:
        parcel.writeInt(0);
          goto _L3
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
        s = null;
          goto _L4
    }

    public final AccountChangeEventsResponse a(AccountChangeEventsRequest accountchangeeventsrequest)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        if (accountchangeeventsrequest == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        accountchangeeventsrequest.writeToParcel(parcel, 0);
_L3:
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        accountchangeeventsrequest = AccountChangeEventsResponse.CREATOR;
        accountchangeeventsrequest = atx.a(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return accountchangeeventsrequest;
_L2:
        parcel.writeInt(0);
          goto _L3
        accountchangeeventsrequest;
        parcel1.recycle();
        parcel.recycle();
        throw accountchangeeventsrequest;
        accountchangeeventsrequest = null;
          goto _L4
    }

    public final IBinder asBinder()
    {
        return a;
    }
}

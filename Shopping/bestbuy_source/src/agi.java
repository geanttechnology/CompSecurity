// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

class agi
    implements agg
{

    private IBinder a;

    agi(IBinder ibinder)
    {
        a = ibinder;
    }

    public aga a(ry ry1, rv rv1, WalletFragmentOptions walletfragmentoptions, agd agd1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L7:
        parcel.writeStrongBinder(ry1);
        if (rv1 == null) goto _L4; else goto _L3
_L3:
        ry1 = rv1.asBinder();
_L8:
        parcel.writeStrongBinder(ry1);
        if (walletfragmentoptions == null) goto _L6; else goto _L5
_L5:
        parcel.writeInt(1);
        walletfragmentoptions.writeToParcel(parcel, 0);
_L9:
        ry1 = obj;
        if (agd1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        ry1 = agd1.asBinder();
        parcel.writeStrongBinder(ry1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = agb.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry1;
_L2:
        ry1 = null;
          goto _L7
_L4:
        ry1 = null;
          goto _L8
_L6:
        parcel.writeInt(0);
          goto _L9
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
          goto _L7
    }

    public IBinder asBinder()
    {
        return a;
    }
}

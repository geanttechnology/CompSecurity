// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

class agc
    implements aga
{

    private IBinder a;

    agc(IBinder ibinder)
    {
        a = ibinder;
    }

    public ry a(ry ry1, ry ry2, Bundle bundle)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        ry1 = obj;
        if (ry2 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        ry1 = ry2.asBinder();
        parcel.writeStrongBinder(ry1);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = rz.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ry1;
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

    public void a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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

    public void a(int i, int j, Intent intent)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        parcel.writeInt(i);
        parcel.writeInt(j);
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        parcel.writeInt(1);
        intent.writeToParcel(parcel, 0);
_L1:
        a.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        intent;
        parcel1.recycle();
        parcel.recycle();
        throw intent;
    }

    public void a(Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel1.recycle();
        parcel.recycle();
        throw bundle;
    }

    public void a(MaskedWallet maskedwallet)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (maskedwallet == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        maskedwallet.writeToParcel(parcel, 0);
_L1:
        a.transact(14, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        maskedwallet;
        parcel1.recycle();
        parcel.recycle();
        throw maskedwallet;
    }

    public void a(MaskedWalletRequest maskedwalletrequest)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (maskedwalletrequest == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        maskedwalletrequest.writeToParcel(parcel, 0);
_L1:
        a.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        maskedwalletrequest;
        parcel1.recycle();
        parcel.recycle();
        throw maskedwalletrequest;
    }

    public void a(WalletFragmentInitParams walletfragmentinitparams)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (walletfragmentinitparams == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        walletfragmentinitparams.writeToParcel(parcel, 0);
_L1:
        a.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        walletfragmentinitparams;
        parcel1.recycle();
        parcel.recycle();
        throw walletfragmentinitparams;
    }

    public void a(ry ry1, WalletFragmentOptions walletfragmentoptions, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (ry1 == null) goto _L2; else goto _L1
_L1:
        ry1 = ry1.asBinder();
_L5:
        parcel.writeStrongBinder(ry1);
        if (walletfragmentoptions == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        walletfragmentoptions.writeToParcel(parcel, 0);
_L6:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L7:
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

    public void a(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        int i;
        i = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (flag)
        {
            i = 1;
        }
        parcel.writeInt(i);
        a.transact(12, parcel, parcel1, 0);
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
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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

    public void b(Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        a.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() != 0)
        {
            bundle.readFromParcel(parcel1);
        }
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel1.recycle();
        parcel.recycle();
        throw bundle;
    }

    public void c()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        a.transact(6, parcel, parcel1, 0);
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
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        a.transact(7, parcel, parcel1, 0);
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

    public int e()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        a.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }
}

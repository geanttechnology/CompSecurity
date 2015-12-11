// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface aga
    extends IInterface
{

    public abstract ry a(ry ry, ry ry1, Bundle bundle);

    public abstract void a();

    public abstract void a(int i, int j, Intent intent);

    public abstract void a(Bundle bundle);

    public abstract void a(MaskedWallet maskedwallet);

    public abstract void a(MaskedWalletRequest maskedwalletrequest);

    public abstract void a(WalletFragmentInitParams walletfragmentinitparams);

    public abstract void a(ry ry, WalletFragmentOptions walletfragmentoptions, Bundle bundle);

    public abstract void a(boolean flag);

    public abstract void b();

    public abstract void b(Bundle bundle);

    public abstract void c();

    public abstract void d();

    public abstract int e();
}

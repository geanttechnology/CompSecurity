// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import com.google.android.gms.wallet.fragment.WalletFragment;

public class asv extends age
{

    private asu a;
    private final WalletFragment b;

    public asv(WalletFragment walletfragment)
    {
        b = walletfragment;
    }

    public void a(int i, int j, Bundle bundle)
    {
        if (a != null)
        {
            a.a(b, i, j, bundle);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import com.google.android.gms.wallet.fragment.SupportWalletFragment;

public class asr extends age
{

    private asq a;
    private final SupportWalletFragment b;

    public asr(SupportWalletFragment supportwalletfragment)
    {
        b = supportwalletfragment;
    }

    public void a(int i, int j, Bundle bundle)
    {
        if (a != null)
        {
            a.a(b, i, j, bundle);
        }
    }
}

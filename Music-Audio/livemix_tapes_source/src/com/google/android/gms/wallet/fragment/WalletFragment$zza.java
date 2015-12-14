// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.os.Bundle;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragment

static class zzaYe extends com.google.android.gms.internal.nt.zza
{

    private ateChangedListener zzaYd;
    private final WalletFragment zzaYe;

    public void zza(int i, int j, Bundle bundle)
    {
        if (zzaYd != null)
        {
            zzaYd.onStateChanged(zzaYe, i, j, bundle);
        }
    }

    public void zza(ateChangedListener atechangedlistener)
    {
        zzaYd = atechangedlistener;
    }

    ateChangedListener(WalletFragment walletfragment)
    {
        zzaYe = walletfragment;
    }
}

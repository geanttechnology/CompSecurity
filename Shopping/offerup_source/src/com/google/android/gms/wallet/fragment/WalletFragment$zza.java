// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.os.Bundle;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragment

class zzbem extends com.google.android.gms.internal.nt.zza
{

    private ateChangedListener zzbel;
    private final WalletFragment zzbem;

    public void zza(int i, int j, Bundle bundle)
    {
        if (zzbel != null)
        {
            zzbel.onStateChanged(zzbem, i, j, bundle);
        }
    }

    public void zza(ateChangedListener atechangedlistener)
    {
        zzbel = atechangedlistener;
    }

    ateChangedListener(WalletFragment walletfragment)
    {
        zzbem = walletfragment;
    }
}

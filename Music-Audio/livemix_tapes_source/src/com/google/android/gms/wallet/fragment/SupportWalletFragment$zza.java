// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.os.Bundle;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            SupportWalletFragment

static class zzaXW extends com.google.android.gms.internal.nt.zza
{

    private ateChangedListener zzaXV;
    private final SupportWalletFragment zzaXW;

    public void zza(int i, int j, Bundle bundle)
    {
        if (zzaXV != null)
        {
            zzaXV.onStateChanged(zzaXW, i, j, bundle);
        }
    }

    public void zza(ateChangedListener atechangedlistener)
    {
        zzaXV = atechangedlistener;
    }

    ateChangedListener(SupportWalletFragment supportwalletfragment)
    {
        zzaXW = supportwalletfragment;
    }
}

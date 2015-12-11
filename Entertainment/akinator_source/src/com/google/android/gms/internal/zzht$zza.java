// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            zzht

private static final class zzHO
{

    private long zzHN;
    private long zzHO;

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", zzHN);
        bundle.putLong("tclose", zzHO);
        return bundle;
    }

    public long zzgi()
    {
        return zzHO;
    }

    public void zzgj()
    {
        zzHO = SystemClock.elapsedRealtime();
    }

    public void zzgk()
    {
        zzHN = SystemClock.elapsedRealtime();
    }

    public ()
    {
        zzHN = -1L;
        zzHO = -1L;
    }
}

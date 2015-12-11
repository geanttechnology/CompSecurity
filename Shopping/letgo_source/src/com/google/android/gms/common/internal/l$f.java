// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.common.internal:
//            l

protected class a
    implements com.google.android.gms.common.api..l.f
{

    final l a;

    public void a(ConnectionResult connectionresult)
    {
        if (connectionresult.b())
        {
            a.zza(null, l.zzd(a));
        } else
        if (l.zze(a) != null)
        {
            l.zze(a).onConnectionFailed(connectionresult);
            return;
        }
    }

    public void b(ConnectionResult connectionresult)
    {
        throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }

    public ult(l l1)
    {
        a = l1;
        super();
    }
}

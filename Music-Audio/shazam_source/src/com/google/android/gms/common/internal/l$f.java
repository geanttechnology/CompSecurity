// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.common.internal:
//            l

protected final class a
    implements com.google.android.gms.common.api..l.f
{

    final l a;

    public final void a(ConnectionResult connectionresult)
    {
        if (connectionresult.b())
        {
            a.a(null, l.d(a));
        } else
        if (l.e(a) != null)
        {
            l.e(a).a(connectionresult);
            return;
        }
    }

    public final void b(ConnectionResult connectionresult)
    {
        throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }

    public ult(l l1)
    {
        a = l1;
        super();
    }
}

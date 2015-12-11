// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            hm

final class Dm extends Dm
    implements com.google.android.gms.panorama.ama.a
{

    public final Status Dl;
    public final Intent Dm;
    final hm Dn;
    public final int type;

    protected void aL()
    {
    }

    protected void b(Object obj)
    {
        c((com.google.android.gms.common.api.a.a)obj);
    }

    protected void c(com.google.android.gms.common.api.a.a a1)
    {
        a1.(this);
    }

    public Status getStatus()
    {
        return Dl;
    }

    public Intent getViewerIntent()
    {
        return Dm;
    }

    public tus(hm hm1, com.google.android.gms.common.api.s s, Status status, int i, Intent intent)
    {
        Dn = hm1;
        super(hm1, s);
        Dl = status;
        type = i;
        Dm = intent;
    }
}

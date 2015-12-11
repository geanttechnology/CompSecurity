// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            hn, hs

final class Dp extends hn
{

    final hs DM;
    private final com.google.android.gms.common.api.s Dp;

    public void b(int i, Bundle bundle)
    {
        if (bundle != null)
        {
            bundle = (PendingIntent)bundle.getParcelable("pendingIntent");
        } else
        {
            bundle = null;
        }
        bundle = new Status(i, null, bundle);
        DM.a(new <init>(DM, Dp, bundle));
    }

    public (hs hs1, com.google.android.gms.common.api.s s)
    {
        DM = hs1;
        super();
        Dp = s;
    }
}

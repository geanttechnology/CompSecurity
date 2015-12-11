// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            hm

final class Dq extends Dq
{

    final hm Dn;
    private final com.google.android.gms.common.api.s Do;
    private final com.google.android.gms.common.api.s Dp;
    private final Uri Dq;

    public void a(int i, Bundle bundle, int j, Intent intent)
    {
        if (Dq != null)
        {
            Dn.getContext().revokeUriPermission(Dq, 1);
        }
        if (bundle != null)
        {
            bundle = (PendingIntent)bundle.getParcelable("pendingIntent");
        } else
        {
            bundle = null;
        }
        bundle = new Status(i, null, bundle);
        if (Dp != null)
        {
            Dn.a(new <init>(Dn, Dp, bundle, intent));
        } else
        if (Do != null)
        {
            Dn.a(new <init>(Dn, Do, bundle, j, intent));
            return;
        }
    }

    public (hm hm1, com.google.android.gms.common.api.s s, com.google.android.gms.common.api.s s1, Uri uri)
    {
        Dn = hm1;
        super();
        Do = s;
        Dp = s1;
        Dq = uri;
    }
}

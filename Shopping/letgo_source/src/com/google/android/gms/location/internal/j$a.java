// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.location.n;

// Referenced classes of package com.google.android.gms.location.internal:
//            j

private static final class a extends a
{

    private com.google.android.gms.common.api.al.j.a a;

    public void a(int i, PendingIntent pendingintent)
    {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }

    public void a(int i, String as[])
    {
        if (a == null)
        {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            return;
        } else
        {
            as = n.b(n.a(i));
            a.a(as);
            a = null;
            return;
        }
    }

    public void b(int i, String as[])
    {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }

    public (com.google.android.gms.common.api..a a1)
    {
        a = a1;
    }
}

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

    private com.google.android.gms.common.api.al.j.b.a a;

    private void a(int i)
    {
        if (a == null)
        {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
            return;
        } else
        {
            com.google.android.gms.common.api.Status status = n.b(n.a(i));
            a.a(status);
            a = null;
            return;
        }
    }

    public void a(int i, PendingIntent pendingintent)
    {
        a(i);
    }

    public void a(int i, String as[])
    {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
    }

    public void b(int i, String as[])
    {
        a(i);
    }

    public (com.google.android.gms.common.api..b b1)
    {
        a = b1;
    }
}

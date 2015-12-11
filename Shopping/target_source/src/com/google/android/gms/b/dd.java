// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.b:
//            dc

public final class dd
    implements dc
{

    public dd()
    {
    }

    public long a()
    {
        return System.currentTimeMillis();
    }

    public long b()
    {
        return SystemClock.elapsedRealtime();
    }
}

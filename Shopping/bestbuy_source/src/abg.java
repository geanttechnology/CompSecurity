// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.SystemClock;

final class abg
{

    private long a;
    private long b;

    public abg()
    {
        a = -1L;
        b = -1L;
    }

    public long a()
    {
        return b;
    }

    public void b()
    {
        b = SystemClock.elapsedRealtime();
    }

    public void c()
    {
        a = SystemClock.elapsedRealtime();
    }

    public Bundle d()
    {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", a);
        bundle.putLong("tclose", b);
        return bundle;
    }
}

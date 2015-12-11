// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.os.SystemClock;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaClock

final class n
    implements MediaClock
{

    private boolean a;
    private long b;
    private long c;

    n()
    {
    }

    private static long b(long l)
    {
        return SystemClock.elapsedRealtime() * 1000L - l;
    }

    public final void a()
    {
        if (!a)
        {
            a = true;
            c = b(b);
        }
    }

    public final void a(long l)
    {
        b = l;
        c = b(l);
    }

    public final void b()
    {
        if (a)
        {
            b = b(c);
            a = false;
        }
    }

    public final long getPositionUs()
    {
        if (a)
        {
            return b(c);
        } else
        {
            return b;
        }
    }
}

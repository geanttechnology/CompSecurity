// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream.cache;

import android.os.ConditionVariable;

// Referenced classes of package shared_presage.com.google.android.exoplayer.upstream.cache:
//            SimpleCache

final class a extends Thread
{

    final ConditionVariable a;
    final SimpleCache b;

    a(SimpleCache simplecache, ConditionVariable conditionvariable)
    {
        b = simplecache;
        a = conditionvariable;
        super();
    }

    public final void run()
    {
        synchronized (b)
        {
            a.open();
            SimpleCache.access$000(b);
        }
    }
}

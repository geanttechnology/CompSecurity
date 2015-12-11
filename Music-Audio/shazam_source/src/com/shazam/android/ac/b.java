// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ac;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.shazam.o.q;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.ac:
//            c, a

public final class b extends c
    implements Runnable
{

    public final Handler a = new Handler(Looper.getMainLooper());
    private final q b;
    private final List c;

    public transient b(q q1, a aa[])
    {
        b = q1;
        c = Arrays.asList(aa);
    }

    public final void onActivityPaused(Activity activity)
    {
        a.postDelayed(this, b.a());
    }

    public final void onActivityResumed(Activity activity)
    {
        a.removeCallbacks(this);
        for (activity = c.iterator(); activity.hasNext(); ((a)activity.next()).d()) { }
    }

    public final void run()
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((a)iterator.next()).a()) { }
    }
}

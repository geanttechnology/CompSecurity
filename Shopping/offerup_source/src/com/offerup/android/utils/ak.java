// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import com.offerup.android.activities.a;

// Referenced classes of package com.offerup.android.utils:
//            aj, x

final class ak
    implements Runnable
{

    private aj a;

    ak(aj aj1)
    {
        a = aj1;
        super();
    }

    public final void run()
    {
        x.e(a.a).c();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.f.h;
import java.util.TimerTask;

// Referenced classes of package com.smule.android.network.managers:
//            e

class a extends TimerTask
{

    final e a;

    public void run()
    {
        h.a().a("CONTEST_STATE_MIGHT_HAVE_CHANGED", new Object[0]);
        e.c(a);
    }

    (e e1)
    {
        a = e1;
        super();
    }
}

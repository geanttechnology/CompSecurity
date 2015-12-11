// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.util.Log;
import com.smule.android.network.core.b;

// Referenced classes of package com.smule.android.f:
//            o

class a
    implements Runnable
{

    final o a;

    public void run()
    {
        Log.i(o.a(), "Starting a new session.");
        b.a().a(true);
    }

    k.core.b(o o1)
    {
        a = o1;
        super();
    }
}

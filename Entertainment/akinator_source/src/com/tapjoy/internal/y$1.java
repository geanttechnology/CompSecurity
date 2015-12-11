// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.Handler;

// Referenced classes of package com.tapjoy.internal:
//            bg, y

static final class a
    implements bg
{

    final Handler a;

    public final boolean a(Runnable runnable)
    {
        return a.post(runnable);
    }

    (Handler handler)
    {
        a = handler;
        super();
    }
}

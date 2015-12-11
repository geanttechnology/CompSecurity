// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            m, ad

class a
    implements ad.UncaughtExceptionHandler
{

    final m a;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        ad.a(throwable.getStackTrace());
        ad.d(throwable.getMessage());
        a.a.finish();
    }

    r(m m1)
    {
        a = m1;
        super();
    }
}

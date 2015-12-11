// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.a;

import android.app.Activity;
import com.tremorvideo.sdk.android.videoad.ad;

// Referenced classes of package com.tremorvideo.sdk.android.a:
//            b

class a
    implements ad.UncaughtExceptionHandler
{

    final b a;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        ad.a(throwable.getStackTrace());
        ad.d(throwable.getMessage());
        b.b(a).finish();
    }

    d.ad(b b1)
    {
        a = b1;
        super();
    }
}

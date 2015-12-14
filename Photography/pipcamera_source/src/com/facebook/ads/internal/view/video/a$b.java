// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view.video;

import android.os.Handler;
import com.facebook.ads.internal.util.t;
import com.facebook.ads.internal.view.video.support.a;

// Referenced classes of package com.facebook.ads.internal.view.video:
//            a

final class ort.a extends t
{

    public void run()
    {
        com.facebook.ads.internal.view.video.a a1;
        for (a1 = (com.facebook.ads.internal.view.video.a)a(); a1 == null || a1 == null;)
        {
            return;
        }

        int i = a.c(a1).getCurrentPosition();
        if (i > a.d(a1))
        {
            com.facebook.ads.internal.view.video.a.a(a1, i);
        }
        a.e(a1).postDelayed(this, 250L);
    }

    public ort.a(com.facebook.ads.internal.view.video.a a1)
    {
        super(a1);
    }
}

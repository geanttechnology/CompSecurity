// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view.video;

import android.os.Handler;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.t;
import com.facebook.ads.internal.view.video.support.a;

// Referenced classes of package com.facebook.ads.internal.view.video:
//            a

final class ort.a extends t
{

    public void run()
    {
        com.facebook.ads.internal.view.video.a a1 = (com.facebook.ads.internal.view.video.a)a();
        if (a1 == null)
        {
            return;
        }
        if (a.c(a1).getCurrentPosition() > 3000)
        {
            (new o()).execute(new String[] {
                a1.getVideoPlayReportURI()
            });
            return;
        } else
        {
            a.f(a1).postDelayed(this, 250L);
            return;
        }
    }

    public ort.a(com.facebook.ads.internal.view.video.a a1)
    {
        super(a1);
    }
}

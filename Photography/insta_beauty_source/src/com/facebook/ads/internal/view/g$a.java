// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.os.Handler;
import android.widget.VideoView;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.t;

// Referenced classes of package com.facebook.ads.internal.view:
//            g

final class nit> extends t
{

    public void run()
    {
        g g1;
label0:
        {
            g1 = (g)a();
            if (g1 != null)
            {
                if (g.a(g1).getCurrentPosition() <= 3000)
                {
                    break label0;
                }
                (new o()).execute(new String[] {
                    g1.getVideoPlayReportURI()
                });
            }
            return;
        }
        g.d(g1).postDelayed(this, 250L);
    }

    public (g g1)
    {
        super(g1);
    }
}

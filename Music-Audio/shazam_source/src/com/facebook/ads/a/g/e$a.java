// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g;

import android.os.Handler;
import android.widget.VideoView;
import com.facebook.ads.a.f.o;
import com.facebook.ads.a.f.u;
import java.lang.ref.WeakReference;

// Referenced classes of package com.facebook.ads.a.g:
//            e

private static final class nit> extends u
{

    public final void run()
    {
        e e1;
label0:
        {
            e1 = (e)super.a.get();
            if (e1 != null)
            {
                if (e.a(e1).getCurrentPosition() <= 3000)
                {
                    break label0;
                }
                (new o()).execute(new String[] {
                    e1.getVideoPlayReportURI()
                });
            }
            return;
        }
        e.d(e1).postDelayed(this, 250L);
    }

    public ce(e e1)
    {
        super(e1);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.foundationtouchview;

import android.os.Vibrator;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.foundationtouchview:
//            FoundationView

class a
    implements Runnable
{

    final FoundationView a;

    public void run()
    {
        if (FoundationView.a(a) != null)
        {
            FoundationView.a(a).cancel();
        }
        FoundationView.b(a);
        if (FoundationView.c(a) != null)
        {
            FoundationView.c(a).g(false);
            FoundationView.c(a).f(true);
        }
        a.invalidate();
    }

    (FoundationView foundationview)
    {
        a = foundationview;
        super();
    }
}

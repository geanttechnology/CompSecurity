// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.shareview;

import android.location.LocationManager;

// Referenced classes of package com.cyberlink.youcammakeup.pages.shareview:
//            a

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        if (!com.cyberlink.youcammakeup.pages.shareview.a.a(a))
        {
            com.cyberlink.youcammakeup.pages.shareview.a.a(a, null);
            com.cyberlink.youcammakeup.pages.shareview.a.b(a).removeUpdates(a.a);
            com.cyberlink.youcammakeup.pages.shareview.a.b(a).removeUpdates(a.b);
        }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}

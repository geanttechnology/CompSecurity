// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.util.Log;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            f, e

class h extends f
{

    final e b;

    h(e e1)
    {
        b = e1;
        super(e1, null);
        e.b(e1).setVisibility(4);
        e.c(e1).setVisibility(0);
        e.a(e1).setVisibility(8);
    }

    public f a()
    {
        Log.d("CameraEffectGridItem", "from StateDownloadCompleted to StateDownloadCompleted");
        return this;
    }
}

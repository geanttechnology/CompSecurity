// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.util.Log;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            f, e

class j extends f
{

    final e b;

    j(e e1)
    {
        b = e1;
        super(e1, null);
        e.b(e1).setBackgroundResource(0x7f02086f);
        e.b(e1).setVisibility(0);
        e.c(e1).setVisibility(0);
        e.a(e1).setVisibility(8);
    }

    public f a()
    {
        Log.d("CameraEffectGridItem", "from StateLocked to StateLocked");
        return this;
    }
}

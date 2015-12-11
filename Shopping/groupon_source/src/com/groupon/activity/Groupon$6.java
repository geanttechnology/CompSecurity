// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.SystemClock;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            Groupon

class this._cls0
    implements android.view.ckListener
{

    private static final int CLICK_THRESHOLD_MILLIS = 1500;
    private long lastClickMillis;
    final Groupon this$0;

    public void onClick(View view)
    {
        long l = SystemClock.elapsedRealtime();
        if (l - lastClickMillis > 1500L)
        {
            Groupon.access$400(Groupon.this);
        }
        lastClickMillis = l;
    }

    er()
    {
        this$0 = Groupon.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.refresh;

import android.os.Handler;
import android.os.Message;
import android.view.View;

// Referenced classes of package com.aio.downloader.refresh:
//            PullToRefreshLayout

class this._cls0 extends Handler
{

    final PullToRefreshLayout this$0;

    public void handleMessage(Message message)
    {
        MOVE_SPEED = (float)(8D + 20D * Math.tan((1.5707963267948966D / (double)getMeasuredHeight()) * (double)pullDownY));
        if (!PullToRefreshLayout.access$0(PullToRefreshLayout.this) && PullToRefreshLayout.access$1(PullToRefreshLayout.this) == 2 && pullDownY <= PullToRefreshLayout.access$2(PullToRefreshLayout.this))
        {
            pullDownY = PullToRefreshLayout.access$2(PullToRefreshLayout.this);
            PullToRefreshLayout.access$3(PullToRefreshLayout.this).cancel();
        }
        if (pullDownY > 0.0F)
        {
            message = PullToRefreshLayout.this;
            message.pullDownY = ((PullToRefreshLayout) (message)).pullDownY - MOVE_SPEED;
        }
        if (pullDownY <= 0.0F)
        {
            pullDownY = 0.0F;
            PullToRefreshLayout.access$4(PullToRefreshLayout.this).clearAnimation();
            if (PullToRefreshLayout.access$1(PullToRefreshLayout.this) != 2)
            {
                PullToRefreshLayout.access$5(PullToRefreshLayout.this, 0);
            }
            PullToRefreshLayout.access$3(PullToRefreshLayout.this).cancel();
        }
        requestLayout();
    }

    Timer()
    {
        this$0 = PullToRefreshLayout.this;
        super();
    }
}

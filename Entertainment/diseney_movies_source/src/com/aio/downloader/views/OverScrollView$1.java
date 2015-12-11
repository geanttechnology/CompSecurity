// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.aio.downloader.views:
//            OverScrollView

class this._cls0 extends Handler
{

    final OverScrollView this$0;

    public void handleMessage(Message message)
    {
        MOVE_SPEED = (float)(5D + 15D * Math.tan((1.5707963267948966D / (double)getMeasuredHeight()) * (double)(pullDownY + Math.abs(OverScrollView.access$0(OverScrollView.this)))));
        if (pullDownY <= 0.0F) goto _L2; else goto _L1
_L1:
        message = OverScrollView.this;
        message.pullDownY = ((OverScrollView) (message)).pullDownY - MOVE_SPEED;
_L4:
        if (pullDownY < 0.0F)
        {
            pullDownY = 0.0F;
            OverScrollView.access$2(OverScrollView.this).cancel();
        }
        if (OverScrollView.access$0(OverScrollView.this) > 0.0F)
        {
            OverScrollView.access$1(OverScrollView.this, 0.0F);
            OverScrollView.access$2(OverScrollView.this).cancel();
        }
        requestLayout();
        return;
_L2:
        if (OverScrollView.access$0(OverScrollView.this) < 0.0F)
        {
            message = OverScrollView.this;
            OverScrollView.access$1(message, OverScrollView.access$0(message) + MOVE_SPEED);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    Timer()
    {
        this$0 = OverScrollView.this;
        super();
    }
}

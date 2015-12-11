// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.uplynk.media:
//            CaptionManager

private class _overlayView extends Handler
{

    _overlayView _overlayView;
    final CaptionManager this$0;

    public void handleMessage(Message message)
    {
        if (message.what == 1)
        {
            removeMessages(1);
            _overlayView.de = WN;
            _overlayView.alidate();
            ess._mth0(_overlayView, false);
        }
    }

    protected ( , Looper looper)
    {
        this$0 = CaptionManager.this;
        super(looper);
        _overlayView = ;
    }
}

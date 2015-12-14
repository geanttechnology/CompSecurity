// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView

class a extends Handler
{

    private WeakReference a;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 2 2: default 24
    //                   2 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if ((message = (InlineVideoView)a.get()) != null)
        {
            if (message.isPlaying())
            {
                message.updateVideoSeekTime();
            }
            ((InlineVideoView) (message)).videoHandler.sendMessageDelayed(Message.obtain(((InlineVideoView) (message)).videoHandler, 2), 500L);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public (InlineVideoView inlinevideoview)
    {
        a = new WeakReference(inlinevideoview);
    }
}

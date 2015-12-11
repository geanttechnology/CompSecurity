// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import android.util.Log;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

class val.postAction
    implements Runnable
{

    final RdioAudioPlayer this$0;
    final Runnable val$postAction;

    public void run()
    {
        Object obj = RdioAudioPlayer.access$1700(RdioAudioPlayer.this);
        obj;
        JVM INSTR monitorenter ;
        Thread thread = RdioAudioPlayer.access$1800(RdioAudioPlayer.this);
        if (thread == null) goto _L2; else goto _L1
_L1:
        RdioAudioPlayer.access$1800(RdioAudioPlayer.this).join();
_L3:
        RdioAudioPlayer.access$1802(RdioAudioPlayer.this, null);
_L2:
        if (val$postAction != null)
        {
            val$postAction.run();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        ((InterruptedException) (obj1)).printStackTrace();
        Log.e("RdioAudioPlayer", "Could not join audioProcessingThread");
          goto _L3
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    ()
    {
        this$0 = final_rdioaudioplayer;
        val$postAction = Runnable.this;
        super();
    }
}

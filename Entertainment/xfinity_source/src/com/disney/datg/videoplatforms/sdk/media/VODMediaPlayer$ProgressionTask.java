// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VODMediaPlayer

class this._cls0 extends TimerTask
{

    final VODMediaPlayer this$0;

    public void run()
    {
        if (!isPlaying()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = getCurrentPosition();
        isCurrentTimeInAdBreak(j);
        i = j / 1000;
        j = (j * 100) / getDuration();
        if (j < 99 || VODMediaPlayer.access$100(VODMediaPlayer.this) >= 99) goto _L4; else goto _L3
_L3:
        VODMediaPlayer.access$102(VODMediaPlayer.this, 99);
        sendTrackable(MPLETE);
_L7:
        if (currentAdBreak != null || i < nextPingTime || !needsPing || pingUplynk == null) goto _L2; else goto _L5
_L5:
        needsPing = false;
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        nextPingTime = ((Integer)pingUplynk.MPLETE(i, "start").get(5L, TimeUnit.SECONDS)).intValue();
_L2:
        return;
_L4:
        if (j >= 75 && VODMediaPlayer.access$100(VODMediaPlayer.this) < 75)
        {
            VODMediaPlayer.access$102(VODMediaPlayer.this, 75);
            sendTrackable(MPLETE_75);
        } else
        if (j >= 50 && VODMediaPlayer.access$100(VODMediaPlayer.this) < 50)
        {
            VODMediaPlayer.access$102(VODMediaPlayer.this, 50);
            sendTrackable(MPLETE_50);
        } else
        if (j >= 25 && VODMediaPlayer.access$100(VODMediaPlayer.this) < 25)
        {
            VODMediaPlayer.access$102(VODMediaPlayer.this, 25);
            sendTrackable(MPLETE_25);
        }
        if (true) goto _L7; else goto _L6
        Object obj;
        obj;
        LogUtils.LOGE(VODMediaPlayer.access$000(), ((InterruptedException) (obj)).getMessage());
        return;
        obj;
        LogUtils.LOGE(VODMediaPlayer.access$000(), ((ExecutionException) (obj)).getMessage());
        return;
        obj;
        LogUtils.LOGE(VODMediaPlayer.access$000(), ((TimeoutException) (obj)).getMessage());
        return;
_L6:
        try
        {
            nextPingTime = ((Integer)pingUplynk.MPLETE_25(i, null).get(5L, TimeUnit.SECONDS)).intValue();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            LogUtils.LOGE(VODMediaPlayer.access$000(), interruptedexception.getMessage());
            return;
        }
        catch (ExecutionException executionexception)
        {
            LogUtils.LOGE(VODMediaPlayer.access$000(), executionexception.getMessage());
            return;
        }
        catch (TimeoutException timeoutexception)
        {
            LogUtils.LOGE(VODMediaPlayer.access$000(), timeoutexception.getMessage());
        }
        return;
    }

    ()
    {
        this$0 = VODMediaPlayer.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.player;

import android.os.Handler;
import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.util.TimerTask;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.player:
//            VideoCastControllerActivity

private class <init> extends TimerTask
{

    final VideoCastControllerActivity this$0;

    public void run()
    {
        VideoCastControllerActivity.access$1300(VideoCastControllerActivity.this).post(new Runnable() {

            final VideoCastControllerActivity.UpdateSeekbarTask this$1;

            public void run()
            {
_L2:
                return;
                if (VideoCastControllerActivity.access$300(this$0) == 4 || !VideoCastControllerActivity.access$100(this$0).isConnected()) goto _L2; else goto _L1
_L1:
                double d = VideoCastControllerActivity.access$100(this$0).getMediaDuration();
                if (d <= 0.0D) goto _L2; else goto _L3
_L3:
                int i = (int)VideoCastControllerActivity.access$100(this$0).getCurrentMediaPosition();
                VideoCastControllerActivity.access$1200(this$0, i, (int)d);
                return;
                Exception exception;
                exception;
                try
                {
                    LogUtils.LOGE(VideoCastControllerActivity.access$000(), "Failed to get current media position");
                    return;
                }
                catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
                {
                    LogUtils.LOGE(VideoCastControllerActivity.access$000(), "Failed to update the progress bar due to network issues", transientnetworkdisconnectionexception);
                    return;
                }
                catch (NoConnectionException noconnectionexception)
                {
                    LogUtils.LOGE(VideoCastControllerActivity.access$000(), "Failed to update the progress bar due to network issues", noconnectionexception);
                }
                return;
            }

            
            {
                this$1 = VideoCastControllerActivity.UpdateSeekbarTask.this;
                super();
            }
        });
    }

    private _cls1.this._cls1()
    {
        this$0 = VideoCastControllerActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

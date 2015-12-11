// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.player;

import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.player:
//            VideoCastControllerActivity

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
_L2:
        return;
        if (VideoCastControllerActivity.access$300(_fld0) == 4 || !VideoCastControllerActivity.access$100(_fld0).isConnected()) goto _L2; else goto _L1
_L1:
        double d = VideoCastControllerActivity.access$100(_fld0).getMediaDuration();
        if (d <= 0.0D) goto _L2; else goto _L3
_L3:
        int i = (int)VideoCastControllerActivity.access$100(_fld0).getCurrentMediaPosition();
        VideoCastControllerActivity.access$1200(_fld0, i, (int)d);
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

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}

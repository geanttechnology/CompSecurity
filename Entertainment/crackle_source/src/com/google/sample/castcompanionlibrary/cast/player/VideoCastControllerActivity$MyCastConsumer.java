// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.player;

import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.callbacks.VideoCastConsumerImpl;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.player:
//            VideoCastControllerActivity

class this._cls0 extends VideoCastConsumerImpl
{

    final VideoCastControllerActivity this$0;

    public void onApplicationDisconnected(int i)
    {
        finish();
    }

    public void onConnectionSuspended(int i)
    {
        VideoCastControllerActivity.access$1000(VideoCastControllerActivity.this, false);
    }

    public void onConnectivityRecovered()
    {
        VideoCastControllerActivity.access$1000(VideoCastControllerActivity.this, true);
    }

    public void onDisconnected()
    {
        finish();
    }

    public void onRemoteMediaPlayerMetadataUpdated()
    {
        try
        {
            VideoCastControllerActivity.access$802(VideoCastControllerActivity.this, VideoCastControllerActivity.access$100(VideoCastControllerActivity.this).getRemoteMediaInformation());
            VideoCastControllerActivity.access$900(VideoCastControllerActivity.this);
            return;
        }
        catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
        {
            LogUtils.LOGE(VideoCastControllerActivity.access$000(), "Failed to update the metadata due to network issues", transientnetworkdisconnectionexception);
            return;
        }
        catch (NoConnectionException noconnectionexception)
        {
            LogUtils.LOGE(VideoCastControllerActivity.access$000(), "Failed to update the metadata due to network issues", noconnectionexception);
        }
    }

    public void onRemoteMediaPlayerStatusUpdated()
    {
        int i;
        i = VideoCastControllerActivity.access$100(VideoCastControllerActivity.this).getPlaybackStatus();
        LogUtils.LOGD(VideoCastControllerActivity.access$000(), (new StringBuilder()).append("onRemoteMediaPlayerStatusUpdated(), status: ").append(i).toString());
        i;
        JVM INSTR tableswitch 1 4: default 68
    //                   1 174
    //                   2 69
    //                   3 104
    //                   4 139;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L3:
        if (VideoCastControllerActivity.access$300(VideoCastControllerActivity.this) != 2)
        {
            VideoCastControllerActivity.access$302(VideoCastControllerActivity.this, 2);
            VideoCastControllerActivity.access$400(VideoCastControllerActivity.this, VideoCastControllerActivity.access$300(VideoCastControllerActivity.this));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (VideoCastControllerActivity.access$300(VideoCastControllerActivity.this) != 3)
        {
            VideoCastControllerActivity.access$302(VideoCastControllerActivity.this, 3);
            VideoCastControllerActivity.access$400(VideoCastControllerActivity.this, VideoCastControllerActivity.access$300(VideoCastControllerActivity.this));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (VideoCastControllerActivity.access$300(VideoCastControllerActivity.this) != 4)
        {
            VideoCastControllerActivity.access$302(VideoCastControllerActivity.this, 4);
            VideoCastControllerActivity.access$400(VideoCastControllerActivity.this, VideoCastControllerActivity.access$300(VideoCastControllerActivity.this));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (VideoCastControllerActivity.access$100(VideoCastControllerActivity.this).getIdleReason() == 1)
        {
            finish();
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    ()
    {
        this$0 = VideoCastControllerActivity.this;
        super();
    }
}

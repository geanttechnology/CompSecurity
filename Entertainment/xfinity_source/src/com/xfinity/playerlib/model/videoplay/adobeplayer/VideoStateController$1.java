// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.comcast.cim.cmasl.xip.XipHttpErrorException;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;
import com.xfinity.playerlib.authorization.VideoAuthManager;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            VideoStateController

class this._cls0
    implements Runnable
{

    final VideoStateController this$0;

    private void callOnAMSContinueException(final Exception e)
    {
        VideoStateController.access$300(VideoStateController.this).execute(new Runnable() {

            final VideoStateController._cls1 this$1;
            final Exception val$e;

            public void run()
            {
                onAMSContinueException(e);
            }

            
            {
                this$1 = VideoStateController._cls1.this;
                e = exception;
                super();
            }
        });
    }

    public void run()
    {
        try
        {
            VideoStateController.access$000(VideoStateController.this).sendVideoContinueHeartbeat();
            return;
        }
        catch (AmsHttpErrorException amshttperrorexception)
        {
            VideoStateController.access$100().error("Caught exception during AMS continue call", amshttperrorexception);
            switch (.SwitchMap.com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException.PlayerAction[AmsHttpErrorException.getPlayerActionForException(amshttperrorexception).ordinal()])
            {
            default:
                callOnAMSContinueException(amshttperrorexception);
                return;

            case 1: // '\001'
                break;
            }
            if (VideoStateController.access$200(VideoStateController.this).incrementAndGet() > 2)
            {
                callOnAMSContinueException(amshttperrorexception);
                return;
            } else
            {
                VideoStateController.access$100().error("Error count {} is within threshold {}, continuing", VideoStateController.access$200(VideoStateController.this), Integer.valueOf(2));
                return;
            }
        }
        catch (Exception exception)
        {
            if ((exception instanceof XipHttpErrorException) && ((XipHttpErrorException)exception).getDetailedStatusCode() == 3001)
            {
                VideoStateController.access$100().error("XipNotProvisioned captured in continue auth, signout and quit video", exception);
                callOnAMSContinueException(exception);
                return;
            } else
            {
                VideoStateController.access$100().warn("AMS continue call caught exception...ignore");
                return;
            }
        }
    }

    _cls1.val.e()
    {
        this$0 = VideoStateController.this;
        super();
    }
}

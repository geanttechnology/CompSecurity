// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.videoplay.NanoHTTPD;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, PlayerPreparingState, ErrorState, 
//            VideoState

public class InitializeLocalHostState extends DefaultVideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState);

    public InitializeLocalHostState(VideoStateController videostatecontroller)
    {
        super(videostatecontroller);
    }

    private void startLocalHostServer(String s)
    {
        Object obj;
        int i;
        if (stateController.getLocalHostServer() != null)
        {
            stateController.getLocalHostServer().stop();
            stateController.setLocalHostServer(null);
        }
        i = 0;
        obj = null;
_L2:
        if (i >= 15)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        Object obj1 = new File(s);
        obj1 = new NanoHTTPD(stateController.getHttpPort(), ((File) (obj1)));
        stateController.setLocalHostServer(((NanoHTTPD) (obj1)));
        transitionToState(new PlayerPreparingState(stateController));
        if (stateController.getLocalHostServer() == null)
        {
            transitionToState(new ErrorState(stateController, ((Throwable) (obj)), this));
        }
        return;
        obj;
        i++;
        stateController.incrementHttpPort();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getStateName()
    {
        return "InitializeLocalHostState";
    }

    public void run()
    {
        startLocalHostServer(stateController.getDownloadedFile().getFileDirectory());
    }

    public void transitionToState(VideoState videostate)
    {
        if (videostate instanceof PlayerPreparingState)
        {
            stateController.setState(videostate);
            return;
        } else
        {
            super.transitionToState(videostate);
            return;
        }
    }

}

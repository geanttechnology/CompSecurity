// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, QuitState, AuthenticatingState, 
//            VideoState

public class CheckPinState extends DefaultVideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/CheckPinState);

    public CheckPinState(VideoStateController videostatecontroller)
    {
        super(videostatecontroller);
    }

    private void validatePin()
    {
        stateController.getUiController().showPinPadFragment();
    }

    public String getStateName()
    {
        return "CheckPinState";
    }

    public void onPinCanceled()
    {
        stateController.transitionToState(new QuitState(stateController));
    }

    public void onValidatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
    {
        stateController.transitionToState(new AuthenticatingState(stateController, pinvalidationcompletedlistener, s));
    }

    public void run()
    {
        validatePin();
    }

    public void transitionToState(VideoState videostate)
    {
        if (videostate instanceof AuthenticatingState)
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

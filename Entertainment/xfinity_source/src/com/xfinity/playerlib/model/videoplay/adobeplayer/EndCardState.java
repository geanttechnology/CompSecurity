// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, QuitState, MobileDataWarningState, 
//            VideoState

public class EndCardState extends DefaultVideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState);

    public EndCardState(VideoStateController videostatecontroller)
    {
        super(videostatecontroller);
    }

    private void showEndCard()
    {
        final Watchable nextWatchable = stateController.getNextVideoItem();
        if (nextWatchable != null && !stateController.shouldUseDownloadFile())
        {
            StringBuilder stringbuilder = new StringBuilder();
            final VideoFacade nextVideoFacade = (VideoFacade)((Tuple) (nextWatchable)).e1;
            nextWatchable = (Watchable)((Tuple) (nextWatchable)).e2;
            stringbuilder.append(stateController.getActivityContext().getResources().getString(com.xfinity.playerlib.R.string.play)).append(" ").append(nextWatchable.getNextItemDisplayTitle()).append("?");
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(stateController.getActivityContext());
            builder.setMessage(stringbuilder.toString()).setTitle(stateController.getActivityContext().getResources().getString(com.xfinity.playerlib.R.string.play_next_episode_dialog_title)).setCancelable(false).setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener() {

                final EndCardState this$0;
                final VideoFacade val$nextVideoFacade;
                final Watchable val$nextWatchable;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    stateController.setVideoAndWatchable(nextVideoFacade, nextWatchable);
                    stateController.reset();
                }

            
            {
                this$0 = EndCardState.this;
                nextVideoFacade = videofacade;
                nextWatchable = watchable;
                super();
            }
            }).setNegativeButton("No", new android.content.DialogInterface.OnClickListener() {

                final EndCardState this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.cancel();
                    stateController.transitionToState(new QuitState(stateController));
                }

            
            {
                this$0 = EndCardState.this;
                super();
            }
            });
            builder.create().show();
            return;
        } else
        {
            stateController.transitionToState(new QuitState(stateController));
            return;
        }
    }

    public String getStateName()
    {
        return "EndCardState";
    }

    public void run()
    {
        showEndCard();
    }

    public void transitionToState(VideoState videostate)
    {
        if (videostate instanceof MobileDataWarningState)
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

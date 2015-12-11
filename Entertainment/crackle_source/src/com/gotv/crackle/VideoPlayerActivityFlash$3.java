// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import android.view.View;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.OmnitureWrapper;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivityFlash, Application, TwitterWebActivity

class this._cls0
    implements android.view.h._cls3
{

    final VideoPlayerActivityFlash this$0;

    public void onClick(View view)
    {
        MediaDetailsItem mediadetailsitem = VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem();
        if (view.getId() == 0x7f0a0169)
        {
            removeDialog(4);
            postToFacebook(false, VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem());
            Application.getInstance().getOmnitureTracker().onVideoShare("Facebook", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), mediadetailsitem.getDuration());
        } else
        {
            if (view.getId() == 0x7f0a016a)
            {
                removeDialog(4);
                view = new Intent(VideoPlayerActivityFlash.this, com/gotv/crackle/TwitterWebActivity);
                view.putExtra("share_link", VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem().getPermaLink());
                view.putExtra("share_title", VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem().getTitle());
                startActivity(view);
                Application.getInstance().getOmnitureTracker().onVideoShare("Twitter", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), mediadetailsitem.getDuration());
                return;
            }
            if (view.getId() == 0x7f0a0165)
            {
                try
                {
                    shareMailClicked(VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem());
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                removeDialog(4);
                Application.getInstance().getOmnitureTracker().onVideoShare("Email", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), mediadetailsitem.getDuration());
                return;
            }
            if (view.getId() == 0x7f0a0167)
            {
                removeDialog(4);
                Application.getInstance().getOmnitureTracker().onVideoShare("SMS", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), mediadetailsitem.getDuration());
                shareSMSClicked(mediadetailsitem);
                return;
            }
        }
    }

    ()
    {
        this$0 = VideoPlayerActivityFlash.this;
        super();
    }
}

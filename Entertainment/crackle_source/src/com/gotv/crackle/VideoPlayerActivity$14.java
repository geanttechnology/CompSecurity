// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.OmnitureWrapper;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity, Application, TwitterWebActivity

class this._cls0
    implements android.view.._cls14
{

    final VideoPlayerActivity this$0;

    public void onClick(View view)
    {
        MediaDetailsItem mediadetailsitem = VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem();
        if (view.getId() == 0x7f0a0169)
        {
            mShareDialog.dismiss();
            postToFacebook(false, VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem());
            if (VideoPlayerActivity.access$500(VideoPlayerActivity.this).isPlaying())
            {
                VideoPlayerActivity.access$500(VideoPlayerActivity.this).pause();
            }
            Application.getInstance().getOmnitureTracker().onVideoShare("Facebook", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", VideoPlayerActivity.access$3200(VideoPlayerActivity.this), mediadetailsitem.getDuration());
        } else
        {
            if (view.getId() == 0x7f0a016a)
            {
                mShareDialog.dismiss();
                view = new Intent(VideoPlayerActivity.this, com/gotv/crackle/TwitterWebActivity);
                view.putExtra("share_link", VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem().getPermaLink());
                view.putExtra("share_title", VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem().getTitle());
                startActivity(view);
                Application.getInstance().getOmnitureTracker().onVideoShare("Twitter", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", VideoPlayerActivity.access$3200(VideoPlayerActivity.this), mediadetailsitem.getDuration());
                return;
            }
            if (view.getId() == 0x7f0a0165)
            {
                try
                {
                    shareMailClicked(VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem());
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                mShareDialog.dismiss();
                Application.getInstance().getOmnitureTracker().onVideoShare("Email", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", VideoPlayerActivity.access$3200(VideoPlayerActivity.this), mediadetailsitem.getDuration());
                return;
            }
            if (view.getId() == 0x7f0a0167)
            {
                mShareDialog.dismiss();
                shareSMSClicked(VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem());
                Application.getInstance().getOmnitureTracker().onVideoShare("SMS", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", VideoPlayerActivity.access$3200(VideoPlayerActivity.this), mediadetailsitem.getDuration());
                return;
            }
        }
    }

    per()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}

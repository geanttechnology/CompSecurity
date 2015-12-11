// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.webkit.WebView;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.OmnitureWrapper;
import com.sessionm.api.SessionM;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivityFlash, Application

private class <init>
{

    final VideoPlayerActivityFlash this$0;

    public void captionClick(String s)
    {
        Log.d("VideoPlayerActivityFlash", (new StringBuilder()).append("CaptionClicked: ").append(s).toString());
        showDialog(6);
    }

    public void flexToJavascript(String s)
    {
        Log.d("VideoPlayerActivityFlash", (new StringBuilder()).append("VideoPlayer ").append(s).toString());
        if (!s.equalsIgnoreCase("ShareThis")) goto _L2; else goto _L1
_L1:
        SessionM.getInstance().presentActivity(com.sessionm.api.<init>);
        runOnUiThread(new Runnable() {

            final VideoPlayerActivityFlash.ClickHandlerInterface this$1;

            public void run()
            {
                showDialog(4);
            }

            
            {
                this$1 = VideoPlayerActivityFlash.ClickHandlerInterface.this;
                super();
            }
        });
_L4:
        return;
_L2:
        if (!s.equalsIgnoreCase("AddToQueue"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo() == null) goto _L4; else goto _L3
_L3:
        s = CrackleAccountManager.getUserID();
        if (s != null)
        {
            MediaDetailsItem mediadetailsitem = VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem();
            Application.getInstance().getOmnitureTracker().onVideoQueue(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), mediadetailsitem.getDuration());
            s = new QueueManager(VideoPlayerActivityFlash.this, s);
            SessionM.getInstance().logAction("addToMyQueue");
            s.addMediaToWatchlist(VideoPlayerActivityFlash.access$700(VideoPlayerActivityFlash.this));
            return;
        } else
        {
            showDialogFragment(0xa7b54);
            return;
        }
        if (!s.equalsIgnoreCase("BuyOnAmazon") || VideoPlayerActivityFlash.access$800(VideoPlayerActivityFlash.this) == null || VideoPlayerActivityFlash.access$800(VideoPlayerActivityFlash.this).isEmpty() || VideoPlayerActivityFlash.access$800(VideoPlayerActivityFlash.this).equalsIgnoreCase("null")) goto _L4; else goto _L5
_L5:
        s = VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem();
        Application.getInstance().getOmnitureTracker().onVideoBuy(s.getID(), s.getTitle(), s.getTitle(), s.getRootChannelID(), s.getMediaType(), s.getSeason(), s.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), s.getDuration());
        s = new Intent("android.intent.action.VIEW", Uri.parse(VideoPlayerActivityFlash.access$800(VideoPlayerActivityFlash.this)));
        startActivity(s);
        return;
    }

    public void moviePlayer75PercentJavascript()
    {
        MediaDetailsItem mediadetailsitem = VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem();
        VideoPlayerActivityFlash.access$1102(VideoPlayerActivityFlash.this, Application.getInstance().getOmnitureTracker().onVideo75Percent(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), mediadetailsitem.getDuration(), VideoPlayerActivityFlash.access$1000(VideoPlayerActivityFlash.this), VideoPlayerActivityFlash.access$1100(VideoPlayerActivityFlash.this)));
    }

    public void onAdStart()
    {
        MediaDetailsItem mediadetailsitem = VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem();
        VideoPlayerActivityFlash.access$1102(VideoPlayerActivityFlash.this, Application.getInstance().getOmnitureTracker().onAdStart(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), mediadetailsitem.getDuration(), VideoPlayerActivityFlash.access$1000(VideoPlayerActivityFlash.this), VideoPlayerActivityFlash.access$1100(VideoPlayerActivityFlash.this), 0, 0, ""));
    }

    public void onbeforeunload(String s)
    {
        int i = (int)Math.round(Double.parseDouble(s));
        if (i > 0 && i <= VideoPlayerActivityFlash.access$1200(VideoPlayerActivityFlash.this))
        {
            SharedPrefsManager.setPlayProgressForItem(VideoPlayerActivityFlash.access$700(VideoPlayerActivityFlash.this), VideoPlayerActivityFlash.access$1300(VideoPlayerActivityFlash.this), Integer.valueOf(i));
        }
    }

    public void subtitlesLoaded(String s)
    {
        Log.d("VideoPlayerActivityFlash", (new StringBuilder()).append("VideoPlayerActivityFlash:").append(s).toString());
    }

    public void updatePlayerPosition(String s)
    {
        Log.d("VideoPlayerActivityFlash", (new StringBuilder()).append("updatePlayerPosition: ").append(s).toString());
        if ((int)Math.round(Double.parseDouble(s)) > 0 && !VideoPlayerActivityFlash.access$900(VideoPlayerActivityFlash.this))
        {
            VideoPlayerActivityFlash.access$902(VideoPlayerActivityFlash.this, true);
            VideoPlayerActivityFlash.access$100(VideoPlayerActivityFlash.this).loadUrl((new StringBuilder()).append("javascript:loadSubtitles('").append(VideoPlayerActivityFlash.access$400(VideoPlayerActivityFlash.this)).append("')").toString());
        }
        int _tmp = VideoPlayerActivityFlash.access$1008(VideoPlayerActivityFlash.this);
    }

    public void videoPlayerEndJavascript()
    {
        SharedPrefsManager.clearPlayProgressForItem(VideoPlayerActivityFlash.access$700(VideoPlayerActivityFlash.this));
        MediaDetailsItem mediadetailsitem = VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem();
        Application.getInstance().getOmnitureTracker().onVideoComplete(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", VideoPlayerActivityFlash.access$300(VideoPlayerActivityFlash.this), mediadetailsitem.getDuration(), VideoPlayerActivityFlash.access$1000(VideoPlayerActivityFlash.this), VideoPlayerActivityFlash.access$1100(VideoPlayerActivityFlash.this));
        finish();
    }

    private _cls1.this._cls1()
    {
        this$0 = VideoPlayerActivityFlash.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

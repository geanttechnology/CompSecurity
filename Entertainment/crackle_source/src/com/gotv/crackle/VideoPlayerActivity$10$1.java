// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import com.gotv.crackle.captions.CaptionWindow;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.SocialOnAPI;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.ComscoreTracker;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.OmnitureWrapper;
import com.nielsen.app.sdk.AppSdk;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity, Application

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (SharedPrefsManager.getSocialOnEnabled() && CrackleAccountManager.isLoggedIn() && VideoPlayerActivity.access$3600(_fld0) != null)
        {
            String s = CrackleAccountManager.getUserID();
            VideoPlayerActivity.access$3800(_fld0).publishWatchedhMediaItem(_fld0, s, VideoPlayerActivity.access$3700(_fld0));
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$10

/* anonymous class */
    class VideoPlayerActivity._cls10
        implements com.gotv.crackle.views.MediaControllerView.ControllerListener
    {

        final VideoPlayerActivity this$0;

        public void doToggleFullscreen()
        {
            Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("doToggleFullScreen").toString());
        }

        public void onAboutToSeekTo(int i)
        {
            if (!VideoPlayerActivity.access$1600(VideoPlayerActivity.this))
            {
                VideoPlayerActivity.access$1700(VideoPlayerActivity.this, i, false);
            }
            if (VideoPlayerActivity.access$1800(VideoPlayerActivity.this) != null)
            {
                VideoPlayerActivity.access$1800(VideoPlayerActivity.this).trackPause();
            }
        }

        public void onBuffer()
        {
            if (VideoPlayerActivity.access$1800(VideoPlayerActivity.this) != null)
            {
                if (getCurrentPosition() != 0)
                {
                    VideoPlayerActivity.access$1800(VideoPlayerActivity.this).setTimeRecentlyObserved(getCurrentPosition());
                }
                VideoPlayerActivity.access$1800(VideoPlayerActivity.this).trackBuffer();
            }
        }

        public void onBufferTooLong()
        {
            VideoPlayerActivity.access$4400(VideoPlayerActivity.this);
        }

        public void onPrepared()
        {
            Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("onPrepared").toString());
            if (mLowBandwidthDialog != null)
            {
                mLowBandwidthDialog.dismiss();
            }
        }

        public void onSeekDragging()
        {
            mHideHandler.removeCallbacks(mHideRunnable);
        }

        public boolean onSeekTo(int i)
        {
            Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("onSeekTo : ").append(i).toString());
            i /= 1000;
            if ((double)i > (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) * 0.25D)
            {
                VideoPlayerActivity.access$2002(VideoPlayerActivity.this, true);
            }
            if ((double)i > (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) * 0.5D)
            {
                VideoPlayerActivity.access$2102(VideoPlayerActivity.this, true);
            }
            if ((double)i > (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) * 0.75D)
            {
                VideoPlayerActivity.access$2202(VideoPlayerActivity.this, true);
            }
            if ((double)i > (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) * 0.94999999999999996D)
            {
                VideoPlayerActivity.access$2302(VideoPlayerActivity.this, true);
            }
            return false;
        }

        public void onStopBuffering()
        {
        }

        public void onStopDragging()
        {
            VideoPlayerActivity.access$1200(VideoPlayerActivity.this, 6000);
        }

        public void onVideoPlaybackPaused()
        {
            Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("onVideoPlaybackPaused").toString());
            if (VideoPlayerActivity.access$1800(VideoPlayerActivity.this) != null)
            {
                if (getCurrentPosition() != 0)
                {
                    VideoPlayerActivity.access$1800(VideoPlayerActivity.this).setTimeRecentlyObserved(getCurrentPosition());
                }
                VideoPlayerActivity.access$1800(VideoPlayerActivity.this).trackPause();
            }
            if (VideoPlayerActivity.access$4000() != null)
            {
                VideoPlayerActivity.access$4100().stop();
            }
        }

        public void onVideoPlaybackStarted()
        {
            Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("onVideoPlaybackStarted").toString());
            if (VideoPlayerActivity.access$1800(VideoPlayerActivity.this) != null)
            {
                VideoPlayerActivity.access$1800(VideoPlayerActivity.this).setTimeRecentlyObserved(getCurrentPosition());
                VideoPlayerActivity.access$1800(VideoPlayerActivity.this).setClipToMediaItem();
            }
            if (VideoPlayerActivity.access$2400() != null)
            {
                VideoPlayerActivity.access$2600().play(VideoPlayerActivity.access$2500(VideoPlayerActivity.this));
                VideoPlayerActivity.access$2800().loadMetadata(VideoPlayerActivity.access$2700(VideoPlayerActivity.this));
            }
            if (VideoPlayerActivity.mConvivaSessionID >= 0);
            if (VideoPlayerActivity.access$2900(VideoPlayerActivity.this))
            {
                MediaDetailsItem mediadetailsitem = VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem();
                VideoPlayerActivity.access$3102(VideoPlayerActivity.this, Application.getInstance().getOmnitureTracker().onVideoStart(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", VideoPlayerActivity.access$3200(VideoPlayerActivity.this), mediadetailsitem.getDuration(), VideoPlayerActivity.access$3300(VideoPlayerActivity.this), VideoPlayerActivity.access$3100(VideoPlayerActivity.this)));
                VideoPlayerActivity.access$2902(VideoPlayerActivity.this, false);
            }
            VideoPlayerActivity.access$3400(VideoPlayerActivity.this).setVisibility(0);
            if (!VideoPlayerActivity.access$3500(VideoPlayerActivity.this))
            {
                VideoPlayerActivity.access$3502(VideoPlayerActivity.this, true);
                VideoPlayerActivity.access$3900(VideoPlayerActivity.this).postDelayed(new VideoPlayerActivity._cls10._cls1(), 10000L);
            }
            if (mLowBandwidthDialog != null)
            {
                mLowBandwidthDialog.dismiss();
            }
        }

        public void onVideoPlaybackStopped()
        {
            Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("onVideoPlaybackStopped").toString());
            if (VideoPlayerActivity.access$4200() != null)
            {
                VideoPlayerActivity.access$4300().stop();
            }
        }

        public void onVisibilityChanged(boolean flag)
        {
            Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("onVisibilityChanged").toString());
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)VideoPlayerActivity.access$1500(VideoPlayerActivity.this).getLayoutParams();
            if (flag)
            {
                layoutparams.setMargins(0, 0, 0, Application.getDisplayIndependantPixelSize(60));
            } else
            {
                layoutparams.setMargins(0, 0, 0, Application.getDisplayIndependantPixelSize(10));
            }
            VideoPlayerActivity.access$1500(VideoPlayerActivity.this).setLayoutParams(layoutparams);
        }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
    }

}

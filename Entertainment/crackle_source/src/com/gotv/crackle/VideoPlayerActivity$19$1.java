// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.drm.DrmErrorEvent;
import android.drm.DrmEvent;
import android.drm.DrmManagerClient;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.ComscoreTracker;
import com.gotv.crackle.util.Log;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity, Application, WidevineDrm

class this._cls1
    implements android.view._cls9._cls1
{

    final anguageDialog this$1;

    public void onClick(View view)
    {
        showLanguageDialog();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$19

/* anonymous class */
    class VideoPlayerActivity._cls19
        implements Runnable
    {

        final VideoPlayerActivity this$0;

        public void run()
        {
            MediaDetailsItem mediadetailsitem = VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem();
            Log.v(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("onDataSuccess").toString());
            Object obj;
            if (mediadetailsitem.getRootChannelID().compareTo("82") == 0)
            {
                BaseActivity.mJustPlayedMovie = true;
            } else
            {
                BaseActivity.mJustPlayedShow = true;
            }
            VideoPlayerActivity.access$5802(VideoPlayerActivity.this, mediadetailsitem.getThumbnailOneSheet185x277());
            Exception exception;
            try
            {
                VideoPlayerActivity.access$1902(VideoPlayerActivity.this, Integer.parseInt(mediadetailsitem.getDurationInSeconds()));
            }
            catch (Exception exception1) { }
            VideoPlayerActivity.access$5902(VideoPlayerActivity.this, mediadetailsitem.getAmazonLink());
            if (VideoPlayerActivity.access$6000(VideoPlayerActivity.this) != null)
            {
                if (VideoPlayerActivity.access$5900(VideoPlayerActivity.this) == null || VideoPlayerActivity.access$5900(VideoPlayerActivity.this).isEmpty() || VideoPlayerActivity.access$5900(VideoPlayerActivity.this).equalsIgnoreCase("null") || Application.getInstance().getLocalization().isLatinAmericaUI() || Application.isNookTablet() || Application.isLeanBack())
                {
                    VideoPlayerActivity.access$6000(VideoPlayerActivity.this).setVisible(false);
                } else
                {
                    VideoPlayerActivity.access$6000(VideoPlayerActivity.this).setVisible(true);
                }
            }
            obj = (ImageButton)findViewById(0x7f0a010f);
            if (!Application.isLeanBack() && (mediadetailsitem.getClosedCaptionFiles().size() > 0 || VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem().IsDubbed()))
            {
                ((ImageButton) (obj)).setVisibility(0);
                ((ImageButton) (obj)).setOnClickListener(new VideoPlayerActivity._cls19._cls1());
                String s = SharedPrefsManager.getLastSubtitles();
                obj = s;
                if (TextUtils.isEmpty(s))
                {
                    obj = mediadetailsitem.getDefaultLang();
                }
                if (obj != null)
                {
                    VideoPlayerActivity.access$3202(VideoPlayerActivity.this, ((String) (obj)));
                    VideoPlayerActivity.access$6102(VideoPlayerActivity.this, (List)VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem().getClosedCaptionFiles().get(obj));
                }
            } else
            {
                ((ImageButton) (obj)).setVisibility(8);
            }
            VideoPlayerActivity.access$3000(VideoPlayerActivity.this).setCurrentLanguage(mediadetailsitem.getLocalizedLanguage());
            if (!setMediaUrlAndReturnIfDRM(mediadetailsitem, mediadetailsitem.getMediaUrls())) goto _L2; else goto _L1
_L1:
            if (VideoPlayerActivity.access$100(VideoPlayerActivity.this) == null)
            {
                try
                {
                    Uri.parse(VideoPlayerActivity.access$100(VideoPlayerActivity.this));
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    Log.d("Crackle Stoped", "URL not Found");
                    Toast.makeText(getBaseContext(), "Can not open this video. Video not found.", 1).show();
                    finish();
                    return;
                }
            }
            VideoPlayerActivity.access$6300(VideoPlayerActivity.this).setOnEventListener(new VideoPlayerActivity._cls19._cls2());
            VideoPlayerActivity.access$6300(VideoPlayerActivity.this).setOnErrorListener(new VideoPlayerActivity._cls19._cls3());
            VideoPlayerActivity.access$6300(VideoPlayerActivity.this).acquireRights(VideoPlayerActivity.access$100(VideoPlayerActivity.this));
_L4:
            VideoPlayerActivity.access$1802(VideoPlayerActivity.this, new ComscoreTracker(mediadetailsitem, VideoPlayerActivity.access$100(VideoPlayerActivity.this), VideoPlayerActivity.access$700(VideoPlayerActivity.this)));
            if (!SharedPrefsManager.getIsParentalLockEnabled(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_MATURE_CONTENT) && !SharedPrefsManager.getIsParentalLockEnabled(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_ALL_CONTENT))
            {
                VideoPlayerActivity.access$6400(VideoPlayerActivity.this, mediadetailsitem);
            }
            return;
_L2:
            if (VideoPlayerActivity.access$100(VideoPlayerActivity.this) == null)
            {
                try
                {
                    Uri.parse(VideoPlayerActivity.access$100(VideoPlayerActivity.this));
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    Log.d("Crackle Stoped", "URL not Found");
                    Toast.makeText(getBaseContext(), "Can not open this video. Video not found.", 1).show();
                    finish();
                    return;
                }
            }
            VideoPlayerActivity.access$6200(VideoPlayerActivity.this);
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }

        // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$19$2

/* anonymous class */
        class VideoPlayerActivity._cls19._cls2
            implements android.drm.DrmManagerClient.OnEventListener
        {

            final VideoPlayerActivity._cls19 this$1;

            public void onEvent(DrmManagerClient drmmanagerclient, DrmEvent drmevent)
            {
                switch (drmevent.getType())
                {
                default:
                    return;

                case 1002: 
                    VideoPlayerActivity.access$6200(this$0);
                    break;
                }
            }

                    
                    {
                        this$1 = VideoPlayerActivity._cls19.this;
                        super();
                    }
        }


        // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$19$3

/* anonymous class */
        class VideoPlayerActivity._cls19._cls3
            implements android.drm.DrmManagerClient.OnErrorListener
        {

            final VideoPlayerActivity._cls19 this$1;

            public void onError(DrmManagerClient drmmanagerclient, DrmErrorEvent drmerrorevent)
            {
                runOnUiThread(new VideoPlayerActivity._cls19._cls3._cls1());
            }

                    
                    {
                        this$1 = VideoPlayerActivity._cls19.this;
                        super();
                    }
        }


        // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$19$3$1

/* anonymous class */
        class VideoPlayerActivity._cls19._cls3._cls1
            implements Runnable
        {

            final VideoPlayerActivity._cls19._cls3 this$2;

            public void run()
            {
                mVideoErrorDialog.show();
            }

                    
                    {
                        this$2 = VideoPlayerActivity._cls19._cls3.this;
                        super();
                    }
        }

    }

}

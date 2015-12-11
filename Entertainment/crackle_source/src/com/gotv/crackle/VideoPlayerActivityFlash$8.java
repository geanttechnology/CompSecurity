// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.MediaUrlItem;
import java.util.Map;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivityFlash

class this._cls0
    implements Runnable
{

    final VideoPlayerActivityFlash this$0;

    public void run()
    {
        MediaDetailsItem mediadetailsitem = VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem();
        float f;
        String s;
        String s1;
        int i;
        int j;
        if (mediadetailsitem.getRootChannelID().compareTo("82") == 0)
        {
            BaseActivity.mJustPlayedMovie = true;
        } else
        {
            BaseActivity.mJustPlayedShow = true;
        }
        if (mediadetailsitem.getClosedCaptionFiles().size() > 0)
        {
            VideoPlayerActivityFlash.access$1402(VideoPlayerActivityFlash.this, true);
            if (mediadetailsitem.getDefaultLang() != null)
            {
                VideoPlayerActivityFlash.access$302(VideoPlayerActivityFlash.this, mediadetailsitem.getDefaultLang());
                VideoPlayerActivityFlash.access$402(VideoPlayerActivityFlash.this, (String)VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem().getClosedCaptionFileUrls().get(mediadetailsitem.getDefaultLang()));
            }
        }
        VideoPlayerActivityFlash.access$1502(VideoPlayerActivityFlash.this, mediadetailsitem.getDimensions());
        s = VideoPlayerActivityFlash.access$1500(VideoPlayerActivityFlash.this).substring(0, VideoPlayerActivityFlash.access$1500(VideoPlayerActivityFlash.this).indexOf("x"));
        s1 = VideoPlayerActivityFlash.access$1500(VideoPlayerActivityFlash.this).substring(VideoPlayerActivityFlash.access$1500(VideoPlayerActivityFlash.this).indexOf("x") + 1, VideoPlayerActivityFlash.access$1500(VideoPlayerActivityFlash.this).length());
        j = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        i = getWindow().getWindowManager().getDefaultDisplay().getHeight();
        f = getResources().getDisplayMetrics().density;
        j = (new Float((float)j / f)).intValue();
        i = (new Float((float)i / f)).intValue();
        f = Float.parseFloat(s1) / Float.parseFloat(s);
        VideoPlayerActivityFlash.access$1602(VideoPlayerActivityFlash.this, (new Float((float)j * f)).intValue());
        VideoPlayerActivityFlash.access$1702(VideoPlayerActivityFlash.this, j);
        if (VideoPlayerActivityFlash.access$1600(VideoPlayerActivityFlash.this) > i)
        {
            VideoPlayerActivityFlash.access$1602(VideoPlayerActivityFlash.this, i);
            float f1 = Float.parseFloat(s) / Float.parseFloat(s1);
            VideoPlayerActivityFlash.access$1702(VideoPlayerActivityFlash.this, (new Float((float)i * f1)).intValue());
        }
        VideoPlayerActivityFlash.access$1302(VideoPlayerActivityFlash.this, mediadetailsitem.getThumbnailOneSheet185x277());
        try
        {
            VideoPlayerActivityFlash.access$1202(VideoPlayerActivityFlash.this, Integer.parseInt(mediadetailsitem.getDurationInSeconds()));
        }
        catch (Exception exception) { }
        VideoPlayerActivityFlash.access$802(VideoPlayerActivityFlash.this, mediadetailsitem.getAmazonLink());
        VideoPlayerActivityFlash.access$1502(VideoPlayerActivityFlash.this, mediadetailsitem.getDimensions());
        VideoPlayerActivityFlash.access$1802(VideoPlayerActivityFlash.this, ((MediaUrlItem)VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem().getMediaUrls().get("H264_Android.smil")).path);
        if (SharedPrefsManager.getPlayProgressForItem(VideoPlayerActivityFlash.access$700(VideoPlayerActivityFlash.this)) > 0)
        {
            if (VideoPlayerActivityFlash.access$1900(VideoPlayerActivityFlash.this) == null)
            {
                showDialog(1);
                return;
            }
            if (VideoPlayerActivityFlash.access$1900(VideoPlayerActivityFlash.this).booleanValue())
            {
                VideoPlayerActivityFlash.access$602(VideoPlayerActivityFlash.this, SharedPrefsManager.getPlayProgressForItem(VideoPlayerActivityFlash.access$700(VideoPlayerActivityFlash.this)));
                VideoPlayerActivityFlash.access$500(VideoPlayerActivityFlash.this);
                return;
            } else
            {
                VideoPlayerActivityFlash.access$500(VideoPlayerActivityFlash.this);
                return;
            }
        } else
        {
            VideoPlayerActivityFlash.access$500(VideoPlayerActivityFlash.this);
            return;
        }
    }

    ()
    {
        this$0 = VideoPlayerActivityFlash.this;
        super();
    }
}

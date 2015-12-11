// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoAdView, VideoRenderer

class this._cls0
    implements android.media.ErrorListener
{

    final VideoAdView this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        VideoAdView.access$000(VideoAdView.this).debug((new StringBuilder()).append("onError: ").append(i).append(",").append(j).toString());
        VideoAdView.access$102(VideoAdView.this, -1);
        VideoAdView.access$202(VideoAdView.this, -1);
        if (VideoAdView.access$300(VideoAdView.this) != null)
        {
            VideoAdView.access$300(VideoAdView.this).hide();
        }
        Bundle bundle = new Bundle();
        if (i == 200)
        {
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_UNKNOWN());
            mediaplayer = "The video is streamed and its container is not valid for progressive playback i.e the video's index (e.g moov atom) is not at the start of the file.";
        } else
        if (i == 1)
        {
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_UNKNOWN());
            mediaplayer = "media file format is not recognized.";
        } else
        if (i == 100)
        {
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_IO());
            mediaplayer = "media server has gone away.";
        } else
        {
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_IO());
            mediaplayer = "unknown common IO error.";
        }
        bundle.putString(constants.INFO_KEY_ERROR_INFO(), mediaplayer);
        VideoAdView.access$400(VideoAdView.this).onAdVideoViewError(bundle);
        return true;
    }

    ()
    {
        this$0 = VideoAdView.this;
        super();
    }
}

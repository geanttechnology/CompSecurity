// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import android.net.Uri;
import android.widget.VideoView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

class val.video
    implements com.amazon.gallery.framework.network.andler
{

    final VideoTrimmerActivity this$0;
    final Video val$video;
    final VideoView val$videoView;

    public void onFailure(TerminalException terminalexception)
    {
        val$videoView.post(new Runnable() {

            final VideoTrimmerActivity._cls6 this$1;

            public void run()
            {
                if (video.getType() == MediaType.VIDEO && video.getDuration() >= TimeUnit.MINUTES.toMillis(20L))
                {
                    GLogger.i(VideoTrimmerActivity.access$1800(), "Failed to load video URL from Cloud Drive because video duration > 20 minutes", new Object[0]);
                    return;
                } else
                {
                    GLogger.i(VideoTrimmerActivity.access$1800(), "Failed to load video URL from Cloud Drive", new Object[0]);
                    return;
                }
            }

            
            {
                this$1 = VideoTrimmerActivity._cls6.this;
                super();
            }
        });
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((String)obj);
    }

    public void onSuccess(final String url)
    {
        val$videoView.post(new Runnable() {

            final VideoTrimmerActivity._cls6 this$1;
            final String val$url;

            public void run()
            {
                videoView.setVideoURI(Uri.parse(url));
                videoView.start();
            }

            
            {
                this$1 = VideoTrimmerActivity._cls6.this;
                url = s;
                super();
            }
        });
    }

    _cls2.this._cls1()
    {
        this$0 = final_videotrimmeractivity;
        val$videoView = videoview;
        val$video = Video.this;
        super();
    }
}

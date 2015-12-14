// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import com.amazon.gallery.framework.gallery.video.GalleryVideoView;
import com.google.common.base.Optional;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

class this._cls0
    implements Runnable
{

    final VideoTrimmerActivity this$0;

    public void run()
    {
label0:
        {
            if (VideoTrimmerActivity.access$1000(VideoTrimmerActivity.this) != null)
            {
                VideoTrimmerActivity.access$1102(VideoTrimmerActivity.this, true);
                VideoTrimmerActivity.access$1202(VideoTrimmerActivity.this, Optional.of(Integer.valueOf(VideoTrimmerActivity.access$1000(VideoTrimmerActivity.this).getCurrentPosition())));
                if (!VideoTrimmerActivity.access$1300(VideoTrimmerActivity.this))
                {
                    break label0;
                }
                VideoTrimmerActivity.access$1000(VideoTrimmerActivity.this).seekTo(VideoTrimmerActivity.access$1400(VideoTrimmerActivity.this));
            }
            return;
        }
        VideoTrimmerActivity.access$1000(VideoTrimmerActivity.this).seekTo(VideoTrimmerActivity.access$1500(VideoTrimmerActivity.this));
    }

    View()
    {
        this$0 = VideoTrimmerActivity.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.amazon.gallery.thor.app.service.VideoTranscodeService;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

class this._cls0
    implements ServiceConnection
{

    final VideoTrimmerActivity this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = (com.amazon.gallery.thor.app.service.ocalBinder)ibinder;
        VideoTrimmerActivity.access$502(VideoTrimmerActivity.this, componentname.getService());
        VideoTrimmerActivity.access$500(VideoTrimmerActivity.this).addOnUpdateListener(VideoTrimmerActivity.this);
        if (VideoTrimmerActivity.access$600(VideoTrimmerActivity.this))
        {
            VideoTrimmerActivity.access$300(VideoTrimmerActivity.this);
        }
        if (VideoTrimmerActivity.access$700(VideoTrimmerActivity.this))
        {
            VideoTrimmerActivity.access$800(VideoTrimmerActivity.this, true);
        }
        VideoTrimmerActivity.access$902(VideoTrimmerActivity.this, true);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        if (VideoTrimmerActivity.access$900(VideoTrimmerActivity.this))
        {
            VideoTrimmerActivity.access$500(VideoTrimmerActivity.this).removeOnUpdateListener(VideoTrimmerActivity.this);
            VideoTrimmerActivity.access$902(VideoTrimmerActivity.this, false);
        }
    }

    ce()
    {
        this$0 = VideoTrimmerActivity.this;
        super();
    }
}

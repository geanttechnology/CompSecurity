// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            VideoTranscodeService

class val.output
    implements Runnable
{

    final VideoTranscodeService this$0;
    final String val$id;
    final File val$output;

    public void run()
    {
        VideoTranscodeService.access$1800(VideoTranscodeService.this, val$id, rkState.COMPLETED);
        for (Iterator iterator = VideoTranscodeService.access$1900(VideoTranscodeService.this).iterator(); iterator.hasNext(); ((UpdateListener)iterator.next()).onVideoTranscodeCompleted(val$id, val$output)) { }
    }

    UpdateListener()
    {
        this$0 = final_videotranscodeservice;
        val$id = s;
        val$output = File.this;
        super();
    }
}

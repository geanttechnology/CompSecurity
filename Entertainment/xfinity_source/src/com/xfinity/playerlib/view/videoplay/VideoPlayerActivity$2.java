// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerActivity

class this._cls0
    implements OrientationStrategy
{

    final VideoPlayerActivity this$0;

    public int getAppropriateOrientation()
    {
        return VideoPlayerActivity.access$100(VideoPlayerActivity.this).getLandscapeOrientation();
    }

    ()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}

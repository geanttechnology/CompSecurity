// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.video;

import android.view.View;

// Referenced classes of package com.rhythmnewmedia.sdk.video:
//            RhythmVideoView

public interface ClipBrowserDataSource
{

    public abstract String getChannelName(RhythmVideoView rhythmvideoview, int i);

    public abstract View getDefaultThumbnail(RhythmVideoView rhythmvideoview);

    public abstract View getDetailView(RhythmVideoView rhythmvideoview, int i, int j);

    public abstract View getVideoThumbnail(RhythmVideoView rhythmvideoview, int i, int j);
}
